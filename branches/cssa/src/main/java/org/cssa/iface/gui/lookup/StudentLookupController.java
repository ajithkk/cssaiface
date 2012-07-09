/**
 * 
 */
package org.cssa.iface.gui.lookup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import org.cssa.iface.bo.StudentDetails;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.formvalidator.StudentLookupFormValidator;
import org.cssa.iface.gui.student.StudentAndGroupEventController;
import org.cssa.iface.transaction.StudentTransaction;

/**
 * @author ajith
 *
 */
public class StudentLookupController implements ActionListener, MouseListener {
	
	private CssaMDIForm mdiForm;
	private StudentLookupTableModel tableModel;
	private StudentLookupView lookupView;
	private StudentTransaction transaction;
	private StudentLookupFormValidator validator;
	List<StudentDetails> studentDetails;
	
	
	public StudentLookupController(CssaMDIForm mdiForm) {
		super();
		this.mdiForm = mdiForm;
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
		}
		
	}


	private void clearActionPerformed() {
		lookupView.setCollegeId("");
		lookupView.setStudentId("");
		lookupView.setStudentName("");
		
		
	}


	private void searchActionPerformed() {
		validator.setLookupView(lookupView);
		if(validator.allFieldsEmpty()) {
			try {
				studentDetails = transaction.loadAll();
				tableModel.setStudents(studentDetails);
			} catch (IfaceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void askStudentLookupsereen() {
		lookupView = new StudentLookupView(this, tableModel, mdiForm);
		lookupView.showEventDetailLookup();
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		int selectedRow = lookupView.getTblStudentDetails().getSelectedRow();
		StudentDetails details = tableModel.getStudents().get(selectedRow);
		//new StudentDetailsController(details, mdiForm).askStudentDetailsView();
		new StudentAndGroupEventController(details, mdiForm).showStudentAndGroupEventTab();
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

}
