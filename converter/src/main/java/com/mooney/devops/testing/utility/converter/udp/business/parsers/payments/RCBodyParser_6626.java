package com.mooney.devops.testing.utility.converter.udp.business.parsers.payments;

import java.util.ArrayList;
import java.util.List;

import com.mooney.devops.testing.utility.converter.udp.business.exception.RuntimeParserException;
import com.mooney.devops.testing.utility.converter.udp.business.msg.TransactionBean;
import com.mooney.devops.testing.utility.converter.udp.business.msg.payments.RCBody_6626;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.BodyParser;
import com.mooney.devops.testing.utility.converter.udp.business.parsers.TransactionsParser;
import com.vipera.sisal.retefisica.common.business.interfaces.IParsableObject;

/**
 * @author spinellilu
 * @edit by #p4r51f4! on 14/04/16
 */
public class RCBodyParser_6626 extends BodyParser {
	private static final int START_OFFSET = 23;

	private static final int TOTAL_ITEMS = 10;

	@Override
	public IParsableObject parser(byte[] h) throws RuntimeParserException {
		IParsableObject newBody = super.parser(h);

		TransactionsParser txsParser = new TransactionsParser();
		List<TransactionBean> txBean = new ArrayList<TransactionBean>();
		int totalTxArrayLenght = TOTAL_ITEMS * TransactionBean.LENGTH;

		for (int i = START_OFFSET; i < totalTxArrayLenght; i = i + TransactionBean.LENGTH) {
			byte[] arrayTx = new byte[TransactionBean.LENGTH];

			System.arraycopy(h, i, arrayTx, 0, TransactionBean.LENGTH);

			TransactionBean transaction = (TransactionBean) txsParser.parser(arrayTx);

			txBean.add(transaction);
		}
		((RCBody_6626) newBody).setTransactionList(txBean);

		return newBody;
	}

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

		return new RCBody_6626();
	}

}
