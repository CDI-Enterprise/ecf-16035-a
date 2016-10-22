package fr.cdiEnterprise.util;



import java.sql.SQLException;
import java.time.LocalDateTime;




import fr.cdiEnterprise.dao.messageDao;
import fr.cdiEnterprise.model.Item;
import fr.cdiEnterprise.service.Items;






/**
 * This class is going to give you the control over sending, receiving , editing and removing messages.
 * only the draft message can be edited.
 * 
 * to put message in the draft folder, use the following method draft(String from, String to, String obj, String bdy).
 * at that point we put the draft variable to true in the message.
 * to edit and send a message you will have to follow those steps :
 * Pop the message from the server(draft folder of your user), by calling popMessage method then, use the sendEmail method.
 * As soon as the message is send out to the final user, the timestamp is setup, the draft boolean will be put on false.
 * 
 * @author Nicolas Tarral
 * @version 20-10-2016
 *
 */
public class MpClientV2 {
	
	
	
	public Items getMyMessages() {
		return myMessages;
	}

	private static int ID_NUMBER = 0;
	  

	//private Server messageDao;
	private String box;
	private Items myMessages;
	//private Items myDraft;
	
	public MpClientV2(String usr) {
		box = usr;
		//this.messageDao = server;
		this.myMessages = new Items();
		getMaxItems();
		
		
	//	this.myDraft = new  Items();
		
		
		

	}

	/**
	 * 
	 */
	private Items getMaxItems() {
		Items items = null;
		if(ID_NUMBER == 0)
		{
			int max = 0;
			items = getMessages(false);
			for(Item current : items){
				if(current.getId() > max) {
					max = current.getId();
					ID_NUMBER = max;
				}
			}
		}
		
		System.out.println("l'email le plus rescent est numero "+ ID_NUMBER);
		return items;
	}
	
	/**
	 * This method is going to send new email to other users.
	 * 
	 * @param from this is to indicate the user who send the email
	 * @param to this is to indicate the user who receive the email
	 * @param obj this is to provide the email's object
	 * @param bdy the body of the message.
	 * @return this will return true if the message was correctly sent out
	 * @throws SQLException 
	 */
	public void newEmail(String from, String to, String obj, String bdy )   {
		
		int idNumber = 0;
		
		ID_NUMBER = ID_NUMBER + 1;
		LocalDateTime timeStamp = LocalDateTime.now();
		idNumber = ID_NUMBER;
		Item itm = new Item(from, to, obj, bdy, timeStamp);
		System.out.println("Taille du Message : "+bdy.length());
		itm.setId(idNumber);

		messageDao.insertItem(itm);
		System.out.println("Message devrait etre insere");
			
		
	}
	
