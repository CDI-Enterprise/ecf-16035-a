package fr.cdiEnterprise.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

/**
 * @author Claire
 *
 */
public class ProfileCreationFrame extends MainFrame {

	/**
	 * Frame for a user's profile creation.
	 * Last update: 20161002
	 * @version 1.0
	 * @author Claire
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public ProfileCreationFrame() {
		super();
		//Override title from MainFrame
		
		/* Header with one title */
		JPanel panNorth = new JPanel();
		panMain.add(panNorth, BorderLayout.NORTH);
		panNorth.setLayout(new MigLayout());
		panNorth.add(new JLabel("CRÉATION DE PROFIL"), "center, wrap 15");
		panNorth.add(new JLabel("Les champs marqués d'étoiles sont obligatoires pour : "
				+ "* tous les utilisateurs / "
				+ "** les statuts Stagiaire et Ancien / "
				+ "*** le statut Ancien"));
		panNorth.setBorder(BorderFactory.createLineBorder(Color.WHITE));	
		
		/* Body */
		//Main center panel with four horizontal parts
		JPanel panCenter = new JPanel();
		panMain.add(panCenter, BorderLayout.CENTER);
		panCenter.setLayout(new GridLayout(4,1));
		
		//Second horizontal part: first log-in informations
		JPanel panCenterRegister = new JPanel();
		panCenter.add(panCenterRegister);
		panCenterRegister.setLayout(new MigLayout());
		panCenterRegister.setBorder(BorderFactory.createTitledBorder("ENREGISTREMENT"));
	
		
		//panCenterRegister.add(new JLabel("Les champs marquées d'un * sont obligatoires pour tous."), "wrap");
		
		//User alias
		panCenterRegister.add(new JLabel("Nom d'utilisateur* : "), "w 150!");
		panCenterRegister.add(new JTextField(20));
		panCenterRegister.add(new JLabel("<html><body><i>Maximum 20 caractères</i></body></html>"), "gapleft20, wrap");
		
		//User email
		panCenterRegister.add(new JLabel("Mail* : "));
		panCenterRegister.add(new JTextField(20));
		panCenterRegister.add(new JLabel("<html><body><i>Ne sera pas rendu public</i></body></html>"), "gapleft20, wrap");
		
		//User status TODO One selection possible
		panCenterRegister.add(new JLabel("Statut* : "));
		panCenterRegister.add(new JRadioButton("Stagiaire"));
		panCenterRegister.add(new JRadioButton("Ancien"));
		panCenterRegister.add(new JRadioButton("Formateur"), "wrap");
		
		//Name of AFPA where the user did his training
		panCenterRegister.add(new JLabel("AFPA* : "));
		panCenterRegister.add(new JTextField(20), "wrap");
		
		//User trainer
		panCenterRegister.add(new JLabel("Nom du formateur** : "));
		panCenterRegister.add(new JTextField(20), "wrap");
		
		//Third horizontal part: public profile informations
		JPanel panCenterPublic = new JPanel();
		panCenter.add(panCenterPublic);
		panCenterPublic.setLayout(new MigLayout());
		panCenterPublic.setBorder(BorderFactory.createTitledBorder("PROFIL PUBLIC"));
		
		//Code of training session, usually 5 numbers
		panCenterPublic.add(new JLabel("Numéro de session** : "), "w 150!");
		panCenterPublic.add(new JTextField(20), "wrap");
		
		//Main programming language of the training
		panCenterPublic.add(new JLabel("Langage principal** : "));
		String [] language = {"C#", "Java"};
		JComboBox<String> cboLanguage = new JComboBox<String> ();
		for (int i = 0; i<language.length; i++) {
			cboLanguage.addItem(language[i]);
		}
		cboLanguage.setMaximumRowCount(2);
		panCenterPublic.add(cboLanguage);
		
		//
		
		//Fourth horizontal part: protected profile informations
		JPanel panCenterProtected = new JPanel();
		panCenter.add(panCenterProtected);
		panCenterProtected.setLayout(new MigLayout());
		panCenterProtected.setBorder(BorderFactory.createTitledBorder("PROFIL RESTREINT"));
		
		//Fifth horizontal part: optional profile informations
		JPanel panCenterOptional = new JPanel();
		panCenter.add(panCenterOptional);
		panCenterOptional.setLayout(new MigLayout());
		panCenterOptional.setBorder(BorderFactory.createTitledBorder("VISIBLE PUBLIQUEMENT SI RENSEIGNÉ"));
		
		//Footer with two buttons
		JPanel panSouth = new JPanel();
		panMain.add(panSouth, BorderLayout.SOUTH);
		panSouth.setLayout(new FlowLayout());
		panSouth.add(new JButton("Annuler"));
		panSouth.add(new JButton("S'enregistrer"));
		
	}

}
