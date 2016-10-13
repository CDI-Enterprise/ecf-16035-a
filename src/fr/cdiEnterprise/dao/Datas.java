/**
 * 
 */
package fr.cdiEnterprise.dao;
import fr.cdiEnterprise.controler.MpClient;
import fr.cdiEnterprise.model.Department;
import fr.cdiEnterprise.model.Region;
import fr.cdiEnterprise.model.Trainee;
import fr.cdiEnterprise.model.User;
import fr.cdiEnterprise.service.Clients;
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
	private static Server exchange;
	private static Clients clientBox;

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
		
		// Test du server de messagerie
		exchange = new Server();
		clientBox = new Clients();

		// Test list trainee
		usersList = new Users();
		
		usersList.add(new Trainee("email@boite.fr", "Pseudo1", "mdp", "Stagiaire", "Saint-Jérôme", "D. Muller", "Nom1", "Prénom1",
				"16035", null, "Java", "Swing", "site.fr", "LI"));
		for(User current : usersList) {
			MpClient client = new MpClient(exchange, current.getAlias());
			clientBox.add(client);
		}
		
		usersList.add(new Trainee("nicolas@tarral.net", "ntarral", "mdp", "Stagiaire", "Saint-Jérôme", "D. Muller", "tarral", "nicolas",
				"16035", null, "Java", "Swing", "tarral.net", "LI"));
		
		
		usersList.add(new Trainee("pierre@benoit.net", "pbenoit", "mdp", "Stagiaire", "Saint-Jérôme", "D. Muller", "benoit", "pierre",
				"16035", null, "Java", "Swing", "benoit.net", "LI"));
		// remplir les thèmes de la biblio

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
