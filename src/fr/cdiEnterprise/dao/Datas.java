/**
 * 
 */
package fr.cdiEnterprise.dao;
import fr.cdiEnterprise.control.MpClient;
import fr.cdiEnterprise.model.Company;
import fr.cdiEnterprise.model.Department;
import fr.cdiEnterprise.model.FormerTrainee;
import fr.cdiEnterprise.model.Language;
import fr.cdiEnterprise.model.Region;
import fr.cdiEnterprise.model.Trainee;
import fr.cdiEnterprise.model.User;
import fr.cdiEnterprise.service.Clients;
import fr.cdiEnterprise.model.Trainer;

import fr.cdiEnterprise.service.Companies;
import fr.cdiEnterprise.service.Departments;
import fr.cdiEnterprise.service.Languages;
import fr.cdiEnterprise.service.Regions;
import fr.cdiEnterprise.service.Users;


/**
 * @author Claire, Ana�s, Nicolas
 *
 */
public class Datas {

	private static Users usersList;
	
	private static Companies companiesList = new Companies();
	
	private static Clients clientBox;
	private static Server exchange;
	
	private static Departments departmentsList = new Departments();
	private static Regions regionsList = new Regions();

	private static Languages languagesCompanyList = new Languages();

	/**
	 * 
	 */
	public Datas() {

	}

	public static void init(){
		
		// Test du server de messagerie
		exchange = new Server();
		clientBox = new Clients();

//		// Non exhaustive DB programming language
//		progLangList = new Languages();
//		progLangList.add(new Language("C"));
//		progLangList.add(new Language("C++"));
//		progLangList.add(new Language("Delphi"));
//		progLangList.add(new Language("JavaScript"));
//		progLangList.add(new Language("Perl"));
//		progLangList.add(new Language("PHP"));
//		progLangList.add(new Language("Python"));
//		progLangList.add(new Language("R"));
//		progLangList.add(new Language("Ruby"));
//		progLangList.add(new Language("Visual Basic"));
		
		// Test list trainee
		usersList = new Users();

//		usersList.add(new Trainee("email@boite.fr", "Pseudo1", "mdp", "Stagiaire", "Saint-J�r�me", "D. Muller", "Nom1", "Pr�nom1",
//				"16035", null, "Java", "Swing", "site.fr", "LI"));
		
// HEAD
		// List Department


		// User database
		usersList = new Users();
		usersList.add(new Trainer("01-01-2010 08:00", "Formateur", "Domi", "domim@afpa.fr", "Saint-J�r�me"));
		usersList.add(new FormerTrainee("29-08-2015 08:00", "Ancien", "CDI", "cdi@mail.org", "Saint-J�r�me", "E. Cattaneo"));
		
		usersList.add(new Trainee("29-08-2016 08:00", "Stagiaire", "Klaroo", "klaroo@mail.fr", "Saint-J�r�me", "D. Muller"));
		usersList.add(new Trainee("29-08-2016 08:00", "Stagiaire", "Cookie", "cookie@mail.fr", "Saint-J�r�me", "D. Muller"));
		usersList.add(new Trainee("29-08-2016 08:00", "Stagiaire", "Omy", "omy@mail.fr", "Saint-J�r�me", "D. Muller"));
		usersList.add(new Trainee("29-08-2016 08:00", "Stagiaire", "Oracle", "oracle@mail.fr", "Saint-J�r�me", "D. Muller"));
		usersList.add(new Trainee("29-08-2016 08:00", "Stagiaire", "Dark Swan", "darkswan@mail.fr", "Saint-J�r�me", "D. Muller"));
		
		
		// Test du server de messagerie
		exchange = new Server();
		clientBox = new Clients();
		
		// Creation des boite de Messagerie
		for(User current : usersList) {
			MpClient client = new MpClient(exchange, current.getAlias());
			clientBox.add(client);
		}
		

		//Departments allStaticDepartment = new Departments();
		for(int i = 0; i < Department.DEPARTMENTS.length; i++) {
			departmentsList.add(new Department(Department.DEPARTMENTS[i]));
		}	

		//Regions allRegions = new Regions();
		for(int i = 0; i < Region.REGIONS.length; i++) {
			regionsList.add(new Region(Region.REGIONS[i]));	
		}

		//Languages allLunguages = new Languages();
		for (int i =0; i< Language.LANGUAGES.length; i++){
		languagesCompanyList.add(new Language(Language.LANGUAGES[i]));
		}
		//Companies database
//		companiesList.add(new Company("AFPA", "53 Boulevard Laveran", "13000","MARSEILLE", 
//						new Department(Department.DEPARTMENTS[13]),new Region(Region.REGIONS[11]),
//						null,"Formation", new Languages(),"Formation m�tier",
//						"afpa.fr", null));
	}
	
	
	/**
	 * @return the usersList
	 */
	public static Users getUsersList() {
		return usersList;
	}
	
	public static Department getDepartment(String nomDepartment) {
		return departmentsList.getDepartment(nomDepartment);
	}

	public static Companies getCompaniesList() {
		return companiesList;

	}


	public static void setCompaniesList(Companies listeCompanies) {
		Datas.companiesList = listeCompanies;
	}
	
	public static Clients getClientBox() {
		return clientBox;
	}
	
	public static Departments getDepartmentsList() {
		return departmentsList;
	}
	
	public static void setDepartmentsList(Departments listeDepartments) {
		Datas.departmentsList = listeDepartments;
	}


	public static Regions getRegionsList() {
		return regionsList;
	}


	public static Languages getLanguagesCompanyList() {
		return languagesCompanyList;
	}

	public static Region getRegion(String nomRegion) {
		return regionsList.getRegion(nomRegion);
	}

}
