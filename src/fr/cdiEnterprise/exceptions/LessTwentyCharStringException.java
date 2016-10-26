/**
 * 
 */
package fr.cdiEnterprise.exceptions;

/**
 * This exception can be instantiate when the method isLessTwentyChar() is used.
 * 
 * @author Claire
 * @see fr.cdiEnterprise.util.StringControl
 * @version 25-10-2016
 */
public class LessTwentyCharStringException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LessTwentyCharStringException(String message) {
		super(message);
	}
	
}
