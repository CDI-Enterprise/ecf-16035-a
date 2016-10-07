package fr.cdiEnterprise.service;

import java.util.ArrayList;
import fr.cdiEnterprise.model.Company;

/**
 * Cette classe représente la liste des entreprises 
 *  
 * @author Anaïs
 * @version 30-09-2016
 *
 */
public class Companies  {
	
	private Company company;
	private ArrayList<Company> listeCompanies;
	
	public Companies() 
	{
		listeCompanies = new ArrayList<Company>();
	}

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return the listeCompanies
	 */
	public ArrayList<Company> getListeCompanies() {
		return listeCompanies;
	}

	/**
	 * @param listeCompanies the listeCompanies to set
	 */
	public void setListeCompanies(ArrayList<Company> listeCompanies) {
		this.listeCompanies = listeCompanies;
	}



}
