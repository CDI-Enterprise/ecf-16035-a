package fr.cdiEnterprise.test;

import java.util.Scanner;

//import fr.cdiEnterprise.model.FormerTrainee;
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
		
		//Different type of user's creation with hard coded data
//		Trainee trainee1 = new Trainee("email@boite.fr", "Pseudo1", "motpasse", "stagiaire", "St-J", "Muller",
//				"Nom1", "Prénom1", "16035", null,
//				"Java", "Swing", "blabla.com", "Mon profil LI");
//		System.out.println(trainee1.toString());
//		
//		FormerTrainee formerTrainee1 = new FormerTrainee("email2@boite.fr", "Pseudo2", "motpasse2", "ancien", "St-Jé", "Muller D",
//				"Nom2", "Prénom2", "16035", null,
//				"Java", "Swing", "blabla.com", "Mon profil LI",
//				"Développeur Java", null, null);
//		System.out.println(formerTrainee1.toString());
		
		Trainer trainer1 = new Trainer("email@boite.fr", "Pseudo1", "motpasse", "formateur", "St-J");
		System.out.println(trainer1.toString());
		
		
		//Testing input control for User methods
		Scanner sc = new Scanner(System.in);
		
	//	String alias, email, password, status, afpa;
		
		System.out.println("Création de profil"
				+ "\nEnregistrement "
				+ "\nLes champs marqués d'un * sont obligatoires pour tous.");
		
		Trainee trainee2 = new Trainee();
		
		System.out.println("\nNom d'utilisateur* : ");
		trainee2.setAlias(sc.nextLine()); 
		System.out.println(trainee2.getAlias());
		
		System.out.println("Adresse email* : ");
		trainee2.setEmail(sc.nextLine());
		System.out.println(trainee2.getAlias());
		
		System.out.println("Mot de passe* : ");
		trainee2.setPassword(sc.nextLine());
		System.out.println(trainee2.getPassword());
		
		System.out.println("Satut* : ");
		trainee2.setStatus(sc.nextLine());
		System.out.println(trainee2.getStatus());
		
		System.out.println("Nom de l'AFPA* : ");
		trainee2.setAfpa(sc.nextLine());
		System.out.println(trainee2.getAfpa());
		
		System.out.println("Nom du formateur : "
				+ "* pour Stagiaire et Ancien");
		trainee2.setTrainer(sc.nextLine());
		System.out.println(trainee2.getTrainer());		
		
		sc.close();
		
	}

}
