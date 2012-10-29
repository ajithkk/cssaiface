/**
 * 
 */
package org.cssa.iface.gui.timesheet;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.controls.CButton;

/**
 * @author ajith
 *
 */
public class TimeSheetView {

	public static final String PRINT = "Print";
	public static final String SAVE = "Save";
	public static final String CANCEL = "Cancel";
	public static final String ADD = "Add";
	public static final String DELETE = "Delete";
	
	private CButton btnPrint;
	private CButton btnSave;
	private CButton btnCancel;
	private CButton btnAdd;
	private CButton btnDelete;
	private JTable tblTimeSheet;
	
	private CssaMDIForm mdiForm;
	private TimeSheetController controller;
	private TimeSheetTableModel tableModel;
	
	/**
	 * @param mdiForm
	 * @param controller
	 * @param tableModel
	 */
	public TimeSheetView(CssaMDIForm mdiForm, TimeSheetController controller,
			TimeSheetTableModel tableModel) {
		super();
		this.mdiForm = mdiForm;
		this.controller = controller;
		this.tableModel = tableModel;
	}

	
	public void showTimeSheetScreen() {
		JPanel panel = new JPanel();
		
		panel.setMinimumSize(new Dimension(1150, 550));
		panel.setMaximumSize(new Dimension(1150, 550));
		panel.setPreferredSize(new Dimension(1150, 550));
		
		
		panel.add(searchPannel(),BorderLayout.EAST);
		mdiForm.addChild(panel, "Event Based search");
	}
	
	public JPanel getButtonPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;

		constraints = new GridBagConstraints();
		btnAdd = new CButton("Add");
		btnAdd.setActionCommand(ADD);
		btnAdd.setMnemonic('A');
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 2;
		constraints.gridy = 0;
		panel.add(btnAdd, constraints);
		btnAdd.addActionListener(controller);

		constraints = new GridBagConstraints();
		btnSave = new CButton("Save");
		btnSave.setMnemonic('S');
		btnSave.setActionCommand(SAVE);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 2;
		constraints.gridy = 1;
		panel.add(btnSave, constraints);
		btnSave.addActionListener(controller);
		
		constraints = new GridBagConstraints();
		btnDelete = new CButton("Delete");
		btnDelete.setMnemonic('X');
		btnDelete.setActionCommand(DELETE);
		
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 2;
		constraints.gridy = 2;
		panel.add(btnDelete, constraints);
		btnDelete.addActionListener(controller);

		constraints = new GridBagConstraints();
		btnPrint = new CButton("Print");
		btnPrint.setMnemonic('P');
		btnPrint.setActionCommand(PRINT);
		
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 2;
		constraints.gridy = 3;
		panel.add(btnPrint, constraints);
		btnPrint.addActionListener(controller);
		
		constraints = new GridBagConstraints();

		btnCancel = new CButton("Cancel");
		btnCancel.setMnemonic('C');
		btnCancel.setActionCommand(CANCEL);
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 2;
		constraints.gridy = 4;
		panel.add(btnCancel, constraints);
		btnCancel.addActionListener(controller);
		
		
		return panel;
	}
	
	
	public JPanel getTablePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		tblTimeSheet = new JTable(tableModel);
		tblTimeSheet.setRowHeight(20);
		tblTimeSheet.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tblTimeSheet);
		scrollPane.setMinimumSize(new Dimension(1170, 550));
		scrollPane.setMaximumSize(new Dimension(1170, 550));
		scrollPane.setPreferredSize(new Dimension(1170, 550));
		
		panel.add(scrollPane, BorderLayout.WEST);
		return panel;
	}
	
	public JPanel searchPannel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridy = 0;
		constraints.gridx = 0;
		panel.add(getTablePanel(), constraints);

		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.gridx =1;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.insets = new Insets(10, 5, 0, 0);
		panel.add(getButtonPanel(), constraints);

		return panel;
	}

	
	
	
	
	
	/**
	 * @return the tblTimeSheet
	 */
	public JTable getTblTimeSheet() {
		return tblTimeSheet;
	}

	/**
	 * @param tblTimeSheet the tblTimeSheet to set
	 */
	public void setTblTimeSheet(JTable tblTimeSheet) {
		this.tblTimeSheet = tblTimeSheet;
	}
	
	
	
	
	

}
