/**
 * 
 */
package org.cssa.iface.gui.database;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.controls.CButton;

/**
 * @author ajith
 *
 */
public class DatabaseView {

	public static final String PRINT = "Print";
	public static final String CANCEL = "Cancel";
	public static final String CLEAR = "Clear";
	
	
	private CButton btnPrint;
	private CButton btnCancel;
	private CButton btnClear;
	private JTable tblSearchResult;
	
	private DatabaseViewController controller;
	private AbstractTableModel tableModel;
	private CssaMDIForm mdiForm;
	
	/**
	 * @param controller
	 * @param tableModel
	 * @param mdiForm
	 */
	public DatabaseView(DatabaseViewController controller,
			AbstractTableModel tableModel, CssaMDIForm mdiForm) {
		super();
		this.controller = controller;
		this.tableModel = tableModel;
		this.mdiForm = mdiForm;
	}
	
	
	public void showSearchResultScreen() {
		JPanel panel = new JPanel();
		
		panel.setMinimumSize(new Dimension(1150, 550));
		panel.setMaximumSize(new Dimension(1150, 550));
		panel.setPreferredSize(new Dimension(1150, 550));
		
		
		panel.add(searchPannel(),BorderLayout.EAST);
		mdiForm.addChild(panel, "Table View");
	}
	
	public JPanel getButtonPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;

		constraints = new GridBagConstraints();
		btnPrint = new CButton("Print");
		btnPrint.setMnemonic('S');
		btnPrint.setActionCommand(PRINT);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 2;
		constraints.gridy = 0;
		panel.add(btnPrint, constraints);
		btnPrint.addActionListener(controller);

		constraints = new GridBagConstraints();
		btnClear = new CButton("Clear");
		btnClear.setMnemonic('L');
		btnClear.setActionCommand(CLEAR);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 2;
		constraints.gridy = 1;
		panel.add(btnClear, constraints);
		btnClear.addActionListener(controller);

		constraints = new GridBagConstraints();
		btnCancel = new CButton("Cancel");
		btnCancel.setMnemonic('C');
		btnCancel.setActionCommand(CANCEL);
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 2;
		constraints.gridy = 2;
		panel.add(btnCancel, constraints);
		btnCancel.addActionListener(controller);
		
		return panel;
	}
	
	
	public JPanel getTablePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		tblSearchResult = new JTable(tableModel);
		tblSearchResult.setRowHeight(20);
		tblSearchResult.setFillsViewportHeight(true);
		tblSearchResult.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(tblSearchResult);
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

}
