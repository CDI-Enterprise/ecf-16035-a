package fr.cdiEnterprise.util;

import java.sql.Connection;
import java.sql.DriverManager;

// TODO (groupe) A SUPPRIMER
/**
 * 
 * @author Olivier 20-10-2016
 * Classe static  permettant de créer un objet connexion
 *
 */
public class ClassConnexion {

	private static Connection connection;


	static{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:stag17/stag17pw@junon:1521:AFPA");
			System.out.println("Création de la connexion");
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	// creation de la méthode pour créer la connexion
	public static Connection getConnection() {
		return connection;
	}
}


