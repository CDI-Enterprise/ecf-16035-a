package fr.cdiEnterprise.test;

import fr.cdiEnterprise.model.FormerTrainee;
import fr.cdiEnterprise.model.Trainee;
import fr.cdiEnterprise.model.Trainer;

/**
 * @author Claire
 *
 */
public class TestUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Trainee trainee1 = new Trainee("email@boite.fr", "Pseudo1", "motpasse", "stagiaire", "St-J", "Muller",
				"Nom1", "Prénom1", 16035, null,
				"Java", "Swing", "blabla.com", "Mon profil LI");
		System.out.println(trainee1.toString());
		
		FormerTrainee formerTrainee1 = new FormerTrainee("email2@boite.fr", "Pseudo2", "motpasse2", "ancien", "St-Jé", "Muller D",
				"Nom2", "Prénom2", 16035, null,
				"Java", "Swing", "blabla.com", "Mon profil LI",
				"Développeur Java", null, null);
		System.out.println(formerTrainee1.toString());
		
		Trainer trainer1 = new Trainer("email@boite.fr", "Pseudo1", "motpasse", "formateur", "St-J");
		System.out.println(trainer1.toString());
		
	}

}
