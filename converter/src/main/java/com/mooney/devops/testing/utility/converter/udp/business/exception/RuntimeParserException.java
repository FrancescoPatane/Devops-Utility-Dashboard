package com.mooney.devops.testing.utility.converter.udp.business.exception;

/**
 * Incapsula le eccezioni che si verifica a runtime (es.: NoSuchMethodException)
 * 
 * @author sesti
 * @version 1.0
 * @created 15-lug-2008 9.11.22
 */
public class RuntimeParserException extends ParserException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7551956436106116275L;

	/**
	 *
	 * @param message
	 * @param cause
	 */
	public RuntimeParserException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 *
	 * @param message
	 */
	public RuntimeParserException(String message) {
		super(message);
	}

	/**
	 *
	 * @param cause
	 */
	public RuntimeParserException(Throwable cause) {
		super(cause);
	}

	/**
	 *
	 */
	public RuntimeParserException() {

	}

}