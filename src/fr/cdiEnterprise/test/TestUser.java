package fr.cdiEnterprise.test;

import fr.cdiEnterprise.model.Trainee;
import fr.cdiEnterprise.model.User;

/**
 * @author Claire
 *
 */
public class TestUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Remove abstract from User class for test
//		User userTest = new User("email@boite.org", "Pseudo", "MdP", "Stagiaire", "St-J�r�me");
//		System.out.println(userTest.toString());
		
		Trainee trainee1 = new Trainee("email@boite.fr", "Pseudo1", "motpasse", "stagiaire", "St-J", "Muller",
				"Nom1", "Pr�nom1", 16035, null,
				"Java", "Swing", "blabla.com", "Mon profil LI");
		System.out.println(trainee1.toString());
	}

}
