/**
 * 
 */
package org.cssa.iface.gui.timesheet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;

import org.cssa.iface.bo.TimeSheet;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.util.ErrorDialog;
import org.cssa.iface.report.timesheet.TimeSheetReport;
import org.cssa.iface.transaction.TimeSheetTransaction;
import org.cssa.iface.util.Util;

import com.itextpdf.text.DocumentException;

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
			
			performPrintAction();
			
		}
		
	}
	
	private void performPrintAction() {
		List<TimeSheet> timeSheets = tableModel.getTimeSheets();
		if(null != timeSheets) {
			String FILE = Util.getReportHome()+"\\Timesheet_"+tableModel.getTimeSheets().get(0).getDate()+".pdf";
			TimeSheetReport report = new TimeSheetReport(FILE, timeSheets);
			try {
				report.createReport();
			} catch (FileNotFoundException e) {
				new ErrorDialog(e).setVisible(true);
			} catch (DocumentException e) {
				new ErrorDialog(e).setVisible(true);
			}
		}
	}




	private void performDeleteAction() {
		int selectedRow = view.getTblTimeSheet().getSelectedRow();
		try {
			timeSheetTransaction.delete(tableModel.getTimeSheets().get(selectedRow));
			setTimeSheetVAlue();
		} catch (IfaceException e) {
			new ErrorDialog(e).setVisible(true);
		}
		
	}




	private void performSaveAction() {
		
		List<TimeSheet> timeSheetList = tableModel.getTimeSheets();
		try {
			timeSheetTransaction.update(timeSheetList);
		} catch (IfaceException e) {
			new ErrorDialog(e).setVisible(true);
		}
		
		
	}




	private void performAddAction() {
		TimeSheet timeSheet = new TimeSheet();
		try {
			timeSheet.setDate(Util.convertDate(selectedDate));
		} catch (IfaceException e1) {
			new ErrorDialog(e1).setVisible(true);
			e1.printStackTrace();
		}
		try {
			timeSheetTransaction.save(timeSheet);
			setTimeSheetVAlue();
		} catch (IfaceException e) {
			new ErrorDialog(e).setVisible(true);
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
		try {
			timeSheet.setDate(Util.convertDate(selectedDate));
		} catch (IfaceException e1) {
			new ErrorDialog(e1).setVisible(true);
			e1.printStackTrace();
		}
		try {
			tableModel.setTimeSheets(timeSheetTransaction.loadAll(timeSheet));
		} catch (IfaceException e) {
			new ErrorDialog(e).setVisible(true);
			e.printStackTrace();
		}
	}

}
