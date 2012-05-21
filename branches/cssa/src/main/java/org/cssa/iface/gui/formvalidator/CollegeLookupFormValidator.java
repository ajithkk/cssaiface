/**
 * 
 */
package org.cssa.iface.gui.formvalidator;

import org.cssa.iface.gui.lookup.CollegeLookupView;

/**
 * @author ajith
 *
 */
public class CollegeLookupFormValidator  extends ValidateUtil {
	
	private CollegeLookupView lookupView;
	private String message;
	/**
	 * @param lookupView
	 */
	public CollegeLookupFormValidator(CollegeLookupView lookupView) {
		super();
		this.lookupView = lookupView;
		this.message = null;
	}
	/**
	 * 
	 */
	public CollegeLookupFormValidator() {
		super();
		this.message = null;
	}
	@Override
	public boolean validateForm() {
		if(isEmpty(lookupView.getCollegeId())){
			message = "Enter college Id";
			return false;
		}
		if(isEmpty(lookupView.getCollegeName())) {
			message = "Enter College Name";
			return false;
		}
		return true;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 
	 * @return true all fields are empty otherwise false
	 */
	public boolean allFieldsEmpty() {
		if(isEmpty(lookupView.getCollegeId())&isEmpty(lookupView.getCollegeName())) {
			return true;
		}
		return false;
	}
	
	

}
