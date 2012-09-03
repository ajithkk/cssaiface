/**
 * 
 */
package org.cssa.iface.gui.result;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.controls.CButton;
import org.cssa.iface.gui.controls.CLabel;
import org.cssa.iface.gui.controls.CTextField;

/**
 * @author ajith
 *
 */
public class InsertResultView {
	
	public static final String INSERT = "Insert";
	public static final String CANCEL = "Cancel";
	public static final String CLEAR = "Clear";
	public static final String SEARCH = "Search";
	
	private CLabel lblCollegeId;
	private CLabel lblStudentId;
	private CLabel lblEventId;
	private CLabel lblEventStage;
	private CLabel lblResultStatus;
	private CLabel lblMark;
	
	private CTextField txtCollegeId;
	private CTextField txtStudentId;
	private CTextField txtMark;
	
	private JComboBox cmbEventId;
	private JComboBox cmbEventStage;
	private JComboBox cmbResultStatus;
	
	private CButton btnInsert;
	private CButton btnCancel;
	private CButton btnClear;
	private CButton btnSearch;
	
	private InsertResultController controller;
	private InsertResultTableModel tableModel;
	private CssaMDIForm mdiForm;
	private JTable tblCollegeDetails;
	
	
	public InsertResultView(InsertResultController controller, CssaMDIForm mdiForm, InsertResultTableModel tableModel) {
		super();
		this.controller = controller;
		this.mdiForm = mdiForm;
		this.tableModel = tableModel;
	}
	
	public void showInsertResultScreen() {
		
		JPanel panel = new JPanel();
		panel.add(getInsertResultBody(), BorderLayout.CENTER);
		mdiForm.addChild(panel, "Insert Result");
		
	}
	
	public JPanel getMainPanel() {
		JPanel  panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		
		lblEventId = new CLabel("Event Code");
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 5, 0, 2);
		panel.add(lblEventId, constraints);
		
