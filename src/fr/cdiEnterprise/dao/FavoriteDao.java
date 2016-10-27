/**
 * 
 */
package fr.cdiEnterprise.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

import fr.cdiEnterprise.model.Favorite;
import fr.cdiEnterprise.service.Favorites;
//import fr.cdiEnterprise.view.company.CompaniesSRPanel;
//import fr.cdiEnterprise.view.BookMarkPanel;
//import fr.cdiEnterprise.model.NoteCompany;
//import fr.cdiEnterprise.service.Favorites;
//import fr.cdiEnterprise.view.CompanyCreationPanel;


/**
 *20 oct. 2016
 * @author Ismael
 *ecf-16035-a
 *22:19:29
 */

public class FavoriteDao 
{
	private static Connection conn = DBConnection.getConnect();
	private static Statement stmt;
	private static PreparedStatement prStmt;
//	private static PreparedStatement createFavorite;
	private JComboBox <String> lstMyFavorites;

	/**
	 * Create idMax for BDD
	 * @param favorite
	 * @return idMax
	 * @throws SQLException 
	 * 
	 */
	public static int getIdMax(String table) throws SQLException
	{
		Statement stmt = conn.createStatement();

		ResultSet rsMax = stmt.executeQuery("select max (" + table + "_id) from " + table);
		int idMax = 0;

		while (rsMax.next())
			idMax = rsMax.getInt(1);
		return idMax;
	}


