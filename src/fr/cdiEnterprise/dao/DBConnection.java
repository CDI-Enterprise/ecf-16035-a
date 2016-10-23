/**
 * 
 */
package fr.cdiEnterprise.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Create a single object Connection to link this program to the database.
 * @author Claire
 * @version 2016-10-19
 *
 */
//TODO (Groupe) separate driver loading from connection?
public class DBConnection {

	// Defines a JDBC driver
	private final static String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	// Defines a connection string
//	private final static String JUNON_URL = "jdbc:oracle:thin:stag16/stag16pw@junon:1521:AFPA";
	// Our local connections, don't forget to change the URL!
	private final static String CLAIRE_URL = "jdbc:oracle:thin:claire/5Q1D3V@localhost:1521:XE";
	// New connection
	private static Connection connect;

	/**
	 * Private constructor to prevent the instantiation of multiple connections.
	 */
	private DBConnection() {
	}

	/**
	 * Checks if a connection to DB already exists before creating one.
	 * @return connect
	 */
	static {
		try {
			// Loads JDBC Oracle driver
			Class.forName(ORACLE_DRIVER);
			// Asks for a new connection
			if (connect == null) {
				connect = DriverManager.getConnection(CLAIRE_URL);
				System.out.println("Connexion établie.");
			}
			else {
				System.out.println("Une connexion existe déjà.");
			}
		}
		// If exception, JDBC driver is not linked to the Java project
		catch(ClassNotFoundException e){
			System.err.println("Oracle : Le driver n'a pas été trouvé."); 
		}
		// If connection doesn't work
		catch (SQLException s){
			System.err.println("Junon : Erreur lors de la connexion : "
					+ s.getSQLState() + " , "
					+ " (" + s + ")" );
		}
	}
	
	public static Connection getConnect() {
		return connect;
	}
	
}