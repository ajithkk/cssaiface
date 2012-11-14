/**
 * 
 */
package org.cssa.iface.gui.lookup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.List;

import org.cssa.iface.bo.CollegeDetails;
import org.cssa.iface.bo.StudentDetails;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.formvalidator.StudentLookupFormValidator;
import org.cssa.iface.gui.student.StudentAndGroupEventController;
import org.cssa.iface.gui.util.ErrorDialog;
import org.cssa.iface.report.student.StudentDetailsReport;
import org.cssa.iface.services.CollegeLookupService;
import org.cssa.iface.services.StudentLookupService;
import org.cssa.iface.transaction.StudentTransaction;
import org.cssa.iface.util.Util;

import com.itextpdf.text.DocumentException;

/**
 * @author ajith
 *
 */
public class StudentLookupController implements ActionListener, MouseListener, CollegeLookupService<CollegeDetails>{
	
	private boolean printEanable;
	private boolean group;
	
	private CssaMDIForm mdiForm;
	private StudentLookupTableModel tableModel;
	private StudentLookupView lookupView;
	private StudentTransaction transaction;
	private StudentLookupFormValidator validator;
	private List<StudentDetails> studentDetails;
	private StudentDetails student;
	private  StudentLookupService<StudentDetails> controller;
	
	public StudentLookupController(CssaMDIForm mdiForm) {
		super();
		this.mdiForm = mdiForm;
		tableModel = new StudentLookupTableModel();
		transaction = new StudentTransaction();
		validator = new StudentLookupFormValidator();
		controller = null;
		
	}
	
	public StudentLookupController(CssaMDIForm mdiForm, boolean group, boolean printEnable) {
		this(mdiForm);
		this.group = group;
		this.printEanable = printEnable;
	}
	
	public StudentLookupController(CssaMDIForm mdiForm, StudentLookupService<StudentDetails>  controller) {
		this.mdiForm = mdiForm;
		this.controller = controller;
		tableModel = new StudentLookupTableModel();
		transaction = new StudentTransaction();
		validator = new StudentLookupFormValidator();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(StudentLookupView.SEARCH.equals(actionCommand)) {
			searchActionPerformed();
			
		} else if(StudentLookupView.CANCEL.equals(actionCommand)) {
			mdiForm.closeFrame();
			
		} else if (StudentLookupView.CLEAR.equals(actionCommand)) {
			clearActionPerformed();
		} else if(StudentLookupView.SEARCH_COLLEGE_ID.equals(actionCommand)) {
			CollegeLookupController collegeLookup = new CollegeLookupController(mdiForm, this);
			collegeLookup.askCollegeLookupView();
		} else if (StudentLookupView.PRINT.equals(actionCommand)) {
			performPrintAction();
		}
		
	}


	private void performPrintAction() {
		String FILE = Util.getReportHome()+"\\StudentDetailsReport.pdf";
		List<StudentDetails> studentDetails = tableModel.getStudents();
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

	private void clearActionPerformed() {
		lookupView.setCollegeId("");
		lookupView.setStudentId("");
		lookupView.setStudentName("");
		
		
	}


	private void searchActionPerformed() {
		/*validator.setLookupView(lookupView);
		if(validator.allFieldsEmpty()) {
			try {
				studentDetails = transaction.loadAll();
				tableModel.setStudents(studentDetails);
			} catch (IfaceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {*/
			StudentDetails student = new StudentDetails();
			student.setCollegeId(lookupView.getCollegeId());
			student.setStudentId(lookupView.getStudentId());
			student.setStudentName(lookupView.getStudentName());
			try {
				studentDetails = transaction.loadAll(student);
				tableModel.setStudents(studentDetails);
			} catch (IfaceException e) {
				
				new ErrorDialog(e).setVisible(true);
				e.printStackTrace();
			}
			
		/*}*/
		
	}
	
	public void askStudentLookupsereen() {
		lookupView = new StudentLookupView(this, tableModel, mdiForm);
		lookupView.showEventDetailLookup();
		if(printEanable) {
			lookupView.getBtnPrint().setVisible(true);
		} else {
			lookupView.getBtnPrint().setVisible(false);
		}
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(!printEanable) {
			int selectedRow = lookupView.getTblStudentDetails().getSelectedRow();
			StudentDetails details = tableModel.getStudents().get(selectedRow);
			if(null == controller) {
				//new StudentDetailsController(details, mdiForm).askStudentDetailsView();
				StudentAndGroupEventController studentAndGroupEventController = new  StudentAndGroupEventController(details, mdiForm, group);
				studentAndGroupEventController.showStudentAndGroupEventTab();
			} else {
				mdiForm.closeFrame();
				controller.setSelectedStudent(details);
			}
		}
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public StudentDetails getStudent() {
		return student;
	}

	public void setStudent(StudentDetails student) {
		this.student = student;
	}

	@Override
	public void setSelectedCollege(CollegeDetails e) {
		if(null != e) {
			lookupView.setCollegeId(e.getCollegeId());
		}
		
	}
	
	

}
