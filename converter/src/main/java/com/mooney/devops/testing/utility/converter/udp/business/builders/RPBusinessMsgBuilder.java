package com.mooney.devops.testing.utility.converter.udp.business.builders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mooney.devops.testing.utility.converter.udp.business.msg.DefaultMsgHeader;
import com.mooney.devops.testing.utility.converter.udp.business.msg.RPMsg;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.BodyParser;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.DefaultMsgHeaderParser;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsg;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;

/**
 * Created by ciccio on 13/05/16.
 */
public class RPBusinessMsgBuilder extends AbstractBusinessMsgBuilder<byte[]> {
	private static final Logger logger = LoggerFactory.getLogger(RPBusinessMsgBuilder.class);

	protected IBusinessMsg businessMsg;

	public RPBusinessMsgBuilder(byte[] sourceDataObject, int recordCode) {
		super(sourceDataObject, recordCode);
		businessMsg = new RPMsg(null, null);
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

		originalBody = getMsgBodyParser().getBody(getSourceDataObject());

		short msn = businessMsg.getMsgHeader().getMessageSeqNo();

		int recCode = businessMsg.getMsgHeader().getRecordCode();
		logger.debug("UDP - {} - recordCode:{}", this.getClass().getSimpleName(), recCode);

		BodyParser bodyParser = getMsgBodyParser();
		if (msn > 0) {
			newBody = (IBusinessMsgBody) bodyParser.parser(originalBody);
		} else {
			newBody = (IBusinessMsgBody) bodyParser.getObject();
			newBody.setTid(-1);
		}
		businessMsg.setMsgBody(newBody);
	}

	@Override
	public IBusinessMsg getBusinessMsg() {
		return this.businessMsg;
	}
}
