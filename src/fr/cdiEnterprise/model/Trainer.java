package fr.cdiEnterprise.model;

/**
 * Class for Trainer creation.
 * Last update: 20161001
 * 
 * @see fr.cdiEnterprise.model.User
 * @version 1.0
 * @author Claire
 *
 */
public class Trainer extends User {

	/**
	 * 
	 */
	public Trainer() {
		super();
	}

	/**
	 * @param email
	 * @param alias
	 * @param password
	 * @param status
	 * @param afpa
	 */
	public Trainer(String email, String alias, String password, String status, String afpa) {
		super(email, alias, password, status, afpa);
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
