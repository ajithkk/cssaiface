/**
 * 
 */
package org.cssa.iface.gui.student;

import static org.cssa.iface.infrastructure.CSSAConstants.GROUP_COLUMN_NAMES;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.cssa.iface.bo.EventDetails;
import org.cssa.iface.bo.StudentDetails;

/**
 * @author ajith
 *
 */
public class GroupEventTableModel extends AbstractTableModel {

private List<EventDetails> studentDetails;
	
	/**
	 * @return the studentDetails
	 */
	public List<EventDetails> getStudentDetails() {
		return studentDetails;
	}

	/**
	 * @param studentDetails the studentDetails to set
	 */
	public void setStudentDetails(List<EventDetails> studentDetails) {
		this.studentDetails = studentDetails;
		fireTableDataChanged();
	}
	
	public void addRow(EventDetails student) {
		studentDetails.add(student);
		fireTableDataChanged();
	}
	
	public GroupEventTableModel() {
		studentDetails = new ArrayList<EventDetails>();
	}
	
	/**
	 * @param studentDetails
	 */
	public GroupEventTableModel(List<EventDetails> studentDetails) {
		super();
		this.studentDetails = studentDetails;
	}

	@Override
	public int getRowCount() {
		return studentDetails.size();
	}

	@Override
	public int getColumnCount() {
		return GROUP_COLUMN_NAMES.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return  GROUP_COLUMN_NAMES.length >= columnIndex ? GROUP_COLUMN_NAMES[columnIndex]: "COLUMN"+columnIndex;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if( columnIndex == 8) {
			return Boolean.class;
		}
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		EventDetails details = studentDetails.get(rowIndex);
		switch(columnIndex) {
		case 0: return rowIndex + 1;
		case 1: return details.getCollegeId();
		case 2: return details.getCollegeName();
		case 3: return details.getStudentId();
		case 4: return details.getStudentName();
		case 5: return details.getEventId();
		case 6: return details.getGroupId();
		case 7: return details.getStudentPhone();
		case 8: return details.isStatus();
		default: return "";
		}
	}


}
