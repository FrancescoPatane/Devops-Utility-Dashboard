package com.mooney.devops.testing.utility.converter.udp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mooney.devops.testing.utility.converter.udp.business.builders.BusinessMsgBuilderDirector;
import com.mooney.devops.testing.utility.converter.udp.business.builders.IBusinessMsgBuilder;
import com.mooney.devops.testing.utility.converter.udp.business.builders.RCBusinessMsgBuilder;
import com.mooney.devops.testing.utility.converter.udp.business.builders.RDGPBusinessMsgBuilder;
import com.mooney.devops.testing.utility.converter.udp.business.builders.RDOCBusinessMsgBuilder;
import com.mooney.devops.testing.utility.converter.udp.business.builders.RPBusinessMsgBuilder;
import com.mooney.devops.testing.utility.converter.udp.business.builders.RVBusinessMsgBuilder;
import com.mooney.devops.testing.utility.converter.udp.business.msg.DefaultMsgHeader;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.DefaultMsgHeaderParser;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsg;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgHeader;
import com.vipera.sisal.retefisica.common.utils.ContentConversionUtils;

@Component
public class UdpConverter {

	private static final Logger logger = LoggerFactory.getLogger(UdpConverter.class);

	private static final List<Integer> REQUEST_VERIFY = new ArrayList<>(Arrays.asList(8518, 6530, 6532, 7420, 8422, 6332, 6342, 7542, 6630));
	private static final List<Integer> REQUEST_CONFIRM = new ArrayList<>(Arrays.asList(6626, 8626, 6726));	
	private static final List<Integer> REQUEST_REPRINT = new ArrayList<>(Arrays.asList(6228));
	private static final List<Integer> REQUEST_DIGIPAY = new ArrayList<>(Arrays.asList(8000));
	private static final List<Integer> REQUEST_DOCUMENT = new ArrayList<>(Arrays.asList(9000));



	public String convertUdpToJsonString(String udpMessage) {

		try {
			logger.info("INPUT from OLS (hexa string blueprint.xml): "+udpMessage);

			String[] res = this.convert(udpMessage);
			logger.info("HEADER: "+res[0]);
			logger.info("BODY: "+res[1]);
			return "{\"header\": " + res[0] + ", \"body\": " + res[1] + "}";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException("Error compare bundles", e); 
		}
	}

	private String[] convert(String message) throws Exception {
		logger.debug("*************** START ****************");

		String[] result = new String[2];
		result[0] = "{\"result\":\"header empty\"}";
		result[1] = "{\"result\":\"body empty\"}";

		IBusinessMsg myNewMsg = null;
		IBusinessMsgBuilder myMessageBuilder = null;

		byte[] buf;

		buf = decodeHex(message);

		logger.debug("message: "+message);

		byte[] headerByteArray = Utils.getHeaderByteArray(buf);

		DefaultMsgHeader header = Utils.toObject(headerByteArray);

		byte[] bodyByteArray = Utils.getBodyByteArray(buf);
		logger.debug(">>bodyByteArray: " + Arrays.toString(bodyByteArray));
		String encBody = Utils.encodeHexString(bodyByteArray);
		logger.debug(">>encBody: " + encBody);


		byte[] recordCodeBytes = new byte[DefaultMsgHeaderParser.RECORD_CODE_LENGTH];
		System.arraycopy(bodyByteArray, DefaultMsgHeaderParser.RECORD_CODE_OFFSET, recordCodeBytes, 0, DefaultMsgHeaderParser.RECORD_CODE_LENGTH);
		int recordCode = header.getRecordCode();
		logger.info(">> recordCode:"+recordCode);

		if (REQUEST_VERIFY.contains(recordCode)) {
			logger.debug("UDP - REQUEST_VERIFY builder");
			myMessageBuilder = new RVBusinessMsgBuilder(buf, recordCode);
		} else if (REQUEST_CONFIRM.contains(recordCode)) {
			logger.debug("UDP - REQUEST_CONFIRM builder");
			myMessageBuilder = new RCBusinessMsgBuilder(bodyByteArray, recordCode);
		} else if (REQUEST_REPRINT.contains(recordCode)) {
			logger.debug("UDP - REQUEST_REPRINT builder");
			myMessageBuilder = new RPBusinessMsgBuilder(bodyByteArray, recordCode);
		} else if (REQUEST_DIGIPAY.contains(recordCode)) {
			logger.debug("UDP - REQUEST_DIGIPAY builder");
			myMessageBuilder = new RDGPBusinessMsgBuilder(bodyByteArray, recordCode);
		} else if (REQUEST_DOCUMENT.contains(recordCode)) {
			logger.debug("UDP - REQUEST_DOCUMENT builder");
			myMessageBuilder = new RDOCBusinessMsgBuilder(bodyByteArray, recordCode);
		} else {
			throw new Exception("Unknown record code");
		}

		BusinessMsgBuilderDirector myDirector = new BusinessMsgBuilderDirector(myMessageBuilder);
		myDirector.buildBusinessMsg();
		myNewMsg = myDirector.getBusinessMsg();

		if (myNewMsg != null) {		
			logger.debug(">>body: " + myNewMsg.getClass());
			IBusinessMsgBody bodyObj = myNewMsg.getMsgBody();
			IBusinessMsgHeader headerObj = myNewMsg.getMsgHeader();
			String jsonbody = ContentConversionUtils.objectToJSON(bodyObj);
			String jsonHeader = ContentConversionUtils.objectToJSON(headerObj);

			logger.debug(">>jsonHeader: " + jsonHeader);
			logger.debug(">>jsonbody: " + jsonbody);

			logger.debug("HEADER: "+jsonHeader);
			logger.debug("BODY: "+jsonbody);

			result[0] = jsonHeader;
			result[1] = jsonbody;

		}
		else {
			logger.warn(">>jsonbody null");
		}


		return result;
	}


	private static byte[] decodeHex(final String data) throws Exception {
		return decodeHex(data.toCharArray());
	}

	public static byte[] decodeHex(final char[] data) throws Exception {

		final int len = data.length;

		if ((len & 0x01) != 0) {
			throw new Exception("Odd number of characters.");
		}

		final byte[] out = new byte[len >> 1];

		// two characters form the hex value.
		for (int i = 0, j = 0; j < len; i++) {
			int f = toDigit(data[j], j) << 4;
			j++;
			f = f | toDigit(data[j], j);
			j++;
			out[i] = (byte) (f & 0xFF);
		}

		return out;
	}

	protected static int toDigit(final char ch, final int index) throws Exception {
		final int digit = Character.digit(ch, 16);
		if (digit == -1) {
			throw new Exception("Illegal hexadecimal character " + ch + " at index " + index);
		}
		return digit;
	}

}
