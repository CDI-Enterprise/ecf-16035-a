/**
 * 
 */
package fr.cdiEnterprise.view.profile;

import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import fr.cdiEnterprise.control.PanelUserSRListener;
import fr.cdiEnterprise.dao.UserDAO;
import fr.cdiEnterprise.model.User;
import fr.cdiEnterprise.service.Users;
import net.miginfocom.swing.MigLayout;

/**
 * Panel test to display a list of all users.
 * 
 * @author Claire
 * @version 23-10-2016
 * 
 */
public class PanelUserSR extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Components for panNorth
	private JPanel panNorth;
	private JLabel lblPanelTitle;
	private JLabel lblDisplay;
	private JButton cmdAll;
	private JButton cmdTrainee;
	private JButton cmdFormerTrainee;
	private JButton cmdTrainer;
	
	// Attributes for UserDAO
	private UserDAO userDAO;
	private Users users;
	
	// Attributes for a JTable
	private DefaultTableModel mdlTable;
	private JTable jtUser;
	private Object[] userArray;
	
	// JScrollPane for BorderLayout Center
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
		
		lblPanelTitle = new JLabel("Membres");
		lblPanelTitle.setFont(new Font(getName(), Font.BOLD, 14));
		panNorth.add(lblPanelTitle, "wrap 20");
		
		lblDisplay = new JLabel("Voir : ");
		panNorth.add(lblDisplay);
		cmdAll = new JButton("Tout");
		panNorth.add(cmdAll);
		cmdTrainee = new JButton("Stagiaire");
		panNorth.add(cmdTrainee);
		cmdFormerTrainee = new JButton("Ancien");
		panNorth.add(cmdFormerTrainee);
		cmdTrainer = new JButton("Formateur");
		panNorth.add(cmdTrainer);
		
		// CENTER - List
		panScrollList = new JScrollPane();
		panScrollList.setBorder(new EmptyBorder(0, 20, 0, 20));
		this.add(panScrollList, BorderLayout.CENTER);		
		
		// TODO (Claire) IHM not directly to DAO?
		// Calling the User DAO manager
		userDAO = new UserDAO();
		users = userDAO.getUsersList();
		
		// Create a table model, a JTable to display users list as JTable
		mdlTable = new DefaultTableModel();
		jtUser = new JTable();
		
		mdlTable.setColumnIdentifiers(new String[] {"ID", "Statut", "Nom d'utilisateur", "Date d'inscription", "AFPA"});
		for (User user : users) {
			userArray = new Object[] {user.getId(), user.getStatus(),
					user.getAlias(), user.getInscriptionDate(), user.getAfpa()};
			mdlTable.addRow(userArray);
		}
		
		jtUser.setModel(mdlTable);		
		// Only one line at a time can be selected
		jtUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
		panScrollList.setViewportView(jtUser);
		
		// LISTENER
		PanelUserSRListener listener = new PanelUserSRListener(this);
		cmdAll.addActionListener(listener);
		cmdTrainee.addActionListener(listener);
		cmdFormerTrainee.addActionListener(listener);
		cmdTrainer.addActionListener(listener);
	}

	/**
	 * @return the cmdFormerTrainee
	 */
	public JButton getCmdFormerTrainee() {
		return cmdFormerTrainee;
	}

	/**
	 * @return the cmdAll
	 */
	public JButton getCmdAll() {
		return cmdAll;
	}

	/**
	 * @return the cmdTrainee
	 */
	public JButton getCmdTrainee() {
		return cmdTrainee;
	}

	/**
	 * @return the cmdTrainer
	 */
	public JButton getCmdTrainer() {
		return cmdTrainer;
	}		
}