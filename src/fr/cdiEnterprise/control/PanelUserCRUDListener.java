/**
 * 
 */
package fr.cdiEnterprise.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import fr.cdiEnterprise.control.exceptions.ZeroLenghtStringException;
import fr.cdiEnterprise.dao.UserDAO;
import fr.cdiEnterprise.model.FormerTrainee;
import fr.cdiEnterprise.model.Trainee;
import fr.cdiEnterprise.model.Trainer;
import fr.cdiEnterprise.model.User;
import fr.cdiEnterprise.view.profile.PanelUserCRUD;

/**
 * Listener test for users CRUD with DB.
 *
 * @author Claire
 * @version 24-10-2016
 */
public class PanelUserCRUDListener implements ActionListener, MouseListener {

	// Given attribute
	private PanelUserCRUD panel;

	// Attributes for DB access
	//	private UserDAO userDAO;

	// Frame for error message
	private JFrame popUpFrame;

	// Attributes do define the selected status
	private ButtonGroup jrButtonGrp;
	private JRadioButton jrButtonSelected;	

	// Attributes to handle selection
	private User selectedUser;
	//	private integer indexUser;
	private Trainee selectedTrainee;
	private FormerTrainee selectedFormerTrainee;
	private Trainer selectedTrainer;

	// Attributes to create-update a user
	private User user;
	private int id;
	//	private String inscriptionDate;
	private String status;
	private String alias;
	private String email;
	private String afpa;

	// Attributes to reset component
	ArrayList<JTextField> allJTextFields;

	/**
	 * @throws SQLException 
	 * 
	 */
	public PanelUserCRUDListener(PanelUserCRUD panel) throws SQLException {
		this.panel = panel;
	}

