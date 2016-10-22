/**
 * 
 */
package fr.cdiEnterprise.dao;
//import fr.cdiEnterprise.model.Company;
import fr.cdiEnterprise.model.Department;
import fr.cdiEnterprise.model.Favorite;
import fr.cdiEnterprise.model.FormerTrainee;
import fr.cdiEnterprise.model.Language;
import fr.cdiEnterprise.model.Region;
import fr.cdiEnterprise.model.Trainee;
import fr.cdiEnterprise.model.User;
import fr.cdiEnterprise.service.Clients;
import fr.cdiEnterprise.model.Trainer;

import fr.cdiEnterprise.service.Companies;
import fr.cdiEnterprise.service.Departments;
import fr.cdiEnterprise.service.Favorites;
import fr.cdiEnterprise.service.Languages;
import fr.cdiEnterprise.service.Regions;
import fr.cdiEnterprise.service.Users;
import fr.cdiEnterprise.util.MpClient;

/**
 * Temporary database.
 * @author Claire, Anais, Nicolas
 * @version 16-10-2016
 */
public class OldDatas {

	private static Users usersList;
	
	private static Companies companiesList = new Companies();
	
	private static Clients clientBox;
	private static Server exchange;
	
	private static Departments departmentsList = new Departments();
	private static Regions regionsList = new Regions();

	private static Languages languagesCompanyList = new Languages();
	
	private static Favorites favoritesList = new Favorites();

	/**
	 * 
	 */
	public OldDatas() {

	}

	public static void init(){
		
		// User database
		usersList = new Users();
		usersList.add(new Trainer("Formateur", "Domi", "domim@afpa.fr", "Saint-J�r�me"));
		usersList.add(new FormerTrainee("Ancien", "CDI", "cdi@mail.org", "Saint-J�r�me"));
		
		usersList.add(new Trainee("Stagiaire", "Klaroo", "klaroo@mail.fr", "Saint-J�r�me"));
		usersList.add(new Trainee("Stagiaire", "Cookie", "cookie@mail.fr", "Saint-J�r�me"));
		usersList.add(new Trainee("Stagiaire", "Omy", "omy@mail.fr", "Saint-J�r�me"));
		usersList.add(new Trainee("Stagiaire", "Oracle", "oracle@mail.fr", "Saint-J�r�me"));
		usersList.add(new Trainee("Stagiaire", "Dark Swan", "darkswan@mail.fr", "Saint-J�r�me"));
		
		
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
		
		
		//BookMark
		for(int i =0; i< Favorite.FAVORITES.length;i++)
		{
			favoritesList.add(new Favorite(Favorite.FAVORITES[i]));
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
	
	public static Companies getCompaniesList() {
		return companiesList;
	}

	public static void setCompaniesList(Companies listeCompanies) {
		OldDatas.companiesList = listeCompanies;
	}
	
	public static Clients getClientBox() {
		return clientBox;
	}
	
	public static Departments getDepartmentsList() {
		return departmentsList;
	}
	
	public static void setDepartmentsList(Departments listeDepartments) {
		OldDatas.departmentsList = listeDepartments;
	}

	public static Regions getRegionsList() {
		return regionsList;
	}

	public static void setRegionsList(Regions listeRegions) {
		OldDatas.regionsList = listeRegions;
	}

	public static Languages getLanguagesCompanyList() {
		return languagesCompanyList;
	}

	/**
	 * @return the favoritesList
	 */
	public static Favorites getFavoritesList() {
		return favoritesList;
	}

	/**
	 * @param favoritesList the favoritesList to set
	 */
	public static void setFavoritesList(Favorites favoritesList) {
		OldDatas.favoritesList = favoritesList;
	}

	public static Department getDepartment(String nomDepartment) {
		return departmentsList.getDepartment(nomDepartment);
	}
	
	public static Region getRegion(String nomRegion) {
		return regionsList.getRegion(nomRegion);
	}
}
