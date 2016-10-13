/**
 * 
 */
package fr.cdiEnterprise.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

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
public class MainMenuListener implements ActionListener, MenuListener {

	private Menu menu;

	/**
	 * @param menu
	 */
	public MainMenuListener(Menu menu) {
		this.menu = menu;
	}

	// ACTION LISTENER
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == menu.getSubCompanyCreate()){
			MainFrame.getMainPan().removeAll();
			MainFrame.getMainPan().add(MainFrame.getPanelCreatCompany());
			MainFrame.getMainPan().repaint();
			MainFrame.getMainPan().revalidate();
		}
		
		if(e.getSource() == menu.getSubCompanyUpdateDelete()){
			MainFrame.getMainPan().removeAll();
			MainFrame.getMainPan().add(MainFrame.getPanelDeletUpdatCompany());
			MainFrame.getMainPan().repaint();
			MainFrame.getMainPan().revalidate();
		}
		
		if(e.getSource() == menu.getSubMessageDisplay()){
			MainFrame.getMainPan().removeAll();
			MainFrame.getMainPan().add(MainFrame.getPanelMessaging());
			MainFrame.getMainPan().validate();
			MainFrame.getMainPan().repaint();
			
		}
		if(e.getSource() == menu.getMenuBookmark())
		{
			MainFrame.getMainPan().removeAll();
			MainFrame.getMainPan().add(MainFrame.getPanelBookMark());
			MainFrame.getMainPan().validate();
			MainFrame.getMainPan().repaint();
		}
		
	}


	// MENU LISTENER
	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	// TODO deselected menu
	@Override
	public void menuSelected(MenuEvent e) {
		
		if(e.getSource() == menu.getMenuProfile()) {
			MainFrame.getMainPan().removeAll();
			MainFrame.getMainPan().add(MainFrame.getScrollUser());
			MainFrame.getMainPan().repaint();
			MainFrame.getMainPan().revalidate();
	
		}
		
	}

}
