package org.cssa.iface.gui.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JToolBar;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.util.ImageUtil;
/**
 * 
 * @author ajith
 * @since 5/26/2012
 */

public class CssaToolBar extends JToolBar implements ActionListener {
	
	public CssaToolbarButton addNewCollege;
	public CssaToolbarButton addNewCollegeDetails;
	public CssaToolbarButton addStudentDetails;
	public CssaToolbarButton addResult;
	public CssaToolbarButton report;
	public CssaToolbarButton exit;
	private CssaMDIForm mdiForm;
	ImageUtil imageUtil;
	
	public CssaToolBar() {
		createToolBar();
		// TODO Auto-generated constructor stub
	}
	
	public CssaToolBar(CssaMDIForm mdiForm) {
		super();
		this.mdiForm = mdiForm;
	}
	
	public void createToolBar()	{
		imageUtil = new ImageUtil();
		addNewCollege = new CssaToolbarButton(imageUtil.getIcon("War16.gif"), "College", "Add New college");
		addNewCollege.addActionListener(this);
		
		this.add(addNewCollege);
		
		addNewCollegeDetails = new CssaToolbarButton(imageUtil.loadImage("Host24.gif"), "College details", "College details");
		addNewCollegeDetails.addActionListener(this);
		this.add(addNewCollegeDetails);
		
		addStudentDetails = new CssaToolbarButton(imageUtil.loadImage("Jar24.gif"), "Student details", "Student details");
		addStudentDetails.addActionListener(this);
		this.add(addStudentDetails);
		
		addResult = new CssaToolbarButton(imageUtil.loadImage("J2EEServer24.gif"), "Result details", "Add Result");
		addResult.addActionListener(this);
		this.add(addResult);
		
		report = new CssaToolbarButton(imageUtil.loadImage("J2EEApplication24.gif"), "Report details", "Report");
		report.addActionListener(this);
		this.add(report);
		
		exit = new CssaToolbarButton(imageUtil.loadImage("exit.gif"), "Report details", "Report");
		exit.addActionListener(this);
		this.add(exit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
