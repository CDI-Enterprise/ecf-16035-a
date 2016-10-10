package fr.cdiEnterprise.application;

import fr.cdiEnterprise.dao.Datas;
import fr.cdiEnterprise.view.MainFrame;

public class Application {

	public static void main(String[] args) {
		
		Datas.init();
		
		MainFrame mainFrame = new MainFrame();
		mainFrame.setVisible(true);
		mainFrame.pack();

	}

}
