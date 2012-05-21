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

/**
 * @author ajith
 *
 */
public class CssaMenuBar extends JMenuBar  {
	
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
	
	public static final String MNU_REPORT = "Report";
	public static final String MNU_REPORT_COLLEGE = "College";
	public static final String MNU_REPORT_STUDENT = "Student";
	public static final String MNU_REPORT_RESULT = "Result";
	
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
		
		mnuItemNewCollege.addActionListener(controller);
		mnuItemNewCollege.setActionCommand(MNU_FILE_NEWCOLLEGE);
		mnuItemNewEvent.addActionListener(controller);
		mnuItemNewEvent.setActionCommand(MNU_FILE_NEWEVENT);
		mnuItemSeminar.addActionListener(controller);
		mnuItemSeminar.setActionCommand(MNU_FILE_SEMINAR);
		mnuItemExit1.addActionListener(controller);
		mnuItemExit1.setActionCommand(MNU_FILE_EXIT);
		
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
		mnuItemCollege.addActionListener(controller);
		mnuItemCollege.setActionCommand(MNU_MAINTAIN_COLLEGE);
		
		
		CssaMenuItem mnuItemStudents = new CssaMenuItem(MNU_MAINTAIN_STUDENT);
		mnuItemStudents.addActionListener(controller);
		mnuItemStudents.setActionCommand(MNU_MAINTAIN_STUDENT);
		
		CssaMenuItem mnuItemGroup = new CssaMenuItem(MNU_MAINTAIN_GROUP_EVENT);
		mnuItemGroup.addActionListener(controller);
		mnuItemGroup.setActionCommand(MNU_MAINTAIN_GROUP_EVENT);
		
		CssaMenuItem mnuItemResult = new CssaMenuItem(MNU_MAINTAIN_RESULT);
		mnuItemResult.addActionListener(controller);
		mnuItemResult.setActionCommand(MNU_MAINTAIN_RESULT);
		
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
		
		mnuItemCollege.addActionListener(controller);
		mnuItemCollege.setActionCommand(MNU_REPORT_COLLEGE);
		mnuItemStudents.addActionListener(controller);
		mnuItemStudents.setActionCommand(MNU_REPORT_STUDENT);
		mnuItemResult.addActionListener(controller);
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
		mnuItemHelpContent.addActionListener(controller);
		mnuItemAbout.addActionListener(controller);
		
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
	
	//@Override
	/*public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(CssaMenuBar.MNU_FILE_EXIT.equals(actionCommand)) {
			exitApp();
		}
		
	}*/

	/*private void exitApp() {
		System.exit(ABORT);
		
	}*/
	

}
