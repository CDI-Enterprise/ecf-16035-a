package fr.cdiEnterprise.model;

import fr.cdiEnterprise.view.FenetreEntreprise;

public class Test {

	// import javax.swing.UIManager;
	// import javax.swing.UnsupportedLookAndFeelException;

	// import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
	// import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

	public static void main(String[] args) {

		FenetreEntreprise fenetre = new FenetreEntreprise();

		fenetre.pack(); 										// Demande � la fen�tre de se recalculer pour tout repositionner
		fenetre.setLocationRelativeTo(null);					// La fen�tre se placera au centre de l'�cran
		fenetre.setVisible(true);

		// try {
		// UIManager.setLookAndFeel(new MotifLookAndFeel());
		// } catch (UnsupportedLookAndFeelException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

}
