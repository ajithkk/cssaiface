package org.cssa.iface.gui.result;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import org.cssa.iface.bo.Events;
import org.cssa.iface.bo.InsertResult;
import org.cssa.iface.bo.InsertResultsTableBo;
import org.cssa.iface.bo.Results;
import org.cssa.iface.bo.StudentDetails;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.lookup.ParticipantLookupController;
import org.cssa.iface.gui.lookup.StudentLookupController;
import org.cssa.iface.gui.util.ErrorDialog;
import org.cssa.iface.services.LookupService;
import org.cssa.iface.services.StudentLookupService;
import org.cssa.iface.transaction.EventsTransaction;
import org.cssa.iface.transaction.TransactioUtils;
import org.cssa.iface.transaction.WinnerTransaction;
import org.cssa.iface.util.CssaMessage;
/**
 * 
 * @author admin
 *
 */

public class InsertResultController implements ActionListener, LookupService<InsertResult>{

	private boolean editMode;
	private CssaMDIForm mdiForm;
	private InsertResultView resultView;
	private InsertResultTableModel tableModel;
	private StudentDetails studentDetails;
	private List<InsertResult> insertResults;
	
	
	private TransactioUtils transactioUtils;
	private WinnerTransaction winnerTransaction;
	
	public InsertResultController(CssaMDIForm mdiForm) {
		this(mdiForm, false);
		
	}
	
	public InsertResultController(CssaMDIForm mdiForm, boolean editMode) {
		this.mdiForm = mdiForm;
		this.editMode = editMode;
		tableModel = new InsertResultTableModel();
		studentDetails = new StudentDetails();
		transactioUtils = new TransactioUtils();
		winnerTransaction = new WinnerTransaction();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals(InsertResultView.SEARCH)){
			
			ParticipantLookupController participantLookupController = new ParticipantLookupController(mdiForm, this);
			participantLookupController.askParticipantsLookupView();
		}
		
		if(actionCommand.equals(InsertResultView.INSERT)) {
			if(null != tableModel.getResultsTableBos()) {
				performSaveAction();
			}
		}
		
	}
	
	private void performSaveAction() {
		if(null != insertResults) {
			try {
				String winnerStatus  = resultView.getCmbResultStatus().getSelectedIndex() > 0 ?  resultView.getCmbResultStatus().getSelectedItem().toString() : null;
				if(null == winnerStatus) {
					CssaMessage.informationMessage(mdiForm, "Please select winner position");
				} else {     
					winnerTransaction.saveAll( insertResults,winnerStatus );
					CssaMessage.informationMessage(mdiForm, "Successfully Inserted");
				}
			} catch (IfaceException e) {
				e.printStackTrace();
				new ErrorDialog(e).setVisible(true);
			}
		}
		
	}

	public void askInsertResultView() {
		resultView = new InsertResultView(this, mdiForm, tableModel);				
		resultView.showInsertResultScreen();
//		setEventId();
		setResultStatus();
	}
	
	/*public void setStudent(StudentDetails studentDetails) {
		resultView.setStudentId(studentDetails.getStudentId());
		resultView.setCollegeId(studentDetails.getCollegeId());
	}*/

//	@Override
//	public void setResult(StudentDetails studentDetails) {
//		results = new Results();
//		resultView.setStudentId(studentDetails.getStudentId());
//		resultView.setCollegeId(studentDetails.getCollegeId());
//		
//		results.setCollegeId(studentDetails.getCollegeId());
//		results.setStudentId(studentDetails.getStudentId());
//		results.setEventId(resultView.getEventCode());
//		
//		try {
//			resultsTableBos = transactioUtils.getGroupResult(results);
//			tableModel.setResultsTableBos(resultsTableBos);
//		} catch (IfaceException e) {
//			e.printStackTrace();
//		}
//		
//	}
	

	public void setResultStatus() {
		resultView.getCmbResultStatus().addItem("please select");
		resultView.getCmbResultStatus().addItem("First");
		resultView.getCmbResultStatus().addItem("Second");
	}
	
	
//	public void setEventId() {
//		eventsTransaction = new EventsTransaction();
//		try {
//			events = eventsTransaction.loadAll();
//			resultView.getCmbEventId().addItem("please select");
//			for(Events event : events) {
//				resultView.getCmbEventId().addItem(event.getEventId());
//			}
//		} catch (IfaceException e) {
//			e.printStackTrace();
//		}
//	}

	/*@Override
	public void setSelectedStudent(StudentDetails studentDetail) {
		results = new Results();
		resultView.setStudentId(studentDetail.getStudentId());
		resultView.setCollegeId(studentDetail.getCollegeId());
		
		results.setCollegeId(studentDetail.getCollegeId());
		results.setStudentId(studentDetail.getStudentId());
		results.setEventId(resultView.getEventCode());
		
		try {
			resultsTableBos = transactioUtils.getGroupResult(results);
			tableModel.setResultsTableBos(resultsTableBos);
		} catch (IfaceException ex) {
			ex.printStackTrace();
		}
		
		
	}
*/
	@Override
	public void setResult(InsertResult e) {
		resultView.setStudentId(e.getStudentId());
		resultView.setCollegeId(e.getCollegeId());
		resultView.setTxtEventName(e.getEventName());
		try {
			List<InsertResult> insertResults = transactioUtils.getWinnersParticipantsList(e);
			tableModel.setResultsTableBos(insertResults);
			
		} catch (IfaceException e1) {
			new ErrorDialog(e1).setVisible(true);
			e1.printStackTrace();
		}
		resultView.setTxtEventName(e.getEventName());
		try {
			insertResults = transactioUtils.getWinnersParticipantsList(e);
			tableModel.setResultsTableBos(insertResults);
			
		} catch (IfaceException e1) {
			new ErrorDialog(e1).setVisible(true);
			e1.printStackTrace();
		}
		
	}

}