	/**
	 * Exemple add favorite
	 * @param favorite
	 * 
	 */
	public int addFavorite (Favorite favorite)
	{
		int returnMark = 0;
		try
		{
			//Recover datas 
			//================

			//TODO note

			//			NoteCompany noteUser = favorite.getNoteCompany();
			//
			//			//Seach if noteUser exist
			//			if (noteUser != null)
			//			{
			//				String lblNoteUser	= noteUser.getLblNote();
			//				NoteCompany noteBDD = null;
			//
			//				ResultSet rs = stmt.executeQuery("select idNote from notecompany where lblNote = '" + lblNoteUser + "'");
			//				while (rs.next())
			//				{
			//					int idNote	= rs.getInt(1);
			//					noteBDD		= new NoteCompany(idNote, lblNoteUser);
			//				}
			//				//if don't exist,we create it
			//
			//				if(noteBDD == null)
			//				{
			//					ResultSet rsMax = stmt.executeQuery("select max(idNote) from notecompany");
			//					int idMax = 0;
			//					while (rsMax.next()) idMax = rsMax.getInt(1);
			//
			//					noteBDD = new NoteCompany(idMax + 1, lblNoteUser);
			//
			//					//insert to BDD
			//					stmt.executeUpdate("insert into notecompany (" + noteBDD.getIdNote() + 
			//							",'" + noteBDD.getLblNote() + "')");						
			//				}
			//
			//				//Put the note to favorite for to have a object
			//				favorite.setNoteCompany(noteUser);			
			//			}

			//================

			//Insert favorite

			stmt.executeUpdate("insert into favorite values (" +  favorite.getIdFavorite() + ",' "+ favorite.getCompanyName() +
					",'" + favorite.getCity() + ",'" + favorite.getSize() + ",'" + favorite.getSector() + ",'" + favorite.getWebSite() +
					",'"  + favorite.getContactMail() +  ",'" + favorite.getNoteCompany() + "')");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return returnMark;	
	}


	/**
	 * Exemple update note favorite
	 * @param note reference to Company
	 * 
	 */

	public void noteFavorite (String noteCompany) throws SQLException
	{
		String reqSql = null;
		int rs;

		reqSql = "UPDATE favorite set noteCompany = ? where favoriteId = ?";

		prStmt = conn.prepareStatement(reqSql);
		prStmt.setString(1, noteCompany);
		//updateFavorite.

		rs = prStmt.executeUpdate();
		System.out.println(rs);

		prStmt.close();
		
	}


	/**
	 * Exemple delete favorite
	 * @param companyName reference to Company
	 * 
	 */

	public String deleteFavorite (String companyName)
	{
		try 
		{
			stmt.executeUpdate("delete favorite where companyName = " + companyName);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return companyName;
	}

	/**
	 * Exemple load jcomboxfavorite to lstfavorite
	 * @param companyName reference to Company
	 * @throws SQLException 
	 * 
	 */

	public static Favorites getMyFavorite () throws SQLException				//load the companyName
	{
		Favorite favCompany;
		Favorites favList		= new Favorites();
		String companyName;
		String reqSql			= null;
		ResultSet rsMyFavorite	= null;
		reqSql					= "select companyName from favorite order by companyName";
		
		try
		{
			prStmt = conn.prepareStatement(reqSql);    
			rsMyFavorite = prStmt.executeQuery()	;
			while (rsMyFavorite.next())
			{
				companyName = rsMyFavorite.getString(1);
				//System.out.println("cn" + companyName);
				favCompany = new Favorite();
				favCompany.setCompanyName(companyName);
				System.out.println("fc" + favCompany);
				favList.add(favCompany);
				//.add("companyName");
				System.out.println("CompanyName select : " + favList);
			}
		//	prStmt.close();
			//rsMyFavorite.close();
			System.out.println("f2" + favList);
		}
		catch (SQLException e)
		{
			System.out.println("Favorite : erreur myFavorite()");
			e.printStackTrace();
		}
		prStmt.close();
		return favList;	
	}

	//		Favorite cboCompanyName = new Favorite();
	//
	//		String companyName 	= null;
	//		String reqSql		= null;
	//		reqSql				= "select companyName from favorite order by companyName";
	//		ResultSet rsMyFavorite	= null;
	//		try
	//		{
	//			PreparedStatement myFavorite = conn.prepareStatement(reqSql);    
	//			rsMyFavorite = myFavorite.executeQuery(reqSql)	;
	//		}
	//		catch (SQLException e)
	//		{
	//			System.out.println("Favorite : erreur myFavorite()");
	//			e.printStackTrace();
	//	
	//		}
	//		try{
	//			while (rsMyFavorite.next()) 
	//				{
	//				lstMyFavorites.addItem(rsMyFavorite.getString("companyName"));
	//				
	//				//Create object
	//				cboCompanyName = new Favorite(companyName);
	//				stmt.close();
	//				System.out.println(cboCompanyName);
	//				}
	//		}
	//		catch (SQLException e)
	//		{
	//			System.out.println("Favorite : erreur myFavorite()");
	//			e.printStackTrace();
	//		}
	//		return cboCompanyName;
	//}

	//To  display the result

	public Favorite lstFavorite(String companyName)
	{
		Favorite favorite = new Favorite();

		String reqSql	= null;
		reqSql			= "select companycity , companysize, companysector, companywebSite, noteuser from favorite where = ?";
		ResultSet rs	= null;

		try
		{
			PreparedStatement lstFavorite = conn.prepareStatement(reqSql);
			lstFavorite.setString(1, companyName); 							//load the data by companyName
			rs = lstFavorite.executeQuery(reqSql)	;	
		}
		catch (SQLException e)
		{
			System.out.println("Favorite : erreur lstFavorite()");
			e.printStackTrace();
		}
		try
		{
			while (rs.next())
			{
				String city				= rs.getString("city");
				String size 			= rs.getString("size");
				String sector 			= rs.getString("sector");
				String webSite			= rs.getString("webSite");
				String contactMail 		= rs.getString("contactMail");
				String noteUser			= rs.getString("noteUser");

				//				//Search if note is null
				//				NoteCompany note = null;
				//
				//				//New statement for this 
				//				Statement stmtNote 	= conn.createStatement();
				//				String sqlNote		= "select lblNote from noteUser where idNote = " + idNoteUser ; 
				//				ResultSet rsNoteUser = stmtNote.executeQuery(sqlNote);
				//				while (rsNoteUser.next())
				//				{
				//					String lblNote = rsNoteUser.getString(1);
				//					note = new NoteCompany(lblNote);
				//				}

				//Create object
				favorite = new Favorite(city, size, sector, webSite, contactMail, noteUser);
				stmt.close();
			}
		}catch (SQLException e)
		{
			System.out.println("FavoriteDao : lstFavorite() - erreur sur favori");
			e.printStackTrace();
		}
		return favorite;
	}


	/**
	 * @return the lstMyFavorites
	 */
	public JComboBox<String> getLstMyFavorites() {
		return lstMyFavorites;
	}

}
