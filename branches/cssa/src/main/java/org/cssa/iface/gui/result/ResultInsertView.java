/**
 * 
 */
package org.cssa.iface.gui.result;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.controls.CButton;
import org.cssa.iface.gui.controls.CLabel;
import org.cssa.iface.gui.controls.CTextField;
import org.cssa.iface.gui.util.FloatEditor;
import org.cssa.iface.util.ImageUtil;

/**
 * @author ajith
 *
 */
public class ResultInsertView {
	
	public static final String CANCEL = "Cancel";
	public static final String CLEAR = "Clear";
	public static final String SEARCH = "Search";
	public static final String SAVE = "Save";
	public static final String COLLEGE_SEARCH = "College_Search";
	public static final String STUDENT_SEARCH = "Student_Search";
	
	
	private CLabel lblEventCode;
	private CLabel lblEventStage;
	private CLabel lblCollegeId;
	private CLabel lblStudentId;
	
	private CTextField txtCollegeId;
	private CTextField txtStudentId;
	
	private CButton btnSearch;
	private CButton btnClear;
	private CButton btnCancel;
	private CButton btnInsert;
	private CButton btnStudentSearch;
	private CButton btnCollegeSearch;
	
	private JComboBox cmbEventCode;
	private JComboBox cmbEventStage;
	private JTable tblParticipants;
	
	private CssaMDIForm mdiForm;
	private ResultInsertController controller;
	private ResultInsertTableModel tableModel;
	
	/**
	 * @param mdiForm
	 * @param controller
	 * @param tableModel
	 */
	public ResultInsertView(CssaMDIForm mdiForm,
			ResultInsertController controller, ResultInsertTableModel tableModel) {
		this.mdiForm = mdiForm;
		this.controller = controller;
		this.tableModel = tableModel;
	}
	public void showResultInsertScreen() {
		JPanel tabbedPane = new JPanel();
		tabbedPane.add(getResultDetailsBody(), BorderLayout.CENTER);
		mdiForm.addChild(tabbedPane, "Inser Result");
	}
	public JPanel eventPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		
		lblEventCode = new CLabel("Event Code");
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 5, 0, 2);
		panel.add(lblEventCode, constraints);
		
		cmbEventCode = new JComboBox();
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 0, 5, 2);
		cmbEventCode.setPreferredSize(new Dimension(250, 23));
		panel.add(cmbEventCode, constraints);
		
		lblEventStage = new CLabel("Event Stage: ");
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 5, 0, 2);
		panel.add(lblEventStage, constraints);
		
		cmbEventStage = new JComboBox();
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 0, 5, 2);
		cmbEventStage.setPreferredSize(new Dimension(250, 23));
		panel.add(cmbEventStage, constraints);
		
		lblCollegeId = new CLabel("College Id");
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 5, 0, 2);
		panel.add(lblCollegeId, constraints);
		
		txtCollegeId = new CTextField();
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 0, 5, 2);
		panel.add(txtCollegeId, constraints);
		
		ImageIcon icon = new ImageIcon(new ImageUtil().getImage("search.gif"));
		btnCollegeSearch = new CButton(icon);
		btnCollegeSearch.setPreferredSize(new Dimension(40, 23));
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 2;
		constraints.gridy = 3;
		constraints.insets = new Insets(5, 0, 5, 2);
		panel.add(btnCollegeSearch, constraints);
		btnCollegeSearch.addActionListener(controller);
		btnCollegeSearch.setActionCommand(COLLEGE_SEARCH);
		
		
		lblStudentId = new CLabel("Student Id");
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 5, 0, 2);
		panel.add(lblStudentId, constraints);
		
		txtStudentId = new CTextField();
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 0, 5, 2);
		panel.add(txtStudentId, constraints);
		
		 icon = new ImageIcon(new ImageUtil().getImage("search.gif"));
		btnStudentSearch = new CButton(icon);
		btnStudentSearch.setPreferredSize(new Dimension(40, 23));
		
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 2;
		constraints.gridy = 4;
		constraints.insets = new Insets(5, 0, 5, 2);
		panel.add(btnStudentSearch, constraints);
		btnStudentSearch.addActionListener(controller);
		btnStudentSearch.setActionCommand(STUDENT_SEARCH);
		
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
		btnSearch.addActionListener(controller);

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
	
	
	public JPanel getTablePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		tblParticipants = new JTable(tableModel);
		tblParticipants.setRowHeight(20);
		tblParticipants.setDefaultEditor(Float.class, new FloatEditor(0.0, 500.0));
		tblParticipants.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tblParticipants);
		scrollPane.setMinimumSize(new Dimension(700, 400));
		scrollPane.setMaximumSize(new Dimension(700, 400));
		scrollPane.setPreferredSize(new Dimension(700, 400));
		panel.add(scrollPane, BorderLayout.CENTER);
		//tblParticipants.addMouseListener(controller);
		return panel;
	}
	public JPanel getSideButtonPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;

		constraints = new GridBagConstraints();
		btnInsert = new CButton("Save");
		btnInsert.setMnemonic('a');
		btnInsert.setActionCommand(SAVE);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(btnInsert, constraints);
		btnInsert.addActionListener(controller);
		
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
		panel.add(eventPanel(), constraints);

		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 6;
		constraints.insets = new Insets(10, 0, 10, 0);
		constraints.anchor = GridBagConstraints.CENTER;
		panel.add(getButtonPanel(), constraints);
		return panel;
	}

	public JPanel getBottomPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridy = 0;
		constraints.gridx = 1;
		panel.add(getTablePanel(), constraints);

		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.insets = new Insets(10, 5, 0, 0);
		panel.add(getSideButtonPanel(), constraints);

		return panel;
	}

	public JPanel getResultDetailsBody() {
		
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
		panel.add(getBottomPanel(), constraints);

		return panel;
	}

	/**
	 * @return the cmbEventCode
	 */
	public JComboBox getCmbEventCode() {
		return cmbEventCode;
	}
	/**
	 * @param cmbEventCode the cmbEventCode to set
	 */
	public void setCmbEventCode(JComboBox cmbEventCode) {
		this.cmbEventCode = cmbEventCode;
	}
	/**
	 * @return the cmbEventStage
	 */
	public JComboBox getCmbEventStage() {
		return cmbEventStage;
	}
	/**
	 * @param cmbEventStage the cmbEventStage to set
	 */
	public void setCmbEventStage(JComboBox cmbEventStage) {
		this.cmbEventStage = cmbEventStage;
	}
	/**
	 * @return the txtCollegeId
	 */
	public String getTxtCollegeId() {
		return txtCollegeId.getText();
	}
	/**
	 * @param txtCollegeId the txtCollegeId to set
	 */
	public void setTxtCollegeId(String txtCollegeId) {
		this.txtCollegeId.setText(txtCollegeId);
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
	 * @return the tblParticipants
	 */
	public JTable getTblParticipants() {
		return tblParticipants;
	}
	/**
	 * @param tblParticipants the tblParticipants to set
	 */
	public void setTblParticipants(JTable tblParticipants) {
		this.tblParticipants = tblParticipants;
	}
	/**
	 * @return the tableModel
	 */
	public ResultInsertTableModel getTableModel() {
		return tableModel;
	}
	/**
	 * @param tableModel the tableModel to set
	 */
	public void setTableModel(ResultInsertTableModel tableModel) {
		this.tableModel = tableModel;
	}
		
	
}
