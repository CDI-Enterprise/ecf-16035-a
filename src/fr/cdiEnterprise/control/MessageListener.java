/**
 * 
 */
package fr.cdiEnterprise.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import fr.cdiEnterprise.dao.Datas;
import fr.cdiEnterprise.model.Trainee;
import fr.cdiEnterprise.model.User;
import fr.cdiEnterprise.view.MainFrame;
import fr.cdiEnterprise.view.MessagingMainPanel;
import fr.cdiEnterprise.view.MessagingNewPanel;
import fr.cdiEnterprise.view.PanelUser;

/**
 * Class for the actionListner dedicated to the Messaging part.
 * This class is able to identify if the user ask to create a new messa, znd return back to the 
 * message list.
 * 
 * 
 * @version 13-10-2016
 * @author Nicolas Tarral
 *
 */
public class MessageListener implements ActionListener, KeyListener {

	// Given attribute
	private static MessagingMainPanel panelMain;
	private MessagingNewPanel panelNew;
	private JPanel panel;
	private static final int MESSAGE_MAX_SIZE = 850;
	// Attribute to create-update a user
	private User user;
	private String alias;
	private String email;
	private int nbCaracters;
	
	
	/**
	 * Constructs a listener taking a panel for attribute
	 */
	public MessageListener(JPanel panelUser) {
		
		if(panelUser instanceof MessagingMainPanel) {
			
			this.panelMain = (MessagingMainPanel) panelUser;
		} 
		if(panelUser instanceof MessagingNewPanel) {
			panelNew = (MessagingNewPanel) panelUser;
		}

		
		
	}

	// ACTION LISTENER
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		if(e.getSource() ==  panelMain.getBtnNew()) {
			
			panelNew = new MessagingNewPanel();
			
			System.out.println("switch to panel : new message");
			MainFrame.SwithPanel(panelNew);
		
		}if(e.getSource() ==  panelNew.getBtnEnv()) {
			
			//panelNew = new MessagingNewPanel();
		
			
			
			System.out.println("switch to panel : main message");
			MainFrame.SwithPanel(panelMain);
		
		}
		
		
		if(e.getSource() ==  panelNew.getBtnReturn()) {
			
			//panelNew = new MessagingNewPanel();
			
			System.out.println("switch to panel : main message");
			MainFrame.SwithPanel(panelMain);
		
		}
	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		int nb = 0;
		System.out.println("lettre tapée : " +e.getKeyChar());
		nb ++;
		nbCaracters += nb;
		System.out.println("nombre de lettre tapées " + nbCaracters);
		panelNew.getLblCounter().setText((MESSAGE_MAX_SIZE - nbCaracters)+"");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
