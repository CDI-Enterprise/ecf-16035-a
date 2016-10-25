package fr.cdiEnterprise.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fr.cdiEnterprise.dao.DataBaseCompany;
import fr.cdiEnterprise.exceptions.CompanyCreationException;
import fr.cdiEnterprise.model.Company;
import fr.cdiEnterprise.model.Contact;
import fr.cdiEnterprise.model.Department;
import fr.cdiEnterprise.model.Language;
import fr.cdiEnterprise.model.Region;
//import fr.cdiEnterprise.service.Languages;
import fr.cdiEnterprise.view.MainFrame;
import fr.cdiEnterprise.view.company.CompanyCreationPanel;

/**
 *Listeners for panel "Company Creation"
 *
 * @version 21-10-2016
 * @author Anaïs
 * 
 *
 */
public class PanelCreateComListener implements ActionListener, ListSelectionListener {

	// Given attribute
	private CompanyCreationPanel panCompCreat;

	// Attributes for creation company
	private int idCompany;
	private String companyName;
	private String companyAdress;
	private String companyCity;
	private String companyPostalCode;
	private Department companyDepartment;
	private String nomDepartment;
	private Region companyRegion;
	private String nomRegion;
	private String companySize;
	private String companySector;
//	private Languages companyLanguages;					Sera utilisé dans la deuxième version => sélection multiple de langages informatiques
	private Language companyLanguage;
	private String companyProjets;
	private String companyWebSite;
	private Contact contact;
	private String contactName;
	private String contactPhone;
	private String contactMail;
	
	// Attributes to give select language
	String languageSelect;
	
	// Attributes do define the selected size
	ButtonGroup btnGrp;
	JRadioButton btnSelected;	
	
	// Attribute to create a company
	Company company;

	private JFrame popupError;
	
	public PanelCreateComListener(CompanyCreationPanel panCompCreat) {
		this.panCompCreat = panCompCreat;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		if (e.getSource() == panCompCreat.getBtnCreate()) {
			try {
				btnGrp = panCompCreat.getSizeGrp();
				btnSelected = MethodsForListeners.getSelectedJRadioButton(btnGrp);
				companySize = btnSelected.getText();	
			}catch(NullPointerException excep){
				companySize = null;
			}
			
			try{
				System.out.println("Création d'une nouvelle entreprise");	
	
				companyName = MethodsForListeners.nullField(panCompCreat.getTxtCompanyName().getText());
				companyAdress = panCompCreat.getTxtCompanyAdress().getText();
				companyCity = MethodsForListeners.nullField(panCompCreat.getTxtCompanyCity().getText().toUpperCase());
				companyPostalCode = MethodsForListeners.nullField(panCompCreat.getTxtPostalCode().getText());
				nomDepartment = panCompCreat.getCboCompanyDepartment().getSelectedItem().toString();
				companyDepartment = DataBaseCompany.getDepartmentId(nomDepartment);
				nomRegion = panCompCreat.getCboCompanyRegion().getSelectedItem().toString();
				companyRegion = DataBaseCompany.getRegionId(nomRegion);				
				companySector = panCompCreat.getTxtSector().getText();
				
				try{
				languageSelect = panCompCreat.getLstLanguages().getSelectedValue().toString();
				}catch(NullPointerException except){
					languageSelect = "JAVA";
				}
				companyLanguage= DataBaseCompany.getLanguageId(languageSelect);

				//companyLanguages = new Languages();      Pour la première version, seulement une sélection est autorisée
//				int[] indSel = panCompCreat.getLstLanguages().getSelectedIndices();
//				try {
//					for (int i = 0; i < indSel.length; i++) {
//						companyLanguages.add(panCompCreat.getDlmLanguages().get(indSel[i]));
//					}
//				} catch (IndexOutOfBoundsException excep) {
//					companyLanguages = null;
//				}
				
				companyProjets= panCompCreat.getTxtProjets().getText();
				companyWebSite = panCompCreat.getTxtWebSite().getText();
				contactName = panCompCreat.getTxtContactName().getText();
				contactPhone = panCompCreat.getTxtContactPhone().getText();
				contactMail = panCompCreat.getTxtContactMail().getText();		

				contact = new Contact (contactName, contactPhone, contactMail);
				
				idCompany = DataBaseCompany.getIdMax("company") + 1;
	//			System.out.println(idCompany);
				company = new Company(idCompany, companyName, companyAdress, companyPostalCode, companyCity, companyDepartment, companyRegion,  
						companySize,companySector, companyLanguage, companyProjets, companyWebSite, contact);
				//System.out.println(company);
				
				DataBaseCompany.insertCompanyData(company, contact);
				CompanyCreationPanel.getDlmCompanies().addElement(company);
				MethodsForListeners.resetJTextField(panCompCreat.getAllJTextFields());
				
			}catch (CompanyCreationException ev){
				JOptionPane.showMessageDialog(popupError, "Veuillez renseigner les champs obligatoires");
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
	
		}
		
		if (e.getSource() == panCompCreat.getBtnCancel()){
			MainFrame.getPanMain().removeAll();
			MainFrame.getPanMain().add(MainFrame.getPanHome());
			MainFrame.getPanMain().repaint();
			MainFrame.getPanMain().revalidate();
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent ev) {

		if (ev.getSource() == panCompCreat.getLstLanguages()) {
			System.out.println("Affiche le langage");
			panCompCreat.getLstLanguages().getSelectedValuesList().toString();
			System.out.println(panCompCreat.getLstLanguages().getSelectedValuesList());
			int[] indSel = panCompCreat.getLstLanguages().getSelectedIndices();
			try {
				for (int i = 0; i < indSel.length; i++) {
					System.out.println(indSel[i]);
					System.out.println(panCompCreat.getDlmLanguages().get(indSel[i]));
				}
			} catch (IndexOutOfBoundsException excep) {
			
			}
		}
	}
}


