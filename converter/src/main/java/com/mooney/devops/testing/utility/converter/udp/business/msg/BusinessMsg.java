/**
 * 
 */
package com.mooney.devops.testing.utility.converter.udp.business.msg;

import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsg;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgHeader;

/**
 * @author Luigi Spinelli This is the base implementation of a business message
 *
 */
public abstract class BusinessMsg implements IBusinessMsg {

	private IBusinessMsgHeader msgHeader;

	private IBusinessMsgBody msgBody;

	/**
	 *
	 * @param msgHeader
	 * @param msgBody
	 */
	public BusinessMsg(IBusinessMsgHeader msgHeader, IBusinessMsgBody msgBody) {
		this.msgBody = msgBody;
		this.msgHeader = msgHeader;

	}

	/**
	 *
	 * @return
	 */
	public IBusinessMsgBody getMsgBody() {

		return this.msgBody;
	}

	public IBusinessMsgHeader getMsgHeader() {

		return this.msgHeader;
	}

	/**
	 *
	 * @param msgBody
	 */
	public void setMsgBody(IBusinessMsgBody msgBody) {
		this.msgBody = msgBody;

	}

	/**
	 *
	 * @param msgHeader
	 */
	public void setMsgHeader(IBusinessMsgHeader msgHeader) {
		this.msgHeader = msgHeader;

	}

}
