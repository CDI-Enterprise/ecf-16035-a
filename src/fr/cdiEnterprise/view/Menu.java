package fr.cdiEnterprise.view;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * Main menu for the CDI Enterprise program, visible on every frame.
 * Last update: 20160930
 * @version 1.0
 * @author Claire
 *
 */

//J'ai modifi� un peu ta classe Claire pour ma partie mais je ne sais pas si je dois incr�menter la version et tout ;)

public class Menu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* MAIN */
	// Main menu creation
	JMenu menuProfile = new JMenu("Profil");
	JMenu menuEnterprise = new JMenu("Entreprise");
	JMenu menuSearch = new JMenu("Recherche");
	JMenu menuBookmark = new JMenu("Favoris");
	JMenu menuMessaging = new JMenu("Messagerie");
	JMenu menuHelp = new JMenu("Aide");
	JMenu menuQuit = new JMenu("D�connexion");

	// /* SUB */
	// //menuFile : sub menu and item
	// JMenu subFileNew = new JMenu("Cr�er...");
	// JMenuItem subFileSave = new JMenuItem("Enregistrer", 'S');
	// JMenuItem subFileQuit = new JMenuItem("Quitter", 'Q');

	// menuHelp : sub item
	JMenuItem subHelpDoc = new JMenuItem("Documentation");
	JMenuItem subHelpShortcut = new JMenuItem("Raccourcis clavier");
	JMenuItem subHelpUpdate = new JMenuItem("V�rifier les mises � jours");
	JMenuItem subHelpAbout = new JMenuItem("A propos");


	// menuEntreprise : sub item
	JMenuItem subCompanyCreate = new JMenuItem("Cr�er une nouvelle fiche");
	JMenuItem subCompanyModify = new JMenuItem("Modifier une fiche");
	JMenuItem subCompanyDelete = new JMenuItem("Suppimer une fiche");
	JMenuItem subCompanyList = new JMenuItem("Afficher toutes les les fiches entreprises");

	// /* SUB SUB */
	// //subFileNew : item
	// JMenuItem subNewUser = new JMenuItem(USER, 'U');
	// JMenuItem subNewBook = new JMenuItem(BOOK, 'B');
	// JMenuItem subNewLoan = new JMenuItem(LOAN, 'L');

	public Menu() {
		// PROFILE
		this.add(menuProfile);

		// ENTERPRISE
		this.add(menuEnterprise);

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

		//Sub menu for Entreprise
		menuEnterprise.add(subCompanyCreate);
		menuEnterprise.add(subCompanyModify);
		menuEnterprise.add(subCompanyDelete);
		menuEnterprise.add(subCompanyList);
		
		// QUIT
		this.add(menuQuit);

		// Menu shortcut
		menuProfile.setMnemonic('P'); // Use of char obsolete? TODO shortcuts
		menuEnterprise.setMnemonic('E');
	}
}