package fr.cdiEnterprise.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * MainFrame for the CDI Enterprise program with a JMenuBar.
 * Last update: 20161001
 * @version 1.0
 * @author Claire
 *
 */

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Get the contentPanel by default
	JPanel panMain = (JPanel)this.getContentPane();
	
	//Default constructor
	public MainFrame() {
		
		/* Window properties */
		//Icon for MainFrame
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconMainFrame.png")));
	    //Title for MainFrame
		this.setTitle("CDI Enterprise - Recherche de stages et suivi des stagiaires");
		//Is it resizable?
		this.setResizable(false);
		//Pop where the OS window usually does
		this.setLocationByPlatform(true);
		//MMC Close properties
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/* Main content properties */
		panMain.setPreferredSize(new Dimension (1024,600));
		panMain.setBackground(Color.WHITE);
		panMain.setLayout(new BorderLayout(20,20));
	
		/* Main menu */
		this.setJMenuBar(new Menu());
		
		this.pack();
		this.setLocationRelativeTo(null);
		
	}
	
}