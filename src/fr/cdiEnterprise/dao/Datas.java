/**
 * 
 */
package fr.cdiEnterprise.dao;
import fr.cdiEnterprise.model.Department;
import fr.cdiEnterprise.model.Region;
import fr.cdiEnterprise.model.Trainee;
import fr.cdiEnterprise.service.Companies;
import fr.cdiEnterprise.service.Departments;
import fr.cdiEnterprise.service.Languages;
import fr.cdiEnterprise.service.Regions;
import fr.cdiEnterprise.service.Users;

/**
 * @author Claire, Ana�s
 *
 */
public class Datas {

	private static Users usersList;

	private static Departments listeDepartments = new Departments();
	private static Regions listeRegions = new Regions();
	private static Companies listeCompanies = new Companies();
	private static Languages listeLanguagesCompany = new Languages();

	/**
	 * 
	 */
	public Datas() {

	}

	public static void init(){

		// Test list trainee
		usersList = new Users();
		usersList.add(new Trainee("email@boite.fr", "Pseudo1", "mdp", "Stagiaire", "Saint-J�r�me", "D. Muller", "Nom1", "Pr�nom1",
				"16035", null, "Java", "Swing", "site.fr", "LI"));

		
		// remplir les th�mes de la biblio

		Departments allStaticDepartment = new Departments();
		for(int i = 0; i < Department.DEPARTMENTS.length; i++) {
			listeDepartments.add(new Department(Department.DEPARTMENTS[i]));
		}	

		Regions allRegions = new Regions();
		for(int i = 0; i < Region.REGIONS.length; i++) {
			listeRegions.add(new Region(Region.REGIONS[i]));	
		}
	}

	Languages allLunguages = new Languages();


	public static Departments getListeDepartments() {
		return listeDepartments;
	}

	public static void setListeDepartments(Departments listeDepartments) {
		Datas.listeDepartments = listeDepartments;
	}

	public static Regions getListeRegions() {
		return listeRegions;
	}

	public static void setListeRegions(Regions listeRegions) {
		Datas.listeRegions = listeRegions;
	}

	public static Companies getListeCompanies() {
		return listeCompanies;
	}

	public static void setListeCompanies(Companies listeCompanies) {
		Datas.listeCompanies = listeCompanies;
	}

	public static Languages getListeLanguages() {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * @return the usersList
	 */
	public static Users getUsersList() {
		return usersList;
	}

}