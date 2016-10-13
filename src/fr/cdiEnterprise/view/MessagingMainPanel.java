/**
 * 
 */
package fr.cdiEnterprise.view;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import fr.cdiEnterprise.control.MessageListener;
import net.miginfocom.swing.MigLayout;

/**
 * This class is going to display the main messenging's page, which contains all the messages for the user.
 * from there user will be able to create new message, remove or edit draft message
 * @author Nicolas Tarral
 * @version 11-10-2016
 *
 */
public class MessagingMainPanel extends JPanel {
	
	private JButton btnNew;
	private JButton btnDraft;
	private JButton btnDisplay;
	
	
	
	/**
	 * Default constructor 
	 */
	public MessagingMainPanel() {
		
		
		
		MessageListener listener = new MessageListener((JPanel) this);
		
		DefaultListModel<String> listModele = new DefaultListModel<>();
		for(int i =0; i< 15; i++) {
			listModele.addElement("- Nicolas -");
		}
		
		
		JPanel panMess = new JPanel();
		JPanel panNorth = new JPanel();
		JPanel panCenter = new JPanel();
		panMess.setLayout(new BorderLayout());
		add(panMess);
		panMess.add(panNorth,BorderLayout.NORTH);
		panMess.add(panCenter,BorderLayout.CENTER);
		
		JLabel lblTitle = new JLabel("- Messagerie -");
		JLabel lblMess = new JLabel("Nombre de Message(s) :");
		JLabel lblNombre = new JLabel("20");
		
		btnNew = new JButton("Nouveau");
		btnDraft = new JButton("Brouillon");
		btnDisplay = new JButton("Refersh");
		
		JList<String> list = new JList<String>(listModele);
		
		
		panNorth.add(lblTitle);
		panCenter.setLayout(new MigLayout());
		
		panCenter.add(btnNew, "w 200!");
		panCenter.add(btnDraft, "w 200!");
		panCenter.add(btnDisplay, "wrap");
		panCenter.add(lblMess, "w 200!");
		panCenter.add(lblNombre, "wrap");
		
		panCenter.add(list, "wrap");
		
		btnNew.addActionListener(listener);
		btnDraft.addActionListener(listener);
		btnDisplay.addActionListener(listener);
	}

	public JButton getBtnNew() {
		return btnNew;
	}

	public JButton getBtnDraft() {
		return btnDraft;
	}

	public JButton getBtnDisplay() {
		return btnDisplay;
	}

}
