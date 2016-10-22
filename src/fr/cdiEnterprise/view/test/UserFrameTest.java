/**
 * 
 */
package fr.cdiEnterprise.view.test;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.cdiEnterprise.view.UserPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Map.Entry;

/**
 * MainFrame for the CDI Enterprise program with a JMenuBar.
 * @author Claire
 * @version 07-10-2016
 */

public class UserFrameTest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static JPanel mainPan;

	private static UserPanel panelUser;
	private static JScrollPane scrollUser;
	
	/**
	 * MainFrame constructor.
	 * Constructs a Main Frame with a default panel of 1280*800 resizable
	 * With a personalized icon for system menu and main title
	 * With a main menu @see fr.cdiEnterprise.view.Menu
	 * It opens where the OS windows usually do
	 * @throws SQLException 
	 */
	public UserFrameTest()  {

		// Algorithm from stackoverflow.com, set the font by default
		for (Entry<Object, Object> entry : javax.swing.UIManager.getDefaults().entrySet()) {
			Object key = entry.getKey();
			Object value = javax.swing.UIManager.get(key);
			if (value != null && value instanceof javax.swing.plaf.FontUIResource) {
//				javax.swing.plaf.FontUIResource fr=(javax.swing.plaf.FontUIResource)value;
				// (String for font name, integer for style, integer for size)
				javax.swing.plaf.FontUIResource f = new javax.swing.plaf.FontUIResource("Arial", Font.PLAIN, 14);
				javax.swing.UIManager.put(key, f);
			}
		}

		// Get the JFrame's default panel
		mainPan = (JPanel) this.getContentPane();

		// Main frame properties
		// Title for MainFrame
		this.setTitle("CDI Enterprise - Recherche de stages et suivi des stagiaires");
		// Is it resizable?
		this.setResizable(true);
		// Set the opening location
		this.setLocationByPlatform(true);
		// MMC Close properties
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Main content properties
		mainPan.setPreferredSize(new Dimension (1280,800));
		mainPan.setLayout(new BorderLayout());
		
		// Panel for user CRUD
		panelUser = new UserPanel();
		panelUser.setPreferredSize(new Dimension (1260,800));
		scrollUser = new JScrollPane(panelUser);
		mainPan.add(scrollUser);

		
	}
}