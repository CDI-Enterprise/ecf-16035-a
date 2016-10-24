package fr.cdiEnterprise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import fr.cdiEnterprise.model.Company;
import fr.cdiEnterprise.model.Contact;
import fr.cdiEnterprise.model.Department;
import fr.cdiEnterprise.model.Language;
import fr.cdiEnterprise.model.Region;
import fr.cdiEnterprise.service.Companies;
import fr.cdiEnterprise.service.Departments;
import fr.cdiEnterprise.service.Languages;
import fr.cdiEnterprise.service.Regions;



public class DataBaseCompany {

	public static void insertDepartmentData(Department department) throws SQLException {
		// Statement stmt = null;
		Connection connexion = null;
		// String reqSql = null;
		int res;

		connexion = DBConnection.getConnect();
		// stmt = connexion.createStatement();
		//
		// reqSql = "insert into departments values(" +
		// department.getDepartmentNumber() + ",'"
		// + department.getDepartmentName() + "')";
		// System.out.println(reqSql);
		// stmt.executeUpdate(reqSql);
		// connexion.commit();
		// stmt.close();

		PreparedStatement insertDepartment = connexion.prepareStatement("insert into departments values (?,?)");

		insertDepartment.setInt(1, department.getDepartmentNumber());
		insertDepartment.setString(2, department.getDepartmentName());

		res = insertDepartment.executeUpdate();
		System.out.println("insérer " + res);
		connexion.commit();
		connexion.close();
		// stmt.close();

	}

	public static Departments getDepartmentListData() throws SQLException {
		Departments departments = new Departments();
		ResultSet rs = null;
		Statement stmt = null;
		Connection connexion = null;

		connexion = DBConnection.getConnect();
		stmt = connexion.createStatement();

		rs = stmt.executeQuery("select departmentName from departments order by departmentNumber");
		while (rs.next()) {
			String departmentName = rs.getString("departmentName");
			departments.add(new Department(departmentName));
		}
		stmt.close();
		rs.close();

		return departments;
	}

	public static void deleteDepartmentData(Department department) throws SQLException {

		Statement stmt = null;
		Connection connexion = null;

		String reqSql;

		connexion = DBConnection.getConnect();
		stmt = connexion.createStatement();

		reqSql = "delete from departments where idTheme = ?";

		PreparedStatement deleteDepartment = connexion.prepareStatement(reqSql);
		deleteDepartment.setInt(1, department.getDepartmentNumber());

		deleteDepartment.executeUpdate();

		stmt.close();
	}

	public static Department getDepartmentName(int departmentNumber) throws SQLException {

		Department department = null;
		ResultSet rs = null;
		Statement stmt = null;
		Connection connexion = null;
		String reqSql = null;

		connexion = DBConnection.getConnect();
		stmt = connexion.createStatement();

		reqSql = "select departmentNumber, departmentName from departments where departmentNumber = ?";
		PreparedStatement getDepartmentName = connexion.prepareStatement(reqSql);
		getDepartmentName.setInt(1, departmentNumber);

		rs = getDepartmentName.executeQuery();
		// System.out.println("modifier");
		while (rs.next()) {
			String name = rs.getString("departmentName");
			department = new Department(name, departmentNumber);
		}

		stmt.close();

		return department;
	}

	public static Department getDepartmentId(String departmentName) throws SQLException {

		Department department = null;
		Statement stmt = null;
		Connection connexion = null;
		String reqSql = null;
		ResultSet res;

		connexion = DBConnection.getConnect();
		stmt = connexion.createStatement();

		reqSql = "select departmentNumber, departmentName from departments where departmentName = ?";
		PreparedStatement getDepartmentId = connexion.prepareStatement(reqSql);
		// System.out.println(reqSql);
		getDepartmentId.setString(1, departmentName);

		res = getDepartmentId.executeQuery();
		// System.out.println("modifier");
		while (res.next()) {
			int number = res.getInt("departmentNumber");
			department = new Department(departmentName, number);
		}
		stmt.close();

		return department;
	}

	public static void insertRegionData(Region region) throws SQLException {
		Statement stmt = null;
		Connection connexion = null;
		String reqSql = null;

		connexion = DBConnection.getConnect();
		stmt = connexion.createStatement();

		reqSql = "insert into regions values('" + region.getRegionName() + "'," + region.getCodeRegion() + ")";
		System.out.println(reqSql);
		stmt.executeUpdate(reqSql);
		connexion.commit();
		stmt.close();

	}

