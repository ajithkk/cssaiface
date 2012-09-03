/**
 * 
 */
package org.cssa.iface.gui.result;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.controls.CButton;
import org.cssa.iface.gui.controls.CLabel;

/**
 * @author ajith
 *
 */
public class ResultInsertView {
	
	public static final String CANCEL = "Cancel";
	public static final String CLEAR = "Clear";
	public static final String SEARCH = "Search";
	public static final String SAVE = "Save";
	
	
	private CLabel lblEventCode;
	private CLabel lblEventStage;
	
	

	private CButton btnSearch;
	private CButton btnClear;
	private CButton btnCancel;
	private CButton btnInsert;
	
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
	public void showEventscreen() {
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
	
	
}
