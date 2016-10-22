/**
 * 
 */

package fr.cdiEnterprise.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.cdiEnterprise.view.BookMarkPanel;
import fr.cdiEnterprise.model.*;

/**
 *13 oct. 2016
 * @author Ismael
 *ecf-16035-a
 *10:26:16
 */

public class BookMarkListener implements ActionListener
{
	private BookMarkPanel bookMarkPanel;
	
	

	public BookMarkListener(BookMarkPanel bookMarkPanel)
	{
		//TODO (Ismaël)
		this.bookMarkPanel = bookMarkPanel;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	
	
	

	//ActionListener
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == bookMarkPanel.getCmdBookMarkDelete())
		{
			
		}
		// TODO (Ismaël) Auto-generated method stub
		
	}

}
