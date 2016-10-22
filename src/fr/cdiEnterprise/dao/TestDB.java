package fr.cdiEnterprise.dao;

import java.sql.SQLException;
import java.time.LocalDateTime;

import fr.cdiEnterprise.control.MpClientV2;
import fr.cdiEnterprise.model.Item;
import fr.cdiEnterprise.service.Items;
import fr.cdiEnterprise.util.ReadProperties;

/**
 * test creation base et insert d'une donnee.
 * @author nicolas Tarral
 *
 */
public class TestDB {

	public static void main(String[] args)  {

		Database Oracle = new Database();
		Items items = new Items();

		MpClientV2 client = new MpClientV2(ReadProperties.getMyAlias());
		
		// used to be tested with messageDAO  Item message2 = new Item("omy", "oracle", "test2", "This is a test.", LocalDateTime.now());
		//message2.setDraftEmail(false);
		//messageDao.insertItem(message2);
		try {
			client.newEmail("omy", "oracle", "test2", "This is a test.");
			client.newEmail("claire", "oracle", "test3", "This is a test3.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


//		Item message3 = new Item("claire", "oracle", "test3", "This is a test3.", LocalDateTime.now());
//		message3.setDraftEmail(false);
//		messageDao.insertItem(message3);
		
		
		
		System.out.println("--- TEST DE RECEPTION ---");

//		items =  client.getMessages(false);
//		for(Item current :items) {
//			System.out.println("email : "+current);
//		}
//		
//		System.out.println("---- FIN DE TEST ----");
		
	}

}
