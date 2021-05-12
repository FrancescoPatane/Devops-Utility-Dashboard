package com.mooney.devops.testing.utility.converter.udp.business.msg.recharges;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mooney.devops.testing.utility.converter.udp.business.common.Position;
import com.mooney.devops.testing.utility.converter.udp.business.msg.FeesRecharges;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;
import com.vipera.sisal.retefisica.common.business.interfaces.IParsableObject;

/**
 * @author Luigi Spinelli
 */
public class RVRBody_8519 implements IBusinessMsgBody, IParsableObject {
	// RESPONSE - VERIFY - SELLIN
	private static final long serialVersionUID = -719238363326696926L;

	@JsonIgnore
	public static final int LENGTH = 1710;

	private long tid;

	@JsonIgnore
	@Position(offset = 0, length = 15)
	private String tidString;

	@Position(offset = 15, length = 4)
	private int amount;

	@Position(offset = 19, length = 4)
	private int premium;

	@Position(offset = 23, length = 4)
	private int salePointFee;

	@Position(offset = 27, length = 4)
	private int sisalFee;

	@Position(offset = 31, length = 1)
	private byte feeType;

	@Position(offset = 32, length = 4)
	private int balance;

	@Position(offset = 36, length = 1)
	private int result;

	@Position(offset = 37, length = 160)
	private String resultDescription = "";

	@Position(offset = 197, length = 500)
	private String data = "";

	private List<String> extraList;

	@Position(offset = 697, length = 15)
	private byte[] cartId;

	/*--- DescrizioneAggi -> */
	@Position(offset = 712, length = 180)
	private List<FeesRecharges> fees;
	/*--- END -> DescrizioneAggi ---*/

	/*--- SCANSIONE DOCUMENTO */
	@Position(offset = 892, length = 1)
	private byte requiredDocument;

	@Position(offset = 893, length = 160)
	private String descripitionScanRequest = "";

	@Position(offset = 1053, length = 64)
	private String documentIdScan = "";

	@Position(offset = 1117, length = 8)
	private String documentIssueDate = "";

	@Position(offset = 1125, length = 20)
	private String documentIssuer = "";

	@Position(offset = 1145, length = 40)
	private String residenceStreet = "";

	@Position(offset = 1185, length = 5)
	private String residenceStreetNumber = "";

	@Position(offset = 1190, length = 5)
	private String residenceApartmentNumber = "";

	@Position(offset = 1195, length = 40)
	private String residenceArea = "";

	@Position(offset = 1235, length = 50)
	private String residenceCity = "";

	@Position(offset = 1285, length = 2)
	private String residenceCounty = "";

	@Position(offset = 1287, length = 5)
	private String residencePostalCode = "";

	@Position(offset = 1292, length = 20)
	private String residenceNation = "";

	@Position(offset = 1312, length = 40)
	private String domicileStreet = "";

	@Position(offset = 1352, length = 5)
	private String domicileStreetNumber = "";

	@Position(offset = 1357, length = 5)
	private String domicileApartmentNumber = "";

	@Position(offset = 1362, length = 40)
	private String domicileArea = "";

	@Position(offset = 1402, length = 50)
	private String domicileCity = "";

	@Position(offset = 1452, length = 2)
	private String domicileCounty = "";

	@Position(offset = 1454, length = 5)
	private String domicilePostalCode = "";

	@Position(offset = 1459, length = 20)
	private String domicileNation = "";

	@Position(offset = 1479, length = 100)
	private String name;

	@Position(offset = 1579, length = 10)
	private String birthDate;

	@Position(offset = 1589, length = 16)
	private String fiscalCode;

	@Position(offset = 1605, length = 50)
	private String birthPlace;

	@Position(offset = 1655, length = 1)
	private byte documentType;

	@Position(offset = 1656, length = 20)
	private String documentNumber;

	@Position(offset = 1676, length = 8)
	private String documentValidity;

	@Position(offset = 1684, length = 26)
	private String wallet;

	public List<FeesRecharges> getFees() {
		return fees;
	}

	public void setFees(List<FeesRecharges> fees) {
		this.fees = fees;
	}

	public byte[] getCartId() {
		return cartId;
	}

	public void setCartId(byte[] cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return
	 */
	public int getPremium() {
		return premium;
	}

	/**
	 * @param premium
	 */
	public void setPremium(int premium) {
		this.premium = premium;
	}

	/**
	 * @return
	 */
	public int getSalePointFee() {
		return salePointFee;
	}

	/**
	 * @param salePointFee
	 */
	public void setSalePointFee(int salePointFee) {
		this.salePointFee = salePointFee;
	}

	/**
	 * @return
	 */
	public int getSisalFee() {
		return sisalFee;
	}

	/**
	 * @param sisalFee
	 */
	public void setSisalFee(int sisalFee) {
		this.sisalFee = sisalFee;
	}

	/**
	 * @return
	 */
	public byte getFeeType() {
		return feeType;
	}

	/**
	 * @param feeType
	 */
	public void setFeeType(byte feeType) {
		this.feeType = feeType;
	}

	/**
	 * @return
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

	/**
	 * @return
	 */
	public int getResult() {
		return result;
	}

	/**
	 * @param result
	 */
	public void setResult(int result) {
		this.result = result;
	}

	/**
	 * @return
	 */
	public String getResultDescription() {
		return resultDescription;
	}

	/**
	 * @param resultDescription
	 */
	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}

	/**
	 * @return
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data
	 */
	public void setData(String data) {
		this.data = data;
	}

