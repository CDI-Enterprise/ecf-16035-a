/**
 * 
 */
package fr.cdiEnterprise.view.test;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import fr.cdiEnterprise.control.test.UserMenuTestListener;

/**
 * Menu test to only display the profile JMenu.
 * @author Claire
 * @version 22-10-2016 
 *
 */
public class UserMenuTest extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Main menu creation
	private JMenu menuProfile;
	// menuProfile : sub item
	private JMenuItem subProfileCRUD;
	private JMenuItem subProfileSR;	

	/**
	 * Constructor.
	 */
	public UserMenuTest() {
		// PROFILE
		menuProfile = new JMenu("Profil");
		this.add(menuProfile);
		subProfileCRUD = new JMenuItem("Administrer les profils");
		menuProfile.add(subProfileCRUD);
		subProfileCRUD.setMnemonic(KeyEvent.VK_P);
		subProfileCRUD.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		subProfileSR = new JMenuItem("Liste des membres");
		menuProfile.add(subProfileSR);

		//LISTENER
		UserMenuTestListener listener = new UserMenuTestListener(this);
		subProfileCRUD.addActionListener(listener);
		subProfileSR.addActionListener(listener);

	}
	
	/**
	 * @return the subProfileCRUD
	 */
	public JMenuItem getSubProfileCRUD() {
		return subProfileCRUD;
	}
	
	/**
	 * @return the subProfileSR
	 */
	public JMenuItem getSubProfileSR() {
		return subProfileSR;
	}

}
