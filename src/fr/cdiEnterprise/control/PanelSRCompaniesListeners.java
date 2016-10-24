package fr.cdiEnterprise.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import fr.cdiEnterprise.dao.DataBaseCompany;
import fr.cdiEnterprise.dao.OldDatas;
import fr.cdiEnterprise.model.Company;
import fr.cdiEnterprise.view.MainFrame;
import fr.cdiEnterprise.view.company.CompaniesSRPanel;
import fr.cdiEnterprise.view.company.CompanyCreationPanel;
import fr.cdiEnterprise.view.company.CompanyDeletUpdatPanel;

public class PanelSRCompaniesListeners implements ActionListener {
	
	/* Given attributes*/
	private CompaniesSRPanel panCompaniesSR;		

	
	// Attributes do define the selected 
		ButtonGroup btnGrp;
		JRadioButton btnSelected;	
	
	public PanelSRCompaniesListeners(CompaniesSRPanel panCompaniesSR) {
		this.panCompaniesSR = panCompaniesSR;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == panCompaniesSR.getBtnCancel()){
			MainFrame.getPanMain().removeAll();
			MainFrame.getPanMain().add(MainFrame.getPanHome());
			MainFrame.getPanMain().repaint();
			MainFrame.getPanMain().revalidate();
		}
		
		if (e.getSource() == panCompaniesSR.getBtnValider()){
			try {
				btnGrp = panCompaniesSR.getReadGrp();
				btnSelected = MethodsForListeners.getSelectedJRadioButton(btnGrp);					
			}catch(NullPointerException excep){		
				btnSelected = panCompaniesSR.getOptAffiche();
			}
//			if(btnSelected == panCompaniesSR.getOptAffiche()){
//				for(Company company: OldDatas.getCompaniesList()){
//					//for (Company company: DataBaseCompany.getCompaniesData()){
//						panCompaniesSR.getDlmCompanies().addElement(company);
//					}
//			}else{
//				for (Company company : DataBaseCompany.getDepartmentId(departmentName))
//			}
//			
			//			System.out.println(OldDatas.getCompaniesList());
//			System.out.println("*******Suppression*****");
//			OldDatas.getCompaniesList().remove(selecCompanie);
//			System.out.println(OldDatas.getCompaniesList());
//			CompanyCreationPanel.getDlmCompanies().remove(selecIndex);
		}
	}
	
	
}
