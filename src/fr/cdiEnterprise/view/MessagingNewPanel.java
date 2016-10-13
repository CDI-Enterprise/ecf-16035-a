/**
 * 
 */
package fr.cdiEnterprise.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import fr.cdiEnterprise.control.MessageListener;
import net.miginfocom.swing.MigLayout;

/**
 * @author Administrateur
 *
 */
public class MessagingNewPanel extends JPanel {
	
	private JButton btnEnv;
	private JButton btnDraft;
	private JButton btnReturn;
	
	private JLabel receiver;
	private JLabel object;
	private JLabel Message;
	
	private JTextField txtReceiver;
	private JTextField txtObject;
	private JTextArea  txtMessage;
	
	
	
	public MessagingNewPanel() {
		
		
		MessageListener listener = new MessageListener((JPanel) this);
		
		JPanel panMess = new JPanel();
		JPanel panNorth = new JPanel();
		JPanel panCenter = new JPanel();
		panMess.setLayout(new BorderLayout());
		add(panMess);
		panMess.add(panNorth,BorderLayout.NORTH);
		panMess.add(panCenter,BorderLayout.CENTER);
		
		
		JLabel lblTitle = new JLabel("- Nouveau Message -");
		
		btnEnv = new JButton("Envoyé");
		btnDraft = new JButton("Brouillon");
		btnReturn = new JButton("Retour");
		
		receiver = new JLabel("Destinataire");
		object = new JLabel("Objet");
		Message = new JLabel("Texte");
		
		txtReceiver = new JTextField();
		txtObject = new JTextField();
		txtMessage = new JTextArea();
		
		panNorth.add(lblTitle);
		panCenter.setLayout(new MigLayout());
		
		
		panCenter.add(receiver, "w 200!");
		panCenter.add(txtReceiver, "wrap");
		panCenter.add(object, "w 200!");
		panCenter.add(txtObject, "wrap");
		
		panCenter.add(Message, "w 200!");
		panCenter.add(txtMessage, "wrap");
		
		panCenter.add(btnEnv, "w 200!");
		panCenter.add(btnDraft, "w 200!");
		panCenter.add(btnReturn, "w 200!");
		
		
		btnEnv.addActionListener(listener);
		btnDraft.addActionListener(listener);
		btnReturn.addActionListener(listener);
		
		
		
		
	}



	public JButton getBtnEnv() {
		return btnEnv;
	}



	public JButton getBtnDraft() {
		return btnDraft;
	}



	public JButton getBtnReturn() {
		return btnReturn;
	}





}
