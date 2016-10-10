package fr.cdiEnterprise.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *  Classe permettant d'effectuer une recherche
 *  selon des critères sur les Fiches Entreprise
 *  @author olivier
 *  @version 02-10-2016
 */

public class RechercheAvancee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String comPagnyName;
	protected String adress;
	protected String postalCode;
	protected String city;
	protected Integer department;
	protected String sector;
	protected String webSite;
	protected Contact contact;
	protected List<Company> listCompanies=new ArrayList<Company>();


	/**
	 * Default constructor
	 */

	public RechercheAvancee() {
	}

	/**
	 * Constructor whith parameters
	 * @param comPagnyName
	 * @param adress
	 * @param postalCode
	 * @param city
	 * @param department
	 * @param sector
	 * @param webSite
	 * @param contact
	 */
	public RechercheAvancee(String comPagnyName, String adress,
			String postalCode, String city, Integer department, String sector,
			String webSite, Contact contact) {
		this.comPagnyName = comPagnyName;
		this.adress = adress;
		this.postalCode = postalCode;
		this.city = city;
		this.department = department;
		this.sector = sector;
		this.webSite = webSite;
		this.contact = contact;
	}
	/**
	 * 
	 * @return name of compagny
	 */
	public String getComPagnyName() {
		return comPagnyName;
	}

	/**
	 * Updates name of compagny
	 * @param comPagnyName
	 */
	public void setComPagnyName(String comPagnyName) {
		this.comPagnyName = comPagnyName;
	}

	/**
	 * 
	 * @return adress of compagny
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * Updates adress of compagny
	 * @param adress
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	/**
	 * 
	 * @return code Zip of compagny
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Updates code Zip of compagny
	 * @param postalCode
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * 
	 * @return the city of compgny
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Updates city of compagny
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 
	 * @return department of compagny
	 */
	public Integer getDepartment() {
		return department;
	}

	/**
	 * Updates departement of compagny
	 * @param department
	 */
	public void setDepartment(Integer department) {
		this.department = department;
	}

	/**
	 * 
	 * @return sector of compagny
	 */
	public String getSector() {
		return sector;
	}

	/**
	 * Updatres sector of compagny
	 * @param sector
	 */
	public void setSector(String sector) {
		this.sector = sector;
	}

	/**
	 * 
	 * @return wevsite of compagny
	 */
	public String getWebSite() {
		return webSite;
	}

	/**
	 * 
	 * @param webSite
	 */
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	/**
	 * 
	 * @return a contact of compagny
	 */
	public Contact getContact() {
		return contact;
	}

	/**
	 * Updates the contact of compagny
	 * @param contact
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	/**
	 * 
	 * @return the list of companies
	 */
	public List<Company> getListCompanies() {
		return listCompanies;
	}

	/**
	 * Upadates list of companies	
	 * @param listCompanies
	 */
	public void setListCompanies(List<Company> listCompanies) {
		this.listCompanies = listCompanies;
	}

	@Override
	public String toString() {
		return "RechercheAvancee [comPagnyName=" + comPagnyName + ", adress="
				+ adress + ", postalCode=" + postalCode + ", city=" + city
				+ ", department=" + department + ", sector=" + sector
				+ ", webSite=" + webSite + ", contact=" + contact
				+ ", getComPagnyName()=" + getComPagnyName() + ", getAdress()="
				+ getAdress() + ", getPostalCode()=" + getPostalCode()
				+ ", getCity()=" + getCity() + ", getDepartment()="
				+ getDepartment() + ", getSector()=" + getSector()
				+ ", getWebSite()=" + getWebSite() + ", getContact()="
				+ getContact() + "]";
	}


}
