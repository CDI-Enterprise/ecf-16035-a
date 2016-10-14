/**
 * 
 */
package fr.cdiEnterprise.dao;
import fr.cdiEnterprise.control.MpClient;
import fr.cdiEnterprise.model.Department;
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
 * @author Claire, Anaïs
 *
 */
public class Datas {

	private static Languages progLangList;
	
	private static Users usersList;
	private static Server exchange;
	private static Clients clientBox;

	private static Departments listeDepartments = new Departments();
	private static Regions listeRegions = new Regions();
	private static Companies listeCompanies = new Companies();


	/**
	 * 
	 */
	public Datas() {

	}

	public static void init(){
		
		// Test du server de messagerie
		exchange = new Server();
		clientBox = new Clients();

		// Non exhaustive DB programming language
		progLangList = new Languages();
		progLangList.add(new Language("C"));
		progLangList.add(new Language("C++"));
		progLangList.add(new Language("Delphi"));
		progLangList.add(new Language("JavaScript"));
		progLangList.add(new Language("Perl"));
		progLangList.add(new Language("PHP"));
		progLangList.add(new Language("Python"));
		progLangList.add(new Language("R"));
		progLangList.add(new Language("Ruby"));
		progLangList.add(new Language("Visual Basic"));
		
		// Test list trainee
		usersList = new Users();
		usersList.add(new Trainer("01-01-2010 08:00", "Formateur", "Domi", "domim@afpa.fr", "Saint-Jérôme"));
		usersList.add(new Trainee("29-08-2016 08:00", "Stagiaire", "Klaroo", "klaroo@mail.fr", "Saint-Jérôme", "D. Muller"));
		usersList.add(new Trainee("29-08-2016 08:00", "Stagiaire", "Cookie", "cookie@mail.fr", "Saint-Jérôme", "D. Muller"));
		usersList.add(new Trainee("29-08-2016 08:00", "Stagiaire", "Omy", "omy@mail.fr", "Saint-Jérôme", "D. Muller"));
		usersList.add(new Trainee("29-08-2016 08:00", "Stagiaire", "Oracle", "oracle@mail.fr", "Saint-Jérôme", "D. Muller"));
		usersList.add(new Trainee("29-08-2016 08:00", "Stagiaire", "Dark Swan", "darkswan@mail.fr", "Saint-Jérôme", "D. Muller"));

		// Creation des boite de Messagerie
		
		for(User current : usersList) {
			MpClient client = new MpClient(exchange, current.getAlias());
			clientBox.add(client);
		}
		

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
	

	/**
	 * @return the usersList
	 */
	public static Users getUsersList() {
		return usersList;
	}
	
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

	public static Clients getClientBox() {
		return clientBox;
	}

}
