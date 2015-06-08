/**
 * 
 */
package org.cssa.iface.gui.college;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import org.cssa.iface.bo.CollegeDetails;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.util.ErrorDialog;
import org.cssa.iface.transaction.CollegeTransaction;
import org.cssa.iface.util.CssaMessage;

/**
 * @author ajith
 *
 */
public class CollegeDetailsController implements ActionListener{
	
	public CollegeDetilsView collegeDetilsView;
	private CssaMDIForm mdiForm;
	private CollegeDetails collegeDetails;
	private CollegeTransaction transaction;
	
	/**
	 * 
	 * @param mdiForm
	 */
	public CollegeDetailsController(CssaMDIForm mdiForm) {
		super();
		this.mdiForm = mdiForm;
		transaction = new CollegeTransaction();
	}


 /**
  * 
  * @param mdiForm
  * @param collegeDetails
  */
	public CollegeDetailsController(CssaMDIForm mdiForm,
			CollegeDetails collegeDetails) {
		super();
		this.mdiForm = mdiForm;
		this.collegeDetails = collegeDetails;
		collegeDetilsView = new CollegeDetilsView(this, mdiForm);
		transaction = new CollegeTransaction();
		
	}
	/**
	 * 
	 */
	private void setCollegeDetails() {
		collegeDetilsView.setTxtCollegeId(collegeDetails.getCollegeId());
		collegeDetilsView.setTxtCollegeName(collegeDetails.getCollegeName());
		collegeDetilsView.setTxtCollegePhone(collegeDetails.getCollegePhone());
		collegeDetilsView.setTxtNoOfParticipants(String.valueOf(collegeDetails.getNoOfParticipants()));
		collegeDetilsView.setTxtCollegeAddress(collegeDetails.getCollegeAddress());
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(CollegeDetilsView.SAVE.equals(actionCommand)) {
			performSaveAction();
		} else if (CollegeDetilsView.CANCEL.equals(actionCommand)) {
			performCancelAction();
		} else if (CollegeDetilsView.CLEAR.equals(actionCommand)) {
			performClearAction();
			
		}
		
	}
	
	private void performClearAction() {
		collegeDetilsView.setTxtCollegeAddress("");
		collegeDetilsView.setTxtCollegeName("");
		collegeDetilsView.setTxtCollegePhone("");
	}

	private void performCancelAction() {
		mdiForm.closeFrame();
	}



	private void performSaveAction() {
		CollegeDetails details = new CollegeDetails();
		details.setNoOfParticipants(Integer.valueOf(collegeDetilsView.getTxtNoOfParticipants()));
		details.setCollegeId(collegeDetilsView.getTxtCollegeId());
		details.setCollegeName(collegeDetilsView.getTxtCollegeName());
		details.setCollegePhone(collegeDetilsView.getTxtCollegePhone());
		details.setStatus(collegeDetilsView.getStatus());
		details.setCollegeAddress(collegeDetilsView.getTxtCollegeAddress());
		
		try {
			transaction.update(details);
			CssaMessage.informationMessage(mdiForm, "Successfully saved", "Information");
		} catch (IfaceException e) {
			new ErrorDialog(e).setVisible(true);
			e.printStackTrace();
		}
		
	}

	public void askCollegeDetailsView() {
		collegeDetilsView.showCollegeDetailsView();
		if(null != collegeDetails) {
			setCollegeDetails();
		}
	}
}
