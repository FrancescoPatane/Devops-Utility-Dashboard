package com.mooney.devops.testing.utility.converter.udp.business.parsers.payments;

import com.mooney.devops.testing.utility.converter.udp.business.exception.RuntimeParserException;
import com.mooney.devops.testing.utility.converter.udp.business.msg.payments.RVBody_7542;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.BodyParser;
import com.vipera.sisal.retefisica.common.business.interfaces.IParsableObject;

/**
 *
 * @author spinellilu
 */
public class RVBodyParser_7542 extends BodyParser {

	private static final int BODY_SIZE = 2;

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
		return new RVBody_7542();
	}

	protected int getBodyLength() {
		return BODY_SIZE;
	}
}
