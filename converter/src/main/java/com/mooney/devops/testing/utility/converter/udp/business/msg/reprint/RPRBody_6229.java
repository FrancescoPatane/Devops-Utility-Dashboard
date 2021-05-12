package com.mooney.devops.testing.utility.converter.udp.business.msg.reprint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mooney.devops.testing.utility.converter.udp.business.common.Position;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;
import com.vipera.sisal.retefisica.common.business.interfaces.IParsableObject;

/**
 * Created by ciccio on 13/05/16.
 */
public class RPRBody_6229 implements IBusinessMsgBody, IParsableObject {
	// RESPONSE - REPRINT
	private static final long serialVersionUID = -719238363326696926L;

	@JsonIgnore
	public static final int LENGTH = 4021;

	private Long tid;

	@Position(offset = 0, length = 2)
	private short partnerId;

	@Position(offset = 2, length = 2)
	private short paymentCode;

	@Position(offset = 4, length = 2)
	private short receiptLength;

	@Position(offset = 6, length = 15)
	private String tidString;

	@Position(offset = 21, length = 4020)
	private String receiptData;

	public short getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(short partnerId) {
		this.partnerId = partnerId;
	}

	public short getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(short paymentCode) {
		this.paymentCode = paymentCode;
	}

	public short getReceiptLength() {
		return receiptLength;
	}

	public void setReceiptLength(short receiptLength) {
		this.receiptLength = receiptLength;
	}

	public String getReceiptData() {
		return receiptData;
	}

	public void setReceiptData(String receiptData) {
		this.receiptData = receiptData;
	}

	public String getTidString() {
		return tidString;
	}

	public void setTidString(String tidString) {
		this.tidString = tidString;
	}

	@Override
	public long getTid() {
		return tid;
	}

	@Override
	public void setTid(long tid) {
		this.tid = tid;
		this.tidString = String.format("%015d", this.tid);
	}

	@Override
	public int getLength() {
		return this.LENGTH;
	}

}
