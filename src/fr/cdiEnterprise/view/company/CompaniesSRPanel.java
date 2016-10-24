package fr.cdiEnterprise.view.company;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseListener;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

import fr.cdiEnterprise.control.PanelDeletUpdatCompListeners;
import fr.cdiEnterprise.control.PanelSRCompaniesListeners;
import fr.cdiEnterprise.dao.OldDatas;
import fr.cdiEnterprise.model.Company;
import fr.cdiEnterprise.model.Language;

public class CompaniesSRPanel extends JPanel {

	/**
	 * Panel pour l'affichage et la recherche de companies
	 */
	private static final long serialVersionUID = 1L;
	private Container panneau;
	private JPanel panNorth;
	private JPanel panSouth;
	private JPanel panCenter;
	private JPanel panWest;
	private Border border;
	private JRadioButton optAffiche;
	private JRadioButton optRecherche;
	private ButtonGroup readGrp; 
	private JLabel lblSearchByName;
	private JTextField txtSearchByName;
	private DefaultListModel<Company> dlmCompanies; 
	private JList <Company> lstCompanies;
	private JScrollPane companies;
	private JButton btnValider;
	private JButton btnCancel;
	private PanelSRCompaniesListeners clic;
	
	
	
	public CompaniesSRPanel() {
		
		panneau = this;
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
	
		optAffiche = new JRadioButton("Afficher toutes les fiches entreprises");
		optRecherche = new JRadioButton("Rechercher par critères (uniquement par nom)");
		readGrp = new ButtonGroup();
		readGrp.add(optRecherche);
		readGrp.add(optAffiche);
			
		
		lblSearchByName = new JLabel("Recherche par nom d'entreprise");
		txtSearchByName = new JTextField();
		txtSearchByName.setColumns(30);
		
		dlmCompanies = new DefaultListModel<Company>();
		lstCompanies = new JList<Company>(CompanyCreationPanel.dlmCompanies);
		lstCompanies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		companies = new JScrollPane(lstCompanies, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		companies.setPreferredSize(new Dimension(800, 800));
		
		btnValider = new JButton("Valider");
		btnCancel = new JButton("Annuler");
		
	
		panCenter.add(optAffiche);
		panCenter.add(optRecherche);
		panCenter.add(lblSearchByName);
		panCenter.add(txtSearchByName);
		panCenter.add(companies);
		panSouth.add(btnValider);
		panSouth.add(btnCancel);
	
		clic = new PanelSRCompaniesListeners(this);
		btnValider.addActionListener(clic);
		btnCancel.addActionListener(clic);
	}



	public Container getPanneau() {
		return panneau;
	}



	public void setPanneau(Container panneau) {
		this.panneau = panneau;
	}



	public JPanel getPanNorth() {
		return panNorth;
	}



	public void setPanNorth(JPanel panNorth) {
		this.panNorth = panNorth;
	}



	public JPanel getPanSouth() {
		return panSouth;
	}



	public void setPanSouth(JPanel panSouth) {
		this.panSouth = panSouth;
	}



	public JPanel getPanCenter() {
		return panCenter;
	}



	public void setPanCenter(JPanel panCenter) {
		this.panCenter = panCenter;
	}



	public JPanel getPanWest() {
		return panWest;
	}



	public void setPanWest(JPanel panWest) {
		this.panWest = panWest;
	}



	public JRadioButton getOptAffiche() {
		return optAffiche;
	}



	public void setOptAffiche(JRadioButton optAffiche) {
		this.optAffiche = optAffiche;
	}



	public JRadioButton getOptRecherche() {
		return optRecherche;
	}



	public void setOptRecherche(JRadioButton optRecherche) {
		this.optRecherche = optRecherche;
	}



	public JLabel getLblSearchByName() {
		return lblSearchByName;
	}



	public void setLblSearchByName(JLabel lblSearchByName) {
		this.lblSearchByName = lblSearchByName;
	}



	public JTextField getTxtSearchByName() {
		return txtSearchByName;
	}



	public void setTxtSearchByName(JTextField txtSearchByName) {
		this.txtSearchByName = txtSearchByName;
	}



	public DefaultListModel<Company> getDlmCompanies() {
		return dlmCompanies;
	}



	public void setDlmCompanies(DefaultListModel<Company> dlmCompanies) {
		this.dlmCompanies = dlmCompanies;
	}



	public JList<Company> getLstCompanies() {
		return lstCompanies;
	}



	public void setLstCompanies(JList<Company> lstCompanies) {
		this.lstCompanies = lstCompanies;
	}



	public JScrollPane getCompanies() {
		return companies;
	}



	public void setCompanies(JScrollPane companies) {
		this.companies = companies;
	}



	public JButton getBtnValider() {
		return btnValider;
	}



	public void setBtnValider(JButton btnValider) {
		this.btnValider = btnValider;
	}



	public JButton getBtnCancel() {
		return btnCancel;
	}



	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}



	public ButtonGroup getReadGrp() {
		return readGrp;
	}



	public void setReadGrp(ButtonGroup readGrp) {
		this.readGrp = readGrp;
	}

}
