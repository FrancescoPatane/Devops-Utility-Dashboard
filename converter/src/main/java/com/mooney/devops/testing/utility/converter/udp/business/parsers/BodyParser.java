package com.mooney.devops.testing.utility.converter.udp.business.parsers;

import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mooney.devops.testing.utility.converter.udp.business.common.Convert;
import com.mooney.devops.testing.utility.converter.udp.business.common.Position;
import com.mooney.devops.testing.utility.converter.udp.business.exception.RuntimeParserException;
import com.vipera.sisal.retefisica.common.business.interfaces.IParsableObject;

/**
 * Classe astratta, root della gerarchia dei body parser.
 *
 * @author Luigi
 * @version 1.0
 * @created 16-giu-2008 10.25.24
 */
public abstract class BodyParser implements BodyParserInterface {
	private static final Logger logger = LoggerFactory.getLogger(BodyParser.class);

	/**
	 * Ritorna l'offset del buffer gestito direttamente dal parser specifico, viene utilizzato quando non e' possibile inserire il valore offeset nelle annotation.
	 *
	 * @param f
	 *            - Oggetto Field che identifica l'attributo
	 * @param obj
	 *            - Oggetto che contiene l'attributo in input
	 *
	 * @return offset dell'attributo passato come input
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws com.vipera.sisal.retefisica.decoupler.business.exception.RuntimeParserException
	 */
	public int getOffset(Field f, Object obj) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, RuntimeParserException {
		Position ann = f.getAnnotation(Position.class);
		if (ann.offset() != -1) {
			return ann.offset();
		}
		String field = ann.relField();
		Field rf = null;
		rf = obj.getClass().getDeclaredField(field);
		return getOffset(rf, obj) + getLength(rf, obj);
	}

	/**
	 *
	 * @param f
	 * @param obj
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws RuntimeParserException
	 */
	public int getLength(Field f, Object obj) throws IllegalArgumentException, IllegalAccessException, RuntimeParserException {
		Position ann = f.getAnnotation(Position.class);
		return ann.length();
	}

	/**
	 * Restituisce la lunghezza del body. L'implementazione dipende dall'instanza di parser specifica.
	 *
	 * @return lunghezza del body
	 */
	// protected abstract int getBodyLength();

	/**
	 * Quando la logica generale di parsing incontra una classe non gestita invoca il metodo per una corretta gestione
	 *
	 * @param buf
	 *            - array di byte
	 * @param cls
	 *            - classe dell'oggetto in cui trasformare l'array di byte, cioe' il tipo del campo che si analizza
	 * @param fName
	 *            - nome del campo che si analizza
	 * @param obj
	 *            - Oggetto di cui si sta facendo il parsing
	 * @return object che dipende dall'implementazione
	 * @throws RuntimeParserException
	 */
	protected abstract Object getParam(byte[] buf, Class cls, String fName, IParsableObject obj) throws RuntimeParserException;

	/**
	 * Quando la logica generale di formatting incontra una classe non gestita invoca il metodo per una corretta gestione
	 *
	 * @param result
	 *            - il valore del campo che si deve trasformare in array di byte
	 * @param cls
	 *            - classe dell'oggetto da trasformare in array di byte, cioe' il tipo del campo che si analizza
	 * @param fName
	 *            - nome del campo che si analizza
	 * @return array di byte la cui codifica dipende dall'implementazione dallo specifico parser
	 * @throws RuntimeParserException
	 */
	protected abstract byte[] getBytes(Object result, Class cls, String fName) throws RuntimeParserException;

	/**
	 * Metodo che definisce l'oggetto che il metodo di parsing restituisce che dipende dall'implementazione dello specifico parser
	 *
	 * @return oggetto in cui trasformare l'arrey di byte di cui si effettua il parsing.
	 */
	public abstract IParsableObject getObject();

