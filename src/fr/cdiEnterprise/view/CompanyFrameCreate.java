package fr.cdiEnterprise.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class CompanyFrameCreate extends MainFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompanyFrameCreate() {
		super();
		this.setTitle("CDI Enterprise - Création d'une fiche entreprise");

		mainPan.setLayout(new BorderLayout());
		
		/* Header */
		JPanel panNorth = new JPanel();
		mainPan.add(panNorth, BorderLayout.NORTH);
		panNorth.setLayout(new FlowLayout());
		//Main information on compulsory fields
		JLabel lblFieldInfo = new JLabel("Les champs marqués d'étoiles sont obligatoires");
		lblFieldInfo.setFont(new Font(getName(), Font.BOLD, 14));
		panNorth.add(lblFieldInfo);
		panNorth.setBorder(BorderFactory.createLineBorder(Color.RED));	
		
//		/* Body */
//		//Main center panel with four horizontal parts
//		JPanel panCenter = new JPanel();
//		panMain.add(panCenter, BorderLayout.CENTER);
//		panCenter.setLayout(new MigLayout());
//	
//		
//		//FIRST horizontal part: first log-in informations
//		JPanel panCenterRegister = new JPanel();
//		panCenter.add(panCenterRegister, "wrap, w 1425!");
//		panCenterRegister.setLayout(new MigLayout());
//		panCenterRegister.setBorder(BorderFactory.createTitledBorder("ENREGISTREMENT"));
//		
//		//User alias
//		JLabel lblAlias = new JLabel("Nom d'utilisateur* : ");
//		panCenterRegister.add(lblAlias, "w 200!");
//		panCenterRegister.add(new JTextField(20));
//		panCenterRegister.add(new JLabel("<html><body><i>Maximum 20 caractères</i></body></html>"), "gapleft20, wrap");
//		
//		//User email
//		panCenterRegister.add(new JLabel("Mail* : "));
//		panCenterRegister.add(new JTextField(20));
//		panCenterRegister.add(new JLabel("<html><body><i>Ne sera pas rendu public</i></body></html>"), "gapleft20, wrap");
//		
//		//User status TODO one status possible
//		panCenterRegister.add(new JLabel("Statut* : "));
//		panCenterRegister.add(new JRadioButton("Stagiaire"));
//		panCenterRegister.add(new JRadioButton("Ancien"));
//		panCenterRegister.add(new JRadioButton("Formateur"), "wrap");
//		
//		//Name of AFPA where the user did his training
//		panCenterRegister.add(new JLabel("AFPA* : "));
//		panCenterRegister.add(new JTextField(20), "wrap");
//		
//		//User trainer
//		panCenterRegister.add(new JLabel("Nom du formateur** : "));
//		panCenterRegister.add(new JTextField(20));
//		
//		
//		//SECOND horizontal part: public profile informations
//		JPanel panCenterPublic = new JPanel();
//		panCenter.add(panCenterPublic, "wrap, w 1425!");
//		panCenterPublic.setLayout(new MigLayout());
//		panCenterPublic.setBorder(BorderFactory.createTitledBorder("PROFIL PUBLIC"));
//		
//		//Code of training session, usually 5 numbers
//		panCenterPublic.add(new JLabel("Numéro de session** : "), "w 200!");
//		panCenterPublic.add(new JTextField(20), "wrap");
//		
//		//Main programming language of the training
//		panCenterPublic.add(new JLabel("Langage principal** : "));
//		panCenterPublic.add(new JRadioButton("C#"));
//		panCenterPublic.add(new JRadioButton("Java"), "wrap");
//		
//		//List of approached companies
//		panCenterPublic.add(new JLabel("Entreprise(s) démarchée(s)*** : "));
//		JComboBox<String> approachedCie = new JComboBox<String> ();
//		for (int i = 0; i<company.length; i++) {
//			approachedCie.addItem(company[i]);
//		}
//		approachedCie.setMaximumRowCount(5);
//		panCenterPublic.add(approachedCie, "wrap");
//		
//		//Current profession
//		panCenterPublic.add(new JLabel("Profession actuelle*** : "));
//		panCenterPublic.add(new JTextField(20), "wrap");
//		
//		//Current company
//		panCenterPublic.add(new JLabel("Entreprise actuelle*** : "));
//		JComboBox<String> currentCie = new JComboBox<String> ();
//		for (int i = 0; i<company.length; i++) {
//			currentCie.addItem(company[i]);
//		}
//		currentCie.setMaximumRowCount(5);
//		panCenterPublic.add(currentCie, "wrap");
//		
//		//Former company
//		panCenterPublic.add(new JLabel("Ancienne(s) entreprise(s)*** : "));
//		JComboBox<String> formerCie = new JComboBox<String> ();
//		for (int i = 0; i<company.length; i++) {
//			formerCie.addItem(company[i]);
//		}
//		formerCie.setMaximumRowCount(5);
//		panCenterPublic.add(formerCie, "wrap");
//		
//		
//		//THIRD horizontal part: protected profile informations
//		JPanel panCenterProtected = new JPanel();
//		panCenter.add(panCenterProtected, "wrap, w 1425!");
//		panCenterProtected.setLayout(new MigLayout());
//		panCenterProtected.setBorder(BorderFactory.createTitledBorder("PROFIL RESTREINT"));
//		
//		//Trainee surname for trainer (monitoring)
//		panCenterProtected.add(new JLabel("Nom** : "), "w 200!");
//		panCenterProtected.add(new JTextField(20), "wrap");
//		
//		//Trainee given name for trainer (monitoring)
//		panCenterProtected.add(new JLabel("Prénom** : "));
//		panCenterProtected.add(new JTextField(20), "wrap");
//		
//		
//		//FOURTH horizontal part: optional profile informations
//		JPanel panCenterOptional = new JPanel();
//		panCenter.add(panCenterOptional, "w 1425!");
//		panCenterOptional.setLayout(new MigLayout());
//		panCenterOptional.setBorder(BorderFactory.createTitledBorder("VISIBLE PUBLIQUEMENT SI RENSEIGNÉ"));
//	
//		//Other known programming languages
//		panCenterOptional.add(new JLabel("Autre(s) langage(s) : "), "w 200!");
//		String [] progLanguage = {"C", "PHP"};
//		JComboBox<String> cboProgLanguage = new JComboBox<String> ();
//		for (int i = 0; i<progLanguage.length; i++) {
//			cboProgLanguage.addItem(progLanguage[i]);
//		}
//		cboProgLanguage.setMaximumRowCount(2);
//		panCenterOptional.add(cboProgLanguage, "wrap");
//		
//		//Known graphic API
//		panCenterOptional.add(new JLabel("API graphique : "), "w 200!");
//		String [] graphicApi = {"AWT", "JFace", "Swing", "SWT"};
//		JComboBox<String> cboGraphicApi = new JComboBox<String> ();
//		for (int i = 0; i<graphicApi.length; i++) {
//			cboGraphicApi.addItem(graphicApi[i]);
//		}
//		cboGraphicApi.setMaximumRowCount(4);
//		panCenterOptional.add(cboGraphicApi, "wrap");
//		
//		//User website
//		panCenterOptional.add(new JLabel("Site Internet : "), "w 200!");
//		panCenterOptional.add(new JTextField(20), "wrap");
//		
//		//User LinkedIn
//		panCenterOptional.add(new JLabel("Profil LinkedIn"));
//		panCenterOptional.add(new JTextField(20), "wrap");
//		
//		
//		//Footer with two buttons
//		JPanel panSouth = new JPanel();
//		panMain.add(panSouth, BorderLayout.SOUTH);
//		panSouth.setLayout(new FlowLayout());
//		panSouth.add(new JButton("Annuler"));
//		panSouth.add(new JButton("S'enregistrer"));
		
	}

}
