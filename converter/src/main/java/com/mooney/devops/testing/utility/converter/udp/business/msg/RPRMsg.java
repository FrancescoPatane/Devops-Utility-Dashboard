package com.mooney.devops.testing.utility.converter.udp.business.msg;

import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgHeader;

/**
 * Created by ciccio on 13/05/16.
 */
public class RPRMsg extends BusinessMsg {
	/**
	 * @param msgHeader
	 * @param msgBody
	 */
	public RPRMsg(IBusinessMsgHeader msgHeader, IBusinessMsgBody msgBody) {
		super(msgHeader, msgBody);
	}
}
