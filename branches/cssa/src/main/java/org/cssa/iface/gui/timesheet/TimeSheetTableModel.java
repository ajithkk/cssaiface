package org.cssa.iface.gui.timesheet;
import static org.cssa.iface.infrastructure.CSSAConstants.TIMESHEET_COLUMN_NAMES;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.cssa.iface.bo.TimeSheet;

/**
 * 
 * @author ajith
 *
 */
public class TimeSheetTableModel  extends AbstractTableModel{
	
	List<TimeSheet> timeSheets;

	/**
	 * 
	 */
	public TimeSheetTableModel() {
		super();
		timeSheets = new ArrayList<TimeSheet>();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return timeSheets.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return TIMESHEET_COLUMN_NAMES.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return TIMESHEET_COLUMN_NAMES.length >= columnIndex ? TIMESHEET_COLUMN_NAMES[columnIndex]: "COLUMN"+columnIndex;
		
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(columnIndex > 1){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void setValueAt(Object value, int row, int col) {
		
        fireTableCellUpdated(row, col);
    }
	
	/**
	 * @return the timeSheets
	 */
	public List<TimeSheet> getTimeSheets() {
		return timeSheets;
	}

	/**
	 * @param timeSheets the timeSheets to set
	 */
	public void setTimeSheets(List<TimeSheet> timeSheets) {
		this.timeSheets = timeSheets;
		fireTableDataChanged();
	}
	
	public void setSchedule(TimeSheet timeSheet) {
		timeSheets.add(timeSheet);
		fireTableDataChanged();
	}
	
	

	
}
