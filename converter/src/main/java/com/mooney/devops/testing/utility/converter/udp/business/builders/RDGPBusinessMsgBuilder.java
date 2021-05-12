package com.mooney.devops.testing.utility.converter.udp.business.builders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mooney.devops.testing.utility.converter.udp.business.msg.DefaultMsgHeader;
import com.mooney.devops.testing.utility.converter.udp.business.msg.RDGPMsg;
import com.mooney.devops.testing.utility.converter.udp.business.msg.digipay.RDGPBody_8000;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.DefaultMsgHeaderParser;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsg;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;

/**
 * @author quintavalle
 */
public class RDGPBusinessMsgBuilder extends AbstractBusinessMsgBuilder<byte[]> {

	private static final Logger logger = LoggerFactory.getLogger(RDGPBusinessMsgBuilder.class);

	protected IBusinessMsg businessMsg;

	public RDGPBusinessMsgBuilder(byte[] sourceDataObject, int recordCode) {
		super(sourceDataObject, recordCode);
		businessMsg = new RDGPMsg(null, null);
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

		originalBody = getBody(getSourceDataObject());
		newBody = new RDGPBody_8000();
		String body = new String(originalBody);

		((RDGPBody_8000) newBody).setBody(body);

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
