package fr.cdiEnterprise.view;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import fr.cdiEnterprise.control.MenuListener;

/**
 * Main menu for the CDI Enterprise program, visible on every frame.
 * Last update: 20161007 * 
 * @version 0.2
 * @author Claire, Anaïs
 */

public class Menu extends JMenuBar {

	private static final long serialVersionUID = 1L;

	// Main menu creation
	private JMenuItem menuProfile;
	private JMenu menuCompany;
	private JMenu menuSearch;
	private JMenu menuBookmark;
	private JMenu menuMessaging;
	private JMenu menuHelp;
	private JMenu menuQuit;

	// menuEntreprise : sub item
	private JMenuItem subCompanyCreate;
	private JMenuItem subCompanyUpdate;
	private JMenuItem subCompanyDelete;
	private JMenuItem subCompanyRead;

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
		// TODO check why menuItems don't stay next to each other
		// PROFILE
		menuProfile = new JMenuItem("Profil");
		this.add(menuProfile);
		// Shortcut for Profile
		menuProfile.setMnemonic('P');

		// COMPANY
		menuCompany = new JMenu("Entreprise");
		this.add(menuCompany);
		// Shortcut for Company
		menuCompany.setMnemonic('E');
		// Sub menu for Enterprise
		subCompanyCreate = new JMenuItem("Créer une nouvelle fiche");
		menuCompany.add(subCompanyCreate);
		subCompanyUpdate = new JMenuItem("Modifier une fiche");
		menuCompany.add(subCompanyUpdate);
		subCompanyDelete = new JMenuItem("Suppimer une fiche");
		menuCompany.add(subCompanyDelete);
		subCompanyRead = new JMenuItem("Afficher toutes les les fiches entreprises");
		menuCompany.add(subCompanyRead);

		// SEARCH
		menuSearch = new JMenu("Recherche");
		this.add(menuSearch);

		// BOOKMARK
		menuBookmark = new JMenu("Favoris");
		this.add(menuBookmark);

		// MESSAGING
		menuMessaging = new JMenu("Messagerie");
		this.add(menuMessaging);

		// HELP
		menuHelp = new JMenu("Aide");
		this.add(menuHelp);

		// Sub menu for Help
		subHelpDoc = new JMenuItem("Documentation");
		menuHelp.add(subHelpDoc);
		subHelpShortcut = new JMenuItem("Raccourcis clavier");
		menuHelp.add(subHelpShortcut);
		subHelpUpdate = new JMenuItem("Vérifier les mises à jours");
		menuHelp.add(subHelpUpdate);
		subHelpAbout = new JMenuItem("A propos");
		menuHelp.add(subHelpAbout);

		// QUIT
		menuQuit = new JMenu("Déconnexion");
		this.add(menuQuit);


		//LISTENER
		MenuListener listener = new MenuListener(this);
		menuProfile.addActionListener(listener);
		subCompanyCreate.addActionListener(listener);

	}

	/**
	 * @return the menuProfile
	 */
	public JMenuItem getMenuProfile() {
		return menuProfile;
	}

	/**
	 * @return the subCompanyCreate
	 */
	public JMenuItem getSubCompanyCreate() {
		return subCompanyCreate;
	}

	}
