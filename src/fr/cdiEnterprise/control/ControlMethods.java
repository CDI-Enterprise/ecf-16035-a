package fr.cdiEnterprise.control;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Methods for the control package
 * @version 16-10-2016
 * @author Claire
 */
public class ControlMethods {

	/**
	 * Takes a group of JRadioButton and searches which one is selected to return it.
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
	
//	public static String nullJTextField(String field){
		//TODO méthode pour controler si un textfield est null @Anaïs
//	}
	
	
	
}