package fr.cdiEnterprise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.cdiEnterprise.model.Department;
import fr.cdiEnterprise.model.Language;
import fr.cdiEnterprise.model.Region;
import fr.cdiEnterprise.service.Companies;
import fr.cdiEnterprise.service.Regions;

public class DataBaseAccess {

	// private static String tableAuteurs = "auteurs";
	// private static String tableEditeurs = "editeurs";
	// private static String tableThemes = "themes";
	// private static String tableLivres = "livres";
	// private static String tableLivreAuteur = "livreauteur";
	// private static String tableLivresEditeur = "livresediteur";
	// private static String tableLivreTheme = "livretheme";
	//
	//
	public static void insertDepartmentData(Department department) throws SQLException {
		//
		////
		//// connexion= DataBase.getConnection();
		//// stmt = connexion.createStatement();
		////
		// reqSql = "insert into departments values('" +
		// department.getDepartmentNumber() + "','" +
		// department.getDepartmentName() + "')";
		//// System.out.println(reqSql);
		//// stmt.executeUpdate(reqSql);
		////
		//// connexion.close();
		//// stmt.close();
		// }
		//
		// public static Departments getDepartmentListData() throws
		// SQLException{
		// Departments departments = new Departments();
		// ResultSet rs = null;
		//
		// connexion= DataBase.getConnection();
		// stmt = connexion.createStatement();
		//
		// rs = stmt.executeQuery("select departmentName from departments order
		// by id");
		// while( rs.next() ){
		// String departmentName = rs.getString("departmentName");
		// departments.add(new Department(departmentName));
		//// System.out.println("Resultat select : " + nomAuteur+ " " +
		// prenomAuteur);
		// }
		// connexion.close();
		// stmt.close();
		// return departments;
	}

	//
	public static void insertRegionData(Region region) throws SQLException {
		// connexion= DataBase.getConnection();
		// stmt = connexion.createStatement();
		//
		// reqSql = "insert into regions values('" + region.getRegionName() +
		// "','" + region.getCodeRegion()+ "')";
		//// System.out.println(reqSql);
		// stmt.executeUpdate(reqSql);
		//
		// connexion.close();
		// stmt.close();
		//
	}

	//
	public static Regions getRegionsData() throws SQLException {
		//
		Regions regions = new Regions();
		// ResultSet rs = null;
		//
		// connexion= DataBase.getConnection();
		// stmt = connexion.createStatement();
		//
		// rs = stmt.executeQuery("select regionName from regions order by
		// regionNumber");
		// while( rs.next() ){
		// String regionName = rs.getString("regionName");
		// regions.add(new Region(regionName));
		//// System.out.println("Resultat select : " + nomEditeur);
		// }
		// connexion.close();
		// stmt.close();
		return regions;
	}

	//
	//
	public static void insertLanguageData(Language language) throws SQLException {
		// Connection connexion = null;
		// Statement stmt = null;
		// String reqSql= null;
		// int res;
		//
		// connexion= DataBase.getConnection();
		// stmt = connexion.createStatement();
		//
		// PreparedStatement insertLanguage = connexion.prepareStatement("insert
		// into languages values (?,?)");
		//
		//// insertLanguage.setInt(1,language.getCode());
		// insertLanguage.setString(2, language.getLanguageName());
		//
		// res = insertLanguage.executeUpdate();
		//
		//// System.out.println(res);
		//
		// connexion.close();
		// stmt.close();
	}

	//
	//
	public static Companies getCompaniesData() throws SQLException {
		//
		Companies companies = new Companies();
		// Connection connexion = null;
		// Statement stmt = null;
		// ResultSet rs = null;
		//
		// connexion= DataBase.getConnection();
		// stmt = connexion.createStatement();
		//
		//// rs = stmt.executeQuery("Select livres.cote, titre, nomauteur,
		// prenomauteur, dateedition, NOMEDITEUR, NOMTHEME "
		//// + "\nfrom livres, LIVREAUTEUR, AUTEURS, editeurs, themes ,
		// livreediteur, livretheme"
		//// + "\n where livres.cote= livreAuteur.COTE "
		//// + "\nand livres.cote= livreediteur.cote"
		//// + " \nand livres.cote=livretheme.COTE"
		//// + "\nand AUTEURS.REFAUTEUR= livreauteur.REFAUTEUR"
		//// + "\nand Editeurs.idEditeur = livreediteur.IDEDITEUR"
		//// + "\nand themes.IDTHEME=livretheme.IDTHEME");
		////
		////// System.out.println("Select livres.cote, titre, nomauteur,
		// prenomauteur, dateedition, NOMEDITEUR, NOMTHEME "
		////// + "\nfrom livres, LIVREAUTEUR, AUTEURS, editeurs, themes ,
		// livreediteur, livretheme"
		////// + "\n where livres.cote= livreAuteur.COTE "
		////// + "\nand livres.cote= livreediteur.cote"
		////// + " \nand livres.cote=livretheme.COTE"
		////// + "\nand AUTEURS.REFAUTEUR= livreauteur.REFAUTEUR"
		////// + "\nand Editeurs.idEditeur = livreediteur.IDEDITEUR"
		////// + "\nand themes.IDTHEME=livretheme.IDTHEME");
		////
		//// System.out.println("go");
		////
		//// while( rs.next() ){
		//// String titre = rs.getString("titre");
		//// String nomAuteur = rs.getString("nomAuteur");
		//// String prenomAuteur= rs.getString("prenomauteur");
		//// String dateedition= rs.getString("dateedition");
		//// String nomediteur = rs.getString("nomediteur");
		//// String nomTheme= rs.getString("nomtheme");
		////
		////// livres.add(new Livre());
		//// System.out.println("Resultat select : " +titre + " "+ nomAuteur + "
		// " +prenomAuteur + " " + dateedition + " "+ nomediteur + " " +
		// nomTheme);
		//// }
		//// connexion.close();
		//// stmt.close();
		return companies;
	}

	//
	//
	//
	public static int getIdMax(String table) throws SQLException {
		//
		// connexion = DataBase.getConnection();
		// stmt = connexion.createStatement();
		//
		// ResultSet rsMax = stmt.executeQuery("select max (id) from " + table
		// );
		int idMax = 0;
		//
		// while (rsMax.next())
		// idMax = rsMax.getInt(1);
		//
		return idMax;
	}

}
