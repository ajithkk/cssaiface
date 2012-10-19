/**
 * 
 */
package org.cssa.iface.gui.timesheet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.cssa.iface.gui.CssaMDIForm;

/**
 * @author ajith
 *
 */
public class TimeSheetController implements ActionListener {
	
	private String selectedDate;
	private TimeSheetTableModel tableModel;
	private TimeSheetView view;
	private CssaMDIForm mdiForm;
	
	/**
	 * @param mdiForm
	 */
	public TimeSheetController(CssaMDIForm mdiForm) {
		super();
		this.mdiForm = mdiForm;
		tableModel = new TimeSheetTableModel();
	}




	public TimeSheetController(CssaMDIForm mdiForm, String selectedDate) {
		this.mdiForm = mdiForm;
		this.selectedDate = selectedDate;
		tableModel = new TimeSheetTableModel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void askTimeSheetView() {
		view = new TimeSheetView(mdiForm, this, tableModel);
		view.showTimeSheetScreen();
	}

}
