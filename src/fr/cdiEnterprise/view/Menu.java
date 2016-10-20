package fr.cdiEnterprise.view;

import javax.swing.JMenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import fr.cdiEnterprise.control.MainMenuListener;


/**
 * Main menu for the CDI Enterprise program, visible on every frame.
 * @author Claire, Anais, Nicolas, Ismael, Olivier
 * @version 07-10-2016
 */

public class Menu extends JMenuBar {

	private static final long serialVersionUID = 1L;

	// Main menu creation
	private JMenu menuProfile;
	private JMenu menuCompany;
	private JMenu menuSearch;
	private JMenu menuBookmark;
	private JMenu menuMessaging;
	private JMenu menuHelp;
	private JMenu menuQuit;

	// menuProfile : sub item
	private JMenuItem subProfileCrud;

	// menuEntreprise : sub item
	private JMenuItem subCompanyCreate;
	private JMenuItem subCompanyUpdateDelete;
	private JMenuItem subCompanyRead;
	
	// menuSearch : sub item
	private JMenuItem subSearchRechercher;
	private JMenuItem subSearchDeleteRecherche;
	
	private JMenuItem subMessageDisplay;

	//menuBokkMark : sub item
	private JMenuItem subBookMarkRead;

	// menuHelp : sub item
	private JMenuItem subHelpDoc;
	private JMenuItem subHelpShortcut;
	private JMenuItem subHelpUpdate;
	private JMenuItem subHelpAbout;

	/**
	 * Constructor
	 */
	public Menu() {

		// PROFILE
		menuProfile = new JMenu("Profil");
		this.add(menuProfile);
		subProfileCrud = new JMenuItem("Gérer les profils");
		menuProfile.add(subProfileCrud);
		subProfileCrud.setMnemonic(KeyEvent.VK_P);
		subProfileCrud.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

		// COMPANY
		menuCompany = new JMenu("Entreprise");
		this.add(menuCompany);
		// Shortcut for Company
		//menuCompany.setMnemonic('E');
		// Sub menu for Enterprise
		subCompanyCreate = new JMenuItem("Créer une nouvelle fiche");
		menuCompany.add(subCompanyCreate);
		subCompanyUpdateDelete = new JMenuItem("Modifier / Supprimer une fiche");
		menuCompany.add(subCompanyUpdateDelete);
		subCompanyRead = new JMenuItem("Afficher toutes les fiches entreprises");
		menuCompany.add(subCompanyRead);

		// SEARCH
		menuSearch = new JMenu("Recherche");
		this.add(menuSearch);
		subSearchRechercher = new JMenuItem("Rechercher une fiche entreprise");
		menuSearch.add(subSearchRechercher);
		subSearchDeleteRecherche = new JMenuItem("Supprimer une recherche");
		menuSearch.add(subSearchDeleteRecherche);

		

		// BOOKMARK
		menuBookmark = new JMenu("Favoris");
		this.add(menuBookmark);
		subBookMarkRead = new JMenuItem("Mes Favoris");
		menuBookmark.add(subBookMarkRead);

		// MESSAGING
		menuMessaging = new JMenu("Messagerie");
		subMessageDisplay = new JMenuItem("Affichage");
		menuMessaging.add(subMessageDisplay);
		subMessageDisplay.setMnemonic(KeyEvent.VK_M);
		subMessageDisplay.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		this.add(menuMessaging);

		// HELP
		menuHelp = new JMenu("Aide");
		this.add(menuHelp);
	

		// Sub menu for Help
		subHelpDoc = new JMenuItem("Documentation");
		menuHelp.add(subHelpDoc);
		subHelpShortcut = new JMenuItem("Raccourcis clavier");
		menuHelp.add(subHelpShortcut);
		subHelpUpdate = new JMenuItem("Vérifier les mises à  jours");
		menuHelp.add(subHelpUpdate);
		subHelpAbout = new JMenuItem("A propos");
		menuHelp.add(subHelpAbout);

		// QUIT
		menuQuit = new JMenu("Déconnexion");
		this.add(menuQuit);


		//LISTENER
		MainMenuListener listener = new MainMenuListener(this);
		subProfileCrud.addActionListener(listener);

		subMessageDisplay.addActionListener(listener);

		subCompanyCreate.addActionListener(listener);
		subCompanyUpdateDelete.addActionListener(listener);
		
		subSearchRechercher.addActionListener(listener);
		subSearchDeleteRecherche.addActionListener(listener);
		menuBookmark.addActionListener(listener);
		subBookMarkRead.addActionListener(listener);

	}

	/**
	 * @return the menuProfile
	 */
	public JMenuItem getSubProfileCrud() {
		return subProfileCrud;
	}

	/**
	 * @return the subCompanyCreate
	 */
	public JMenuItem getSubCompanyCreate() {
		return subCompanyCreate;
	}

	public JMenuItem getSubCompanyUpdateDelete(){
		return subCompanyUpdateDelete;
	}
	
	/**
	 * @return the subSearchRechercher
	 */
	public JMenuItem getSubSearchRechercher() {
		return subSearchRechercher;
	}
	
	/**
	 * @return the subSearchDeleteRecherche
	 */
	public JMenuItem getSubSearchDeleteRecherche() {
		return subSearchDeleteRecherche;
	}

	/**
	 * @return the subBookMarkRead
	 */
	public JMenuItem getSubBookMarkRead() {
		return subBookMarkRead;
	}


	public JMenuItem getSubMessageDisplay() {
		return subMessageDisplay;
	}

}