	/**
	 * Ricava i byte del msg a partire da un offset, per una data lunghezza (num. di byte)
	 *
	 * @param buf
	 *            - array di byte
	 * @param offset
	 *            - offset da cui partire per leggere il campo
	 * @param count
	 *            - numero di byte da leggere
	 * @return bytes relativi al campo estratto
	 */
	protected byte[] getBodyField(byte[] buf, int offset, int count) {
		byte[] ret = null;
		int len = (count == 0 ? (buf.length - offset) : count);
		ret = new byte[len];
		logger.debug("BodyParser->getBodyField - offset:{} - count:{} - len:{} - buf.length:{}", new Object[] { offset, count,len, buf.length });
		System.arraycopy(buf, offset, ret, 0, len);
		return ret;
	}

	private IParsableObject internalParser(byte[] h, Class cls, IParsableObject obj) throws RuntimeParserException {
		Class padre = cls.getSuperclass();

		if (padre != null) {
			obj = this.internalParser(h, padre, obj);
		} else {
			return obj;
		}

		// getLog().debug("BodyParser->internalParser " + cls.getName());
		byte[] field = null;
		Class[] typeParms = new Class[1];

		// getLog().debug("BodyParser->internalParser Inizio Introspection per i
		// campi ");
		for (Field f : cls.getDeclaredFields()) {

			Annotation[] fieldAnnotations = f.getAnnotations();

			for (Annotation annotation : fieldAnnotations) {
				if (annotation instanceof Position) {
					Position ann = (Position) annotation;
					try {
						logger.debug("BodyParser->internalParser - Name:{} - getOffset:{} - getLength:{}", new Object[] { f.getName(), getOffset(f, obj), ann.length() });
						field = this.getBodyField(h, getOffset(f, obj), ann.length());
					} catch (SecurityException | NoSuchFieldException | IllegalArgumentException | IllegalAccessException e1) {
						logger.error(e1.getMessage(), e1);
						throw new RuntimeParserException(e1);
					}

					String s = "set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);

					typeParms[0] = f.getType();

					try {
						Method mt = cls.getMethod(s, typeParms);
						Object[] params = new Object[1];
						if (int.class == f.getType()) {
							params[0] = Convert.byteToInt(field, 0, field.length, ann.encoding());
						} else if (short.class == f.getType()) {
							params[0] = Convert.byteToShort(field, ann.encoding());
						} else if (short[].class == f.getType()) {
							short[] arr = new short[field.length];
							for (int i = 0; i < arr.length; i++) {
								arr[i] = Convert.byteToShort(field[i]);
							}
							params[0] = arr;
						} else if (byte.class == f.getType()) {
							params[0] = field[0];
						} else if (byte[].class == f.getType()) {
							params[0] = field;
						} else if (long.class == f.getType()) {
							params[0] = Convert.byteToLong(field, 0, field.length, ann.encoding());
						} else if (char.class == f.getType()) {
							params[0] = Convert.byteToChar(field[0]);
						} else if (char[].class == f.getType()) {
							char[] vch = new char[field.length];
							for (int i = 0; i < field.length; i++) {
								vch[i] = (char) field[i];
							}
							params[0] = vch;
						} else if (String.class == f.getType()) {
							params[0] = Convert.byteToString(field);
						} else {
							params[0] = getParam(field, f.getType(), f.getName(), obj);
						}
						try {
							logger.debug("BodyParser->internalParser - method:{} - value:{}", s, params[0]);
							mt.invoke(obj, params);
						} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
							logger.error(e.getMessage(), e);
							throw new RuntimeParserException(e);
						}
					} catch (SecurityException | NoSuchMethodException e) {
						logger.error(e.getMessage(), e);
						throw new RuntimeParserException(e);
					}
				}
			}
		}
		return obj;

	}

	@Override
	public IParsableObject parser(byte[] h) throws RuntimeParserException {
		Object obj = getObject();
		logger.debug("BodyParser->parser - parser:{}", obj.getClass().getName());
		IParsableObject ipa = this.internalParser(h, obj.getClass(), (IParsableObject) obj);
		logger.info("BodyParser: "+ipa.getClass());
		return ipa;
	}

	private byte[] internalFormat(Class cls, IParsableObject obj) throws RuntimeParserException, UnsupportedEncodingException {
		byte[] buffer = new byte[obj.getLength()];
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = 0x00;
		}

		logger.debug("BodyParser->internalFormat - buffer.length:{} - CLASSE:{}", buffer.length, cls);

		for (Field f : cls.getDeclaredFields()) {
			Annotation[] fieldAnnotations = f.getAnnotations();
			for (Annotation annotation : fieldAnnotations) {
				if (annotation instanceof Position) {
					Position pos = (Position) annotation;
					String s = "get" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
					logger.debug("BodyParser->internalFormat - parser:{} ", s);
					try {
						Method mt = cls.getMethod(s, null);

						Object result = null;
						byte[] field;
						try {
							result = mt.invoke(obj, null);
						} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
							logger.error(e.getMessage(), e);
							throw new RuntimeParserException(e);
						}
						if (int.class == mt.getReturnType()) {
							int val = ((Integer) result);
							field = Convert.numberToByteArray(val, pos.length(), pos.encoding());
						} else if (short.class == mt.getReturnType()) {
							short val = ((Short) result);
							field = Convert.numberToByteArray(val, pos.length());
						} else if (short[].class == mt.getReturnType()) {
							short[] val = (short[]) result;
							field = new byte[val.length];
							for (int i = 0; i < val.length; i++) {
								field[i] = Convert.shortToByte(val[i]);
							}
						} else if (long.class == mt.getReturnType()) {
							long val = ((Long) result);
							field = Convert.numberToByteArray(val, pos.length(), pos.encoding());
						} else if (byte.class == mt.getReturnType()) {
							field = new byte[1];
							field[0] = (Byte) result;
						} else if (char.class == mt.getReturnType()) {
							Character c = (Character) result;
							field = new byte[1];
							field[0] = (byte) c.charValue();
						} else if (byte[].class == mt.getReturnType()) {
							field = (byte[]) result;
						} else if (char[].class == mt.getReturnType()) {
							field = (byte[]) result;
						} else if (String.class == mt.getReturnType()) {
							if (result != null) {
								field = Convert.stringToByte((String) result, ((String) result).length());
							} else {
								// fix for field null
								field = Convert.stringToByte((String) "", 0);
							}
							String value = new String(field);
							logger.debug("BodyParser->internalFormat - String field:{} - value:{}", f.getName(), value);

						} else {
							field = getBytes(result, mt.getReturnType(), f.getName());
						}
						try {
							logger.debug("BodyParser->internalFormat - buffer.length:{} - field:{} - getOffset:{} - field.length:{}", new Object[] { buffer.length, f.getName(), getOffset(f, obj), field.length });
							System.arraycopy(field, 0, buffer, getOffset(f, obj), field.length);

							/*
							 * StringBuffer bf = new StringBuffer(); for (byte pippo:field){ bf.append(pippo);
							 * 
							 * logger.debug(f.getName()+" -> " + pippo); }
							 */

						} catch (SecurityException | NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
							logger.error(e.getMessage(), e);
							throw new RuntimeParserException(e);
						}
					} catch (SecurityException | NoSuchMethodException e) {
						logger.error(e.getMessage(), e);
						throw new RuntimeParserException(e);
					}

				}
			}
		}
		return buffer;
	}

	@Override
	public byte[] format(IParsableObject body) throws RuntimeParserException, UnsupportedEncodingException {
		return this.internalFormat(body.getClass(), body);

	}

	/**
	 *
	 * @param buf
	 * @return
	 */
	public byte[] getBody(byte[] buf) {
		int offset = 24;
		int count = buf.length - 24;
		byte[] ret = new byte[count];

		for (int i = 0; i < count; i++) {
			ret[i] = buf[offset + i];
		}
		return ret;
	}
}
