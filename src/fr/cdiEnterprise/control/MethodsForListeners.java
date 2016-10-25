package fr.cdiEnterprise.control;

import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import fr.cdiEnterprise.dao.DataBaseCompany;
import fr.cdiEnterprise.exceptions.CompanyCreationException;
import fr.cdiEnterprise.model.Company;
import fr.cdiEnterprise.view.company.CompanyCreationPanel;

/**
 * Methods for the control package
 * 
 * @version 16-10-2016
 * @author Claire
 */
public class MethodsForListeners {

	/**
	 * Takes a group of JRadioButton and searches which one is selected to
	 * return it.
	 * 
	 * @author Claire
	 * @param jrButtonGrp
	 * @return jrButtonSelected
	 * @since 16-10-2016
	 */
	public static JRadioButton getSelectedJRadioButton(ButtonGroup jrButtonGrp) {

		JRadioButton jrButtonSelected = null;

		for (Enumeration<AbstractButton> e = jrButtonGrp.getElements(); e.hasMoreElements();) {

			JRadioButton jrButton = (JRadioButton) e.nextElement();

			if (jrButton.getModel() == jrButtonGrp.getSelection()) {

				jrButtonSelected = jrButton;
				break;
			}
		}

		return jrButtonSelected;
	}

	/**
	 * Takes an ArrayList of JTextField to clear and re-enabled all of them.
	 * 
	 * @author Claire
	 * @param allJTextFields
	 * @since 16-10-2016
	 */
	public static void resetJTextField(ArrayList<JTextField> allJTextFields) {

		for (Component c : allJTextFields) {

			if (c instanceof JTextField) {

				JTextField textfield = (JTextField) c;
				textfield.setText(null);
				textfield.setEnabled(true);
			}
		}
	}

	/**
	 * Méthode pour controler la saisie des champs obligatoires
	 * 
	 * @author Anaïs
	 * @param String
	 *            (txtField)
	 * @return
	 * @return
	 * @since 21-10-2016
	 */

	public static String nullField(String txtField) {

		String field = txtField;
		int fieldLength = field.length();
		String fieldReturn;

		if (fieldLength != 0) {
			fieldReturn = field;
		} else {
			throw new CompanyCreationException();
		}
		return fieldReturn;
	}

	public static void refreshListCompanies() throws SQLException{
		CompanyCreationPanel.getDlmCompanies().clear();
		for(Company company : DataBaseCompany.getCompaniesData()){
			CompanyCreationPanel.getDlmCompanies().addElement(company);
		}
	}
}
