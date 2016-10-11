package fr.cdiEnterprise.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
//import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import fr.cdiEnterprise.dao.Datas;
import fr.cdiEnterprise.model.Department;
import fr.cdiEnterprise.model.Language;
import fr.cdiEnterprise.model.Region;
import net.miginfocom.swing.MigLayout;

public class CompanyCreationPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Border border;
	private JPanel panNorth;
	private JPanel panCenter;
	private JPanel panSouth;
	private JLabel lblTitle;
	private JLabel lblCompanyName;
	private JTextField txtCompanyName;
	private JLabel lblCompanyAdress;
	private JTextField txtCompanyAdress;
	private JLabel lblCompanyCity;
	private JTextField txtCompanyCity;
	private JLabel lblCompanyDepartment;
	private JComboBox<String> cboCompanyDepartment;
	private JLabel lblSelcDepartment;
	private JLabel lblCompanyRegion;
	private JComboBox<String> cboCompanyRegion;
	private JLabel lblSelcRegion;
//	private JLabel lblSize;
//	private JLabel lblSector;
	private JLabel lblLanguages;
	private DefaultListModel<Language> dlmLanguages;
	private JList<Language> lstLanguages;
	private JScrollPane languages;
	private JLabel lblSelcLanguages;
//	private JLabel lblwebSite;
	private JLabel lblProjets;
	private JTextArea txtProjets;
//	private JLabel lblContact;
	
	private JLabel lblFieldInfo;
	private JButton btnCreate;
	private JButton btnCancel;
	private JButton btnFavoris;
	
	public CompanyCreationPanel() {
		
		Container panneau = this;
		panneau.setLayout(new BorderLayout(5,5));
		
		panNorth = new JPanel();
		panCenter = new JPanel();
		panSouth = new JPanel();
		
		panneau.add(panNorth, BorderLayout.NORTH);
		panneau.add(panCenter, BorderLayout.CENTER);
		panneau.add(panSouth, BorderLayout.SOUTH);

		 border = BorderFactory.createLineBorder(Color.GRAY);
		 
		/* Header */
		panNorth.setLayout(new FlowLayout());
		lblTitle = new JLabel("Création d'une fiche entreprise");
		lblTitle.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		lblTitle.setVisible(true);
		//Main information on compulsory fields
		lblFieldInfo = new JLabel("Les champs marqués d'étoiles sont obligatoires");
		lblFieldInfo.setFont(new Font(getName(), Font.BOLD, 14));

		panNorth.setBorder(BorderFactory.createLineBorder(Color.RED));	
		
		panNorth.add(lblTitle);
		/* Body */

		this.add(panCenter, BorderLayout.CENTER);
		panCenter.setLayout(new MigLayout());
	
		lblCompanyName = new JLabel();
		lblCompanyName.setText("Nom de l'entreprise");
		
		txtCompanyName = new JTextField();
		txtCompanyName.setColumns(30);
		txtCompanyName.setBorder(border);

		lblCompanyAdress = new JLabel();
		lblCompanyAdress.setText("Adresse (rue et numéro)");

		txtCompanyAdress = new JTextField();
		txtCompanyAdress.setColumns(30);
		txtCompanyAdress.setBorder(border);

		lblCompanyCity = new JLabel();
		lblCompanyCity.setText("Ville");

		txtCompanyCity = new JTextField();
		txtCompanyCity.setColumns(30);
		txtCompanyCity.setBorder(border);

		lblCompanyDepartment = new JLabel();
		lblCompanyDepartment.setText("Departement");

		cboCompanyDepartment = new JComboBox<String>();
		
		for (Department department : Datas.getListeDepartments()) {
			cboCompanyDepartment.addItem(department.toString());
		}
		
		cboCompanyDepartment.setEditable(true);
		cboCompanyDepartment.setMaximumRowCount(5);
		
		lblSelcDepartment = new JLabel();

		lblCompanyRegion = new JLabel();
		lblCompanyRegion.setText("Région");
		
		cboCompanyRegion = new JComboBox<String>();
		for (Region region : Datas.getListeRegions()) {
			cboCompanyRegion.addItem(region.getRegionName());
		}
		cboCompanyRegion.setEditable(true);
		cboCompanyRegion.setMaximumRowCount(5);
		
		lblSelcRegion = new JLabel();
		
		
		lblLanguages = new JLabel ("Langages principalement utilisés");
		
		
		/**
		 * Il faut une JList pour stocker les langages avec la possibilité de pouvoir en créer en renseignant la fiche entreprise
		 * 
		 */		
		dlmLanguages = new DefaultListModel<Language>();
		lstLanguages = new JList<Language>(dlmLanguages);
//		for (Language language : Datas.getListeLanguages()) {
//		dlmLanguages.addElement(language);
//		}
		languages = new JScrollPane(lstLanguages, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		languages.setPreferredSize(new Dimension(300, 70));
		
		lblSelcLanguages = new JLabel();

		lblProjets = new JLabel("Principaux projets de l'entreprise");
		txtProjets= new JTextArea();
		txtProjets.setEditable(true);
		txtProjets.setColumns(30);
		txtProjets.setRows(3);
		txtProjets.setBorder(border);
		
		btnCreate = new JButton("Enregistrer");
		btnCancel = new JButton("Annuler");
		btnFavoris = new JButton("Ajouter aux favoris");
		
//		dateEdit = new JDateChooser();
//

		panCenter.add(lblCompanyName);
		panCenter.add(txtCompanyName, "wrap");
		panCenter.add(lblCompanyAdress);
		panCenter.add(txtCompanyAdress, "wrap 20");
		panCenter.add(lblCompanyCity);
		panCenter.add(txtCompanyCity, "wrap 30");
		panCenter.add(lblCompanyDepartment);
		panCenter.add(cboCompanyDepartment);
		panCenter.add(lblSelcDepartment, "wrap 20");
		panCenter.add(lblCompanyRegion);
		panCenter.add(cboCompanyRegion);
		panCenter.add(lblSelcRegion, "wrap 20");
		panCenter.add(lblLanguages);
		panCenter.add(languages);
		panCenter.add(lblSelcLanguages, "wrap 20");
		panCenter.add(lblProjets);
		panCenter.add(txtProjets, "wrap");
		
		
		
		
		panCenter.add(lblFieldInfo);
		
		panSouth.add(btnCreate);
		panSouth.add(btnCancel);
		panSouth.add(btnFavoris);
//
//		commande = new JPanel();
//		commande.setBorder(border);
//		commande.add(btnOk);
//		commande.add(btnAnnul);
//		commande.add(btnModif);
//		commande.add(btnDelete);
//

//
//		clic = new AppListeners(this);
//		btnOk.addActionListener(clic);
//
//		btnDelete.addActionListener(clic);
//		// btnModif.addActionListener(clic);
//
//		cboEditeur.addActionListener(clic);
//		cboThemes.addActionListener(clic);
//		// cboAuteur.addActionListener(clic);
//		btnCreaAuteur.addActionListener(clic);
//		btnCreaEditeur.addActionListener(clic);
//		btnCreaTheme.addActionListener(clic);
//		btnOkDate.addActionListener(clic);
//		lstLivres.addListSelectionListener(clic);
//		lstAuteurs.addListSelectionListener(clic);

	}
		
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

