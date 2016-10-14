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
	private ArrayList<Item> allItems;
	private DefaultListModel<Item> listModele;
	private DefaultTableModel tableModele;
	private JScrollPane scrollPane;
	private JTable table;
	private String[][] tableauMsg = {
			{"olivier", "test1", "13-10-2016"},
			{"claire", "test3", "14-10-2016"},
			{"anais", "test4", "12-10-2016"},
			{"ismael", "test5", "14-10-2016"},

		};; 
	
	
	private static final String FORMAT_LIST = "%1$-25s %2$-35s %3$-10s";
	private static final String[] HEADER_LIST	= {"From", "Objet", "Date reception"};
	
	
	/**
	 * Default constructor 
	 */
	public MessagingMainPanel() {
		
		listModele = new DefaultListModel<>();
		MessageListener listener = new MessageListener(this);
		border = BorderFactory.createLineBorder(Color.GRAY);
		
		
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
		
		JLabel lblNombre = new JLabel(listModele.size()+"");
		
		btnNew = new JButton("Nouveau");
		btnDraft = new JButton("Brouillon");
		btnDisplay = new JButton("Refersh");
		
		panWest.setLayout(new MigLayout());
		
		panWest.add(btnNew, "wrap");
		panWest.add(btnDraft, "wrap");
		panWest.add(btnDisplay, "wrap");
		
		
		String header = String.format(FORMAT_LIST, HEADER_LIST);
		
		JLabel headerLabel = new JLabel(header);
		JList<Item> list = new JList<Item>(listModele);
		
		scrollPane = new JScrollPane();
		panMess.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(tableModele);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		
		table.setFillsViewportHeight(true);
		
		table.setEnabled(true);
		
		table.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		//table.setAutoCreateRowSorter(true);
		//table.setColumnSelectionAllowed(false);
		table.setModel(new DefaultTableModel(
				tableauMsg,
			new String[] {
				"Sender", "Objet", "Date reception"
			}
		));
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

	/**
	 * @param allItems
	 * @return
	 */
	private void fillModel() {
		Clients allClients = Datas.getClientBox();
		
		MpClient cli = allClients.getClient(ReadProperties.getMyAlias());
		if(cli == null) {
			System.out.println("cli est null");
		}
		allItems = cli.getMessages(false);
		//tableauMsg = new String[allItems.size()][3];
		System.out.println("Nb emails :"+allItems.size());
			
		

		//tableauMsg = allClients.getMsgTableFormat(ReadProperties.getMyAlias(), false);
		
		

		
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

}
