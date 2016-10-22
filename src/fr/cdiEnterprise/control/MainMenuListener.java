/**
 * 
 */
package fr.cdiEnterprise.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.cdiEnterprise.view.MainFrame;
import fr.cdiEnterprise.view.Menu;

/**
 * Listeners for menu of the main frame
 * @version 07-10-2016
 * @author Claire, Anais, Nicolas, Ismael, Olivier
 */

// TODO (Groupe) is this the best listener for a JMenuBar?
public class MainMenuListener implements ActionListener {

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
		
		// Display the panel user
		if(e.getSource() == menu.getSubProfileCrud()) {
			
			MainFrame.getMainPan().removeAll();
			MainFrame.getMainPan().add(MainFrame.getScrollUser());
			MainFrame.getMainPan().repaint();
			MainFrame.getMainPan().validate();
	
		}
		
		if(e.getSource() == menu.getSubCompanyCreate()){
			MainFrame.getMainPan().removeAll();
			MainFrame.getMainPan().add(MainFrame.getScrollCreateCompany());
			MainFrame.getMainPan().repaint();
			MainFrame.getMainPan().revalidate();
		}
		
		if(e.getSource() == menu.getSubCompanyUpdateDelete()){
			MainFrame.getMainPan().removeAll();
			MainFrame.getMainPan().add(MainFrame.getScrollUpdateDeleteCompany());
			MainFrame.getMainPan().repaint();
			MainFrame.getMainPan().revalidate();
		}
		
		if(e.getSource() == menu.getSubMessageDisplay()){
			MainFrame.getMainPan().removeAll();
			MainFrame.getMainPan().add(MainFrame.getPanelMessaging());
			MainFrame.getMainPan().validate();
			MainFrame.getMainPan().repaint();
			
		}
		if(e.getSource() == menu.getSubBookMarkRead())
		{
			MainFrame.getMainPan().removeAll();
			MainFrame.getMainPan().add(MainFrame.getPanelBookMark());
			MainFrame.getMainPan().validate();
			MainFrame.getMainPan().repaint();
		}
		
		if(e.getSource() == menu.getSubSearchRechercher())
		{
			MainFrame.getMainPan().removeAll();
			MainFrame.getMainPan().add(MainFrame.getPanelRecherche());
			MainFrame.getMainPan().validate();
			MainFrame.getMainPan().repaint();
		}
		
	}

}
