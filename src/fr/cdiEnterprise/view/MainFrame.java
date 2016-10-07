package fr.cdiEnterprise.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
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
	
	/**
	 * MainFrame constructor.
	 * Constructs a Main Frame of 1440*900 non resizable
	 * With a personalized icon for system menu and main title
	 * With a white background in the main panel
	 * With a main menu @see fr.cdiEnterprise.view.Menu
	 * It opens in the middle of the screen
	 */
	public MainFrame() {
		
		/* Window properties */
		//Icon for MainFrame
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconMainFrame.png")));
	    //Title for MainFrame
		this.setTitle("CDI Enterprise - Recherche de stages et suivi des stagiaires");
		//Is it resizable?
		this.setResizable(false);
		//MMC Close properties
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/* Main content properties */
		panMain.setPreferredSize(new Dimension (1440,900));
		panMain.setLayout(new BorderLayout(20,20));
	
		/* Main menu */
		this.setJMenuBar(new Menu());
		
		this.pack();
		this.setLocationRelativeTo(null);
		
	}
	
}