	@JsonIgnore
	public int getLength() {

		return LENGTH;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("RVRMsg BODY: ");
		sb.append("\n");

		sb.append("Tid = " + this.tid).append("\n");
		sb.append("FeeType = " + this.feeType).append("\n");
		sb.append("Balance = " + this.balance).append("\n");
		sb.append("Amount = " + this.amount).append("\n");
		sb.append("Result = " + this.result).append("\n");
		sb.append("ResultDescription = " + this.resultDescription).append("\n");
		sb.append("Data = " + this.data).append("\n");
		sb.append("Premium = " + this.premium).append("\n");
		sb.append("SisalFee = " + this.sisalFee).append("\n");
		sb.append("SalePointFee = " + this.salePointFee).append("\n");

		return sb.toString();
	}

	/**
	 * @return the tid
	 */
	public long getTid() {
		return tid;
	}

	/**
	 * @param tid
	 *            the tid to set
	 */
	public void setTid(long tid) {
		this.tid = tid;
		this.tidString = String.format("%015d", this.tid);
	}

	/**
	 * @return the tidString
	 */
	@JsonIgnore
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
	 * @return the extraList
	 */

	public List<String> getExtraList() {
		return extraList;
	}

	/**
	 * @param extraList
	 *            the extraList to set
	 */
	public void setExtraList(List<String> extraList) {
		this.extraList = extraList;
	}

	public byte getRequiredDocument() {
		return requiredDocument;
	}

	public void setRequiredDocument(byte requiredDocument) {
		this.requiredDocument = requiredDocument;
	}

	public String getDescripitionScanRequest() {
		return descripitionScanRequest;
	}

	public void setDescripitionScanRequest(String descripitionScanRequest) {
		this.descripitionScanRequest = descripitionScanRequest;
	}

	public String getDocumentIdScan() {
		return documentIdScan;
	}

	public void setDocumentIdScan(String documentIdScan) {
		this.documentIdScan = documentIdScan;
	}

	public String getDocumentIssueDate() {
		return documentIssueDate;
	}

	public void setDocumentIssueDate(String documentIssueDate) {
		this.documentIssueDate = documentIssueDate;
	}

	public String getDocumentIssuer() {
		return documentIssuer;
	}

	public void setDocumentIssuer(String documentIssuer) {
		this.documentIssuer = documentIssuer;
	}

	public String getResidenceStreet() {
		return residenceStreet;
	}

	public void setResidenceStreet(String residenceStreet) {
		this.residenceStreet = residenceStreet;
	}

	public String getResidenceStreetNumber() {
		return residenceStreetNumber;
	}

	public void setResidenceStreetNumber(String residenceStreetNumber) {
		this.residenceStreetNumber = residenceStreetNumber;
	}

	public String getResidenceApartmentNumber() {
		return residenceApartmentNumber;
	}

	public void setResidenceApartmentNumber(String residenceApartmentNumber) {
		this.residenceApartmentNumber = residenceApartmentNumber;
	}

	public String getResidenceArea() {
		return residenceArea;
	}

	public void setResidenceArea(String residenceArea) {
		this.residenceArea = residenceArea;
	}

	public String getResidenceCity() {
		return residenceCity;
	}

	public void setResidenceCity(String residenceCity) {
		this.residenceCity = residenceCity;
	}

	public String getResidenceCounty() {
		return residenceCounty;
	}

	public void setResidenceCounty(String residenceCounty) {
		this.residenceCounty = residenceCounty;
	}

	public String getResidencePostalCode() {
		return residencePostalCode;
	}

	public void setResidencePostalCode(String residencePostalCode) {
		this.residencePostalCode = residencePostalCode;
	}

	public String getResidenceNation() {
		return residenceNation;
	}

	public void setResidenceNation(String residenceNation) {
		this.residenceNation = residenceNation;
	}

	public String getDomicileStreet() {
		return domicileStreet;
	}

	public void setDomicileStreet(String domicileStreet) {
		this.domicileStreet = domicileStreet;
	}

	public String getDomicileStreetNumber() {
		return domicileStreetNumber;
	}

	public void setDomicileStreetNumber(String domicileStreetNumber) {
		this.domicileStreetNumber = domicileStreetNumber;
	}

	public String getDomicileApartmentNumber() {
		return domicileApartmentNumber;
	}

	public void setDomicileApartmentNumber(String domicileApartmentNumber) {
		this.domicileApartmentNumber = domicileApartmentNumber;
	}

	public String getDomicileArea() {
		return domicileArea;
	}

	public void setDomicileArea(String domicileArea) {
		this.domicileArea = domicileArea;
	}

	public String getDomicileCity() {
		return domicileCity;
	}

	public void setDomicileCity(String domicileCity) {
		this.domicileCity = domicileCity;
	}

	public String getDomicileCounty() {
		return domicileCounty;
	}

	public void setDomicileCounty(String domicileCounty) {
		this.domicileCounty = domicileCounty;
	}

	public String getDomicilePostalCode() {
		return domicilePostalCode;
	}

	public void setDomicilePostalCode(String domicilePostalCode) {
		this.domicilePostalCode = domicilePostalCode;
	}

	public String getDomicileNation() {
		return domicileNation;
	}

	public void setDomicileNation(String domicileNation) {
		this.domicileNation = domicileNation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public byte getDocumentType() {
		return documentType;
	}

	public void setDocumentType(byte documentType) {
		this.documentType = documentType;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getDocumentValidity() {
		return documentValidity;
	}

	public void setDocumentValidity(String documentValidity) {
		this.documentValidity = documentValidity;
	}

	public String getWallet() {
		return wallet;
	}

	public void setWallet(String wallet) {
		this.wallet = wallet;
	}

	public String getFiscalCode() {
		return fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}
}