	/**
	 * This method will be used to reply to an email , draft have to be false, or send a draft email and draft have to be true.
	 * @param item
	 * @param draft
	 * @return
	 */
	public boolean sendEmail(Item item, boolean draft) {

		LocalDateTime timeStamp = LocalDateTime.now();
	
		Item repliedItem = new Item(item.getSender(), item.getReceiver(), item.getObject(), item.getBody(),  timeStamp);
		
		//repliedItem.setId(item.getId()); // old implementation
		ID_NUMBER = ID_NUMBER + 1;
		repliedItem.setId(ID_NUMBER);
		if(draft) {
			
			repliedItem.setDraftEmail(false);
			System.out.println(repliedItem.toString());
			messageDao.insertItem(repliedItem);
			
			return true;
		}else {
			if(item.getObject() != null && item.getBody() != null) {
				repliedItem.setObject("re: "+ item.getObject());
				repliedItem.setTimeStamp(timeStamp);
				String snd = item.getSender();
				String rcv = item.getReceiver();
				repliedItem.setReceiver(snd);
				repliedItem.setSender(rcv);
				
				
				messageDao.insertItem(repliedItem);
				return true;
			}else {
				return false;
			}

		}

	}
	
	
	
//	/**
//	 * This method is going to put the edited draft email back to the draft folder
//	 * @param item
//	 * @return return true if properly drafted.
//	 */
//	public boolean editDraft(Item toEdit, String to, String obj, String bdy) {	
//		
//		
//		String idNumber = null;
//		
//		
//		ID_NUMBER = ID_NUMBER + 1;
//		LocalDateTime timeStamp = LocalDateTime.now();
//		idNumber = ID_NUMBER + "";
//		Item itm = new Item(toEdit.getSender(), to, obj, bdy, null);
//		//System.out.println(idNumber);
//		itm.setId(toEdit.getId());
//		itm.setDraftEmail(true);
//		if(server.postDraft(itm)) {  
//			
//			return true;
//		}
//		return false;
//	}
//	
	
	
	
//	/**
//	 * This method is going to put the new created  email into the draft folder
//	 * @param item
//	 * @return return true if properly drafted.
//	 */
	public void draft(String from, String to, String obj, String bdy, boolean draft) {
//		
		int idNumber = 0;
		ID_NUMBER = ID_NUMBER + 1;		
		idNumber = ID_NUMBER;
		Item itm = new Item(idNumber, from, to, obj, bdy, null, draft);
		System.out.println("Taille du Message : "+bdy.length());

		messageDao.insertItem(itm);
		System.out.println("Message devrait etre insere");
	}

	
	/**
	 * THis method is going to get messages , mail or draft email
	 * will depends on the boolean status
	 * @param draft true will indicate to return the draft email
	 * @return an arrayList of items
	 * @throws SQLException 
	 */
	public Items getMessages(boolean draft)  {

		
		myMessages = messageDao.getAllItems(this.box, draft);
		//System.out.println("numbers of email : " +myMessages.size());
		
		
		return myMessages;
	}
	
	/**
	 * this is going to remove a message or a draft message, and with a particular id.
	 * @param identifier to get the requested email removed
	 * @param draft will indicate if this is a draft email
	 */
	public void removeMessage(int identifier, boolean draft) {
		
		if(messageDao.removeMessage(this.box, identifier, draft)) {
			System.out.println("Message has been removed...");
		}
	}
	
//	/**
//	 * going to pop one message with particular Id, and draft or not
//	 * @param identifier 
//	 * @param draft
//	 * @return an item representing the message.
//	 */
//	public Item popMessage(String identifier, boolean draft) {
//		Item message = server.popMessage(this.box, identifier, draft);
//		if(message != null) {
//			//System.out.println("Message has been popped..." + message.toString());
//		}
//		return message;
//	}
//	
//	
//	public int numberOfMessages(boolean draft) {
//		myMessages = server.getAllItems(this.box, draft);
//		return myMessages.size();
//	}
//	
//	/**
//	 * will display the mailbox or the draft box.
//	 * @param draft
//	 */
//	public void display(boolean draft) {
//		
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
//		if(draft) {
//			System.out.printf("---*** Boite Brouillon de %s ***---\n",this.box);
//		}else {
//			System.out.printf("---*** Boite de %s ***---\n",this.box);
//		}
//		
//		System.out.printf("--- %s message(s) dans votre boite ---\n",myMessages.size());
//		System.out.printf("--- Liste des messages ---\n",box);
//		for(Item current : myMessages) {
//			System.out.println("message From : "+current.getSender());
//			System.out.println("message To : "+current.getReceiver());
//			if(current.getTimeStamp() != null) {
//				System.out.println("message sent At : "+current.getTimeStamp().format(formatter));
//			} else {
//				System.out.println("Message does not have a timestamp not send out...");
//			}
//			
//			System.out.println("Subject : "+current.getObject());
//			System.out.println("Message : "+current.getBody());
//			System.out.println("Message ID: "+current.getId());
//		}
//	}
//
	public  String getBox() {
		return box;
	}
//	
//	
}
