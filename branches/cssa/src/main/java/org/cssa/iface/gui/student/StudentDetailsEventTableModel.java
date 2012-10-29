package org.cssa.iface.gui.student;

import static org.cssa.iface.infrastructure.CSSAConstants.STUDENT_LOOKUP_COLUMN_NAMES;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.cssa.iface.bo.StudentDetails;

/**
 * 
 * @author ajith
 *
 */

public class StudentDetailsEventTableModel  extends AbstractTableModel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<StudentDetails> studentDetails;
	
	
	/**
	 * @return the studentDetails
	 */
	public List<StudentDetails> getStudentDetails() {
		return studentDetails;
	}

	/**
	 * @param studentDetails the studentDetails to set
	 */
	public void setStudentDetails(List<StudentDetails> studentDetails) {
		this.studentDetails = studentDetails;
		fireTableDataChanged();
	}
	
	public void addRow(StudentDetails student) {
		studentDetails.add(student);
		fireTableDataChanged();
	}
	
	public StudentDetailsEventTableModel() {
		studentDetails = new ArrayList<StudentDetails>();
	}
	
	/**
	 * @param studentDetails
	 */
	public StudentDetailsEventTableModel(List<StudentDetails> studentDetails) {
		super();
		this.studentDetails = studentDetails;
	}

	@Override
	public int getRowCount() {
		return studentDetails.size();
	}

	@Override
	public int getColumnCount() {
		return STUDENT_LOOKUP_COLUMN_NAMES.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return  STUDENT_LOOKUP_COLUMN_NAMES.length >= columnIndex ? STUDENT_LOOKUP_COLUMN_NAMES[columnIndex]: "COLUMN"+columnIndex;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if( columnIndex > 6) {
			return Boolean.class;
		} else if (0 == columnIndex) {
			return Integer.class;
		} else if (6 == columnIndex) {
			return Float.class;
		}
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		StudentDetails details = studentDetails.get(rowIndex);
		switch(columnIndex) {
		case 0: return rowIndex+1;
		case 1: return details.getCollegeId();
		case 2: return details.getCollegeName();
		case 3: return details.getStudentId();
		case 4: return details.getStudentName();
		case 5: return details.getStudentPhone();
		case 6: return details.getStudentPoint();
		case 7: return details.isAccommodation();
		case 8: return details.isStatus();
		default: return "";
		}
	}
	
	

}
