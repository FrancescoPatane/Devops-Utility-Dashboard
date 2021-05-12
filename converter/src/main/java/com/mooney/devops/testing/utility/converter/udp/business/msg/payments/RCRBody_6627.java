package com.mooney.devops.testing.utility.converter.udp.business.msg.payments;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mooney.devops.testing.utility.converter.udp.business.common.Position;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;
import com.vipera.sisal.retefisica.common.business.interfaces.IParsableObject;

/**
 * @author #p4r51f4!
 */
public class RCRBody_6627 implements IBusinessMsgBody, IParsableObject {
	// RESPONSE - CONFIRM - PAYMENT or TICKETING
	private static final long serialVersionUID = 6242429878493021042L;

	@JsonIgnore
	public static final int LENGTH = 4247;

	private long tid;

	@Position(offset = 0, length = 15)
	private String cartId;

	@Position(offset = 15, length = 15)
	private String tidString;

	@Position(offset = 30, length = 40)
	private String paymentId;

	@Position(offset = 70, length = 2)
	private short paymentCode;

	@Position(offset = 72, length = 4)
	private long amount;

	@Position(offset = 76, length = 4)
	private long salePointFee;

	@Position(offset = 80, length = 4)
	private long sisalFee;

	@Position(offset = 84, length = 1)
	private short result;

	@Position(offset = 85, length = 160)
	private String resultDesc;

	@Position(offset = 245, length = 1)
	private short receiptFields;

	@Position(offset = 246, length = 4000)
	private String receiptData;

	@Position(offset = 4246, length = 1)
	private byte lastPayment;

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public byte getLastPayment() {
		return lastPayment;
	}

	public void setLastPayment(byte lastPayment) {
		this.lastPayment = lastPayment;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public short getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(short paymentCode) {
		this.paymentCode = paymentCode;
	}

	public String getReceiptData() {
		return receiptData;
	}

	public void setReceiptData(String receiptData) {
		this.receiptData = receiptData;
	}

	public short getReceiptFields() {
		return receiptFields;
	}

	public void setReceiptFields(short receiptFields) {
		this.receiptFields = receiptFields;
	}

	public short getResult() {
		return result;
	}

	public void setResult(short result) {
		this.result = result;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

	public long getSalePointFee() {
		return salePointFee;
	}

	public void setSalePointFee(long salePointFee) {
		this.salePointFee = salePointFee;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public long getSisalFee() {
		return sisalFee;
	}

	public void setSisalFee(long sisalFee) {
		this.sisalFee = sisalFee;
	}

	public String getTidString() {
		return tidString;
	}

	public void setTidString(String tidString) {
		this.tidString = tidString;
	}

	@Override
	public int getLength() {
		return LENGTH;
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

}