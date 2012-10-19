/**
 * 
 */
package org.cssa.iface.gui.student;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
public class StudentDetailsView {
	
	public static final String[] GENDER = {"Male", "Female"};

	public static final String SAVE = "Save";
	public static final String PRINT = "Print";
	public static final String EDIT = "Edit";
	public static final String CANCEL = "Cancel";
	public static final String CLEAR = "clear";
	public static final String DELETE = "Delete";
	public static final String ADD = "Add";
	
	private CLabel lblStudentId;
	private CLabel lblCollegeId;
	private CLabel lblStudentName;
	private CLabel lblGender;
	private CLabel lblPhone;
	
	private CTextField txtStudentId;
	private CTextField txtCollegeId;
	private CTextField txtStudentName;
	private CTextField txtPhone;
	
	private JComboBox cbGender;
	private JCheckBox ckAccommodation;
	private JCheckBox status;
	private JTable studentTable;
	
	private CssaMDIForm cssaMDIForm;
	private StudentDetailsEventTableModel tableModel;
	private StudentDetailsController controller;

	private CButton btnSave;
	private CButton btnClear;
	private CButton btnCancel;
	private CButton btnDelete;
	private CButton btnPrint;
    private CButton btnAdd;
	private CButton btnEdit;
	
	
	public StudentDetailsView(CssaMDIForm cssaMDIForm,
			StudentDetailsEventTableModel tableModel,StudentDetailsController controller) {
		super();
		this.cssaMDIForm = cssaMDIForm;
		this.tableModel = tableModel;
		this.controller = controller;
	}
	
	public void showStudentScreen() {
		JPanel tabbedPane = new JPanel();
		tabbedPane.add(getStudentDetailsBody(), BorderLayout.CENTER);
		cssaMDIForm.addChild(tabbedPane, "Event Details");
	}


	public  JPanel getStudentDetailsPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		
		lblStudentId = new CLabel("Studen Id:");
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(3, 0, 2, 2);
		panel.add(lblStudentId,constraints);
		
		txtStudentId = new CTextField();
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.insets = new Insets(3, 2, 2, 0);
		txtStudentId.setEditable(false);
		panel.add(txtStudentId, constraints);
		
		lblCollegeId = new CLabel("College Id:");
		constraints = new GridBagConstraints();
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(3, 6, 2, 2);
		panel.add(lblCollegeId, constraints);
		
		txtCollegeId = new CTextField();
		constraints = new GridBagConstraints();
		constraints.gridx = 3;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(3, 2, 3, 0);
		txtCollegeId.setEditable(false);
		panel.add(txtCollegeId, constraints);
		
		lblStudentName = new CLabel("Student Name:");
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(2, 0, 2, 2);
		panel.add(lblStudentName, constraints);
		
		txtStudentName = new CTextField();
		constraints = new GridBagConstraints();
		txtStudentName.setPreferredSize(new Dimension(390,20));
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 3;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(2, 3, 3, 0);
		panel.add(txtStudentName, constraints);
		
		lblPhone = new CLabel("Phone:");
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(2, 3, 3, 2);
		panel.add(lblPhone, constraints);
		
		txtPhone = new CTextField();
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(2, 2, 2, 2);
		panel.add(txtPhone, constraints);
		
		constraints = new GridBagConstraints();
		constraints.gridx = 2;
		constraints.gridy = 2;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(2, 5, 2, 2);
		panel.add(getGenderPanel(), constraints);
		
