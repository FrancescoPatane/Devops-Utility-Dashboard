/**
 *
 */
package com.mooney.devops.testing.utility.converter.udp.business.msg.recharges;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mooney.devops.testing.utility.converter.udp.business.common.Position;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;

/**
 * @author #p4r51f4! on 29/06/16
 */
public class RVBody_8422 implements IBusinessMsgBody {
	// REQUEST - VERIFY - SELLING - REGISTRATION
	private static final long serialVersionUID = -1619334568845660737L;

	@JsonIgnore
	private static final int LENGTH = 327;

	@Position(offset = 0, length = 1)
	private byte zone;

	@Position(offset = 1, length = 2)
	private short salePoint;

	@Position(offset = 3, length = 1)
	private byte terminal;

	@Position(offset = 4, length = 1)
	private byte salePointType;

	@Position(offset = 5, length = 1)
	private byte terminalType;

	@Position(offset = 6, length = 2)
	private short operator;

	@Position(offset = 8, length = 12)
	private String productId;

	@Position(offset = 20, length = 1)
	private byte rechargeType;

	@Position(offset = 21, length = 1)
	private byte rechargeMode;

	@Position(offset = 22, length = 4)
	private int amount;

	@Position(offset = 26, length = 4)
	private int salePointFee;

	@Position(offset = 30, length = 4)
	private int sisalFee;

	@Position(offset = 34, length = 1)
	private byte feeType;

	@Position(offset = 35, length = 1)
	private byte paymentType;

	@Position(offset = 36, length = 50)
	private String IdMP;

	@Position(offset = 86, length = 16)
	private String orderFC;

	@Position(offset = 102, length = 50)
	private String orderName;

	@Position(offset = 152, length = 50)
	private String orderSurname;

	@Position(offset = 202, length = 2)
	private String provinceResidence;

	@Position(offset = 204, length = 100)
	private String email;

	@Position(offset = 304, length = 20)
	private String mobileTelephone;

	@Position(offset = 324, length = 1)
	private byte fcReadMode;

	@Position(offset = 325, length = 2)
	private short checkSum;

	@Position(offset = 325, length = 2)
	private String checkSumString;

	public String getIdMP() {
		return IdMP;
	}

	public void setIdMP(String idMP) {
		IdMP = idMP;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public short getCheckSum() {
		return checkSum;
	}

	public void setCheckSum(short checkSum) {
		this.checkSum = checkSum;
	}

	public String getCheckSumString() {
		return checkSumString;
	}

	public void setCheckSumString(String checkSumString) {
		this.checkSumString = checkSumString;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getFcReadMode() {
		return fcReadMode;
	}

	public void setFcReadMode(byte fcReadMode) {
		this.fcReadMode = fcReadMode;
	}

	public byte getFeeType() {
		return feeType;
	}

	public void setFeeType(byte feeType) {
		this.feeType = feeType;
	}

	public String getMobileTelephone() {
		return mobileTelephone;
	}

	public void setMobileTelephone(String mobileTelephone) {
		this.mobileTelephone = mobileTelephone;
	}

	public short getOperator() {
		return operator;
	}

	public void setOperator(short operator) {
		this.operator = operator;
	}

	public String getOrderFC() {
		return orderFC;
	}

	public void setOrderFC(String orderFC) {
		this.orderFC = orderFC;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderSurname() {
		return orderSurname;
	}

	public void setOrderSurname(String orderSurname) {
		this.orderSurname = orderSurname;
	}

	public byte getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(byte paymentType) {
		this.paymentType = paymentType;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProvinceResidence() {
		return provinceResidence;
	}

	public void setProvinceResidence(String provinceResidence) {
		this.provinceResidence = provinceResidence;
	}

	public byte getRechargeMode() {
		return rechargeMode;
	}

	public void setRechargeMode(byte rechargeMode) {
		this.rechargeMode = rechargeMode;
	}

	public byte getRechargeType() {
		return rechargeType;
	}

	public void setRechargeType(byte rechargeType) {
		this.rechargeType = rechargeType;
	}

	public short getSalePoint() {
		return salePoint;
	}

	public void setSalePoint(short salePoint) {
		this.salePoint = salePoint;
	}

	public int getSalePointFee() {
		return salePointFee;
	}

	public void setSalePointFee(int salePointFee) {
		this.salePointFee = salePointFee;
	}

	public byte getSalePointType() {
		return salePointType;
	}

	public void setSalePointType(byte salePointType) {
		this.salePointType = salePointType;
	}

	public int getSisalFee() {
		return sisalFee;
	}

	public void setSisalFee(int sisalFee) {
		this.sisalFee = sisalFee;
	}

	public byte getTerminal() {
		return terminal;
	}

	public void setTerminal(byte terminal) {
		this.terminal = terminal;
	}

	public byte getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(byte terminalType) {
		this.terminalType = terminalType;
	}

	public byte getZone() {
		return zone;
	}

	public void setZone(byte zone) {
		this.zone = zone;
	}

	@Override
	public long getTid() {
		return 0;
	}

	@Override
	public void setTid(long tid) {
	}

	@Override
	public int getLength() {
		return LENGTH;
	}
}
