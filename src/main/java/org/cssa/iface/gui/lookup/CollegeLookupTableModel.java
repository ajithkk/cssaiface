package org.cssa.iface.gui.lookup;
import static org.cssa.iface.infrastructure.CSSAConstants.COLLEGE_DETAILS_COLUMN_NAMES;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.cssa.iface.bo.CollegeDetails;

public class CollegeLookupTableModel extends AbstractTableModel {
	
	private List<CollegeDetails> collegeList = null;
	
	/**
	 * default constructor
	 */
	public CollegeLookupTableModel() {
		collegeList = new ArrayList<CollegeDetails>();
	}

	/**
	 * @param collegeList
	 */
	public CollegeLookupTableModel(List<CollegeDetails> collegeList) {
		super();
		this.collegeList = collegeList;
	}

	@Override
	public int getRowCount() {
		
		return collegeList.size();
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
	public int getColumnCount() {
		
		return COLLEGE_DETAILS_COLUMN_NAMES.length;
	}
	@Override
	public String getColumnName(int columnIndex) {
		
		return  COLLEGE_DETAILS_COLUMN_NAMES.length >= columnIndex ? COLLEGE_DETAILS_COLUMN_NAMES[columnIndex]: "COLUMN"+columnIndex;
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		CollegeDetails college = collegeList.get(rowIndex);
		return college;
	}

}
