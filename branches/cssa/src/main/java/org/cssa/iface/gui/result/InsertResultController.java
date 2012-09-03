package org.cssa.iface.gui.result;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import org.cssa.iface.bo.Events;
import org.cssa.iface.bo.InsertResultsTableBo;
import org.cssa.iface.bo.Results;
import org.cssa.iface.bo.StudentDetails;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.lookup.StudentLookupController;
import org.cssa.iface.services.LookupService;
import org.cssa.iface.transaction.EventsTransaction;
import org.cssa.iface.transaction.TransactioUtils;

public class InsertResultController implements ActionListener, LookupService<StudentDetails> {

	private Results results;
	private List<Events> events;
	private List<InsertResultsTableBo> resultsTableBos;
	private CssaMDIForm mdiForm;
	private InsertResultView resultView;
	private InsertResultTableModel tableModel;
	private StudentDetails studentDetails;
	
	
	private TransactioUtils transactioUtils;
	private EventsTransaction eventsTransaction;
	
	public InsertResultController(CssaMDIForm mdiForm) {
		super();
		this.mdiForm = mdiForm;
		tableModel = new InsertResultTableModel();
		studentDetails = new StudentDetails();
		transactioUtils = new TransactioUtils();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals(InsertResultView.SEARCH)){
			StudentLookupController studentLookupController = new StudentLookupController(mdiForm, this);
			studentLookupController.askStudentLookupsereen();
			
		}
	}
	
	public void askInsertResultView() {
		resultView = new InsertResultView(this, mdiForm, tableModel);				
		resultView.showInsertResultScreen();
		setEventId();
		setResultStatus();
	}
	
	/*public void setStudent(StudentDetails studentDetails) {
		resultView.setStudentId(studentDetails.getStudentId());
		resultView.setCollegeId(studentDetails.getCollegeId());
	}*/

	@Override
	public void setResult(StudentDetails studentDetails) {
		results = new Results();
		resultView.setStudentId(studentDetails.getStudentId());
		resultView.setCollegeId(studentDetails.getCollegeId());
		
		results.setCollegeId(studentDetails.getCollegeId());
		results.setStudentId(studentDetails.getStudentId());
		results.setEventId(resultView.getEventCode());
		
		try {
			resultsTableBos = transactioUtils.getGroupResult(results);
			tableModel.setResultsTableBos(resultsTableBos);
		} catch (IfaceException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setResultStatus() {
		resultView.getCmbEventStage().addItem("");
		resultView.getCmbEventStage().addItem("Final");
		resultView.getCmbEventStage().addItem("Prelims");
		resultView.getCmbEventStage().setSelectedItem("");
	}
	
	public void setEventId() {
		eventsTransaction = new EventsTransaction();
		try {
			events = eventsTransaction.loadAll();
			for(Events event : events) {
				resultView.getCmbEventId().addItem(event.getEventId());
			}
		} catch (IfaceException e) {
			e.printStackTrace();
		}
	}

}
