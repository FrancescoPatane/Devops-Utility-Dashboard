package com.mooney.devops.testing.utility.converter.udp.business.msg;

import java.io.Serializable;

import com.mooney.devops.testing.utility.converter.udp.business.common.Position;
import com.vipera.sisal.retefisica.common.business.interfaces.IParsableObject;

/**
 * Created by musone on 17/03/17.
 */
public class FeesRecharges implements IParsableObject, Serializable {
	private static final long serialVersionUID = 1L;

	public static final int LENGTH = 18;

	@Position(offset = 0, length = 2)
	private String paymentInstrument;

	@Position(offset = 2, length = 4)
	private long feeSalePoint;

	@Position(offset = 6, length = 4)
	private long feeSisal;

	@Position(offset = 10, length = 4)
	private long maxAmount;

	@Position(offset = 14, length = 4)
	private int premium;

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

	public long getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(long maxAmount) {
		this.maxAmount = maxAmount;
	}

	public String getPaymentInstrument() {
		return paymentInstrument;
	}

	public void setPaymentInstrument(String paymentInstrument) {
		this.paymentInstrument = paymentInstrument;
	}

	public int getPremium() {
		return premium;
	}

	public void setPremium(int premium) {
		this.premium = premium;
	}

	@Override
	public int getLength() {
		return LENGTH;
	}
}
