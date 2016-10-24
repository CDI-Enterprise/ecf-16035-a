package fr.cdiEnterprise.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


// TODO (groupe) A SUPPRIMER
public class Database {
	
	
	final String strNomDriver = "oracle.jdbc.driver.OracleDriver";
	//static final String dbURL ="jdbc:oracle:thin:stag14/stag14pw@localhost:1521:xe"; // a asuga local a la masion
	private final static String JUNON_URL = "jdbc:oracle:thin:cdi_enterprise/stagpw@junon:1521:AFPA";
	
	
	//static final String dbURL ="jdbc:oracle:thin:stag14/stag14pw@junon:1521:afpa";

	//static Connection conn = null;
	
	public Database() {
		
		try {
			Class.forName(strNomDriver);
		} catch (ClassNotFoundException e) {
			System.out.println("Probleme detecte avec le chargement de la class, verifier que le .jar est lie correctement au projet.");
			e.printStackTrace();
		}
		
	}

	
	public static Connection getConnect() {
		Connection conn = null;
		try {
			conn       = DriverManager.getConnection(JUNON_URL);
		} catch (SQLException e) {
			System.out.println("Erreur de connection a la base de donnée !");
			e.printStackTrace();
		}	
		System.out.println("Connection a la base OK");
		
		return conn;
	}
	
	
	

	
	

}
