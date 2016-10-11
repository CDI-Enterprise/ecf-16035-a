/**
 * 
 */
package fr.cdiEnterprise.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class UsersListener implements ActionListener {

	// Given attribute
	private PanelUser panelUser;
	// Attribute to create-update a user
	private User user;
	private String alias;
	private String email;
	
	
	/**
	 * Constructs a listener taking a panel for attribute
	 */
	public UsersListener(PanelUser panelUser) {

		this.panelUser = panelUser;
		
	}

	// ACTION LISTENER
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO pt-virgule ?
		if(e.getSource() == panelUser.getTxtAlias()); {
			
			alias = panelUser.getTxtAlias().getText();
			System.out.println(alias);
		
		}
		
		// TODO pas de lst sur variable?
		if(e.getSource() == panelUser.getTxtMail()); {
			
			email = panelUser.getTxtMail().getText();
			
		}
		
		
		
		if(e.getSource() == panelUser.getCmdCreate()) {
			
			user = new Trainee(alias, email);
			System.out.println(user);
			
			Datas.getUsersList().add(user);
			panelUser.getMdlListUsers().addElement(user);
			
			
		}
		
	}

}
