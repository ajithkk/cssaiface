package org.cssa.iface.gui.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import org.cssa.iface.bo.Events;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.transaction.EventsTransaction;

/**
 * 
 * @author ajith
 * @since 1/27/2012
 */

public class EventsController implements ActionListener  {
	
	EventsView eventsView = null;
	EventTableModel eventTableModel = null;
	private CssaMDIForm mdiForm;
	private boolean editFlag;
	
	private EventsTransaction eventsTransaction = null;
	
	public EventsController() {
		eventTableModel = new EventTableModel(); 
		editFlag = false;
	}
	public EventsController(CssaMDIForm mdiForm) {
		this.mdiForm = mdiForm;
		editFlag = false;
		eventsTransaction = new EventsTransaction();
		try {
			eventTableModel = new EventTableModel(eventsTransaction.loadAll());
		} catch (IfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command =  e.getActionCommand();
		if(EventsView.CANCEL.equals(command)) {
			mdiForm.closeFrame();
		}
		if(EventsView.CLEAR.equals(command)) {
			clearEventView();
		}
		if(EventsView.SAVE.equals(command)) {
			if(editFlag) {
				editFlag = false;
				performEdit();
			}else {
				performEventSaveAction();
				clearEventView();
			}
		}
		if(EventsView.DELETE.equals(command)) {
			eventsView.setEventCode("Delete Clicked");
		}
		
		if(EventsView.EDIT.equals(command)) {
			editFlag = true;
			performEditAction();
		}
		if(EventsView.PRINT.equals(command)) {
			eventsView.setEventCode("Print Clicked");
		}
		
	}
	
	private void performEdit() {
		Events events = new Events();
		events.setEventId(eventsView.getEventCode());
		events.setEventName(eventsView.getEventName());
		events.setMaxNoOfParticipants(Integer.valueOf(eventsView.getMaxParticipants()));
		events.setPoints(Integer.valueOf(eventsView.getPoints()));
		try {
			//eventTableModel.addRow(events);
			eventsTransaction.update(events);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void performEventSaveAction() {
		Events events = new Events();
		events.setEventId(eventsView.getEventCode());
		events.setEventName(eventsView.getEventName());
		events.setMaxNoOfParticipants(Integer.valueOf(eventsView.getMaxParticipants()));
		events.setPoints(Integer.valueOf(eventsView.getPoints()));
		try {
			eventTableModel.addRow(events);
			eventsTransaction.save(events);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public void performEditAction() {
		int rowSelected = eventsView.getEventTable().getSelectedRow();
		Events events = eventTableModel.getEventList().get(rowSelected);
		eventsView.setEventCode(events.getEventId());
		eventsView.setEventName(events.getEventName());
		eventsView.setMaxParticipants(String.valueOf(events.getMaxNoOfParticipants()));
		eventsView.setPoints(String.valueOf(events.getPoints()));
	}
}