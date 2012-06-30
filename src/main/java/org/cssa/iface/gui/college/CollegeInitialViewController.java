/**
 * 
 */
package org.cssa.iface.gui.college;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;

import org.cssa.iface.bo.CollegeDetails;
import org.cssa.iface.bo.StudentDetails;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.transaction.CollegeTransaction;
import org.cssa.iface.transaction.TransactioUtils;

/**
 * @author ajith
 * @since 2/6/2012
 */
public class CollegeInitialViewController extends AbstractAction {
	
	private CssaMDIForm mdiForm;
	private CollegeInitialTableModel tableModel;
	private CollegeInitialView collegeInitialView;
	private TransactioUtils transactioUtils;
	CollegeTransaction transaction;
	
	public CollegeInitialViewController(CssaMDIForm mdiForm) {
		this.mdiForm = mdiForm;
		tableModel = new CollegeInitialTableModel();
		collegeInitialView = new CollegeInitialView(this, tableModel, mdiForm);
		transactioUtils = new TransactioUtils();
		transaction = new CollegeTransaction();
	}
	
	

	public CollegeInitialViewController() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		if(CollegeInitialView.INSERT.equalsIgnoreCase(actionCommand)) {
			insertActionPerformed();
			
		} else if (collegeInitialView.CANCEL.equalsIgnoreCase(actionCommand)) {
			mdiForm.closeFrame();
		} else if (collegeInitialView.CLEAR.equalsIgnoreCase(actionCommand)) {
			clearCollegenitialView();
		} else if (collegeInitialView.PRINT.equalsIgnoreCase(actionCommand)) {
			
		}
	}
	
	private void insertActionPerformed() {
		CollegeDetails collegeDetails = new CollegeDetails();
		collegeDetails.setCollegeId(collegeInitialView.getCollegeId());
		collegeDetails.setNoOfParticipants(Integer.valueOf(collegeInitialView.getNoOfParticipants()));
		collegeDetails.setCollegeName(collegeInitialView.getCollegeName());
		collegeDetails.setCollegePhone(collegeInitialView.getCollegePhone());
		collegeDetails.setCollegeAddress("");
		collegeDetails.setCollegePoints(0);
		collegeDetails.setStatus(true);
		try {
			transaction.save(collegeDetails);
		} catch (IfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setStudentIdInTable(); 
		
	}

	private void setStudentIdInTable() {
		
		try {
			List<String> studentId = transactioUtils.getStudentIds(collegeInitialView.getCollegeId(), Integer.valueOf(collegeInitialView.getNoOfParticipants()));
			List<StudentDetails> studentDetails = new ArrayList<StudentDetails>();
			int i = 0;
			for(String sid : studentId) {
				StudentDetails studentDetail = new StudentDetails();
				studentDetail.setSno(i++);
				studentDetail.setStudentId(sid);
				studentDetails.add(studentDetail);
			}
			tableModel.setStudentRegisterNumbers(studentDetails);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}



	public void askCollegeInitialView() {
		collegeInitialView.showCollegeInitialView();
		setCollegId();
	}
	
	private void clearCollegenitialView() {
		collegeInitialView.setCollegeId("");
		collegeInitialView.setCollegeName("");
		collegeInitialView.setCollegePhone("");
		collegeInitialView.setNoOfParticipants("");
		collegeInitialView.getTblStudentDetails().setModel(new CollegeInitialTableModel());
	}
	
	private void setCollegId() {
		try {
			collegeInitialView.setCollegeId(transactioUtils.getCollegeId());
		} catch (IfaceException e) {
			e.printStackTrace();
		}
		
	}

}
