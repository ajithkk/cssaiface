package org.cssa.iface.gui.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToolBar;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.college.CollegeInitialViewController;
import org.cssa.iface.gui.events.EventsController;
import org.cssa.iface.gui.lookup.CollegeLookupController;
import org.cssa.iface.gui.lookup.ParticipantLookupController;
import org.cssa.iface.gui.lookup.StudentLookupController;
import org.cssa.iface.gui.menu.CssaMenuBar;
import org.cssa.iface.gui.result.InsertResultController;
import org.cssa.iface.gui.result.ResultInsertController;
import org.cssa.iface.gui.search.SearchTableController;
import org.cssa.iface.gui.timesheet.SelectDateDialogController;
import org.cssa.iface.services.MenuConstants;
import org.cssa.iface.util.ImageUtil;
import org.cssa.iface.util.Util;
/**
 * 
 * @author ajith
 * @since 5/26/2012
 */

public class CssaToolBar extends JToolBar implements ActionListener, MenuConstants {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CssaToolbarButton addNewEvent;
	public CssaToolbarButton addNewCollege;
	public CssaToolbarButton addNewCollegeDetails;
	public CssaToolbarButton addStudentDetails;
	public CssaToolbarButton timeSchedule;
	public CssaToolbarButton report;
	public CssaToolbarButton exit;
	public CssaToolbarButton insertResult;
	public CssaToolbarButton insertWinners;
	public CssaToolbarButton editInsertResult;
	public CssaToolbarButton editInsertWinners;
	public CssaToolbarButton reportCollege;
	public CssaToolbarButton reportStudent;
	public CssaToolbarButton reportEvent;
	private CssaMDIForm mdiForm;
	ImageUtil imageUtil;
	
	public CssaToolBar() {
		this(null);
	}
	
	public CssaToolBar(CssaMDIForm mdiForm) {
		this.mdiForm = mdiForm;
		createToolBar();
	}
	
	public void createToolBar()	{
		imageUtil = new ImageUtil();
		
		addNewEvent = new CssaToolbarButton(imageUtil.getIcon("BeanAdd24.gif"), "Event", " Add New Event");
		addNewEvent.setActionCommand(MNU_FILE_NEWEVENT);
		addNewEvent.addActionListener(this);
		this.add(addNewEvent);
		
		addNewCollegeDetails = new CssaToolbarButton(imageUtil.loadImage("JarAdd24.gif"), "College Details", "Add College Initial details");
		addNewCollegeDetails.addActionListener(this);
		addNewCollegeDetails.setActionCommand(MNU_FILE_NEWCOLLEGE);
		this.add(addNewCollegeDetails);
		
		
		
		insertResult = new CssaToolbarButton(imageUtil.loadImage("WarAdd24.gif"), "Result details", "Add Result");
		insertResult.addActionListener(this);
		insertResult.setActionCommand(MNU_MAINTAIN_RESULT);
		this.add(insertResult);
		
		editInsertResult = new CssaToolbarButton(imageUtil.loadImage("War24.gif"), "Edit Result details", " Edit Result");
		editInsertResult.addActionListener(this);
		editInsertResult.setActionCommand(MNU_MAINTAIN_EDIT_RESULT);
		this.add(editInsertResult);
		
		insertWinners = new CssaToolbarButton(imageUtil.loadImage("WebComponentAdd24.gif"), "Winners", "Insert Winners");
		insertWinners.addActionListener(this);
		insertWinners.setActionCommand(MNU_MAINTAIN_WINNERS);
		this.add(insertWinners);
		
		editInsertWinners = new CssaToolbarButton(imageUtil.loadImage("WebComponent24.gif"), "Edit Winners details", " Edit Winners");
		editInsertWinners.addActionListener(this);
		editInsertWinners.setActionCommand(MNU_MAINTAIN_EDIT_WINNERS);
		this.add(editInsertWinners);
		
		timeSchedule = new CssaToolbarButton(imageUtil.loadImage("Server24.gif"), "Time Schedule", "Time Schedule");
		timeSchedule.addActionListener(this);
		timeSchedule.setActionCommand(MNU_FILE_TIME_SHEET);
		this.add(timeSchedule);
		
		reportCollege = new CssaToolbarButton(imageUtil.loadImage("J2EEApplicationClient24.gif"), "Report College", "Report College");
		reportCollege.addActionListener(this);
		reportCollege.setActionCommand(MNU_REPORT_COLLEGE);
		this.add(reportCollege);
		
		reportStudent = new CssaToolbarButton(imageUtil.loadImage("J2EEServer24.gif"), "Report Student", "Report Student");
		reportStudent.addActionListener(this);
		reportStudent.setActionCommand(MNU_REPORT_STUDENT);
		this.add(reportStudent);
		
		reportEvent = new CssaToolbarButton(imageUtil.loadImage("EnterpriseJavaBean24.gif"), "Reprt Event", "Report Event");
		reportEvent.addActionListener(this);
		reportEvent.setActionCommand(MNU_REPORT_EVENT);
		this.add(reportEvent);
		
		exit = new CssaToolbarButton(imageUtil.loadImage("exit.gif"), "Exit", "Exit");
		exit.addActionListener(this);
		exit.setActionCommand(MNU_FILE_EXIT);
		this.add(exit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(CssaMenuBar.MNU_FILE_EXIT.equals(actionCommand)) {
			Util.exitApplicataion();
		} else if (MNU_FILE_NEWEVENT.equals(actionCommand)) {
			new EventsController(mdiForm).askEventView();
		} else if (MNU_HELP_CONTENT.equals(actionCommand)) {
		} else if(MNU_FILE_NEWCOLLEGE.equals(actionCommand)) {
			new CollegeInitialViewController(mdiForm).askCollegeInitialView();
		} else if(MNU_MAINTAIN_COLLEGE.equals(actionCommand)) {
			new CollegeLookupController(mdiForm).askCollegeLookupView();
		} else if (MNU_MAINTAIN_STUDENT.equals(actionCommand)) {
			new StudentLookupController(mdiForm).askStudentLookupsereen();
		} else if(MNU_MAINTAIN_RESULT.equals(actionCommand)) {
			new ResultInsertController(mdiForm).askResultInsertView();
		}else if(MNU_MAINTAIN_EDIT_RESULT.equals(actionCommand)) {
			new ResultInsertController(mdiForm,true).askResultInsertView();
		} else if(MNU_MAINTAIN_WINNERS.equals(actionCommand)) {
			new InsertResultController(mdiForm).askInsertResultView();
		} else if(ACT_MNU_REPORT_COLLEGE.equals(actionCommand)) {
			new CollegeLookupController(mdiForm,true).askCollegeLookupView();
		} else if(ACT_MNU_REPORT_STUDENT.equals(actionCommand)) {
			new StudentLookupController(mdiForm, false, true).askStudentLookupsereen();
		} else if (ACT_MNU_REPORT_EVENT.equals(actionCommand)) {
			new SearchTableController(mdiForm).askSearachTable();
		} else if(ACT_MNU_REPORT_RESULT.equals(actionCommand)) {
			new ParticipantLookupController(mdiForm).askParticipantsLookupView();
		} else if (MNU_FILE_TIME_SHEET.equals(actionCommand)) {
			new SelectDateDialogController(mdiForm).askDateDialog();
		} else if (MNU_MAINTAIN_GROUP_EVENT.equals(actionCommand)) {
			new StudentLookupController(mdiForm, true, false).askStudentLookupsereen();
		}
		
	}

}
