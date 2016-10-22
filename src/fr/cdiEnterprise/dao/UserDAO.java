/**
 * 
 */
package fr.cdiEnterprise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author Claire
 *
 */
public class UserDAO {


	private Connection connect;

	// Prepared statement for SQL request
	private static PreparedStatement createUser;
	private static PreparedStatement updateUser;
	private static PreparedStatement deleteUser;

	private static int result;
	private static ResultSet requestRes;


	/**
	 * Asks for the connection to DB.
	 */
	public UserDAO() {
		this.connect = DBConnection.getConnect();
	}
	

	/**
	 * Insert a new user in database.
	 * @param id
	 * @param inscriptionDate
	 * @param status
	 * @param alias
	 * @param mail
	 * @param afpa
	 * @return creationDone (test code)
	 * @throws SQLException
	 */
	public String create(int id, String inscriptionDate,
			String status, String alias, String mail, String afpa) throws SQLException {

		result = 0;

		try {
			createUser = connect.prepareStatement("INSERT INTO cdi_user VALUES (?, ?, ?, ?, ?, ?)");
			createUser.setInt(1, id);
			createUser.setString(2, inscriptionDate);
			createUser.setString(3, status);
			createUser.setString(4, alias);
			createUser.setString(5, mail);
			createUser.setString(6, afpa);
			result = createUser.executeUpdate();
		} catch (SQLException e) {
			//			e.printStackTrace();
			System.err.println("Requ�te incorrecte : l'utilisateur n'a pas pu �tre cr��.");
		}

		finally {
			closeRequest(createUser);
		}
		// Test code
		String creationDone = null;

		if (result == 0) {
			creationDone = "Aucune cr�ation effectu�e.";
		}
		else {
			creationDone = result + " cr�ation(s) effectu�e(s).";
		}

		return creationDone;
		// Fin test code
	}
	
	/**
	 * Updates an user in database.
	 * @param id
	 * @param inscriptionDate
	 * @param status
	 * @param alias
	 * @param mail
	 * @param afpa
	 * @return updateDone (test code)
	 * @throws SQLException
	 */
	public String update(int id, String inscriptionDate,
			String status, String alias, String mail, String afpa) throws SQLException {

		result = 0;

		try {
			updateUser = connect.prepareStatement("UPDATE cdi_user "
					+ "SET user_inscription_date = ?, user_status = ?, user_alias = ?, user_mail = ?, user_afpa = ? "
					+ "WHERE user_id = ?");
			updateUser.setString(1, inscriptionDate);
			updateUser.setString(2, status);
			updateUser.setString(3, alias);
			updateUser.setString(4, mail);
			updateUser.setString(5, afpa);
			updateUser.setInt(6,id);
			result = updateUser.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			System.err.println("Requ�te incorrecte : l'utilisateur n'a pas pu �tre modifi�.");
		}

		finally {
			closeRequest(updateUser);
		}
		// Test code
		String updateDone = null;

		if (result == 0) {
			updateDone = "Aucune mise � jour effectu�e."; 
		}
		else {
			updateDone = result + " mise(s) � jour effectu�e(s).";
		}

		return updateDone;
		// Fin test code
	}


	/**
	 * Deletes an user in database.
	 * @param id
	 * @return deleteDone (test code)
	 * @throws SQLException
	 */
	public String delete(int id) throws SQLException {

		result = 0;

		try {
			deleteUser = connect.prepareStatement("DELETE FROM cdi_user WHERE user_id = ?");
			deleteUser.setInt(1,id);
			result = deleteUser.executeUpdate();
		} catch (SQLException e) {
			//			e.printStackTrace();
			System.err.println("Requ�te incorrecte : l'utilisateur n'a pas pu �tre supprim�.");
		}

		finally {
			closeRequest(deleteUser);
		}
		// Test code
		String deleteDone = null;

		if (result == 0) {
			deleteDone = "Aucune suppression effecut�e."; // Test code
		}
		else {
			deleteDone = result + " suppression(s) effectu�e(s)."; // Test code
		}

		return deleteDone;
		// Fin test code
	}

	/**
	 * Closes request and automatically result of request if there's one.
	 * @param prepStatmt
	 * @return a string (test code)
	 * @throws SQLException
	 */
	private void closeRequest(PreparedStatement prepStatmt) throws SQLException {
		if (prepStatmt != null) {
			prepStatmt.close();
			// Test code
			System.out.println("Requ�te termin�e.");
			boolean request = false;
			request = prepStatmt.isClosed();
			System.out.println("Statement is closed: " + request);
			if (requestRes != null) {
				boolean result = false;
				result = requestRes.isClosed();
				System.out.println("Result of request is closed: " + result);
			}
			// Fin test code
		}	
	}
}
