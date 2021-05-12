package com.mooney.devops.testing.utility.converter.udp.business.msg;

import java.io.Serializable;

public class AdditionalInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String description;

	private long startDatevalidity;

	private long endDatevalidity;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the startDatevalidity
	 */
	public long getStartDatevalidity() {
		return startDatevalidity;
	}

	/**
	 * @param startDatevalidity
	 *            the startDatevalidity to set
	 */
	public void setStartDatevalidity(long startDatevalidity) {
		this.startDatevalidity = startDatevalidity;
	}

	/**
	 * @return the endDatevalidity
	 */
	public long getEndDatevalidity() {
		return endDatevalidity;
	}

	/**
	 * @param endDatevalidity
	 *            the endDatevalidity to set
	 */
	public void setEndDatevalidity(long endDatevalidity) {
		this.endDatevalidity = endDatevalidity;
	}

	public String printBean() {
		return printBean(" ");
	}

	public String printBean(String sep) {
		StringBuffer sb = new StringBuffer();

		sb.append("Description").append(sep).append(description).append(sep).append("StartDatevalidity").append(sep).append(startDatevalidity).append(sep)
				.append("EndDatevalidity").append(sep).append(endDatevalidity);

		return sb.toString();
	}

}
