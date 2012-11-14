/**
 * 
 */
package org.cssa.iface.gui.database;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.table.AbstractTableModel;


import org.cssa.iface.bo.CollegeDetails;
import org.cssa.iface.bo.EventDetails;
import org.cssa.iface.bo.Events;
import org.cssa.iface.bo.InsertResult;
import org.cssa.iface.bo.Results;
import org.cssa.iface.bo.StudentDetails;
import org.cssa.iface.bo.TimeSheet;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.events.EventTableModel;
import org.cssa.iface.gui.lookup.CollegeLookupTableModel;
import org.cssa.iface.gui.lookup.WinnerLookupTableModel;
import org.cssa.iface.gui.timesheet.TimeSheetTableModel;
import org.cssa.iface.gui.util.ErrorDialog;
import org.cssa.iface.infrastructure.CSSAConstants;
import org.cssa.iface.report.ReportService;
import org.cssa.iface.report.college.CollegeLookupReport;
import org.cssa.iface.report.database.EventDetailsTableReport;
import org.cssa.iface.report.database.ResultTableReport;
import org.cssa.iface.report.database.StudentDetailsTableReport;
import org.cssa.iface.report.event.EventReport;
import org.cssa.iface.report.timesheet.TimeSheetReport;
import org.cssa.iface.report.winners.WinnersReport;
import org.cssa.iface.transaction.CollegeTransaction;
import org.cssa.iface.transaction.EventsDetailsTransaction;
import org.cssa.iface.transaction.EventsTransaction;
import org.cssa.iface.transaction.ResultsTransaction;
import org.cssa.iface.transaction.StudentTransaction;
import org.cssa.iface.transaction.TimeSheetTransaction;
import org.cssa.iface.transaction.WinnerTransaction;
import org.cssa.iface.util.Util;

import com.itextpdf.text.DocumentException;

/**
 * @author ajith
 *
 */
public class DatabaseViewController implements ActionListener {
	
	private String tableName;
	private CssaMDIForm mdiForm;
	private DatabaseView databaseView;
	
	

	/**
	 * @param tableName
	 * @param mdiForm
	 */
	public DatabaseViewController(String tableName, CssaMDIForm mdiForm) {
		this.tableName = tableName;
		this.mdiForm = mdiForm;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(DatabaseView.PRINT.equals(actionCommand)) {
			performPrintAction();
		} else if (DatabaseView.CANCEL.equals(actionCommand)) {
			performCancelAction();
		} else if (DatabaseView.CLEAR.equals(actionCommand)) {
			performClearAction();
		}
		
	}
	
	private void performClearAction() {
		// TODO Auto-generated method stub
		
	}



	private void performCancelAction() {
		mdiForm.closeFrame();
		
	}



