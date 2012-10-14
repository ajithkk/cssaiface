package org.cssa.iface.gui.search;

import static org.cssa.iface.infrastructure.CSSAConstants.EVENT_RESULT_TABLE_COLUMN_NAMES;


import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.cssa.iface.bo.InsertResult;

/**
 * 
 * @author ajith
 *
 */
public class SearchResultTableModel  extends AbstractTableModel{
	
	private List<InsertResult> searchResult;
	

	/**
	 * @param searchResult
	 */
	public SearchResultTableModel(List<InsertResult> searchResult) {
		super();
		this.searchResult = searchResult;
	}

	/**
	 * @return the searchResult
	 */
	public List<InsertResult> getSearchResult() {
		return searchResult;
	}

	/**
	 * @param searchResult the searchResult to set
	 */
	public void setSearchResult(List<InsertResult> searchResult) {
		this.searchResult = searchResult;
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return searchResult.size();
	}

	@Override
	public int getColumnCount() {
		return EVENT_RESULT_TABLE_COLUMN_NAMES.length;
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
		
		InsertResult InsertResult = searchResult.get(rowIndex);
		switch(columnIndex) {
		case 0: return rowIndex+1;
		case 1: return InsertResult.getCollegeId();
		case 2: return InsertResult.getCollegeName(); 
		case 3: return InsertResult.getStudentId();
		case 4: return InsertResult.getStudentName();
		case 5: return InsertResult.getEventName();
		case 6: return InsertResult.getGroupName();
		case 7: return InsertResult.getEventStatus();
		default: return "";
				
		}
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		
		return  EVENT_RESULT_TABLE_COLUMN_NAMES.length >= columnIndex ? EVENT_RESULT_TABLE_COLUMN_NAMES[columnIndex]: "COLUMN"+columnIndex;
	}


}
	
	
	
	
