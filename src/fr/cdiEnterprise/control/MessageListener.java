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
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import fr.cdiEnterprise.dao.OldDatas;
import fr.cdiEnterprise.model.Item;
import fr.cdiEnterprise.model.User;
import fr.cdiEnterprise.service.Items;
import fr.cdiEnterprise.service.Users;
import fr.cdiEnterprise.util.MpClientV2;
import fr.cdiEnterprise.util.ReadProperties;
import fr.cdiEnterprise.view.MainFrame;
import fr.cdiEnterprise.view.MessagingDraftPanel;
import fr.cdiEnterprise.view.MessagingMainPanel;
import fr.cdiEnterprise.view.MessagingModifPanel;
import fr.cdiEnterprise.view.MessagingNewPanel;

import fr.cdiEnterprise.view.MessagingReadPanel;
import fr.cdiEnterprise.view.SpecialTableItemModel;

/**
 * Class for the actionListner dedicated to the Messaging part. This class is
 * able to identify if the user ask to create a new messa, znd return back to
 * the message list.
 * 
 * 
 * @version 13-10-2016
 * @author Nicolas Tarral
 *
 */
public class MessageListener implements ActionListener, KeyListener, MouseListener {

	// Given attribute
	private static MessagingMainPanel panelMain;
	private static MessagingDraftPanel panelDraft;
	private MessagingNewPanel panelNew;
	private MessagingReadPanel panelRead;
	private MessagingModifPanel panelMod;
	private JPanel panelUser;
//	private JPanel panel;
	private static final int MESSAGE_MAX_SIZE = 850;
	// Attribute to create-update a user
//	private User user;
	private String alias;
	
	private int nbCaracters;
	private static Item currentItem;
	
	
	//Previous implementation private static MpClient cli;
	private static MpClientV2 client;
	//private Clients clients;
	//private ClientsV2 clientsV2;
	
	/**
	 * Constructs a listener taking a panel for attribute
	 * @throws SQLException 
	 */
	public MessageListener(JPanel panelUser)  {
		
		this.alias = ReadProperties.getMyAlias();
		this.client = new MpClientV2(alias);
		this.panelUser = panelUser;
		//MessageListener.panelMain.setCopyUserItems(client.getMessages(false));
		
		//clients = Datas.getClientBox(); // old implementation.
			
				//cli = clients.getClient(ReadProperties.getMyAlias());// commented line to avoid calling old implementation.
		//client = clientsV2.getClient(ReadProperties.getMyAlias());
		

		
		
		if (panelUser instanceof MessagingMainPanel) {

			MessageListener.panelMain = (MessagingMainPanel) panelUser;
			Items itms =client.getMyMessages();
			
				
			MessageListener.panelMain.setCopyUserItems(itms);
			System.out.println("Il ya " + MessageListener.panelMain.getCopyUserItems().size());
			
			MessageListener.panelMain.refresh();
			//MessageListener.panelMain.setCopyUserItems(cli.getMessages(false));//old implementation
			//MessageListener.panelMain.setCopyUserItems(client.getMessages(false));


			
		}
		if (panelUser instanceof MessagingDraftPanel) {
			panelDraft = (MessagingDraftPanel) panelUser;
		}		
		if (panelUser instanceof MessagingNewPanel) {
			panelNew = (MessagingNewPanel) panelUser;
		}
		if (panelUser instanceof MessagingReadPanel) {
			panelRead = (MessagingReadPanel) panelUser;
		}
		if (panelUser instanceof MessagingModifPanel) {
			panelMod = (MessagingModifPanel) panelUser;
		}
	}

