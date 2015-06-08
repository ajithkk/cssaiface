/**
 * 
 */
package org.cssa.iface.gui.database;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.controls.CButton;

/**
 * @author ajith
 *
 */
public class DatabaseAdministrationView {
	
	public static final String PRINT = "Print";
	public static final String CANCEL = "Cancel";
	public static final String CLEAR = "Clear";
	public static final String DELETE = "Delete";
	
	
	private DatabaseAdministrationController controller;
	private CssaMDIForm mdiForm;
	private TableTreeModel tableTreeModel;
	private TableModel tableModel;
	
	private JTree jTree;
	private JTable tblSearchResult;
	
	private CButton btnPrint;
	private CButton btnCancel;
	private CButton btnClear;
	private CButton btnDelete;
	
	/**
	 * @param controller
	 * @param mdiForm
	 */
	public DatabaseAdministrationView(
			DatabaseAdministrationController controller, CssaMDIForm mdiForm, TableTreeModel  tableTreeModel,TableModel tableModel) {
		this.controller = controller;
		this.mdiForm = mdiForm;
		this.tableTreeModel =tableTreeModel;
		this.tableModel = tableModel;
	}
	public void showSearchResultScreen() {
		JPanel panel = new JPanel();
		panel.add(databaseAdministrationPanel() ,BorderLayout.WEST);
		mdiForm.addChild(panel, "Database Administration");
	}
	

	public JPanel getTreePanel() {
		JPanel panel = new JPanel();
		jTree = new JTree(tableTreeModel);
		jTree.addTreeExpansionListener(controller);
		jTree.addTreeSelectionListener(controller);
		
		JScrollPane scrollPane = new JScrollPane(jTree);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int w = 200;
		Dimension hh = mdiForm.getContentPane().getSize();
		int he = hh.height - 60;
		scrollPane.setMinimumSize(new Dimension(w, he));
		scrollPane.setMaximumSize(new Dimension(w, he));
		scrollPane.setPreferredSize(new Dimension(w, he));
		panel.add(scrollPane, BorderLayout.CENTER);
		return panel;
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
		btnDelete = new CButton(DELETE);
		btnDelete.setMnemonic('X');
		btnDelete.setActionCommand(DELETE);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 2;
		constraints.gridy = 2;
		panel.add(btnDelete, constraints);
		btnDelete.addActionListener(controller);

		constraints = new GridBagConstraints();
		btnCancel = new CButton("Cancel");
		btnCancel.setMnemonic('C');
		btnCancel.setActionCommand(CANCEL);
		//constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 2;
		constraints.gridy = 3;
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
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int w = d.width - 400;
		Dimension hh = mdiForm.getContentPane().getSize();
		int he = hh.height - 60;
		scrollPane.setMinimumSize(new Dimension(w, he));
		scrollPane.setMaximumSize(new Dimension(w, he));
		scrollPane.setPreferredSize(new Dimension(w, he));
		
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
	
	public JPanel databaseAdministrationPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(getTreePanel(), BorderLayout.LINE_START);
		panel.add(searchPannel(),BorderLayout.CENTER);
		return panel;
		
	}


	/**
	 * @return the jTree
	 */
	public JTree getjTree() {
		return jTree;
	}

	/**
	 * @param jTree the jTree to set
	 */
	public void setjTree(JTree jTree) {
		this.jTree = jTree;
	}
	/**
	 * @return the tblSearchResult
	 */
	public JTable getTblSearchResult() {
		return tblSearchResult;
	}
	/**
	 * @param tblSearchResult the tblSearchResult to set
	 */
	public void setTblSearchResult(JTable tblSearchResult) {
		this.tblSearchResult = tblSearchResult;
	}
	
	
	
	
	

}
