/**
 *
 */
package com.mooney.devops.testing.utility.converter.udp.business.msg.recharges;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mooney.devops.testing.utility.converter.udp.business.common.Position;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;

/**
 * @author Luigi Spinelli
 */
public class RVBody_8518 implements IBusinessMsgBody {
    // REQUEST - VERIFY - SELLING
    private static final long serialVersionUID = -1619334568845660737L;

    @JsonIgnore
    private static final int LENGTH = 1336;

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

    @Position(offset = 62, length = 4)
    private int amount;

    @Position(offset = 66, length = 4)
    private int salePointFee;

    @Position(offset = 70, length = 4)
    private int sisalFee;

    @Position(offset = 74, length = 1)
    private byte feeType;

    @Position(offset = 75, length = 1)
    private byte paymentType;

    @Position(offset = 76, length = 16)
    private String orderFC = "";

    @Position(offset = 92, length = 100)
    private String orderName = "";

    @Position(offset = 192, length = 16)
    private String ownerFC = "";

    @Position(offset = 208, length = 100)
    private String ownerName = "";

    @Position(offset = 308, length = 1)
    private byte fcReadMode;

    @Position(offset = 309, length = 2)
    private short checkSum;

    @Position(offset = 309, length = 2)
    private String checkSumString;

    @Position(offset = 311, length = 16)
    private String maskedPAN = "";

    @Position(offset = 327, length = 512)
    private String encryptedPAN = "";

    @Position(offset = 839, length = 5)
    private String keyIndexRSA = "";

    @Position(offset = 844, length = 140)
    private String rechargeReason = "";

    @Position(offset = 984, length = 1)
    private String gender = "";

    @Position(offset = 985, length = 8)
    private String birthDate = "";

    @Position(offset = 993, length = 50)
    private String birthPlace = "";

    @Position(offset = 1043, length = 1)
    private byte documentType;

    @Position(offset = 1044, length = 20)
    private String documentNumber;

    @Position(offset = 1064, length = 8)
    private String documentValidity;

    @Position(offset = 1072, length = 256)
    private String rechargeToken;

    @Position(offset = 1328, length = 8)
    private String issueDate;

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
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
     * @return the productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * @return
     */
    @Override
    @JsonIgnore
    public long getTid() {
        return 0;
    }

    @Override
    public void setTid(long tid) {
        // TODO Auto-generated method stub

    }

    /**
     * @return the maskedPAN
     */
    public String getMaskedPAN() {
        return maskedPAN;
    }

    /**
     * @param maskedPAN the maskedPAN to set
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
     * @param encryptedPAN the encryptedPAN to set
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
     * @param keyIndexRSA the keyIndexRSA to set
     */
    public void setKeyIndexRSA(String keyIndexRSA) {
        this.keyIndexRSA = keyIndexRSA;
    }

    public String getRechargeReason() {
        return rechargeReason;
    }

    public void setRechargeReason(String rechargeReason) {
        this.rechargeReason = rechargeReason;
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

    public String getRechargeToken() {
        return rechargeToken;
    }

    public void setRechargeToken(String rechargeToken) {
        this.rechargeToken = rechargeToken;
    }

}
