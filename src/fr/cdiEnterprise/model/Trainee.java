package fr.cdiEnterprise.model;

/**
 * Class for Trainee creation.
 * Last update: 20161001
 * 
 * @see fr.cdiEnterprise.model.User
 * @version 1.0
 * @author Claire
 *
 */

public class Trainee extends User {

	/* Object attributes */
	//Compulsory first log-in information
	private String trainer;									// AFPA trainer's name

	//Compulsory profile (public/protected) information
	private String surname;									// Trainee's surname, protected profile only
	private String givenName;								// Trainee's given name, protected profile only
	private int sessionCode;								// AFPA code for training session
	private String programmingLanguage;						// Known programming language, one compulsory

	//Optional profile information
	private String graphicAPI;								// Known graphic API
	private Company approachedCompany;						// Name of company approach by trainee
	private String webSite;									// Website's trainee
	private String linkedIn;								// LinkedIn address profile

	/* Constructors */
	/**
	 * Default constructor
	 */
	public Trainee(){
		super();
	}

	/**
	 * Constructs a trainee with compulsory first log-in, compulsory and optional profile informations
	 * Compulsory parameters from super class (log-in informations)
	 * @param email
	 * @param alias
	 * @param password
	 * @param status
	 * @param afpa
	 * 
	 * Compulsory parameters (log-in informations)
	 * @param trainer
	 * 
	 * Compulsory parameters (profile creation)
	 * @param surname
	 * @param givenName
	 * @param sessionCode
	 * @param programmingLanguage
	 * 
	 * Optional parameters (profile creation)
	 * @param approachedCompany
	 * @param graphicAPI;
	 * @param webSite;
	 * @param linkedIn;
	 */
	public Trainee(String email, String alias, String password, String status, String afpa, String trainer,
			String surname, String givenName, int sessionCode, Company approachedCompany,
			String programmingLanguage, String graphicAPI, String webSite, String linkedIn) {
		super(email, alias, password, status, afpa);
		this.trainer = trainer;
		this.surname = surname;
		this.givenName = givenName;
		this.sessionCode = sessionCode;
		this.approachedCompany = approachedCompany;
		this.programmingLanguage = programmingLanguage;
		this.graphicAPI = graphicAPI;
		this.webSite = webSite;
		this.linkedIn = linkedIn;
	}
	

	/* Object methods */
	//TODO create input control

	/**
	 * @return String 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String newLine = System.getProperty("line.separator");
		
		return super.toString()
			+ newLine + "Formateur : " + trainer
			+ newLine
			+ newLine + "INFORMATIONS OBLIGATOIRES POUR CREATION DE PROFIL PUBLIC/RESTREINT"
			+ newLine + "Nom (restreint)  : " + surname
			+ newLine + "Prénom (restreint) : " + givenName
			+ newLine + "Session : " + sessionCode
			+ newLine + "Langage(s) : " + programmingLanguage
			+ newLine
			+ newLine + "INFORMATIONS PUBLIQUES FACULTATIVES"
			+ newLine + "Entreprise(s) démarchée(s) : " + approachedCompany
			+ newLine + "API(s) graphique : " + graphicAPI
			+ newLine + "Site Internet : " + webSite
			+ newLine + "LinkedIn : " + linkedIn;
	}

	
	/* Object - Getter & setter */
	/**
	 * @return the trainer
	 */
	public String getTrainer() {
		return trainer;
	}

	/**
	 * @param trainer the trainer to set
	 */
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the givenName
	 */
	public String getGivenName() {
		return givenName;
	}

	/**
	 * @param givenName the givenName to set
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	/**
	 * @return the sessionCode
	 */
	public int getSessionCode() {
		return sessionCode;
	}

	/**
	 * @param sessionCode the sessionCode to set
	 */
	public void setSessionCode(int sessionCode) {
		this.sessionCode = sessionCode;
	}

	/**
	 * @return the programmingLanguage
	 */
	public String getProgrammingLanguage() {
		return programmingLanguage;
	}

	/**
	 * @param programmingLanguage the programmingLanguage to set
	 */
	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}

	/**
	 * @return the graphicAPI
	 */
	public String getGraphicAPI() {
		return graphicAPI;
	}

	/**
	 * @param graphicAPI the graphicAPI to set
	 */
	public void setGraphicAPI(String graphicAPI) {
		this.graphicAPI = graphicAPI;
	}

	/**
	 * @return the approachedCompany
	 */
	public Company getApproachedCompany() {
		return approachedCompany;
	}

	/**
	 * @param approachedCompany the approachedCompany to set
	 */
	public void setApproachedCompany(Company approachedCompany) {
		this.approachedCompany = approachedCompany;
	}

	/**
	 * @return the webSite
	 */
	public String getWebSite() {
		return webSite;
	}

	/**
	 * @param webSite the webSite to set
	 */
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	/**
	 * @return the linkedIn
	 */
	public String getLinkedIn() {
		return linkedIn;
	}

	/**
	 * @param linkedIn the linkedIn to set
	 */
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	
}
