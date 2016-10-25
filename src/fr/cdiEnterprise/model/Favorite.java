/**
 * 
 */
package fr.cdiEnterprise.model;

/**
 *This class describe different parameters in a bookmark's user.
 * 
 *14 oct. 2016
 * @author Ismael
 *ecf-16035-a
 *22:06:18
 */

public class Favorite 
{
	private static int id;
	private int idEnterprise;
	private String companyName;
	private NoteCompany noteCompany;
	private String city;
	private String size;
	private String sector;
	private String webSite;
	private Contact contactMail;

	//public static final String[] FAVORITES ={"First DAO", "Second JAVA", "Third Windows", "Fourth UML", "Fifth SQL", "Sixth PENCIL", 
	//		"Seven POWERAMC","Eighth BALSAMIQUE", "Ninth WEB", "Tenth ZERO"};

	/**
	 * Default constructor
	 * @param noteCompany 
	 */

	public Favorite(NoteCompany noteCompany) 
	{
		id++;
		this.noteCompany	= noteCompany;

	}

	//	public Favorite(String companyName, String city, String size, String sector, String webSite, Contact contactMail)
	//	{
	//		id++;
	//		this.idEnterprise	= id;
	//		this.companyName 	= companyName;
	//		this.city 			= city;
	//		this.size			= size;
	//		this.sector			= sector;
	//		this.webSite		= webSite;
	//	}

	/**
	 * Constructor with parameters
	 * 
	 * @param companyName
	 * @param city
	 * @param size
	 * @param sector
	 * @param website
	 * @param contactMail
	 * 
	 */

	public Favorite(String companyName, NoteCompany noteCompany,String city, String size, String sector, String webSite, Contact contactMail) 
	{
		super();
		id++;
		this.idEnterprise = id;
		this.companyName 	= companyName;
		this.noteCompany	= noteCompany;
		this.city			= city;
		this.size			= size;
		this.sector			= sector;
		this.webSite		= webSite;
		this.contactMail	= contactMail;
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param city
	 * @param size
	 * @param sector
	 * @param website
	 * @param contactMail
	 * @param note
	 * 
	 */

	public Favorite(String city, String size, String sector, String webSite, String contactMail, NoteCompany note) 
	{
		super();
		id++;
		this.idEnterprise = id;
		this.city			= city;
		this.size			= size;
		this.sector			= sector;
		this.webSite		= webSite;
		//this.contactMail	= contactMail;
	}

	/**
	 * @param noteCompany2
	 */
	public Favorite(String noteCompany2) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Getters
	 */



	/**
	 * @return the idEnterprise
	 */
	public int getIdEnterprise() {
		return idEnterprise;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @return the noteCompany
	 */
	public NoteCompany getNoteCompany() {
		return noteCompany;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @return the sector
	 */
	public String getSector() {
		return sector;
	}

	/**
	 * @return the webSite
	 */
	public String getWebSite() {
		return webSite;
	}

	/**
	 * @return the contactMail
	 */
	public Contact getContactMail() {
		return contactMail;
	}


	/**
	 * Setters
	 */

	/**
	 * @param companyName
	 * the companyName to set
	 */
	public void setCompanyName(String companyName) 
	{
		this.companyName = companyName;
	}

	/**
	 * @param idEnterprise
	 *            the idEnterprise to set
	 */
	public void setIdEnterprise(int idEnterprise) 
	{
		this.idEnterprise = idEnterprise;
	}

	/**
	 * @param noteCompany the noteCompany to set
	 */
	public void setNoteCompany(NoteCompany noteCompany) {
		this.noteCompany = noteCompany;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @param sector the sector to set
	 */
	public void setSector(String sector) {
		this.sector = sector;
	}

	/**
	 * @param webSite the webSite to set
	 */
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	/**
	 * @param contactMail the contactMail to set
	 */
	public void setContactMail(Contact contactMail) {
		this.contactMail = contactMail;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Favorite [idEnterprise=" + idEnterprise + ", companyName=" + companyName + ", city=" + city + ", size="
				+ size + ", sector=" + sector + ", webSite=" + webSite + ", contactMail=" + contactMail + "]";
	}

	@Override
	public void finalize() {
		System.gc();
		System.out.println("This is end");
	}
}
