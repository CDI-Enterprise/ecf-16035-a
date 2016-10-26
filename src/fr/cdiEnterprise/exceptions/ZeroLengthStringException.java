/**
 * 
 */
package fr.cdiEnterprise.exceptions;

/**
 * This exception can be instantiate when the method isZeroLengthString() is used.
 * 
 * @author Claire
 * @see fr.cdiEnterprise.util.StringControl
 * @version 23-10-2016
 */
public class ZeroLengthStringException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ZeroLengthStringException(String message) {
		super(message);
	}

}
