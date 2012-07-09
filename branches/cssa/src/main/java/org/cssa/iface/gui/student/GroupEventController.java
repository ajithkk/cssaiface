/**
 * 
 */
package org.cssa.iface.gui.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

import org.cssa.iface.bo.EventDetails;
import org.cssa.iface.bo.StudentDetails;
import org.cssa.iface.gui.CssaMDIForm;

/**
 * @author ajith
 *
 */
public class GroupEventController implements ActionListener{
	
	private List<StudentDetails> studentDetails;
	private List<EventDetails> eventDetails;
	
	private GroupEventTableModel tableModel;
	private GroupEventView groupEventView;
	private CssaMDIForm mdiForm;
	
	public GroupEventController() {
		tableModel = new GroupEventTableModel();
		groupEventView = new GroupEventView();
	
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
		groupEventView = new GroupEventView();
	}


	/**
	 * @param studentDetails
	 */
	public GroupEventController(List<StudentDetails> studentDetails) {
		super();
		this.studentDetails = studentDetails;
		groupEventView = new GroupEventView();
	}




	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
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
		return groupEventView.getBody();
	}

}
