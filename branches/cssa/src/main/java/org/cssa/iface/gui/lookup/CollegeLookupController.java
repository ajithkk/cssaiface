/**
 * 
 */
package org.cssa.iface.gui.lookup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.cssa.iface.gui.formvalidator.CollegeLookupFormValidator;
import org.cssa.iface.services.CollegeDetailsQueryEngine;

/**
 * @author ajith
 *
 */
public class CollegeLookupController implements ActionListener {
	
	CollegeLookupView lookupView;
	CollegeLookupFormValidator validator;
	CollegeDetailsQueryEngine engine;
	CollegeLookupTableModel tableModel;
	
	/**
	 * default constructor
	 */
	public CollegeLookupController() {
		validator = new CollegeLookupFormValidator();
		tableModel = new CollegeLookupTableModel();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if(CollegeLookupView.SEARCH.equals(action)) {
			if(validator.allFieldsEmpty()){
				
			}
		}
		if(CollegeLookupView.CANCEL.equals(action)) {
			
		}
		if(CollegeLookupView.CLEAR.equals(action)) {
			clearCollegeLookupView();
		}
		
		
	}
	/**
	 * clear the college look view
	 */
	public void clearCollegeLookupView() {
		lookupView.setCollegeId("");
		lookupView.setCollegeName("");
	}
	
	/**
	 * method to ask college lookup view 
	 */
	public void askCollegeLookupView() {
		lookupView = new CollegeLookupView(this,tableModel);
		
	}

}
