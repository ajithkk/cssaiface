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
import org.cssa.iface.gui.formvalidator.GroupEventViewValidator;
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
	private GroupEventViewValidator validator;
	
	private Vector<String> addStudent;
	
	public GroupEventController() {
		tableModel = new GroupEventTableModel();
		addStudent = new Vector<String>();
		eventDetails = new ArrayList<EventDetails>();
		eventsDetailsTransaction = new EventsDetailsTransaction();
		validator = new GroupEventViewValidator();
	
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
		tableModel = new GroupEventTableModel();
		addStudent = new Vector<String>();
		eventDetails = new ArrayList<EventDetails>();
		eventsDetailsTransaction = new EventsDetailsTransaction();
		validator = new GroupEventViewValidator();
	}

	/**
	 * @param studentDetails
	 */
	public GroupEventController(List<StudentDetails> studentDetails) {
		super();
		this.studentDetails = studentDetails;
		tableModel = new GroupEventTableModel();
		addStudent = new Vector<String>();
		eventDetails = new ArrayList<EventDetails>();
		eventsDetailsTransaction = new EventsDetailsTransaction();
		validator = new GroupEventViewValidator();
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
			e.printStackTrace();
		}
		groupEventView.getLstAddedStudentList().setListData(addStudent);
		
		
	}

	private void performEventSelectedAction() {
		
		String selectedEvent = groupEventView.getCmbEventNames().getSelectedItem().toString();
		String collegeId = studentDetails.get(0).getCollegeId();
		groupEventView.getLstAddedStudentList().setListData(new Vector<String>());
		EventDetails eventDetails = new EventDetails();
		eventDetails.setCollegeId(collegeId);
		eventDetails.setEventId(selectedEvent);
		try {
			List<EventDetails> lstEventDetails = eventsDetailsTransaction.selectEventParticipants(eventDetails);
			addStudent = new Vector<String>();
			Vector<String> allStudent = validator.getAllStudentRegisterNumber(studentDetails);// setAllStudentRegisterNumber();
			if(lstEventDetails.size() == 0) {
				groupEventView.getLstAllStudentIds().setListData(allStudent);
			} else {
				addStudent = validator.contatin(allStudent, lstEventDetails);
			}
			groupEventView.getLstAllStudentIds().setListData(addStudent);
			
		} catch (IfaceException e) {
			e.printStackTrace();
		}
		
		
	}

	private void performSearchAcion() {
		
	}

	private void performRemoveAction() {
		eventDetails = new ArrayList<EventDetails>();
		String eventId = groupEventView.getCmbEventNames().getSelectedItem().toString();
		String groupName = groupEventView.getCmbGroupNames().getSelectedItem().toString();
		Object[] selecterRegsterNumbers = groupEventView.getLstAllStudentIds().getSelectedValues();
			for(Object object: selecterRegsterNumbers) {
					EventDetails studentParticipation = new EventDetails();
					studentParticipation.setCollegeId(studentDetails.get(0).getCollegeId());
					studentParticipation.setStudentId(object.toString());
					studentParticipation.setEventId(eventId);
					studentParticipation.setGroupId(groupName);
					eventDetails.add(studentParticipation);
					addStudent.removeElement(object.toString());
			}
			eventsDetailsTransaction = new EventsDetailsTransaction();
			try {
				eventsDetailsTransaction.deleteAll(eventDetails);
			} catch (IfaceException e) {
				e.printStackTrace();
			}
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
				e.printStackTrace();
			}
			
			groupEventView.getLstAddedStudentList().setListData(addStudent);
		} else {
			
		}
		
	}

	public Vector<String>  setAllStudentRegisterNumber() {
		Vector<String> regsterNumber = new Vector<String>();
		for(StudentDetails student : studentDetails) {
			regsterNumber.addElement(student.getStudentId());
		}
		return regsterNumber;
	}
	
	public void setGroupNames() {
		groupEventView.getCmbGroupNames().addItem("");
		for(int i = 0; i < studentDetails.size(); i++) {
			groupEventView.getCmbGroupNames().addItem("Group"+(i+1));
		}
		
	}
	
	public void setAllEventName() {
		eventsTransaction = new EventsTransaction();
		groupEventView.getCmbEventNames().addItem("");
		try {
			events = eventsTransaction.loadAll();
			for(Events event : events) {
				groupEventView.getCmbEventNames().addItem(event.getEventId());
			}
		} catch (IfaceException e) {
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
				if((aCount+count) > maxCount  ) {
					return false;
				}
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
		return panel;
	}
	
	public Vector<String> contatin(Vector<String> allStudent, List<EventDetails> details) {
		boolean find = true;
		int size = allStudent.size();
		Vector<String> remainingRegster = allStudent;
		for(EventDetails event : details) {
			find = true;
			for(int i = 0; i < size & find; i++) {
				if(event.getStudentId().equals(allStudent.get(i))) {
					find = false;
					remainingRegster.remove(allStudent.get(i));
				}
			}
		}
		return remainingRegster;
	}

}
