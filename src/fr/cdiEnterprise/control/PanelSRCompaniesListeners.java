package fr.cdiEnterprise.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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

	/* Given attributes */
	private CompaniesSRPanel panCompaniesSR;

	// Attributes do define the selected
	private ButtonGroup btnGrp;
	private JRadioButton btnSelected;

	private Company company;
	private String companySelec;

	public PanelSRCompaniesListeners(CompaniesSRPanel panCompaniesSR) {
		this.panCompaniesSR = panCompaniesSR;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == panCompaniesSR.getBtnCancel()) {
			MainFrame.getPanMain().removeAll();
			MainFrame.getPanMain().add(MainFrame.getPanHome());
			MainFrame.getPanMain().repaint();
			MainFrame.getPanMain().revalidate();
		}

		if (e.getSource() == panCompaniesSR.getBtnValider()) {
			try {
				btnGrp = panCompaniesSR.getReadGrp();
				btnSelected = MethodsForListeners.getSelectedJRadioButton(btnGrp);
			} catch (NullPointerException excep) {
				btnSelected = panCompaniesSR.getOptAffiche();
			}
			
			try {
				if (btnSelected == panCompaniesSR.getOptAffiche()) {
					for (Company company : DataBaseCompany.getCompaniesData()) {
						panCompaniesSR.getDlmCompanies().addElement(company);
					}
				} else {
					companySelec = panCompaniesSR.getTxtSearchByName().getText();
					company = DataBaseCompany.getCompaniesId(companySelec);
					panCompaniesSR.getDlmCompanies().addElement(company);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
