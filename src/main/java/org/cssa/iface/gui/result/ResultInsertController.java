/**
 * 
 */
package org.cssa.iface.gui.result;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.cssa.iface.bo.CollegeDetails;
import org.cssa.iface.bo.Events;
import org.cssa.iface.bo.InsertResult;
import org.cssa.iface.bo.StudentDetails;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.lookup.CollegeLookupController;
import org.cssa.iface.gui.lookup.StudentLookupController;
import org.cssa.iface.gui.util.ErrorDialog;
import org.cssa.iface.services.CollegeLookupService;
import org.cssa.iface.services.LookupController;
import org.cssa.iface.services.StudentLookupService;
import org.cssa.iface.transaction.EventsTransaction;
import org.cssa.iface.transaction.ResultsTransaction;
import org.cssa.iface.transaction.TransactioUtils;
import org.cssa.iface.util.CssaMessage;
import org.cssa.iface.util.EventStorageXML;

/**
 * @author ajith
 *
 */
public class ResultInsertController implements ActionListener,CollegeLookupService<CollegeDetails>, LookupController, StudentLookupService<StudentDetails> {
	
	private boolean editMode;
	
	private CssaMDIForm mdiForm;
	private ResultInsertView resultInsertView;
	private ResultInsertTableModel tableModel;
	private TransactioUtils transactioUtils;
	private EventsTransaction eventsTransaction;
	private List<Events> events;
	private Map<String, String> eventStateMap;
	
	/**
	 * @param mdiForm
	 */
	public ResultInsertController(CssaMDIForm mdiForm) {
		this(mdiForm, false);
	}
	
	/**
	 * @param mdiForm
	 */
	public ResultInsertController(CssaMDIForm mdiForm , boolean editMode) {
		
		this.mdiForm = mdiForm;
		tableModel = new ResultInsertTableModel();
		this.editMode = editMode;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		String actionCommand = e.getActionCommand();
		
		if(actionCommand.equals(ResultInsertView.CANCEL)) {
			cancelAction();
			
		} else if (actionCommand.equals(ResultInsertView.CLEAR)) {
			clearAction();
			
		} else if (actionCommand.equals(ResultInsertView.SEARCH)) {
			searchAction();
			
		} else if (actionCommand.equals(ResultInsertView.SAVE)) {
			performSaveAction();
			
		} else if (actionCommand.equals(ResultInsertView.COLLEGE_SEARCH)) {
			
			CollegeLookupController collegeLookupController = new CollegeLookupController(mdiForm, this);
			collegeLookupController.askCollegeLookupView();
			
		} else if (actionCommand.equals(ResultInsertView.STUDENT_SEARCH)) {
			
			StudentLookupController studentLookupController = new StudentLookupController(mdiForm, this);
			studentLookupController.askStudentLookupsereen();
		}
	}

	private void performSaveAction() {
		ResultsTransaction resultsTransaction = new ResultsTransaction();
		if(!editMode) {
			try {
				resultsTransaction.save(tableModel.getResultList(), resultInsertView.getCmbEventStage().getSelectedItem().toString());
			     CssaMessage.informationMessage(mdiForm, "Successuflly insert the result" , "Insert Result");
			} catch (IfaceException e) {
				new ErrorDialog(e).setVisible(true);
				e.printStackTrace();
			}
		} else {
			try {
				resultsTransaction.update(tableModel.getResultList(), resultInsertView.getCmbEventStage().getSelectedItem().toString());
				CssaMessage.informationMessage(mdiForm, "Successuflly update the result" , "Update Result");
			} catch (IfaceException e) {
				new ErrorDialog(e).setVisible(true);
				e.printStackTrace();
			}
		}
		
	}


	public void askResultInsertView() {
		
		resultInsertView = new ResultInsertView(mdiForm, this, tableModel);
		resultInsertView.showResultInsertScreen();
		setEventId();
		setEventState();
	}
	
	@Override
	public void setSelectedCollege(CollegeDetails collegeDetails) {
		 if(null != collegeDetails) {
			 resultInsertView.setTxtCollegeId(collegeDetails.getCollegeId());
		 }
		
	}


	@Override
	public void searchAction() {
		transactioUtils = new TransactioUtils();
		InsertResult inResult = new InsertResult();
		inResult.setCollegeId(resultInsertView.getTxtCollegeId());
		inResult.setStudentId(resultInsertView.getTxtStudentId());
		if(resultInsertView.getCmbEventStage().getSelectedIndex() > 0) {
			inResult.setEventStatus(resultInsertView.getCmbEventStage().getSelectedItem().toString());
		}
		if(resultInsertView.getCmbEventCode().getSelectedIndex() > 0) {
			inResult.setEventName(resultInsertView.getCmbEventCode().getSelectedItem().toString());
		} 
		try {
			List<InsertResult> participantList = transactioUtils.getParticipantsList(inResult,editMode);
			tableModel.setResultList(participantList);
		} catch (IfaceException e) {
			new ErrorDialog(e).setVisible(true);
		}

	}


	@Override
	public void clearAction() {
		resultInsertView.setTxtCollegeId("");
		resultInsertView.getCmbEventCode().setSelectedIndex(0);
		resultInsertView.getCmbEventStage().setSelectedIndex(0);
		
	}


	@Override
	public void cancelAction() {
		mdiForm.closeFrame();
	}
	
	private void setEventId() {
		eventsTransaction = new EventsTransaction();
		try {
			events = eventsTransaction.loadAll();
			resultInsertView.getCmbEventCode().addItem("please select");

			for(Events event : events) {
				resultInsertView.getCmbEventCode().addItem(event.getEventId());
			}
		} catch (IfaceException e) {
			new ErrorDialog(e).setVisible(true);
		}
	}
	
	private void setEventState() {
		EventStorageXML eventStorageXML = new EventStorageXML();
		eventStateMap = eventStorageXML.getEventStageMap();
		
		resultInsertView.getCmbEventStage().addItem("please select");
		Set<Map.Entry<String, String>> eventStateSet = eventStateMap.entrySet();
		for(Map.Entry<String, String> set : eventStateSet) {
			resultInsertView.getCmbEventStage().addItem(set.getValue());
		}
		
	}


	@Override
	public void setSelectedStudent(StudentDetails studentDetails) {
		if(null != studentDetails) {
			resultInsertView.setTxtCollegeId(studentDetails.getCollegeId());
			resultInsertView.setTxtStudentId(studentDetails.getStudentId());
		}
	}

 
}
