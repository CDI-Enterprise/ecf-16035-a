package fr.cdiEnterprise.test;

import fr.cdiEnterprise.controler.MpClient;
import fr.cdiEnterprise.dao.Datas;
import fr.cdiEnterprise.dao.Server;
import fr.cdiEnterprise.view.MainFrame;

/**
 * @author Claire
 *
 */
public class TestMainFrameMenu {

	/**
	 * @param args
	 */
public static void main(String[] args) {
		
//		Window mainWindow = new Window();
//		mainWindow.setVisible(true);
		MainFrame mainFrame = new MainFrame();
		
		mainFrame.setVisible(true);
		mainFrame.setResizable(true);
		mainFrame.pack();

	}

}