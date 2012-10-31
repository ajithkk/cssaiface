/**
 * 
 */
package org.cssa.iface.gui.lookup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.cssa.iface.bo.Events;
import org.cssa.iface.bo.InsertResult;
import org.cssa.iface.bo.InsertResultsTableBo;
import org.cssa.iface.bo.StudentDetails;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.util.ErrorDialog;
import org.cssa.iface.services.LookupController;
import org.cssa.iface.services.LookupService;
import org.cssa.iface.services.StudentLookupService;
import org.cssa.iface.transaction.EventsTransaction;
import org.cssa.iface.transaction.TransactioUtils;
import org.cssa.iface.util.EventStorageXML;

/**
 * @author Ajith
 *
 */
public class ParticipantLookupController implements ActionListener, MouseListener, LookupController, StudentLookupService<StudentDetails> {
	
	private CssaMDIForm mdiForm;
	private EventsTransaction eventsTransaction;
	private ParticipantLookupTableModel tableModel;
	private ParticipantLookupView lookupView;
	private List<InsertResultsTableBo> resultsTableBos;
	private LookupService<InsertResult> insertResult;
	private InsertResultsTableBo tableBo;
	private List<Events> events;
	
	
	/**
	 * constructor
	 * @param mdiForm
	 */
	public ParticipantLookupController(CssaMDIForm mdiForm) {
		this.mdiForm = mdiForm;
		tableModel = new ParticipantLookupTableModel();
		insertResult = null;
	}
	
	

	/**
	 * @param mdiForm
	 * @param insertResult
	 */
	public ParticipantLookupController(CssaMDIForm mdiForm,
			LookupService<InsertResult> insertResult) {
		super();
		this.mdiForm = mdiForm;
		this.insertResult = insertResult;
		tableModel = new ParticipantLookupTableModel();
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		
		int selectedRow = lookupView.getTblParticipants().getSelectedRow();
		InsertResult selectedResult = tableModel.getResultsTableBos().get(selectedRow);
		if(null != insertResult) {
			mdiForm.closeFrame();
			insertResult.setResult(selectedResult);
		}
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(ParticipantLookupView.SEARCH.equals(actionCommand)) {
			searchAction();
			
		} else if(ParticipantLookupView.CANCEL.equals(actionCommand)) {
			cancelAction();
			
		} else if (ParticipantLookupView.CLEAR.equals(actionCommand)) {
			clearAction();
		} else if (ParticipantLookupView.STUDENT_SEARCH.equals(actionCommand)) {
			StudentLookupController studentLookupController = new StudentLookupController(mdiForm, this);
			studentLookupController.askStudentLookupsereen();
		}
	}


	@Override
	public void searchAction() {
		
		TransactioUtils transactioUtils = new TransactioUtils();
		InsertResult insertResult = new InsertResult();
		insertResult.setCollegeId(lookupView.getTxtCollegeId());
		insertResult.setStudentId(lookupView.getTxtStudentId());
		if(lookupView.getCmbEventStage().getSelectedIndex() > 0) {
			insertResult.setEventStatus(lookupView.getCmbEventStage().getSelectedItem().toString());
		}
		if(lookupView.getCmbEventCode().getSelectedIndex() > 0) {
			insertResult.setEventName(lookupView.getCmbEventCode().getSelectedItem().toString());
		}
		try {
			List<InsertResult> winnersList = transactioUtils.getWinnersParticipantsList(insertResult);
			tableModel.setResultsTableBos(winnersList);
		} catch (IfaceException e) {
			new ErrorDialog(e).setVisible(true);
		}
	}



	@Override
	public void clearAction() {
		
	}



	@Override
	public void cancelAction() {
		mdiForm.closeFrame();
		
	}
	
	public void askParticipantsLookupView() {
		lookupView = new ParticipantLookupView(mdiForm, this, tableModel);
		lookupView.showLookupView();
		setEventId();
		setEventState();
		
	}
	
	public void setEventId() {
		eventsTransaction = new EventsTransaction();
		try {
			 events = eventsTransaction.loadAll();
			lookupView.getCmbEventCode().addItem("please select");
			for(Events event : events) {
				lookupView.getCmbEventCode().addItem(event.getEventId());
			}
		} catch (IfaceException e) {
			new ErrorDialog(e).setVisible(true);
		}
	}
	
	private void setEventState() {
		EventStorageXML eventStorageXML = new EventStorageXML();
		Map<String, String> eventStateMap = eventStorageXML.getEventStageMap();
		
		lookupView.getCmbEventStage().addItem("please select");
		Set<Map.Entry<String, String>> eventStateSet = eventStateMap.entrySet();
		for(Map.Entry<String, String> set : eventStateSet) {
			lookupView.getCmbEventStage().addItem(set.getValue());
		}
		
	}

	@Override
	public void setSelectedStudent(StudentDetails studentDetails) {
		
		if(null != studentDetails) {
			lookupView.setTxtCollegeId(studentDetails.getCollegeId());
			lookupView.setTxtStudentId(studentDetails.getStudentId());
		}
		
		
	}

}
