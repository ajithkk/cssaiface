/**
 * 
 */
package org.cssa.iface.gui.database;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.cssa.iface.bo.EventDetails;

import static org.cssa.iface.infrastructure.CSSAConstants.EVENT_DETAILS_TABLE_COLUMN_NAMES;

/**
 * @author ajith
 *
 */
public class EventDetailsTableModel extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2408432074513241479L;
	private List<EventDetails> eventDetails;

	/**
	 * @return the eventDetails
	 */
	public List<EventDetails> getEventDetails() {
		return eventDetails;
	}

	/**
	 * @param eventDetails the eventDetails to set
	 */
	public void setEventDetails(List<EventDetails> eventDetails) {
		this.eventDetails = eventDetails;
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return eventDetails.size();
	}

	@Override
	public int getColumnCount() {
		return EVENT_DETAILS_TABLE_COLUMN_NAMES.length;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return  EVENT_DETAILS_TABLE_COLUMN_NAMES.length >= columnIndex ? EVENT_DETAILS_TABLE_COLUMN_NAMES[columnIndex]: "COLUMN"+columnIndex;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		EventDetails details = eventDetails.get(rowIndex);
		switch(columnIndex) {
			case 0: return details.getSno();
			case 1: return details.getCollegeId();
			case 2: return details.getStudentId();
			case 3: return details.getEventId();
			case 4: return details.getGroupId();
			default: return "";
		}
	}

}
