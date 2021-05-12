package com.mooney.devops.testing.utility.converter.udp.business.parsers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mooney.devops.testing.utility.converter.udp.business.common.Convert;
import com.mooney.devops.testing.utility.converter.udp.business.msg.DefaultMsgHeader;
import com.vipera.sisal.retefisica.common.utils.DateUtils;

/**
 * @author
 * @version
 * @created
 */
public class DefaultMsgHeaderParser {
	private static final Logger logger = LoggerFactory.getLogger(DefaultMsgHeaderParser.class);

	/**
	 *
	 */
	public static final int HEADER_SIZE = 24;

	/**
	 *
	 */
	public static final int LUNGHEZZA_OFF = 0;

	/**
	 *
	 */
	public static final int LUNGHEZZA_LEN = 2;

	/**
	 *
	 */
	public static final int SENDER_GEO_ID_OFFSET = 2;

	/**
	 *
	 */
	public static final int SENDER_GEO_ID_LENGTH = 1;

	/**
	 *
	 */
	public static final int SENDER_TERMINAL_ID_OFFSET = 3;

	/**
	 *
	 */
	public static final int SENDER_TERMINAL_ID_LENGTH = 2;

	/**
	 *
	 */
	public static final int SESSION_ID_FROM_OFFSET = 5;

	/**
	 *
	 */
	public static final int SESSION_ID_FROM_LENGTH = 1;

	/**
	 *
	 */
	public static final int RECEIVER_GEO_ID_OFFSET = 6;

	/**
	 *
	 */
	public static final int RECEIVER_GEO_ID_LENGTH = 1;

	/**
	 *
	 */
	public static final int RECEIVER_TERMINAL_ID_OFFSET = 7;

	/**
	 *
	 */
	public static final int RECEIVER_TERMINAL_ID_LENGTH = 2;

	/**
	 *
	 */
	public static final int SESSION_ID_TO_OFFSET = 9;

	/**
	 *
	 */
	public static final int SESSION_ID_TO_LENGTH = 1;

	/**
	 *
	 */
	public static final int MESSAGE_SEQ_NUM_OFFSET = 10;

	/**
	 *
	 */
	public static final int MESSAGE_SEQ_NUM_LENGTH = 1;

	/**
	 *
	 */
	public static final int PRIORITY_OFFSET = 11;

	/**
	 *
	 */
	public static final int PRIORITY_LENGTH = 1;

	/**
	 *
	 */
	public static final int TIME_OFFSET = 12;

	/**
	 *
	 */
	public static final int TIME_LENGTH = 8;

	/**
	 *
	 */
	public static final int RECORD_CODE_OFFSET = 20;

	/**
	 *
	 */
	public static final int RECORD_CODE_LENGTH = 2;

	/**
	 *
	 */
	public static final int RECORD_STATE_OFFSET = 22;

	/**
	 *
	 */
	public static final int RECORD_STATE_LENGTH = 2;

	/**
	 *
	 */
	public DefaultMsgHeaderParser() {

	}

	/**
	 *
	 * @param header
	 * @return
	 */
	public byte[] toBytes(DefaultMsgHeader header) {

		byte[] headerBytes = new byte[HEADER_SIZE];

		System.arraycopy(Convert.numberToByteArray(header.getLength(), 2), 0, headerBytes, 0, 2);

		headerBytes[2] = Convert.shortToByte(header.getSenderGEOId());

		System.arraycopy(Convert.numberToByteArray(header.getSenderTerminalId(), 2), 0, headerBytes, 3, 2);

		headerBytes[5] = Convert.shortToByte(header.getSessionIdFrom());

		headerBytes[6] = Convert.shortToByte(header.getReceiverGEOId());

		System.arraycopy(Convert.numberToByteArray(header.getReceiverTerminalId(), 2), 0, headerBytes, 7, 2);

		headerBytes[9] = Convert.shortToByte(header.getSessionIdTo());

		headerBytes[10] = Convert.shortToByte(header.getMessageSeqNo());

		headerBytes[11] = Convert.shortToByte(header.getPriority());

		if (header.getTime() != null)
			System.arraycopy(DateUtils.getByteArrayDate(header.getTime()), 0, headerBytes, 12, 8);

		System.arraycopy(Convert.numberToByteArray(header.getRecordCode(), 2), 0, headerBytes, 20, 2);

		System.arraycopy(Convert.numberToByteArray(header.getRecordState(), 2), 0, headerBytes, 22, 2);

		return headerBytes;
	}

