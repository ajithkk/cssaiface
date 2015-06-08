package org.cssa.iface.gui.lookup;

import static org.cssa.iface.infrastructure.CSSAConstants.INSERT_RESULT_TABLE_COLUMN_NAMES;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.cssa.iface.bo.InsertResult;

/**
 * 
 * @author Ajith
 *
 */

public class ParticipantLookupTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<InsertResult> resultsTableBos;
	public ParticipantLookupTableModel() {
		super();
		resultsTableBos = new ArrayList<InsertResult>();
	}

	public ParticipantLookupTableModel(List<InsertResult> resultsTableBos) {
		super();
		this.resultsTableBos = resultsTableBos;
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return resultsTableBos.size();
	}

	@Override
	public int getColumnCount() {
		return INSERT_RESULT_TABLE_COLUMN_NAMES.length;
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
		
		InsertResult InsertResult = resultsTableBos.get(rowIndex);
		switch(columnIndex) {
		case 0: return rowIndex+1;
		case 1: return InsertResult.getCollegeId();
		case 2: return InsertResult.getStudentId();
		case 3: return InsertResult.getStudentName();
		case 4: return InsertResult.getEventName();
		case 5: return InsertResult.getGroupName();
		case 6: return InsertResult.getEventStatus();
		default: return "";
				
		}
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		
		return  INSERT_RESULT_TABLE_COLUMN_NAMES.length >= columnIndex ? INSERT_RESULT_TABLE_COLUMN_NAMES[columnIndex]: "COLUMN"+columnIndex;
	}

	/**
	 * @return the resultsTableBos
	 */
	public List<InsertResult> getResultsTableBos() {
		return resultsTableBos;
	}

	/**
	 * @param resultsTableBos the resultsTableBos to set
	 */
	public void setResultsTableBos(List<InsertResult> resultsTableBos) {
		this.resultsTableBos = resultsTableBos;
		fireTableDataChanged();

	}
	

}
