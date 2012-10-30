package org.cssa.iface.gui.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;


import org.cssa.iface.bo.Events;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.report.event.EventReport;
import org.cssa.iface.transaction.EventsTransaction;
import org.cssa.iface.util.Util;

import com.itextpdf.text.DocumentException;

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
			performDeleteAction();
		}
		
		if(EventsView.EDIT.equals(command)) {
			editFlag = true;
			performEditAction();
		}
		if(EventsView.PRINT.equals(command)) {
			performPrintAction();
		}
		
	}
	
	private void performPrintAction() {
		String FILE = Util.getReportHome()+"\\EventREport.pdf";
		List<Events> events = eventTableModel.getEventList();
		if(null != events) {
			EventReport report = new EventReport(FILE, events);
			try {
				report.createReport();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	private void performDeleteAction() {
		int rowSelected = eventsView.getEventTable().getSelectedRow();
		Events events = eventTableModel.getEventList().get(rowSelected);
		if(null != events) {
			try {
				eventsTransaction.delete(events);
				eventTableModel.setEventList(eventsTransaction.loadAll());
			} catch (IfaceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
