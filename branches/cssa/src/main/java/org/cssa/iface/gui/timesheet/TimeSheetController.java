/**
 * 
 */
package org.cssa.iface.gui.timesheet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import org.cssa.iface.bo.TimeSheet;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.transaction.TimeSheetTransaction;
import org.cssa.iface.util.Util;

/**
 * @author ajith
 *
 */
public class TimeSheetController implements ActionListener {
	
	private String selectedDate;
	private TimeSheetTableModel tableModel;
	private TimeSheetView view;
	private CssaMDIForm mdiForm;
	private TimeSheetTransaction timeSheetTransaction;
	
	/**
	 * @param mdiForm
	 */
	public TimeSheetController(CssaMDIForm mdiForm) {
		super();
		this.mdiForm = mdiForm;
		tableModel = new TimeSheetTableModel();
		timeSheetTransaction = new TimeSheetTransaction();
	}




	public TimeSheetController(CssaMDIForm mdiForm, String selectedDate) {
		this.mdiForm = mdiForm;
		this.selectedDate = selectedDate;
		tableModel = new TimeSheetTableModel();
		timeSheetTransaction = new TimeSheetTransaction();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (TimeSheetView.CANCEL.equals(actionCommand)) {
			mdiForm.closeFrame();
		} else if (TimeSheetView.ADD.equals(actionCommand)) {
			performAddAction();
			
		} else if (TimeSheetView.DELETE.equals(actionCommand)) {
			performDeleteAction();
			
		} else if (TimeSheetView.SAVE.equals(actionCommand)) {
			performSaveAction();
			
		} else if (TimeSheetView.PRINT.equals(actionCommand)) {
			
		}
		
	}
	
	private void performDeleteAction() {
		int selectedRow = view.getTblTimeSheet().getSelectedRow();
		try {
			timeSheetTransaction.delete(tableModel.getTimeSheets().get(selectedRow));
			setTimeSheetVAlue();
		} catch (IfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}




	private void performSaveAction() {
		
		List<TimeSheet> timeSheetList = tableModel.getTimeSheets();
		try {
			timeSheetTransaction.update(timeSheetList);
		} catch (IfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}




	private void performAddAction() {
		TimeSheet timeSheet = new TimeSheet();
		timeSheet.setDate(Util.convertDate(selectedDate));
		try {
			timeSheetTransaction.save(timeSheet);
			setTimeSheetVAlue();
		} catch (IfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}




	public void askTimeSheetView() {
		view = new TimeSheetView(mdiForm, this, tableModel);
		view.showTimeSheetScreen();
		setTimeSheetVAlue();
		
	}
	
	public void setTimeSheetVAlue() {
		TimeSheet timeSheet = new TimeSheet();
		timeSheet.setDate(Util.convertDate(selectedDate));
		try {
			tableModel.setTimeSheets(timeSheetTransaction.loadAll(timeSheet));
		} catch (IfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}