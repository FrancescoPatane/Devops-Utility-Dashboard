/**
 *
 */
package com.mooney.devops.testing.utility.converter.udp.business.msg.payments;

import com.mooney.devops.testing.utility.converter.udp.business.common.Position;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;

/**
 * @author Parsifal
 *
 */
public class RVBody_7542 implements IBusinessMsgBody {
	// REQUEST - VERIFY - TICKETING
	private static final long serialVersionUID = -1619334568845660737L;

	public static final int LENGTH = 97;

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
	private byte paymentType;

	@Position(offset = 7, length = 15)
	private String cartId;

	@Position(offset = 22, length = 2)
	private short partnerId;

	@Position(offset = 24, length = 2)
	private short paymentCode;

	@Position(offset = 26, length = 40)
	private String paymentId;

	@Position(offset = 66, length = 9)
	private String startStationId;

	@Position(offset = 75, length = 9)
	private String endStationId;

	@Position(offset = 84, length = 1)
	private String tripType;

	@Position(offset = 85, length = 1)
	private String classType;

	@Position(offset = 86, length = 1)
	private String category;

	@Position(offset = 87, length = 1)
	private String passengersNumber;

	@Position(offset = 88, length = 6)
	private String inquiryDate;

	@Position(offset = 94, length = 2)
	private short checkSum;

	@Position(offset = 94, length = 2)
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

	public byte getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(byte paymentType) {
		this.paymentType = paymentType;
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

	public String getStartStationId() {
		return startStationId;
	}

	public void setStartStationId(String startStationId) {
		this.startStationId = startStationId;
	}

	public String getEndStationId() {
		return endStationId;
	}

	public void setEndStationId(String endStationId) {
		this.endStationId = endStationId;
	}

	public String getTripType() {
		return tripType;
	}

	public void setTripType(String tripType) {
		this.tripType = tripType;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPassengersNumber() {
		return passengersNumber;
	}

	public void setPassengersNumber(String passengersNumber) {
		this.passengersNumber = passengersNumber;
	}

	public String getInquiryDate() {
		return inquiryDate;
	}

	public void setInquiryDate(String inquiryDate) {
		this.inquiryDate = inquiryDate;
	}

	public String getCheckSumString() {
		return checkSumString;
	}

	public void setCheckSumString(String checkSumString) {
		this.checkSumString = checkSumString;
	}

	public short getCheckSum() {
		return checkSum;
	}

	public void setCheckSum(short checkSum) {
		this.checkSum = checkSum;
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
