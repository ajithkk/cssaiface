/**
 * 
 */
package org.cssa.iface.gui.formvalidator;

import java.util.List;
import java.util.Vector;

import org.cssa.iface.bo.EventDetails;
import org.cssa.iface.bo.StudentDetails;

/**
 * @author ajith
 *
 */
public class GroupEventViewValidator {
	
	private Vector<String>	allStudent;
	private Vector<String> addedStudent;
	
	public Vector<String> contatin(Vector<String> allStudent, List<EventDetails> details) {
		boolean find = true;
		int size = allStudent.size();
		Vector<String> remainingRegster = allStudent;
		for(EventDetails event : details) {
			find = true;
			for(int i = 0; i < size & find; i++) {
				if(event.getStudentId().equals(allStudent.get(i))) {
					find = false;
					remainingRegster.remove(allStudent.get(i));
				}
			}
		}
		return remainingRegster;
	}
	
	public Vector<String>  getAllStudentRegisterNumber(List<StudentDetails> studentDetails) {
		Vector<String> regsterNumber = new Vector<String>();
		for(StudentDetails student : studentDetails) {
			regsterNumber.addElement(student.getStudentId());
		}
		return regsterNumber;
	 }

	/**
	 * @return the allStudent
	 */
	public Vector<String> getAllStudent() {
		return allStudent;
	}

	/**
	 * @param allStudent the allStudent to set
	 */
	public void setAllStudent(Vector<String> allStudent) {
		this.allStudent = allStudent;
	}

	/**
	 * @return the addedStudent
	 */
	public Vector<String> getAddedStudent() {
		return addedStudent;
	}

	/**
	 * @param addedStudent the addedStudent to set
	 */
	public void setAddedStudent(Vector<String> addedStudent) {
		this.addedStudent = addedStudent;
	}
	
	
	
}