	private void performPrintAction() {
		if(null != tableName) {
			if(CSSAConstants.EVENTS_TABLE.equals(tableName)) {
				String FILE = Util.getReportHome()+"\\EventTable.pdf";
				List<Events> events =((EventTableModel) databaseView.getTblSearchResult().getModel()).getEventList();
				if(null != events) {
					EventReport report = new EventReport(FILE, events);
					try {
						report.createReport();
					} catch (FileNotFoundException e) {
						new ErrorDialog(e).setVisible(true);
					} catch (DocumentException e) {
						new ErrorDialog(e).setVisible(true);
					}
				} 
			}else if (CSSAConstants.EVENT_DETAILS_TABLE.equals(tableName)) {
				String FILE = Util.getReportHome()+"\\Event_DetailsTable.pdf";
				List<EventDetails> events =((EventDetailsTableModel) databaseView.getTblSearchResult().getModel()).getEventDetails();
				if(null != events) {
					EventDetailsTableReport report = new EventDetailsTableReport(FILE, events);
					try {
						report.createReport();
					} catch (FileNotFoundException e) {
						new ErrorDialog(e).setVisible(true);
					} catch (DocumentException e) {
						new ErrorDialog(e).setVisible(true);
					}
				} 
			} else if (CSSAConstants.WINNERS_TABLE.equals(tableName)) {
				List<InsertResult> list = ((WinnerLookupTableModel) databaseView.getTblSearchResult().getModel()).getWinnerList();
				String FILE = Util.getReportHome()+"\\WinnersTable.pdf";
				if(null != list) {
					ReportService report = new WinnersReport(FILE, list);
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
			} else if (CSSAConstants.STUDENTS_DETAILS_TABLE.equals(tableName)) {
				String FILE = Util.getReportHome()+"\\StudentDetailsReport.pdf";
				List<StudentDetails> student = ((StudentDetailsTableModel) databaseView.getTblSearchResult().getModel()).getStudents();
				if(null != student) {
					StudentDetailsTableReport report = new StudentDetailsTableReport(FILE, student);
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
			} else if (CSSAConstants.COLLEGE_DETAILS_TABLE.equals(tableName)) {
				String FILE = Util.getReportHome()+"\\CollegeDetailsReport.pdf";
				List<CollegeDetails> college = ((CollegeLookupTableModel) databaseView.getTblSearchResult().getModel()).getCollegeList();
				if(null != college) {
					CollegeLookupReport report = new CollegeLookupReport(FILE, college);
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
			} else if (CSSAConstants.RESULTS_TABLE.equals(tableName)) {
				String FILE = Util.getReportHome()+"\\ResultTableReport.pdf";
				List<Results> student = ((ResultTableModel) databaseView.getTblSearchResult().getModel()).getResultList();
				if(null != student) {
					ResultTableReport report = new ResultTableReport(FILE, student);
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
			} else if (CSSAConstants.TIMESHEET_TABLE.equals(tableName)) {
				List<TimeSheet> timeSheets = ((TimeSheetTableModel) databaseView.getTblSearchResult().getModel()).getTimeSheets();
				if(null != timeSheets) {
					String FILE = Util.getReportHome()+"\\TimeSheetTable.pdf";
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
				
			
		}
		
	}



	public void showDatabaseView() {
		if(null != tableName) {
			if(CSSAConstants.EVENTS_TABLE.equals(tableName)) {
				EventTableModel eventTableModel = new EventTableModel();
				List<Events> eventList = null;
				try {
					eventList = new EventsTransaction().loadAll();
				} catch (IfaceException e) {
					new ErrorDialog(e).setVisible(true);
					e.printStackTrace();
				}
				eventTableModel.setEventList(eventList);
				databaseView = new DatabaseView(this, eventTableModel, mdiForm);
				databaseView.showSearchResultScreen();
			} else if (CSSAConstants.STUDENTS_DETAILS_TABLE.equals(tableName)) {
				StudentDetailsTableModel tableModel = new StudentDetailsTableModel();
				List<StudentDetails> studentDetails = null;
				try {
					studentDetails = new StudentTransaction().loadAll();
					
				} catch (IfaceException e) {
					new ErrorDialog(e).setVisible(true);
					e.printStackTrace();
				}
				tableModel.setStudents(studentDetails);
				databaseView = new DatabaseView(this, tableModel, mdiForm);
				databaseView.showSearchResultScreen();
				
			} else if (CSSAConstants.COLLEGE_DETAILS_TABLE.equals(tableName)) {
				CollegeLookupTableModel tableModel = new CollegeLookupTableModel();
				List<CollegeDetails> collegeDetails = null;
				try {
					collegeDetails = new CollegeTransaction().loadAll();
					
				} catch (IfaceException e) {
					new ErrorDialog(e).setVisible(true);
					e.printStackTrace();
				}
				tableModel.setCollegeList(collegeDetails);
				databaseView = new DatabaseView(this, tableModel, mdiForm);
				databaseView.showSearchResultScreen();
				
			} else if (CSSAConstants.EVENT_DETAILS_TABLE.equals(tableName)) {
				EventDetailsTableModel tableModel = new EventDetailsTableModel();
				List<EventDetails> eventDetails = null;
				try {
					eventDetails = new EventsDetailsTransaction().loadAll();
					
				} catch (IfaceException e) {
					new ErrorDialog(e).setVisible(true);
					e.printStackTrace();
				}
				tableModel.setEventDetails(eventDetails);
				databaseView = new DatabaseView(this, tableModel, mdiForm);
				databaseView.showSearchResultScreen();
				
			} else if (CSSAConstants.RESULTS_TABLE.equals(tableName)) {
				ResultTableModel tableModel = new ResultTableModel();
				List<Results> resultsDetails = null;
				try {
					resultsDetails = new ResultsTransaction().loadAll();
					
				} catch (IfaceException e) {
					new ErrorDialog(e).setVisible(true);
					e.printStackTrace();
				}
				tableModel.setResultList(resultsDetails);
				databaseView = new DatabaseView(this, tableModel, mdiForm);
				databaseView.showSearchResultScreen();
				
				
			} else if (CSSAConstants.WINNERS_TABLE.equals(tableName)) {
				
				WinnerLookupTableModel tableModel = new WinnerLookupTableModel();
				List<InsertResult> results = null;
				try {
					results = new WinnerTransaction().loadAll();
				} catch (IfaceException e) {
					new ErrorDialog(e).setVisible(true);
					e.printStackTrace();
				}
				tableModel.setWinnerList(results);
				databaseView = new DatabaseView(this, tableModel, mdiForm);
				databaseView.showSearchResultScreen();
				
			} else if (CSSAConstants.TIMESHEET_TABLE.equals(tableName)) {
				TimeSheetTableModel tableModel = new TimeSheetTableModel();
				List<TimeSheet> timeSheet = null;
				try {
					timeSheet = new TimeSheetTransaction().loadAll();
					
				} catch (IfaceException e) {
					new ErrorDialog(e).setVisible(true);
					e.printStackTrace();
				}
				tableModel.setTimeSheets(timeSheet);
				databaseView = new DatabaseView(this, tableModel, mdiForm);
				databaseView.showSearchResultScreen();
				
			} else if (CSSAConstants.SEMINAR_DETAILS_TABLE.equals(tableName)) {
				//Coming next version 
			}
			
		}
	}

}
