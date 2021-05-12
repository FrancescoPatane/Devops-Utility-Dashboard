package com.mooney.devops.testing.utility.converter.udp.business.msg.reprint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mooney.devops.testing.utility.converter.udp.business.common.Position;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;

/**
 * Created by ciccio on 13/05/16.
 */
public class RPBody_6228 implements IBusinessMsgBody {
	// REQUEST - REPRINT
	private static final long serialVersionUID = -1619334568845660737L;

	private long tid;

	@Position(offset = 0, length = 1)
	private byte zone;

	@Position(offset = 1, length = 2)
	private short salePoint;

	public byte getZone() {
		return zone;
	}

	public void setZone(byte zone) {
		this.zone = zone;
	}

	public short getSalePoint() {
		return salePoint;
	}

	public void setSalePoint(short salePoint) {
		this.salePoint = salePoint;
	}

	@JsonIgnore
	private static final int LENGTH = 92;

	@Override
	public long getTid() {
		return this.tid;
	}

	@Override
	public void setTid(long tid) {
	}

	@Override
	public int getLength() {
		return this.LENGTH;
	}

}
