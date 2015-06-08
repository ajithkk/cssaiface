/**
 * 
 */
package org.cssa.iface.gui.student;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.controls.CButton;
import org.cssa.iface.gui.controls.CLabel;
import org.cssa.iface.gui.controls.CTextField;

/**
 * @author ajith
 *
 */
public class GroupEventView {
	
	public static final String SEARCH = "Search";
	public static final String ADD = "Add";
	public static final String REMOVE = "Remove";
	public static final String DELETE = "Delete";
	public static final String PRINT = "Print";
	public static final String EVENT_SELECTED = "Event_Selected";
	public static final String SAVE = "Save";
	public static final String CLEAR = "Clear";
	public static final String GROUP_SELECTED = "Group_Selected";
	
	public CLabel lblEventId;
	public CLabel lblGroupName;
	public CLabel lblCollegeId;
	public CLabel lblCollegeName;
	
	public CTextField txtCollegeId;
	public CTextField txtCollegeName;
	
	public JButton btnAdd;
	public JButton btnRemove;
	public JButton btnSearch;
	
	public CButton  btnDelete;
	public CButton btnPrint;
	
	private CButton btnSave;
	private CButton btnClear;
	
	public JComboBox cmbEventNames;
	public JComboBox cmbGroupNames;
	
	public JList lstAllStudentIds;
	public JList lstAddedStudentList;
	public JTable tblEventDetails;
	
	private CssaMDIForm mdiForm;
	private GroupEventController groupEventController;
	private GroupEventTableModel tableModel;
	private boolean collegeVisible;
	
	
	public GroupEventView(CssaMDIForm mdiForm,
			GroupEventController groupEventController,
			GroupEventTableModel tableModel) {
		super();
		this.mdiForm = mdiForm;
		this.groupEventController = groupEventController;
		this.tableModel = tableModel;
	}

	public JPanel getCollegeSearchPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		
		lblCollegeId = new CLabel("College Id:");
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(5, 5, 5, 5);
		panel.add(lblCollegeId, constraints);
		
		txtCollegeId = new CTextField();
		txtCollegeId.setPreferredSize(new Dimension(173, 23));
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.insets = new Insets(5, 0, 5, 5);
		panel.add(txtCollegeId,constraints);
		
		btnSearch = new JButton("Search");
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.insets = new Insets(5, 0, 5, 5);
		panel.add(btnSearch, constraints);
		btnSearch.addActionListener(groupEventController);
		
		lblCollegeName = new CLabel("College Name:");
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(5, 5, 5, 5);
		panel.add(lblCollegeName, constraints);
		
		txtCollegeName = new CTextField();
		txtCollegeName.setPreferredSize(new Dimension(173, 23));
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 1;
		panel.add(txtCollegeName, constraints);
		
