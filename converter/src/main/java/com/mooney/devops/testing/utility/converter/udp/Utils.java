package com.mooney.devops.testing.utility.converter.udp;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.mooney.devops.testing.utility.converter.udp.business.common.Convert;
import com.mooney.devops.testing.utility.converter.udp.business.msg.DefaultMsgHeader;


public class Utils {

    public static final int HEADER_SIZE = 24;
    public static final int LUNGHEZZA_OFF = 0;
    public static final int LUNGHEZZA_LEN = 2;
    public static final int SENDER_GEO_ID_OFFSET = 2;
    public static final int SENDER_GEO_ID_LENGTH = 1;
    public static final int SENDER_TERMINAL_ID_OFFSET = 3;
    public static final int SENDER_TERMINAL_ID_LENGTH = 2;
    public static final int SESSION_ID_FROM_OFFSET = 5;
    public static final int SESSION_ID_FROM_LENGTH = 1;
    public static final int RECEIVER_GEO_ID_OFFSET = 6;
    public static final int RECEIVER_GEO_ID_LENGTH = 1;
    public static final int RECEIVER_TERMINAL_ID_OFFSET = 7;
    public static final int RECEIVER_TERMINAL_ID_LENGTH = 2;
    public static final int SESSION_ID_TO_OFFSET = 9;
    public static final int SESSION_ID_TO_LENGTH = 1;
    public static final int MESSAGE_SEQ_NUM_OFFSET = 10;
    public static final int MESSAGE_SEQ_NUM_LENGTH = 1;
    public static final int PRIORITY_OFFSET = 11;
    public static final int PRIORITY_LENGTH = 1;
    public static final int TIME_OFFSET = 12;
    public static final int TIME_LENGTH = 8;
    public static final int RECORD_CODE_OFFSET = 20;
    public static final int RECORD_CODE_LENGTH = 2;
    public static final int RECORD_STATE_OFFSET = 22;
    public static final int RECORD_STATE_LENGTH = 2;

    private Utils() {
    }

    public static Date getDate(byte[] byteDate) {
        int year = (byteDate[1] << 8) + (byteDate[0] & 255);
        int month = byteDate[2] & 255;
        int day = byteDate[3] & 255;
        int hour = byteDate[4] & 255;
        int minute = byteDate[5] & 255;
        int second = byteDate[6] & 255;
        int cent = byteDate[7] & 255;
        Calendar calendar = new GregorianCalendar();
        calendar.set(year, month - 1, day, hour, minute, second);
        calendar.set(14, 0);
        calendar.add(14, cent * 10);
        return calendar.getTime();
    }

    public static Date parseDate(String sourceDate, String datePattern) {
        Date myDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);

        try {
            myDate = sdf.parse(sourceDate);
        } catch (ParseException var5) {
            System.out.println("DateUtils.getDate(s,d) - error while parsing date " + var5.getMessage());
        }

