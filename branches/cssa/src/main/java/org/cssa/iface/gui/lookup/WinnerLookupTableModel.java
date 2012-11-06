package org.cssa.iface.gui.lookup;

import static org.cssa.iface.infrastructure.CSSAConstants.WINNERS_TABLE_COLUMN_NAMES;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.cssa.iface.bo.InsertResult;

/**
 * 
 * @author admin
 *
 */

public class WinnerLookupTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<InsertResult> winnerList;
	
	public WinnerLookupTableModel() {
		winnerList = new ArrayList<InsertResult>();
	}

	@Override
	public int getRowCount() {
		return winnerList.size();
	}

	@Override
	public int getColumnCount() {
		return WINNERS_TABLE_COLUMN_NAMES.length;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return  WINNERS_TABLE_COLUMN_NAMES.length >= columnIndex ? WINNERS_TABLE_COLUMN_NAMES[columnIndex]: "COLUMN"+columnIndex;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(6 == columnIndex) {
			return true;
		}
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		InsertResult insert = winnerList.get(rowIndex);
		switch (columnIndex) {
		case 0: return insert.getSno();
		case 1: return insert.getCollegeId();
		case 2: return insert.getStudentId();
		case 3: return insert.getStudentName();
		case 4: return insert.getEventName();
		case 5: return insert.getGroupName();
		case 6: return insert.getEventStatus();
			/*if('P' == insert.getEventStatus()) {
			return "Prelims";
		} else if ('F' == insert.getEventStatus()) {
			return "Final";
		}*/
		default:
			break;
		}
		return null;
	}
	@Override
	public void setValueAt(Object value, int row, int col) {
		winnerList.get(row).setEventStatus(value.toString());
        fireTableCellUpdated(row, col);
    }
	/**
	 * @return the winnerList
	 */
	public List<InsertResult> getWinnerList() {
		return winnerList;
	}

	/**
	 * @param winnerList the winnerList to set
	 */
	public void setWinnerList(List<InsertResult> winnerList) {
		this.winnerList = winnerList;
		fireTableDataChanged();
	}
	
	

}
