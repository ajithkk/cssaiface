package org.cssa.iface.gui.lookup;
import static org.cssa.iface.infrastructure.CSSAConstants.COLLEGE_DETAILS_COLUMN_NAMES;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.cssa.iface.bo.CollegeDetails;

public class CollegeLookupTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CollegeDetails> collegeList;
	
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
		if(0 == columnIndex || 5 == columnIndex) {
			return Integer.class;
		} else if (6 == columnIndex) {
			return Boolean.class;
		}
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
		switch(columnIndex) {
			case 0 : return college.getSno();
			case 1 : return college.getCollegeId();
			case 2 : return college.getCollegeName();
			case 3 : return college.getCollegeAddress();
			case 4 : return college.getCollegePhone();
			case 5 : return college.getNoOfParticipants();
			case 6 : return college.isStatus();
			case 7 : return college.getCollegePoints();
			default : return "";
		}
		
	}

	/**
	 * @return the collegeList
	 */
	public List<CollegeDetails> getCollegeList() {
		return collegeList;
	}

	/**
	 * @param collegeList the collegeList to set
	 */
	public void setCollegeList(List<CollegeDetails> collegeList) {
		this.collegeList = collegeList;
		fireTableDataChanged();
	}

}
