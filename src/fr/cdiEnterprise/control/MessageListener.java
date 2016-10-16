/**
 * 
 */
package fr.cdiEnterprise.control;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import fr.cdiEnterprise.dao.Datas;
import fr.cdiEnterprise.model.Item;
import fr.cdiEnterprise.model.Trainee;
import fr.cdiEnterprise.model.User;
import fr.cdiEnterprise.service.Clients;
import fr.cdiEnterprise.util.ReadProperties;
import fr.cdiEnterprise.view.MainFrame;
import fr.cdiEnterprise.view.MessagingMainPanel;
import fr.cdiEnterprise.view.MessagingNewPanel;
import fr.cdiEnterprise.view.UserPanel;

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
public class MessageListener implements ActionListener, KeyListener, MouseListener {

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
		
		}if(e.getSource() ==  panelMain.getBtnDisplay()) {
			
			
			
			System.out.println("switch to panel : new message");
			
		
		}
		if(e.getSource() ==  panelNew.getBtnEnv()) {
			
			//panelNew = new MessagingNewPanel();
			System.out.println("envoie from " + panelNew.getFrom());
			String receiver = (String) panelNew.getCboReceiver().getItemAt(panelNew.getCboReceiver().getSelectedIndex());
			System.out.println("envoie to " + receiver);
			System.out.println("envoie objet " + panelNew.getTxtObject().getText());
			System.out.println("envoie message " + panelNew.getTxtMessage().getText());
			Clients clients = Datas.getClientBox();
			MpClient cli = clients.getClient(ReadProperties.getMyAlias());
			cli.newEmail(cli.getBox(), receiver, panelNew.getTxtObject().getText(),panelNew.getTxtMessage().getText());
			System.out.println("Message send out...");
			panelMain.refresh();
			
			
			
			
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




	
	    public void mousePressed(MouseEvent me) {
	        JTable table =(JTable) me.getSource();
	        Point p = me.getPoint();
	        int row = table.rowAtPoint(p);
	        if (me.getClickCount() == 1) {
	        	System.out.println("click..." +row);
	            // your valueChanged overridden method 
	        }
	        
	        if (me.getClickCount() == 2) {
	        	System.out.println("double click..." +row);
	            // your valueChanged overridden method 
	        }
	    }

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

}
