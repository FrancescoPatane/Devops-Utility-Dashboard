package com.mooney.devops.testing.utility.converter.udp.business.msg.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;
import com.vipera.sisal.retefisica.common.business.interfaces.IParsableObject;

public class RDOCBody_9000 implements IBusinessMsgBody, IParsableObject {
	private String body;

	@Override
	public int getLength() {
		return 0;
	}

	@Override
	@JsonIgnore
	public long getTid() {
		return 0;
	}

	@Override
	public void setTid(long arg0) {
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
