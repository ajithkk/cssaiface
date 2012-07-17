/**
 * 
 */
package org.cssa.iface.gui.college;

import static org.cssa.iface.infrastructure.CSSAConstants.COLLEGE_INITIAL_DETAILS_COLUMN_NAMES;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.cssa.iface.bo.StudentDetails;

/**
 * @author ajith
 *
 */
public class CollegeInitialTableModel extends AbstractTableModel {
	
	private List<StudentDetails> studentRegisterNumbers;
	
	public CollegeInitialTableModel() {
		studentRegisterNumbers = new ArrayList<StudentDetails>();
	}
	
	public CollegeInitialTableModel(
			List<StudentDetails> studentRegisterNumbers) {
		super();
		this.studentRegisterNumbers = studentRegisterNumbers;
	}

	
	@Override
	public int getRowCount() {
		return studentRegisterNumbers.size();
	}

	@Override
	public int getColumnCount() {
		return COLLEGE_INITIAL_DETAILS_COLUMN_NAMES.length;
	}
	@Override
	public String getColumnName(int columnIndex) {
		
		return  COLLEGE_INITIAL_DETAILS_COLUMN_NAMES.length >= columnIndex ? COLLEGE_INITIAL_DETAILS_COLUMN_NAMES[columnIndex]: "COLUMN"+columnIndex;
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if( 2 < columnIndex) {
			return false;
		}
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		StudentDetails studentRegisterNumber = studentRegisterNumbers.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return studentRegisterNumber.getSno();
		case 1:
			return studentRegisterNumber.getStudentId();
		case 2: 
			return studentRegisterNumber.getStudentName();
		default: return "";
		}
	}
	
	public void setValueAt(Object value, int row, int col) {
        studentRegisterNumbers.get(row).setStudentName(value.toString());
        fireTableCellUpdated(row, col);
    }
	
	/**
	 * @return the studentRegisterNumbers
	 */
	public List<StudentDetails> getStudentRegisterNumbers() {
		return studentRegisterNumbers;
	}


	/**
	 * @param studentRegisterNumbers the studentRegisterNumbers to set
	 */
	public void setStudentRegisterNumbers(
			List<StudentDetails> studentRegisterNumbers) {
		this.studentRegisterNumbers = studentRegisterNumbers;
		fireTableDataChanged();
	}

}
