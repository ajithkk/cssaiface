/**
 * 
 */
package org.cssa.iface.gui.lookup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.cssa.iface.gui.CssaMDIForm;

/**
 * @author ajith
 *
 */
public class StudentLookupController implements ActionListener {
	
	private CssaMDIForm mdiForm;
	private StudentLookupTableModel tableModel;
	private StudentLookupView lookupView;
	
	
	public StudentLookupController(CssaMDIForm mdiForm) {
		super();
		this.mdiForm = mdiForm;
		tableModel = new StudentLookupTableModel();
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
		
		
	}


	private void searchActionPerformed() {
		// TODO Auto-generated method stub
		
	}
	
	public void askStudentLookupsereen() {
		lookupView = new StudentLookupView(this, tableModel, mdiForm);
		lookupView.showEventDetailLookup();
	}

}
