package com.mooney.devops.testing.utility.converter.udp.business.msg.recharges;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mooney.devops.testing.utility.converter.udp.business.common.Position;
import com.mooney.devops.testing.utility.converter.udp.business.msg.IntRechargeProduct4Tg;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;
import com.vipera.sisal.retefisica.common.business.interfaces.IParsableObject;

/**
 *
 * class for International Topups Response Verify Body
 *
 */
public class RVRBody_7421 implements IBusinessMsgBody, IParsableObject {
	// RESPONSE - VERIFY - SELLING - INTERNATIONAL_TOPUPS
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	public static final int LENGTH = 1163;
	private long tid;

	@JsonIgnore
	@Position(offset = 0, length = 15)
	private String tidString;

	@Position(offset = 15, length = 1)
	private int result;

	@Position(offset = 16, length = 160)
	private String resultDescription;

	@Position(offset = 176, length = 6)
	private String countryCode;

	@Position(offset = 182, length = 20)
	private String carrierCode;

	@Position(offset = 202, length = 1)
	private String numProducts;

	// --(offset = 203, length = 960)
	private List<IntRechargeProduct4Tg> productList;

	/*
	 * @Position(offset = 203, length = 960) private List<IntRechargeProduct> productList;
	 *
	 */
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

	/**
	 * @return the tidString
	 */
	public String getTidString() {
		return tidString;
	}

	/**
	 * @param tidString
	 *            the tidString to set
	 */
	public void setTidString(String tidString) {
		this.tidString = tidString;
	}

	/**
	 * @return the resultDescription
	 */
	public String getResultDescription() {
		return resultDescription;
	}

	/**
	 * @param resultDescription
	 *            the resultDescription to set
	 */
	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
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
	 * @return the numProducts
	 */
	public String getNumProducts() {
		return numProducts;
	}

	/**
	 * @param numProducts
	 *            the numProducts to set
	 */
	public void setNumProducts(String numProducts) {
		this.numProducts = numProducts;
	}

	/**
	 * @return the productList
	 */
	public List<IntRechargeProduct4Tg> getProductList() {
		return productList;
	}

	/**
	 * @param productList
	 *            the productList to set
	 */
	public void setProductList(List<IntRechargeProduct4Tg> productList) {
		this.productList = productList;
	}

	public String printBean() {
		return printBean(" ");
	}

	public String printBean(String sep) {
		StringBuffer sb = new StringBuffer();

		sb.append("tid").append(sep).append(tid).append(sep).append("tidString").append(sep).append(tidString).append(sep).append("result").append(sep).append(result).append(sep).append("resultDescription").append(sep).append(resultDescription).append(sep).append("countryCode").append(sep).append(countryCode).append(sep).append("carrierCode").append(sep).append(carrierCode).append(sep).append("numProducts").append(sep).append(numProducts).append(sep).append("productList").append(sep).append(productList);

		return sb.toString();

	}

	/**
	 * @return the result
	 */
	public int getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(int result) {
		this.result = result;
	}
}
