package org.cssa.iface.gui.events;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.BorderFactory;


import org.cssa.iface.bo.Events;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.formvalidator.ValidateUtil;
import org.cssa.iface.gui.util.ErrorDialog;
import org.cssa.iface.gui.util.MessageUtil;
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
			new ErrorDialog(e).setVisible(true);
			//e.printStackTrace();
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
				//clearEventView();
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
		String FILE = Util.getReportHome()+"\\EventReport.pdf";
		List<Events> events = eventTableModel.getEventList();
		if(null != events) {
			EventReport report = new EventReport(FILE, events);
			try {
				report.createReport();
			} catch (FileNotFoundException e) {
				new ErrorDialog(e).setVisible(true);
			} catch (DocumentException e) {
				new ErrorDialog(e).setVisible(true);
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
				new ErrorDialog(e).setVisible(true);
			}
		}
		
		
	}
	private void performEdit() {
		if(validateForm()) {
			Events events = new Events();
			events.setEventId(eventsView.getEventCode());
			events.setEventName(eventsView.getEventName());
			events.setMaxNoOfParticipants(Integer.valueOf(eventsView.getMaxParticipants()));
			events.setPoints(Integer.valueOf(eventsView.getPoints()));
			try {
				eventsTransaction.update(events);
				eventTableModel.setEventList(eventsTransaction.loadAll());
				clearEventView();
			} catch (Exception e) {
				new ErrorDialog(e).setVisible(true);
			}
		}
		
	}
	/**
	 * method to perform save action
	 */
	private void performEventSaveAction() {
		if(validateForm()) {
			Events events = new Events();
			events.setEventId(eventsView.getEventCode());
			events.setEventName(eventsView.getEventName());
			events.setMaxNoOfParticipants(Integer.valueOf(eventsView.getMaxParticipants()));
			events.setPoints(Integer.valueOf(eventsView.getPoints()));
			try {
				eventsTransaction.save(events);
				eventTableModel.setEventList(eventsTransaction.loadAll());
				clearEventView();
			} catch (Exception e) {
				new ErrorDialog(e).setVisible(true);
			}
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
		eventsView.getTxtEventcode().setEditable(true);
		
	}
	/**
	 * method to ask eventView form
	 */
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
		eventsView.getTxtEventcode().setEditable(false);
	}
	
	private boolean validateForm() {
		boolean success = false;
		if(ValidateUtil.isNumber(eventsView.getMaxParticipants())) {
			eventsView.getTxtMaxParticipants().setBorder(BorderFactory.createLineBorder(Color.gray));
			success = true;
		} else {
			eventsView.getTxtMaxParticipants().setBorder(BorderFactory.createLineBorder(Color.red));
			new MessageUtil(mdiForm).showErrorMessage("Invalid Number", eventsView.getMaxParticipants()+ "Is not a number.This fiels only contain Integers");
			return false; 
		}
		
		if(ValidateUtil.isNumber(eventsView.getPoints())) {
			eventsView.getTxtPoints().setBorder(BorderFactory.createLineBorder(Color.gray));
			success = true;
		}else {
			eventsView.getTxtPoints().setBorder(BorderFactory.createLineBorder(Color.red));
			new MessageUtil(mdiForm).showErrorMessage("Invalid Number", eventsView.getPoints()+ "Is not a number.This fiels only contain Integers");
			return false;
		}
		return success;
	}
}
