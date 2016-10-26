package fr.cdiEnterprise.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import fr.cdiEnterprise.dao.DataBaseCompany;
import fr.cdiEnterprise.dao.FavoriteDao;
import fr.cdiEnterprise.model.Company;
import fr.cdiEnterprise.model.Favorite;
import fr.cdiEnterprise.view.MainFrame;
import fr.cdiEnterprise.view.company.CompaniesSRPanel;


public class PanelSRCompaniesListeners implements ActionListener, MouseListener {

	/* Given attributes */
	private CompaniesSRPanel panCompaniesSR;

	// Attributes do define the selected
	private ButtonGroup btnGrp;
	private JRadioButton btnSelected;

	private Company company;
	private String companySelec;
	
	private Company selecCompany;
	private static int selecIndSelec;
	
	//Attributed to add favorite
	private int idFavorite;
	private String companyName;
	private String companyCity;
	private String companySize;
	private String companySector;
	private String companyWebSite;
	private String contactMail;	
	private String noteCompany;
	private FavoriteDao favoriteDao;


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
		
		//if cmbBookMarkValidate clicked
		if (e.getSource() == panCompaniesSR.getBtnFavoris())		//(Ismael)
		{
			FavoriteDao favoriteDao = new FavoriteDao();
			try
			{
			companyName		= panCompaniesSR.getTxtCompanyCity().getText();
			companyCity		= panCompaniesSR.getTxtCompanyCity().getText();
			companySize		= panCompaniesSR.getLblSize().getText();	
			companySector	= panCompaniesSR.getTxtSector().getText();
			companyWebSite	= panCompaniesSR.getTxtWebSite().getText();
			contactMail		= panCompaniesSR.getTxtContactMail().getText();
			idFavorite		= FavoriteDao.getIdMax("favorite") +1;

			//Create a favorite's object
			Favorite favoriteCompany = new Favorite( idFavorite,companyName, companyCity, companySize, companySector, companyWebSite, contactMail, noteCompany);

			//Send the add
			favoriteDao.addFavorite(favoriteCompany);
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			
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
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// JList list = (JList)e.getSource();
		//
		// if (e.getClickCount() == 2) {
		// System.out.println("double clicked");
		// }

		if (e.getSource() == panCompaniesSR.getLstCompanies()) {
			selecCompany = (Company) panCompaniesSR.getLstCompanies().getSelectedValue();
			selecIndSelec = selecCompany.getCompanyId();
			System.out.println(selecIndSelec);
			panCompaniesSR.getTxtCompanyName().setText(selecCompany.getCompanyName());
			panCompaniesSR.getTxtCompanyAdress().setText(selecCompany.getAdress());
			panCompaniesSR.getTxtCompanyCity().setText(selecCompany.getCity());
			panCompaniesSR.getTxtPostalCode().setText(selecCompany.getPostalCode());
			panCompaniesSR.getTxtSector().setText(selecCompany.getSector());
			panCompaniesSR.getTxtProjets().setText(selecCompany.getProjets());
			panCompaniesSR.getTxtWebSite().setText(selecCompany.getWebSite());

			try {
				panCompaniesSR.getTxtContactName().setText(selecCompany.getContact().getName());
				panCompaniesSR.getTxtContactPhone().setText(selecCompany.getContact().getPhoneNumber());
				panCompaniesSR.getTxtContactMail().setText(selecCompany.getContact().getEmail());
			} catch (NullPointerException excpt) {

			}
		}
}


	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}