package fr.cdiEnterprise.db;

import java.sql.SQLException;
import java.time.LocalDateTime;

import fr.cdiEnterprise.dao.Database;
import fr.cdiEnterprise.dao.messageDao;
import fr.cdiEnterprise.model.Item;
import fr.cdiEnterprise.service.Items;

/**
 * test creation base et insert d'une donnee.
 * @author nicolas Tarral
 *
 */
public class TestDB {

	public static void main(String[] args) throws SQLException {

		Database Oracle = new Database();
		Items items = new Items();
		
		Item message2 = new Item("omy", "oracle", "test2", "This is a test.", LocalDateTime.now());
		message2.setDraftEmail(false);
		messageDao.insertItem(message2);

		Item message3 = new Item("claire", "oracle", "test3", "This is a test3.", LocalDateTime.now());
		message3.setDraftEmail(false);
		messageDao.insertItem(message3);
		
		System.out.println("--- TEST DE RECEPTION ---");
		
		items = messageDao.getAllItems("oracle", false);
		
		for(Item current :items) {
			System.out.println("email : "+current);
		}
		
		System.out.println("---- FIN DE TEST ----");
		
	}

}
