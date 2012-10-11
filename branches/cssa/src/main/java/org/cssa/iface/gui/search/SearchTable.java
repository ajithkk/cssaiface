/**
 * 
 */
package org.cssa.iface.gui.search;

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
public class SearchTable {
	
	public static final String SEARCH = "Search";
	public static final String CLEAR = "Clear";
	public static final String CANCEL = "Cancel";
	private JTable table;
	private CButton btnSearch;
	private CButton btnCancel;
	private CButton btnClear;
	
	private CssaMDIForm mdiForm;
	private SearchTableController controller;
	private SearchTableModel tableModel;
	
	public SearchTable(CssaMDIForm mdiForm, SearchTableController controller, SearchTableModel tableModel) {
		this.mdiForm = mdiForm;
		this.controller = controller;
		this.tableModel = tableModel;
	
	}
	
	public void showSearchTable() {
		JPanel panel = new JPanel();
		panel.add(searchPannel(),BorderLayout.CENTER);
		mdiForm.addChild(panel, "Event Based search",new Dimension(770, 300));
	}
	
	public JPanel getButtonPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;

		constraints = new GridBagConstraints();
		btnSearch = new CButton("Search");
		btnSearch.setMnemonic('S');
		btnSearch.setActionCommand(SEARCH);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 2;
		constraints.gridy = 0;
		panel.add(btnSearch, constraints);
		btnSearch.addActionListener(controller);

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
		
		table = new JTable(tableModel);
		table.setRowHeight(20);
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setMinimumSize(new Dimension(600, 250));
		scrollPane.setMaximumSize(new Dimension(600, 250));
		scrollPane.setPreferredSize(new Dimension(600, 250));
		panel.add(scrollPane, BorderLayout.CENTER);
		return panel;
	}
	
	public JPanel searchPannel() {
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
		panel.add(getButtonPanel(), constraints);

		return panel;
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(JTable table) {
		this.table = table;
	}
	
	

}
