package com.mooney.devops.testing.utility.converter.udp.business.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author sesti offset - indica lo scostamento del campo. Se = -1 allora e' relativo al campo indicato dalla proripeta' relField
 * 
 *         lenght - indica la lunghezza in byte del campo. Se = 0 indica una lunghezza dinamica
 * 
 *         encoding - indica la codifica da utilizzare per gestire correttamento il campo. I valore possibili sono: 1 - LITTLE ENDIAN 0 - BIG ENDIAN
 * 
 *         relField - Se l'offset e' -1, indica che l'offset deve essere calcolato com offset del campo relField sommato alla lunghezza del campo relField.
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Position {

	/**
	 *
	 * @return
	 */
	int offset();

	/**
	 *
	 * @return
	 */
	int length();

	// 1 indica la codifica LITTLE ENDIAN
	// 0 indica la codifica BIG ENDIAN

	/**
	 *
	 * @return
	 */
	int encoding() default 1;

	/**
	 *
	 * @return
	 */
	String relField() default "";
}