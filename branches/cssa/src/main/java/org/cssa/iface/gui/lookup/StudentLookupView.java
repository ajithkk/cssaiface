/**
 * 
 */
package org.cssa.iface.gui.lookup;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.sound.midi.MidiChannel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.controls.CButton;
import org.cssa.iface.gui.controls.CLabel;
import org.cssa.iface.gui.controls.CTextField;

/**
 * @author ajith
 *
 */
public class StudentLookupView {
	
	public static final String CANCEL = "Cancel";
	public static final String CLEAR = "Clear";
	public static final String SEARCH = "Search";
	
	private CLabel lblStudentId;
	private CLabel lblStudentName;
	private CLabel lblCollegeId;
	
	private CTextField txtStudentId;
	private CTextField txtStudentName;
	private CTextField txtCollegeId;
	
	private CButton btnSearch;
	private CButton btnClear;
	private CButton btnCancel;
	private JButton btnCollegeLookUp;
	
	private JTable tblStudentDetails;
	
	private StudentLookupController studentLookupController;
	private StudentLookupTableModel tableModel;
	private CssaMDIForm mdiForm;
	
	
	public StudentLookupView(StudentLookupController studentLookupController,
			StudentLookupTableModel tableModel, CssaMDIForm mdiForm) {
		super();
		this.studentLookupController = studentLookupController;
		this.tableModel = tableModel;
		this.mdiForm = mdiForm;
	}


	/**
	 * @param studentLookupController
	 * @param tableModel
	 */
	public StudentLookupView(StudentLookupController studentLookupController,
			StudentLookupTableModel tableModel) {
		super();
		this.studentLookupController = studentLookupController;
		this.tableModel = tableModel;
	}
	

	public void showEventDetailLookup() {
		JPanel panel = new JPanel();
		panel.add(getStudentLookupDetailsBody(), BorderLayout.CENTER);
		mdiForm.addChild(panel, "Student Lookup Form");
		
	}
	
	private  JPanel getStudentDetailsPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		
		lblStudentId = new CLabel("Student Id:");
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(10, 5, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(lblStudentId,constraints);
		
		txtStudentId = new CTextField();
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 0;
		panel.add(txtStudentId, constraints);
		
		lblStudentName = new CLabel("Student Name:");
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		panel.add(lblStudentName,constraints);
		
		txtStudentName =  new CTextField();
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 1;
		panel.add(txtStudentName, constraints);
		
		
		lblCollegeId = new CLabel("College Id:");
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(10, 5, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 2;
		panel.add(lblCollegeId,constraints);
		
		txtCollegeId = new CTextField();
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 2;
		panel.add(txtCollegeId, constraints);
		
		return panel;
	}
	
	
	private  JPanel getButtonPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;

		constraints = new GridBagConstraints();
		btnSearch = new CButton("Search");
		btnSearch.setMnemonic('S');
		btnSearch.setActionCommand(SEARCH);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 2;
		constraints.gridy = 0;
		panel.add(btnSearch, constraints);
		btnSearch.addActionListener(studentLookupController);

		constraints = new GridBagConstraints();
		btnClear = new CButton("Clear");
		btnClear.setMnemonic('L');
		btnClear.setActionCommand(CLEAR);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 3;
		constraints.gridy = 0;
		panel.add(btnClear, constraints);
		btnClear.addActionListener(studentLookupController);

		constraints = new GridBagConstraints();
		btnCancel = new CButton("Cancel");
		btnCancel.setMnemonic('C');
		btnCancel.setActionCommand(CANCEL);
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 4;
		constraints.gridy = 0;
		panel.add(btnCancel, constraints);
		btnCancel.addActionListener(studentLookupController);
		
		return panel;
	}
	
	private  JPanel getTablePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		tblStudentDetails = new JTable(tableModel);
		tblStudentDetails.setFillsViewportHeight(true);
		tblStudentDetails.setRowHeight(20);
		JScrollPane scrollPane = new JScrollPane(tblStudentDetails);
		scrollPane.setMinimumSize(new Dimension(700, 400));
		scrollPane.setMaximumSize(new Dimension(700, 400));
		scrollPane.setPreferredSize(new Dimension(700, 400));
		panel.add(scrollPane, BorderLayout.CENTER);
		tblStudentDetails.addMouseListener(studentLookupController);

		return panel;
	}
	
	
	public JPanel getTopPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 0, 0, 0);
		constraints.gridx = 1;
		constraints.gridy = 5;
		constraints.anchor = GridBagConstraints.WEST;
		panel.add(getStudentDetailsPanel(), constraints);

		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 6;
		constraints.insets = new Insets(10, 0,10, 0);
		constraints.anchor = GridBagConstraints.CENTER;
		panel.add(getButtonPanel(), constraints);
		
		return panel;
	}
	public JPanel getBottomPannel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		// constraints.insets = new Insets(0, 90, 0, 0);
		constraints.gridy = 0;
		constraints.gridx = 1;
		panel.add(getTablePanel(), constraints);

		/*constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.insets = new Insets(10, 5, 0, 0);
		panel.add(getSideButtonPanel(), constraints);
*/
		return panel;
	}
	
	public JPanel getStudentLookupDetailsBody() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(getTopPanel(), BorderLayout.NORTH);
		panel.add(getBottomPannel(), BorderLayout.CENTER);

		return panel;
	}
	
	/**
	 * 
	 * @return student id
	 */
	public String getStudentId() {
		return txtStudentId.getText();
	}
	/**
	 * method to set student id
	 * @param studentId
	 */
	public void setStudentId(String studentId) {
		txtStudentId.setText(studentId);
	}
	
	/**
	 * 
	 * @return student name 
	 */
	public String getStudentName() {
		return txtStudentName.getText();
	}
	
	/**
	 * method to set student name 
	 * @param StudentName
	 */
	public void setStudentName(String StudentName) {
		txtStudentName.setText(StudentName);
	}
	
	/**
	 * 
	 * @return college id
	 */
	public String getCollegeId() {
		return txtCollegeId.getText();
	}
	
	/**
	 * method to set college id
	 * @param collegeId
	 */
	public void setCollegeId(String collegeId) {
		txtCollegeId.setText(collegeId);
	}


	/**
	 * @return the tblStudentDetails
	 */
	public JTable getTblStudentDetails() {
		return tblStudentDetails;
	}


	/**
	 * @param tblStudentDetails the tblStudentDetails to set
	 */
	public void setTblStudentDetails(JTable tblStudentDetails) {
		this.tblStudentDetails = tblStudentDetails;
	}
	
	

}