		return panel;
		
	}
	
	public JPanel getEventListPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		
		lblEventId = new CLabel("Event Name:");
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(5, 5, 5, 5);
		panel.add(lblEventId, constraints);
		
		cmbEventNames = new JComboBox();
		cmbEventNames.addActionListener(groupEventController);
		cmbEventNames.setActionCommand(EVENT_SELECTED);
		cmbEventNames.setMaximumSize(new Dimension(180, 23));
		cmbEventNames.setMinimumSize(new Dimension(180,23));
		cmbEventNames.setPreferredSize(new Dimension(180,23));
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.insets = new Insets(5, 5, 5, 5);
		panel.add(cmbEventNames, constraints);
		
		lstAllStudentIds = new JList();
		lstAllStudentIds.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		lstAllStudentIds.setLayoutOrientation(JList.VERTICAL);
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		constraints.insets = new Insets(5, 5, 5, 5);
		JScrollPane scrollPane = new JScrollPane(lstAllStudentIds);
		scrollPane.setMinimumSize(new Dimension(255, 175));
		scrollPane.setMaximumSize(new Dimension(255, 175));
		scrollPane.setPreferredSize(new Dimension(250, 175));
		panel.add(scrollPane, constraints);

		return panel;
		
	}
	
	public JPanel getGruopListPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		
		lblGroupName = new CLabel("Group Name:");
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(5, 5, 5, 5);
		panel.add(lblGroupName, constraints);
		
		cmbGroupNames = new JComboBox();
		cmbGroupNames.addActionListener(groupEventController);
		cmbGroupNames.setActionCommand(GROUP_SELECTED);
		cmbGroupNames.setMaximumSize(new Dimension(180, 23));
		cmbGroupNames.setMinimumSize(new Dimension(180,23));
		cmbGroupNames.setPreferredSize(new Dimension(180,23));
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.insets = new Insets(5, 0, 5, 5);
		panel.add(cmbGroupNames, constraints);
		
		lstAddedStudentList = new JList();
		lstAddedStudentList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		lstAddedStudentList.setLayoutOrientation(JList.VERTICAL);
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		constraints.insets = new Insets(5, 5, 5, 5);
		JScrollPane scrollPane = new JScrollPane(lstAddedStudentList,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setMinimumSize(new Dimension(255, 175));
		scrollPane.setMaximumSize(new Dimension(255, 175));
		scrollPane.setPreferredSize(new Dimension(250, 175));
		panel.add(scrollPane, constraints);

		return panel;
		
	}
	
	public JPanel getListButtonPanel() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;

		btnAdd = new JButton(">>");
		btnAdd.setActionCommand(ADD);
		btnAdd.setMinimumSize(new Dimension(50,23));
		btnAdd.setMaximumSize(new Dimension(50, 23));
		btnAdd.setPreferredSize(new Dimension(50, 23));
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(5, 5, 5, 5);
		panel.add(btnAdd, constraints);
		btnAdd.addActionListener(groupEventController);
		
		btnRemove = new JButton("<<");
		btnRemove.setActionCommand(REMOVE);
		btnRemove.setMinimumSize(new Dimension(50,23));
		btnRemove.setMaximumSize(new Dimension(50, 23));
		btnRemove.setPreferredSize(new Dimension(50, 23));
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(5, 5, 5, 5);
		panel.add(btnRemove, constraints);
		btnRemove.addActionListener(groupEventController);
		
		return panel;
	}
	
  public JPanel getListSideButtonPanel() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;

		btnSave = new CButton("Save");
		btnSave.setActionCommand(SAVE);
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(5, 5, 5, 5);
		panel.add(btnSave, constraints);
		btnSave.addActionListener(groupEventController);
		
		btnClear = new CButton("Clear");
		btnClear.setActionCommand(CLEAR);
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(5, 5, 5, 5);
		panel.add(btnClear, constraints);
		btnClear.addActionListener(groupEventController);
		
		return panel;
	}
	public JPanel getTableButtonPanel() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;

		btnPrint = new CButton("Print");
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(5, 5, 5, 5);
		panel.add(btnPrint, constraints);
		btnPrint.setActionCommand(PRINT);
		btnPrint.addActionListener(groupEventController);
		
		btnDelete = new CButton("Delete");
		constraints = new GridBagConstraints();
		btnDelete.setActionCommand(DELETE);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(5, 5, 5, 5);
		panel.add(btnDelete, constraints);
		btnDelete.addActionListener(groupEventController);
		
		return panel;
	}
	public JPanel getTablePanel() {
		JPanel panel = new JPanel();
		tblEventDetails = new JTable(tableModel);
		tblEventDetails.setRowHeight(20);
		tblEventDetails.addMouseListener(groupEventController);
		tblEventDetails.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(tblEventDetails);
		scrollPane.setMinimumSize(new Dimension(900, 200));
		scrollPane.setMaximumSize(new Dimension(900, 200));
		scrollPane.setPreferredSize(new Dimension(900, 200));
		panel.add(scrollPane, BorderLayout.CENTER);

		return panel;
	}
	
	public JPanel getMiddlePanel1() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Group", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new javax.swing.plaf.FontUIResource("Microsoft Sans Serif",Font.BOLD,11)));
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(getEventListPanel(),constraints);
		
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 1;
		constraints.gridy = 0;
		panel.add(getListButtonPanel(), constraints);
		
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 2;
		constraints.gridy = 0;
		panel.add(getGruopListPanel(), constraints);
		
		
		return panel;
		
	}
	
	public JPanel getMiddlePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 1;
		constraints.gridy = 0;
		panel.add(getMiddlePanel1(), constraints);
		
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 2;
		constraints.gridy = 0;
		//panel.add(getListSideButtonPanel(), constraints);
		
		return panel;
		
	}
	public JPanel getBottomPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(getTablePanel(), constraints);
		
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 0;
		panel.add(getTableButtonPanel(), constraints);
		
		return panel;
		
	}
	public JPanel getBody(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints;
		
		
		if(isCollegeVisible()) {
			constraints = new GridBagConstraints();
			constraints.anchor = GridBagConstraints.WEST;
			constraints.gridx = 0;
			constraints.gridy = 0;
			panel.add(getCollegeSearchPanel(), constraints);
		}
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		panel.add(getMiddlePanel(), constraints);
		
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 2;
		panel.add(getBottomPanel(), constraints);
		
		return panel;
		
	}
	
	public String getCollegeId() {
		return txtCollegeId.getText();
	}
	
	public void setCollegeId(String collegeId) {
		txtCollegeId.setText(collegeId);
	}
	
	public String getCollegeName() {
		return txtCollegeName.getText();
	}
	
	public void setCollegeName(String collegeName) {
		txtCollegeName.setText(collegeName);
	}

	/**
	 * @return the lstAllStudentIds
	 */
	public JList getLstAllStudentIds() {
		return lstAllStudentIds;
	}

	/**
	 * @param lstAllStudentIds the lstAllStudentIds to set
	 */
	public void setLstAllStudentIds(JList lstAllStudentIds) {
		this.lstAllStudentIds = lstAllStudentIds;
	}

	/**
	 * @return the lstAddedStudentList
	 */
	public JList getLstAddedStudentList() {
		return lstAddedStudentList;
	}

	/**
	 * @param lstAddedStudentList the lstAddedStudentList to set
	 */
	public void setLstAddedStudentList(JList lstAddedStudentList) {
		this.lstAddedStudentList = lstAddedStudentList;
	}

	/**
	 * @return the tblEventDetails
	 */
	public JTable getTblEventDetails() {
		return tblEventDetails;
	}

	/**
	 * @param tblEventDetails the tblEventDetails to set
	 */
	public void setTblEventDetails(JTable tblEventDetails) {
		this.tblEventDetails = tblEventDetails;
	}

	/**
	 * @return the cmbEventNames
	 */
	public JComboBox getCmbEventNames() {
		return cmbEventNames;
	}

	/**
	 * @param cmbEventNames the cmbEventNames to set
	 */
	public void setCmbEventNames(JComboBox cmbEventNames) {
		this.cmbEventNames = cmbEventNames;
	}

	/**
	 * @return the cmbGroupNames
	 */
	public JComboBox getCmbGroupNames() {
		return cmbGroupNames;
	}

	/**
	 * @param cmbGroupNames the cmbGroupNames to set
	 */
	public void setCmbGroupNames(JComboBox cmbGroupNames) {
		this.cmbGroupNames = cmbGroupNames;
	}

	/**
	 * @return the collegeVisible
	 */
	public boolean isCollegeVisible() {
		return collegeVisible;
	}

	/**
	 * @param collegeVisible the collegeVisible to set
	 */
	public void setCollegeVisible(boolean collegeVisible) {
		this.collegeVisible = collegeVisible;
	}
	
	
}
