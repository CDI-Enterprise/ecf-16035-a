/**
 * 
 */
package fr.cdiEnterprise.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.StyledDocument;

import fr.cdiEnterprise.control.MessageListener;

import fr.cdiEnterprise.model.User;
import fr.cdiEnterprise.service.Users;
import fr.cdiEnterprise.util.ReadProperties;
import javafx.scene.control.ComboBox;
import net.miginfocom.swing.MigLayout;


/**
 * class nouveau message, inclu une combobox qui donne accés aux psuedo des utlisateurs de la class Datas.
 * 
 * 
 * @version 13-10-2016
 * @author nicolas Tarral
 *
 */
public class MessagingNewPanel extends JPanel {
	
	private JButton btnEnv;
	private JButton btnDraft;
	private JButton btnReturn;
	private Border border;
	private Border borderMessage;
	
	private String from;
	private JLabel receiver;
	private JLabel lblobject;
	private JLabel Message;
	private JLabel letterCount;
	private JLabel lblCounter;
	private JTextPane textPane;
	
	private JComboBox cboReceiver;
	private JTextField txtReceiver;
	private JTextField txtObject;
	private JTextArea  txtMessage;
	private JScrollPane scroll;
	
	private static final int MAX_CHARACTERS = 450;
	private Users usersList;


	
	public MessagingNewPanel(Users list) {
		
		
		MessageListener listener = new MessageListener((JPanel) this);
		
		borderMessage = BorderFactory.createTitledBorder(" Nouveau Message ");
		border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		usersList = list;
		from = MessageListener.alias;
		
		
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
		
		btnEnv.setMnemonic(KeyEvent.VK_E);
		btnDraft.setMnemonic(KeyEvent.VK_B);
		btnReturn.setMnemonic(KeyEvent.VK_R);
		
		receiver = new JLabel("Destinataire");
		lblobject = new JLabel("Objet");
		Message = new JLabel("Texte");
		letterCount = new JLabel("compteur");
		lblCounter =   new JLabel();
		
	
		
//		textPane = new JTextPane();
//		textPane.setCaretPosition(0);
//		textPane.setBounds(0, 0, 200, 200);
//        textPane.setMargin(new Insets(5,5,5,5));
        
       // JScrollPane scrollPane = new JScrollPane(textPane);
      //  scrollPane.setPreferredSize(new Dimension(200, 200));

        
	
		//StyledDocument styledDoc = textPane.getStyledDocument();
		
		//if (styledDoc instanceof AbstractDocument) {

	//	}
		//textPane.setBorder(border);
		
		
		
		

		cboReceiver = new JComboBox();
		cboReceiver.setEditable(true);
		cboReceiver.setMaximumRowCount(3);
		//txtReceiver = new JTextField();
		txtObject = new JTextField(20);
		
		txtMessage = new JTextArea(10, 50);
		txtMessage.setLineWrap(true);
		txtMessage.setWrapStyleWord(true);
		txtMessage.setBorder(border);
		
		AbstractDocument doc = (AbstractDocument) txtMessage.getDocument();
		
	    doc.setDocumentFilter(new DocumentSizeFilter(MAX_CHARACTERS));
		
		if(usersList != null) {
			for(User current : usersList) {
				if(current != null) {
					cboReceiver.addItem(current.getAlias());
					}	
			}
		}else {
			//System.out.println("usersList is null ");
		}
		
		
		panNorth.add(lblTitle);
		panCenter.setLayout(new MigLayout());
		panCenter.setBorder(borderMessage);
		
		panCenter.add(receiver, "w 200!");
		panCenter.add(cboReceiver, "wrap");
		panCenter.add(lblobject, "w 200!");
		panCenter.add(txtObject, "wrap");
		
		panCenter.add(Message, "w 200!");
		panCenter.add(txtMessage, "wrap");

		panCenter.add(letterCount, "w 200!");
		panCenter.add(lblCounter, "wrap");
		
		
		panCenter.add(btnEnv, "w 200!");
		panCenter.add(btnDraft, "w 200!");
		panCenter.add(btnReturn, "w 200!");
		
		
		btnEnv.addActionListener(listener);
		btnDraft.addActionListener(listener);
		btnReturn.addActionListener(listener);
		
		//txtMessage.addKeyListener(listener);
		
		
		
		
	}



	public JLabel getLblCounter() {
		return lblCounter;
	}



	public void setLblCounter(JLabel lblCounter) {
		this.lblCounter = lblCounter;
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



	public String getFrom() {
		return from;
	}



	public JComboBox getCboReceiver() {
		return cboReceiver;
	}



	public JTextField getTxtObject() {
		return txtObject;
	}



	public JTextArea getTxtMessage() {
		return txtMessage;
	}



	public JLabel getLblobject() {
		return lblobject;
	}



	public void setLblobject(JLabel lblobject) {
		this.lblobject = lblobject;
	}



	public void setTxtObject(JTextField txtObject) {
		this.txtObject = txtObject;
	}



	public void setUsersList(Users usersList) {
		this.usersList = usersList;
	}





}
