/**
 * 
 */
package fr.cdiEnterprise.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import fr.cdiEnterprise.control.MessageListener;

import fr.cdiEnterprise.control.MpClient;
import fr.cdiEnterprise.dao.Datas;
import fr.cdiEnterprise.model.Item;
import fr.cdiEnterprise.service.Clients;
import fr.cdiEnterprise.service.Items;
import fr.cdiEnterprise.util.ReadProperties;
import net.miginfocom.swing.MigLayout;


/**
 * This class is going to display the main messenging's page, which contains all the messages for the user.
 * from there user will be able to create new message, remove or edit draft message
 * @author Nicolas Tarral
 * @version 11-10-2016
 *
 */
public class MessagingMainPanel extends JPanel {
	
	
	private Border border;
	private JButton btnNew;
	private JButton btnDraft;
	private JButton btnDisplay;
	
	private String nombreMessage;
	private Items allItems;
	private SpecialTableItemModel tiModel;
	private DefaultTableModel tableModele;
	private JScrollPane scrollPane;
	private JTable table;
	//private String[][] tableauMsg;
	private String[][] tableauMsg;
	private Items userItems;
	

	
	
	private static final String FORMAT_LIST = "%1$-25s %2$-35s %3$-10s";
	private static final String[] HEADER_LIST	= {"From", "Objet", "Date reception"};
	
	
	/**
	 * Default constructor 
	 */
	public MessagingMainPanel() {
		
		//listModele = new DefaultListModel<>();
		MessageListener listener = new MessageListener(this);
		border = BorderFactory.createLineBorder(Color.GRAY);
		table = new JTable(tiModel);
		
		
		fillModel();
		


		
		
		JPanel panMess = new JPanel();
		JPanel panNorth = new JPanel();
		JPanel panWest = new JPanel();
		JPanel panCenter = new JPanel();
		panMess.setLayout(new BorderLayout());
		add(panMess);
		panMess.add(panNorth,BorderLayout.NORTH);
		panMess.add(panCenter,BorderLayout.CENTER);
		panMess.add(panWest, BorderLayout.WEST);
		
		JLabel lblTitle = new JLabel("- Messagerie -");
		JLabel lblMess = new JLabel("Nombre de Message(s) :");
		
		tiModel = new SpecialTableItemModel(userItems);
		
		tableModele =  new DefaultTableModel(tableauMsg, new String[] {
				"Sender", "Objet", "Date Reception"
			});
		
		JLabel lblNombre = new JLabel(tableModele.getRowCount()+"");
		
		btnNew = new JButton("Nouveau");
		btnDraft = new JButton("Brouillon");
		btnDisplay = new JButton("Refersh");
		
		panWest.setLayout(new MigLayout());
		
		panWest.add(btnNew, "wrap");
		panWest.add(btnDraft, "wrap");
		panWest.add(btnDisplay, "wrap");
		
		
		String header = String.format(FORMAT_LIST, HEADER_LIST);
		
		JLabel headerLabel = new JLabel(header);
		//JList<Item> list = new JList<Item>(listModele);
		
		scrollPane = new JScrollPane();
		panMess.add(scrollPane, BorderLayout.CENTER);
		
		
		
		//table = new JTable();
		//table.setModel(tableModele);
		//table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		
		table.setFillsViewportHeight(true);
		
		table.setEnabled(true);
		
		table.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		//table.setAutoCreateRowSorter(true);
		//table.setColumnSelectionAllowed(false);
		//table.setModel(tableModele);
		scrollPane.setViewportView(table);
		
		panNorth.add(lblTitle);
		
		
		
		panCenter.setBorder(border);
		
		// used to be for the Jlist
		/*panCenter.setLayout(new MigLayout());
		
//		panCenter.add(btnNew, "w 200!");
//		panCenter.add(btnDraft, "w 200!");
//		panCenter.add(btnDisplay, "wrap");
		panCenter.add(lblMess, "w 200!");
		panCenter.add(lblNombre, "wrap");
		
		panCenter.add(headerLabel, "wrap");
		panCenter.add(list, "wrap");*/
		
		table.addMouseListener(listener);
		//table.getSelectionModel().addListSelectionListener(listener);
		btnNew.addActionListener(listener);
		btnDraft.addActionListener(listener);
		btnDisplay.addActionListener(listener);
	}

	public SpecialTableItemModel getTiModel() {
		return tiModel;
	}

	/**
	 * @param allItems
	 * @return
	 */
	private void fillModel() {
		// obteniur toutes les boites de messageries
		Clients allClients = Datas.getClientBox();
		
		// retourne la boite messagerie de notre utilisateur.
		MpClient cli = allClients.getClient(ReadProperties.getMyAlias());
		if(cli == null) {
			System.out.println("cli est null");
		}
		// TODO (nicolas)factoriser cette partie.
		// rapatrier tous les messages.
		
		allItems = cli.getMessages(false);
		
		
		if(allItems.isEmpty()) {
			System.out.println("--- il n'y a pas de message ---");
			tableauMsg = new String[allItems.size()][3];
			tableauMsg = allClients.getMsgTableFormat(ReadProperties.getMyAlias(), false);
			if(tableauMsg == null) {
				System.out.println("tableauMsg est null" + tableauMsg.length);
			}else {
				
				System.out.println("tableauMsg nest pqs null" + tableauMsg.length);
				tableModele =  new DefaultTableModel(tableauMsg, new String[] {
						"Sender", "Objet", "Date Reception"
					});
				
			}
			
			
		}else {
			userItems = allItems;
			tiModel.setUsers(userItems);
			tableauMsg = new String[allItems.size()][3];
			// recupere tous les messages d'un utilisateur de l'app.
			tableauMsg = allClients.getMsgTableFormat(ReadProperties.getMyAlias(), false);
			tableModele =  new DefaultTableModel(tableauMsg, new String[] {
					"Sender", "Objet", "Date Reception"
				});
		
			
		}
		System.out.println("tableModele est "+tableModele.getRowCount()+ "table " + table);
		table.setModel(tableModele);
		//
		
			
		

		//
		
		

		
	}

	/**
	 * 
	 */
	private void readTableauModele(String[][] tableauMsg) {
		System.out.println("--- Verification du tableau ---");
		for(int i =0; i < tableauMsg.length; i++ ) {
			for(int j =0; j < 3; j++ ) {
				System.out.println(tableauMsg[i][j]);
			}
		}
		System.out.println("--- fin ---");
	}

	public JButton getBtnNew() {
		return btnNew;
	}

	public JButton getBtnDraft() {
		return btnDraft;
	}

	public JButton getBtnDisplay() {
		return btnDisplay;
	}

	public void refresh() {
		fillModel();
		
		// TODO Auto-generated method stub
		
	}

	public Items getUserItems() {
		return userItems;
	}



}