	public static Regions getRegionsListData() throws SQLException {

		Regions regions = new Regions();
		Connection connexion = null;
		ResultSet rs = null;
		Statement stmt = null;

		connexion = DBConnection.getConnect();
		stmt = connexion.createStatement();
		rs = stmt.executeQuery("select regionName from regions order by regionId");
		while (rs.next()) {
			String regionName = rs.getString("regionName");
			regions.add(new Region(regionName));
			// System.out.println("Resultat select : " + nomEditeur);
		}

		stmt.close();
		rs.close();
		return regions;
	}

	/*
	 * Méthode pour récupérer le nom de la région dont le numéro est porté en
	 * paramètre
	 * 
	 * @Author : Anaïs
	 */
	public static Region getRegionName(int regionId) throws SQLException {

		Region region = null;
		ResultSet rs = null;
		Statement stmt = null;
		Connection connexion = null;
		String reqSql = null;

		connexion = DBConnection.getConnect();
		stmt = connexion.createStatement();

		reqSql = "select regionId, regionName from regions where regionId = ?";
		PreparedStatement getRegionName = connexion.prepareStatement(reqSql);
		getRegionName.setInt(1, regionId);

		rs = getRegionName.executeQuery();
		// System.out.println("modifier");
		while (rs.next()) {
			String name = rs.getString("regionName");
			region = new Region(name, regionId);
		}

		stmt.close();

		return region;
	}

	/*
	 * Méthode permettant de fournir le numéro de région correspondant à la
	 * région portée en paramètre
	 * 
	 * @author : Anaïs
	 */

	public static Region getRegionId(String regionName) throws SQLException {

		Region region = null;
		Statement stmt = null;
		Connection connexion = null;
		String reqSql = null;
		ResultSet res;

		connexion = DBConnection.getConnect();
		stmt = connexion.createStatement();

		reqSql = "select regionId, regionName from regions where regionName = ?";
		PreparedStatement getRegionId = connexion.prepareStatement(reqSql);
		// System.out.println(reqSql);
		getRegionId.setString(1, regionName);

		res = getRegionId.executeQuery();
		// System.out.println("modifier");
		while (res.next()) {
			int number = res.getInt("regionId");
			region = new Region(regionName, number);
		}
		stmt.close();

		return region;
	}

	public static void insertLanguageData(Language language) throws SQLException {
		Connection connexion = null;
		Statement stmt = null;
		String reqSql = null;
		int res;

		connexion = DBConnection.getConnect();
		stmt = connexion.createStatement();

		reqSql = "insert into languages values (" + language.getId() + " , '" + language.getLanguageName() + "' );";
		PreparedStatement insertLanguage = connexion.prepareStatement("insert into languages values (?,?)");
		System.out.println(reqSql);
		insertLanguage.setInt(1, language.getId());
		insertLanguage.setString(2, language.getLanguageName());

		res = insertLanguage.executeUpdate();
		System.out.println(res);

		stmt.close();
	}

	public static Languages getLanguagesListData() throws SQLException {

		Languages languages = new Languages();
		Connection connexion = null;
		ResultSet rs = null;
		Statement stmt = null;

		connexion = DBConnection.getConnect();
		stmt = connexion.createStatement();
		rs = stmt.executeQuery("select languageName from languages order by languageId");
		while (rs.next()) {
			String languageName = rs.getString("languageName");
			languages.add(new Language(languageName));
			// System.out.println("Resultat select : " + nomEditeur);
		}

		stmt.close();
		rs.close();
		return languages;
	}

	public static Companies getCompaniesData() throws SQLException {

		Companies companies = new Companies();
		Connection connexion = null;
		Statement stmt = null;
		ResultSet rs = null;

		connexion = DBConnection.getConnect();
		stmt = connexion.createStatement();

		rs = stmt.executeQuery("select company.companyId, companyName,companyAdress, companyCODEPOSTAL, companyCity, "
				+ "companySize , companySector , companyProjects , companyWeb, departmentname, regionName, languagename "
				+ "from company, languages, departments, regions, companydepartment, companyregion, companylanguage "
				+ "where company.companyId = companyregion.companyId "
				+ "and company.companyId = companydepartment.companyId "
				+ "and company.companyId = companyLanguage.companyId "
				+ "and departments.departmentNumber = companydepartment.departmentNumber "
				+ "and regions.regionId = companyregion.regionId "
				+ "and languages.languageId = companylanguage.LANGUAGEID");

		while (rs.next()) {
			// int idCompany = rs.getInt("idCompany");
			String companyName = rs.getString("companyName");
			String companyAdress = rs.getString("companyAdress");
			String postalcode = rs.getString("companyCodepostal");
			String city = rs.getString("companyCity");
			String departmentN = rs.getString("departmentName");

			Department department = DataBaseCompany.getDepartmentId(departmentN);

			companies.add(new Company(companyName, companyAdress, postalcode, city, department));

		}
//		stmt.close();
		return companies;
		

	}

