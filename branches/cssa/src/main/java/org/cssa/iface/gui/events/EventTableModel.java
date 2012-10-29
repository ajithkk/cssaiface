/**
 * 
 */
package org.cssa.iface.gui.events;

import static org.cssa.iface.infrastructure.CSSAConstants.EVENT_DETAILS_COLUMN_NAMES;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.cssa.iface.bo.Events;


/**
 * @author ajith
 * @since 1/27/2012
 */
public class EventTableModel extends AbstractTableModel {
	
	private List<Events> eventList = new ArrayList<Events>();
	
	public EventTableModel() {
	}
	public EventTableModel(List<Events> eventList) {
		this.eventList = eventList;
	}
	
	public void addRow(Events details) {
		if(eventList.size() > 0) {
			details.setSno(eventList.get(eventList.size()-1).getSno()+1);
		}else {
			details.setSno(1);
		}
		eventList.add(details);
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return eventList.size();
	}

	@Override
	public int getColumnCount() {
		
		return EVENT_DETAILS_COLUMN_NAMES.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		
		return  EVENT_DETAILS_COLUMN_NAMES.length >= columnIndex ? EVENT_DETAILS_COLUMN_NAMES[columnIndex]: "COLUMN"+columnIndex;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if(0 == columnIndex || 3 == columnIndex || 4 == columnIndex ) {
			return Integer.class;
		}
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Events event = eventList.get(rowIndex);
		if(columnIndex == 0) {
			return event.getSno();
		} else if (columnIndex == 1) { 
			return event.getEventId();
		} else if (columnIndex == 2) {
			return event.getEventName();
		} else if (3 == columnIndex) {
			return event.getMaxNoOfParticipants();
		} else if (4 == columnIndex) {
			return event.getPoints();
		}
		
		return "";
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}
	public List<Events> getEventList() {
		return eventList;
	}
	public void setEventList(List<Events> eventList) {
		this.eventList = eventList;
	}

}
