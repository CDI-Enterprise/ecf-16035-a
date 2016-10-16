package fr.cdiEnterprise.model;

/**
 * Class for FormerTrainee creation.
 * @author Claire
 * @see fr.cdiEnterprise.model.User, fr.cdiEnterprise.model.Trainee
 * @version 13-10-2016
 */

public class FormerTrainee extends Trainee {

	//Compulsory profile (public/protected) information (approacheCompany from super-class compulsory here)
	private String currentProfession;						// Actual occupation, job-seeker possible
	private Company currentCompany;							// Actual company where former trainee works, none possible
	private Company formerCompany;							// Former companies where former trainee worked, none possible
	
	
	// Constructor test
	public FormerTrainee(String status, String alias, String email, String afpa, String trainer) {
		super(status, alias, email, afpa, trainer);
	}
		
	/**
	 * Default constructor
	 */
	public FormerTrainee() {
		super();
	}

//	/**
//	 * Constructs a former trainee with compulsory first log-in and profile informations
//	 * Compulsory parameters from super class (log-in informations)
//	 * @param email
//	 * @param alias
//	 * @param password
//	 * @param status
//	 * @param afpa
//	 * @param trainer
//	 *  
//	 * Compulsory parameters from super class (profile creation)
//	 * @param surname
//	 * @param givenName
//	 * @param sessionCode
//	 * @param programmingLanguage
//	 * @param approachedCompany
//	 * 
//	 * Compulsory parameters (profile creation)
//	 * @param currentProfession
//	 * @param currentCompany
//	 * @param formerCompany
//	 * 
//	 * Optional parameters from super class (profile creation)
//	 * @param graphicAPI;
//	 * @param webSite;
//	 * @param linkedIn;
//	 * 
//	 */
//	public FormerTrainee(String email, String alias, String password, String status, String afpa, String trainer,
//			String surname, String givenName, String sessionCode, Company approachedCompany,
//			String programmingLanguage, String graphicAPI, String webSite, String linkedIn,
//			String currentProfession, Company currentCompany, Company formerCompany) {
//		super(email, alias, password, status, afpa, trainer, surname, givenName, sessionCode, approachedCompany,
//				programmingLanguage, graphicAPI, webSite, linkedIn);
//		this.currentProfession = currentProfession;
//		this.currentCompany = currentCompany;
//		this.formerCompany = formerCompany;
//	}

	
	/* Object methods */
	//TODO Claire create input control

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "FormerTrainee [currentProfession=" + currentProfession + ", currentCompany=" + currentCompany
				+ ", formerCompany=" + formerCompany + "]";
	}
	
//	/**
//	 * @return String 
//	 * @see java.lang.Object#toString()
//	 */
//	@Override
//	public String toString() {
//		String newLine = System.getProperty("line.separator");
//		
//		return
//				super.toString()
//				+ newLine
//				+ newLine + "INFORMATIONS ANCIEN STAGIAIRE"
//				+ newLine + "Profession actuelle : " + currentProfession
//				+ newLine + "Entreprise actuelle : " + currentCompany
//				+ newLine + "Ancienne(s) entreprise(s) : " + formerCompany;
//	}

	
	/* Object - Getter & setter */
	/**
	 * @return the currentProfession
	 */
	public String getCurrentProfession() {
		return currentProfession;
	}

	/**
	 * @param currentProfession the currentProfession to set
	 */
	public void setCurrentProfession(String currentProfession) {
		this.currentProfession = currentProfession;
	}

	/**
	 * @return the currentCompany
	 */
	public Company getCurrentCompany() {
		return currentCompany;
	}

	/**
	 * @param currentCompany the currentCompany to set
	 */
	public void setCurrentCompany(Company currentCompany) {
		this.currentCompany = currentCompany;
	}

	/**
	 * @return the formerCompany
	 */
	public Company getFormerCompany() {
		return formerCompany;
	}

	/**
	 * @param formerCompany the formerCompany to set
	 */
	public void setFormerCompany(Company formerCompany) {
		this.formerCompany = formerCompany;
	}
	
}
