package fr.cdiEnterprise.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import fr.cdiEnterprise.control.UserPanelListeners;
import fr.cdiEnterprise.dao.Datas;
import fr.cdiEnterprise.model.User;
import net.miginfocom.swing.MigLayout;

/**
 * Panel for a user's profile CRUD
 * Last update: 20161007
 * @version 0.0
 * @author Claire
 */
public class UserPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//TODO fake companies list in database!
	String [] company = {"Aucune", "9e compagnie", "Cie", "Comme Pagny", "Autre..."};

//	private JPanel panEast;

	// NORTH
	private JPanel panNorth;
	//Labels
	private JLabel lblFieldInfo;

	// WEST
	private JPanel panWest;
	private JScrollPane panScrollWest;
	// First panel for first log-in informations
	private JPanel panRegister;
	// Labels
	private JLabel lblStatus;
	private JLabel lblAlias;
	private JLabel lblInfoAlias;
	private JLabel lblMail;
//	private JLabel lblInfoMail;
	private JLabel lblAfpa;
	private JLabel lblTrainer;
	// Others components
	private ButtonGroup statusGrp;
	private JRadioButton optTrainee;
	private JRadioButton optFormerTrainee;
	private JRadioButton optTrainer;
	private JTextField txtAlias;
	private JTextField txtMail;
	private JTextField txtAfpa;
	private JTextField txtTrainer;

	// Second panel for public profile informations
	private JPanel panPublic;
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

	// Third panel for restricted profile informations
	private JPanel panRestricted;
	// Labels
	private JLabel lblSurname;
	private JLabel lblGivenName;
	// Others components
	private JTextField txtSurname;
	private JTextField txtGivenName;

	// Fourth panel for optional profile informations
	private JPanel panOptional;
	// Labels
	private JLabel lblInfoLang;
	private JLabel lblApi;
	private JLabel lblWebsite;
	private JLabel lblLinkedIn;
	// Others components
	private JTextField txtWebsite;
	private JTextField txtLinkedIn;
	
	// CENTER
	private JPanel panCenter;
	// JList
	private JPanel panLstUsers;
	private DefaultListModel<User> mdlLstUsers;
	private JList<User> lstUsers;
	private JScrollPane panScrollLstUsers;
	
	// SOUTH
	private JPanel panSouth;
	// JButton
	private JButton cmdCancel;
	private JButton cmdCreate;
	private JButton cmdUpdate;
	private JButton cmdDelete;

	public UserPanel() {

		// Main layout for book creation panel
		this.setLayout(new BorderLayout(10, 20));

		
		// NORTH - main information on compulsory fields
		panNorth = new JPanel();
		panNorth.setLayout(new FlowLayout());
		this.add(panNorth, BorderLayout.NORTH);

		lblFieldInfo = new JLabel("Les champs marqués d'étoiles sont obligatoires pour : "
				+ "* tous les utilisateurs / "
				+ "** les statuts Stagiaire et Ancien / "
				+ "*** le statut Ancien");
		lblFieldInfo.setFont(new Font(getName(), Font.BOLD, 14));
		panNorth.add(lblFieldInfo);
		panNorth.setBorder(BorderFactory.createLineBorder(Color.RED));

		
		// WEST - For create / update with four horizontal parts
		panWest = new JPanel();
		panWest.setLayout(new MigLayout());
		panScrollWest = new JScrollPane(panWest);
		panScrollWest.setBorder(new EmptyBorder(0, 5,0, 0));
		this.add(panScrollWest, BorderLayout.WEST);

		// FIRST horizontal part: first log-in informations
		panRegister = new JPanel();	
		panRegister.setLayout(new MigLayout());
		panRegister.setBorder(BorderFactory.createTitledBorder("ENREGISTREMENT"));
		panWest.add(panRegister, "wrap, w 475!");

		// User status
		lblStatus = new JLabel("Statut* : ");
		panRegister.add(lblStatus, "w 200!");
		optTrainee = new JRadioButton("Stagiaire");
		optFormerTrainee = new JRadioButton("Ancien");
		optTrainer = new JRadioButton("Formateur");
		// RadioButton group creation
		statusGrp = new ButtonGroup();
		statusGrp.add(optTrainee);
		statusGrp.add(optFormerTrainee);
		statusGrp.add(optTrainer);
		
		panRegister.add(optTrainee, "split 3");
		panRegister.add(optFormerTrainee);
		panRegister.add(optTrainer, "wrap");

		// User alias
		lblAlias = new JLabel("Pseudo* : ");
		panRegister.add(lblAlias);
		txtAlias = new JTextField(20);
		panRegister.add(txtAlias, "wrap");
		lblInfoAlias = new JLabel("<html><font color = #808080>Maximum 20 caractères</font></html>");
		lblInfoAlias.setFont(new Font(getName(), Font.ITALIC, 13));
		panRegister.add(lblInfoAlias, "wrap, cell 1 2 1 1");

		// User email
		lblMail = new JLabel("Mail* : ");
		panRegister.add(lblMail);
		txtMail = new JTextField(20);
		panRegister.add(txtMail, "wrap");
//		lblInfoMail = new JLabel("<html><font color = #808080 >Ne sera pas rendu public</font></html>");
//		lblInfoMail.setFont(new Font(getName(), Font.ITALIC, 13));
//		registerPan.add(lblInfoMail, "wrap, cell 1 4 1 1");

		// Name of AFPA where the user did his training
		lblAfpa = new JLabel("AFPA* : ");
		panRegister.add(lblAfpa);
		txtAfpa = new JTextField(20);
		panRegister.add(txtAfpa, "wrap");

		// User trainer
		lblTrainer = new JLabel("Nom du formateur** : ");
		panRegister.add(lblTrainer);
		txtTrainer = new JTextField(20);
		panRegister.add(txtTrainer);

		// SECOND horizontal part: public profile informations
		panPublic = new JPanel();
		panPublic.setLayout(new MigLayout());
		panPublic.setBorder(BorderFactory.createTitledBorder("PROFIL PUBLIC"));
		panWest.add(panPublic, "wrap, w 475!");

		// Code of training session, usually 5 numbers
		lblSession = new JLabel("Numéro de session** : ");
		panPublic.add(lblSession, "w 200!");
		txtSession = new JTextField(20);
		panPublic.add(txtSession, "wrap");

		// Main programming language of the training
		lblMainInfoLang = new JLabel("Langage principal** : ");
		panPublic.add(lblMainInfoLang);
		optCsharp = new JRadioButton("C#");
		optJava = new JRadioButton("Java");
		panPublic.add(optCsharp, "split 2");
		panPublic.add(optJava, "wrap");

		// List of approached companies
		// TODO Claire put arraylist in JList?
		lblApproachedCie = new JLabel("Entreprise(s) démarchée(s)*** : ");
		panPublic.add(lblApproachedCie);
		JComboBox<String> approachedCie = new JComboBox<String> ();
		for (int i = 0; i < company.length; i++) {
			approachedCie.addItem(company[i]);
		}
		approachedCie.setMaximumRowCount(5);
		panPublic.add(approachedCie, "wrap");

		// Current job
		lblJob = new JLabel("Profession actuelle*** : ");
		panPublic.add(lblJob);
		txtJob = new JTextField(20);
		panPublic.add(txtJob, "wrap");

		// Current company
		// TODO Claire cie arraylist
		lblCurrentCie = new JLabel("Entreprise actuelle*** : ");
		panPublic.add(lblCurrentCie);
		JComboBox<String> currentCie = new JComboBox<String> ();
		for (int i = 0; i < company.length; i++) {
			currentCie.addItem(company[i]);
		}
		currentCie.setMaximumRowCount(5);
		panPublic.add(currentCie, "wrap");

		// Former companies
		lblFormerCie = new JLabel("Ancienne(s) entreprise(s)*** : "); 
		panPublic.add(lblFormerCie);
		JComboBox<String> formerCie = new JComboBox<String> ();
		for (int i = 0; i<company.length; i++) {
			formerCie.addItem(company[i]);
		}
		formerCie.setMaximumRowCount(5);
		panPublic.add(formerCie, "wrap");

		// THIRD horizontal part: protected profile informations
		panRestricted = new JPanel();
		panRestricted.setLayout(new MigLayout());
		panRestricted.setBorder(BorderFactory.createTitledBorder("PROFIL RESTREINT"));
		panWest.add(panRestricted, "wrap, w 475!");

		// Trainee surname for trainer (monitoring)
		lblSurname = new JLabel("Nom** : ");
		panRestricted.add(lblSurname, "w 200!");
		txtSurname = new JTextField(20);
		panRestricted.add(txtSurname, "wrap");

		// Trainee given name for trainer (monitoring)
		lblGivenName = new JLabel("Prénom** : ");
		panRestricted.add(lblGivenName);
		txtGivenName = new JTextField(20);
		panRestricted.add(txtGivenName, "wrap");

		// FOURTH horizontal part: optional profile informations
		panOptional = new JPanel();
		panOptional.setLayout(new MigLayout());
		panOptional.setBorder(BorderFactory.createTitledBorder("VISIBLE PUBLIQUEMENT SI RENSEIGNÉ"));
		panWest.add(panOptional, "w 475!");

		// Other known programming languages
		lblInfoLang = new JLabel("Autre(s) langage(s) : ");
		panOptional.add(lblInfoLang, "w 200!");
		// TODO Claire create language list in dao
		String [] progLanguage = {"C", "PHP"};
		JComboBox<String> cboProgLanguage = new JComboBox<String> ();
		for (int i = 0; i < progLanguage.length; i++) {
			cboProgLanguage.addItem(progLanguage[i]);
		}
		cboProgLanguage.setMaximumRowCount(2);
		panOptional.add(cboProgLanguage, "wrap");

		// Known graphic API
		lblApi = new JLabel("API graphique : ");
		panOptional.add(lblApi);
		// TODO Claire create api list in dao
		String [] graphicApi = {"AWT", "JFace", "Swing", "SWT"};
		JComboBox<String> cboGraphicApi = new JComboBox<String> ();
		for (int i = 0; i < graphicApi.length; i++) {
			cboGraphicApi.addItem(graphicApi[i]);
		}
		cboGraphicApi.setMaximumRowCount(4);
		panOptional.add(cboGraphicApi, "wrap");

		// User web site
		lblWebsite = new JLabel("Site Internet : ");
		panOptional.add(lblWebsite);
		txtWebsite = new JTextField(20);
		panOptional.add(txtWebsite, "wrap");

		// User LinkedIn
		lblLinkedIn = new JLabel("Profil LinkedIn");
		panOptional.add(lblLinkedIn);
		txtLinkedIn = new JTextField(20);
		panOptional.add(txtLinkedIn, "wrap");

		
		// CENTER - for list of users
		panCenter = new JPanel();
		panCenter.setLayout(new MigLayout());
		panCenter.setBorder(new EmptyBorder(0, 0, 0, 5));
		
		this.add(panCenter, BorderLayout.CENTER);
		
		panLstUsers = new JPanel();
		panLstUsers.setLayout(new MigLayout());
		panLstUsers.setBorder(BorderFactory.createTitledBorder("Liste des utilisateurs"));
		panCenter.add(panLstUsers);
		
		mdlLstUsers = new DefaultListModel<User>();
		lstUsers = new JList<User>(mdlLstUsers);
		lstUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		if(Datas.getUsersList() != null) {
			for (User user : Datas.getUsersList()) {
				if(user != null) {
					mdlLstUsers.addElement(user);
				}
			}
		}

		panScrollLstUsers = new JScrollPane(lstUsers);
		panLstUsers.add(panScrollLstUsers);
		
		
		// SOUTH - Footer for JButton
		panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		this.add(panSouth, BorderLayout.SOUTH);
		cmdCancel = new JButton("Annuler");
		panSouth.add(cmdCancel);
		cmdCreate = new JButton("S'enregistrer");
		panSouth.add(cmdCreate);
		cmdUpdate = new JButton("Modifier");
		panSouth.add(cmdUpdate);
		cmdDelete = new JButton("Supprimer");
		panSouth.add(cmdDelete);
		
		
		// LISTENERS
		UserPanelListeners listener = new UserPanelListeners(this);
		cmdCancel.addActionListener(listener);
		cmdCreate.addActionListener(listener);
		cmdUpdate.addActionListener(listener);
		cmdDelete.addActionListener(listener);
		
		lstUsers.addMouseListener(listener);

	}

	/**
	 * @return the statusGrp
	 */
	public ButtonGroup getStatusGrp() {
		return statusGrp;
	}

	/**
	 * @return the optTrainee
	 */
	public JRadioButton getOptTrainee() {
		return optTrainee;
	}

	/**
	 * @param optTrainee the optTrainee to set
	 */
	public void setOptTrainee(JRadioButton optTrainee) {
		this.optTrainee = optTrainee;
	}

	/**
	 * @return the optFormerTrainee
	 */
	public JRadioButton getOptFormerTrainee() {
		return optFormerTrainee;
	}

	/**
	 * @param optFormerTrainee the optFormerTrainee to set
	 */
	public void setOptFormerTrainee(JRadioButton optFormerTrainee) {
		this.optFormerTrainee = optFormerTrainee;
	}

	/**
	 * @return the optTrainer
	 */
	public JRadioButton getOptTrainer() {
		return optTrainer;
	}

	/**
	 * @param optTrainer the optTrainer to set
	 */
	public void setOptTrainer(JRadioButton optTrainer) {
		this.optTrainer = optTrainer;
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
	 * @return the txtAfpa
	 */
	public JTextField getTxtAfpa() {
		return txtAfpa;
	}

	/**
	 * @return the txtTrainer
	 */
	public JTextField getTxtTrainer() {
		return txtTrainer;
	}

	/**
	 * @return the mdlListUsers
	 */
	public DefaultListModel<User> getMdlListUsers() {
		return mdlLstUsers;
	}

	/**
	 * @return the lstUsers
	 */
	public JList<User> getLstUsers() {
		return lstUsers;
	}

	/**
	 * @return the cmdCancel
	 */
	public JButton getCmdCancel() {
		return cmdCancel;
	}

	/**
	 * @return the cmdCreate
	 */
	public JButton getCmdCreate() {
		return cmdCreate;
	}

	/**
	 * @return the cmdUpdate
	 */
	public JButton getCmdUpdate() {
		return cmdUpdate;
	}

	/**
	 * @return the cmdDelete
	 */
	public JButton getCmdDelete() {
		return cmdDelete;
	}

}
