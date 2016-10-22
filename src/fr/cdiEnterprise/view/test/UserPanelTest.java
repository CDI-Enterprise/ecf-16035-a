package fr.cdiEnterprise.view.test;

import java.sql.Connection;

import fr.cdiEnterprise.dao.DBConnection;

/**
 * @author Claire
 * @version 22-10-2016
 *
 */
public class UserPanelTest {

	public static void main(String[] args) {
		
		Connection connect = DBConnection.getConnect();
		
		UserFrameTest mainFrame = new UserFrameTest();
		mainFrame.setVisible(true);
		mainFrame.pack();

	}

}