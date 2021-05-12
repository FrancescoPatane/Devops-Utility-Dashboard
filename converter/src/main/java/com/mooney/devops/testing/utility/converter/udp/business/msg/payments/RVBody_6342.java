/**
 *
 */
package com.mooney.devops.testing.utility.converter.udp.business.msg.payments;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mooney.devops.testing.utility.converter.udp.business.common.Position;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;

/**
 * @author Parsifal
 *
 */
public class RVBody_6342 implements IBusinessMsgBody {
	// REQUEST - BOLLO ACI
	private static final long serialVersionUID = -1619334568845660737L;

	@JsonIgnore
	private static final int LENGTH = 513;

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
	private short partnerId;

	@Position(offset = 8, length = 2)
	private short paymentCode;

	@Position(offset = 10, length = 1)
	private byte readMode;

	@Position(offset = 11, length = 2)
	private short checkSum;

	@Position(offset = 11, length = 2)
	private String checkSumString;

	@Position(offset = 13, length = 500)
	private String infoVerify;

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

	public String getInfoVerify() {
		return infoVerify;
	}

	public void setInfoVerify(String infoVerify) {
		this.infoVerify = infoVerify;
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

	public byte getReadMode() {
		return readMode;
	}

	public void setReadMode(byte readMode) {
		this.readMode = readMode;
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
