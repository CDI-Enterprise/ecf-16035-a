/**
 * 
 */
package fr.cdiEnterprise.dao;
import fr.cdiEnterprise.control.MpClient;
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
 * @author Claire, Anaïs, Nicolas
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
		
		// User database
		usersList = new Users();
		usersList.add(new Trainer("01-01-2010 08:00", "Formateur", "Domi", "domim@afpa.fr", "Saint-Jérôme"));
		usersList.add(new FormerTrainee("29-08-2015 08:00", "Ancien", "CDI", "cdi@mail.org", "Saint-Jérôme", "E. Cattaneo"));
		
		usersList.add(new Trainee("29-08-2016 08:00", "Stagiaire", "Klaroo", "klaroo@mail.fr", "Saint-Jérôme", "D. Muller"));
		usersList.add(new Trainee("29-08-2016 08:00", "Stagiaire", "Cookie", "cookie@mail.fr", "Saint-Jérôme", "D. Muller"));
		usersList.add(new Trainee("29-08-2016 08:00", "Stagiaire", "Omy", "omy@mail.fr", "Saint-Jérôme", "D. Muller"));
		usersList.add(new Trainee("29-08-2016 08:00", "Stagiaire", "Oracle", "oracle@mail.fr", "Saint-Jérôme", "D. Muller"));
		usersList.add(new Trainee("29-08-2016 08:00", "Stagiaire", "Dark Swan", "darkswan@mail.fr", "Saint-Jérôme", "D. Muller"));
		
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
	}
	
	
	/**
	 * @return the usersList
	 */
	public static Users getUsersList() {
		return usersList;
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

	public static void setRegionsList(Regions listeRegions) {
		Datas.regionsList = listeRegions;
	}

	public static Languages getLanguagesCompanyList() {
		return languagesCompanyList;
	}

}