	/**
	 *
	 * @param h
	 * @return
	 */
	public DefaultMsgHeader toObject(byte[] h) {
		DefaultMsgHeader header = new DefaultMsgHeader();

		header.setLength(Convert.byteToShort(this.getHeaderField(h, LUNGHEZZA_OFF, 2)));
		byte[] data = this.getHeaderField(h, SENDER_GEO_ID_OFFSET, SENDER_GEO_ID_LENGTH);
		if (data != null) {
			header.setSenderGEOId(data[0]);
		}
		header.setSenderTerminalId(Convert.byteToInt(this.getHeaderField(h, SENDER_TERMINAL_ID_OFFSET, SENDER_TERMINAL_ID_LENGTH)));

		data = this.getHeaderField(h, SESSION_ID_FROM_OFFSET, SESSION_ID_FROM_LENGTH);
		if (data != null) {
			header.setSessionIdFrom(data[0]);
		}

		data = this.getHeaderField(h, RECEIVER_GEO_ID_OFFSET, RECEIVER_GEO_ID_LENGTH);
		if (data != null) {
			header.setReceiverGEOId(data[0]);
		}
		header.setReceiverTerminalId(Convert.byteToInt(this.getHeaderField(h, RECEIVER_TERMINAL_ID_OFFSET, RECEIVER_TERMINAL_ID_LENGTH)));

		data = this.getHeaderField(h, SESSION_ID_TO_OFFSET, SESSION_ID_TO_LENGTH);
		if (data != null) {
			header.setSessionIdTo(data[0]);
		}
		header.setMessageSeqNo(Convert.byteToShort(this.getHeaderField(h, MESSAGE_SEQ_NUM_OFFSET, MESSAGE_SEQ_NUM_LENGTH)));
		data = this.getHeaderField(h, PRIORITY_OFFSET, PRIORITY_LENGTH);
		if (data != null) {
			header.setPriority(data[0]);
		}
		header.setTime(DateUtils.getDate(this.getHeaderField(h, TIME_OFFSET, TIME_LENGTH)));

		logger.debug("TIMESTAMP={}", header.getTime());
		logger.debug("MSN={}", header.getMessageSeqNo());
		header.setRecordCode(Convert.byteToShort(this.getHeaderField(h, RECORD_CODE_OFFSET, RECORD_CODE_LENGTH)));

		int msgStatus = Convert.byteToInt(this.getHeaderField(h, RECORD_STATE_OFFSET, RECORD_STATE_LENGTH));

		if (msgStatus > 32768)
			msgStatus = msgStatus - 65536;

		header.setRecordState(msgStatus);

		// logger.debug("DefaultMsgHeaderParser - toObject - header =
		// ["+header+"]");
		return header;
	}

	/**
	 * Ricava i byte del msg a partire da un offset, per una certa lunghezza (num. di byte)
	 *
	 * @return bytes relativi al campo estratto
	 */
	private byte[] getHeaderField(byte[] buf, int offset, int count) {
		byte[] ret = null;
		if (HEADER_SIZE > offset) {
			ret = new byte[count];
			System.arraycopy(buf, offset, ret, 0, count);
		}
		return ret;
	}

	/**
	 *
	 * @param buf
	 * @return
	 */
	public byte[] getHeader(byte[] buf) {
		int offset = 0;
		int count = 24;
		byte[] ret = new byte[count];

		for (int i = 0; i < count; i++) {
			ret[i] = buf[offset + i];
		}
		return ret;
	}

}