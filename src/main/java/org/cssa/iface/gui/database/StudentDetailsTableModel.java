/**
 * 
 */
package org.cssa.iface.gui.database;

import static org.cssa.iface.infrastructure.CSSAConstants.STUDENT_DETAILS_COLUMN_NAMES;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.cssa.iface.bo.StudentDetails;

/**
 * @author ajith
 *
 */
public class StudentDetailsTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<StudentDetails> students;
	
	public StudentDetailsTableModel() {
		students = new ArrayList<StudentDetails>();
	}
	

	public StudentDetailsTableModel(List<StudentDetails> students) {
		super();
		this.students = students;
	}

	@Override
	public int getRowCount() {
		return students.size();
	}

	@Override
	public int getColumnCount() {
		return  STUDENT_DETAILS_COLUMN_NAMES.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return  STUDENT_DETAILS_COLUMN_NAMES.length >= columnIndex ? STUDENT_DETAILS_COLUMN_NAMES[columnIndex]: "COLUMN"+columnIndex;
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

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		StudentDetails details = students.get(rowIndex);
		switch(columnIndex) {
			case 0: return details.getSno();
			case 1: return details.getCollegeId();
			case 2: return details.getStudentId();
			case 3: return details.getStudentName();
			case 4: return details.getStudentGender();
			case 5: return details.getStudentPhone();
			case 6: return details.getStudentPoint();
			case 7: return details.isAccommodation();
			case 8: return details.isStatus();
			default: return "";
		}
	}

	/**
	 * @return the students
	 */
	public List<StudentDetails> getStudents() {
		return students;
	}


	/**
	 * @param students the students to set
	 */
	public void setStudents(List<StudentDetails> students) {
		this.students = students;
		fireTableDataChanged();
	}

}
