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


	private static MessagingMainPanel panelMain;
	private static MessagingDraftPanel panelDraft;
	private MessagingNewPanel panelNew;
	private MessagingReadPanel panelRead;
	private MessagingModifPanel panelMod;
	private JPanel panelUser;

	private static final int MESSAGE_MAX_SIZE = 850;

	private String alias;
	
	private int nbCaracters;
	private static Item currentItem;
	
	
	
	private static MpClientV2 client;
	
	
	/**
	 * Constructs a listener taking a panel for attribute
	 * @throws SQLException 
	 */
	public MessageListener(JPanel panelUser)  {
		
		this.alias 		= ReadProperties.getMyAlias();
		this.client 	= new MpClientV2(alias);
		this.panelUser 	= panelUser;
		//MessageListener.panelMain.setCopyUserItems(client.getMessages(false));
		
		//clients = Datas.getClientBox(); // old implementation.
			
				//cli = clients.getClient(ReadProperties.getMyAlias());// commented line to avoid calling old implementation.
		//client = clientsV2.getClient(ReadProperties.getMyAlias());
		

		
		
		if (panelUser instanceof MessagingMainPanel) {

			MessageListener.panelMain = (MessagingMainPanel) panelUser;
			Items itms =client.getMyMessages();
			
				
			MessageListener.panelMain.setCopyUserItems(itms);
					
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

			Users usr 	= aliasInLower();
			panelNew 	= new MessagingNewPanel(usr);
			

			
			
		
			MainFrame.SwithPanel(panelNew);

		}
		else if  (e.getSource() == panelMain.getBtnDraft()) {
			
			// TODO (nicolas) implementer la consultations des messages brouillon
			// nouveau panel.
			panelDraft = new MessagingDraftPanel();
			MessageListener.panelDraft.setCopyUserItems(client.getMessages(true));
			//Previous implementation MessageListener.panelDraft.setCopyUserItems(cli.getMessages(true));
			panelDraft.refresh();
			
			MainFrame.SwithPanel(panelDraft);
			
		}
		else if  (e.getSource() == panelMain.getBtnDisplay()) {

			

		}
		
		
		// PANEL NOUVEAU MESSAGE
		else if ((panelNew != null) && (e.getSource() == panelNew.getBtnEnv())) {

			
			String receiver = (String) panelNew.getCboReceiver()
					.getItemAt(panelNew.getCboReceiver().getSelectedIndex());

			if (panelNew.getTxtObject().getText().isEmpty()) {
				customDialog("le champ Objet doit etre remplie.");
			} else {

				
				
				client.newEmail(alias,receiver, panelNew.getTxtObject().getText(),
						panelNew.getTxtMessage().getText());
				
				
				
				
				// TODO (Nicolas) : need to handle well this exception, maybe in the class client ?

					try {
						MessageListener.panelMain.setCopyUserItems(client.getMessages(false));
						
						
					} catch (Exception e1) {
						// TODO (Nicolas) Auto-generated catch block
						e1.printStackTrace();
					}

				
				// MessageListener.panelMain.setCopyUserItems(cli.getMessages(false)); // old implementation.
				panelMain.refresh();
				
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

				
				
				
				client.draft(alias,receiver, panelNew.getTxtObject().getText(),
						panelNew.getTxtMessage().getText(), DraftMessage);


				
					panelDraft = new MessagingDraftPanel();
					//MessageListener.panelDraft.setCopyUserItems(cli.getMessages(true));
					MessageListener.panelDraft.setCopyUserItems(client.getMessages(true));
					panelDraft.refresh();
					MainFrame.SwithPanel(panelDraft);
			}
			// TODO (nicolas) implementer l'envoie du message vers le repertoire brouillon
			// et revenir vers les messages brouillons
			
		}

		//RETURN FROM THE NEW MESSAGE PANEL
		else if ((panelNew != null) && ( e.getSource() == panelNew.getBtnReturn())) {

		
			//MessageListener.panelMain.setCopyUserItems(cli.getMessages(false));
			MessageListener.panelMain.setCopyUserItems(client.getMessages(false));
		
			MainFrame.SwithPanel(panelMain);
			
		// PANEL LECTURE D'UN MESSAGE - CAS POSSIBLES DE LA Fenetre de lecture.
		}else if ((panelRead	 != null ) && (e.getSource() == panelRead.getBtnRep())) {
		
			//cli.display(false);
			currentItem = panelRead.getItm();
			currentItem.setObject(panelRead.getTxtObject().getText());
			currentItem.setBody(panelRead.getTxtMessage().getText());
			
			client.sendEmail(currentItem, false);
			MessageListener.panelMain.setCopyUserItems(client.getMessages(false));
			//client.display(false);
		
			
			
			panelMain.refresh();
			//cli.display(false);
			MainFrame.SwithPanel(panelMain);
		}else if ((panelRead	 != null ) && (e.getSource() == panelRead.getBtnRet())) {
			MessageListener.panelMain.setCopyUserItems(client.getMessages(false));
			
			MainFrame.SwithPanel(panelMain);
		} else if ((panelRead	 != null ) && (e.getSource() == panelRead.getBtnDel())) {
			client.removeMessage(currentItem.getId(), false);
			
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
						
						
						
						Item draftToSend = new Item(alias,receiver, panelMod.getTxtObject().getText(),
								panelMod.getTxtMessage().getText(), null);
						

						
						
						// TODO (Nicolas) : need to handle well this exception, maybe in the class client ?

							try {
								MessageListener.panelDraft.setCopyUserItems(client.getMessages(true));
								
								
							} catch (Exception e1) {
								// TODO (nicolas) need to fix this excep
								e1.printStackTrace();
							}

						
						// MessageListener.panelMain.setCopyUserItems(cli.getMessages(false)); // old implementation.
						panelMain.refresh();
						MainFrame.SwithPanel(panelDraft);
					}

				}
				
				else if ((panelMod != null) && (e.getSource() == panelMod.getBtnDel())) {
							
					client.removeMessage(currentItem.getId(), true);

					panelDraft.setCopyUserItems(client.getMessages(true));
					panelDraft.refresh();
					MainFrame.SwithPanel(panelDraft);
					
					}
				else if ((panelMod != null) && (e.getSource() == panelMod.getBtnRet())) {
					
					
					MainFrame.SwithPanel(panelDraft);		
					
				}
				else if ((panelMod != null) && (e.getSource() == panelMod.getBtnSav())) {
					System.out.println("appuis sur sauvegarder");
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
			//System.out.println("lettre tapée : " + e.getKeyChar());
			
		}else {
			//System.out.println("lettre tapée : " + e.getKeyChar());
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
	 * Cette Method va trouvé l'objet Item selectionné dans la table et
	 * mettre l'Item dans la proriété de l'objet de la class Messagelistener.
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
			
			//spemod =  panelUser.getTiModel();
			//spemod = panelMain.getTiModel();
			//System.out.println("double click..." + row );
			//System.out.println(spemod.getRowCount() -1);
					SpecialTableItemModel<?> spemod =null;
					SpecialTableItemModel<?> spemodDraft =null;
					if (panelUser instanceof MessagingMainPanel) {
						spemod = panelMain.getTiModel();
						spemod = panelMain.getTiModel();
						if (row > spemod.getRowCount() -1) {
							
						} else {
							currentItem = spemod.getUserAt(row);
							if(currentItem != null) {
								Item itmCopy = new Item(currentItem);
								panelRead = new MessagingReadPanel(itmCopy);
								MainFrame.SwithPanel(panelRead);
							}	
						}
					}
						else if (panelUser instanceof MessagingDraftPanel) {
						spemodDraft = panelDraft.getTiModel();
						spemodDraft = panelDraft.getTiModel();
						if (row > spemodDraft.getRowCount() -1) {
							System.out.println("hors de la partie");
						} else {
							currentItem = spemodDraft.getUserAt(row);
							if(currentItem != null) {
								Item itmCopy = new Item(currentItem);
								// TODO (nicolas) devrait venir de la classe en static ?
								panelMod = new MessagingModifPanel(itmCopy, aliasInLower());
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
