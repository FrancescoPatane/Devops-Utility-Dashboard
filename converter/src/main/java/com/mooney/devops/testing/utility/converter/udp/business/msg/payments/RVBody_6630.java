package com.mooney.devops.testing.utility.converter.udp.business.msg.payments;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;

/**
 * @author
 */
public class RVBody_6630 implements IBusinessMsgBody {
	// REQUEST - VERIFY - PAYMENT_PREMARKED
	private String body;

	@Override
	@JsonIgnore
	public long getTid() {
		return 0;
	}

	@Override
	public void setTid(long tid) {
	}

	@Override
	public int getLength() {
		return 0;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}