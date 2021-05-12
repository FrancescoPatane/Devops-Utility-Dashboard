package com.mooney.devops.testing.utility.converter.udp.business.parsers;

import java.io.UnsupportedEncodingException;

import com.mooney.devops.testing.utility.converter.udp.business.exception.RuntimeParserException;
import com.vipera.sisal.retefisica.common.business.interfaces.IParsableObject;

/**
 * Definisce l'interfaccia per un parser dei body message
 * 
 * @author Luigi
 * @version 1.0
 * @created 12-giu-2008 15.13.49
 */
public interface BodyParserInterface {
	/**
	 * 
	 * @param body
	 * @return
	 * @throws RuntimeParserException
	 * @throws java.io.UnsupportedEncodingException
	 */
	public byte[] format(IParsableObject body) throws RuntimeParserException, UnsupportedEncodingException;

	/**
	 * 
	 * @param h
	 * @return
	 * @throws RuntimeParserException
	 * @throws java.io.UnsupportedEncodingException
	 */
	public IParsableObject parser(byte[] h) throws RuntimeParserException, UnsupportedEncodingException;

}