	public static void insertCompanyData(Company company) throws SQLException {

		Connection connexion = null;
		Statement stmt = null;
		String reqSqla;
		String reqSqlb;
		String reqSqlc;
		String reqSqld;

		connexion = DBConnection.getConnect();
		stmt = connexion.createStatement();

		reqSqla = "insert into company values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement insertCompany = connexion.prepareStatement(reqSqla);

		insertCompany.setInt(1, company.getIdEnterprise());
		insertCompany.setString(2, company.getCompanyName());
		insertCompany.setString(3, company.getAdress());
		insertCompany.setString(4, company.getPostalCode());
		insertCompany.setString(5, company.getCity());
		insertCompany.setString(6, company.getSize());
		insertCompany.setString(7, company.getSector());
		insertCompany.setString(8, company.getProjets());
		insertCompany.setString(9, company.getWebSite());

		reqSqlb = "insert into companyregion values (?,?)";
		PreparedStatement insertCompanyRegion = connexion.prepareStatement(reqSqlb);
		insertCompanyRegion.setInt(1, company.getIdEnterprise());
		insertCompanyRegion.setInt(2, company.getRegion().getCodeRegion());

		reqSqlc = "insert into companydepartment values (?,?)";
		PreparedStatement insertCompanyDepartment = connexion.prepareStatement(reqSqlc);
		insertCompanyDepartment.setInt(1, company.getIdEnterprise());
		insertCompanyDepartment.setInt(2, company.getDepartment().getDepartmentNumber());

		reqSqld = "insert into companylanguage values (?,?)";
		PreparedStatement insertCompanyLanguage = connexion.prepareStatement(reqSqld);
		insertCompanyLanguage.setInt(1, company.getIdEnterprise());
		insertCompanyLanguage.setInt(2, company.getLanguage().getId());

		insertCompany.executeUpdate();
		insertCompanyRegion.executeUpdate();
		insertCompanyDepartment.executeUpdate();
		insertCompanyLanguage.executeUpdate();

		stmt.close();

	}
	
	public static void deleteCompanyData(Company company) throws SQLException {
		Connection connexion = null;
		Statement stmt = null;
		String reqSql = null;
		int res;

		connexion = DBConnection.getConnect();
		stmt = connexion.createStatement();
		reqSql = "delete from " + company + " where companyId = ?";

		PreparedStatement deleteCompany = connexion.prepareStatement(reqSql);

		deleteCompany.setInt(1, company.getIdEnterprise());
//		System.out.println(rqSql);

		deleteCompany.executeUpdate();
//		System.out.println("effacer");


		stmt.close();
	}
	
	
	public static void updateCompanyData(Company company, String newNom) throws SQLException {
		Connection connexion = null;
		Statement stmt = null;
		String reqSql = null;
		int res;
		
		connexion = DBConnection.getConnect();
		stmt = connexion.createStatement();
		
		reqSql = "UPDATE company set nomCompany= ? where companyId = " + company.getIdEnterprise();

		PreparedStatement updateCompany = connexion.prepareStatement(reqSql);
		updateCompany.setString(1, newNom); 
//		System.out.println(rqSql);

		updateCompany.executeUpdate();
//		System.out.println("modifier");

		connexion.close();
		stmt.close();
	}

	public static void insertContact(Contact contact) throws SQLException {
		Connection connexion = null;
		Statement stmt = null;
		String reqSql = null;
		int res;
		String table = "contactComp";
		int idContact = getIdMax(table);

		connexion = DBConnection.getConnect();
		stmt = connexion.createStatement();

		reqSql = "insert into contactComp values (" + idContact + " , '" + contact.getName() + "', "
				+ contact.getPhoneNumber() + ", " + contact.getEmail() + ")";

		PreparedStatement insertContact = connexion.prepareStatement("insert into contactComp values (?,?,?,?)");

		insertContact.setInt(1, idContact);
		insertContact.setString(2, contact.getName());
		insertContact.setString(3, contact.getPhoneNumber());
		insertContact.setString(4, contact.getEmail());

		res = insertContact.executeUpdate();
		System.out.println(res);

		stmt.close();
	}

	
	public static int getIdMax(String table) throws SQLException {
		Connection connexion;
		Statement stmt;

		connexion = DBConnection.getConnect();
		stmt = connexion.createStatement();

		ResultSet rsMax = stmt.executeQuery("select max (id) from " + table);
		int idMax = 0;

		while (rsMax.next())
			idMax = rsMax.getInt(1);

		return idMax;
	}

}
