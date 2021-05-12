/**
 *
 */
package com.mooney.devops.testing.utility.converter.udp.business.msg.recharges;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mooney.devops.testing.utility.converter.udp.business.common.Position;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;

/**
 * class for International Recharges Request Verify Body
 */
public class RVBody_7420 implements IBusinessMsgBody {
// REQUEST - VERIFY - SELLING - INTERNATIONAL_TOPUPS
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private static final int LENGTH = 76;

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

	@Position(offset = 8, length = 6)
	private String countryCode;

	@Position(offset = 14, length = 20)
	private String carrierCode;

	@Position(offset = 34, length = 20)
	private String code1 = "";

	@Position(offset = 54, length = 20)
	private String code2 = "";

	@Position(offset = 74, length = 2)
	private short checkSum;

	@Position(offset = 74, length = 2)
	private String checkSumString;

	/**
	 * @return the zone
	 */
	public byte getZone() {
		return zone;
	}

	/**
	 * @param zone
	 *            the zone to set
	 */
	public void setZone(byte zone) {
		this.zone = zone;
	}

	/**
	 * @return the salePoint
	 */
	public short getSalePoint() {
		return salePoint;
	}

	/**
	 * @param salePoint
	 *            the salePoint to set
	 */
	public void setSalePoint(short salePoint) {
		this.salePoint = salePoint;
	}

	/**
	 * @return the terminal
	 */
	public byte getTerminal() {
		return terminal;
	}

	/**
	 * @param terminal
	 *            the terminal to set
	 */
	public void setTerminal(byte terminal) {
		this.terminal = terminal;
	}

	/**
	 * @return the salePointType
	 */
	public byte getSalePointType() {
		return salePointType;
	}

	/**
	 * @param salePointType
	 *            the salePointType to set
	 */
	public void setSalePointType(byte salePointType) {
		this.salePointType = salePointType;
	}

	/**
	 * @return the terminalType
	 */
	public byte getTerminalType() {
		return terminalType;
	}

	/**
	 * @param terminalType
	 *            the terminalType to set
	 */
	public void setTerminalType(byte terminalType) {
		this.terminalType = terminalType;
	}

	/**
	 * @return the operator
	 */
	public short getOperator() {
		return operator;
	}

	/**
	 * @param operator
	 *            the operator to set
	 */
	public void setOperator(short operator) {
		this.operator = operator;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode
	 *            the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the carrierCode
	 */
	public String getCarrierCode() {
		return carrierCode;
	}

	/**
	 * @param carrierCode
	 *            the carrierCode to set
	 */
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	/**
	 * @return the code1
	 */
	public String getCode1() {
		return code1;
	}

	/**
	 * @param code1
	 *            the code1 to set
	 */
	public void setCode1(String code1) {
		this.code1 = code1;
	}

	/**
	 * @return the code2
	 */
	public String getCode2() {
		return code2;
	}

	/**
	 * @param code2
	 *            the code2 to set
	 */
	public void setCode2(String code2) {
		this.code2 = code2;
	}

	/**
	 * @return the checkSum
	 */
	public short getCheckSum() {
		return checkSum;
	}

	/**
	 * @param checkSum
	 *            the checkSum to set
	 */
	public void setCheckSum(short checkSum) {
		this.checkSum = checkSum;
	}

	@Override
	public int getLength() {
		return LENGTH;
	}

	@Override
	public long getTid() {
		return 0;
	}

	@Override
	public void setTid(long arg0) {

	}

	/**
	 * @return the checkSumString
	 */
	public String getCheckSumString() {
		return checkSumString;
	}

	/**
	 * @param checkSumString
	 *            the checkSumString to set
	 */
	public void setCheckSumString(String checkSumString) {
		this.checkSumString = checkSumString;
	}

}
