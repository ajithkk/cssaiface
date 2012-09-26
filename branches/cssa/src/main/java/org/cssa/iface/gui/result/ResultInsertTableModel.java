/**
 * 
 */
package org.cssa.iface.gui.result;

import static org.cssa.iface.infrastructure.CSSAConstants.INSERT_RESULT_COLUMN_NAMES;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.cssa.iface.bo.InsertResult;

/**
 * @author Ajith
 *
 */
public class ResultInsertTableModel  extends AbstractTableModel{

	
	private List<InsertResult> resultList;
	/**
	 * @param resultList
	 */
	public ResultInsertTableModel(List<InsertResult> resultList) {
		super();
		this.resultList = resultList;
		fireTableDataChanged();
	}

	/**
	 * default constructor
	 */
	public ResultInsertTableModel() {
		
		resultList = new ArrayList<InsertResult>();
	}

	@Override
	public int getRowCount() {
		return resultList.size();
	}

	@Override
	public int getColumnCount() {
		return INSERT_RESULT_COLUMN_NAMES.length;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if(6 == columnIndex) {
			return Double.class;
		}
		return String.class;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return  INSERT_RESULT_COLUMN_NAMES.length >= columnIndex ? INSERT_RESULT_COLUMN_NAMES[columnIndex]: "COLUMN"+columnIndex;
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
		InsertResult insert = resultList.get(rowIndex);
		switch (columnIndex) {
		case 0: return insert.getSno();
		case 1: return insert.getCollegeId();
		case 2: return insert.getStudentId();
		case 3: return insert.getStudentName();
		case 4: return insert.getEventName();
		case 5: return insert.getGroupName();
		case 6: return insert.getMark();
		case 7: return insert.getEventStatus();
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
		resultList.get(row).setMark(Float.valueOf(value.toString()));
        fireTableCellUpdated(row, col);
    }
	

	/**
	 * @return the resultList
	 */
	public List<InsertResult> getResultList() {
		return resultList;
	}

	/**
	 * @param resultList the resultList to set
	 */
	public void setResultList(List<InsertResult> resultList) {
		this.resultList = resultList;
		fireTableDataChanged();
	}

}
