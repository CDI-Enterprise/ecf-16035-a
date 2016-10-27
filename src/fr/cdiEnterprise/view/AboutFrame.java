/**
 * 
 */
package fr.cdiEnterprise.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Claire
 *
 */
public class AboutFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panMain;

	public AboutFrame() {

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
		panMain = (JPanel) this.getContentPane();

		// Main frame properties
		// Icon for MainFrame
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconMainFrame.png")));
		// Title for MainFrame
		this.setTitle("A propos de CDI Enterprise");
		// Is it resizable?
		this.setResizable(false);
		// Set the opening location
		this.setLocationRelativeTo(null);
		// MMC Close properties
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Main content properties
		panMain.setPreferredSize(new Dimension (400,300));
		panMain.setLayout(new FlowLayout());

		

	}

}
