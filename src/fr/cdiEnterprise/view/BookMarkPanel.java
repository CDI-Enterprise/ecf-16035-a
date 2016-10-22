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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import fr.cdiEnterprise.control.BookMarkListener;
import fr.cdiEnterprise.dao.OldDatas;
import fr.cdiEnterprise.model.Company;
import fr.cdiEnterprise.model.Favorite;
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

	private JButton cmdBookMark;			//Button Favoris to CompanyCreationPanel



	//Panel
	private JPanel northPan;
	private JPanel westPan;
	private JPanel centerPan;


	//North
	private JLabel lblFieldInfo;			//Title of panel

	//West

	private JPanel jListBookMarkPan;

	private DefaultListModel<Favorite> mdlListCompany;		//List model
	private JList<Favorite> bookMarkChoosen;				//List of enterprise recorded
	private JScrollPane	panListCompany;						//Add scrollbar to the JList

	private JButton cmdBookMarkValidate;					//Button for show a company
	private JButton cmdBookMarkDelete;						//Button for delete a favorites


	//Center

	private JPanel listCompanyResultPan;
	private DefaultTableModel mdlListRsult;			//Detailed information on the company
	private JTable bookMarkResult;					//Info Company
	//private JList<Company> lstCompanyMarked;
	private JScrollPane panListCompanyMarked;


	/**
	 * 
	 */
	public BookMarkPanel()
	{
		//Main
		this.setLayout(new BorderLayout(20,20));

		//North
		northPan = new JPanel();
		northPan.setLayout(new FlowLayout());
		this.add(northPan, BorderLayout.NORTH);

		//Windows title
		lblFieldInfo = new JLabel("Mes Favoris");						
		lblFieldInfo.setFont(new Font(getName(), Font.CENTER_BASELINE, 14));
		northPan.add(lblFieldInfo);
		northPan.setBorder(BorderFactory.createLineBorder(Color.RED));

		//West

		westPan = new JPanel();
		westPan.setLayout(new MigLayout());
		westPan.setBorder(new EmptyBorder(0, 5, 0, 0));
		this.add(westPan, BorderLayout.WEST);

		//JList Company 
		jListBookMarkPan = new JPanel();
		jListBookMarkPan.setLayout(new MigLayout("fill, wrap 2"));
		jListBookMarkPan.setBorder(BorderFactory.createTitledBorder("MA LISTE D'ENTREPRISE"));
		westPan.add(jListBookMarkPan, "wrap, w 550!");

		//TODO (Ismaël) remplace it with a ComboBox

		mdlListCompany = new DefaultListModel<Favorite>();							//Create model of BookMarkList

		JList<Favorite> lstBookMarkCompany = new JList<Favorite>(mdlListCompany);
		lstBookMarkCompany.setVisibleRowCount(5);
		if(OldDatas.getCompaniesList() != null) {
			for (Favorite favorite : OldDatas.getFavoritesList()) {
				if(favorite != null) {
					mdlListCompany.addElement(favorite);
				}
			}
		}
		panListCompany = new JScrollPane(lstBookMarkCompany);						//Add scrollpane to jlist
		jListBookMarkPan.add(panListCompany);										//Add to panel in windows

		//Button 

		cmdBookMarkValidate = new JButton("Voir");
//		cmdBookMarkValidate.setLayout(null);
//		cmdBookMarkValidate.setBounds(0, 500, 100, 100);
		
//		cmdBookMarkValidate.setAlignmentX(CENTER_ALIGNMENT);
//		cmdBookMarkValidate.setAlignmentY(LEFT_ALIGNMENT);
		westPan.add(cmdBookMarkValidate,"grow, span 2 2");
		
		cmdBookMarkDelete = new JButton("Supprimer");
//		cmdBookMarkDelete.setAlignmentX(CENTER_ALIGNMENT);
//		cmdBookMarkDelete.setAlignmentY(RIGHT_ALIGNMENT);
		westPan.add(cmdBookMarkDelete, "grow, span 2 2");


		//Center

		centerPan = new JPanel();
		centerPan.setLayout(new FlowLayout());
		centerPan.setBorder(new EmptyBorder(0, 0, 0, 5));
		this.add(centerPan, BorderLayout.CENTER);

		listCompanyResultPan = new JPanel();
		listCompanyResultPan.setLayout(new MigLayout());
		listCompanyResultPan.setBorder(BorderFactory.createTitledBorder("Détail sur l'Entreprise"));
		centerPan.add(listCompanyResultPan);

		mdlListRsult = new DefaultTableModel();
		bookMarkResult= new JTable(mdlListRsult);

		//TODO (Ismaël) LOOP


		panListCompanyMarked = new JScrollPane(bookMarkResult);
		listCompanyResultPan.add(panListCompanyMarked);




		//LISTENER
		BookMarkListener listener = new BookMarkListener(this);					//Creation of actionListener 
		cmdBookMarkValidate.addActionListener(listener);
		cmdBookMarkDelete.addActionListener(listener);


	}



	/**
	 * @return the mdlListCompany
	 */
	public DefaultListModel<Favorite> getMdlListCompany() {
		return mdlListCompany;
	}

	/**
	 * @return the cmdBookMarkValidate
	 */
	public JButton getCmdBookMarkValidate() {
		return cmdBookMarkValidate;
	}

	/**
	 * @return the cmdBookMarkDelete
	 */
	public JButton getCmdBookMarkDelete() {
		return cmdBookMarkDelete;
	}

	/**
	 * @return the cmdBookMark
	 */
	public JButton getCmdBookMark() 
	{
		return cmdBookMark;
	}



}
