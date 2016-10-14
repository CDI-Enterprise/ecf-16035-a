/**
 * 
 */
package fr.cdiEnterprise.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import fr.cdiEnterprise.dao.Datas;
import fr.cdiEnterprise.model.Company;
import net.miginfocom.swing.MigLayout;

/**
 *12 oct. 2016
 * @author Ismael
 *ecf-16035-a
 *21:48:53
 */

public class BookMarkPanel extends JPanel 
{

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private JButton cmdBookMark;			//



	//Panel
	private JPanel northPan;
	private JPanel westPan;
	private JPanel centerPan;


	//North
	private JLabel lblFieldInfo;			//Title of panel

	//West

	private JPanel jListBookMarkPan;

	private DefaultListModel<Company> mdlListCompany;		//List model
	private JList <Company> bookMarkChoosen;				//List of enterprise recorded
	private JScrollPane	panListCompany;						//Add scrollbar to the JList

	private JButton cmdBookMarkDelete;						//Button for delete a favorites


	//Center

	private JTable bookMarkResult;							//Info Company


	public BookMarkPanel()
	{
		//Main
		this.setLayout(new BorderLayout(20,20));

		//North
		northPan = new JPanel();
		northPan.setLayout(new FlowLayout());
		this.add(northPan, BorderLayout.NORTH);

		lblFieldInfo = new JLabel("Mes Favoris");
		lblFieldInfo.setFont(new Font(getName(), Font.CENTER_BASELINE, 14));
		northPan.add(lblFieldInfo);
		northPan.setBorder(BorderFactory.createLineBorder(Color.BLUE));

		//West

		westPan = new JPanel();
		westPan.setLayout(new MigLayout());
		westPan.setBorder(new EmptyBorder(0, 5, 0, 0));
		this.add(westPan, BorderLayout.WEST);

		//JList Company 
		jListBookMarkPan = new JPanel();
		jListBookMarkPan.setLayout(new MigLayout());
		jListBookMarkPan.setBorder(BorderFactory.createTitledBorder("MA LISTE D'ENTREPRISE"));
		westPan.add(jListBookMarkPan, "wrap, w 400!");

		mdlListCompany = new DefaultListModel<Company>();							//Create model of BookMarkList
		JList<Company> lstBookMarkCompany = new JList<Company>(mdlListCompany);
		if(Datas.getCompaniesList() != null) {
			for (Company user : Datas.getCompaniesList()) {
				if(user != null) {
					mdlListCompany.addElement(user);
								 }
						}
				}
		panListCompany = new JScrollPane(lstBookMarkCompany);						//Add scrollpane to jlist
		jListBookMarkPan.add(panListCompany);										//Add to panel in windows

		
		//Center
		
		centerPan = new JPanel();

		
	}











	/**
	 * @return the mdlListCompany
	 */
	public DefaultListModel<Company> getMdlListCompany() {
		return mdlListCompany;
	}


	/**
	 * @return the cmdBookMark
	 */
	public JButton getCmdBookMark() 
	{
		return cmdBookMark;
	}



}