	// ACTION LISTENER
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == panelMain.getBtnNew()) {

			Users usr = aliasInLower();
			panelNew = new MessagingNewPanel(usr);
			

			
			
			System.out.println("switch to panel : new message");
			MainFrame.SwithPanel(panelNew);

		}
		else if  (e.getSource() == panelMain.getBtnDraft()) {
			
			// TODO (nicolas) implementer la consultations des messages brouillon
			// nouveau panel.
			panelDraft = new MessagingDraftPanel();
			MessageListener.panelDraft.setCopyUserItems(client.getMessages(true));
			//Previous implementation MessageListener.panelDraft.setCopyUserItems(cli.getMessages(true));
			panelDraft.refresh();
			System.out.println("switch to panel : brouillon message");
			MainFrame.SwithPanel(panelDraft);
			
		}
		else if  (e.getSource() == panelMain.getBtnDisplay()) {

			System.out.println("switch to panel : new message");

		}
		
		
		// PANEL NOUVEAU MESSAGE
		else if ((panelNew != null) && (e.getSource() == panelNew.getBtnEnv())) {

			
			String receiver = (String) panelNew.getCboReceiver()
					.getItemAt(panelNew.getCboReceiver().getSelectedIndex());

			if (panelNew.getTxtObject().getText().isEmpty()) {
				customDialog("le champ Objet doit etre remplie.");
			} else {

				System.out.println("Envoie d'un message depuis cette utilisateur"+alias);
				System.out.println(panelNew.getTxtObject().getText()+" - "+
						panelNew.getTxtMessage().getText());
				
				client.newEmail(alias,receiver, panelNew.getTxtObject().getText(),
						panelNew.getTxtMessage().getText());
				
				System.out.println("Message send out...");
				
				
				// TODO (Nicolas) : need to handle well this exception, maybe in the class client ?

					try {
						MessageListener.panelMain.setCopyUserItems(client.getMessages(false));
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				
				// MessageListener.panelMain.setCopyUserItems(cli.getMessages(false)); // old implementation.
				panelMain.refresh();
				System.out.println("switch to panel : main message");
				MainFrame.SwithPanel(panelMain);
			}

		}
		
		else if ((panelNew != null) && (e.getSource() == panelNew.getBtnDraft())) {
					
			boolean DraftMessage = true;
			String receiver = (String) panelNew.getCboReceiver()
					.getItemAt(panelNew.getCboReceiver().getSelectedIndex());

			if (panelNew.getTxtObject().getText().isEmpty()) {
				customDialog("le champ Objet doit etre remplie.");
			} else {

				System.out.println("Envoie d'un message depuis cette utilisateur"+alias);
				System.out.println(panelNew.getTxtObject().getText()+" - "+
						panelNew.getTxtMessage().getText());
				
				
				
				client.draft(alias,receiver, panelNew.getTxtObject().getText(),
						panelNew.getTxtMessage().getText(), DraftMessage);


					System.out.println("Message in Draft.");
					panelDraft = new MessagingDraftPanel();
					//MessageListener.panelDraft.setCopyUserItems(cli.getMessages(true));
					MessageListener.panelDraft.setCopyUserItems(client.getMessages(true));
					panelDraft.refresh();
					System.out.println("switch to panel : main message");
					MainFrame.SwithPanel(panelDraft);
			}
			// TODO (nicolas) implementer l'envoie du message vers le repertoire brouillon
			// et revenir vers les messages brouillons
			
		}

		//RETURN FROM THE NEW MESSAGE PANEL
		else if ((panelNew != null) && ( e.getSource() == panelNew.getBtnReturn())) {

		
			//MessageListener.panelMain.setCopyUserItems(cli.getMessages(false));
			MessageListener.panelMain.setCopyUserItems(client.getMessages(false));
			System.out.println("taille mess "+client.getMessages(false).size());
			System.out.println("switch to panel : main message");

			MainFrame.SwithPanel(panelMain);
			
		// PANEL LECTURE D'UN MESSAGE - CAS POSSIBLES DE LA Fenetre de lecture.
		}else if ((panelRead	 != null ) && (e.getSource() == panelRead.getBtnRep())) {
			System.out.print("appuie sur reply...");
			//cli.display(false);
			currentItem = panelRead.getItm();
			currentItem.setObject(panelRead.getTxtObject().getText());
			currentItem.setBody(panelRead.getTxtMessage().getText());
			
			client.sendEmail(currentItem, false);
			MessageListener.panelMain.setCopyUserItems(client.getMessages(false));
			//client.display(false);
			System.out.println(currentItem.toString());
			
			System.out.println("switch to panel : main message");
			panelMain.refresh();
			//cli.display(false);
			MainFrame.SwithPanel(panelMain);
		}else if ((panelRead	 != null ) && (e.getSource() == panelRead.getBtnRet())) {
			MessageListener.panelMain.setCopyUserItems(client.getMessages(false));
			System.out.println("switch to panel : main message");
			MainFrame.SwithPanel(panelMain);
		} else if ((panelRead	 != null ) && (e.getSource() == panelRead.getBtnDel())) {
			client.removeMessage(currentItem.getId(), false);
			System.out.println("switch to panel : main message");
			//cli.numberOfMessages(false);
			MessageListener.panelMain.setCopyUserItems(client.getMessages(false));
			panelMain.refresh();
			MainFrame.SwithPanel(panelMain);
		
		// LISTE DES BROUILLONS
		} else if ((panelDraft != null) && (e.getSource() == panelDraft.getBtnDisplay())) {
			
			
		}

		
		else if ((panelDraft != null) && ( e.getSource() == panelDraft.getBtnMess())) {

			// panelNew = new MessagingNewPanel();
			//MessageListener.panelMain.setCopyUserItems(cli.getMessages(false)); // Previous imlplementatioons
			MessageListener.panelMain.setCopyUserItems(client.getMessages(false));
			System.out.println("switch to panel : main message");

			MainFrame.SwithPanel(panelMain);
		
		}
		
		// PANEL MODIFIER BROUILLON
				else if ((panelMod != null) && (e.getSource() == panelMod.getBtnEnv())) {

					
					// TODO (nicolas) Penser a refactoriser cette partie en creant une methode pour creation objet Item
					String receiver = (String) panelMod.getCboReceiver()
							.getItemAt(panelMod.getCboReceiver().getSelectedIndex());

					if (panelMod.getTxtObject().getText().isEmpty()) {
						customDialog("le champ Objet doit etre remplie.");
					} else {
						System.out.println("Envoie d'un message depuis cette utilisateur"+alias);
						System.out.println(panelMod.getTxtObject().getText()+" - "+
								panelMod.getTxtMessage().getText());
						Item draftToSend = new Item(alias,receiver, panelMod.getTxtObject().getText(),
								panelMod.getTxtMessage().getText(), null);
						client.sendEmail(draftToSend, true);
						System.out.println("Message send out...");
						
						
						// TODO (Nicolas) : need to handle well this exception, maybe in the class client ?

							try {
								MessageListener.panelDraft.setCopyUserItems(client.getMessages(true));
								
								
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						
						// MessageListener.panelMain.setCopyUserItems(cli.getMessages(false)); // old implementation.
						panelMain.refresh();
						System.out.println("switch to panel : Draft message");
						MainFrame.SwithPanel(panelDraft);
					}

				}
				
				else if ((panelMod != null) && (e.getSource() == panelMod.getBtnDel())) {
							
					// TODO (nicolas) implementer suppression de brouillon
					}
				else if ((panelMod != null) && (e.getSource() == panelMod.getBtnRet())) {
					// TODO (nicolas) implementer retour vers les messages brouillon		
					
				}
				else if ((panelMod != null) && (e.getSource() == panelMod.getBtnRet())) {
					// TODO (nicolas) implementer sauvegarde du brouillon.		
					
				}
				
				else {
			System.out.println("nothing correspond to that event...");
		}

	}

	/**
	 * @return
	 */
	private Users aliasInLower() {
		Users usr = OldDatas.getUsersList();
		for(User current : usr) {
			String toLowerCase = current.getAlias().toLowerCase();
			current.setAlias(toLowerCase);
			
		}
		return usr;
	}

	@Override
	public void keyTyped(KeyEvent e) {

		int nb = 0;
		if(e.getKeyChar() == '\b' || KeyEvent.VK_DELETE == e.getKeyChar()) {
			System.out.println("lettre tap�e : " + e.getKeyChar());
			
		}else {
			System.out.println("lettre tap�e : " + e.getKeyChar());
			nb++;
			nbCaracters += nb;
		}


		panelNew.getLblCounter().setText((MESSAGE_MAX_SIZE - nbCaracters) + "");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		

	}

	@Override
	public void keyReleased(KeyEvent e) {
		

	}

	/**
	 * Cette Method va trouv� l'objet Item selectionn� dans la table et
	 * mettre l'Item dans la prori�t� de l'objet de la class Messagelistener.
	 * il sera ensuite plus facile a manipuler.
	 */
	public void mousePressed(MouseEvent me) {


		JTable table = (JTable) me.getSource();
		Point p = me.getPoint();
		int row = table.rowAtPoint(p);
		
		//System.out.println("click..." + row );
		//System.out.println(spemod.getRowCount() -1);
	/*	if (me.getClickCount() == 1) {
			if (row > spemod.getRowCount() -1) {
				System.out.println("hors de la partie");
			} else {
				Item itm = spemod.getUserAt(row);
				panelRead = new MessagingReadPanel();

				System.out.println("switch to panel : read message");
				MainFrame.SwithPanel(panelRead);
			}*/

		if (me.getClickCount() == 2) {
			System.out.println("double clicked ");
			//spemod =  panelUser.getTiModel();
			//spemod = panelMain.getTiModel();
			//System.out.println("double click..." + row );
			//System.out.println(spemod.getRowCount() -1);
					SpecialTableItemModel<?> spemod =null;
					SpecialTableItemModel<?> spemodDraft =null;
					if (panelUser instanceof MessagingMainPanel) {
						spemod = panelMain.getTiModel();
						System.out.println("double click comin from Main Panel");
						spemod = panelMain.getTiModel();
						if (row > spemod.getRowCount() -1) {
							System.out.println("hors de la partie");
						} else {
							currentItem = spemod.getUserAt(row);
							if(currentItem != null) {
								Item itmCopy = new Item(currentItem);
								panelRead = new MessagingReadPanel(itmCopy);
								System.out.println(itmCopy.toString());
								MainFrame.SwithPanel(panelRead);
							}	
						}
					}
						else if (panelUser instanceof MessagingDraftPanel) {
						spemodDraft = panelDraft.getTiModel();
						System.out.println("double click comin from Draft Panel");
						spemodDraft = panelDraft.getTiModel();
						if (row > spemodDraft.getRowCount() -1) {
							System.out.println("hors de la partie");
						} else {
							currentItem = spemodDraft.getUserAt(row);
							if(currentItem != null) {
								Item itmCopy = new Item(currentItem);
								// TODO (nicolas) devrait venir de la classe en static ?
								panelMod = new MessagingModifPanel(itmCopy, aliasInLower());
								System.out.println(itmCopy.toString());
								MainFrame.SwithPanel(panelMod);
							}
								
					}
					
					

						

				}

			}
		}
		

	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		

	}

	@Override
	public void mouseExited(MouseEvent e) {
		

	}

	public void customDialog(String message) {
		JOptionPane.showMessageDialog(panelNew, message, "Nouveau message", JOptionPane.WARNING_MESSAGE);
	}

	public Item getItem() {
		return currentItem;
	}

	public void setItem(Item item) {
		MessageListener.currentItem = item;
	}

}
