package fr.cdiEnterprise.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestDBAna {

	public static void main(String[] args) throws SQLException {
		
//		DataBase dataB = new DataBase();
		
//		Connection connexion = dataB.getConnection();
//		String maTable = "test";
//		
//		Statement stmt = connexion.createStatement();
//		String reqSql = "create table " + maTable + " ( nom char(25), prenom char(25))";
//		stmt.executeUpdate(reqSql);
//		
//		connexion.commit();
//
//		String nom = "FAIVRE";
//		String prenom = "Anaïs";
//				reqSql = "insert into " + maTable + " values('" + nom + "','" + prenom + "')";
//				System.out.println(reqSql);
//	//	insert into THEMES values (1, 'Fantastique');
//		stmt.executeUpdate(reqSql);
//
//		
//		ResultSet rs = stmt.executeQuery("select * from test");
//		while( rs.next() ){
//			String nom1 = rs.getString ("nom");
//			String prenom1 = rs.getString ( "prenom");
//			System.out.println("Resultat select : " + nom1 + " " + prenom1);
//		}
//		reqSql = "drop table test";
//		stmt.executeUpdate(reqSql);
	
//		System.out.println(DataBaseAccess.getThemesData());
		
		/**Test pour ajouter un theme**/
//		Theme theme = new Theme("Aventure", 001);
//		DataBaseAccess.insertThemeData(theme);
//		System.out.println(DataBaseAccess.getThemesData());
	
//		System.out.println(DataBaseAccess.getAuteursData());
		
		/**Test pour ajouter un auteur**/
//		Auteur auteur = new Auteur("Tolkien", "John Ronald Reuel");
//		DataBaseAccess.insertAuteurData(auteur);
//		System.out.println(DataBaseAccess.getAuteursData());
		
//		System.out.println(DataBaseAccess.getEditeursData());
				
//		System.out.println(DataBaseAccess.getLivresData());
		
		
		
		/**Test pour ajouter un editeur**/
		// Editeur editeur1 = new Editeur(" Mondes");
//		System.out.println(new Editeur("Revue des deux Mondes", 005));
//		System.out.println(editeur1);
//		 DataBaseAccess.insertEditeurData(editeur);
//		 System.out.println(DataBaseAccess.getEditeursData());


	
	}

}
