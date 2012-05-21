/**
 * 
 */
package org.cssa.iface.gui.events;

import static org.cssa.iface.infrastructure.CSSAConstants.EVENT_DETAILS_COLUMN_NAMES;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import org.cssa.iface.bo.EventDetails;


/**
 * @author ajith
 * @since 1/27/2012
 */
public class EventTableModel extends AbstractTableModel {
	
	private List<EventDetails> eventList = new ArrayList<EventDetails>();
	
	public EventTableModel() {
	}
	public EventTableModel(List<EventDetails> eventList) {
		this.eventList = eventList;
	}
	
	public void addRow(EventDetails details) {
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
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		EventDetails event = eventList.get(rowIndex);
		return event;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

}
