package com.mooney.devops.testing.utility.converter.udp.business.msg;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mooney.devops.testing.utility.converter.udp.business.common.Position;
import com.vipera.sisal.retefisica.common.business.interfaces.IParsableObject;

/**
 * 
 * map the RFRicIntProduct into the TG struct: taglioSingolo
 *
 */
public class IntRechargeProduct4Tg implements IParsableObject, Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	public final static int LENGTH = 80;

	@Position(offset = 0, length = 30)
	private String productId;

	@Position(offset = 30, length = 30)
	private String productDescription;

	@Position(offset = 60, length = 4)
	private int amount;

	@Position(offset = 64, length = 4)
	private int topUpValue;

	@Position(offset = 68, length = 4)
	private int fees;

	@Position(offset = 72, length = 4)
	private int riceAmount;

	@Position(offset = 76, length = 4)
	private int sisalAmount;

	@Override
	public int getLength() {

		return LENGTH;
	}

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * @param productDescription
	 *            the productDescription to set
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the topUpValue
	 */
	public int getTopUpValue() {
		return topUpValue;
	}

	/**
	 * @param topUpValue
	 *            the topUpValue to set
	 */
	public void setTopUpValue(int topUpValue) {
		this.topUpValue = topUpValue;
	}

	/**
	 * @return the fees
	 */
	public int getFees() {
		return fees;
	}

	/**
	 * @param fees
	 *            the fees to set
	 */
	public void setFees(int fees) {
		this.fees = fees;
	}

	/**
	 * @return the riceAmount
	 */
	public int getRiceAmount() {
		return riceAmount;
	}

	/**
	 * @param riceAmount
	 *            the riceAmount to set
	 */
	public void setRiceAmount(int riceAmount) {
		this.riceAmount = riceAmount;
	}

	/**
	 * @return the sisalAmount
	 */
	public int getSisalAmount() {
		return sisalAmount;
	}

	/**
	 * @param sisalAmount
	 *            the sisalAmount to set
	 */
	public void setSisalAmount(int sisalAmount) {
		this.sisalAmount = sisalAmount;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String printBean() {
		return printBean(" ");
	}

	public String printBean(String sep) {
		StringBuffer sb = new StringBuffer();

		sb.append("productId").append(sep).append(productId).append(sep).append("productDescription").append(sep).append(productDescription).append(sep)
				.append("amount").append(sep).append(amount).append(sep).append("topUpValue").append(sep).append(topUpValue).append(sep).append("fees")
				.append(sep).append(fees).append(sep).append("riceAmount").append(sep).append(riceAmount).append(sep).append("sisalAmount").append(sep)
				.append(sisalAmount);

		return sb.toString();

	}

}
