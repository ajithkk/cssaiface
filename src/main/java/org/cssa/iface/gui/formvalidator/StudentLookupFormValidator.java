package org.cssa.iface.gui.formvalidator;

import org.cssa.iface.gui.lookup.StudentLookupView;

public class StudentLookupFormValidator extends ValidateUtil {
	
	private StudentLookupView lookupView;
	private String message;
	
	public StudentLookupFormValidator() {
		super();
	}
	
	public StudentLookupFormValidator(StudentLookupView lookupView) {
		this.lookupView = lookupView;
		message = null;
	}

	@Override
	public boolean validateForm() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean allFieldsEmpty() {
		if(isEmpty(lookupView.getCollegeId()) & isEmpty(lookupView.getStudentId()) & isEmpty(lookupView.getStudentName())) {
			return true;
		}
		return false;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	

	/**
	 * @return the lookupView
	 */
	public StudentLookupView getLookupView() {
		return lookupView;
	}

	/**
	 * @param lookupView the lookupView to set
	 */
	public void setLookupView(StudentLookupView lookupView) {
		this.lookupView = lookupView;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
