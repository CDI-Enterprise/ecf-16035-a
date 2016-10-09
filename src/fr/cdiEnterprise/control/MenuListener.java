/**
 * 
 */
package fr.cdiEnterprise.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.cdiEnterprise.view.Menu;
import fr.cdiEnterprise.view.MainFrame;

/**
 * Listeners for menu of the main frame
 * Last update: 20161007
 * @version 0.1
 * @author Claire
 *
 */
// TODO is this the best listener for a JMenuBar?
public class MenuListener implements ActionListener {

	private Menu menu;

	/**
	 * @param menu
	 */
	public MenuListener(Menu menu) {
		this.menu = menu;
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == menu.getMenuProfile()) {
			MainFrame.getMainPan().removeAll();
			MainFrame.getMainPan().add(MainFrame.getPanelUser());
			MainFrame.getMainPan().repaint();
			MainFrame.getMainPan().revalidate();
		}

	}

}
