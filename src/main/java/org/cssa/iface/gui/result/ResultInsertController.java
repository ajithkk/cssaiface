/**
 * 
 */
package org.cssa.iface.gui.result;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.cssa.iface.bo.CollegeDetails;
import org.cssa.iface.bo.StudentDetails;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.services.CollegeLookupService;
import org.cssa.iface.services.LookupService;
import org.cssa.iface.services.StudentLookupService;

/**
 * @author ajith
 *
 */
public class ResultInsertController implements ActionListener,LookupService<CollegeDetails> {
	
	
	private CssaMDIForm mdiForm;
	private ResultInsertView resultInsertView;
	private ResultInsertTableModel tableModel;
	
	/**
	 * @param mdiForm
	 */
	public ResultInsertController(CssaMDIForm mdiForm) {
		super();
		this.mdiForm = mdiForm;
		tableModel = new ResultInsertTableModel();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		String actionCommand = e.getActionCommand();
		
		if(actionCommand.equals(ResultInsertView.CANCEL)) {
			
		} else if (actionCommand.equals(ResultInsertView.CLEAR)) {
			
		} else if (actionCommand.equals(ResultInsertView.SEARCH)) {
			
		} else if (actionCommand.equals(ResultInsertView.SAVE)) {
			
		} else if (actionCommand.equals(ResultInsertView.COLLEGE_SEARCH)) {
			
		} else if (actionCommand.equals(ResultInsertView.STUDENT_SEARCH)) {
			
		}
	}

	public void askResultInsertView() {
		
		resultInsertView = new ResultInsertView(mdiForm, this, tableModel);
		resultInsertView.showResultInsertScreen();
		
	}

	@Override
	public void setResult(CollegeDetails e) {
		// TODO Auto-generated method stub
		
	}



}
