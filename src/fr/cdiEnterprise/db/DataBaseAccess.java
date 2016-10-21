package fr.cdiEnterprise.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.cdiEnterprise.model.Department;

public class DataBaseAccess {

//	private static String tableAuteurs = "auteurs";
//	private static String tableEditeurs = "editeurs";
//	private static String tableThemes = "themes";
//	private static String tableLivres = "livres";
//	private static String tableLivreAuteur = "livreauteur";
//	private static String tableLivresEditeur = "livresediteur";
//	private static String tableLivreTheme = "livretheme";
//	
//	
	public static void insertDepartmentData(Department department) throws SQLException{
//		Connection connexion = null;
//		Statement stmt = null;
//		String reqSql= null;
//		
//		connexion= DataBase.getConnection();
//		stmt = connexion.createStatement();
//		
//		reqSql = "insert into " + tableThemes + " values('" + theme.getCode() + "','" + theme.getNom() + "')";
//		System.out.println(reqSql);
//		stmt.executeUpdate(reqSql);
//		
//		connexion.close();
//		stmt.close();
//
	}
//	
//	
//	public static Auteurs getAuteursData() throws SQLException{
//		
//		Auteurs auteurs = new Auteurs();
//		Connection connexion = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		
//		connexion= DataBase.getConnection();
//		stmt = connexion.createStatement();
//		
//		rs = stmt.executeQuery("select nomAuteur, prenomauteur, refauteur from auteurs");
//		while( rs.next() ){
//			String nomAuteur = rs.getString("nomAuteur");
//			String prenomAuteur= rs.getString("prenomauteur");
//			int codeAuteur =rs.getInt("refauteur");
//			auteurs.add(new Auteur(nomAuteur, prenomAuteur,codeAuteur));
////			System.out.println("Resultat select : " +  nomAuteur+ " " + prenomAuteur);
//		}
//		connexion.close();
//		stmt.close();
//		return auteurs;
//	}
//	
//	
//	public static void insertAuteurData(Auteur auteur) throws SQLException{
//		Connection connexion = null;
//		Statement stmt = null;
//		String reqSql= null;
//		
//		
//		connexion= DataBase.getConnection();
//		stmt = connexion.createStatement();
//		
//		reqSql = "insert into " + tableAuteurs + " values('" + auteur.getCode() + "','" + auteur.getNom() + "', '" + auteur.getPrenom()+ "')";
//		System.out.println(reqSql);
//		stmt.executeUpdate(reqSql);
//		
//		connexion.close();
//		stmt.close();
//
//	}
//
//
//	public static Editeurs getEditeursData() throws SQLException{
//		
//		Editeurs editeurs = new Editeurs();
//		Connection connexion = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		
//		connexion= DataBase.getConnection();
//		stmt = connexion.createStatement();
//		
//		rs = stmt.executeQuery("select nomEditeur, idediteur from editeurs");
//		while( rs.next() ){
//			String nomEditeur = rs.getString("nomediteur");
//			int refEditeur = rs.getInt("idediteur");
//			editeurs.add(new Editeur(nomEditeur, refEditeur));
////			System.out.println("Resultat select : " +  nomEditeur);
//		}
//		connexion.close();
//		stmt.close();
//		return editeurs;
//	}
//	
//	
//	public static void insertEditeurData(Editeur editeur) throws SQLException{
//		Connection connexion = null;
//		Statement stmt = null;
////		String reqSql= null;
//		
//		connexion= DataBase.getConnection();
//		stmt = connexion.createStatement();
//		
//		PreparedStatement insertEditeur = connexion.prepareStatement("insert into editeurs values (?,?)");
//		
//		insertEditeur.setInt(1,editeur.getCode()); 						// (position ? (commence à 1), valeur)
//		insertEditeur.setString(2, editeur.getNomEdit());
//		
//		int res = insertEditeur.executeUpdate();
//		
//		System.out.println(res);
//		
//		
////		reqSql = "insert into " + tableEditeurs + " values(" + editeur.getCode() + ",'" + editeur.getNomEdit() + "')";
////		System.out.println(reqSql);
////		stmt.executeUpdate(reqSql);
//		
//		connexion.close();
//		stmt.close();
//
//	}
//
//	public static Livres getLivresData() throws SQLException{
//		
//		Livres livres = new Livres();
//		Connection connexion = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		
//		connexion= DataBase.getConnection();
//		stmt = connexion.createStatement();
//		
//		rs = stmt.executeQuery("Select livres.cote, titre, nomauteur, prenomauteur, dateedition, NOMEDITEUR, NOMTHEME "
//				+ "\nfrom livres, LIVREAUTEUR, AUTEURS, editeurs, themes , livreediteur, livretheme"
//				+ "\n where livres.cote= livreAuteur.COTE " 
//				+ "\nand livres.cote= livreediteur.cote"
//				+ " \nand livres.cote=livretheme.COTE" 
//				+ "\nand AUTEURS.REFAUTEUR= livreauteur.REFAUTEUR"
//				+ "\nand Editeurs.idEditeur = livreediteur.IDEDITEUR" 
//				+ "\nand themes.IDTHEME=livretheme.IDTHEME");
//		
////		System.out.println("Select livres.cote, titre, nomauteur, prenomauteur, dateedition, NOMEDITEUR, NOMTHEME "
////				+ "\nfrom livres, LIVREAUTEUR, AUTEURS, editeurs, themes , livreediteur, livretheme"
////				+ "\n where livres.cote= livreAuteur.COTE "
////				+ "\nand livres.cote= livreediteur.cote"
////				+ " \nand livres.cote=livretheme.COTE"
////				+ "\nand AUTEURS.REFAUTEUR= livreauteur.REFAUTEUR"
////				+ "\nand Editeurs.idEditeur = livreediteur.IDEDITEUR"
////				+ "\nand themes.IDTHEME=livretheme.IDTHEME");
//		
//		System.out.println("go");
//		
//		while( rs.next() ){
//			String titre = rs.getString("titre");
//			String nomAuteur = rs.getString("nomAuteur");
//			String prenomAuteur= rs.getString("prenomauteur");
//			String dateedition= rs.getString("dateedition");
//			String nomediteur = rs.getString("nomediteur");
//			String nomTheme= rs.getString("nomtheme");
//			
////			livres.add(new Livre());
//			System.out.println("Resultat select : " +titre + " "+  nomAuteur + " " +prenomAuteur + " " + dateedition + " "+ nomediteur + " " + nomTheme);
//		}
//		connexion.close();
//		stmt.close();
//		return livres;
//	}
















}
