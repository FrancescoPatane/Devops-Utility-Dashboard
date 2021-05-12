package com.mooney.devops.testing.utility.converter.udp.business.parsers;

import com.mooney.devops.testing.utility.converter.udp.business.exception.RuntimeParserException;
import com.mooney.devops.testing.utility.converter.udp.business.msg.TransactionBean;
import com.vipera.sisal.retefisica.common.business.interfaces.IParsableObject;

/**
 * Created by #p4r51f4! on 13/06/16.
 */
public class TransactionsParser extends BodyParser {

	@Override
	protected Object getParam(byte[] buf, Class cls, String fName, IParsableObject obj) throws RuntimeParserException {
		return null;
	}

	@Override
	protected byte[] getBytes(Object result, Class cls, String fName) throws RuntimeParserException {
		return new byte[0];
	}

	@Override
	public IParsableObject getObject() {
		return new TransactionBean();
	}

}
