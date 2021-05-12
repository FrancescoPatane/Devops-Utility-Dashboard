/**
 *
 */
package com.mooney.devops.testing.utility.converter.udp.business.msg;

import com.vipera.sisal.retefisica.common.business.interfaces.IBusinessMsgBody;

/**
 * @author Luigi Spinelli This class represent a default body implementation of a business message
 *
 */
public class DefaultMsgBody implements IBusinessMsgBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Object content;

	/**
	 *
	 * @return
	 */
	public Object getContent() {
		return content;
	}

	/**
	 *
	 * @param content
	 */
	public void setContent(Object content) {
		this.content = content;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public long getTid() {
		return 0;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTid(long tid) {
		// TODO Auto-generated method stub
	}

}
