package com.mooney.devops.testing.utility.converter.udp.business.msg;

import java.io.Serializable;

public class FeesInternationalTopup implements Serializable {

	private static final long serialVersionUID = 1L;

	private String instrument;

	private int salePoint;

	private int sisal;

	private int type;

	private int maxAmount;

	private int officeAmount;

	/**
	 * @return the instrument
	 */
	public String getInstrument() {
		return instrument;
	}

	/**
	 * @param instrument
	 *            the instrument to set
	 */
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	/**
	 * @return the salePoint
	 */
	public int getSalePoint() {
		return salePoint;
	}

	/**
	 * @param salePoint
	 *            the salePoint to set
	 */
	public void setSalePoint(int salePoint) {
		this.salePoint = salePoint;
	}

	/**
	 * @return the sisal
	 */
	public int getSisal() {
		return sisal;
	}

	/**
	 * @param sisal
	 *            the sisal to set
	 */
	public void setSisal(int sisal) {
		this.sisal = sisal;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the maxAmount
	 */
	public int getMaxAmount() {
		return maxAmount;
	}

	/**
	 * @param maxAmount
	 *            the maxAmount to set
	 */
	public void setMaxAmount(int maxAmount) {
		this.maxAmount = maxAmount;
	}

	/**
	 * @return the officeAmount
	 */
	public int getOfficeAmount() {
		return officeAmount;
	}

	/**
	 * @param officeAmount
	 *            the officeAmount to set
	 */
	public void setOfficeAmount(int officeAmount) {
		this.officeAmount = officeAmount;
	}

}
