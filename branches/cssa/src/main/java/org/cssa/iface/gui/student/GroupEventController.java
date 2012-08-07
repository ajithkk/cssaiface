/**
 * 
 */
package org.cssa.iface.gui.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

import org.cssa.iface.bo.EventDetails;
import org.cssa.iface.bo.Events;
import org.cssa.iface.bo.StudentDetails;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.transaction.EventsDetailsTransaction;
import org.cssa.iface.transaction.EventsTransaction;
import org.cssa.iface.transaction.StudentTransaction;

/**
 * @author ajith
 *
 */
public class GroupEventController implements ActionListener{
	
	private List<StudentDetails> studentDetails;
	private List<EventDetails> eventDetails;
	private List<Events> events;
	
	private GroupEventTableModel tableModel;
	private GroupEventView groupEventView;
	private CssaMDIForm mdiForm;
	
	private StudentTransaction studentTransaction;
	private EventsTransaction eventsTransaction;
	private EventsDetailsTransaction eventsDetailsTransaction;
	
	private Vector<String> addStudent;
	private String preSelectedEvent = null;
	
	public GroupEventController() {
		tableModel = new GroupEventTableModel();
		//groupEventView = new GroupEventView();
		addStudent = new Vector<String>();
		eventDetails = new ArrayList<EventDetails>();
		eventsDetailsTransaction = new EventsDetailsTransaction();
	
	}

	/**
	 * @param studentDetails
	 * @param mdiForm
	 */
	public GroupEventController(List<StudentDetails> studentDetails,
			CssaMDIForm mdiForm) {
		super();
		this.studentDetails = studentDetails;
		this.mdiForm = mdiForm;
		//groupEventView = new GroupEventView();
		tableModel = new GroupEventTableModel();
		addStudent = new Vector<String>();
		eventDetails = new ArrayList<EventDetails>();
		eventsDetailsTransaction = new EventsDetailsTransaction();
	}

	/**
	 * @param studentDetails
	 */
	public GroupEventController(List<StudentDetails> studentDetails) {
		super();
		this.studentDetails = studentDetails;
		//groupEventView = new GroupEventView();
		tableModel = new GroupEventTableModel();
		addStudent = new Vector<String>();
		eventDetails = new ArrayList<EventDetails>();
		eventsDetailsTransaction = new EventsDetailsTransaction();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String actionCommand = arg0.getActionCommand();
		if(GroupEventView.ADD.equals(actionCommand)){
			performAddAction();
			
		} else if (GroupEventView.DELETE.equals(actionCommand)) {
			performDeleteAction();
			
		} else if (GroupEventView.REMOVE.equals(actionCommand)) {
			performRemoveAction();
			
		} else if (GroupEventView.SEARCH.equals(actionCommand)) {
			performSearchAcion();
			
		} else if (GroupEventView.EVENT_SELECTED.equals(actionCommand)) {
			performEventSelectedAction();
		
		} else if(GroupEventView.SAVE.equals(actionCommand)) {
			performSaveAction();
		
		} else if (GroupEventView.CLEAR.equals(actionCommand)) {
			performClearAction();
		} else if (GroupEventView.GROUP_SELECTED.equals(actionCommand)) {
			performGroupSelectionAction();
			
		}
		
	}
	
