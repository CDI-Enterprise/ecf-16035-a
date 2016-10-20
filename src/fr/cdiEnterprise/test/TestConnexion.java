package fr.cdiEnterprise.test;



import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import fr.cdiEnterprise.util.ClassConnexion;

/**
 * 
 * @author Olivier 20-10-2016
 * Classe de test permettant de v�rifier la connexion � la base
 * et � l'execution d'une requ�te
 *
 */

public class TestConnexion {

	public static void main(String[] args) {
		Connection conn = ClassConnexion.getConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String reqSql = "create table testConnetnew ( nomHost char(25),portCon char(25))";
			stmt.executeUpdate(reqSql);
					 
 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}



	}

}
