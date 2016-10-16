package fr.cdiEnterprise.model;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Abstract base class for all User creation: Trainee, FormerTrainee, Trainer.
 * @author Claire
 * @version 13-10-2016
 */

public abstract class User {

	//Auto-generated
	private static int totalId = 0;							// Auto-generated total user's number since the beginning
	private int id;											// Id number for user
	private String inscriptionDate;							// Date of registration for user

	//Compulsory first log-in information
	private String status;									// Three possible choices: Trainee, FormerTrainee, Trainer
	private String email;									// User's email (can be use for log-in)
	private String alias;									// User's nickname for log-in
	private String password;								// User's password (minimum 8 characters)
	private String afpa;									// Name of the AFPA the user go/went to or work for


	/**
	 * Default constructor
	 */
	public User(){	
	}
	
	// Constructor test
	public User(String status, String alias, String email, String afpa) {
		totalId++;
		this.id = totalId;
		this.inscriptionDate = setInscriptionDate();
		this.status = status;
		this.alias = alias;
		this.email = email;
		this.afpa = afpa;
	}

//	/**
//	 * Constructs a user with compulsory first log-in informations
//	 * @param email
//	 * @param alias
//	 * @param password
//	 * @param status
//	 * @param afpa
//	 */
//	public User(String email, String alias, String password, String status, String afpa) {
//		totalId++;
//		this.id = totalId;
//		this.email = email;
//		this.alias = alias;
//		this.password = password;
//		this.status = status;
//		this.afpa = afpa;
//	}


	/**
	 * Generates a date and time from the "Europe/Paris" zone when a User is created.
	 * @author Claire
	 * @return inscriptionDate
	 * @since 16-10-2016
	 */
	public String setInscriptionDate() {
		
		DateTimeFormatter formatter;
		ZonedDateTime zdt;
		String inscriptionDate;
		
		formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		zdt = Instant.now().atZone(ZoneId.of("Europe/Paris"));
		inscriptionDate = zdt.format(formatter);
		
		return inscriptionDate;
		
	}
	
	/**
	 * Basic user description.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", inscriptionDate=" + inscriptionDate + ", status=" + status + ", alias=" + alias
				+ ", email=" + email + ", afpa=" + afpa + "]";
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the afpa
	 */
	public String getAfpa() {
		return afpa;
	}

	/**
	 * @param afpa the afpa to set
	 */
	public void setAfpa(String afpa) {
		this.afpa = afpa;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the inscriptionDate
	 */
	public String getInscriptionDate() {
		return inscriptionDate;
	}

	/**
	 * @return the totalId
	 */
	public static int getTotalId() {
		return totalId;
	}

}