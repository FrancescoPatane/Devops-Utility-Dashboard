package com.mooney.devops.testing.utility.converter.udp.business.msg.payments;

import java.util.List;

import com.mooney.devops.testing.utility.converter.udp.business.common.Position;
import com.mooney.devops.testing.utility.converter.udp.business.msg.TransactionBean;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;
import com.vipera.sisal.retefisica.common.business.interfaces.IParsableObject;

/**
 * @author #p4r51f4!
 */
public class RCBody_6626 implements IBusinessMsgBody, IParsableObject {
	// REQUEST - CONFIRM - PAYMENT or TICKETING
	private static final long serialVersionUID = 1L;

	private static final int LENGTH = 1655;

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

	@Position(offset = 6, length = 15)
	private String cartId;

	@Position(offset = 21, length = 2)
	private String paymentInstrument;

	/*--- Elenco Transazioni -> (offset = 23, length = 1530) ---*/ List<TransactionBean> transactionList;
	// List<TransactionBean> transactionList;
	/*--- Fine Elenco Transazioni ---*/

	@Position(offset = 1553, length = 100)
	private String bankData;

	@Position(offset = 1653, length = 2)
	private String summCksString;

	@Position(offset = 1653, length = 2)
	private short summCks;

	public String getBankData() {
		return bankData;
	}

	public void setBankData(String bankData) {
		this.bankData = bankData;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getPaymentInstrument() {
		return paymentInstrument;
	}

	public void setPaymentInstrument(String paymentInstrument) {
		this.paymentInstrument = paymentInstrument;
	}

	public short getSalePoint() {
		return salePoint;
	}

	public void setSalePoint(short salePoint) {
		this.salePoint = salePoint;
	}

	public byte getSalePointType() {
		return salePointType;
	}

	public void setSalePointType(byte salePointType) {
		this.salePointType = salePointType;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public short getSummCks() {
		return summCks;
	}

	public void setSummCks(short summCks) {
		this.summCks = summCks;
	}

	public String getSummCksString() {
		return summCksString;
	}

	public void setSummCksString(String summCksString) {
		this.summCksString = summCksString;
	}

	public byte getTerminal() {
		return terminal;
	}

	public void setTerminal(byte terminal) {
		this.terminal = terminal;
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

	public List<TransactionBean> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<TransactionBean> transactionList) {
		this.transactionList = transactionList;
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
	public void setTid(long tid) {

	}

}
