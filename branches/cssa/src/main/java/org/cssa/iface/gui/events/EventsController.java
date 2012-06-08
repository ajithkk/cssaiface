package org.cssa.iface.gui.events;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.college.CollegeDetilsView;

/**
 * 
 * @author ajith
 * @since 1/27/2012
 */

public class EventsController implements ActionListener  {
	
	EventsView eventsView = null;
	EventTableModel eventTableModel = null;
	private CssaMDIForm mdiForm;
	
	public EventsController() {
		eventTableModel = new EventTableModel(); 
	}
	public EventsController(CssaMDIForm mdiForm) {
		this.mdiForm = mdiForm;
		eventTableModel = new EventTableModel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command =  e.getActionCommand();
		if(EventsView.CANCEL.equals(command)) {
			eventsView.setEventCode("Cancel Clicked");
		}
		if(EventsView.CLEAR.equals(command)) {
			clearEventView();
		}
		if(EventsView.SAVE.equals(command)) {
			eventsView.setEventCode("Save Clicked");
		}
		if(EventsView.DELETE.equals(command)) {
			eventsView.setEventCode("Delete Clicked");
		}
		
		if(EventsView.EDIT.equals(command)) {
			eventsView.setEventCode("Edit Clicked");
		}
		if(EventsView.PRINT.equals(command)) {
			eventsView.setEventCode("Print Clicked");
		}
		
	}
	
	/**
	 * Clear EventView TextFiels Data
	 */
	private void clearEventView() {
		eventsView.setEventCode("");
		eventsView.setEventName("");
		eventsView.setMaxParticipants("");
		eventsView.setPoints("");
		
	}

	public  void askEventView() {
		eventsView = new EventsView(this,eventTableModel,mdiForm);
		eventsView.showEventscreen();
		
	}
}
