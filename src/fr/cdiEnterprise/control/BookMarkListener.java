/**
 * 
 */

package fr.cdiEnterprise.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import fr.cdiEnterprise.view.BookMarkPanel;

import fr.cdiEnterprise.view.company.CompaniesSRPanel;
import fr.cdiEnterprise.view.company.CompanyDeletUpdatPanel;
//import fr.cdiEnterprise.model.Contact;
import fr.cdiEnterprise.model.Favorite;
//import fr.cdiEnterprise.model.NoteCompany;
//import fr.cdiEnterprise.dao.DataBaseCompany;
//import fr.cdiEnterprise.model.NoteCompany;
import fr.cdiEnterprise.dao.FavoriteDao;
//import fr.cdiEnterprise.service.Favorites;

/**
 *13 oct. 2016
 * @author Ismael
 *ecf-16035-a
 *10:26:16
 */

public class BookMarkListener implements ActionListener
{

	private String searchNameCompany;
	//private int idCompany;
	private int idFavorite;
	private String companyName;
	private String companyCity;
	private String companySize;
	private String companySector;
	private String companyWebSite;
	private String contactMail;	
	private String noteCompany;

	private BookMarkPanel panFavorite = null;			//Attribute
	private FavoriteDao favoriteDao;
	private JDialog Confirmation;


	public BookMarkListener(BookMarkPanel FavoriteCompany)
	{
		this.panFavorite = FavoriteCompany;
		favoriteDao = new FavoriteDao();
	}

	//	public BookMarkListener(CompaniesSRPanel FavoritesCompany)
	//	{
	//		this.panFavorites = FavoritesCompany;
	//		favoriteDao = new FavoriteDao();
	//	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */

	//ActionListener
	@Override
	public void actionPerformed(ActionEvent e) 
	{

		if (panFavorite instanceof fr.cdiEnterprise.view.BookMarkPanel)
		{
			BookMarkPanel mark = (BookMarkPanel) panFavorite;								//Instance mark whatever click button

			if (e.getSource() == mark.getBtnBookMarkSee())  btnSee_click(mark);
			if (e.getSource() == mark.getBtnBookMarkDelete())
				try 
			{
					btnDelete_click(mark);
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			if (e.getSource() == mark.getBtnSaveNote()) btnSave_click(mark);
			if (e.getSource() == mark.getBtnSearchBookMark()) btnSearch_click(mark);
			if (e.getSource() == mark.getBtnGoCompanySheet()) btnGoCompany_click(mark);
		}
		//		else if (panFavorites instanceof fr.cdiEnterprise.view.company.CompaniesSRPanel)	//if cmbBookMarkValidate clicked
		//		{
		//			CompaniesSRPanel mark2 = (CompaniesSRPanel) panFavorites;
		//			if (e.getSource() == mark2.getBtnFavoris()) btnValidate_click(mark2);		
		//
		//		}
		else System.out.println("BookMarkListener - Error IHM");	 					//else message error
	}


	/*
	 * Listener to favorite's button
	 * 
	 */

	/**
	 * Remove company name to the list
	 * @param mark
	 * @param CompanyName
	 */
	private void btnSee_click(BookMarkPanel mark) 
	{
		//TODO SEE



		//Favorites favorites = see.lstFavorite();
		//BookMarkPanel viewSee = new BookMarkPanel();
		//		viewSee.setvi
	}



	/**
	 * Remove company name to the list
	 * @param mark
	 * @param CompanyName
	 */
	private void btnDelete_click(BookMarkPanel mark) throws SQLException 
	{
		JOptionPane.showConfirmDialog(Confirmation, "Vous allez supprimer un favori");
		String companyName = mark.getLstMyFavorites().getSelectedItem().toString();
		favoriteDao.deleteFavorite(companyName);
	}


	/**
	 * Save note's user in bdd
	 * @param mark
	 */
	private void btnSave_click(BookMarkPanel mark) 				
	{
		String noteCompany	=	mark.getTxtNoteUser().getText();

		//Create note's object 
		Favorite companyMark = new Favorite(idFavorite, noteCompany);			

		//Send the add
		favoriteDao.addFavorite(companyMark);
	}


	/**
	 * Search company name into the list
	 * @param mark
	 */
	private void btnSearch_click(BookMarkPanel mark) 		
	{
		searchNameCompany = mark.getTxtSearchBookMark().getText();

	}

	//lstMyFavorites

	/**
	 * To go in Company panel choosen
	 * @param mark
	 */
	private void btnGoCompany_click(BookMarkPanel mark) 
	{
		CompanyDeletUpdatPanel goToCompany;
		try 
		{
			JOptionPane.showConfirmDialog(Confirmation, "Vous allez voir la fiche complète, aurevoir");
			goToCompany = new CompanyDeletUpdatPanel();
			goToCompany.setVisible(true);
			//this.dispose();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
