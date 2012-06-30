package org.cssa.iface.gui.lookup;

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
public class StudentLookupTableModel extends AbstractTableModel {
	
	private List<StudentDetails> students;
	
	public StudentLookupTableModel() {
		students = new ArrayList<StudentDetails>();
	}
	

	public StudentLookupTableModel(List<StudentDetails> students) {
		super();
		this.students = students;
	}

	@Override
	public int getRowCount() {
		return students.size();
	}

	@Override
	public int getColumnCount() {
		return  STUDENT_LOOKUP_COLUMN_NAMES.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return  STUDENT_LOOKUP_COLUMN_NAMES.length >= columnIndex ? STUDENT_LOOKUP_COLUMN_NAMES[columnIndex]: "COLUMN"+columnIndex;
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
		StudentDetails details = students.get(rowIndex);
		switch(columnIndex) {
			case 0: return details.getSno();
			case 1: return details.getCollegeId();
			case 2: return details.getStudentId();
			case 3: return details.getStudentName();
			case 4: return details.getStudentPhone();
			case 5: return details.isStatus();
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
