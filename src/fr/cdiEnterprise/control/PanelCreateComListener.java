package fr.cdiEnterprise.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fr.cdiEnterprise.dao.Datas;
import fr.cdiEnterprise.model.Company;
import fr.cdiEnterprise.model.Contact;
import fr.cdiEnterprise.model.Department;
import fr.cdiEnterprise.model.Region;
import fr.cdiEnterprise.service.Languages;
import fr.cdiEnterprise.view.CompanyCreationPanel;
import fr.cdiEnterprise.view.MainFrame;

public class PanelCreateComListener implements ActionListener, ListSelectionListener {

	// Given attribute
	private CompanyCreationPanel panCompCreat;

	// Attribut
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
	private Languages companyLanguages;
	private String companyProjets;
	private String companyWebSite;
	private Contact contact;
	private String contactName;
	private String contactPhone;
	private String contactMail;
	private ButtonGroup sizeGrp;
	private Enumeration<AbstractButton> enumOpt;
	
	// Attribute to create a company
	Company company;

	public PanelCreateComListener(CompanyCreationPanel panCompCreat) {
		this.panCompCreat = panCompCreat;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		companyName = panCompCreat.getTxtCompanyName().getText();
		companyAdress = panCompCreat.getTxtCompanyAdress().getText();
		companyCity = panCompCreat.getTxtCompanyCity().getText();
		companyPostalCode = panCompCreat.getTxtPostalCode().getText();
		nomDepartment = panCompCreat.getCboCompanyDepartment().getSelectedItem().toString();
//		companyDepartment = Datas.getDepartment(nomDepartment);
		nomRegion = panCompCreat.getCboCompanyRegion().getSelectedItem().toString();
//		companyRegion = Datas.getRegion(nomRegion);
		
		sizeGrp = panCompCreat.getSizeGrp();
		enumOpt = sizeGrp.getElements();
		while (enumOpt.hasMoreElements()) {
			JRadioButton optListener = (JRadioButton) enumOpt.nextElement();
			if (optListener.isSelected()) {
				companySize = optListener.getText();
			}
		}
		
		companySector = panCompCreat.getTxtSector().getText();
		
		companyLanguages = new Languages();
		int[] indSel = panCompCreat.getLstLanguages().getSelectedIndices();
		try {
			for (int i = 0; i < indSel.length; i++) {
				companyLanguages.add(panCompCreat.getDlmLanguages().get(indSel[i]));
			}
		} catch (IndexOutOfBoundsException excep) {
			companyLanguages = null;
		}
		System.out.println(companyLanguages);
		
		companyProjets= panCompCreat.getTxtProjets().getText();
		companyWebSite = panCompCreat.getTxtWebSite().getText();
		contactName = panCompCreat.getTxtContactName().getText();
		contactPhone = panCompCreat.getTxtContactPhone().getText();
		contactMail = panCompCreat.getTxtContactMail().getText();
		
		contact = new Contact (contactName, contactPhone, contactMail);
		
		
		if (e.getSource() == panCompCreat.getBtnCreate()) {
			System.out.println("Création d'une nouvelle entreprise");					
			company = new Company(companyName, companyAdress, companyPostalCode, companyCity, companyDepartment, companyRegion,  
					companySize,companySector, companyLanguages, companyProjets, companyWebSite, contact);
			Datas.getCompaniesList().add(company);
			System.out.println(Datas.getCompaniesList());
			CompanyCreationPanel.getDlmCompanies().addElement(company);
		}
		
		if (e.getSource() == panCompCreat.getBtnCancel()){
			MainFrame.getMainPan().removeAll();
			MainFrame.getMainPan().add(MainFrame.getHomePan());
			MainFrame.getMainPan().repaint();
			MainFrame.getMainPan().revalidate();
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


