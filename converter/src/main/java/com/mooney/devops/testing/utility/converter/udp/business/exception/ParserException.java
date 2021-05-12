package com.mooney.devops.testing.utility.converter.udp.business.exception;

/**
 * Classe root della gerarchia delle eccezioni sollevate se si verifca un errore durante il parsing e/o formatting di un messaggio.
 * 
 * @author sesti
 * @version 1.0
 * @created 15-lug-2008 9.11.21
 */
public class ParserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8174937664129203933L;

	/**
	 *
	 * @param message
	 * @param cause
	 */
	public ParserException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 *
	 * @param message
	 */
	public ParserException(String message) {
		super(message);
	}

	/**
	 *
	 * @param cause
	 */
	public ParserException(Throwable cause) {
		super(cause);
	}

	/**
	 *
	 */
	public ParserException() {

	}

}