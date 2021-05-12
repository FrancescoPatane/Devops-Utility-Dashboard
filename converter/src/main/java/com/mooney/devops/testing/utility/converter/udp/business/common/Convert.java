package com.mooney.devops.testing.utility.converter.udp.business.common;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author spinellilu
 */
public class Convert {

	private Convert() {
	}

	/**
	 *
	 */
	public static final int BIG_ENDIAN = 0;

	/**
	 *
	 */
	public static final int LITTLE_ENDIAN = 1;

	/**
	 *
	 * @param shortToConvert
	 * @return
	 */
	public static byte shortToByte(short shortToConvert) {
		return (byte) shortToConvert;
	}

	/**
	 *
	 * @param byteToConvert
	 * @return
	 */
	public static short byteToShort(byte byteToConvert) {
		return (short) (byteToConvert & 0xff);
	}

	/**
	 *
	 * @param byteArrayToConvert
	 * @return
	 */
	public static short byteToShort(byte[] byteArrayToConvert) {
		return byteToShort(byteArrayToConvert, 0, byteArrayToConvert.length);
	}

	/**
	 *
	 * @param byteArrayToConvert
	 * @param offset
	 * @param length
	 * @return
	 */
	public static short byteToShort(byte[] byteArrayToConvert, int offset, int length) {
		return byteToShort(byteArrayToConvert, offset, length, LITTLE_ENDIAN);
	}

	/**
	 *
	 * @param byteArrayToConvert
	 * @param encoding
	 * @return
	 */
	public static short byteToShort(byte[] byteArrayToConvert, int encoding) {
		return byteToShort(byteArrayToConvert, 0, byteArrayToConvert.length, encoding);
	}

	/**
	 *
	 * @param byteArrayToConvert
	 * @param offset
	 * @param length
	 * @param encoding
	 * @return
	 */
	public static short byteToShort(byte[] byteArrayToConvert, int offset, int length, int encoding) {
		short res = 0;
		int nTrasl;
		int delta;
		if (length <= Short.SIZE) {
			switch (encoding) {
			case BIG_ENDIAN:
				delta = -1;
				nTrasl = length - 1;
				break;
			case LITTLE_ENDIAN:
				nTrasl = 0;
				delta = 1;
				break;
			default:
				nTrasl = 0;
				delta = 1;
				break;
			}
			for (int i = offset; i < offset + length; i++) {
				res += (byteToShort(byteArrayToConvert[i]) << (8 * nTrasl));
				nTrasl += delta;
			}
			return res;
		}
		return -1;
	}

	/**
	 *
	 * @param byteArrayToConvert
	 * @param offset
	 * @param length
	 * @param encoding
	 * @return
	 */
	public static int byteToInt(byte[] byteArrayToConvert, int offset, int length, int encoding) {
		int res = 0;
		int nTrasl;
		int delta;
		if (length <= Integer.SIZE) {
			switch (encoding) {
			case BIG_ENDIAN:
				delta = -1;
				nTrasl = length - 1;
				break;
			case LITTLE_ENDIAN:
				nTrasl = 0;
				delta = 1;
				break;
			default:
				nTrasl = 0;
				delta = 1;
				break;
			}
			for (int i = offset; i < offset + length; i++) {
				res += (byteToInt(byteArrayToConvert[i]) << (8 * nTrasl));
				nTrasl += delta;
			}
			return res;
		}
		return -1;
	}

	/**
	 *
	 * @param byteToConvert
	 * @return
	 */
	public static int byteToInt(byte byteToConvert) {
		return (int) byteToConvert & 0xff;
	}

	/**
	 *
	 * @param byteArrayToConvert
	 * @return
	 */
	public static int byteToInt(byte[] byteArrayToConvert) {
		return byteToInt(byteArrayToConvert, 0, byteArrayToConvert.length);
	}

	/**
	 *
	 * @param byteArrayToConvert
	 * @param offset
	 * @param length
	 * @return
	 */
	public static int byteToInt(byte[] byteArrayToConvert, int offset, int length) {
		return byteToInt(byteArrayToConvert, offset, length, LITTLE_ENDIAN);
	}

	/**
	 *
	 * @param byteToConvert
	 * @return
	 */
	public static long byteToLong(byte byteToConvert) {
		return (long) byteToConvert & 0xff;
	}

	/**
	 *
	 * @param byteArrayToConvert
	 * @param offset
	 * @param length
	 * @param encoding
	 * @return
	 */
	public static long byteToLong(byte[] byteArrayToConvert, int offset, int length, int encoding) {
		long res = 0L;
		int nTrasl;
		int delta;

		if (length <= Long.SIZE) {
			switch (encoding) {
			case BIG_ENDIAN:
				delta = -1;
				nTrasl = length - 1;
				break;
			case LITTLE_ENDIAN:
				nTrasl = 0;
				delta = 1;
				break;
			default:
				nTrasl = 0;
				delta = 1;
				break;
			}

			for (int i = offset; i < offset + length; i++) {
				res += (byteToLong(byteArrayToConvert[i]) << (8 * nTrasl));
				nTrasl += delta;
			}
			return res;
		}
		return -1;
	}

	/**
	 *
	 * @param byteToConvert
	 * @return
	 */
	public static char byteToChar(byte byteToConvert) {

		return (char) byteToConvert;
	}

	/**
	 *
	 * @param longToConvert
	 * @param length
	 * @return
	 */
	public static byte[] numberToByteArray(long longToConvert, int length) {
		byte[] res = new byte[length];
		if (longToConvert <= Long.MAX_VALUE) {
			for (int i = 0; i < length; i++) {
				res[i] = (byte) ((longToConvert >> (i * 8)) & 0xff);
			}
		}
		return res;
	}

	/**
	 *
	 * @param longToConvert
	 * @param length
	 * @param encoding
	 * @return
	 */
	public static byte[] numberToByteArray(long longToConvert, int length, int encoding) {
		byte[] res = new byte[length];
		int nTrasl;
		int delta;

		if (longToConvert <= Long.MAX_VALUE) {
			switch (encoding) {
			case BIG_ENDIAN:
				delta = -1;
				nTrasl = length - 1;
				break;
			case LITTLE_ENDIAN:
				nTrasl = 0;
				delta = 1;
				break;
			default:
				nTrasl = 0;
				delta = 1;
				break;
			}

			for (int i = 0; i < length; i++) {
				res[i] = (byte) ((longToConvert >> (nTrasl * 8)) & 0xff);
				nTrasl += delta;
			}
		}
		return res;
	}

	/**
	 *
	 * @param stringToConvert
	 * @param length
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static byte[] stringToByte(String stringToConvert, int length) throws UnsupportedEncodingException {
		byte[] res = new byte[length];
		byte[] tmp = stringToConvert.getBytes("iso-8859-1");
		System.arraycopy(tmp, 0, res, 0, tmp.length);
		return res;
	}

	/**
	 *
	 * @param byteArrayToConvert
	 * @return
	 */
	public static String byteToString(byte[] byteArrayToConvert) {
		String retVal = new String(byteArrayToConvert);
		return retVal.trim();
	}

}
