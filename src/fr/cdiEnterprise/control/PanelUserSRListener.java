/**
 * 
 */
package fr.cdiEnterprise.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import fr.cdiEnterprise.dao.UserDAO;
import fr.cdiEnterprise.service.Users;
import fr.cdiEnterprise.view.profile.PanelUserSR;

/**
 * Listeners for users Search and Read.
 *
 * @author Claire
 * @version 23-10-2016
 * 
 */
public class PanelUserSRListener implements ActionListener {

	// Given attribute
	private PanelUserSR panel;

	// Attributes for UserDAO
	private UserDAO userDAO;
	private Users users;

	// TEST
	private JFrame popupFrame;

	/**
	 * Constructs a listener taking a panel for attribute.
	 */
	public PanelUserSRListener(PanelUserSR panel) {
		this.panel = panel;
		userDAO = new UserDAO();
	}

	// TODO (Claire) handle SQL exception in catch?
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == panel.getCmdAll()) {

			try {			
				users = userDAO.getUsersList();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource() == panel.getCmdTrainee()) {

			try {
				users = userDAO.getUsersByStatusList(panel.getCmdTrainee().getText());
				
				if (users.isEmpty()) {
					JOptionPane.showMessageDialog(popupFrame, "Désolé, il n'y a aucun "
							+ panel.getCmdTrainee().getText() + " !");
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		if (e.getSource() == panel.getCmdFormerTrainee()) {

			try {
				users = userDAO.getUsersByStatusList(panel.getCmdFormerTrainee().getText());
				
				if (users.isEmpty()) {
						JOptionPane.showMessageDialog(popupFrame, "Désolé, il n'y a aucun "
								+ panel.getCmdFormerTrainee().getText() + " !");
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		if (e.getSource() == panel.getCmdTrainer()) {

			try {
				users = userDAO.getUsersByStatusList(panel.getCmdTrainer().getText());
				
				if (users.isEmpty()) {
					JOptionPane.showMessageDialog(popupFrame, "Désolé, il n'y a aucun "
							+ panel.getCmdTrainer().getText() + " !");
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}