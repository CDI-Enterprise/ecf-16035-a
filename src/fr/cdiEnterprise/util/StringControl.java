/**
 * 
 */
package fr.cdiEnterprise.util;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.cdiEnterprise.dao.UserDAO;
import fr.cdiEnterprise.exceptions.AlreadyUsedException;
import fr.cdiEnterprise.exceptions.LessTwentyCharStringException;
import fr.cdiEnterprise.exceptions.ZeroLengthStringException;

/**
 * Methods for input control.
 * 
 * @author Claire
 * @version 25-10-2016
 */
public class StringControl {

	static boolean doThrowException;

	/**
	 * This method checks if the length of the String in parameter is equal to 0.
	 * 
	 * @author Claire
	 * @param attribute
	 * @return throwException
	 * @throws ZeroLengthStringException
	 * @version 23-10-2016
	 */
	public static boolean isZeroLength(String attribute) throws ZeroLengthStringException {

		if (attribute.isEmpty()) {
			doThrowException = true;
			throw new ZeroLengthStringException("Merci de remplir les champs obligatoires.");
		}
		return doThrowException;
	}

	// A TESTER
	public static boolean isLessTwentyChar(String attribute) throws LessTwentyCharStringException {

		if (attribute.length() > 20) {
			doThrowException = true;
			throw new LessTwentyCharStringException();
		}
		return doThrowException;
	}

	/**
	 * This method checks if the length of the String in parameter is bigger than 20.
	 * 
	 * @author Claire
	 * @param attribute
	 * @param label
	 * @return throwException
	 * @throws LessTwentyCharStringException
	 * @version 25-10-2016
	 */
	public static boolean isLessTwentyChar(String attribute, String label) throws LessTwentyCharStringException {

		if (attribute.length() > 20) {
			doThrowException = true;
			throw new LessTwentyCharStringException(label + " doit faire moins de vingt caractères.");
		}
		return doThrowException;
	}

	/**
	 * This method checks if an alias already exists in the table USER_CDI.
	 * 
	 * @param attribute
	 * @return throwException
	 * @throws AlreadyUsedException
	 * @throws SQLException
	 * @version 25-10-2016
	 */
	public static boolean isAlreadyUsed(String attribute) throws AlreadyUsedException, SQLException {

		ArrayList<String> aliasList;
		aliasList = UserDAO.getAliasList();

		for (String str : aliasList) {
			if (attribute.equals(str)) {
				doThrowException = true;
				throw new AlreadyUsedException("Désolé, le pseudo " + attribute + " est déjà utilisé.");
			}
		}
		return doThrowException;
	}
}
