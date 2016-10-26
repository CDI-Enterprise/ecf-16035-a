package fr.cdiEnterprise.model;


/**
 * Class for Trainer creation.
 * 
 * @author Claire
 * @see fr.cdiEnterprise.model.User
 * @version 01-10-2016
 * 
 */
public class Trainer extends User {

	// Constructor test for DB
	public Trainer(int id, String inscriptionDate, String status, String alias, String email, String afpa) {
		super(id, inscriptionDate, status, alias, email, afpa);
	}

	/**
	 * @param email
	 * @param alias
	 * @param status
	 * @param afpa
	 * @throws ZeroLenghtStringException 
	 */
	public Trainer(String status, String alias, String email, String afpa) {
		super(status, alias, email, afpa);
	}

	/**
	 * @return String 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString();
	}

}
