package com.mooney.devops.testing.utility.converter.udp.business.parsers.payments;

import com.mooney.devops.testing.utility.converter.udp.business.exception.RuntimeParserException;
import com.mooney.devops.testing.utility.converter.udp.business.msg.payments.RVBody_6530;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.BodyParser;
import com.vipera.sisal.retefisica.common.business.interfaces.IParsableObject;

/**
 * @author #p4r51f4!
 */
public class RVBodyParser_6530 extends BodyParser {

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
		return new RVBody_6530();
	}

}
