/**
 * 
 */
package org.cssa.iface.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.college.CollegeInitialViewController;
import org.cssa.iface.gui.events.EventsController;
import org.cssa.iface.gui.lookup.CollegeLookupController;
import org.cssa.iface.gui.lookup.StudentLookupController;
import org.cssa.iface.gui.result.InsertResultController;
import org.cssa.iface.gui.result.ResultInsertController;

/**
 * @author ajith
 *
 */
public class CssaMenuBar extends JMenuBar implements ActionListener {
	
	public static final String MNU_FILE = "File";
	public static final String MNU_FILE_NEWCOLLEGE = "New College";
	public static final String MNU_FILE_NEWEVENT = "New Event";
	public static final String MNU_FILE_SEMINAR = "Seminar";
	public static final String MNU_FILE_EXIT = "Exit";
	
	public static final String MNU_MAINTAIN = "Maintain";
	public static final String MNU_MAINTAIN_COLLEGE = "College";
	public static final String MNU_MAINTAIN_STUDENT = "Student";
	public static final String MNU_MAINTAIN_GROUP_EVENT = "Group";
	public static final String MNU_MAINTAIN_RESULT = "Result";
	public static final String MNU_MAINTAIN_WINNERS = "Winners";
	
	public static final String MNU_REPORT = "Report";
	public static final String MNU_REPORT_COLLEGE = "College";
	public static final String MNU_REPORT_STUDENT = "Student";
	public static final String MNU_REPORT_RESULT = "Result";
	public static final String MNU_REPORT_WINNERS = "Winners";
	
	public static final String MNU_HELP = "Help";
	public static final String MNU_HELP_CONTENT = "Help Content";
	public static final String MNU_HELP_ABOUT = "About";
	
	private static final String SEPRATOR = "seprator";
	
	private CssaMDIForm cssaMDIForm = null;
	private CssaMenuController controller = null;
	
	/**
	 * 
	 * @return file menu items 
	 */
	public CssaMenu  getFileMenu() {
		
		Vector<Object> fileMenu = new Vector<Object>();
		CssaMenuItem mnuItemNewCollege  = new  CssaMenuItem(MNU_FILE_NEWCOLLEGE);
		CssaMenuItem mnuItemNewEvent = new CssaMenuItem(MNU_FILE_NEWEVENT);
		CssaMenuItem mnuItemExit = new CssaMenuItem(MNU_FILE_EXIT);
		CssaMenuItem mnuItemSeminar = new CssaMenuItem(MNU_FILE_SEMINAR);
		JMenuItem mnuItemExit1 = new JMenuItem(MNU_FILE_EXIT);
		
		mnuItemNewCollege.addActionListener(this);
		mnuItemNewCollege.setActionCommand(MNU_FILE_NEWCOLLEGE);
		mnuItemNewEvent.addActionListener(this);
		mnuItemNewEvent.setActionCommand(MNU_FILE_NEWEVENT);
		mnuItemSeminar.addActionListener(controller);
		mnuItemSeminar.setActionCommand(MNU_FILE_SEMINAR);
		mnuItemExit.addActionListener(this);
		mnuItemExit.setActionCommand(MNU_FILE_EXIT);
		
		fileMenu.addElement(mnuItemNewCollege);
		fileMenu.addElement(mnuItemNewEvent);
		fileMenu.addElement(SEPRATOR);
		fileMenu.addElement(mnuItemSeminar);
		fileMenu.addElement(SEPRATOR);
		fileMenu.addElement(mnuItemExit);
		
		CssaMenu mnuFile = new CssaMenu("File");
		mnuFile.setChildren(fileMenu);
		mnuFile.addMenuItems();
		return mnuFile;
		
	}
	
	public CssaMenu getMaintainMenu() {
		
		Vector<Object> maintainMenu = new Vector<Object>();
			CssaMenuItem mnuItemCollege = new CssaMenuItem(MNU_MAINTAIN_COLLEGE);
		mnuItemCollege.addActionListener(this);
		mnuItemCollege.setActionCommand(MNU_MAINTAIN_COLLEGE);
		
		
		CssaMenuItem mnuItemStudents = new CssaMenuItem(MNU_MAINTAIN_STUDENT);
		mnuItemStudents.addActionListener(this);
		mnuItemStudents.setActionCommand(MNU_MAINTAIN_STUDENT);
		
		CssaMenuItem mnuItemGroup = new CssaMenuItem(MNU_MAINTAIN_GROUP_EVENT);
		mnuItemGroup.addActionListener(this);
		mnuItemGroup.setActionCommand(MNU_MAINTAIN_GROUP_EVENT);
		
		CssaMenuItem mnuItemResult = new CssaMenuItem(MNU_MAINTAIN_RESULT);
		mnuItemResult.addActionListener(this);
		mnuItemResult.setActionCommand(MNU_MAINTAIN_RESULT);
		
		CssaMenuItem mnuItemWinners = new CssaMenuItem(MNU_MAINTAIN_WINNERS);
		mnuItemWinners.addActionListener(this);
		mnuItemWinners.setActionCommand(MNU_MAINTAIN_WINNERS);
		
		maintainMenu.addElement(mnuItemCollege);
		maintainMenu.addElement(mnuItemStudents);
		maintainMenu.addElement(mnuItemGroup);
		maintainMenu.addElement(SEPRATOR);
		maintainMenu.addElement(mnuItemResult);
		
		CssaMenu mnuMaintain = new CssaMenu("Maintain");
		mnuMaintain.setChildren(maintainMenu);
		mnuMaintain.addMenuItems();
		return mnuMaintain;
		
	}
	