		return panel;
		
	}
	
	public JPanel getGenderPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		
		panel.setPreferredSize(new Dimension(300, 20));
		panel.setMaximumSize(new Dimension(300, 20));
		panel.setMinimumSize(new Dimension(300, 20));
		
		constraints = new GridBagConstraints();
		lblGender = new CLabel("Gender:");
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(2, 0, 3, 2);
		panel.add(lblGender, constraints);
		
		cbGender = new JComboBox(GENDER);
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(2, 5, 3, 5);
		panel.add(cbGender, constraints);
		
		status = new JCheckBox("Status");
		status.setSelected(true);
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 10, 5, 5);
		constraints.gridx = 2;
		constraints.gridy = 0;
		panel.add(status,constraints);
		
		ckAccommodation = new JCheckBox("Accommodation");
		constraints = new GridBagConstraints();
		constraints.gridx = 3;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(2, 10, 3, 0);
		panel.add(ckAccommodation, constraints);
		return panel;
	}
	
	public JPanel getMiddleButtonPanel() {

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;

		constraints = new GridBagConstraints();
		btnSave = new CButton("Save");
		btnSave.setMnemonic('S');
		btnSave.setActionCommand(SAVE);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 2;
		constraints.gridy = 0;
		panel.add(btnSave, constraints);
		btnSave.addActionListener(controller);

		constraints = new GridBagConstraints();
		btnClear = new CButton("Clear");
		btnClear.setMnemonic('L');
		btnClear.setActionCommand(CLEAR);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 3;
		constraints.gridy = 0;
		panel.add(btnClear, constraints);
		btnClear.addActionListener(controller);

		constraints = new GridBagConstraints();
		btnCancel = new CButton("Cancel");
		btnCancel.setMnemonic('C');
		btnCancel.setActionCommand(CANCEL);
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 4;
		constraints.gridy = 0;
		panel.add(btnCancel, constraints);
		btnCancel.addActionListener(controller);
		
		return panel;
	}
	
	public JPanel getSideButtonPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;

		constraints = new GridBagConstraints();
		btnEdit = new CButton("Edit");
		btnEdit.setMnemonic('E');
		btnEdit.setActionCommand(EDIT);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(btnEdit, constraints);
		btnEdit.addActionListener(controller);
		
		constraints = new GridBagConstraints();
		btnAdd = new CButton("Add");
		btnAdd.setMnemonic('A');
		btnAdd.setActionCommand(ADD);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 1;
		panel.add(btnAdd, constraints);
		btnAdd.addActionListener(controller);
		

		constraints = new GridBagConstraints();
		btnDelete = new CButton("Delete");
		btnDelete.setMnemonic('D');
		btnDelete.setActionCommand(DELETE);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 2;
		panel.add(btnDelete, constraints);
		btnDelete.addActionListener(controller);

		constraints = new GridBagConstraints();
		btnPrint = new CButton("Print");
		btnPrint.setMnemonic('P');
		btnPrint.setActionCommand(PRINT);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 3;
		panel.add(btnPrint, constraints);
		btnPrint.addActionListener(controller);
		
		return panel;
	}
	
	
	public JPanel getTablePannel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		studentTable = new JTable(tableModel);
		studentTable.setRowHeight(20);
		JScrollPane scrollPane = new JScrollPane(studentTable);
		scrollPane.setMinimumSize(new Dimension(600, 200));
		scrollPane.setMaximumSize(new Dimension(600, 200));
		scrollPane.setPreferredSize(new Dimension(600, 200));
		panel.add(scrollPane, BorderLayout.CENTER);
		studentTable.addMouseListener(controller);
		return panel;
	}	
	
	
	public JPanel getTopPannel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 0, 0, 0);
		constraints.gridx = 1;
		constraints.gridy = 5;
		constraints.anchor = GridBagConstraints.NORTH;
		panel.add(getStudentDetailsPanel(), constraints);

		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 6;
		constraints.insets = new Insets(10, 0, 10, 0);
		constraints.anchor = GridBagConstraints.CENTER;
		panel.add(getMiddleButtonPanel(), constraints);
		return panel;
	}

	public JPanel getBottomPannel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridy = 0;
		constraints.gridx = 1;
		panel.add(getTablePannel(), constraints);

		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.insets = new Insets(10, 5, 0, 0);
		panel.add(getSideButtonPanel(), constraints);

		return panel;
	}

	public JPanel getStudentDetailsBody() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints;
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 5, 0, 10);
		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(getTopPannel(), constraints);

		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(0, 5, 5, 5);
		panel.add(getBottomPannel(), constraints);

		return panel;
	}

	
	

	/**
	 * @return the status
	 */
	public JCheckBox getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(JCheckBox status) {
		this.status = status;
	}

	/**
	 * @return the txtStudentId
	 */
	public String getTxtStudentId() {
		return txtStudentId.getText();
	}


	/**
	 * @param txtStudentId the txtStudentId to set
	 */
	public void setTxtStudentId(String txtStudentId) {
		this.txtStudentId.setText(txtStudentId);
	}


	/**
	 * @return the txtCollegeId
	 */
	public String  getTxtCollegeId() {
		return txtCollegeId.getText();
	}


	/**
	 * @param txtCollegeId the txtCollegeId to set
	 */
	public void setTxtCollegeId(String txtCollegeId) {
		this.txtCollegeId.setText(txtCollegeId);
	}


	/**
	 * @return the txtStudentName
	 */
	public String getTxtStudentName() {
		return txtStudentName.getText();
	}


	/**
	 * @param txtStudentName the txtStudentName to set
	 */
	public void setTxtStudentName(String  txtStudentName) {
		this.txtStudentName.setText(txtStudentName);
	}


	/**
	 * @return the txtPhone
	 */
	public String getTxtPhone() {
		return txtPhone.getText();
	}


	/**
	 * @param txtPhone the txtPhone to set
	 */
	public void setTxtPhone(String txtPhone) {
		this.txtPhone.setText(txtPhone);
	}


	/**
	 * @return the cbGender
	 */
	public JComboBox getCbGender() {
		return cbGender;
	}


	/**
	 * @param cbGender the cbGender to set
	 */
	public void setCbGender(String cbGender) {
		this.cbGender.setSelectedItem(cbGender);
	}


	/**
	 * @return the ckAccommodation
	 */
	public JCheckBox getCkAccommodation() {
		return ckAccommodation;
	}


	/**
	 * @param ckAccommodation the ckAccommodation to set
	 */
	public void setCkAccommodation(Boolean ckAccommodation) {
		this.ckAccommodation.setSelected(ckAccommodation);
	}


	/**
	 * @return the studentTable
	 */
	public JTable getStudentTable() {
		return studentTable;
	}


	/**
	 * @param studentTable the studentTable to set
	 */
	public void setStudentTable(JTable studentTable) {
		this.studentTable = studentTable;
	}


	/**
	 * @return the tableModel
	 */
	public StudentDetailsEventTableModel getTableModel() {
		return tableModel;
	}


	/**
	 * @param tableModel the tableModel to set
	 */
	public void setTableModel(StudentDetailsEventTableModel tableModel) {
		this.tableModel = tableModel;
	}
	
}