	// ACTION
	@Override
	public void actionPerformed(ActionEvent ae) {

		// TODO (Claire) create a new class DTO instead of calling DAO

		// Calls the status selection method TODO (Claire) control method JRadioButton
		jrButtonGrp = panel.getStatusGrp();
		jrButtonSelected = MethodsForListeners.getSelectedJRadioButton(jrButtonGrp);
		status = jrButtonSelected.getText();

		// TODO (Claire) control method JTextField
		alias = panel.getTxtAlias().getText();
		email = panel.getTxtMail().getText();
		afpa = panel.getTxtAfpa().getText();

		// CMD CANCEL
		if (ae.getSource() == panel.getCmdCancel()) {
			// Clears User JList
			panel.getLstUsersDB().setSelectedIndices(new int[] {});

			// Clears and re-enables status JRadioButton
			jrButtonGrp.clearSelection();
			panel.getOptTrainee().setEnabled(true);
			panel.getOptFormerTrainee().setEnabled(true);
			panel.getOptTrainer().setEnabled(true);

			// Calls the method which clears and enables all JTextField 
			allJTextFields = panel.getAllJTextFields();
			MethodsForListeners.resetJTextField(allJTextFields);
		}

		// CMD CREATE
		if (ae.getSource() == panel.getCmdCreate()) {
			try {
				// Depending on status, instantiates a Trainee or FormerTrainee or Trainer with User reference
				switch (status) {
				case "Stagiaire" :
					user = new Trainee(status, controlAttribute(alias), email, afpa);
					System.out.println(user); // Test code
					break;

				case "Ancien" :
					user = new FormerTrainee(status, controlAttribute(alias), email, afpa);
					System.out.println(user); // Test code
					break;

				case "Formateur" :
					user = new Trainer(status, controlAttribute(alias), email, afpa);
					System.out.println(user); // Test code
					break;

				default:
					System.out.println("Aucun statut s�lectionn�.");
					break;
				}

				// Asks UserDAO to insert a new user in DB
				try {
					String creationDone = UserDAO.createUser(user); // With String for test code
					panel.refresh(UserDAO.getUsersList());
					System.out.println(creationDone); // Test code
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} catch (ZeroLenghtStringException zlse) {
				System.out.println(zlse.getMessage());
				JOptionPane.showMessageDialog(popUpFrame, "Vous devez remplir les champs obligatoires.");
			}

		}


		// CMD UPDATE
		if (ae.getSource() == panel.getCmdUpdate()) {

			// Get the editable fields
			status = jrButtonSelected.getText();
			alias = panel.getTxtAlias().getText();
			email = panel.getTxtMail().getText();

			selectedUser.setStatus(status);
			selectedUser.setAlias(alias);
			selectedUser.setEmail(email);		

			// Asks UserDAO to update a user in DB
			try {
				String updateDone = UserDAO.updateUser(selectedUser); // With String for test code
				panel.refresh(UserDAO.getUsersList());
				System.out.println(updateDone); // Test code
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		// CMD DELETE
		if (ae.getSource() == panel.getCmdDelete()) {

			id = selectedUser.getId();

			// Asks UserDAO to delete a user in DB
			try {
				String deleteDone = UserDAO.deleteUser(id); // With String for test code
				panel.refresh(UserDAO.getUsersList());
				System.out.println(deleteDone); // Test code
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// MOUSE
	@Override
	public void mouseClicked(MouseEvent me) {

		if (me.getSource() == panel.getLstUsersDB()) {
			
			// Gets the selected User and its index in the model list
			selectedUser = (User) panel.getLstUsersDB().getSelectedValue();
			//			indexUser = panel.getLstUsersDB().getSelectedIndex();
			System.out.println(selectedUser); // Test code

			// Displays informations of the selected User
			panel.getTxtAlias().setText(selectedUser.getAlias());
			panel.getTxtMail().setText(selectedUser.getEmail());
			panel.getTxtAfpa().setText(selectedUser.getAfpa());

			// These fields can't be changed by the User
			panel.getTxtAlias().setEnabled(false);
			panel.getTxtAfpa().setEnabled(false);

			// Depending on status, displays related informations of the selected User
			switch (selectedUser.getStatus()) {
			case "Stagiaire" :  
				// Casts User to Trainee
				selectedTrainee = (Trainee) selectedUser;
				// Status
				panel.getOptTrainee().setSelected(true);
				panel.getOptTrainee().setEnabled(true);
				panel.getOptFormerTrainee().setEnabled(true);
				panel.getOptTrainer().setEnabled(false);
				break;

			case "Ancien" :
				// Casts User to FormerTrainee
				selectedFormerTrainee = (FormerTrainee) selectedUser;
				// Status
				panel.getOptFormerTrainee().setSelected(true);
				panel.getOptTrainee().setEnabled(false);
				panel.getOptFormerTrainee().setEnabled(false);
				panel.getOptTrainer().setEnabled(false);
				break;

			case "Formateur" :
				// Casts User to Trainer
				selectedTrainer = (Trainer) selectedUser;
				// Status
				panel.getOptTrainer().setSelected(true);
				panel.getOptTrainee().setEnabled(false);
				panel.getOptFormerTrainee().setEnabled(false);
				panel.getOptTrainer().setEnabled(false);
				// A trainer can change his place of work
				panel.getTxtAfpa().setEnabled(true);
				break;

			default:
				System.out.println("Aucun statut s�lectionn�.");
				break;
			}

		}

	}

	@Override
	public void mouseEntered(MouseEvent me) {
	}

	@Override
	public void mouseExited(MouseEvent me) {

	}

	@Override
	public void mousePressed(MouseEvent me) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	//	/**
	//	 * Check if alias is not a string with zero character.
	//	 * 
	//	 * @author Claire
	//	 * @return alias
	//	 * @throws ZeroLenghtStringException
	//	 * @version 23-10-2016
	//	 */
	//	private String getAlias() throws ZeroLenghtStringException {
	//		
	//		alias = panel.getTxtAlias().getText();
	//		System.out.println("Alias : " + alias + " " + alias.length());
	//		
	//		if (alias.length() == 0) {
	//			throw new ZeroLenghtStringException("Champ vide.");
	//		}
	//		else {
	//			return alias;
	//		}
	//	}

	private String controlAttribute(String attribute) throws ZeroLenghtStringException {

		if (attribute.length() == 0) {
			throw new ZeroLenghtStringException("Vous devez remplir les champs obligatoires.");
		}
		else {
			return attribute;
		}
	}

}