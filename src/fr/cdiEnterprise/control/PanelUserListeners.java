/**
 * 
 */
package fr.cdiEnterprise.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import fr.cdiEnterprise.dao.Datas;
import fr.cdiEnterprise.model.FormerTrainee;
import fr.cdiEnterprise.model.Trainee;
import fr.cdiEnterprise.model.Trainer;
import fr.cdiEnterprise.model.User;
import fr.cdiEnterprise.view.PanelUser;

/**
 * Listeners for users CRUD
 * 
 * @version 13-10-2016
 * @author Claire
 *
 */
public class PanelUserListeners implements ActionListener, MouseListener {

	// Given attribute
	private PanelUser panelUser;

	// Attributes to handle selection(s)
	private User selectedUser;
	private Trainee selectedTrainee;
	private FormerTrainee selectedFormerTrainee;
	private Trainer selectedTrainer;
	private int indexUser;
	private int indexTrainee;
	private int indexFormerTrainee;
	private int indexTrainer;

	// Attribute to create-update a user
	private User user;

	// To create the inscriptionDate
	DateTimeFormatter formatter;
	ZonedDateTime zdt;
	private String inscriptionDate;

	private String status;
	private String alias;
	private String email;
	private String afpa;
	private String trainer;

	/**
	 * Constructs a listener taking a panel for attribute
	 */
	public PanelUserListeners(PanelUser panelUser) {

		this.panelUser = panelUser;

	}

	// ACTION LISTENER
	@Override
	public void actionPerformed(ActionEvent e) {

		// Inscription date creation
		formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		zdt = Instant.now().atZone(ZoneId.of("Europe/Paris"));
		inscriptionDate = zdt.format(formatter);

		// Status selection
		ButtonGroup statusGrp = panelUser.getStatusGrp();
		Enumeration<AbstractButton> enumOpt = statusGrp.getElements();

		while (enumOpt.hasMoreElements()) {
			JRadioButton optListener = (JRadioButton) enumOpt.nextElement();
			if (optListener.isSelected()) {
				status = optListener.getText();
			}
		}

		alias = panelUser.getTxtAlias().getText();
		email = panelUser.getTxtMail().getText();
		afpa = panelUser.getTxtAfpa().getText();
		trainer = panelUser.getTxtTrainer().getText();

		// Clear all fields
//		if (e.getSource() == panelUser.)
		
		// User creation
		if (e.getSource() == panelUser.getCmdCreate()) {

			user = new Trainee(inscriptionDate, status, alias, email, afpa, trainer);
			System.out.println(user);

			Datas.getUsersList().add(user);
			panelUser.getMdlListUsers().addElement(user);

		}

		// User removal
		if (e.getSource() == panelUser.getCmdDelete()) {

			Datas.getUsersList().remove(selectedUser);
			panelUser.getMdlListUsers().remove(indexUser);

		}

	}

	// MOUSE LISTENER
	@Override
	public void mouseClicked(MouseEvent e) {

		if(e.getSource() == panelUser.getLstUsers()) {

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
			if(selectedUser.getStatus() == "Stagiaire") {

				selectedTrainee = (Trainee) selectedUser;
				// indexTrainee = indexUser;
				
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
			else if(selectedUser.getStatus() == "Ancien") {

				selectedFormerTrainee = (FormerTrainee) selectedUser;
				// indexFormerTrainee = indexUser;
				
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

				selectedTrainer = (Trainer) selectedUser;
				// indexFormerTrainee = indexUser;
				
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
