/**
 * 
 */
package org.cssa.iface.gui.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import org.cssa.iface.bo.CollegeDetails;
import org.cssa.iface.bo.StudentDetails;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.transaction.StudentTransaction;

/**
 * @author ajith
 *
 */
public class StudentDetailsController implements ActionListener{
	
	private StudentDetailsEventTableModel tableModel;
	private StudentTransaction transaction;
	private CollegeDetails collegeDetails;
	private StudentDetails studentDetails;
	private StudentDetailsView studentDetailsView;
	CssaMDIForm mdiForm;
	
	public StudentDetailsController(CssaMDIForm mdiForm) {
		this.mdiForm = mdiForm;
		transaction = new StudentTransaction();
	}
	
	public StudentDetailsController(StudentDetails studentDetails, CssaMDIForm mdiForm) {
		super();
		this.studentDetails = studentDetails;
		this.mdiForm = mdiForm;
		transaction = new StudentTransaction();
		tableModel = new StudentDetailsEventTableModel();
		studentDetailsView = new StudentDetailsView(mdiForm, tableModel, this);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		if (studentDetailsView.SAVE.equals(actionCommand)) {
			performSaveAction();
		} else if (StudentDetailsView.CANCEL.equals(actionCommand)) {
			mdiForm.closeFrame();
		} else if (StudentDetailsView.CLEAR.equals(actionCommand)) {
			performClearAction();
		} else if (StudentDetailsView.DELETE.equals(actionCommand)) {
			performDeleteAction();
		} else if (StudentDetailsView.EDIT.equals(actionCommand)) {
			performEditActiion();
		} else if (StudentDetailsView.PRINT.equals(actionCommand)) {
			performPrintAction();
		} else if (StudentDetailsView.ADD.equals(actionCommand)) {
			performAddAction();
		}
	}
	
	private void performAddAction() {
		// TODO Auto-generated method stub
		
	}

	private void performPrintAction() {
		// TODO Auto-generated method stub
		
	}

	private void performSaveAction() {
		StudentDetails details = new StudentDetails();
		details.setCollegeId(studentDetailsView.getTxtCollegeId());
		details.setStudentId(studentDetailsView.getTxtStudentId());
		details.setStudentName(studentDetailsView.getTxtStudentName());
		details.setStudentPhone(studentDetailsView.getTxtPhone());
		details.setAccommodation(studentDetailsView.getCkAccommodation());
		details.setStudentGender(studentDetailsView.getCbGender());
		try {
			transaction.update(details);
		} catch (IfaceException e) {
			e.printStackTrace();
		}
	}

	private void performClearAction() {
		studentDetailsView.setTxtStudentName("");
		studentDetailsView.setTxtStudentId("");
		studentDetailsView.setTxtPhone("");
		studentDetailsView.setTxtCollegeId("");
		studentDetailsView.setCbGender(null);
		studentDetailsView.setCkAccommodation(false);
	}

	private void performDeleteAction() {
		// TODO Auto-generated method stub
		
	}

	private void performEditActiion() {
		// TODO Auto-generated method stub
		
	}

	public void askStudentDetailsView() {
		studentDetailsView.showStudentScreen();
		setStudentDetails();
		
	}
		
	public void setStudentDetails() {
		if(null != studentDetails) {
			studentDetailsView.setTxtCollegeId(studentDetails.getCollegeId());
			studentDetailsView.setTxtStudentId(studentDetails.getStudentId());
			studentDetailsView.setTxtStudentName(studentDetails.getStudentName());
			studentDetailsView.setTxtPhone(studentDetails.getStudentPhone());
			studentDetailsView.setCbGender(studentDetails.getStudentGender());
			studentDetailsView.setCkAccommodation(studentDetails.isAccommodation());
		}
	}
	
	public JPanel getStudentDeatilsview() {
		return studentDetailsView.getStudentDetailsBody();
	}
	
}
