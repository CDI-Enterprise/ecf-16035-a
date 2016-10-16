package fr.cdiEnterprise.control;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class ControlMethods {

	/**
	 * Takes a group of JRadioButton and searches which one is selected to return it.
	 * @param jrButtonGrp
	 * @return jrButtonSelected
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
	
}
