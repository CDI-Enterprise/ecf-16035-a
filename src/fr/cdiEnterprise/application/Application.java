package fr.cdiEnterprise.application;

import fr.cdiEnterprise.dao.OldDatas;
import fr.cdiEnterprise.view.MainFrame;

public class Application {

	public static void main(String[] args) {
		
		OldDatas.init();
		
		MainFrame mainFrame = new MainFrame();
		mainFrame.setVisible(true);
		mainFrame.pack();

	}

}
