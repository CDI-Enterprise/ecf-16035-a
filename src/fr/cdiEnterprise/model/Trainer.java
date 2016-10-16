package fr.cdiEnterprise.model;

/**
 * Class for Trainer creation.
 * @author Claire
 * @see fr.cdiEnterprise.model.User
 * @version 01-10-2016
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
	 * @param status
	 * @param afpa
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
