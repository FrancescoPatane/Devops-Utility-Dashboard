package com.mooney.devops.testing.utility.converter.udp.business.msg.payments;

import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;

/**
 * @author #p4r51f4!
 */
public class RVRBody_6631 implements IBusinessMsgBody {
	// RESPONSE - VERIFY - PAYMENT_PREMARKED
	private static final long serialVersionUID = -719238363326696926L;

	private String body;

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getTid() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTid(long tid) {
		// TODO Auto-generated method stub

	}

}