/**
 * 
 */
package fr.cdiEnterprise.dao.test;

import java.sql.SQLException;

import fr.cdiEnterprise.dao.UserDAO;
//import fr.cdiEnterprise.model.User;
import fr.cdiEnterprise.service.Users;

/**
 * @author Claire
 * @version 22-10-2016
 *
 */
public class UserDAOTest {

	public static void main(String[] args) throws SQLException {

		UserDAO userDAO = new UserDAO();
		
		// SELECT WHERE user_id
//		User test = userDAO.search(10);
//		System.out.println("App : " + test);
		
		// SELECT WHERE user_status
//		Users test = userDAO.search("Formateur");
//		System.out.println("App : " + test);
		
		// CREATE
//		String creationDone = userDAO.create(10, "22/10/2016", "Ancien", "CDI", "cdi@mail.com", "Saint-Jérôme");
//		System.out.println(creationDone);
		
		// READ all
		Users users = new Users();
		users = userDAO.getUsersList();
		System.out.println("App : " + users);
//		
		// UPDATE
//		String updateDone = userDAO.update(10, "22/10/2016", "Ancien", "CDI", "cdi@mail.fr", "Saint-J");
//		System.out.println(updateDone);
		
		// DELETE
//		String deleteDone = userDAO.delete(10);
//		System.out.println(deleteDone);
		
	}

}
