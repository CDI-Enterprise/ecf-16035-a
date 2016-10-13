/**
 * 
 */
package fr.cdiEnterprise.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class PanelUserListeners implements ActionListener {

	// Given attribute
	private PanelUser panelUser;
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
	public PanelUserListeners(PanelUser panelUser) {

		this.panelUser = panelUser;
		
	}

	// ACTION LISTENER
	@Override
	public void actionPerformed(ActionEvent e) {
		
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
		
		if(e.getSource() == panelUser.getCmdCreate()) {
			
			user = new Trainee(status, alias, email, afpa, trainer);
			System.out.println(user);
			
			Datas.getUsersList().add(user);
			panelUser.getMdlListUsers().addElement(user);
			
		}
		
	}

}