        return myDate;
    }

    public static byte[] getByteArrayDate(Date date) {
        byte[] ba = new byte[8];
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int year = calendar.get(1);
        int month = calendar.get(2) + 1;
        int day = calendar.get(5);
        int hour = calendar.get(11);
        int minute = calendar.get(12);
        int second = calendar.get(13);
        int millis = calendar.get(14);
        ba[0] = (byte)(year & 255);
        ba[1] = (byte)(year >> 8 & 255);
        ba[2] = (byte)(month & 255);
        ba[3] = (byte)(day & 255);
        ba[4] = (byte)(hour & 255);
        ba[5] = (byte)(minute & 255);
        ba[6] = (byte)(second & 255);
        ba[7] = (byte)(millis / 10 & 255);
        return ba;
    }

    public static byte[] getHeaderByteArray(byte[] buf) {
        int count = 24;
        byte[] ret = new byte[count];

        System.arraycopy(buf, 0, ret, 0, count);
        return ret;
    }

    public static byte[] getBodyByteArray(byte[] buf) {
        int offset = 24;
        int count = buf.length - 24;
        byte[] ret = new byte[count];

        if (count >= 0) System.arraycopy(buf, offset, ret, 0, count);
        return ret;
    }

    public static byte[] toBytes(DefaultMsgHeader header) {

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
            System.arraycopy(Utils.getByteArrayDate(header.getTime()), 0, headerBytes, 12, 8);

        System.arraycopy(Convert.numberToByteArray(header.getRecordCode(), 2), 0, headerBytes, 20, 2);

        System.arraycopy(Convert.numberToByteArray(header.getRecordState(), 2), 0, headerBytes, 22, 2);

        return headerBytes;
    }

    public static DefaultMsgHeader toObject(byte[] h) {
        DefaultMsgHeader header = new DefaultMsgHeader();

        header.setLength(Convert.byteToShort(getHeaderField(h, LUNGHEZZA_OFF, 2)));
        byte[] data = getHeaderField(h, SENDER_GEO_ID_OFFSET, SENDER_GEO_ID_LENGTH);
        if (data != null) {
            header.setSenderGEOId(data[0]);
        }
        header.setSenderTerminalId(Convert.byteToInt(getHeaderField(h, SENDER_TERMINAL_ID_OFFSET, SENDER_TERMINAL_ID_LENGTH)));

        data = getHeaderField(h, SESSION_ID_FROM_OFFSET, SESSION_ID_FROM_LENGTH);
        if (data != null) {
            header.setSessionIdFrom(data[0]);
        }

        data = getHeaderField(h, RECEIVER_GEO_ID_OFFSET, RECEIVER_GEO_ID_LENGTH);
        if (data != null) {
            header.setReceiverGEOId(data[0]);
        }
        header.setReceiverTerminalId(Convert.byteToInt(getHeaderField(h, RECEIVER_TERMINAL_ID_OFFSET, RECEIVER_TERMINAL_ID_LENGTH)));

        data = getHeaderField(h, SESSION_ID_TO_OFFSET, SESSION_ID_TO_LENGTH);
        if (data != null) {
            header.setSessionIdTo(data[0]);
        }
        header.setMessageSeqNo(Convert.byteToShort(getHeaderField(h, MESSAGE_SEQ_NUM_OFFSET, MESSAGE_SEQ_NUM_LENGTH)));
        data = getHeaderField(h, PRIORITY_OFFSET, PRIORITY_LENGTH);
        if (data != null) {
            header.setPriority(data[0]);
        }
        header.setTime(getDate(getHeaderField(h, TIME_OFFSET, TIME_LENGTH)));

        header.setRecordCode(Convert.byteToShort(getHeaderField(h, RECORD_CODE_OFFSET, RECORD_CODE_LENGTH)));

        int msgStatus = Convert.byteToInt(getHeaderField(h, RECORD_STATE_OFFSET, RECORD_STATE_LENGTH));

        if (msgStatus > 32768)
            msgStatus = msgStatus - 65536;

        header.setRecordState(msgStatus);

        // logger.debug("DefaultMsgHeaderParser - toObject - header =
        // ["+header+"]");
        return header;
    }

    private static byte[] getHeaderField(byte[] buf, int offset, int count) {
        byte[] ret = null;
        if (HEADER_SIZE > offset) {
            ret = new byte[count];
            System.arraycopy(buf, offset, ret, 0, count);
        }
        return ret;
    }

    public static byte[] concatenateByteArrays(byte[] array1, byte[] array2) {
        byte[] concatenatedArray = new byte[array1.length + array2.length];
        System.arraycopy(array1, 0, concatenatedArray, 0, array1.length);
        System.arraycopy(array2, 0, concatenatedArray, array1.length, array2.length);

        return concatenatedArray;
    }

    public static String byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits);
    }

    public static String encodeHexString(byte[] byteArray) {
        StringBuilder hexStringBuilder = new StringBuilder();
        for (byte b : byteArray) {
            hexStringBuilder.append(byteToHex(b));
        }
        return hexStringBuilder.toString();
    }
    
    public static String toHexString(byte[] ba) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < ba.length; i++)
            str.append(String.format("%x", ba[i]));
        return str.toString();
    }

    public static String fromHexString(String hex) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < hex.length(); i+=2) {
            str.append((char) Integer.parseInt(hex.substring(i, i + 2), 16));
        }
        return str.toString();
    }
    
    public static String readFile(String path, Charset encoding) throws IOException {
    	byte[] encoded = Files.readAllBytes(Paths.get(path));
    	return new String(encoded, encoding);
    }
}
