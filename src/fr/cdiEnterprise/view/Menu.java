package fr.cdiEnterprise.view;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import fr.cdiEnterprise.control.MainMenuListener;


/**
 * Main menu for the CDI Enterprise program, visible on every frame.
 * Last update: 20161007 * 
 * @version 0.2
 * @author Claire, Anais, Nicolas, Ismael
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
	private JMenuItem subMessageDisplay;
	
	// menuHelp : sub item
	private JMenuItem subHelpDoc;
	private JMenuItem subHelpShortcut;
	private JMenuItem subHelpUpdate;
	private JMenuItem subHelpAbout;

	/**
	 * Constructor
	 */
	public Menu() {

		// TODO shortcuts - use of char obsolete?
		
		// PROFILE TODO MenuListener
		menuProfile = new JMenu("Profil");
		this.add(menuProfile);
		subProfileCrud = new JMenuItem("Gérer les profils");
		menuProfile.add(subProfileCrud);

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

		// BOOKMARK
		menuBookmark = new JMenu("Favoris");
		this.add(menuBookmark);

		// MESSAGING
		menuMessaging = new JMenu("Messagerie");
		subMessageDisplay = new JMenuItem("Affichage");
		menuMessaging.add(subMessageDisplay);
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
		
		menuBookmark.addActionListener(listener);


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
	 * @return the menuBookmark
	 */
	public JMenu getMenuBookmark() {
		return menuBookmark;
	}

	public JMenuItem getSubMessageDisplay() {
		return subMessageDisplay;
	}

	}
