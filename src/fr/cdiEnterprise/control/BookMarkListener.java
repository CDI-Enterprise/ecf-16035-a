/**
 * 
 */

package fr.cdiEnterprise.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.cdiEnterprise.view.BookMarkPanel;
import fr.cdiEnterprise.view.CompanyCreationPanel;
import fr.cdiEnterprise.view.CompanyFrameAllCompanies;
//import fr.cdiEnterprise.model.Contact;
import fr.cdiEnterprise.model.Favorite;
//import fr.cdiEnterprise.model.NoteCompany;
import fr.cdiEnterprise.dao.FavoriteDao;
import fr.cdiEnterprise.service.Favorites;

/**
 *13 oct. 2016
 * @author Ismael
 *ecf-16035-a
 *10:26:16
 */

public class BookMarkListener implements ActionListener
{
	private BookMarkPanel panFavorite = null;			//Attribute
	//private Company FavoritesCompany = null;
	private FavoriteDao favoriteDao;
	private CompanyCreationPanel panFavorites;



	public BookMarkListener(BookMarkPanel FavoriteCompany)
	{
		this.panFavorite = FavoriteCompany;
		favoriteDao = new FavoriteDao();
	}

	public BookMarkListener(CompanyCreationPanel FavoritesCompany)
	{
		this.panFavorites = FavoritesCompany;
		favoriteDao = new FavoriteDao();
	}

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
			if (e.getSource() == mark.getBtnBookMarkDelete()) btnDelete_click(mark);
			if (e.getSource() == mark.getBtnSaveNote()) btnSave_click(mark);
			if (e.getSource() == mark.getBtnSearchBookMark()) btnSearch_click(mark);
			if (e.getSource() == mark.getBtnGoCompanySheet()) btnGoCompany_click(mark);
		}
		else if (panFavorites instanceof fr.cdiEnterprise.view.CompanyCreationPanel)	//if cmbBookMarkValidate clicked
		{
			CompanyCreationPanel mark2 = (CompanyCreationPanel) panFavorites;
			if (e.getSource() == mark2.getBtnFavoris()) btnValidate_click(mark2);		

		}
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
	 * Validate company name to view in text area
	 * @param mark2
	 * 
	 */
	private void btnValidate_click(CompanyCreationPanel mark2) 						//Recover informations
	{

		// TODO listener sql request Viewing Detail to select Company


		//	int idCompany		=Integer.parseInt(mark2.getTxtidCompany().getText());
		String nameCompany	= mark2.getTxtCompanyCity().getText();
		String cityCompany	= mark2.getTxtCompanyCity().getText();

		//A revoir pour "catch" taille
		String sizeCompany	= mark2.getLblSize().getText();	
		//Fin du a revoir
		String sectorCompany	= mark2.getTxtSector().getText();
		String webSiteCompany	= mark2.getTxtWebSite().getText();
		//Contact contactMailCompany	= mark2.getTxtContactMail().getName();

		//Create a favorite's object

		Favorite favoriteCompany = new Favorite(nameCompany, null, cityCompany, sizeCompany, sectorCompany, webSiteCompany, null);

		//Send the add
		favoriteDao.addFavorite(favoriteCompany);
	}

	/**
	 * Remove company name to the list
	 * @param mark
	 * @param CompanyName
	 */
	private void btnDelete_click(BookMarkPanel mark) 
	{
		String companyName = mark.getLstMyFavorites().getSelectedItem().toString();
		favoriteDao.deleteFavorite(companyName);	
	}


	/**
	 * Save note's user in bdd
	 * @param mark
	 */
	private void btnSave_click(BookMarkPanel mark) 				
	{
		// TODO class  noteSave of company
		String noteCompany	=	mark.getTxtNoteUser().getText();

		//Create note's object 
		Favorite companyMark = new Favorite(noteCompany);			

		//Send the add
		favoriteDao.addFavorite(companyMark);
	}


	/**
	 * Search company name into the list
	 * @param mark
	 */
	private void btnSearch_click(BookMarkPanel mark) 		
	{

		// TODO listener sql request search a company

	}

	/**
	 * To go in Company panel choosen
	 * @param mark
	 */
	private void btnGoCompany_click(BookMarkPanel mark) 
	{
		CompanyFrameAllCompanies goToCompany = new CompanyFrameAllCompanies();
		goToCompany.setVisible(true);
		//this.dispose();
		// TODO listener sql request go to sheet company selected

	}


}
