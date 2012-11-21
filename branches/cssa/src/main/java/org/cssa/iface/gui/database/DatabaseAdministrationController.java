package org.cssa.iface.gui.database;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.cssa.iface.bo.CollegeDetails;
import org.cssa.iface.bo.EventDetails;
import org.cssa.iface.bo.Events;
import org.cssa.iface.bo.InsertResult;
import org.cssa.iface.bo.Results;
import org.cssa.iface.bo.StudentDetails;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.events.EventTableModel;
import org.cssa.iface.gui.lookup.CollegeLookupTableModel;
import org.cssa.iface.gui.lookup.WinnerLookupTableModel;
import org.cssa.iface.gui.timesheet.TimeSheetTableModel;
import org.cssa.iface.gui.util.ErrorDialog;
import org.cssa.iface.infrastructure.CSSAConstants;
import org.cssa.iface.transaction.CollegeTransaction;
import org.cssa.iface.transaction.EventsDetailsTransaction;
import org.cssa.iface.transaction.EventsTransaction;
import org.cssa.iface.transaction.ResultsTransaction;
import org.cssa.iface.transaction.StudentTransaction;
import org.cssa.iface.transaction.TimeSheetTransaction;
import org.cssa.iface.transaction.TransactioUtils;
import org.cssa.iface.transaction.WinnerTransaction;
import org.cssa.iface.util.CssaMessage;
import org.cssa.iface.util.Util;


/**
 * 
 * @author ajith
 *
 */
public class DatabaseAdministrationController implements ActionListener, TreeExpansionListener, TreeSelectionListener {

	private CssaMDIForm mdiForm;
	private TableTreeModel tableTreeModel;
	private DatabaseAdministrationView view;
	private Util util;
	private TransactioUtils transactioUtils;
	private List<String> tableNames;
	private String tableName;
	private TableModel tableModel;
	private Object[] columnNames = {"Colunm1","Colunm2","Colunm3","Colunm4","Colunm5","Colunm6"};
	
	/**
	 * @param mdiForm
	 * @param tableTreeModel
	 */
	public DatabaseAdministrationController(CssaMDIForm mdiForm,
			TableTreeModel tableTreeModel) {
		this.mdiForm = mdiForm;
		this.tableTreeModel = tableTreeModel;
		util =  new Util();
		transactioUtils = new TransactioUtils();
		tableModel = new DefaultTableModel(columnNames, 0);
	}
	

	/**
	 * @param mdiForm
	 */
	public DatabaseAdministrationController(CssaMDIForm mdiForm) {
		this(mdiForm,null);
	}


	@Override
	public void treeExpanded(TreeExpansionEvent event) {
		performTreeExpansion();
		
	}

