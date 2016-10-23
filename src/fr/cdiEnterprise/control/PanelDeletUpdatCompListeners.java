package fr.cdiEnterprise.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fr.cdiEnterprise.dao.OldDatas;
import fr.cdiEnterprise.model.Company;
import fr.cdiEnterprise.view.MainFrame;
import fr.cdiEnterprise.view.company.CompanyCreationPanel;
import fr.cdiEnterprise.view.company.CompanyDeletUpdatPanel;


public class PanelDeletUpdatCompListeners implements ActionListener, ListSelectionListener, MouseListener {

	private CompanyDeletUpdatPanel panCompDeletUpdat;
	private Company selecCompanie;
	private int selecIndex;
	
	
	public PanelDeletUpdatCompListeners(CompanyDeletUpdatPanel panCompDeletUpdat) {
		this.panCompDeletUpdat = panCompDeletUpdat;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == panCompDeletUpdat.getBtnCancel()){
			MainFrame.getPanMain().removeAll();
			MainFrame.getPanMain().add(MainFrame.getPanHome());
			MainFrame.getPanMain().repaint();
			MainFrame.getPanMain().revalidate();
		}
		
		if (e.getSource() == panCompDeletUpdat.getBtnDelete()){
			System.out.println(OldDatas.getCompaniesList());
			System.out.println("*******Suppression*****");
			OldDatas.getCompaniesList().remove(selecCompanie);
			System.out.println(OldDatas.getCompaniesList());
			CompanyCreationPanel.getDlmCompanies().remove(selecIndex);
		}

		if (e.getSource() == panCompDeletUpdat.getBtnUpdate()){
			System.out.println("Modification d'une entreprise");
			selecCompanie.setAdress(panCompDeletUpdat.getTxtCompanyAdress().getText());			
			CompanyCreationPanel.getDlmCompanies().set(selecIndex, selecCompanie);
			OldDatas.getCompaniesList().set(selecIndex, selecCompanie);
			System.out.println(OldDatas.getCompaniesList());
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent ev) {
//		if (ev.getSource() == panCompDeletUpdat.getLstCompanies()) {
////			System.out.println("Affiche");     (test)
//			selecCompanie = (Company) panCompDeletUpdat.getLstCompanies().getSelectedValue();
//			selecIndex = panCompDeletUpdat.getLstCompanies().getSelectedIndex();
////			System.out.println(selecCompanie);    (test)
////			System.out.println(selecIndex);       (test)
//		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO (Anaïs) Auto-generated method stub
//		JList list = (JList)e.getSource();
//
//		if (e.getClickCount() == 2) {
//			    System.out.println("double clicked");
//		}
		
      if(e.getSource() == panCompDeletUpdat.getLstCompanies()) {
    	selecCompanie = (Company) panCompDeletUpdat.getLstCompanies().getSelectedValue();
		selecIndex = panCompDeletUpdat.getLstCompanies().getSelectedIndex();
        panCompDeletUpdat.getTxtCompanyName().setText(selecCompanie.getCompanyName());
		panCompDeletUpdat.getTxtCompanyAdress().setText(selecCompanie.getAdress());
		panCompDeletUpdat.getTxtCompanyCity().setText(selecCompanie.getCity());
		panCompDeletUpdat.getTxtPostalCode().setText(selecCompanie.getPostalCode());
		panCompDeletUpdat.getTxtSector().setText(selecCompanie.getSector());
		panCompDeletUpdat.getTxtProjets().setText(selecCompanie.getProjets());
		panCompDeletUpdat.getTxtWebSite().setText(selecCompanie.getWebSite());
		panCompDeletUpdat.getTxtContactName().setText(selecCompanie.getContact().getName());
		panCompDeletUpdat.getTxtContactPhone().setText(selecCompanie.getContact().getPhoneNumber());
		panCompDeletUpdat.getTxtContactMail().setText(selecCompanie.getContact().getEmail());
      }
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO (Anaïs) Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO (Anaïs) Auto-generated method stub		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO (Anaïs) Auto-generated method stub		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO (Anaïs) Auto-generated method stub		
	}

}

