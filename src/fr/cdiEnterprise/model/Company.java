package fr.cdiEnterprise.model;

/**
 * Cette classe représente une fiche entreprise qui sera renseignée par un
 * utilisateur.
 * 
 * @author Anaïs
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
	private int department;
	private String region;
	private String sector;
	private String languages;
	private String webSite;
	private Contact contact;

	/**
	 * Constructeur par défaut, ne prend pas de paramètres
	 */
	public Company() {
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
	public Company(String companyName, String adress, String postalCode, String city, int department, String region,
			String sector, String languages, String webSite, Contact contact) {
		id++;
		this.companyName = companyName;
		this.adress = adress;
		this.postalCode = postalCode;
		this.city = city;
		this.department = department;
		this.region = region;
		this.sector = sector;
		this.languages = languages;
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
	public int getDepartment() {
		return department;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @return the sector
	 */
	public String getSector() {
		return sector;
	}

	/**
	 * @return the languages
	 */
	public String getLanguages() {
		return languages;
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
	public void setDepartment(int department) {
		this.department = department;
	}

	/**
	 * @param region
	 *            the region to set
	 */
	public void setRegion(String region) {
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
	public void setLanguages(String languages) {
		this.languages = languages;
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
				+ ", city=" + city + ", department=" + department + ", region=" + region + ", domaine=" + sector
				+ ", webSite=" + webSite + ", contact=" + contact + "]";
	}

	@Override
	public void finalize() {
		System.gc();
		System.out.println("Game Over, try again");
	}
}
