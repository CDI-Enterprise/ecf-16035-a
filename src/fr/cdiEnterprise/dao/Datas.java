/**
 * 
 */
package fr.cdiEnterprise.dao;

import fr.cdiEnterprise.model.Trainee;
import fr.cdiEnterprise.service.Users;

/**
 * @author Claire
 *
 */
public class Datas {

	private static Users usersList;
	
	/**
	 * 
	 */
	public Datas() {
	
	}

	public static void init() {
		
		usersList = new Users();
		usersList.add(new Trainee("email@boite.fr", "Pseudo1", "mdp", "Stagiaire", "Saint-Jérôme", "D. Muller", "Nom1", "Prénom1",
				"16035", null, "Java", "Swing", "site.fr", "LI"));
		
	}

	/**
	 * @return the usersList
	 */
	public static Users getUsersList() {
		return usersList;
	}
	
}
