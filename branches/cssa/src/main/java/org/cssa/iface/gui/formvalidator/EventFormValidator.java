package org.cssa.iface.gui.formvalidator;

import org.cssa.iface.gui.events.EventsView;
/**
 * 
 * @author ajith
 * @since 2/1/2012
 */

public class EventFormValidator  extends ValidateUtil{
	
	private EventsView eventsView ;
	private String message;
	

	/**
	 * @param eventsView
	 */
	public EventFormValidator(EventsView eventsView) {
		super();
		this.eventsView = eventsView;
		message = null;
	}
	
	public EventFormValidator() {
		message = null;
	}
	
	/**
	 * 
	 * @return true if all the fields are correct otherwise false and set appropriate message
	 */
	@Override
	public boolean validateForm() {
		if(isEmpty(eventsView.getEventName())) {
			message = "Enter a Event Name";
			return false;
		}
		if(isEmpty(eventsView.getEventCode())) {
			message = "Enter a Event Code Name ";
			return false;
		}
		if(isEmpty(eventsView.getMaxParticipants())) {
			message = "Enter Maximun number of participants";
			return false;
		}else if(isNumber(eventsView.getMaxParticipants())) {
			message = eventsView.getMaxParticipants() +" Is not a number";
			return false;
		}
		if( isEmpty(eventsView.toString())) {
			message = "Enter Event Points";
			return false;
		}else if(isNumber(eventsView.getPoints())) {
			message = eventsView.getPoints() +" Is not a number";
			return false;
		}
		
		return true;
		
	}
	/**
	 * 
	 * @return error message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * 
	 * @param message set the error message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	

	

}
