package com.mooney.devops.testing.utility.converter.udp.business.msg.recharges;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mooney.devops.testing.utility.converter.udp.business.common.Position;
import com.mooney.devops.testing.utility.converter.udp.business.msg.FeesRecharges;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;
import com.vipera.sisal.retefisica.common.business.interfaces.IParsableObject;

/**
 * @author #p4r51f4! on 29/06/16
 */
public class RVRBody_8423 implements IBusinessMsgBody, IParsableObject {
	// RESPONSE - VERIFY - SELLING - REGISTRATION
	private static final long serialVersionUID = -719238363326696926L;

	@JsonIgnore
	public static final int LENGTH = 892;

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
	private String resultDescription;

	@Position(offset = 197, length = 500)
	private String data;

	@Position(offset = 697, length = 15)
	private byte[] cartId;

	/*--- DescrizioneAggi -> (offset = 712, length = 180) ---*/
	List<FeesRecharges> fees;
	/*--- END -> DescrizioneAggi ---*/

	private List<String> extraList;

	public List<FeesRecharges> getFees() {
		return fees;
	}

	public void setFees(List<FeesRecharges> fees) {
		this.fees = fees;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public byte getFeeType() {
		return feeType;
	}

	public void setFeeType(byte feeType) {
		this.feeType = feeType;
	}

	public int getPremium() {
		return premium;
	}

	public void setPremium(int premium) {
		this.premium = premium;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getResultDescription() {
		return resultDescription;
	}

	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}

	public int getSalePointFee() {
		return salePointFee;
	}

	public void setSalePointFee(int salePointFee) {
		this.salePointFee = salePointFee;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getSisalFee() {
		return sisalFee;
	}

	public void setSisalFee(int sisalFee) {
		this.sisalFee = sisalFee;
	}

	@JsonIgnore
	public int getLength() {

		return LENGTH;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RVRBody_8423 [tid=").append(tid).append(", tidString=").append(tidString).append(", amount=").append(amount).append(", premium=").append(premium).append(", salePointFee=").append(salePointFee).append(", sisalFee=").append(sisalFee).append(", feeType=").append(feeType).append(", balance=").append(balance).append(", result=").append(result).append(", resultDescription=").append(resultDescription).append(", data=").append(data).append(", cartId=").append(Arrays.toString(cartId)).append(", fees=").append(fees).append(", extraList=").append(extraList).append("]");
		return builder.toString();
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
		this.tidString = String.format("%015d", this.tid);
	}

	@JsonIgnore
	public String getTidString() {
		return tidString;
	}

	public void setTidString(String tidString) {
		this.tidString = tidString;
	}

	public List<String> getExtraList() {
		return extraList;
	}

	public void setExtraList(List<String> extraList) {
		this.extraList = extraList;
	}

	public byte[] getCartId() {
		return cartId;
	}

	public void setCartId(byte[] cartId) {
		this.cartId = cartId;
	}

}
