package com.mooney.devops.testing.utility.converter.udp.business.msg.digipay;

import com.vipera.sisal.retefisica.common.business.interfaces.ITransportMsg;

import it.sisal.pes.digipay.bean.canonical.CanonicalMessage;

/**
 * Message that wrap DigiPay data DigiPay Manager to adapter
 */
public class DigiPayTransportMessage implements ITransportMsg {
	/**
	 * DigiPay Message as it is senmt from DigiPay Manager
	 */
	private CanonicalMessage request;

	public CanonicalMessage getRequest() {
		return request;
	}

	public void setRequest(CanonicalMessage request) {
		this.request = request;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DigiPayTransportMessage [request=").append(request).append("]");
		return builder.toString();
	}
}
