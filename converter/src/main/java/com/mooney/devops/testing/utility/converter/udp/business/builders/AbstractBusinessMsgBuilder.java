package com.mooney.devops.testing.utility.converter.udp.business.builders;

import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mooney.devops.testing.utility.converter.udp.business.msg.DefaultMsgHeader;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.BodyParser;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.payments.RCBodyParser_6626;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.payments.RVBodyParser_6342;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.payments.RVBodyParser_6530;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.payments.RVBodyParser_6532;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.payments.RVBodyParser_7542;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.recharges.RCBodyParser_8626;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.recharges.RVBodyParser_7420;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.recharges.RVBodyParser_8422;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.recharges.RVBodyParser_8518;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.reprint.RPBodyParser_6228;


/**
 * This class describes a business message builder that creates specific type of business message objects.
 *
 * See {@code BusinessMsgTypes} for a complete list of business message types .
 *
 *
 * @author Luigi Spinelli
 * @param <T>
 *
 *
 */
public abstract class AbstractBusinessMsgBuilder<T> implements IBusinessMsgBuilder {

	private static final Logger logger = LoggerFactory.getLogger(AbstractBusinessMsgBuilder.class);

	protected final ArrayList<Integer> JSON_MESSAGE = new ArrayList<>(Arrays.asList(6630, 6726, 6631, 6727));

	private T sourceDataObject;

	private int businessMsgCode;

	private BodyParser msgBodyParser = null;

	/**
	 *
	 * @param sourceDataObject
	 */
	public AbstractBusinessMsgBuilder(T sourceDataObject, int businessMsgCode) {
		this.sourceDataObject = sourceDataObject;
		this.businessMsgCode = businessMsgCode;

		getBodyParserFor(businessMsgCode);

	}

	/**
	 *
	 * @param originalMsgHeader
	 * @return
	 */
	public static DefaultMsgHeader swapHeaderFields(DefaultMsgHeader originalMsgHeader) {
		byte senderGEOId = originalMsgHeader.getReceiverGEOId();
		int senderTerminalId = originalMsgHeader.getReceiverTerminalId();
		byte receiverGEOId = originalMsgHeader.getSenderGEOId();
		int receiverTerminalId = originalMsgHeader.getSenderTerminalId();
		byte sessionIdTo = originalMsgHeader.getSessionIdFrom();
		byte sessionIdFrom = originalMsgHeader.getSessionIdTo();

		originalMsgHeader.setSenderGEOId(senderGEOId);
		originalMsgHeader.setSenderTerminalId(senderTerminalId);
		originalMsgHeader.setReceiverGEOId(receiverGEOId);
		originalMsgHeader.setReceiverTerminalId(receiverTerminalId);
		originalMsgHeader.setSessionIdTo(sessionIdTo);
		originalMsgHeader.setSessionIdFrom(sessionIdFrom);

		return originalMsgHeader;

	}

	/**
	 * @return the recordCode
	 */
	public int getBusinessMsgCode() {
		return businessMsgCode;
	}

	/**
	 * @return the sourceDataObject
	 */
	public T getSourceDataObject() {
		return sourceDataObject;
	}

	private BodyParser getBodyParserFor(int businessMsgCode) {
		logger.debug("AbstractBusinessMsgBuilder.getBodyParserFor started for recordCode {}", businessMsgCode);
		switch (businessMsgCode) {
		case 7420:
			msgBodyParser = new RVBodyParser_7420();
			break;
		case 8422:
			msgBodyParser = new RVBodyParser_8422();
			break;
		case 6530:// Verifica Pagamento
			msgBodyParser = new RVBodyParser_6530();
			break;
		case 6532:// Verifica Rimborso
			msgBodyParser = new RVBodyParser_6532();
			break;
		case 6626:// Conferma Pagamento
			msgBodyParser = new RCBodyParser_6626();
			break;
		case 6342:// Verifica Bollo Auto
			msgBodyParser = new RVBodyParser_6342();
			break;
		case 6228:// Reprint service
			msgBodyParser = new RPBodyParser_6228();
			break;
		case 7542:// VerificaTreni
			msgBodyParser = new RVBodyParser_7542();
			break;

		case 8518:// Card2Card verify
			msgBodyParser = new RVBodyParser_8518();
			break;
		case 8626:// Card2Card confirm
			msgBodyParser = new RCBodyParser_8626();
			break;
		}
		logger.debug("AbstractBusinessMsgBuilder.getBodyParserFor finished for recordCode {}", businessMsgCode);

		return msgBodyParser;
	}

	/**
	 * @return the bodyParser
	 */
	public BodyParser getMsgBodyParser() {
		return msgBodyParser;
	}
}
