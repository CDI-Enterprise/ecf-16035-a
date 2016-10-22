package fr.cdiEnterprise.application.test;

import java.sql.SQLException;

import fr.cdiEnterprise.view.test.UserFrameTest;

/**
 * Lauch the app with the user panel only in a test frame.
 * @author Claire
 * @version 22-10-2016
 *
 */
public class UserAppTest {

	public static void main(String[] args) throws SQLException {
		
		UserFrameTest mainFrame = new UserFrameTest();
		mainFrame.setVisible(true);
		mainFrame.pack();

	}

}