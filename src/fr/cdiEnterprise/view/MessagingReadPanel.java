/**
 * 
 */
package fr.cdiEnterprise.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import fr.cdiEnterprise.control.MessageListener;
import fr.cdiEnterprise.dao.Datas;
import fr.cdiEnterprise.model.Item;
import fr.cdiEnterprise.model.User;
import fr.cdiEnterprise.service.Users;
import fr.cdiEnterprise.util.ReadProperties;
import javafx.scene.control.ComboBox;
import net.miginfocom.swing.MigLayout;

/**
 * Cette class represente la vue d'un message que l'utlidsqteu consulte.
 * l'utilisateur a la possibilité d'y repondre ou de le supprimer.
 * 
 * @version 15-10-2016
 * @author nicolas Tarral
 *
 */
public class MessagingReadPanel extends JPanel {
	
	private JButton btnRep;
	private JButton btnDel;
	private JButton btnRet;
	
	private String from;
	private JLabel receiver;
	private JLabel object;
	private JLabel Message;
	
	private JLabel lblReceiver;
	private JLabel lblObject;
	private JLabel lblMessage;
	
	private JLabel letterCount;
	private JLabel lblCounter;
	
	private JComboBox cboReceiver;
	private JTextField txtReceiver;
	private JTextField txtObject;
	private JTextArea  txtMessage;
	
	private Users usersList;
	private Item itm;


	
	public MessagingReadPanel(Item item) {
		
		itm = item;
		MessageListener listener = new MessageListener((JPanel) this);
		
		System.out.println(itm.toString());
		
		receiver = new JLabel(itm.getSender());
		object = new JLabel(itm.getObject());
		Message = new JLabel(itm.getBody());
		
		txtMessage = new JTextArea(10, 50);
		/*if(itm != null) {
			
			txtMessage.setText("From :/n" +itm.getSender() +"/n");
			txtMessage.setText("When :/n" +itm.getTimeStamp() +"/n");
			txtMessage.setText("Objet :/n" +itm.getObject() +"/n");
			txtMessage.setText("Message :/n" +itm.getBody() +"/n");
		}*/
		
		
		usersList = Datas.getUsersList();
		from = ReadProperties.getMyAlias();
		
		
		JPanel panMess = new JPanel();
		JPanel panNorth = new JPanel();
		JPanel panCenter = new JPanel();
		panMess.setLayout(new BorderLayout());
		add(panMess);
		panMess.add(panNorth,BorderLayout.NORTH);
		panMess.add(panCenter,BorderLayout.CENTER);
		
		
		JLabel lblTitle = new JLabel("- Votre Message -");
		
		btnRep = new JButton("Repondre");
		btnDel = new JButton("Effacer");
		btnRet = new JButton("Retour");
		
	/*	receiver = new JLabel("Destinataire");
		object = new JLabel("Objet");
		Message = new JLabel("Texte");
		letterCount = new JLabel("compteur");
		lblCounter =   new JLabel();
		
		
		lblReceiver = new JLabel();
		lblObject = new JLabel();*/
		lblMessage = new JLabel();


		//cboReceiver = new JComboBox();
		//cboReceiver.setEditable(true);
		//cboReceiver.setMaximumRowCount(3);
		//txtReceiver = new JTextField();
		//txtObject = new JTextField(20);
		txtMessage = new JTextArea(10,50);
		txtMessage.setText(itm.getBody());
		txtMessage.setLineWrap(true);
		txtMessage.setWrapStyleWord(true);
		
	
		
		/*if(usersList != null) {
			for(User current : usersList) {
				if(current != null) {
					cboReceiver.addItem(current.getAlias());
					System.out.println("les alias des utilisateurs :"+current.getAlias());
				}	
			}
		}else {
			System.out.println("usersList is null ");
		}*/
		
		
		panNorth.add(lblTitle);
		panCenter.setLayout(new MigLayout());
		
		
		panCenter.add(receiver, "wrap");
		//panCenter.add(lblReceiver, "wrap");
		panCenter.add(object, "wrap");
		//panCenter.add(lblObject, "wrap");*/
		
		panCenter.add(txtMessage, "wrap");
		
		
		
		//panCenter.add(lblMessage, "w 200!");
		//panCenter.add(txtMessage, "wrap");

		//panCenter.add(letterCount, "w 200!");
		//panCenter.add(lblCounter, "wrap");
		
		
		panCenter.add(btnRep, "w 200!");
		panCenter.add(btnDel, "w 200!");
		panCenter.add(btnRet, "w 200!");
		
		
		btnRep.addActionListener(listener);
		btnDel.addActionListener(listener);
		btnRet.addActionListener(listener);
		
//		txtMessage.addKeyListener(listener);
		
		
		
		
	}



	public MessagingReadPanel() {
		// TODO Auto-generated constructor stub
	}



	public JLabel getLblCounter() {
		return lblCounter;
	}



	public void setLblCounter(JLabel lblCounter) {
		this.lblCounter = lblCounter;
	}



	public JButton getBtnRep() {
		return btnRep;
	}



	public JButton getBtnDel() {
		return btnDel;
	}



	public JButton getBtnRet() {
		return btnRet;
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



	public Item getItm() {
		return itm;
	}



	public void setItm(Item itm) {
		this.itm = itm;
	}





}
