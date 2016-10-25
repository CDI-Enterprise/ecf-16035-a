package fr.cdiEnterprise.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import fr.cdiEnterprise.model.Company;
import fr.cdiEnterprise.model.Language;

public class HomePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Container panneau;
	private JPanel panNorth;
	private JPanel panSouth;
	private JPanel panCenter;
	private JPanel panWest;
	private JLabel lblTitle;
	private JLabel lblImage;
//	private JPanel panCompany;
//	private JPanel panContact;
//	private Border border;
//
//	private JLabel lblCompanyName;
//	private JTextField txtCompanyName;
//	private JLabel lblCompanyAdress;
//	private JTextField txtCompanyAdress;
//	private JLabel lblCompanyCity;
//	private JTextField txtCompanyCity;
//	private JLabel lblPostalCode;
//	private JTextField txtPostalCode;
//	private JLabel lblCompanyDepartment;
//	private JComboBox<String> cboCompanyDepartment;
//	private JLabel lblSelcDepartment;
//	private JLabel lblCompanyRegion;
//	private JComboBox<String> cboCompanyRegion;
//	private JLabel lblSelcRegion;
//	private JLabel lblSize;
//	private JRadioButton optMicroEnt;
//	private JRadioButton optPME;
//	private JRadioButton optETI;
//	private JRadioButton optGrdEnt;
//	private JLabel lblSector;
//	private JTextField txtSector;
//	private JLabel lblLanguages;
//	private DefaultListModel<Language> dlmLanguages;
//	private JList<Language> lstLanguages;
//	private JScrollPane languages;
//	private JLabel lblSelcLanguages;
//	private JLabel lblWebSite;
//	private JTextField txtWebSite;
//	private JLabel lblProjets;
//	private JTextArea txtProjets;
//	private JLabel lblContactName;
//	private JTextField txtContactName;
//	private JLabel lblContactPhone;
//	private JTextField txtContactPhone;
//	private JLabel lblContactMail;
//	private JTextField txtContactMail;
//	private DefaultListModel<Company> dlmCompanies; 
//	private JList <Company> lstCompanies;
//	private JScrollPane companies;
//	private JButton btnDelete;
//	private JButton btnUpdate;
//	private JButton btnCancel;
	
	
	public HomePanel() throws SQLException {
	
		panneau = this;
		panneau.setLayout(new BorderLayout(5,5));
		
		panNorth = new JPanel();
		panWest = new JPanel();
		panCenter = new JPanel();
		panSouth = new JPanel();
		
		panneau.add(panNorth, BorderLayout.NORTH);
		panneau.add(panWest,BorderLayout.WEST);
		panneau.add(panCenter, BorderLayout.CENTER);
		panneau.add(panSouth, BorderLayout.SOUTH);
		
		panNorth.setLayout(new FlowLayout());
		lblTitle = new JLabel("Bienvenue sur l'application CDI Enterprise");
		lblTitle.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		lblTitle.setVisible(true);
		
		lblImage = new JLabel (new ImageIcon("star-trek.png"));
		
		panNorth.add(lblTitle);
		panCenter.add(lblImage);
	
	}
}
