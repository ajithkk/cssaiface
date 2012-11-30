/**
 * 
 */
package org.cssa.iface.gui.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.cssa.iface.bo.CollegeDetails;
import org.cssa.iface.bo.StudentDetails;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.util.ErrorDialog;
import org.cssa.iface.gui.util.MessageUtil;
import org.cssa.iface.report.student.StudentDetailsReport;
import org.cssa.iface.transaction.StudentTransaction;
import org.cssa.iface.util.Util;

import com.itextpdf.text.DocumentException;

/**
 * @author ajith
 *
 */
public class StudentDetailsController implements ActionListener, MouseListener {
	
	private StudentDetailsEventTableModel tableModel;
	private StudentTransaction transaction;
	private CollegeDetails collegeDetails;
	private StudentDetails studentDetails;
	private StudentDetailsView studentDetailsView;
	private List<StudentDetails> sList;
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
		try {
			StudentDetails student = transaction.addNewStudent(tableModel.getStudentDetails());
			tableModel.addRow(student);
		} catch (IfaceException e) {
			new ErrorDialog(e).setVisible(true);
		}
		
	}

	private void performPrintAction() {
		List<StudentDetails> studentDetails = tableModel.getStudentDetails();
		if(studentDetails.size() > 0) {
		String FILE = Util.getReportHome()+"\\StudentDetailsReport"+studentDetails.get(0).getCollegeId().trim()+".pdf";
		if(null != studentDetails) {
			StudentDetailsReport report = new StudentDetailsReport(FILE, studentDetails);
			try {
				report.createReport();
			} catch (FileNotFoundException e) {
				new ErrorDialog(e).setVisible(true);
				e.printStackTrace();
			} catch (DocumentException e) {
				new ErrorDialog(e).setVisible(true);
				e.printStackTrace();
			}
		}
		}
		
	}

	private void performSaveAction() {
		StudentDetails details = new StudentDetails();
		details.setCollegeId(studentDetailsView.getTxtCollegeId());
		details.setStudentId(studentDetailsView.getTxtStudentId());
		details.setStudentName(studentDetailsView.getTxtStudentName());
		details.setStudentPhone(studentDetailsView.getTxtPhone());
		details.setAccommodation(studentDetailsView.getCkAccommodation().isSelected());
		details.setStatus(studentDetailsView.getStatus().isSelected());
		if(null != studentDetailsView.getCbGender().getSelectedItem()) {
			details.setStudentGender(studentDetailsView.getCbGender().getSelectedItem().toString());
		}
		try {
			transaction.update(details);
			tableModel.setStudentDetails(transaction.loadAll(details.getCollegeId()));
		} catch (IfaceException e) {
			new ErrorDialog(e).setVisible(true);
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
		int selectedRow = -1;
		int response = JOptionPane.showConfirmDialog(null, "Do you want to delete student ?", "Confirm",
		        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(response == JOptionPane.YES_OPTION) {
			selectedRow = studentDetailsView.getStudentTable().getSelectedRow();
			StudentDetails details = tableModel.getStudentDetails().get(selectedRow);
			if(null != details) {
				try {
					transaction.delete(tableModel.getStudentDetails().get(selectedRow));
					tableModel.setStudentDetails(transaction.loadAll(details.getCollegeId()));
				} catch (IfaceException e) {
					new ErrorDialog(e).setVisible(true);
				}
			} else {
				new MessageUtil(mdiForm).showErrorMessage("Error ", "Please select any roe from table");
			}
		}
		
	}

	private void performEditActiion() {
		
		
		
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
	
	public void setStudentDetails(StudentDetails studentDetails) {
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
		
		JPanel panel = studentDetailsView.getStudentDetailsBody();
		setStudentDetails();
		return panel;
	}

	public List<StudentDetails> getsList() {
		return sList;
	}

	public void setsList(List<StudentDetails> sList) {
		this.sList = sList;
	}
	
	public void setStudentTableData(List<StudentDetails> studentDetails) {
		tableModel.setStudentDetails(studentDetails);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int selectedRow = studentDetailsView.getStudentTable().getSelectedRow();
		StudentDetails details = tableModel.getStudentDetails().get(selectedRow);
		setStudentDetails(details);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
