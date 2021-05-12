/**
 *
 */
package com.mooney.devops.testing.utility.converter.udp.business.msg;

import java.util.Date;

import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgHeader;

/**
 * @author Luigi Spinelli This class represent a default header implementation of a business message
 *
 */
public class DefaultMsgHeader implements IBusinessMsgHeader {

	/**
	 * record's length: head + body
	 */
	private int length;

	/**
	 * sender GEO2
	 */
	// DaChiClasse
	private byte senderGEOId;

	/**
	 * sender Terminal Id
	 */
	// usiDaChiNumero
	private int senderTerminalId;

	/**
	 * from Session Id
	 */
	// DaChiSessione
	private byte sessionIdFrom;

	/**
	 * receiver GEO2 Id
	 */
	// AChiClasse
	private byte receiverGEOId;

	/**
	 * receiver Terminal Id
	 */
	// usiAChiNumero
	private int receiverTerminalId;

	/**
	 * to Session Id
	 */
	// AChiSessione
	private byte sessionIdTo;

	/**
	 * message sequence numbers
	 */
	// Msn
	private short messageSeqNo;

	/**
	 * priority or random number
	 */
	// Prio
	private byte priority;

	/**
	 * timestamp openvms - NB su tru64 long=8 byte
	 */
	// time
	private Date time;

	/**
	 * record's code
	 */
	// Codice
	private int recordCode;

	/**
	 * record's state
	 */
	// Stato
	private int recordState;

	// UDP Host (OLS)
	private String host;

	// UDP Port (OLS)
	private int port;

	/**
	 *
	 * @return
	 */
	@Override
	public int getLength() {
		return length;
	}

	/**
	 *
	 * @param length
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 *
	 * @return
	 */
	public byte getSenderGEOId() {
		return senderGEOId;
	}

	/**
	 *
	 * @param senderGEOId
	 */
	public void setSenderGEOId(byte senderGEOId) {
		this.senderGEOId = senderGEOId;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public int getSenderTerminalId() {
		return senderTerminalId;
	}

	/**
	 *
	 * @param senderTerminalId
	 */
	public void setSenderTerminalId(int senderTerminalId) {
		this.senderTerminalId = senderTerminalId;
	}

	/**
	 *
	 * @return
	 */
	public byte getSessionIdFrom() {
		return sessionIdFrom;
	}

	/**
	 *
	 * @param sessionIdFrom
	 */
	public void setSessionIdFrom(byte sessionIdFrom) {
		this.sessionIdFrom = sessionIdFrom;
	}

	/**
	 *
	 * @return
	 */
	public byte getReceiverGEOId() {
		return receiverGEOId;
	}

	/**
	 *
	 * @param receiverGEOId
	 */
	public void setReceiverGEOId(byte receiverGEOId) {
		this.receiverGEOId = receiverGEOId;
	}

	/**
	 *
	 * @return
	 */
	public int getReceiverTerminalId() {
		return receiverTerminalId;
	}

	/**
	 *
	 * @param receiverTerminalId
	 */
	public void setReceiverTerminalId(int receiverTerminalId) {
		this.receiverTerminalId = receiverTerminalId;
	}

	/**
	 *
	 * @return
	 */
	public byte getSessionIdTo() {
		return sessionIdTo;
	}

	/**
	 *
	 * @param sessionIdTo
	 */
	public void setSessionIdTo(byte sessionIdTo) {
		this.sessionIdTo = sessionIdTo;
	}

	@Override
	public short getMessageSeqNo() {
		return messageSeqNo;
	}

	/**
	 *
	 * @param messageSeqNo
	 */
	public void setMessageSeqNo(short messageSeqNo) {
		this.messageSeqNo = messageSeqNo;
	}

	/**
	 *
	 * @return
	 */
	public byte getPriority() {
		return priority;
	}

	/**
	 *
	 * @param priority
	 */
	public void setPriority(byte priority) {
		this.priority = priority;
	}

	@Override
	public int getRecordCode() {
		return recordCode;
	}

	/**
	 *
	 * @param recordCode
	 */
	public void setRecordCode(int recordCode) {
		this.recordCode = recordCode;
	}

	/**
	 *
	 * @return
	 */
	public int getRecordState() {
		return recordState;
	}

	/**
	 *
	 * @param recordState
	 */
	public void setRecordState(int recordState) {
		this.recordState = recordState;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Generic Msg HEADER: ");
		sb.append("\n");

		sb.append("Length = " + this.length).append("\n");
		sb.append("Msn = " + this.messageSeqNo).append("\n");
		sb.append("Priority = " + this.priority).append("\n");
		sb.append("ReceiverGEOId = " + this.receiverGEOId).append("\n");
		sb.append("ReceiverTerminalId = " + this.receiverTerminalId).append("\n");
		sb.append("RecordCode = " + this.recordCode).append("\n");
		sb.append("RecordState = " + this.recordState).append("\n");
		sb.append("SenderGEOId = " + this.senderGEOId).append("\n");
		sb.append("SenderTerminalId = " + this.senderTerminalId).append("\n");
		sb.append("SessionIdFrom = " + this.sessionIdFrom).append("\n");
		sb.append("SessionIdTo = " + this.sessionIdTo).append("\n");
		sb.append("Time = " + this.time).append("\n");

		return sb.toString();
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 *
	 * @return
	 */
	public String getHost() {
		return host;
	}

	/**
	 *
	 * @param host
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 *
	 * @return
	 */
	public int getPort() {
		return port;
	}

	/**
	 *
	 * @param port
	 */
	public void setPort(int port) {
		this.port = port;
	}
}
