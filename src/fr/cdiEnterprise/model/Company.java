package fr.cdiEnterprise.model;

/**
 * Cette classe représente une fiche entreprise qui sera renseignée par un utilisateur.
 * 
 * @author Anaïs
 * @version 30-09-2016
 *
 */
public class Company {

	private String companyName;
	private String adress;
	private String postalCode;
	private String city;
	private int department;
	private String region;
	private String sector;
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
	 * @param webSite
	 * @param contact
	 */
	public Company(String companyName, String adress, String postalCode, String city, int department, String region,
			String domaine, String webSite, Contact contact) {

		this.companyName = companyName;
		this.adress = adress;
		this.postalCode = postalCode;
		this.city = city;
		this.department = department;
		this.region = region;
		this.sector = domaine;
		this.webSite = webSite;
		this.contact = contact;
	}

	/**
	 * @return the companyName
	 */
	private String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName
	 *            the companyName to set
	 */
	private void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the adress
	 */
	private String getAdress() {
		return adress;
	}

	/**
	 * @param adress
	 *            the adress to set
	 */
	private void setAdress(String adress) {
		this.adress = adress;
	}

	/**
	 * @return the postalCode
	 */
	private String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode
	 *            the postalCode to set
	 */
	private void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the city
	 */
	private String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	private void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the department
	 */
	private int getDepartment() {
		return department;
	}

	/**
	 * @param department
	 *            the department to set
	 */
	private void setDepartment(int department) {
		this.department = department;
	}

	/**
	 * @return the region
	 */
	private String getRegion() {
		return region;
	}

	/**
	 * @param region
	 *            the region to set
	 */
	private void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the domaine
	 */
	private String getDomaine() {
		return sector;
	}

	/**
	 * @param domaine
	 *            the domaine to set
	 */
	private void setDomaine(String domaine) {
		this.sector = domaine;
	}

	/**
	 * @return the webSite
	 */
	private String getWebSite() {
		return webSite;
	}

	/**
	 * @param webSite
	 *            the webSite to set
	 */
	private void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	/**
	 * @return the contact
	 */
	private Contact getContact() {
		return contact;
	}

	/**
	 * @param contact
	 *            the contact to set
	 */
	private void setContact(Contact contact) {
		this.contact = contact;
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
