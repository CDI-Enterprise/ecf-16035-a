package fr.cdiEnterprise.view;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * Main menu for the CDI Enterprise program, visible on every frame.
 * Last update: 20161003
 * @version 0.2
 * @author Claire, Anaïs
 */

public class Menu extends JMenuBar {

	private static final long serialVersionUID = 1L;

	/* Attributes */
	// Main menu creation
	private JMenu menuProfile = new JMenu("Profil");
	private JMenu menuEnterprise = new JMenu("Entreprise");
	private JMenu menuSearch = new JMenu("Recherche");
	private JMenu menuBookmark = new JMenu("Favoris");
	private JMenu menuMessaging = new JMenu("Messagerie");
	private JMenu menuHelp = new JMenu("Aide");
	private JMenu menuQuit = new JMenu("Déconnexion");

	// menuHelp : sub item
	private JMenuItem subHelpDoc = new JMenuItem("Documentation");
	private JMenuItem subHelpShortcut = new JMenuItem("Raccourcis clavier");
	private JMenuItem subHelpUpdate = new JMenuItem("Vérifier les mises à jours");
	private JMenuItem subHelpAbout = new JMenuItem("A propos");

	// menuEntreprise : sub item
	private JMenuItem subCompanyCreate = new JMenuItem("Créer une nouvelle fiche");
	private JMenuItem subCompanyUpdate = new JMenuItem("Modifier une fiche");
	private JMenuItem subCompanyDelete = new JMenuItem("Suppimer une fiche");
	private JMenuItem subCompanyRead = new JMenuItem("Afficher toutes les fiches Entreprise");

	
	/**
	 * Constructor 
	 */
	public Menu() {
		// PROFILE
		this.add(menuProfile);

		// ENTERPRISE
		this.add(menuEnterprise);
		//Sub menu for Enterprise
		menuEnterprise.add(subCompanyCreate);
		menuEnterprise.add(subCompanyUpdate);
		menuEnterprise.add(subCompanyDelete);
		menuEnterprise.add(subCompanyRead);

		// SEARCH
		this.add(menuSearch);

		// BOOKMARK
		this.add(menuBookmark);

		// MESSAGING
		this.add(menuMessaging);

		// HELP
		this.add(menuHelp);
		// Sub menu for Help
		menuHelp.add(subHelpDoc);
		menuHelp.add(subHelpShortcut);
		menuHelp.add(subHelpUpdate);
		menuHelp.add(subHelpAbout);
		
		// QUIT
		this.add(menuQuit);

		// Menu shortcut
		menuProfile.setMnemonic('P'); 		// Use of char obsolete? TODO shortcuts
		menuEnterprise.setMnemonic('E');
		
	}
}