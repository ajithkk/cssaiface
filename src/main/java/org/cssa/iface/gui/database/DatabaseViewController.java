/**
 * 
 */
package org.cssa.iface.gui.database;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.AbstractTableModel;


import org.cssa.iface.bo.CollegeDetails;
import org.cssa.iface.bo.EventDetails;
import org.cssa.iface.bo.Events;
import org.cssa.iface.bo.Results;
import org.cssa.iface.bo.StudentDetails;
import org.cssa.iface.bo.TimeSheet;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.events.EventTableModel;
import org.cssa.iface.gui.lookup.CollegeLookupTableModel;
import org.cssa.iface.gui.timesheet.TimeSheetTableModel;
import org.cssa.iface.infrastructure.CSSAConstants;
import org.cssa.iface.transaction.CollegeTransaction;
import org.cssa.iface.transaction.EventsDetailsTransaction;
import org.cssa.iface.transaction.EventsTransaction;
import org.cssa.iface.transaction.ResultsTransaction;
import org.cssa.iface.transaction.StudentTransaction;
import org.cssa.iface.transaction.TimeSheetTransaction;

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
		// TODO Auto-generated method stub
		
	}



	private void performPrintAction() {
		// TODO Auto-generated method stub
		
	}



	public void showDatabaseView() {
		if(null != tableName) {
			if(CSSAConstants.EVENTS_TABLE.equals(tableName)) {
				EventTableModel eventTableModel = new EventTableModel();
				List<Events> eventList = null;
				try {
					eventList = new EventsTransaction().loadAll();
				} catch (IfaceException e) {
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
					e.printStackTrace();
				}
				tableModel.setResultList(resultsDetails);
				databaseView = new DatabaseView(this, tableModel, mdiForm);
				databaseView.showSearchResultScreen();
				
				
			} else if (CSSAConstants.WINNERS_TABLE.equals(tableName)) {
				
			} else if (CSSAConstants.TIMESHEET_TABLE.equals(tableName)) {
				TimeSheetTableModel tableModel = new TimeSheetTableModel();
				List<TimeSheet> timeSheet = null;
				try {
					timeSheet = new TimeSheetTransaction().loadAll();
					
				} catch (IfaceException e) {
					e.printStackTrace();
				}
				tableModel.setTimeSheets(timeSheet);
				databaseView = new DatabaseView(this, tableModel, mdiForm);
				databaseView.showSearchResultScreen();
				
			} else if (CSSAConstants.SEMINAR_DETAILS_TABLE.equals(tableName)) {
				
			}
			
		}
	}

}
