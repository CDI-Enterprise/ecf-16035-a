package fr.cdiEnterprise.db;

import java.sql.SQLException;
import java.time.LocalDateTime;

import fr.cdiEnterprise.dao.Database;
import fr.cdiEnterprise.dao.messageDao;
import fr.cdiEnterprise.model.Item;

public class TestDB {

	public static void main(String[] args) throws SQLException {

		Database Oracle = new Database();
		Item message = new Item("oracle", "oracle", "test DB", "This is a test - do not reply", LocalDateTime.now());
		message.setDraftEmail(false);
		messageDao.insertItem(message);

	}

}
