package com.mooney.devops.testing.utility.converter.udp.business.builders;

import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsg;

/**
 *
 * @author spinellilu
 */
public interface IBusinessMsgBuilder

{

	/**
	 *
	 */
	public void buildHeader() throws Exception;

	/**
	 *
	 * @throws RuntimeParserException
	 */
	public void buildBody() throws Exception;

	/**
	 *
	 * @return
	 */
	public IBusinessMsg getBusinessMsg();
}
