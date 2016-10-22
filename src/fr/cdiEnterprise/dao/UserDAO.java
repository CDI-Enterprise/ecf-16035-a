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
	 * @param date
	 * @param status
	 * @param alias
	 * @param email
	 * @param afpa
	 * @return creationDone (test code)
	 * @throws SQLException
	 */
	public String create(int id, String date, String status, String alias, String email, String afpa) throws SQLException {

		result = 0;

		try {
			createUser = connect.prepareStatement("INSERT INTO cdi_user VALUES (?, ?, ?, ?, ?, ?)");
			createUser.setInt(1, id);
			createUser.setString(2, date);
			createUser.setString(3, status);
			createUser.setString(4, alias);
			createUser.setString(5, email);
			createUser.setString(6, afpa);
			result = createUser.executeUpdate();
		} catch (SQLException e) {
			//			e.printStackTrace();
			System.err.println("Requête incorrecte : l'utilisateur n'a pas pu être créé.");
		}

		finally {
			closeRequest(createUser);
		}
		// Test code
		String creationDone = null;

		if (result == 0) {
			creationDone = "Aucune création effectuée.";
		}
		else {
			creationDone = result + " création(s) effectuée(s).";
		}

		return creationDone;
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
			System.err.println("Requête incorrecte : l'utilisateur n'a pas pu être supprimé.");
		}

		finally {
			closeRequest(deleteUser);
		}
		// Test code
		String deleteDone = null;

		if (result == 0) {
			deleteDone = "Aucune suppression effecutée."; // Test code
		}
		else {
			deleteDone = result + " suppression(s) effectuée(s)."; // Test code
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
			System.out.println("Requête terminée.");
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
