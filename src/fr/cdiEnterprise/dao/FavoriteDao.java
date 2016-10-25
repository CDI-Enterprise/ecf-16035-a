/**
 * 
 */
package fr.cdiEnterprise.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import fr.cdiEnterprise.model.Favorite;
import fr.cdiEnterprise.model.NoteCompany;
import fr.cdiEnterprise.service.Favorites;
//import fr.cdiEnterprise.view.CompanyCreationPanel;


/**
 *20 oct. 2016
 * @author Ismael
 *ecf-16035-a
 *22:19:29
 */

public class FavoriteDao 
{


	private final static String strNomDriver 	= "oracle.jdbc.driver.OracleDriver";
	private final static String dbURL			= "jdbc:oracle:thin:cdi_enterprise/stagpw@junon:1521:AFPA";

	private Connection conn;
	private Statement stmt;

	/**
/	 * 
	 */
	public FavoriteDao() 
	{
		try
		{
			Class.forName(strNomDriver);
			conn = DriverManager.getConnection(dbURL);
			stmt = conn.createStatement();
		}
		catch (SQLException e)
		{
			//TODO SQLException dbURL
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			//TODO ClassNotFoundException Class.forName
			e.printStackTrace();
		}
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

			NoteCompany noteUser = favorite.getNoteCompany();

			//Seach if noteUser exist
			if (noteUser != null)
			{
				String lblNoteUser	= noteUser.getLblNote();
				NoteCompany noteBDD = null;

				ResultSet rs = stmt.executeQuery("select idNote from notecompany where lblNote = '" + lblNoteUser + "'");
				while (rs.next())
				{
					int idNote	= rs.getInt(1);
					noteBDD		= new NoteCompany(idNote, lblNoteUser);
				}
				//if don't exist,we create it

				if(noteBDD == null)
				{
					ResultSet rsMax = stmt.executeQuery("select max(idNote) from notecompany");
					int idMax = 0;
					while (rsMax.next()) idMax = rsMax.getInt(1);

					noteBDD = new NoteCompany(idMax + 1, lblNoteUser);

					//insert to BDD
					stmt.executeUpdate("insert into notecompany (" + noteBDD.getIdNote() + 
							",'" + noteBDD.getLblNote() + "')");						
				}

				//Put the note to favorite for to have a object
				favorite.setNoteCompany(noteUser);			
			}

			//================

			//Insert favorite
			stmt.executeUpdate("insert into favorite values (" + favorite.getIdEnterprise() + ",'" + favorite.getCompanyName() +
					",'" + favorite.getCity() + ",'" + favorite.getSize() + ",'" + favorite.getSector() + ",'" + favorite.getWebSite() +
					",'"  + favorite.getContactMail() + "')");

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return returnMark;	
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
			//TODO SQLException deleteFavorite(String companyName)
		}
		return companyName;
	}

	//To  dsplay the result

	public Favorites lstFavorite()
	{
		Favorites favorites = new Favorites();

		String sql		=	"select city , size, sector, webSite, contactMail from company";
		ResultSet rs	=	null;

		try
		{
			rs = (ResultSet) stmt.executeQuery(sql)	;				
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
				int idNoteUser			= rs.getInt("note");

				//Search if note is null
				NoteCompany note = null;

				//New statement for this 
				Statement stmtNote 	= conn.createStatement();
				String sqlNote		= "select lblNote from noteUser where idNote = " + idNoteUser ; 
				ResultSet rsNoteUser = stmtNote.executeQuery(sqlNote);
				while (rsNoteUser.next())
				{
					String lblNote = rsNoteUser.getString(1);
					note = new NoteCompany(lblNote);
				}

				//Create object
				Favorite noteBook = new Favorite(city, size, sector, webSite, contactMail, note);
				favorites.add(noteBook);
			}
		}catch (SQLException e)
		{
			System.out.println("FavoriteDao : lstFavorite() - erreur sur favori");
			e.printStackTrace();
		}
		return favorites;
	}

}
