/**
 * 
 */
package org.cssa.iface.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.JMenuBar;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.college.CollegeInitialViewController;
import org.cssa.iface.gui.events.EventsController;
import org.cssa.iface.gui.lookup.CollegeLookupController;
import org.cssa.iface.gui.lookup.ParticipantLookupController;
import org.cssa.iface.gui.lookup.StudentLookupController;
import org.cssa.iface.gui.lookup.WinnerLookupController;
import org.cssa.iface.gui.result.InsertResultController;
import org.cssa.iface.gui.result.ResultInsertController;
import org.cssa.iface.gui.search.SearchTableController;
import org.cssa.iface.gui.timesheet.SelectDateDialogController;
import org.cssa.iface.services.MenuConstants;
import org.cssa.iface.util.TableStoreXML;

/**
 * @author ajith
 *
 */
public class CssaMenuBar extends JMenuBar implements ActionListener, MenuConstants {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		CssaMenuItem mnuItemSeminar = new CssaMenuItem(MNU_FILE_TIME_SHEET);
		
		mnuItemNewCollege.addActionListener(this);
		mnuItemNewCollege.setActionCommand(MNU_FILE_NEWCOLLEGE);
		mnuItemNewEvent.addActionListener(this);
		mnuItemNewEvent.setActionCommand(MNU_FILE_NEWEVENT);
		mnuItemSeminar.addActionListener(this);
		mnuItemSeminar.setActionCommand(MNU_FILE_TIME_SHEET);
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
		maintainMenu.addElement(SEPRATOR);
		maintainMenu.addElement(mnuItemWinners);
		
		CssaMenu mnuMaintain = new CssaMenu("Maintain");
		mnuMaintain.setChildren(maintainMenu);
		mnuMaintain.addMenuItems();
		return mnuMaintain;
		
	}
	
	public CssaMenu getDatabaseMenu() {
		Vector<Object> databseMenu = new Vector<Object>();
		TableStoreXML tableStoreXML = new TableStoreXML();
		Map<String, String> tableMap = tableStoreXML.getTableStoreMap();
		
		Set<Map.Entry<String, String>> tableSet = tableMap.entrySet();
		for(Map.Entry<String, String> set : tableSet) {
			CssaMenuItem menuItem = new CssaMenuItem(set.getKey().toLowerCase());
			menuItem.setActionCommand(set.getKey());
			menuItem.addActionListener(this);
			databseMenu.addElement(menuItem);
		}
		CssaMenu mnuDatabase = new CssaMenu("Database");
		mnuDatabase.setChildren(databseMenu);
		mnuDatabase.addMenuItems();
		
		return mnuDatabase;
	}
	
	public CssaMenu getReportMenu() {
		Vector<Object> reportMenu = new Vector<Object>();
		
		CssaMenuItem mnuItemCollege = new CssaMenuItem(MNU_REPORT_COLLEGE);
		CssaMenuItem mnuItemStudents = new CssaMenuItem(MNU_REPORT_STUDENT);
		CssaMenuItem mnuItemResult = new CssaMenuItem(MNU_REPORT_RESULT);
		CssaMenuItem mnuItemEvent = new CssaMenuItem(MNU_REPORT_EVENT);
		CssaMenuItem mnuItemWinners = new CssaMenuItem(MNU_REPORT_WINNERS);
		
		mnuItemCollege.addActionListener(this);
		mnuItemCollege.setActionCommand(ACT_MNU_REPORT_COLLEGE);
		mnuItemStudents.addActionListener(this);
		mnuItemStudents.setActionCommand(ACT_MNU_REPORT_STUDENT);
		mnuItemResult.addActionListener(this);
		mnuItemResult.setActionCommand(ACT_MNU_REPORT_RESULT);
		mnuItemEvent.addActionListener(this);
		mnuItemEvent.setActionCommand(ACT_MNU_REPORT_EVENT);
		mnuItemWinners.addActionListener(this);
		mnuItemWinners.setActionCommand(ACT_MNU_REPORT_WINNERS);
		
		reportMenu.addElement(mnuItemCollege);
		reportMenu.addElement(mnuItemStudents);
		reportMenu.addElement(SEPRATOR);
		reportMenu.addElement(mnuItemEvent);
		reportMenu.addElement(SEPRATOR);
		reportMenu.addElement(mnuItemResult);
		reportMenu.addElement(SEPRATOR);
		reportMenu.addElement(mnuItemWinners);
		
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
		this.add(getDatabaseMenu());
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
		} else if(CssaMenuBar.ACT_MNU_REPORT_COLLEGE.equals(actionCommand)) {
			new CollegeLookupController(cssaMDIForm,true).askCollegeLookupView();
		} else if(CssaMenuBar.ACT_MNU_REPORT_STUDENT.equals(actionCommand)) {
			new StudentLookupController(cssaMDIForm, false, true).askStudentLookupsereen();
		} else if (CssaMenuBar.ACT_MNU_REPORT_EVENT.equals(actionCommand)) {
			new SearchTableController(cssaMDIForm).askSearachTable();
		} else if(CssaMenuBar.ACT_MNU_REPORT_RESULT.equals(actionCommand)) {
			new ParticipantLookupController(cssaMDIForm,true).askParticipantsLookupView();
		} else if (CssaMenuBar.MNU_FILE_TIME_SHEET.equals(actionCommand)) {
			new SelectDateDialogController(cssaMDIForm).askDateDialog();
		} else if (CssaMenuBar.MNU_MAINTAIN_GROUP_EVENT.equals(actionCommand)) {
			new StudentLookupController(cssaMDIForm, true, false).askStudentLookupsereen();
		} else if (ACT_MNU_REPORT_WINNERS.equals(actionCommand)) {
			new WinnerLookupController(cssaMDIForm, true).askWinnerLookUp();
		}
			
	}

	private void exitApp() {
		System.exit(ABORT);
		
	}
	

}
