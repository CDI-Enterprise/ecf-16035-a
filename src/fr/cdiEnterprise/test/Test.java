package fr.cdiEnterprise.test;

import fr.cdiEnterprise.dao.Datas;
import fr.cdiEnterprise.view.MainFrame;

public class Test {
	public static void main(String[] args) {
		Datas.init();		
MainFrame fen = new MainFrame();


fen.setVisible(true);
fen.setResizable(true);
fen.setLocationRelativeTo(null);
fen.pack();
		
		
}
}
