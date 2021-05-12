package com.mooney.devops.testing.utility.converter.udp.business.parsers.reprint;

import com.mooney.devops.testing.utility.converter.udp.business.exception.RuntimeParserException;
import com.mooney.devops.testing.utility.converter.udp.business.msg.reprint.RPBody_6228;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.BodyParser;
import com.vipera.sisal.retefisica.common.business.interfaces.IParsableObject;

/**
 * Created by ciccio on 13/05/16.
 */
public class RPBodyParser_6228 extends BodyParser {
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
		return new RPBody_6228();
	}

}
