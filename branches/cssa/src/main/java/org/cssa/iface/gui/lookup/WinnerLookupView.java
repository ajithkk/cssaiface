/**
 * 
 */
package org.cssa.iface.gui.lookup;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.controls.CButton;
import org.cssa.iface.gui.controls.CLabel;

/**
 * @author admin
 *
 */
public class WinnerLookupView {
	public static final String CANCEL = "Cancel";
	public static final String SAVE = "Save";
	public static final String SEARCH = "Search";
	public static final String PRINT = "Print";
	public static final String DELETE = "Delete";
	
	private CLabel lblEventId;
	private CLabel lblWinnerPosition;
	
	private CButton btnSearch;
	private CButton btnSave;
	private CButton btnCancel;
	private CButton btnPrint;
	private CButton btnDelete;
	
	private JComboBox eventId;
	private JComboBox winnerPosition;
	
	private JTable tblStudentDetails;
	
	private WinnerLookupController controller;
	private WinnerLookupTableModel tableModel;
	private CssaMDIForm mdiForm;
	
	
	/**
	 * @param controller
	 * @param tableModel
	 * @param mdiForm
	 */
	public WinnerLookupView(WinnerLookupController controller,
			WinnerLookupTableModel tableModel, CssaMDIForm mdiForm) {
		super();
		this.controller = controller;
		this.tableModel = tableModel;
		this.mdiForm = mdiForm;
	}
	public void showWinnerLookup() {
		JPanel panel = new JPanel();
		panel.add(getStudentLookupDetailsBody(), BorderLayout.CENTER);
		mdiForm.addChild(panel, "Winner Lookup Form");
		
	}
	
	private JPanel getMianPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		
		lblEventId = new CLabel("Event Id:");
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(10, 5, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(lblEventId,constraints);
		
		eventId = new JComboBox();
		eventId.setMaximumSize(new Dimension(250, 24));
		eventId.setMinimumSize(new Dimension(250, 24));
		eventId.setPreferredSize(new Dimension(250, 24));
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 0;
		panel.add(eventId, constraints);
		
		lblWinnerPosition = new CLabel("Winning Position");
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		panel.add(lblWinnerPosition,constraints);
		
		winnerPosition =  new JComboBox();
		winnerPosition.setMaximumSize(new Dimension(250, 24));
		winnerPosition.setMinimumSize(new Dimension(250, 24));
		winnerPosition.setPreferredSize(new Dimension(250, 24));
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 1;
		panel.add(winnerPosition, constraints);
		
		return panel;
	}
	
	
	private  JPanel getButtonPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		
		constraints = new GridBagConstraints();
		btnPrint = new CButton("Print");
		btnPrint.setMnemonic('P');
		btnPrint.setActionCommand(PRINT);
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 2;
		constraints.gridy = 0;
		panel.add(btnPrint, constraints);
		btnPrint.addActionListener(controller);
		

		constraints = new GridBagConstraints();
		btnSearch = new CButton("Search");
		btnSearch.setMnemonic('S');
		btnSearch.setActionCommand(SEARCH);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 3;
		constraints.gridy = 0;
		panel.add(btnSearch, constraints);
		btnSearch.addActionListener(controller);

		

		constraints = new GridBagConstraints();
		btnCancel = new CButton("Cancel");
		btnCancel.setMnemonic('C');
		btnCancel.setActionCommand(CANCEL);
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 4;
		constraints.gridy = 0;
		panel.add(btnCancel, constraints);
		btnCancel.addActionListener(controller);
		
		/*constraints = new GridBagConstraints();
		btnSave = new CButton(SAVE);
		btnSave.setMnemonic('L');
		btnSave.setActionCommand(SAVE);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 5;
		constraints.gridy = 0;
		panel.add(btnSave, constraints);
		btnSave.addActionListener(controller);*/
		
		
		constraints = new GridBagConstraints();
		btnDelete = new CButton(DELETE);
		btnDelete.setMnemonic('X');
		btnDelete.setActionCommand(DELETE);
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 5;
		constraints.gridy = 0;
		panel.add(btnDelete, constraints);
		btnDelete.addActionListener(controller);
		
		
		return panel;
	}
	
	
	private  JPanel getTablePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		tblStudentDetails = new JTable(tableModel);
		tblStudentDetails.setFillsViewportHeight(true);
		tblStudentDetails.setRowHeight(20);
		tblStudentDetails.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(tblStudentDetails);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = d.width - 50;
		Dimension hh = mdiForm.getContentPane().getSize();
		int he = hh.height - 168;
		scrollPane.setMinimumSize(new Dimension(width, he));
		scrollPane.setMaximumSize(new Dimension(width, he));
		scrollPane.setPreferredSize(new Dimension(width, he));
		panel.add(scrollPane, BorderLayout.CENTER);
		tblStudentDetails.addMouseListener(controller);

		return panel;
	}
	public JPanel getTopPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 0, 0, 0);
		constraints.gridx = 1;
		constraints.gridy = 5;
		constraints.anchor = GridBagConstraints.CENTER;
		panel.add(getMianPanel(), constraints);

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
	 * @return the eventId
	 */
	public JComboBox getEventId() {
		return eventId;
	}
	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(JComboBox eventId) {
		this.eventId = eventId;
	}
	/**
	 * @return the winnerPosition
	 */
	public JComboBox getWinnerPosition() {
		return winnerPosition;
	}
	/**
	 * @param winnerPosition the winnerPosition to set
	 */
	public void setWinnerPosition(JComboBox winnerPosition) {
		this.winnerPosition = winnerPosition;
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
	
	/**
	 * @return the btnClear
	 */
	public CButton getBtnSave() {
		return btnSave;
	}
	/**
	 * @param btnClear the btnClear to set
	 */
	public void setBtnSave(CButton btnSave) {
		this.btnSave = btnSave;
	}
	/**
	 * @return the btnPrint
	 */
	public CButton getBtnPrint() {
		return btnPrint;
	}
	/**
	 * @param btnPrint the btnPrint to set
	 */
	public void setBtnPrint(CButton btnPrint) {
		this.btnPrint = btnPrint;
	}
	/**
	 * @return the btnDelete
	 */
	public CButton getBtnDelete() {
		return btnDelete;
	}
	/**
	 * @param btnDelete the btnDelete to set
	 */
	public void setBtnDelete(CButton btnDelete) {
		this.btnDelete = btnDelete;
	}
	

}