	public CssaMenu getReportMenu() {
		Vector<Object> reportMenu = new Vector<Object>();
		
		CssaMenuItem mnuItemCollege = new CssaMenuItem(MNU_REPORT_COLLEGE);
		CssaMenuItem mnuItemStudents = new CssaMenuItem(MNU_REPORT_STUDENT);
		CssaMenuItem mnuItemResult = new CssaMenuItem(MNU_REPORT_RESULT);
		
		mnuItemCollege.addActionListener(this);
		mnuItemCollege.setActionCommand(MNU_REPORT_COLLEGE);
		mnuItemStudents.addActionListener(this);
		mnuItemStudents.setActionCommand(MNU_REPORT_STUDENT);
		mnuItemResult.addActionListener(this);
		mnuItemResult.setActionCommand(MNU_REPORT_RESULT);
		
		reportMenu.addElement(mnuItemCollege);
		reportMenu.addElement(mnuItemStudents);
		reportMenu.addElement(SEPRATOR);
		reportMenu.addElement(mnuItemResult);
		
		CssaMenu mnuReport = new CssaMenu(MNU_REPORT);
		mnuReport.setChildren(reportMenu);
		mnuReport.addMenuItems();
		return mnuReport;
		
	}
	
	public CssaMenu getHelpMenu() {
		Vector<Object> helpMenu = new Vector<Object>();
		
		CssaMenuItem mnuItemHelpContent = new CssaMenuItem(MNU_HELP_CONTENT);
		CssaMenuItem mnuItemAbout = new CssaMenuItem(MNU_HELP_ABOUT);
		
		mnuItemHelpContent.setActionCommand(MNU_HELP_CONTENT);
		mnuItemAbout.setActionCommand(MNU_HELP_ABOUT);
		mnuItemHelpContent.addActionListener(this);
		mnuItemAbout.addActionListener(this);
		
		helpMenu.addElement(mnuItemHelpContent);
		helpMenu.addElement(SEPRATOR);
		helpMenu.addElement(mnuItemAbout);
		
		CssaMenu mnuHelp= new CssaMenu(MNU_HELP);
		mnuHelp.setChildren(helpMenu);
		mnuHelp.addMenuItems();
		return mnuHelp;
	}
	
	public CssaMenuBar() {
		this.add(getFileMenu());
		this.add(getMaintainMenu());
		this.add(getReportMenu());
		this.add(getHelpMenu());
	}
	
	public CssaMenuBar(CssaMDIForm cssaMDIForm) {
		this();
		this.cssaMDIForm = cssaMDIForm;
	}

	public CssaMenuBar(CssaMenuController cssaMenuController) {
		this();
		this.controller = cssaMenuController;
	}
	
	public CssaMenuBar(CssaMenuController controller, CssaMDIForm cssaMDIForm) {
		this();
		this.controller = controller;
		this.cssaMDIForm = cssaMDIForm;
	}
	
	public void setController(CssaMenuController controller) {
		this.controller = controller;
	}

	public void setCssaMDIForm(CssaMDIForm cssaMDIForm) {
		this.cssaMDIForm = cssaMDIForm;
	}
	
	public CssaMDIForm  getCssaMDIForm() {
		return cssaMDIForm;
	}
	
	public void addMenuBar() {
		cssaMDIForm.setJMenuBar(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(CssaMenuBar.MNU_FILE_EXIT.equals(actionCommand)) {
			controller.exitApplication();
		} else if (CssaMenuBar.MNU_FILE_NEWEVENT.equals(actionCommand)) {
			new EventsController(cssaMDIForm).askEventView();
		} else if (CssaMenuBar.MNU_HELP_CONTENT.equals(actionCommand)) {
			controller.displayHelp();
		} else if(CssaMenuBar.MNU_FILE_NEWCOLLEGE.equals(actionCommand)) {
			new CollegeInitialViewController(cssaMDIForm).askCollegeInitialView();
		} else if(CssaMenuBar.MNU_MAINTAIN_COLLEGE.equals(actionCommand)) {
			new CollegeLookupController(cssaMDIForm).askCollegeLookupView();
		} else if (CssaMenuBar.MNU_MAINTAIN_STUDENT.equals(actionCommand)) {
			new StudentLookupController(cssaMDIForm).askStudentLookupsereen();
		} else if(CssaMenuBar.MNU_MAINTAIN_RESULT.equals(actionCommand)) {
			new ResultInsertController(cssaMDIForm).askResultInsertView();
		} else if(CssaMenuBar.MNU_MAINTAIN_WINNERS.equals(actionCommand)) {
			new InsertResultController(cssaMDIForm).askInsertResultView();
		} else if(CssaMenuBar.MNU_REPORT_COLLEGE.equals(actionCommand)) {
			new CollegeLookupController(cssaMDIForm).askCollegeLookupView();
			
		} else if(CssaMenuBar.MNU_REPORT_STUDENT.equals(actionCommand)) {
			new StudentLookupController(cssaMDIForm).askStudentLookupsereen();
		}
			
	}

	private void exitApp() {
		System.exit(ABORT);
		
	}
	

}
