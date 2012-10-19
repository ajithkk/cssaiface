/**
 * 
 */
package org.cssa.iface.gui.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.help.plaf.basic.BasicFavoritesNavigatorUI.AddAction;
import javax.swing.JList;
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
	private Vector<String> allStudent;
	
	public GroupEventController() {
		tableModel = new GroupEventTableModel();
		addStudent = new Vector<String>();
		eventDetails = new ArrayList<EventDetails>();
		eventsDetailsTransaction = new EventsDetailsTransaction();
		validator = new GroupEventViewValidator();
		allStudent = new Vector<String>();
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
		allStudent = new Vector<String>();
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
		allStudent = new Vector<String>();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String actionCommand = arg0.getActionCommand();
		if(GroupEventView.ADD.equals(actionCommand)){
			performAddAction();
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
		if(!"".equals(groupName)) {
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
			validator.setAddedStudent(addStudent);
			groupEventView.getLstAddedStudentList().setListData(addStudent);
			
		} else {
		
			groupEventView.getLstAddedStudentList().setListData(new Vector<String>());
			validator.setAddedStudent(new Vector<String>());
		}
	}

	private void performEventSelectedAction() {
		
		String selectedEvent = groupEventView.getCmbEventNames().getSelectedItem().toString();
		groupEventView.getLstAddedStudentList().setListData(new Vector<String>());
		groupEventView.getCmbGroupNames().setSelectedItem("");
		if(!"".equals(selectedEvent)) {
			String collegeId = studentDetails.get(0).getCollegeId();
			EventDetails eventDetails = new EventDetails();
			eventDetails.setCollegeId(collegeId);
			eventDetails.setEventId(selectedEvent);
			try {
				List<EventDetails> lstEventDetails = eventsDetailsTransaction.selectEventParticipants(eventDetails);
				allStudent = new Vector<String>();
				addStudent = new Vector<String>();
				Vector<String> allStudent = validator.getAllStudentRegisterNumber(studentDetails);// setAllStudentRegisterNumber();
				if(lstEventDetails.size() == 0) {
					validator.setAllStudent(allStudent);
					groupEventView.getLstAllStudentIds().setListData(allStudent);
				} else {
					allStudent = validator.contatin(allStudent, lstEventDetails);
					groupEventView.getLstAllStudentIds().setListData(allStudent);
					validator.setAllStudent(allStudent);
				}
				
				
			} catch (IfaceException e) {
				e.printStackTrace();
			}
			
		} else {
			groupEventView.getLstAllStudentIds().setListData(new Vector<String>());
			validator.setAllStudent(new Vector<String>());
		}
	}

	private void performSearchAcion() {
		
	}

	private void performRemoveAction() {
		
		eventDetails = new ArrayList<EventDetails>();
		String eventId = groupEventView.getCmbEventNames().getSelectedItem().toString();
		String groupName = groupEventView.getCmbGroupNames().getSelectedItem().toString();
		if(!"".equals(eventId) & !"".equals(groupName)) {
			Object[] selecterRegsterNumbers = groupEventView.getLstAddedStudentList().getSelectedValues();
			allStudent = validator.getAllStudent();
			addStudent = validator.getAddedStudent();
			for(Object object: selecterRegsterNumbers) {
				EventDetails studentParticipation = new EventDetails();
				studentParticipation.setCollegeId(studentDetails.get(0).getCollegeId());
				studentParticipation.setStudentId(object.toString());
				studentParticipation.setEventId(eventId);
				studentParticipation.setGroupId(groupName);
				eventDetails.add(studentParticipation);
				addStudent.removeElement(object.toString());
				allStudent.addElement(object.toString());
			}
			
			eventsDetailsTransaction = new EventsDetailsTransaction();
			try {
				eventsDetailsTransaction.deleteAll(eventDetails);
				groupEventView.getLstAddedStudentList().setListData(addStudent);
				groupEventView.getLstAllStudentIds().setListData(allStudent);
				validator.setAllStudent(allStudent);
				validator.setAddedStudent(addStudent);
			} catch (IfaceException e) {
				e.printStackTrace();
			}
		}
	}

	private void performAddAction() {
		
		eventDetails = new ArrayList<EventDetails>();
		String eventId = groupEventView.getCmbEventNames().getSelectedItem().toString();
		String groupName = groupEventView.getCmbGroupNames().getSelectedItem().toString();
		if(!"".equals(eventId) & !"".equals(groupName)) {
			Object[] selecterRegsterNumbers = groupEventView.getLstAllStudentIds().getSelectedValues();
			allStudent = validator.getAllStudent();
			addStudent = validator.getAddedStudent();
			
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
						allStudent.removeElement(object.toString());
					}
				}
				eventsDetailsTransaction = new EventsDetailsTransaction();
				try {
					eventsDetailsTransaction.saveAll(eventDetails);
					groupEventView.getLstAllStudentIds().setListData(allStudent);
					groupEventView.getLstAddedStudentList().setListData(addStudent);
					validator.setAllStudent(allStudent);
					validator.setAddedStudent(addStudent);
				} catch (IfaceException e) {
					e.printStackTrace();
				}
				
				
			} else {
				
			}
		}
		
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
		int studentCount =  validator.getAddedStudent().size();
		for(Events event : events) {
			maxCount = event.getMaxNoOfParticipants();
			if(eventId.equals(event.getEventId()) & maxCount > 1) {
				//aCount = studentCount == 0 ? 1: studentCount  % maxCount;
				if((studentCount+count) > maxCount  ) {
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
}