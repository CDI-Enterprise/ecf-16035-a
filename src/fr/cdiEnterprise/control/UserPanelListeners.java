/**
 * 
 */
package fr.cdiEnterprise.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import fr.cdiEnterprise.dao.Datas;
import fr.cdiEnterprise.model.FormerTrainee;
import fr.cdiEnterprise.model.Trainee;
import fr.cdiEnterprise.model.Trainer;
import fr.cdiEnterprise.model.User;
import fr.cdiEnterprise.view.UserPanel;

/**
 * Listeners for users CRUD
 * 
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
	private Trainer selectedTrainer;
	private int indexUser;

	// Attribute to create-update a user
	private User user;

	private String status;
	private String alias;
	private String email;
	private String afpa;
	private String trainer;

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
		jrButtonSelected = ControlMethods.getSelectedJRadioButton(jrButtonGrp);
		status = jrButtonSelected.getText();		
		
		// Register informations
		alias = panelUser.getTxtAlias().getText();
		email = panelUser.getTxtMail().getText();
		afpa = panelUser.getTxtAfpa().getText();
		trainer = panelUser.getTxtTrainer().getText();
		

		// Clears all fields
		if (e.getSource() == panelUser.getCmdCancel()) {

			// Clears User JList
			panelUser.getLstUsers().setSelectedIndices(new int[] {});

			// Clears and re-enables status JRadioButton
			jrButtonGrp.clearSelection();
			panelUser.getOptTrainee().setEnabled(true);
			panelUser.getOptFormerTrainee().setEnabled(true);
			panelUser.getOptTrainer().setEnabled(true);

			// Clears register informations JTextField
			panelUser.getTxtAlias().setText("");
			panelUser.getTxtMail().setText("");
			panelUser.getTxtAfpa().setText("");
			panelUser.getTxtTrainer().setText("");

		}

		// User creation
		if (e.getSource() == panelUser.getCmdCreate()) {

			// TODO try catch if no status
			// Depending on status, instantiates a Trainee or FormerTrainee or Trainer with User reference
			switch (status) {
            case "Stagiaire" :  
            	user = new Trainee(status, alias, email, afpa, trainer);
				System.out.println(user); // Test code
				System.out.println(Datas.getUsersList()); // Test code
				break;
			
            case "Ancien" :
            	user = new FormerTrainee(status, alias, email, afpa, trainer);
            	System.out.println(user); // Test code
            	System.out.println(Datas.getUsersList()); // Test code
            	break;
            	
            case "Formateur" :
            	user = new Trainer(status, alias, email, afpa);
				System.out.println(user); // Test code
				System.out.println(Datas.getUsersList()); // Test code
				break;
				
			default:
				System.out.println("Aucun statut sélectionné.");
				break;
            
			}

			Datas.getUsersList().add(user);
			panelUser.getMdlListUsers().addElement(user);
			System.out.println(Datas.getUsersList()); // Test code

		}

		// User modification
		if (e.getSource() == panelUser.getCmdUpdate()) {

			// TODO change of status and class for Trainee to FormerTrainee
			selectedUser.setEmail(email);
			selectedUser.setAfpa(afpa);
			// Re-affects new informations to the selected User
			panelUser.getMdlListUsers().set(indexUser, selectedUser);
			System.out.println(Datas.getUsersList()); // Test code

		}

		// User removal
		if (e.getSource() == panelUser.getCmdDelete()) {

			Datas.getUsersList().remove(selectedUser);
			panelUser.getMdlListUsers().remove(indexUser);
			System.out.println(Datas.getUsersList()); // Test code

		}

	}

	// MOUSE LISTENER
	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource() == panelUser.getLstUsers()) {

			// Get the selected User and its index in the model list
			selectedUser = (User) panelUser.getLstUsers().getSelectedValue();
			indexUser = panelUser.getLstUsers().getSelectedIndex();

			// Display informations of the selected User
			panelUser.getTxtAlias().setText(selectedUser.getAlias());
			panelUser.getTxtMail().setText(selectedUser.getEmail());
			panelUser.getTxtAfpa().setText(selectedUser.getAfpa());

			// These fields can't be changed by the User
			panelUser.getTxtAlias().setEnabled(false);
			panelUser.getTxtAfpa().setEnabled(false);

			// Display informations if the selected User is a Trainee
			if (selectedUser.getStatus() == "Stagiaire") {

				// Cast User to Trainee
				selectedTrainee = (Trainee) selectedUser;

				// Status
				panelUser.getOptTrainee().setSelected(true);
				panelUser.getOptTrainee().setEnabled(true);
				panelUser.getOptFormerTrainee().setEnabled(true);
				panelUser.getOptTrainer().setEnabled(false);

				// Trainer
				panelUser.getTxtTrainer().setText(selectedTrainee.getTrainer());
				panelUser.getTxtTrainer().setEnabled(false);

			}
			// Display informations if the selected User is a FormerTrainee
			else if (selectedUser.getStatus() == "Ancien") {

				// Cast User to FormerTrainee
				selectedFormerTrainee = (FormerTrainee) selectedUser;

				// Status
				panelUser.getOptFormerTrainee().setSelected(true);
				panelUser.getOptTrainee().setEnabled(false);
				panelUser.getOptFormerTrainee().setEnabled(false);
				panelUser.getOptTrainer().setEnabled(false);


				// Trainer
				panelUser.getTxtTrainer().setText(selectedFormerTrainee.getTrainer());
				panelUser.getTxtTrainer().setEnabled(false);

			}
			// Display informations if the selected User is a Trainer
			else {

				// Cast User to Trainer
				selectedTrainer = (Trainer) selectedUser;

				// Status
				panelUser.getOptTrainer().setSelected(true);
				panelUser.getOptTrainee().setEnabled(false);
				panelUser.getOptFormerTrainee().setEnabled(false);
				panelUser.getOptTrainer().setEnabled(false);

				// Clean fields not related to the Trainer status
				panelUser.getTxtTrainer().setText("");
				// A trainer can change his place of work
				panelUser.getTxtAfpa().setEnabled(true);


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
