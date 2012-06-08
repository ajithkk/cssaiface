/**
 * 
 */
package org.cssa.iface.gui.college;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.cssa.iface.gui.CssaMDIForm;

/**
 * @author ajith
 * @since 2/6/2012
 */
public class CollegeInitialViewController extends AbstractAction {
	
	private CssaMDIForm mdiForm;
	private CollegeInitialTableModel tableModel;
	private CollegeInitialView collegeInitialView;
	
	public CollegeInitialViewController(CssaMDIForm mdiForm) {
		this.mdiForm = mdiForm;
		tableModel = new CollegeInitialTableModel();
	}
	
	public CollegeInitialViewController() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void askCollegeInitialView() {
		collegeInitialView = new CollegeInitialView(this, tableModel, mdiForm);
		collegeInitialView.showCollegeInitialView();
	}

}
