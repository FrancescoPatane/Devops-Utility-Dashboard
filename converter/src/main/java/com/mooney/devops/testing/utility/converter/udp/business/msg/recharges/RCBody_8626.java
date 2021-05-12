/**
 *
 */
package com.mooney.devops.testing.utility.converter.udp.business.msg.recharges;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mooney.devops.testing.utility.converter.udp.business.common.Position;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;
import com.vipera.sisal.retefisica.common.business.interfaces.IParsableObject;

/**
 * @author Luigi Spinelli
 */
public class RCBody_8626 implements IBusinessMsgBody, IParsableObject {
	// REQUEST - CONFIRM
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private static final int LENGTH = 1820;

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

	@JsonIgnore
	@Position(offset = 8, length = 12)
	private String productId;

	@Position(offset = 20, length = 1)
	private byte rechargeType;

	@Position(offset = 21, length = 1)
	private byte rechargeMode;

	@Position(offset = 22, length = 20)
	private String code1 = "";

	@Position(offset = 42, length = 20)
	private String code2 = "";

	@Position(offset = 62, length = 20)
	private String code3 = "";

	@Position(offset = 82, length = 20)
	private String code4 = "";

	@Position(offset = 102, length = 4)
	private int amount;

	@Position(offset = 106, length = 4)
	private int amountCurrency;

	@Position(offset = 110, length = 4)
	private int salePointFee;

	@Position(offset = 114, length = 4)
	private int sisalFee;

	@Position(offset = 118, length = 1)
	private byte feeType;

	@Position(offset = 119, length = 1)
	private byte paymentType;

	@Position(offset = 120, length = 16)
	private String orderFC = "";

	@Position(offset = 136, length = 100)
	private String orderName = "";

	@Position(offset = 236, length = 16)
	private String ownerFC = "";

	@Position(offset = 252, length = 100)
	private String ownerName = "";

	@Position(offset = 352, length = 1)
	private byte fcReadMode;

	@Position(offset = 353, length = 2)
	private short checkSum;

	@Position(offset = 353, length = 2)
	private String checkSumString;

	private long tid;

	@JsonIgnore
	@Position(offset = 355, length = 15)
	private String tidString;

	@Position(offset = 370, length = 16)
	private String maskedPAN = "";

	@Position(offset = 386, length = 512)
	private String encryptedPAN = "";

	@Position(offset = 898, length = 5)
	private String keyIndexRSA = "";

	@Position(offset = 903, length = 2)
	private String paymentInstrument;

	@Position(offset = 905, length = 15)
	private String cartId;

	@Position(offset = 920, length = 100)
	private String bankData;

	@Position(offset = 1020, length = 1)
	private byte documentIssueDateModification;

	@Position(offset = 1021, length = 8)
	private String documentIssueDate;

	@Position(offset = 1029, length = 20)
	private String documentIssuer;

	@Position(offset = 1049, length = 1)
	private byte documentIssuerChanged;

	@Position(offset = 1050, length = 1)
	private byte documentResidenceChanged;

	@Position(offset = 1051, length = 40)
	private String documentResidenceStreet;

	@Position(offset = 1091, length = 5)
	private String documentResidenceStreetNumber;

	@Position(offset = 1096, length = 5)
	private String documentResidenceStreetApartment;

	@Position(offset = 1101, length = 40)
	private String documentResidenceArea;

	@Position(offset = 1141, length = 50)
	private String documentResidenceCity;

	@Position(offset = 1191, length = 2)
	private String documentResidenceCounty;

	@Position(offset = 1193, length = 5)
	private String documentResidencePostalCode;

	@Position(offset = 1198, length = 20)
	private String documentResidenceNation;

	@Position(offset = 1218, length = 1)
	private byte documentDomicileChanged;

	@Position(offset = 1219, length = 40)
	private String documentDomicileStreet;

	@Position(offset = 1259, length = 5)
	private String documentDomicileStreetNumber;

	@Position(offset = 1264, length = 5)
	private String documentDomicileStreetApartment;

	@Position(offset = 1269, length = 40)
	private String documentDomicileArea;

	@Position(offset = 1309, length = 50)
	private String documentDomicileCity;

