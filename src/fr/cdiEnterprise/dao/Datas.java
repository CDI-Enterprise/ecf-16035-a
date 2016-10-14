/**
 * 
 */
package fr.cdiEnterprise.dao;
import fr.cdiEnterprise.model.Department;
import fr.cdiEnterprise.model.Language;
import fr.cdiEnterprise.model.Region;
import fr.cdiEnterprise.model.Trainee;
import fr.cdiEnterprise.service.Companies;
import fr.cdiEnterprise.service.Departments;
import fr.cdiEnterprise.service.Languages;
import fr.cdiEnterprise.service.Regions;
import fr.cdiEnterprise.service.Users;

/**
 * @author Claire, Anaïs
 *
 */
public class Datas {

	private static Users usersList;

	private static Departments departmentsList = new Departments();
	private static Regions regionsList = new Regions();
	private static Companies companiesList = new Companies();
	private static Languages languagesCompanyList = new Languages();

	/**
	 * 
	 */
	public Datas() {

	}

	public static void init(){

		// Test list trainee
		usersList = new Users();
		usersList.add(new Trainee("email@boite.fr", "Pseudo1", "mdp", "Stagiaire", "Saint-Jérôme", "D. Muller", "Nom1", "Prénom1",
				"16035", null, "Java", "Swing", "site.fr", "LI"));
		
		// List Department
		//Departments allDepartments = new Departments();
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

	public static Companies getCompaniesList() {
		return companiesList;
	}

	public static void setCompaniesList(Companies listeCompanies) {
		Datas.companiesList = listeCompanies;
	}

	public static Languages getLanguagesCompanyList() {
		return languagesCompanyList;
	}


	/**
	 * @return the usersList
	 */
	public static Users getUsersList() {
		return usersList;
	}

}
