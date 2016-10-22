/**
 * 
 */
package fr.cdiEnterprise.dao.test;

import java.sql.SQLException;

import fr.cdiEnterprise.dao.UserDAO;

/**
 * @author Claire
 *
 */
public class UserDAOTest {

	public static void main(String[] args) throws SQLException {

		UserDAO userDAO = new UserDAO();
		
		// Test search a user
//		String test = userDAO.search(3);
//		System.out.println("App : " + test);
		
		// Test create a user
		String creationDone = userDAO.create(10, "22/10/2016", "Ancien", "CDI", "cdi@mail.com", "Saint-Jérôme");
		System.out.println(creationDone);
		
		// Test read all users
//		Users users = new Users();
//		users = userDAO.read();
//		System.out.println("App : " + users);
//		
		// Test update a user
		
		// Test delete a user
//		String deleteDone = userDAO.delete(10);
//		System.out.println(deleteDone);
		
	}

}
