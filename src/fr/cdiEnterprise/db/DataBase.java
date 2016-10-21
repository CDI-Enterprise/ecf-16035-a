package fr.cdiEnterprise.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBase {

	final static String strNomDriver = "oracle.jdbc.driver.OracleDriver"; // Driver
																	// pour
																	// connexion
																	// base de
																	// données
	final static String dbURL = "jdbc:oracle:thin:stag13/stag13pw@junon:1521:afpa"; // Accès
																				// base
																				// de
																				// données
	static Connection conn = null;

	public DataBase() {

		try {
			Class.forName(strNomDriver);
			conn = DriverManager.getConnection(dbURL);
		} catch (ClassNotFoundException e) { // 1
			System.err.println("Erreur Appel2Connexion1 : " + e);
		} catch (SQLException s) { // 2
			System.err.println("Erreur Appel2Connexion2 : " + s.getSQLState() + " , " + " (" + s + ")");
			System.out.println("Fin pgm : " + conn);
		}

	}

	public static Connection getConnection() {
		Connection connex = null;
		try {
			Class.forName(strNomDriver);
			connex = DriverManager.getConnection(dbURL);
			System.out.println("Tout est OK, connexion établie");
		} catch (ClassNotFoundException e) { // 1
			System.err.println("Erreur Appel2Connexion1 : " + e);
		} catch (SQLException s) { // 2
			System.err.println("Erreur Appel2Connexion2 : " + s.getSQLState() + " , " + " (" + s + ")");
			System.out.println("Fin pgm : " + conn);
		}
		return connex;
	}

	
}