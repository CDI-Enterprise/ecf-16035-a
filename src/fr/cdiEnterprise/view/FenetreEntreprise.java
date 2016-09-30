package fr.cdiEnterprise.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FenetreEntreprise extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FenetreEntreprise(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Entreprise");

		//On veut r�cup�rer la r�f�rence du panneau d�j� instanci�
		Container content = this.getContentPane();
		//Pour donner une taille pr�f�r�e --> setPrefereSize attend un objet en param�tre
		content.setPreferredSize(new Dimension (650,650));
		//On positione l'arri�re plan qui attend une couleur (objet couleur (txRouge, txVert,txBleu) ==> Disponible sur internet 
		//content.setBackground(new Color(120,220,240));
		//Ou on peut utiliser une constante
		content.setBackground(Color.CYAN);

		//Cr�ation d'une barre de menus
		JMenuBar mbTop=new JMenuBar();
		this.setJMenuBar(mbTop);
		
		//Cr�ation des menus de la barre de menu
		JMenu mnuGestion=new JMenu("Gestion");
		mnuGestion.setMnemonic('G');
		mbTop.add(mnuGestion);
		JMenu mnuEdition=new JMenu("Edition");
		mnuGestion.setMnemonic('E');
		mbTop.add(mnuEdition);
		
		//Cr�ation des �l�ments des menus
		JMenuItem mnuCreer=new JMenuItem("Creer",'C');
		JMenuItem mnuModifier = new JMenuItem("Modifier",'M');
		mnuGestion.add (mnuCreer);
		mnuGestion.addSeparator();
		mnuGestion.add (mnuModifier);
		
		
		//Cr�ation zone de texte
		JTextField txtNom = new JTextField();
		content.setLayout(new FlowLayout());
		txtNom.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		//String valeur = txtNom.getText();
		content.add(txtNom);
		txtNom.setVisible(true);
		txtNom.setText("Entrer le nom de l'entreprise");
		txtNom.setColumns(15); 							// Fixe la longueur de la zone de saisie 
		txtNom.setEditable(true); 						// Emp�che l'�criture dans la zone
		txtNom.setEnabled(true);

		content.setLayout(new BorderLayout(5,5));					//(5,5) = (hgap,vgap) = d�fini l'espace horizontal et vertical entre composants
		// BorderLayout est instanci� � la vol�e, on en a besoin seulement l�, pas besoin de stocker sa r�f�rence dans une �tiquette
		content.add(new JButton("NORTH"), BorderLayout.NORTH); 	//Contructeur JButton permet d'entrer une chaine de caract�re, et de positioner le bouton
		// a une position pr�cise du BorderLayout
//		content.add(new JButton("SOUTH"), BorderLayout.SOUTH);
//		content.add(new JButton("EAST"), BorderLayout.EAST);
//		content.add(new JButton("WEST"), BorderLayout.WEST);
//		content.add(new JButton("CENTER"), BorderLayout.CENTER);
	
		JPanel panNord = new JPanel();
		content.add(panNord, BorderLayout.NORTH);
		panNord.add(new JButton("North"));
		
		//On veut pouvoir mettre des composents dans la zone Nord de la fen�tre --> On obtient le panneau de la zone avec .getContener et on instancie
		//un nouveau panneau  ==> On donne une �tiquette � notre panneau!
		
		
	}
}
