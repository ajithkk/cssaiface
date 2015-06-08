/**
 * 
 */
package org.cssa.iface.gui.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.transaction.EventsTransaction;

/**
 * @author ajith
 *
 */
public class SearchTableModel extends AbstractTableModel{
	
	private EventsTransaction eventsTransaction;
	private int columnLength;
	private List<Object> eventList;
	private Map<Integer, String> searchKey;
	private List<String> selectedEvent;
	
	public SearchTableModel() {
		eventsTransaction = new EventsTransaction();
		eventList = new ArrayList<Object>();
		searchKey = new HashMap<Integer, String>();
		selectedEvent = new  ArrayList<String>();
		try {
			columnLength = 6;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getRowCount() {
		return 1;
	}

	@Override
	public int getColumnCount() {
		return columnLength;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return eventList.get(columnIndex);
	}
	
	@Override
	public String getColumnName(int col) {
		
		switch (col) {
		case 0:
			return "Event Stage";
		case 1: 
			return "Event Id";
		case 2: 
			return "College Id";
		case 3: 
			return "Student Id";
		case 4:
			return "Common";
					
		default:
			return "Column "+ (col);
		}
    }
	
	@Override
	public Class getColumnClass(int c) {
		if(c == 4) return Boolean.class;
		 return getValueAt(0, c).getClass();
        
    }
	
	@Override
	public boolean isCellEditable(int row, int col) {
		return true;
       
    }
	
	@Override
	 public void setValueAt(Object value, int row, int col) {
		switch (col) {
		case 0:
			eventList.remove(col);
			eventList.add(col, value.toString());
			searchKey.put(col, value.toString());
			break;
		case 1:
			eventList.remove(col);
			eventList.add(col, value.toString());
			selectedEvent.add(value.toString());
			break;
		case 4:
			eventList.remove(col);
			eventList.add(col, value);
			searchKey.put(col, value.toString());
			break;
		default:
			eventList.remove(col);
			eventList.add(col, value.toString());
			searchKey.put(col, value.toString());
			break;
		}
		
		fireTableCellUpdated(row, col);
     }

	/**
	 * @return the eventList
	 */
	public List<Object> getEventList() {
		return eventList;
	}

	/**
	 * @param eventList the eventList to set
	 */
	public void setEventList(List<Object> eventList) {
		this.eventList = eventList;
		fireTableDataChanged();
	}

	/**
	 * @return the searchKey
	 */
	public Map<Integer, String> getSearchKey() {
		return searchKey;
	}

	/**
	 * @param searchKey the searchKey to set
	 */
	public void setSearchKey(Map<Integer, String> searchKey) {
		this.searchKey = searchKey;
	}

	/**
	 * @return the selectedEvent
	 */
	public List<String> getSelectedEvent() {
		return selectedEvent;
	}

	/**
	 * @param selectedEvent the selectedEvent to set
	 */
	public void setSelectedEvent(List<String> selectedEvent) {
		this.selectedEvent = selectedEvent;
	}

	
	

}