	private void performGroupSelectionAction() {
		String groupName = groupEventView.getCmbGroupNames().getSelectedItem().toString();
		String collegeId = studentDetails.get(0).getCollegeId();
		String eventId = groupEventView.getCmbEventNames().getSelectedItem().toString();
		EventDetails eventDetails = new EventDetails();
		eventDetails.setCollegeId(collegeId);
		eventDetails.setGroupId(groupName);
		eventDetails.setEventId(eventId);
		try {
			List<EventDetails> lstEventDetails = eventsDetailsTransaction.loadAll(eventDetails);
			addStudent = new Vector<String>();
			for(EventDetails eDetails : lstEventDetails) {
				addStudent.addElement(eDetails.getStudentId());
			}
		} catch (IfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void performClearAction() {
		
		
	}

	private void performSaveAction() {
		int maxCount = 0;
		String eventId = groupEventView.getCmbEventNames().getSelectedItem().toString();
		String groupName = groupEventView.getCmbGroupNames().getSelectedItem().toString();
		if(null != addStudent) {
			for ( String studentId: addStudent) {
				EventDetails studentParticipation = new EventDetails();
				studentParticipation.setCollegeId(studentDetails.get(0).getCollegeId());
				studentParticipation.setStudentId(studentId);
				studentParticipation.setEventId(eventId);
				studentParticipation.setGroupId(groupName);
				eventDetails.add(studentParticipation);
			}
		}
	}

	private void performEventSelectedAction() {
		
		if(null == preSelectedEvent) {
			preSelectedEvent = groupEventView.getCmbEventNames().getSelectedItem().toString();
		} else {
			if(! preSelectedEvent.equals(groupEventView.getCmbEventNames().getSelectedItem().toString())) {
				addStudent = new Vector<String>();
				//eventDetails = new ArrayList<EventDetails>();
				groupEventView.getLstAddedStudentList().setListData(addStudent);
				preSelectedEvent = groupEventView.getCmbEventNames().getSelectedItem().toString();
			}
		}

		
	}

	private void performSearchAcion() {
		
	}

	private void performRemoveAction() {
		
	}

	private void performDeleteAction() {
		
	}

	private void performAddAction() {
		
		eventDetails = new ArrayList<EventDetails>();
		String eventId = groupEventView.getCmbEventNames().getSelectedItem().toString();
		String groupName = groupEventView.getCmbGroupNames().getSelectedItem().toString();
		Object[] selecterRegsterNumbers = groupEventView.getLstAllStudentIds().getSelectedValues();
		if(setGroup(selecterRegsterNumbers.length)) {
			for(Object object: selecterRegsterNumbers) {
				if(!addStudent.contains(object.toString())) {
					addStudent.addElement(object.toString());
					EventDetails studentParticipation = new EventDetails();
					studentParticipation.setCollegeId(studentDetails.get(0).getCollegeId());
					studentParticipation.setStudentId(object.toString());
					studentParticipation.setEventId(eventId);
					studentParticipation.setGroupId(groupName);
					eventDetails.add(studentParticipation);
				}
			}
			eventsDetailsTransaction = new EventsDetailsTransaction();
			try {
				eventsDetailsTransaction.saveAll(eventDetails);
			} catch (IfaceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			groupEventView.getLstAddedStudentList().setListData(addStudent);
		} else {
			
		}
		
	}

	public void setAllStudentRegisterNumber() {
		Vector<String> regsterNumber = new Vector<String>();
		for(StudentDetails student : studentDetails) {
			regsterNumber.addElement(student.getStudentId());
		}
		groupEventView.getLstAllStudentIds().setListData(regsterNumber);
	}
	
	public void setGroupNames() {
		for(int i = 0; i < studentDetails.size(); i++) {
			groupEventView.getCmbGroupNames().addItem("Group"+(i+1));
		}
		
	}
	
	public void setAllEventName() {
		eventsTransaction = new EventsTransaction();
		try {
			events = eventsTransaction.loadAll();
			for(Events event : events) {
				groupEventView.getCmbEventNames().addItem(event.getEventId());
			}
		} catch (IfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private boolean setGroup(int count) {
		int maxCount = 0;
		int aCount = 0;
		String eventId = groupEventView.getCmbEventNames().getSelectedItem().toString();
		int studentCount =  addStudent.size();
		for(Events event : events) {
			maxCount = event.getMaxNoOfParticipants();
			if(eventId.equals(event.getEventId()) & maxCount > 1) {
				aCount = studentCount == 0 ? 1: studentCount  % maxCount;
				if(aCount == 0 | (aCount+count) > maxCount  ) {
					return false;
				}
				//return true;
			}
		}
		return true;
		
	}
	
	/**
	 * @return the studentDetails
	 */
	public List<StudentDetails> getStudentDetails() {
		return studentDetails;
	}


	/**
	 * @param studentDetails the studentDetails to set
	 */
	public void setStudentDetails(List<StudentDetails> studentDetails) {
		this.studentDetails = studentDetails;
	}




	/**
	 * @return the eventDetails
	 */
	public List<EventDetails> getEventDetails() {
		return eventDetails;
	}

	/**
	 * @param eventDetails the eventDetails to set
	 */
	public void setEventDetails(List<EventDetails> eventDetails) {
		this.eventDetails = eventDetails;
	}

	
	public JPanel getGroupEventView() {
		groupEventView = new GroupEventView(mdiForm, this, tableModel);
		groupEventView.setCollegeVisible(false);
		JPanel panel = groupEventView.getBody();
		tableModel.setStudentDetails(studentDetails);
		setAllEventName();
		setGroupNames();
		setAllStudentRegisterNumber();
		return panel;
	}

}
