package fr.cdiEnterprise.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import fr.cdiEnterprise.control.PanelUserListeners;
import fr.cdiEnterprise.dao.Datas;
import fr.cdiEnterprise.model.User;
import net.miginfocom.swing.MigLayout;

/**
 * Panel for a user's profile CRUD
 * Last update: 20161007
 * @version 0.0
 * @author Claire
 */
public class PanelUser extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//TODO fake companies list in database!
	String [] company = {"Aucune", "9e compagnie", "Cie", "Comme Pagny", "Autre..."};

	// Main panels
	private JPanel northPan;
	private JPanel westPan;
	private JPanel centerPan;
//	private JPanel eastPan;
	private JPanel southPan;

	// NORTH
	//Labels
	private JLabel lblFieldInfo;

	// WEST
	// First panel for first log-in informations
	private JPanel registerPan;
	// Labels
	private JLabel lblStatus;
	private JLabel lblAlias;
	private JLabel lblInfoAlias;
	private JLabel lblMail;
	private JLabel lblInfoMail;
	private JLabel lblAfpa;
	private JLabel lblFormer;
	// Others components
	private JRadioButton optTrainee;
	private JRadioButton optFormerTrainee;
	private JRadioButton optTrainer;
	private JTextField txtAlias;
	private JTextField txtMail;
	private JTextField txtAfpa;
	private JTextField txtFormer;

	// Second panel for public profile informations
	private JPanel publicPan;
	// Labels
	private JLabel lblSession;
	private JLabel lblMainInfoLang;
	private JLabel lblApproachedCie;
	private JLabel lblJob;
	private JLabel lblCurrentCie;
	private JLabel lblFormerCie;
	//Others components
	private JTextField txtSession;
	private JRadioButton optCsharp;
	private JRadioButton optJava;
	private JTextField txtJob;

	// Third panel for protected profile informations
	private JPanel protectedPan;
	// Labels
	private JLabel lblSurname;
	private JLabel lblGivenName;
	// Others components
	private JTextField txtSurname;
	private JTextField txtGivenName;

	// Fourth panel for optional profile informations
	private JPanel optionalPan;
	// Labels
	private JLabel lblInfoLang;
	private JLabel lblApi;
	private JLabel lblWebsite;
	private JLabel lblLinkedIn;
	// Others components
	private JTextField txtWebsite;
	private JTextField txtLinkedIn;
	
	// CENTER
	private DefaultListModel<User> mdlListUsers;
	private JList<User> lstUsers;
	private JScrollPane panListUsers;
	
	// SOUTH
	// JButton
	private JButton cmdCancel;
	private JButton cmdCreate;
	private JButton cmdUpdate;
	private JButton cmdDelete;

	public PanelUser() {

		// Main layout for book creation panel
		this.setLayout(new BorderLayout(20, 20));

		
		// NORTH - main information on compulsory fields
		northPan = new JPanel();
		northPan.setLayout(new FlowLayout());
		this.add(northPan, BorderLayout.NORTH);

		lblFieldInfo = new JLabel("Les champs marqués d'étoiles sont obligatoires pour : "
				+ "* tous les utilisateurs / "
				+ "** les statuts Stagiaire et Ancien / "
				+ "*** le statut Ancien");
		lblFieldInfo.setFont(new Font(getName(), Font.BOLD, 14));
		northPan.add(lblFieldInfo);
		northPan.setBorder(BorderFactory.createLineBorder(Color.RED));

		
		// TODO left margin
		// WEST - For create / update with four horizontal parts
		westPan = new JPanel();
		westPan.setLayout(new MigLayout());
//		westPan.setBorder(BorderFactory.createTitledBorder("Créer / modifier un utilisateur"));
		this.add(westPan, BorderLayout.WEST);
		JLabel lblRegisterPan = new JLabel("Créer / modifier un utilisateur");
		westPan.add(lblRegisterPan, "wrap");

		// FIRST horizontal part: first log-in informations
		registerPan = new JPanel();	
		registerPan.setLayout(new MigLayout());
		registerPan.setBorder(BorderFactory.createTitledBorder("ENREGISTREMENT"));
		westPan.add(registerPan, "wrap, w 475!");

		// User status TODO one status possible (listener)
		lblStatus = new JLabel("Statut* : ");
		registerPan.add(lblStatus, "w 200!");
		optTrainee = new JRadioButton("Stagiaire");
		optFormerTrainee = new JRadioButton("Ancien");
		optTrainer = new JRadioButton("Formateur");
		registerPan.add(optTrainee, "split 3");
		registerPan.add(optFormerTrainee);
		registerPan.add(optTrainer, "wrap");

		// User alias
		// TODO attribute for font, grey color
		lblAlias = new JLabel("Pseudo* : ");
		registerPan.add(lblAlias);
		txtAlias = new JTextField(20);
		registerPan.add(txtAlias, "wrap");
		lblInfoAlias = new JLabel("Maximum 20 caractères");
		lblInfoAlias.setFont(new Font(getName(), Font.ITALIC, 13));
		registerPan.add(lblInfoAlias, "wrap, cell 1 2 1 1");

		// User email
		lblMail = new JLabel("Mail* : ");
		registerPan.add(lblMail);
		txtMail = new JTextField(20);
		registerPan.add(txtMail, "wrap");
		lblInfoMail = new JLabel("Ne sera pas rendu public");
		lblInfoMail.setFont(new Font(getName(), Font.ITALIC, 13));
		registerPan.add(lblInfoMail, "wrap, cell 1 4 1 1");

		// Name of AFPA where the user did his training
		lblAfpa = new JLabel("AFPA* : ");
		registerPan.add(lblAfpa);
		txtAfpa = new JTextField(20);
		registerPan.add(txtAfpa, "wrap");

		// User trainer
		lblFormer = new JLabel("Nom du formateur** : ");
		registerPan.add(lblFormer);
		txtFormer = new JTextField(20);
		registerPan.add(txtFormer);

		// SECOND horizontal part: public profile informations
		publicPan = new JPanel();
		publicPan.setLayout(new MigLayout());
		publicPan.setBorder(BorderFactory.createTitledBorder("PROFIL PUBLIC"));
		westPan.add(publicPan, "wrap, w 475!");

		// Code of training session, usually 5 numbers
		lblSession = new JLabel("Numéro de session** : ");
		publicPan.add(lblSession, "w 200!");
		txtSession = new JTextField(20);
		publicPan.add(txtSession, "wrap");

		// Main programming language of the training
		lblMainInfoLang = new JLabel("Langage principal** : ");
		publicPan.add(lblMainInfoLang);
		optCsharp = new JRadioButton("C#");
		optJava = new JRadioButton("Java");
		publicPan.add(optCsharp, "split 2");
		publicPan.add(optJava, "wrap");

		// List of approached companies
		// TODO put arraylist in JList?
		lblApproachedCie = new JLabel("Entreprise(s) démarchée(s)*** : ");
		publicPan.add(lblApproachedCie);
		JComboBox<String> approachedCie = new JComboBox<String> ();
		for (int i = 0; i < company.length; i++) {
			approachedCie.addItem(company[i]);
		}
		approachedCie.setMaximumRowCount(5);
		publicPan.add(approachedCie, "wrap");

		// Current job
		lblJob = new JLabel("Profession actuelle*** : ");
		publicPan.add(lblJob);
		txtJob = new JTextField(20);
		publicPan.add(txtJob, "wrap");

		// Current company
		// TODO cie arraylist
		lblCurrentCie = new JLabel("Entreprise actuelle*** : ");
		publicPan.add(lblCurrentCie);
		JComboBox<String> currentCie = new JComboBox<String> ();
		for (int i = 0; i < company.length; i++) {
			currentCie.addItem(company[i]);
		}
		currentCie.setMaximumRowCount(5);
		publicPan.add(currentCie, "wrap");

		// Former companies
		lblFormerCie = new JLabel("Ancienne(s) entreprise(s)*** : "); 
		publicPan.add(lblFormerCie);
		JComboBox<String> formerCie = new JComboBox<String> ();
		for (int i = 0; i<company.length; i++) {
			formerCie.addItem(company[i]);
		}
		formerCie.setMaximumRowCount(5);
		publicPan.add(formerCie, "wrap");

		// THIRD horizontal part: protected profile informations
		protectedPan = new JPanel();
		protectedPan.setLayout(new MigLayout());
		protectedPan.setBorder(BorderFactory.createTitledBorder("PROFIL RESTREINT"));
		westPan.add(protectedPan, "wrap, w 475!");

		// Trainee surname for trainer (monitoring)
		lblSurname = new JLabel("Nom** : ");
		protectedPan.add(lblSurname, "w 200!");
		txtSurname = new JTextField(20);
		protectedPan.add(txtSurname, "wrap");

		// Trainee given name for trainer (monitoring)
		lblGivenName = new JLabel("Prénom** : ");
		protectedPan.add(lblGivenName);
		txtGivenName = new JTextField(20);
		protectedPan.add(txtGivenName, "wrap");

		// FOURTH horizontal part: optional profile informations
		optionalPan = new JPanel();
		optionalPan.setLayout(new MigLayout());
		optionalPan.setBorder(BorderFactory.createTitledBorder("VISIBLE PUBLIQUEMENT SI RENSEIGNÉ"));
		westPan.add(optionalPan, "w 475!");

		// Other known programming languages
		lblInfoLang = new JLabel("Autre(s) langage(s) : ");
		optionalPan.add(lblInfoLang, "w 200!");
		// TODO create language list in dao
		String [] progLanguage = {"C", "PHP"};
		JComboBox<String> cboProgLanguage = new JComboBox<String> ();
		for (int i = 0; i < progLanguage.length; i++) {
			cboProgLanguage.addItem(progLanguage[i]);
		}
		cboProgLanguage.setMaximumRowCount(2);
		optionalPan.add(cboProgLanguage, "wrap");

		// Known graphic API
		lblApi = new JLabel("API graphique : ");
		optionalPan.add(lblApi);
		// TODO create api list in dao
		String [] graphicApi = {"AWT", "JFace", "Swing", "SWT"};
		JComboBox<String> cboGraphicApi = new JComboBox<String> ();
		for (int i = 0; i < graphicApi.length; i++) {
			cboGraphicApi.addItem(graphicApi[i]);
		}
		cboGraphicApi.setMaximumRowCount(4);
		optionalPan.add(cboGraphicApi, "wrap");

		// User web site
		lblWebsite = new JLabel("Site Internet : ");
		optionalPan.add(lblWebsite);
		txtWebsite = new JTextField(20);
		optionalPan.add(txtWebsite, "wrap");

		// User LinkedIn
		lblLinkedIn = new JLabel("Profil LinkedIn");
		optionalPan.add(lblLinkedIn);
		txtLinkedIn = new JTextField(20);
		optionalPan.add(txtLinkedIn, "wrap");

		
		// CENTER - for list of users
		centerPan = new JPanel();
		centerPan.setLayout(new MigLayout());
		centerPan.setBorder(BorderFactory.createTitledBorder("Liste des utilisateurs"));
		this.add(centerPan, BorderLayout.CENTER);
		
		mdlListUsers = new DefaultListModel<User>();
		lstUsers = new JList<User>(mdlListUsers);
		if(Datas.getUsersList() != null) {
			for (User user : Datas.getUsersList()) {
				if(user != null) {
					mdlListUsers.addElement(user);
				}
				
			}
		}


		panListUsers = new JScrollPane(lstUsers);
		centerPan.add(panListUsers);
		
		
		// SOUTH - Footer for JButton
		southPan = new JPanel();
		southPan.setLayout(new FlowLayout());
		this.add(southPan, BorderLayout.SOUTH);
		cmdCancel = new JButton("Annuler");
		southPan.add(cmdCancel);
		cmdCreate = new JButton("S'enregistrer");
		southPan.add(cmdCreate);
		cmdUpdate = new JButton("Modifier");
		southPan.add(cmdUpdate);
		cmdDelete = new JButton("Supprimer");
		southPan.add(cmdDelete);
		
		
		// LISTENERS
		PanelUserListeners listener = new PanelUserListeners(this);
		cmdCreate.addActionListener(listener);

	}

	/**
	 * @return the txtAlias
	 */
	public JTextField getTxtAlias() {
		return txtAlias;
	}

	/**
	 * @return the txtMail
	 */
	public JTextField getTxtMail() {
		return txtMail;
	}

	/**
	 * @return the mdlListUsers
	 */
	public DefaultListModel<User> getMdlListUsers() {
		return mdlListUsers;
	}

	/**
	 * @return the cmdCreate
	 */
	public JButton getCmdCreate() {
		return cmdCreate;
	}


}
