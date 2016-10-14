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
import fr.cdiEnterprise.model.Trainee;
import fr.cdiEnterprise.model.User;
import fr.cdiEnterprise.view.PanelUser;

/**
 * Listeners for users CRUD
 * Last update: 20161009
 * @version 0.1
 * @author Claire
 *
 */
public class PanelUserListeners implements ActionListener, MouseListener {

	// Given attribute
	private PanelUser panelUser;
	
	// Attributes to handle selection(s)
	private User selectedUser;
	private int indexUser;
	
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
		
		formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		zdt = Instant.now().atZone(ZoneId.of("Europe/Paris"));
		inscriptionDate = zdt.format(formatter);
		
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
		
		// User creation
		if(e.getSource() == panelUser.getCmdCreate()) {
			
			user = new Trainee(inscriptionDate, status, alias, email, afpa, trainer);
			System.out.println(user);
			
			Datas.getUsersList().add(user);
			panelUser.getMdlListUsers().addElement(user);
			
		}
		
		// User removal
		if(e.getSource() == panelUser.getCmdDelete()) {

			Datas.getUsersList().remove(selectedUser);
			panelUser.getMdlListUsers().remove(indexUser);
			System.out.println(Datas.getUsersList()); // Test code

		}
		
	}

	// MOUSE LISTENER
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource() == panelUser.getLstUsers()) {

			selectedUser = (User) panelUser.getLstUsers().getSelectedValue();
			indexUser = panelUser.getLstUsers().getSelectedIndex();

			panelUser.getTxtAlias().setText(selectedUser.getAlias());
			panelUser.getTxtMail().setText(selectedUser.getEmail());
			panelUser.getTxtAfpa().setText(selectedUser.getAfpa());

		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
