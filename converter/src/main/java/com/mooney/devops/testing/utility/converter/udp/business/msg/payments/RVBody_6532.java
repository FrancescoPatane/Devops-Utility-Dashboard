package com.mooney.devops.testing.utility.converter.udp.business.msg.payments;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mooney.devops.testing.utility.converter.udp.business.common.Position;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;

/**
 * @author #napoleone!
 */
public class RVBody_6532 implements IBusinessMsgBody {
	// REQUEST - UNKNOW
	private static final long serialVersionUID = -1919334568845660737L;

	private static final int LENGTH = 109;

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

	@Position(offset = 6, length = 1)
	private byte readPaymentMode;

	@Position(offset = 7, length = 15)
	private String cartId;

	@Position(offset = 22, length = 2)
	private short partnerId;

	@Position(offset = 24, length = 2)
	private short paymentCode;

	@Position(offset = 26, length = 40)
	private String paymentId;

	@Position(offset = 66, length = 20)
	private String gln;

	@Position(offset = 86, length = 4)
	private int amountTg;

	@Position(offset = 90, length = 16)
	private String fiscalCode;

	@Position(offset = 106, length = 1)
	private int modAcqFs;

	@Position(offset = 107, length = 2)
	private short checkSum;

	@Position(offset = 107, length = 2)
	private String checkSumString;

	public byte getZone() {
		return zone;
	}

	public void setZone(byte zone) {
		this.zone = zone;
	}

	public short getSalePoint() {
		return salePoint;
	}

	public void setSalePoint(short salePoint) {
		this.salePoint = salePoint;
	}

	public byte getTerminal() {
		return terminal;
	}

	public void setTerminal(byte terminal) {
		this.terminal = terminal;
	}

	public byte getSalePointType() {
		return salePointType;
	}

	public void setSalePointType(byte salePointType) {
		this.salePointType = salePointType;
	}

	public byte getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(byte terminalType) {
		this.terminalType = terminalType;
	}

	public byte getReadPaymentMode() {
		return readPaymentMode;
	}

	public void setReadPaymentMode(byte readPaymentMode) {
		this.readPaymentMode = readPaymentMode;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

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

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getGln() {
		return gln;
	}

	public void setGln(String gln) {
		this.gln = gln;
	}

	public int getAmountTg() {
		return amountTg;
	}

	public void setAmountTg(int amountTg) {
		this.amountTg = amountTg;
	}

	public String getFiscalCode() {
		return fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}

	public int getModAcqFs() {
		return modAcqFs;
	}

	public void setModAcqFs(int modAcqFs) {
		this.modAcqFs = modAcqFs;
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
		return LENGTH;
	}

}