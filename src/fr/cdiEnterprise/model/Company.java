package fr.cdiEnterprise.model;

import fr.cdiEnterprise.service.Languages;

/**
 * Cette classe repr�sente une fiche entreprise qui sera renseign�e par un
 * utilisateur. 
 * 
 * @author Ana�s
 * @version 07-10-2016
 *
 */
public class Company {

	private static int id;
	private int idEnterprise;
	private String companyName;
	private String adress;
	private String postalCode;
	private String city;
	private Department department;
	private Region region;
	private String sector;
	private String size;
	private Languages languages;
	private String projets;
	private String webSite;
	private Contact contact;

	/**
	 * Constructeur par d�faut, ne prend pas de param�tres
	 */
	public Company() {
	}

	public Company(String companyName, String adress, String postalCode, String city, Department department) {
		id++;
		this.companyName = companyName;
		this.adress = adress;
		this.postalCode = postalCode;
		this.city = city;
		this.department = department;
		this.idEnterprise = id;
	}

	/**
	 * Constructeur avec attributs
	 * 
	 * @param companyName
	 * @param adress
	 * @param postalCode
	 * @param city
	 * @param department
	 * @param region
	 * @param sector
	 * @param languages
	 * @param webSite
	 * @param contact
	 */
	public Company(String companyName, String adress, String postalCode, String city, Department department, Region region, String size,
			String sector,  Languages languages,String projets, String webSite, Contact contact) {
		id++;
		this.companyName = companyName;
		this.adress = adress;
		this.postalCode = postalCode;
		this.city = city;
		this.department = department;
		this.region = region;
		this.sector = sector;
		this.size = size;
		this.languages = languages;
		this.projets=projets;
		this.webSite = webSite;
		this.contact = contact;
		this.idEnterprise = id;
	}

	/**
	 * Ensemble des getters de la clase Company
	 */

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * @return the sector
	 */
	public String getSector() {
		return sector;
	}
	
	public String getSize() {
		return size;
	}

	/**
	 * @return the languages
	 */
	public Languages getLanguages() {
		return getLanguages();
	}

	public String getProjets(){
		return projets;
	}
	/**
	 * @return the webSite
	 */
	public String getWebSite() {
		return webSite;
	}

	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}

	/**
	 * @return the idEnterprise
	 */
	public int getIdEnterprise() {
		return idEnterprise;
	}

	/**
	 * Ensemble des setteurs de la clase Company
	 */

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @param companyName
	 *            the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @param adress
	 *            the adress to set
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	/**
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @param region
	 *            the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * @param sector
	 *            the sector to set
	 */
	public void setSector(String sector) {
		this.sector = sector;
	}

	/**
	 * @param languages
	 *            the languages to set
	 */
	public void setLanguages(Languages languages) {
		this.languages = languages;
	}

	/**
	 * @param projets
	 *            the projets to set
	 */
	public void setProjets(String projets) {
		this.projets = projets;
	}
	
	
	/**
	 * @param webSite
	 *            the webSite to set
	 */
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	/**
	 * @param contact
	 *            the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	/**
	 * @param idEnterprise
	 *            the idEnterprise to set
	 */
	public void setIdEnterprise(int idEnterprise) {
		this.idEnterprise = idEnterprise;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Entreprise [companyName=" + companyName + ", adress=" + adress + ", postalCode=" + postalCode
				+ ", city=" + city + ", department=" + department + ", region=" + region +", langages=" + languages.toString() + ", size=" + size + ", sector= " + sector 
				+ ", webSite=" + webSite + ", contact=" + contact + "]";
	}

	@Override
	public void finalize() {
		System.gc();
		System.out.println("Game Over, try again");
	}
}
