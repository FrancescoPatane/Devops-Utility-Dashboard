package com.mooney.devops.testing.utility.converter.udp.business.msg.digipay;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;
import com.vipera.sisal.retefisica.common.business.interfaces.IParsableObject;

/**
 * @author quintavalle
 */
public class RDGPRBody_8001 implements IBusinessMsgBody, IParsableObject {
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
