package com.mooney.devops.testing.utility.converter.udp.business.msg;

import com.mooney.devops.testing.utility.converter.udp.business.common.Position;
import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;
import com.vipera.sisal.retefisica.common.business.interfaces.IParsableObject;

/**
 * Created by Parsifal on 12/12/16.
 */
public class RouteBean implements IBusinessMsgBody, IParsableObject {
	private static final long serialVersionUID = 1L;

	public static final int LENGTH = 60;

	@Position(offset = 0, length = 60)
	private String route;

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	@Override
	public long getTid() {
		return 0;
	}

	@Override
	public void setTid(long tid) {
	}

	@Override
	public int getLength() {
		return LENGTH;
	}
}
