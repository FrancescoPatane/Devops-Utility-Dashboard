package com.mooney.devops.testing.utility.converter.udp.business.builders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mooney.devops.testing.utility.converter.udp.business.msg.DefaultMsgHeader;
import com.mooney.devops.testing.utility.converter.udp.business.msg.RCMsg;
import com.mooney.devops.testing.utility.converter.udp.business.msg.payments.RCBody_6726;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.BodyParser;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.DefaultMsgHeaderParser;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsg;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;

/**
 * @author spinellilu
 * @edit by #p4r51f4! on 08/04/16
 */
public class RCBusinessMsgBuilder extends AbstractBusinessMsgBuilder<byte[]> {
	private static final Logger logger = LoggerFactory.getLogger(RCBusinessMsgBuilder.class);

	protected IBusinessMsg businessMsg;

	public RCBusinessMsgBuilder(byte[] sourceDataObject, int recordCode) {
		super(sourceDataObject, recordCode);
		businessMsg = new RCMsg(null, null);
	}

	@Override
	public void buildHeader() throws Exception {
		DefaultMsgHeaderParser myParser = new DefaultMsgHeaderParser();

		byte[] originalHeader = myParser.getHeader(getSourceDataObject());
		DefaultMsgHeader msgHeader = myParser.toObject(originalHeader);

		businessMsg.setMsgHeader(msgHeader);
	}

	@Override
	public void buildBody() throws Exception {
		byte[] originalBody = null;
		IBusinessMsgBody newBody = null;

		int recCode = businessMsg.getMsgHeader().getRecordCode();
		logger.debug("UDP - {} - recordCode:{}", this.getClass().getSimpleName(), recCode);

		if (JSON_MESSAGE.contains(recCode)) {

			originalBody = getBody(getSourceDataObject());
			newBody = new RCBody_6726();
			String body = new String(originalBody);
			((RCBody_6726) newBody).setBody(body);
		} else {
			BodyParser bodyParser = getMsgBodyParser();

			originalBody = bodyParser.getBody(getSourceDataObject());

			short msn = businessMsg.getMsgHeader().getMessageSeqNo();

			// if msn > 0 the byte stream will be parsed
			// if msn <=0 (terminal reset request) the byte stream will not be
			// parsed and a new empty body instance is returned with tid=-1
			if (msn > 0) {
				newBody = (IBusinessMsgBody) bodyParser.parser(originalBody);
			} else {
				newBody = (IBusinessMsgBody) bodyParser.getObject();
				newBody.setTid(-1);
			}
		}
		
		businessMsg.setMsgBody(newBody);
	}

	@Override
	public IBusinessMsg getBusinessMsg() {
		return this.businessMsg;
	}

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
