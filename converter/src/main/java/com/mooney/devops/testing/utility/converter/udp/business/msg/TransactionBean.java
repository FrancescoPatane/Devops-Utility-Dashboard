package com.mooney.devops.testing.utility.converter.udp.business.msg;

import com.mooney.devops.testing.utility.converter.udp.business.common.Position;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;
import com.vipera.sisal.retefisica.common.business.interfaces.IParsableObject;

/**
 * Created by #p4r51f4! on 13/06/16.
 */
public class TransactionBean implements IBusinessMsgBody, IParsableObject {
	private static final long serialVersionUID = 1L;

	public static final int LENGTH = 153;

	private long tid;

	@Position(offset = 0, length = 15)
	private String tidString = "";

	@Position(offset = 15, length = 4)
	private int amount;

	@Position(offset = 19, length = 4)
	private long feeSalePoint;

	@Position(offset = 23, length = 4)
	private long feeSisal;

	@Position(offset = 27, length = 1)
	private byte paymentChoice;

	@Position(offset = 28, length = 16)
	private String fiscalCode = "";

	@Position(offset = 44, length = 1)
	private byte readModeCf;

	@Position(offset = 45, length = 50)
	private String surname = "";

	@Position(offset = 95, length = 50)
	private String name = "";

	@Position(offset = 145, length = 8)
	private String birthday = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public long getFeeSalePoint() {
		return feeSalePoint;
	}

	public void setFeeSalePoint(long feeSalePoint) {
		this.feeSalePoint = feeSalePoint;
	}

	public long getFeeSisal() {
		return feeSisal;
	}

	public void setFeeSisal(long feeSisal) {
		this.feeSisal = feeSisal;
	}

	public String getFiscalCode() {
		return fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}

	public byte getPaymentChoice() {
		return paymentChoice;
	}

	public void setPaymentChoice(byte paymentChoice) {
		this.paymentChoice = paymentChoice;
	}

	public byte getReadModeCf() {
		return readModeCf;
	}

	public void setReadModeCf(byte readModeCf) {
		this.readModeCf = readModeCf;
	}

	public String getTidString() {
		return tidString;
	}

	public void setTidString(String tidString) {
		this.tidString = tidString;
	}

	@Override
	public int getLength() {
		return LENGTH;
	}

	@Override
	public long getTid() {
		return Long.valueOf(tidString);
	}

	@Override
	public void setTid(long tid) {
		this.tid = tid;
		this.tidString = String.format("%015d", this.tid);
	}
}
