package fr.cdiEnterprise.model;

public class Company {

	private String companyName;
	private String adress;
	private String postalCode;
	private String city;
	private int department;
	private String region;
	private String domaine;
	private String webSite;
	private Contact contact;




	//Constructeur par défaut
	/**
	 * Constructeur par défaut, ne prend pas de paramètres
	 */
	public Company(){

	}
			
	//		//Constructeur
	//		/**
	//		 * Constructeur avec les attributs
	//		 * @param id
	//		 * @param civilite
	//		 * @param nom
	//		 * @param prenom
	//		 * @param eMail
	//		 * @param telFixe
	//		 * @param telPortable
	//		 * @param login
	//		 * @param inscription
	//		 */
	//		public User(int id, String civilite, String nom, String prenom, String eMail, String telFixe, String telPortable, 
	//			 String login, Date inscription){
	//		 this.setId(id); 
	//		 this.setCivilite (civilite); 
	//		 this.setNom(nom);
	//		 this.setPrenom(prenom); 
	//		 this.setEMail(eMail); 
	//		 this.setTelFixe(telFixe);
	//		 this.setTelPortable(telPortable);
	//		 this.setLogin(login);
	//		 this.setPw(pw);
	//		 this.setInscription(inscription);
	//	 }
	//
	//
	//		
	//		//Constructeur pour copie
	//		/**
	//		 * Constructeur par copie de données
	//		 * @param user
	//		 */
	//		public User (User user){
	//			this.id=user.id; 
	//			this.civilite=user.civilite; 
	//			this.nom=user.nom;
	//			this.prenom=user.prenom; 
	//			this.eMail=user.eMail; 
	//			this.telFixe= user.telFixe;
	//			this.telPortable=user.telPortable;
	//			this.login=user.login;
	//			this.pw=user.pw;
	//			this.inscription=user.inscription;
	//		}
	//		
	//		// set ==> Ecriture
	//		
	//		

	private String getCompanyName() {
		return companyName;
	}

	private void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	private String getAdress() {
		return adress;
	}

	private void setAdress(String adress) {
		this.adress = adress;
	}

	private String getPostalCode() {
		return postalCode;
	}

	private void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	private String getCity() {
		return city;
	}

	private void setCity(String city) {
		this.city = city;
	}

	private int getDepartment() {
		return department;
	}

	private void setDepartment(int department) {
		this.department = department;
	}

	private String getRegion() {
		return region;
	}

	private void setRegion(String region) {
		this.region = region;
	}

	private String getDomaine() {
		return domaine;
	}

	private void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	private String getWebSite() {
		return webSite;
	}

	private void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	private Contact getContact() {
		return contact;
	}

	private void setContact(Contact contact) {
		this.contact = contact;
	}

	//Fonction finalize
	@Override //Cette méthode est déjà définie quelque part
	public void finalize() {
		System.gc();
		System.out.println ("Game Over, try again");
	}
}