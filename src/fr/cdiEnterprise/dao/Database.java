package fr.cdiEnterprise.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	
	
	final String strNomDriver = "oracle.jdbc.driver.OracleDriver";
	// static final String dbURL ="jdbc:oracle:thin:stag14/stag14pw@localhost:1521:xe"; // a asuga local a la masion
	static final String dbURL ="jdbc:oracle:thin:stag14/stag14pw@junon:1521:afpa";

	//static Connection conn = null;
	
	public Database() {
		
		try {
			Class.forName(strNomDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public static Connection getConnect() {
		Connection conn = null;
		try {
			conn       = DriverManager.getConnection(dbURL);
		} catch (SQLException e) {
			System.out.println("Erreur de connection a la base de donnée !");
			e.printStackTrace();
		}	
		System.out.println("Connection a la base OK");
		
		return conn;
	}
	
	
	
	
	
//	public static void getMeta() {
//		System.out.println("--- Listes des tables ---");
//		DatabaseMetaData databaseMetaData = null;
//		try {
//			databaseMetaData = getConnect().getMetaData();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		ResultSet result = null;
//		try {
//			result = databaseMetaData.getTables(
//			    catalog, "stag14", tableNamePattern, types );
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			while(result.next()) {
//			    String tableName = result.getString(3);
//			    System.out.println("table :" + tableName);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	

}
