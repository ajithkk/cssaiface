/**
 * 
 */
package org.cssa.iface.gui.database;

import static org.cssa.iface.infrastructure.CSSAConstants.RESULT_COLUMN_NAMES;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.cssa.iface.bo.Results;

/**
 * @author ajith
 *
 */
public class ResultTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Results> resultList;
	/**
	 * @param resultList
	 */
	public ResultTableModel(List<Results> resultList) {
		super();
		this.resultList = resultList;
		fireTableDataChanged();
	}

	/**
	 * default constructor
	 */
	public ResultTableModel() {
		
		resultList = new ArrayList<Results>();
	}

	@Override
	public int getRowCount() {
		return resultList.size();
	}

	@Override
	public int getColumnCount() {
		return RESULT_COLUMN_NAMES.length;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return  RESULT_COLUMN_NAMES.length >= columnIndex ? RESULT_COLUMN_NAMES[columnIndex]: "COLUMN"+columnIndex;
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
		Results insert = resultList.get(rowIndex);
		switch (columnIndex) {
		case 0: return insert.getSno();
		case 1: return insert.getCollegeId();
		case 2: return insert.getStudentId();
		case 3: return insert.getEventId();
		case 4: return insert.getEventStatus();
		case 5: return insert.getGroupId();
		case 6: return insert.getMark();
		default:
			break;
		}
		return null;
	}
	

	/**
	 * @return the resultList
	 */
	public List<Results> getResultList() {
		return resultList;
	}

	/**
	 * @param resultList the resultList to set
	 */
	public void setResultList(List<Results> resultList) {
		this.resultList = resultList;
		fireTableDataChanged();
	}

}
