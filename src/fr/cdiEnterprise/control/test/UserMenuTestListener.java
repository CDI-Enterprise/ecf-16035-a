/**
 * 
 */
package fr.cdiEnterprise.control.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.cdiEnterprise.view.MainFrame;
import fr.cdiEnterprise.view.test.UserMenuTest;

/**
 * @author Claire
 *
 */
public class UserMenuTestListener implements ActionListener {

	private UserMenuTest menu;

	/**
	 * 
	 */
	public UserMenuTestListener(UserMenuTest menu) {
		this.menu = menu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Display the panel for User management
		if(e.getSource() == menu.getSubProfileCRUD()) {

			MainFrame.getPanMain().removeAll();
			MainFrame.getPanMain().add(MainFrame.getScrollPanelUserCRUD());
			MainFrame.getPanMain().validate();
			MainFrame.getPanMain().repaint();
		}

		// Display the panel with a list of existing members
		if(e.getSource() == menu.getSubProfileCRUD()) {

			MainFrame.getPanMain().removeAll();
			MainFrame.getPanMain().add(MainFrame.getScrollPanelUserSR());
			MainFrame.getPanMain().validate();
			MainFrame.getPanMain().repaint();
		}

	}

}