		cmbEventId = new JComboBox();
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 0, 5, 2);
		cmbEventId.setPreferredSize(new Dimension(250, 23));
		panel.add(cmbEventId, constraints);
		
		lblStudentId = new CLabel("Student Id");
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 0, 5, 2);
		panel.add(lblStudentId, constraints);
		
		txtStudentId = new CTextField();
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.insets = new Insets(5, 0, 5, 2);
		panel.add(txtStudentId, constraints);
		
		btnSearch = new CButton();
		btnSearch.setPreferredSize(new Dimension(40, 23));
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.insets = new Insets(5, 0, 5, 2);
		panel.add(btnSearch, constraints);
		btnSearch.addActionListener(controller);
		btnSearch.setActionCommand(SEARCH);
		
		lblCollegeId = new CLabel("College Id:");
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 2;
	    constraints.anchor = GridBagConstraints.EAST;
	    constraints.insets = new Insets(5, 5, 0, 2);
	    panel.add(lblCollegeId, constraints);
	    
	    txtCollegeId = new CTextField();
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.insets = new Insets(5, 0, 5, 2);
		panel.add(txtCollegeId, constraints);
		
		lblMark = new CLabel("Mark :");
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 3;
	    constraints.anchor = GridBagConstraints.EAST;
	    constraints.insets = new Insets(5, 5, 0, 2);
	    panel.add(lblMark, constraints);
	    
	    txtMark = new CTextField();
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.insets = new Insets(5, 0, 5, 2);
		panel.add(txtMark, constraints);
	    
		lblEventStage = new CLabel("Event Stage: ");
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 5, 0, 2);
		panel.add(lblEventStage, constraints);
		
		cmbEventStage = new JComboBox();
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 0, 5, 2);
		cmbEventStage.setPreferredSize(new Dimension(250, 23));
		panel.add(cmbEventStage, constraints);
		
		return panel;
	}
	public JPanel getMiddleButtonPanel() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		
		constraints = new GridBagConstraints();
		btnInsert = new CButton("Save");
		btnInsert.setMnemonic('S');
		btnInsert.setActionCommand(INSERT);
		btnInsert.addActionListener(controller);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx =3;
		constraints.gridy = 0;
		panel.add(btnInsert, constraints);
		
		constraints = new GridBagConstraints();
		btnClear = new CButton("Clear");
		btnClear.setMnemonic('L');
		btnClear.setActionCommand(CLEAR);
		btnClear.addActionListener(controller);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 4;
		constraints.gridy = 0;
		panel.add(btnClear,constraints);
		
		constraints = new GridBagConstraints();
		btnCancel = new CButton("Cancel");
		btnCancel.setMnemonic('C');
		btnCancel.setActionCommand(CANCEL);
		btnCancel.addActionListener(controller);
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 5;
		constraints.gridy = 0;
		panel.add(btnCancel,constraints);
		
		return panel;
	}
	
	public JPanel getResultStatusPanel() {
		JPanel  panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		
		lblResultStatus = new CLabel("Event Stage: ");
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 5, 0, 2);
		panel.add(lblResultStatus, constraints);
		
		cmbResultStatus = new JComboBox();
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 0, 5, 2);
		cmbResultStatus.setPreferredSize(new Dimension(250, 23));
		panel.add(cmbResultStatus, constraints);
		
		return panel;
		
	}
	
	public JPanel getTablePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		tblCollegeDetails = new JTable(tableModel);
		tblCollegeDetails.setRowHeight(20);
		JScrollPane scrollPane = new JScrollPane(tblCollegeDetails);
		scrollPane.setMinimumSize(new Dimension(700, 200));
		scrollPane.setMaximumSize(new Dimension(700, 200));
		scrollPane.setPreferredSize(new Dimension(700, 200));
		panel.add(scrollPane, BorderLayout.CENTER);
		//tblCollegeDetails.addMouseListener(controller);
		return panel;
	}
	
	public JPanel getInsertResultBody() {
		
		JPanel  panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		
		panel.setLayout(new GridBagLayout());
	    constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(getMainPanel(),constraints);
		 constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 2;
		panel.add(getMiddleButtonPanel(),constraints);
		
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.insets = new Insets(5, 5, 0, 2);
		panel.add(getTablePanel(),constraints);
		
		return panel;
	}
	
	public JComboBox getCmbEventId() {
		return cmbEventId;
	}

	public void setCmbEventId(JComboBox cmbEventId) {
		this.cmbEventId = cmbEventId;
	}

	public JComboBox getCmbEventStage() {
		return cmbEventStage;
	}

	public void setCmbEventStage(JComboBox cmbEventStage) {
		this.cmbEventStage = cmbEventStage;
	}

	public JComboBox getCmbResultStatus() {
		return cmbResultStatus;
	}

	public void setCmbResultStatus(JComboBox cmbResultStatus) {
		this.cmbResultStatus = cmbResultStatus;
	}

	public JTable getTblCollegeDetails() {
		return tblCollegeDetails;
	}

	public void setTblCollegeDetails(JTable tblCollegeDetails) {
		this.tblCollegeDetails = tblCollegeDetails;
	}

	public void setCollegeId(String collegeId) {
		txtCollegeId.setText(collegeId);
	}
	
	public String getCollegeId() {
		return txtCollegeId.getText();
	}
	
	public void setStudentId(String studentId) {
		txtStudentId.setText(studentId);
	}
	
	public String getStudentId() {
		 return txtStudentId.getText();
	}
	
	public void setMark(String mark) {
		txtMark.setText(mark);
	}
	
	public String getMark() {
		return txtMark.getText();
	}
	
	public String getEventCode() {
		return cmbEventId.getSelectedItem().toString();
	}
	
	public String getEventStage() {
		return cmbEventStage.getSelectedItem().toString();
	}
	
	public String getResultStatus() {
		return cmbResultStatus.getSelectedItem().toString();
	}
}
