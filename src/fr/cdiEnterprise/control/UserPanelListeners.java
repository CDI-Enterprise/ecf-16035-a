/**
 * 
 */
package fr.cdiEnterprise.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import fr.cdiEnterprise.dao.OldDatas;
import fr.cdiEnterprise.model.FormerTrainee;
import fr.cdiEnterprise.model.Trainee;
import fr.cdiEnterprise.model.Trainer;
import fr.cdiEnterprise.model.User;
import fr.cdiEnterprise.view.UserPanel;

/**
 * Listeners for users CRUD
 * @version 16-10-2016
 * @author Claire
 *
 */
public class UserPanelListeners implements ActionListener, MouseListener {

	// Given attribute
	private UserPanel panelUser;

	// Attributes do define the selected status
	ButtonGroup jrButtonGrp;
	JRadioButton jrButtonSelected;	

	// Attributes to handle selection
	private User selectedUser;
	private Trainee selectedTrainee;
	private FormerTrainee selectedFormerTrainee;
//	private Trainer selectedTrainer;
	private int indexUser;

	// Attributes to create-update a user
	private User user;

	private String status;
	private String alias;
	private String email;
	private String afpa;
//	private String trainer;
	
	// Attributes to reset component
	ArrayList<JTextField> allJTextFields;

	/**
	 * Constructs a listener taking a panel for attribute
	 */
	public UserPanelListeners(UserPanel panelUser) {

		this.panelUser = panelUser;

	}

	// ACTION LISTENER
	@Override
	public void actionPerformed(ActionEvent e) {

		// Calls the status selection method
		jrButtonGrp = panelUser.getStatusGrp();
		jrButtonSelected = MethodsForListeners.getSelectedJRadioButton(jrButtonGrp);
		status = jrButtonSelected.getText();		

		// Register informations TODO Claire loop method?
		alias = panelUser.getTxtAlias().getText();
		email = panelUser.getTxtMail().getText();
		afpa = panelUser.getTxtAfpa().getText();
//		trainer = panelUser.getTxtTrainer().getText();

		// Clears all fields
		if (e.getSource() == panelUser.getCmdCancel()) {

			// Clears User JList
			panelUser.getLstUsers().setSelectedIndices(new int[] {});

			// Clears and re-enables status JRadioButton
			jrButtonGrp.clearSelection();
			panelUser.getOptTrainee().setEnabled(true);
			panelUser.getOptFormerTrainee().setEnabled(true);
			panelUser.getOptTrainer().setEnabled(true);
			
			// Calls the method which clears and enables all JTextField 
			allJTextFields = panelUser.getAllJTextFields();
			MethodsForListeners.resetJTextField(allJTextFields);
		}

		// User creation
		if (e.getSource() == panelUser.getCmdCreate()) {

//			try {
//				
//			}
//			catch () {
//				System.out.println("Vous devez remplir les champs obligatoires.");
//			}
			
			// TODO Claire try catch if no status
			// Depending on status, instantiates a Trainee or FormerTrainee or Trainer with User reference
			switch (status) {
			case "Stagiaire" :  
				user = new Trainee(status, alias, email, afpa);
				System.out.println(user); // Test code
				System.out.println(OldDatas.getUsersList()); // Test code
				break;

			case "Ancien" :
				user = new FormerTrainee(status, alias, email, afpa);
				System.out.println(user); // Test code
				System.out.println(OldDatas.getUsersList()); // Test code
				break;

			case "Formateur" :
				user = new Trainer(status, alias, email, afpa);
				System.out.println(user); // Test code
				System.out.println(OldDatas.getUsersList()); // Test code
				break;

			default:
				System.out.println("Aucun statut sélectionné.");
				break;

			}

			OldDatas.getUsersList().add(user);
			panelUser.getMdlListUsers().addElement(user);
			System.out.println(OldDatas.getUsersList()); // Test code

		}

		// User modification
		if (e.getSource() == panelUser.getCmdUpdate()) {

			selectedUser.setEmail(email);
			selectedUser.setAfpa(afpa);
			// Re-affects new informations to the selected User
			panelUser.getMdlListUsers().set(indexUser, selectedUser);
			
			// TODO Claire change of status and class for Trainee to FormerTrainee
			
			System.out.println(OldDatas.getUsersList()); // Test code

		}

		// User removal
		if (e.getSource() == panelUser.getCmdDelete()) {

			OldDatas.getUsersList().remove(selectedUser);
			panelUser.getMdlListUsers().remove(indexUser);
			System.out.println(OldDatas.getUsersList()); // Test code

		}

	}

	// MOUSE LISTENER
	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource() == panelUser.getLstUsers()) {

			// Gets the selected User and its index in the model list
			selectedUser = (User) panelUser.getLstUsers().getSelectedValue();
			indexUser = panelUser.getLstUsers().getSelectedIndex();

			// Displays informations of the selected User
			panelUser.getTxtAlias().setText(selectedUser.getAlias());
			panelUser.getTxtMail().setText(selectedUser.getEmail());
			panelUser.getTxtAfpa().setText(selectedUser.getAfpa());

			// These fields can't be changed by the User
			panelUser.getTxtAlias().setEnabled(false);
			panelUser.getTxtAfpa().setEnabled(false);
			panelUser.getTxtTrainer().setEnabled(false);

			// Depending on status, displays related informations of the selected User
			switch (selectedUser.getStatus()) {
			case "Stagiaire" :  
				// Casts User to Trainee
				selectedTrainee = (Trainee) selectedUser;
				// Status
				panelUser.getOptTrainee().setSelected(true);
				panelUser.getOptTrainee().setEnabled(true);
				panelUser.getOptFormerTrainee().setEnabled(true);
				panelUser.getOptTrainer().setEnabled(false);
				// Trainer
				panelUser.getTxtTrainer().setText(selectedTrainee.getTrainer());
				break;

			case "Ancien" :
				// Casts User to FormerTrainee
				selectedFormerTrainee = (FormerTrainee) selectedUser;
				// Status
				panelUser.getOptFormerTrainee().setSelected(true);
				panelUser.getOptTrainee().setEnabled(false);
				panelUser.getOptFormerTrainee().setEnabled(false);
				panelUser.getOptTrainer().setEnabled(false);
				// Trainer
				panelUser.getTxtTrainer().setText(selectedFormerTrainee.getTrainer());
				break;

			case "Formateur" :
				// Casts User to Trainer
//				selectedTrainer = (Trainer) selectedUser;
				// Status
				panelUser.getOptTrainer().setSelected(true);
				panelUser.getOptTrainee().setEnabled(false);
				panelUser.getOptFormerTrainee().setEnabled(false);
				panelUser.getOptTrainer().setEnabled(false);
				// A trainer can change his place of work
				panelUser.getTxtAfpa().setEnabled(true);
				// Clears fields not related to the Trainer status
				panelUser.getTxtTrainer().setText("");
				break;

			default:
				System.out.println("Aucun statut sélectionné.");
				break;

			}

		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}
