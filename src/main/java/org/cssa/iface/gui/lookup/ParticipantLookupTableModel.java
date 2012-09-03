package org.cssa.iface.gui.lookup;

import static org.cssa.iface.infrastructure.CSSAConstants.INSERT_RESULT_TABLE_COLUMN_NAMES;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.cssa.iface.bo.InsertResultsTableBo;

/**
 * 
 * @author Ajith
 *
 */

public class ParticipantLookupTableModel extends AbstractTableModel {

	List<InsertResultsTableBo> resultsTableBos;
	public ParticipantLookupTableModel() {
		super();
		resultsTableBos = new ArrayList<InsertResultsTableBo>();
	}

	public ParticipantLookupTableModel(List<InsertResultsTableBo> resultsTableBos) {
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
		
		InsertResultsTableBo insertResultsTableBo = resultsTableBos.get(rowIndex);
		switch(columnIndex) {
		case 0: return insertResultsTableBo.getSno();
		case 1: return insertResultsTableBo.getCollegeId();
		case 2: return insertResultsTableBo.getStudentId();
		case 3: return insertResultsTableBo.getStudentName();
		case 4: return insertResultsTableBo.getEventId();
		case 5: return insertResultsTableBo.getGroupName();
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
	public List<InsertResultsTableBo> getResultsTableBos() {
		return resultsTableBos;
	}

	/**
	 * @param resultsTableBos the resultsTableBos to set
	 */
	public void setResultsTableBos(List<InsertResultsTableBo> resultsTableBos) {
		this.resultsTableBos = resultsTableBos;
		fireTableDataChanged();

	}
	

}