	@Position(offset = 1359, length = 2)
	private String documentDomicileCounty;

	@Position(offset = 1361, length = 5)
	private String documentDomicilePostalCode;

	@Position(offset = 1366, length = 20)
	private String documentDomicileNation;

	@Position(offset = 1386, length = 64)
	private String documentIdScan;

	@Position(offset = 1450, length = 1)
	private byte documentType;

	@Position(offset = 1451, length = 20)
	private String documentNumber;

	@Position(offset = 1471, length = 8)
	private String documentValidity;

	@Position(offset = 1479, length = 1)
	private String gender = "";

	@Position(offset = 1480, length = 8)
	private String birthDate = "";

	@Position(offset = 1488, length = 50)
	private String birthPlace = "";

	// DIGICASH
	@Position(offset = 1538, length = 256)
	private String rechargeToken = "";

	@Position(offset = 1794, length = 25)
	private String wallet = "";

	@Position(offset = 1819, length = 1)
	private byte wholeDocumentChanged;
	// DIGICASH FINE

	public String getPaymentInstrument() {
		return paymentInstrument;
	}

	public void setPaymentInstrument(String paymentInstrument) {
		this.paymentInstrument = paymentInstrument;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getBankData() {
		return bankData;
	}

	public void setBankData(String bankData) {
		this.bankData = bankData;
	}

	/**
	 * @return
	 */
	public byte getZone() {
		return zone;
	}

	/**
	 * @param zone
	 */
	public void setZone(byte zone) {
		this.zone = zone;
	}

	/**
	 * @return
	 */
	public short getSalePoint() {
		return salePoint;
	}

	/**
	 * @param salePoint
	 */
	public void setSalePoint(short salePoint) {
		this.salePoint = salePoint;
	}

	/**
	 * @return
	 */
	public byte getTerminal() {
		return terminal;
	}

	/**
	 * @param terminal
	 */
	public void setTerminal(byte terminal) {
		this.terminal = terminal;
	}

	/**
	 * @return
	 */
	public byte getSalePointType() {
		return salePointType;
	}

	/**
	 * @param salePointType
	 */
	public void setSalePointType(byte salePointType) {
		this.salePointType = salePointType;
	}

	/**
	 * @return
	 */
	public byte getTerminalType() {
		return terminalType;
	}

	/**
	 * @param terminalType
	 */
	public void setTerminalType(byte terminalType) {
		this.terminalType = terminalType;
	}

	/**
	 * @return
	 */
	public short getOperator() {
		return operator;
	}

	/**
	 * @param operator
	 */
	public void setOperator(short operator) {
		this.operator = operator;
	}

	/**
	 * @return
	 */
	public byte getRechargeType() {
		return rechargeType;
	}

	/**
	 * @param rechargeType
	 */
	public void setRechargeType(byte rechargeType) {
		this.rechargeType = rechargeType;
	}

	/**
	 * @return
	 */
	public byte getRechargeMode() {
		return rechargeMode;
	}

	/**
	 * @param rechargeMode
	 */
	public void setRechargeMode(byte rechargeMode) {
		this.rechargeMode = rechargeMode;
	}

	/**
	 * @return
	 */
	public String getCode1() {
		return code1;
	}

	/**
	 * @param code1
	 */
	public void setCode1(String code1) {
		this.code1 = code1;
	}

	/**
	 * @return
	 */
	public String getCode2() {
		return code2;
	}

	/**
	 * @param code2
	 */
	public void setCode2(String code2) {
		this.code2 = code2;
	}

	/**
	 * @return
	 */
	public String getCode3() {
		return code3;
	}

	/**
	 * @param code3
	 */
	public void setCode3(String code3) {
		this.code3 = code3;
	}

	/**
	 * @return
	 */
	public String getCode4() {
		return code4;
	}

	/**
	 * @param code4
	 */
	public void setCode4(String code4) {
		this.code4 = code4;
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
	public int getAmountCurrency() {
		return amountCurrency;
	}

	/**
	 * @param amountCurrency
	 */
	public void setAmountCurrency(int amountCurrency) {
		this.amountCurrency = amountCurrency;
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
	public byte getPaymentType() {
		return paymentType;
	}

	/**
	 * @param paymentType
	 */
	public void setPaymentType(byte paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * @return
	 */
	public String getOrderFC() {
		return orderFC;
	}

	/**
	 * @param orderFC
	 */
	public void setOrderFC(String orderFC) {
		this.orderFC = orderFC;
	}

	/**
	 * @return
	 */
	public String getOrderName() {
		return orderName;
	}

	/**
	 * @param orderName
	 */
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	/**
	 * @return
	 */
	public String getOwnerFC() {
		return ownerFC;
	}

	/**
	 * @param ownerFC
	 */
	public void setOwnerFC(String ownerFC) {
		this.ownerFC = ownerFC;
	}

	/**
	 * @return
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * @param ownerName
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	/**
	 * @return
	 */
	public byte getFcReadMode() {
		return fcReadMode;
	}

	/**
	 * @param fcReadMode
	 */
	public void setFcReadMode(byte fcReadMode) {
		this.fcReadMode = fcReadMode;
	}

	/**
	 * @return
	 */
	public short getCheckSum() {
		return checkSum;
	}

	/**
	 * @param checkSum
	 */
	public void setCheckSum(short checkSum) {
		this.checkSum = checkSum;
	}

	public String getCheckSumString() {
		return checkSumString;
	}

	public void setCheckSumString(String checkSumString) {
		this.checkSumString = checkSumString;
	}

	/**
	 * Restituisce la lunghezza dell'array che deve contenere il body del messaggio
	 *
	 * @return
	 */
	@JsonIgnore
	public int getLength() {
		return LENGTH;
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
		this.tid = Long.parseLong(tidString);
	}

	/**
	 * @return the maskedPAN
	 */
	public String getMaskedPAN() {
		return maskedPAN;
	}

	/**
	 * @param maskedPAN
	 *            the maskedPAN to set
	 */
	public void setMaskedPAN(String maskedPAN) {
		this.maskedPAN = maskedPAN;
	}

	/**
	 * @return the encryptedPAN
	 */
	public String getEncryptedPAN() {
		return encryptedPAN;
	}

	/**
	 * @param encryptedPAN
	 *            the encryptedPAN to set
	 */
	public void setEncryptedPAN(String encryptedPAN) {
		this.encryptedPAN = encryptedPAN;
	}

	/**
	 * @return the keyIndexRSA
	 */
	public String getKeyIndexRSA() {
		return keyIndexRSA;
	}

	/**
	 * @param keyIndexRSA
	 *            the keyIndexRSA to set
	 */
	public void setKeyIndexRSA(String keyIndexRSA) {
		this.keyIndexRSA = keyIndexRSA;
	}

	public byte getDocumentIssueDateModification() {
		return documentIssueDateModification;
	}

	public void setDocumentIssueDateModification(byte documentIssueDateModification) {
		this.documentIssueDateModification = documentIssueDateModification;
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

	public byte getDocumentIssuerChanged() {
		return documentIssuerChanged;
	}

	public void setDocumentIssuerChanged(byte documentIssuerChanged) {
		this.documentIssuerChanged = documentIssuerChanged;
	}

	public byte getDocumentResidenceChanged() {
		return documentResidenceChanged;
	}

	public void setDocumentResidenceChanged(byte documentResidenceChanged) {
		this.documentResidenceChanged = documentResidenceChanged;
	}

	public String getDocumentResidenceStreet() {
		return documentResidenceStreet;
	}

	public void setDocumentResidenceStreet(String documentResidenceStreet) {
		this.documentResidenceStreet = documentResidenceStreet;
	}

	public String getDocumentResidenceStreetNumber() {
		return documentResidenceStreetNumber;
	}

	public void setDocumentResidenceStreetNumber(String documentResidenceStreetNumber) {
		this.documentResidenceStreetNumber = documentResidenceStreetNumber;
	}

	public String getDocumentResidenceStreetApartment() {
		return documentResidenceStreetApartment;
	}

	public void setDocumentResidenceStreetApartment(String documentResidenceStreetApartment) {
		this.documentResidenceStreetApartment = documentResidenceStreetApartment;
	}

	public String getDocumentResidenceArea() {
		return documentResidenceArea;
	}

	public void seDocumentResidenceArea(String documentResidenceArea) {
		this.documentResidenceArea = documentResidenceArea;
	}

	public String getDocumentResidenceCity() {
		return documentResidenceCity;
	}

	public void setDocumentResidenceCity(String documentResidenceCity) {
		this.documentResidenceCity = documentResidenceCity;
	}

	public String getDocumentResidenceCounty() {
		return documentResidenceCounty;
	}

	public void setDocumentResidenceCounty(String documentResidenceCounty) {
		this.documentResidenceCounty = documentResidenceCounty;
	}

	public String getDocumentResidencePostalCode() {
		return documentResidencePostalCode;
	}

	public void setDocumentResidencePostalCode(String documentResidencePostalCode) {
		this.documentResidencePostalCode = documentResidencePostalCode;
	}

	public String getDocumentResidenceNation() {
		return documentResidenceNation;
	}

	public void setDocumentResidenceNation(String documentResidenceNation) {
		this.documentResidenceNation = documentResidenceNation;
	}

	public String getDocumentDomicileStreet() {
		return documentDomicileStreet;
	}

	public void setDocumentDomicileStreet(String documentDomicileStreet) {
		this.documentDomicileStreet = documentDomicileStreet;
	}

	public String getDocumentDomicileStreetApartment() {
		return documentDomicileStreetApartment;
	}

	public void setDocumentDomicileStreetApartment(String documentDomicileStreetApartment) {
		this.documentDomicileStreetApartment = documentDomicileStreetApartment;
	}

	public String getDocumentDomicileArea() {
		return documentDomicileArea;
	}

	public void setDocumentDomicileArea(String documentDomicileArea) {
		this.documentDomicileArea = documentDomicileArea;
	}

	public String getDocumentDomicileCity() {
		return documentDomicileCity;
	}

	public void setDocumentDomicileCity(String documentDomicileCity) {
		this.documentDomicileCity = documentDomicileCity;
	}

	public String getDocumentDomicileCounty() {
		return documentDomicileCounty;
	}

	public void setDocumentDomicileCounty(String documentDomicileCounty) {
		this.documentDomicileCounty = documentDomicileCounty;
	}

	public String getDocumentDomicileStreetNumber() {
		return documentDomicileStreetNumber;
	}

	public void setDocumentDomicileStreetNumber(String documentDomicileStreetNumber) {
		this.documentDomicileStreetNumber = documentDomicileStreetNumber;
	}

	public String getDocumentDomicilePostalCode() {
		return documentDomicilePostalCode;
	}

	public void setDocumentDomicilePostalCode(String documentDomicilePostalCode) {
		this.documentDomicilePostalCode = documentDomicilePostalCode;
	}

	public String getDocumentDomicileNation() {
		return documentDomicileNation;
	}

	public void setDocumentDomicileNation(String documentDomicileNation) {
		this.documentDomicileNation = documentDomicileNation;
	}

	public void setDocumentResidenceArea(String documentResidenceArea) {
		this.documentResidenceArea = documentResidenceArea;
	}

	public byte getDocumentDomicileChanged() {
		return documentDomicileChanged;
	}

	public void setDocumentDomicileChanged(byte documentDomicileChanged) {
		this.documentDomicileChanged = documentDomicileChanged;
	}

	public String getDocumentIdScan() {
		return documentIdScan;
	}

	public void setDocumentIdScan(String documentIdScan) {
		this.documentIdScan = documentIdScan;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public byte getWholeDocumentChanged() {
		return wholeDocumentChanged;
	}

	public void setWholeDocumentChanged(byte wholeDocumentChanged) {
		this.wholeDocumentChanged = wholeDocumentChanged;
	}

	public String getWallet() {
		return wallet;
	}

	public void setWallet(String wallet) {
		this.wallet = wallet;
	}

	public String getRechargeToken() {
		return rechargeToken;
	}

	public void setRechargeToken(String rechargeToken) {
		this.rechargeToken = rechargeToken;
	}
}