	private void performTreeExpansion() {
		try {
			
			List<String> tableNameList = transactioUtils.getAllTableNames();
			if(tableNameList.size() == 0) {
				int response = JOptionPane.showConfirmDialog(null, "There is no tables in database do you want to create tables ?", "Confirm",
				        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(response == JOptionPane.YES_OPTION) {
						transactioUtils.runScript(util.getScriptFile("Tablescript_ForDerby.sql"));
						CssaMessage.informationMessage(mdiForm, "Tables Created");
					}
				}
			
		} catch (IfaceException e) {
			new ErrorDialog(e).setVisible(true);
			e.printStackTrace();
		}
		
	}


	@Override
	public void treeCollapsed(TreeExpansionEvent event) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		TableItemNode node = (TableItemNode) view.getjTree().getLastSelectedPathComponent();
        if (node != null) {
    	   if(node.getTitle().equals("Tables")) {
    		   performTreeExpansion();
    	   } else if(node.getTitle().equals(CSSAConstants.TIMESHEET_TABLE)) {
    		   TimeSheetTableModel timeTableModel = new TimeSheetTableModel();
    		   try {
				timeTableModel.setTimeSheets(new TimeSheetTransaction().loadAll());
				view.getTblSearchResult().setModel(timeTableModel);
			} catch (IfaceException e1) {
				new ErrorDialog(e1).setVisible(true);
			}
    		   
    	   } else if (node.getTitle().equals(CSSAConstants.EVENTS_TABLE)) {
    		   EventTableModel eventTableModel = new EventTableModel();
				List<Events> eventList = null;
				try {
					eventList = new EventsTransaction().loadAll();
					eventTableModel.setEventList(eventList);
					view.getTblSearchResult().setModel(eventTableModel);
				} catch (IfaceException e1) {
					new ErrorDialog(e1).setVisible(true);
					e1.printStackTrace();
				}
    	   } else if (node.getTitle().equals(CSSAConstants.STUDENTS_DETAILS_TABLE)) {
    		   StudentDetailsTableModel tableModel = new StudentDetailsTableModel();
				List<StudentDetails> studentDetails = null;
				try {
					studentDetails = new StudentTransaction().loadAll();
					tableModel.setStudents(studentDetails);
					view.getTblSearchResult().setModel(tableModel);
				} catch (IfaceException e1) {
					new ErrorDialog(e1).setVisible(true);
					e1.printStackTrace();
				}
    	   } else if (node.getTitle().equals(CSSAConstants.COLLEGE_DETAILS_TABLE)) {
    		   CollegeLookupTableModel tableModel = new CollegeLookupTableModel();
				List<CollegeDetails> collegeDetails = null;
				try {
					collegeDetails = new CollegeTransaction().loadAll();
					tableModel.setCollegeList(collegeDetails);
					view.getTblSearchResult().setModel(tableModel);
				} catch (IfaceException e1) {
					new ErrorDialog(e1).setVisible(true);
					e1.printStackTrace();
				}
				 
			
    	   } else if (node.getTitle().equals(CSSAConstants.EVENT_DETAILS_TABLE)) {
    		   EventDetailsTableModel tableModel = new EventDetailsTableModel();
				List<EventDetails> eventDetails = null;
				try {
					eventDetails = new EventsDetailsTransaction().loadAll();
					tableModel.setEventDetails(eventDetails);
					view.getTblSearchResult().setModel(tableModel);
				} catch (IfaceException e1) {
					new ErrorDialog(e1).setVisible(true);
					e1.printStackTrace();
				}
				
		} else if (node.getTitle().equals(CSSAConstants.RESULTS_TABLE)) {
			ResultTableModel tableModel = new ResultTableModel();
			List<Results> resultsDetails = null;
			try {
				resultsDetails = new ResultsTransaction().loadAll();
				tableModel.setResultList(resultsDetails);
				view.getTblSearchResult().setModel(tableModel);
			} catch (IfaceException e1) {
				new ErrorDialog(e1).setVisible(true);
				e1.printStackTrace();
			}
			
		} else if (node.getTitle().equals(CSSAConstants.WINNERS_TABLE)) {
			WinnerLookupTableModel tableModel = new WinnerLookupTableModel();
			List<InsertResult> results = null;
			try {
				results = new WinnerTransaction().loadAll();
				tableModel.setWinnerList(results);
				view.getTblSearchResult().setModel(tableModel);
			} catch (IfaceException e1) {
				new ErrorDialog(e1).setVisible(true);
				e1.printStackTrace();
			}
			
		}
			
        }
    }
		
	
	
	public void showAdministrationView() {
		try {
			tableNames = transactioUtils.getAllTableNames();
			
		} catch (IfaceException e) {
			new ErrorDialog(e).setVisible(true);
			e.printStackTrace();
		}
		
		TableItemNode tableItemNode = TableTreeBuilder.build();
		tableTreeModel  = new TableTreeModel(tableItemNode);
		
		view = new DatabaseAdministrationView(this, mdiForm, tableTreeModel, tableModel);
		view.showSearchResultScreen();
	}

}