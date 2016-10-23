/**
 * 
 */
package fr.cdiEnterprise.view.profile;

import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import fr.cdiEnterprise.dao.UserDAO;
import fr.cdiEnterprise.model.User;
import fr.cdiEnterprise.service.Users;
import net.miginfocom.swing.MigLayout;

/**
 * Panel test to display a list of all users.
 * 
 * @author Claire
 * @version 22-10-2016
 */
public class PanelUserSR extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Panels for BorderLayout of MembersPanel
	private JPanel panNorth;
	private JPanel panCenter;
	
	// JLabel for panNorth
	private JLabel lblMembersTitle;
	
	// Attributes for UserDAO
	private UserDAO userDAO;
	private Users users;
	
	// Attributes for a JList
//	private DefaultListModel<User> mdlList;
//	private JList<User> list;
	
	// Attributes for a JTable
	private DefaultTableModel mdlTable;
	private JTable jtUser;
	private Object[] userArray;
	
	// JScrollPane for panCenter
	private JScrollPane panScrollList;

	/**
	 * Constructs a panel which display a list of Users.
	 * @throws SQLException 
	 */
	public PanelUserSR() throws SQLException {

		// Main layout for users display panel
		this.setLayout(new BorderLayout(10, 20));

		// NORTH - Title
		panNorth = new JPanel();
		panNorth.setLayout(new MigLayout());
		this.add(panNorth, BorderLayout.NORTH);
		
		lblMembersTitle = new JLabel("Membres");
		lblMembersTitle.setFont(new Font(getName(), Font.BOLD, 14));
		panNorth.add(lblMembersTitle);
		
		// TODO (Claire) add selection button to display users by selection criterion
		
		// CENTER - List
		panCenter = new JPanel();
		panCenter.setLayout(new MigLayout());
		panCenter.setBorder(new EmptyBorder(0, 0, 0, 5));
		this.add(panCenter, BorderLayout.CENTER);
		
		// Calling the User DAO manager
		userDAO = new UserDAO();
		users = userDAO.getUsersList();
		
//		// Display users list as JList
//		mdlList = new DefaultListModel<User>();	
//		for (User user : users) {
//			if(user != null) {
//					mdlList.addElement(user);
//			}
//		}
//		list = new JList<User>(mdlList);
//		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//
//		panScrollList = new JScrollPane(list);
//		panCenter.add(panScrollList);
		
		// Display users list as JTable
		// Create a table model
		mdlTable = new DefaultTableModel();
		mdlTable.setColumnIdentifiers(new String[] {"ID", "Nom d'utilisateur", "Date d'inscription", "Mail", "AFPA"});
		for (User user : users) {
			userArray = new Object[] {user.getId(), 
					user.getAlias(), user.getInscriptionDate(), user.getEmail(), user.getAfpa()};
			mdlTable.addRow(userArray);
		}
		
		jtUser = new JTable(mdlTable);
		// Only one line at a time can be selected
		jtUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
		panScrollList = new JScrollPane();
		panScrollList.setViewportView(jtUser);
		panCenter.add(panScrollList);

	}

}
