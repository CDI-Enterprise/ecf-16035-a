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
	private JPanel panWest;
	private JPanel panContact;
	private JPanel panCompany;
	private JPanel panCenter;
	private JPanel panSouth;
	private JLabel lblTitle;
	private JLabel lblCompanyName;
	private JTextField txtCompanyName;
	private JLabel lblCompanyAdress;
	private JTextField txtCompanyAdress;
	private JLabel lblCompanyCity;
	private JTextField txtCompanyCity;
	private JLabel lblPostalCode;
	private JTextField txtPostalCode;
	private JLabel lblCompanyDepartment;
	private JComboBox<String> cboCompanyDepartment;
	private JLabel lblSelcDepartment;
	private JLabel lblCompanyRegion;
	private JComboBox<String> cboCompanyRegion;
	private JLabel lblSelcRegion;
	private JLabel lblSize;
	private JTextField txtSize;
	private JLabel lblSector;
	private JTextField txtSector;
	private JLabel lblLanguages;
	private DefaultListModel<Language> dlmLanguages;
	private JList<Language> lstLanguages;
	private JScrollPane languages;
	private JLabel lblSelcLanguages;
	private JLabel lblWebSite;
	private JTextField txtWebSite;
	private JLabel lblProjets;
	private JTextArea txtProjets;
	private JLabel lblFieldInfo;
	private JLabel lblContactName;
	private JTextField txtContactName;
	private JLabel lblContactPhone;
	private JTextField txtContactPhone;
	private JLabel lblContactMail;
	private JTextField txtContactMail;
	private JButton btnCreate;
	private JButton btnCancel;
	private JButton btnFavoris;
	
	public CompanyCreationPanel() {
		
		Container panneau = this;
		panneau.setLayout(new BorderLayout(5,5));
		
		border = BorderFactory.createLineBorder(Color.GRAY);
		panNorth = new JPanel();
		panWest = new JPanel();
		panCenter = new JPanel();
		panSouth = new JPanel();
		
		panneau.add(panNorth, BorderLayout.NORTH);
		panneau.add(panWest,BorderLayout.WEST);
		panneau.add(panCenter, BorderLayout.CENTER);
		panneau.add(panSouth, BorderLayout.SOUTH);

		 
		/* Header */
		panNorth.setLayout(new FlowLayout());
		lblTitle = new JLabel("Création d'une fiche entreprise");
		lblTitle.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		lblTitle.setVisible(true);
		lblFieldInfo = new JLabel("Les champs marqués d'étoiles sont obligatoires");
		lblFieldInfo.setFont(new Font(getName(), Font.BOLD, 14));

		panNorth.setBorder(BorderFactory.createLineBorder(Color.RED));	
		panNorth.add(lblTitle);
		
		/* Body */
		panWest.setLayout(new MigLayout());
		panCompany = new JPanel();
		panCompany.setLayout(new MigLayout());
		panCompany.setBorder(BorderFactory.createTitledBorder("ENTREPRISE"));
		
		panContact = new JPanel();	
		panContact.setLayout(new MigLayout());
		panContact.setBorder(BorderFactory.createTitledBorder("CONTACT ENTREPRISE"));
	
		lblCompanyName = new JLabel("Nom de l'entreprise *");
		txtCompanyName = new JTextField();
		txtCompanyName.setColumns(30);
		txtCompanyName.setBorder(border);

		lblCompanyAdress = new JLabel("Adresse (rue et numéro)");
		txtCompanyAdress = new JTextField();
		txtCompanyAdress.setColumns(30);

		lblCompanyCity = new JLabel("Ville *");
		txtCompanyCity = new JTextField();
		txtCompanyCity.setColumns(30);
		txtCompanyCity.setBorder(border);

		lblPostalCode = new JLabel("Code postal *");
		txtPostalCode = new JTextField();
		txtPostalCode.setColumns(5);
		
		lblCompanyDepartment = new JLabel("Departement *");
		cboCompanyDepartment = new JComboBox<String>();
		
		for (Department department : Datas.getListeDepartments()) {
			cboCompanyDepartment.addItem(department.toString());
		}
		cboCompanyDepartment.setEditable(true);
		cboCompanyDepartment.setMaximumRowCount(5);
		
		lblSelcDepartment = new JLabel();

		lblCompanyRegion = new JLabel("Région *");
		cboCompanyRegion = new JComboBox<String>();
		for (Region region : Datas.getListeRegions()) {
			cboCompanyRegion.addItem(region.getRegionName());
		}
		cboCompanyRegion.setEditable(true);
		cboCompanyRegion.setMaximumRowCount(5);
		
		lblSelcRegion = new JLabel();
		lblSize= new JLabel("Taille entreprise");
		txtSize = new JTextField();
		txtSize.setColumns(20);
		
		lblSector = new JLabel("Secteur");
		txtSector = new JTextField();
		txtSector.setColumns(20);
		
		
		lblLanguages = new JLabel ("Langages principalement utilisés *");	
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
		
		lblWebSite = new JLabel("Site Web *");
		txtWebSite = new JTextField();
		txtWebSite.setColumns(20);
		
		lblContactName = new JLabel("Nom du contact ");
		txtContactName = new JTextField();
		txtContactName.setColumns(20);
		
		lblContactPhone = new JLabel("Téléphone");
		txtContactPhone = new JTextField();
		txtContactPhone.setColumns(20);
		
		
		lblContactMail = new JLabel("Adresse mail");
		txtContactMail = new JTextField();
		txtContactMail.setColumns(20);
		
		btnCreate = new JButton("Enregistrer");
		btnCancel = new JButton("Annuler");
		btnFavoris = new JButton("Ajouter aux favoris");
		
//		dateEdit = new JDateChooser();
//
		panWest.add(panCompany, "wrap 20");
		panCompany.add(lblCompanyName);
		panCompany.add(txtCompanyName, "wrap 20");
		panCompany.add(lblCompanyAdress);
		panCompany.add(txtCompanyAdress, "wrap 20");
		panCompany.add(lblCompanyCity);
		panCompany.add(txtCompanyCity, "wrap 20");
		panCompany.add(lblPostalCode);
		panCompany.add(txtPostalCode, "wrap 20");
		panCompany.add(lblCompanyDepartment);
		panCompany.add(cboCompanyDepartment);
		panCompany.add(lblSelcDepartment, "wrap 20");
		panCompany.add(lblCompanyRegion);
		panCompany.add(cboCompanyRegion);
		panCompany.add(lblSelcRegion, "wrap 20");
		panCompany.add(lblSize);
		panCompany.add(txtSize, "wrap 20");
		panCompany.add(lblSector);
		panCompany.add(txtSector, "wrap 20");
		panCompany.add(lblLanguages);
		panCompany.add(languages);
		panCompany.add(lblSelcLanguages, "wrap 20");
		panCompany.add(lblProjets);
		panCompany.add(txtProjets, "wrap 20");
		panCompany.add(lblWebSite);
		panCompany.add(txtWebSite, "wrap 30");
		panWest.add(panContact);
		panContact.add(lblContactName);
		panContact.add(txtContactName, "wrap 20");
		panContact.add(lblContactPhone);
		panContact.add(txtContactPhone, "wrap 20");
		panContact.add(lblContactMail);
		panContact.add(txtContactMail, "wrap 20");
		panCompany.add(lblFieldInfo);
	
		
		panSouth.add(btnCreate);
		panSouth.add(btnCancel);
		panSouth.add(btnFavoris);
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
	}

