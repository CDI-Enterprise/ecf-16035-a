package fr.cdiEnterprise.test;

import fr.cdiEnterprise.model.FormerTrainee;
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
//		User userTest = new User("email@boite.org", "Pseudo", "MdP", "Stagiaire", "St-Jérôme");
//		System.out.println(userTest.toString());
		
		Trainee trainee1 = new Trainee("email@boite.fr", "Pseudo1", "motpasse", "stagiaire", "St-J", "Muller",
				"Nom1", "Prénom1", 16035, null,
				"Java", "Swing", "blabla.com", "Mon profil LI");
		System.out.println(trainee1.toString());
		
		FormerTrainee formerTrainee1 = new FormerTrainee("email2@boite.fr", "Pseudo2", "motpasse2", "ancien", "St-Jé", "Muller D",
				"Nom2", "Prénom2", 16035, null,
				"Java", "Swing", "blabla.com", "Mon profil LI",
				"2015", "Développeur Java", null, null);
		System.out.println(formerTrainee1.toString());
		
	}

}
