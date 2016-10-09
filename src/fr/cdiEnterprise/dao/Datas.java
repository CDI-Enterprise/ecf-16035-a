/**
 * 
 */
package fr.cdiEnterprise.dao;
import fr.cdiEnterprise.model.Companies;
import fr.cdiEnterprise.model.Department;
import fr.cdiEnterprise.model.Departments;
import fr.cdiEnterprise.model.Languages;
import fr.cdiEnterprise.model.Region;
import fr.cdiEnterprise.model.Regions;

/**
 * @author Claire
 *
 */
public class Datas {

	/**
	 * 
	 */
	
	private static Departments listeDepartments = new Departments();
	private static Regions listeRegions = new Regions();
	private static Companies listeCompanies = new Companies();
	private static Languages listeLanguagesCompany = new Languages();
	
	
	
	public Datas() {
		// TODO Auto-generated constructor stub
	}
	
	public static void init(){
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

	

}
