package fr.cdiEnterprise.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.cdiEnterprise.view.RechercheAvanceePanel;


public class PanelRechercheAvanceeListener implements ActionListener{

	//private RechercheAvanceeFrame 
	private String mcRaisonSociale;  
	private String mcDomaine;
	private String mcVille;
	private String mcRegion;
	private RechercheAvanceePanel panelRecherche;
//	private String rqtSqlRecherche;
	
/**
 * 
 * @author  Olivier
 */
	public PanelRechercheAvanceeListener(RechercheAvanceePanel pannelRecherche) {
		this.panelRecherche = pannelRecherche;
		mcRaisonSociale="";
		mcDomaine="";
		mcVille="";
		mcRegion="";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==panelRecherche.getBtnEffacer()){
			if(panelRecherche.getChkRaisonSocial().isSelected()){
				panelRecherche.getTxtRaisonSocial().setText("");
			}else if(panelRecherche.getChkDomaine().isSelected()){
				panelRecherche.getTxtDomaine().setText("");
			}else if (panelRecherche.getChkVille().isSelected()){
				panelRecherche.getTxtVille().setText("");
			}else if (panelRecherche.getChkRegion().isSelected()){
				panelRecherche.getTxtRegion().setText("");
			}

		}
		
		if(e.getSource()==panelRecherche.getBtnDelete()){
			panelRecherche.clear();
		}
		if(e.getSource()==panelRecherche.getBtnRechercher()){
			if(panelRecherche.getChkRaisonSocial().isSelected()){
				mcRaisonSociale = panelRecherche.getTxtRaisonSocial().getText();
			}
			if(panelRecherche.getChkDomaine().isSelected()){
				mcDomaine = panelRecherche.getTxtDomaine().getText();
			}
			if(panelRecherche.getChkVille().isSelected()){
				mcVille = panelRecherche.getTxtVille().getText();
			}
			if(panelRecherche.getChkRegion().isSelected()){
				mcRegion = panelRecherche.getTxtRegion().getText();
			}
			System.out.println(mcRaisonSociale + "," + mcDomaine + "," + mcVille + "," + mcRegion );
			
		}
		//panelRecherche.clear();
	}

	//	txtRaisonSocial.setText("");
	//	txtDomaine.setText("");
	//	txtVille.setText("");
	//	txtRegion.setText("");
	//	chkRaisonSocial.setSelected(false);
	//	chkDomaine.setSelected(false);
	//	chkVille.setSelected(false);
	//	chkRegion.setSelected(false);
}
