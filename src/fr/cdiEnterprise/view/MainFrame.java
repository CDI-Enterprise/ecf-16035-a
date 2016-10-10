package fr.cdiEnterprise.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Map.Entry;

/**
 * MainFrame for the CDI Enterprise program with a JMenuBar.
 * Last update: 20161007
 * @version 1.0
 * @author Claire, Anaïs
 *
 */

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static JPanel mainPan;
	private static JPanel homePan;

	private static PanelUser panelUser;

	/**
	 * MainFrame constructor.
	 * Constructs a Main Frame with a default panel of 1440*900 non resizable
	 * With a personalized icon for system menu and main title
	 * With a white background in the main panel
	 * With a main menu @see fr.cdiEnterprise.view.Menu
	 * It opens where the OS windows usually do
	 */
	public MainFrame() {

		// Algorithm from stackoverflow.com, set the font by default
		for (Entry<Object, Object> entry : javax.swing.UIManager.getDefaults().entrySet()) {
			Object key = entry.getKey();
			Object value = javax.swing.UIManager.get(key);
			if (value != null && value instanceof javax.swing.plaf.FontUIResource) {
				javax.swing.plaf.FontUIResource fr=(javax.swing.plaf.FontUIResource)value;
				// (String for font name, integer for style, integer for size)
				javax.swing.plaf.FontUIResource f = new javax.swing.plaf.FontUIResource(fr.getFamily(), Font.PLAIN, 14);
				javax.swing.UIManager.put(key, f);
			}
		}

		// Get the JFrame's default panel
		mainPan = (JPanel) this.getContentPane();

		// Main frame properties
		// Icon for MainFrame
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconMainFrame.png")));
		// Title for MainFrame
		this.setTitle("CDI Enterprise - Recherche de stages et suivi des stagiaires");
		// Is it resizable?
		this.setResizable(false);
		// Set the opening location
		this.setLocationByPlatform(true);
		// MMC Close properties
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Main content properties
		mainPan.setPreferredSize(new Dimension (1440,900));
		mainPan.setLayout(new BorderLayout(20,20));

		// Main menu @see fr.cdiEnterprise.view.Menu
		this.setJMenuBar(new Menu());

		// TODO Home panel for welcoming screen
		homePan = new JPanel();
		homePan.setBackground(Color.DARK_GRAY);
		homePan.setLayout(new FlowLayout());
		mainPan.add(homePan);

		
		// Panel for user CRUD
		panelUser = new PanelUser();
		
		// Panel CreatCompany
//		CompanyCreationPanel panelCreatCompany = new CompanyCreationPanel();
//		mainPan.add(panelCreatCompany);
		
	}

	public static JPanel getMainPan() {
		return mainPan;
	}

	public static JPanel getPanelUser() {
		return panelUser;
	}
	
}