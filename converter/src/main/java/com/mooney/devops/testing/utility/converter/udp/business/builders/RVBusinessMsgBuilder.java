package com.mooney.devops.testing.utility.converter.udp.business.builders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mooney.devops.testing.utility.converter.udp.business.msg.DefaultMsgHeader;
import com.mooney.devops.testing.utility.converter.udp.business.msg.RVMsg;
import com.mooney.devops.testing.utility.converter.udp.business.msg.payments.RVBody_6630;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.DefaultMsgHeaderParser;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsg;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;

/**
 *
 * @author spinellilu
 */
public class RVBusinessMsgBuilder extends AbstractBusinessMsgBuilder<byte[]> {

	private static final Logger logger = LoggerFactory.getLogger(RVBusinessMsgBuilder.class);

	protected IBusinessMsg businessMsg;

	public RVBusinessMsgBuilder(byte[] sourceDataObject, int recordCode) {
		super(sourceDataObject, recordCode);
		businessMsg = new RVMsg(null, null);
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
			newBody = new RVBody_6630();
			String body = new String(originalBody);
			((RVBody_6630) newBody).setBody(body);
		} else {
			originalBody = getMsgBodyParser().getBody(getSourceDataObject());			
			newBody = (IBusinessMsgBody) getMsgBodyParser().parser(originalBody);
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
