package com.mooney.devops.testing.utility.converter.udp.business.builders;

import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsg;

/**
 * @author spinellilu
 */
public class BusinessMsgBuilderDirector {
	private IBusinessMsgBuilder businessMsgBuilder = null;

	public BusinessMsgBuilderDirector(IBusinessMsgBuilder businessMsgBuilder) {
		this.businessMsgBuilder = businessMsgBuilder;
	}

	public void buildBusinessMsg() throws Exception {
		businessMsgBuilder.buildHeader();
		businessMsgBuilder.buildBody();
	}

	public IBusinessMsg getBusinessMsg() {
		return businessMsgBuilder.getBusinessMsg();
	}
}
