package org.cssa.iface.gui.student;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.cssa.iface.bo.StudentDetails;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.transaction.StudentTransaction;
import org.cssa.iface.transaction.Transaction;
/**
 * 
 * @author ajith
 *
 */

public class StudentAndGroupEventController {
	
	private boolean group;

	private  StudentDetails student;
	private List<StudentDetails> details;
	private StudentDetailsController studentDetailsController;
	private GroupEventController groupEventController;
	private CssaMDIForm mdiForm;
	private StudentTransaction transaction;
	
	public StudentAndGroupEventController(CssaMDIForm mdiForm) {
		this.mdiForm = mdiForm;
	}

	/**
	 * @param student
	 */
	public StudentAndGroupEventController(StudentDetails student, CssaMDIForm mdiForm, boolean group) {
		super();
		this.student = student;
		this.mdiForm = mdiForm;
		this.group = group;
		transaction = new StudentTransaction();
		studentDetailsController = new StudentDetailsController(student, mdiForm);
		groupEventController = new GroupEventController(details, mdiForm);
	}
	
	public void showStudentAndGroupEventTab() {
		setDetails();
		if(group) {
			groupEventController.setStudentDetails(details);
			JPanel groupAndEventPanel = groupEventController.getGroupEventView();
			mdiForm.addChild(groupAndEventPanel, "Group and event");
		} else {
			JTabbedPane tabbedPane = new JTabbedPane();
			studentDetailsController.setStudentTableData(details);
			groupEventController.setStudentDetails(details);
			JPanel studentPanel = studentDetailsController.getStudentDeatilsview();
			tabbedPane.addTab("StudentDetails", null, studentPanel, "Student Details");
			JPanel groupAndEventPanel = groupEventController.getGroupEventView();
			tabbedPane.addTab("Group Event", null, groupAndEventPanel, "Group and event");
			mdiForm.addChild(tabbedPane, "Student Details");
		}
	}

	public List<StudentDetails> getDetails() {
		return details;
	}

	public void setDetails()  {
		try {
			details = transaction.loadAll(student.getCollegeId());
		} catch (IfaceException e) {
			e.printStackTrace();
		}
	}
	
}
