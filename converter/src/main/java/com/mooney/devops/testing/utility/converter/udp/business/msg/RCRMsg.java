package com.mooney.devops.testing.utility.converter.udp.business.msg;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgHeader;

/**
 *
 * @author spinellilu
 * @edit by #p4r51f4! on 08/04/16
 */
public class RCRMsg extends BusinessMsg {

	/**
	 *
	 * @param msgHeader
	 * @param msgBody
	 */
	@JsonCreator
	public RCRMsg(IBusinessMsgHeader msgHeader, IBusinessMsgBody msgBody) {
		super(msgHeader, msgBody);

	}

}
