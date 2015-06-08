/**
 * 
 */
package org.cssa.iface.gui.events;

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
import org.cssa.iface.gui.controls.CLabel;
import org.cssa.iface.gui.controls.CTextField;

/**
 * @author ajith
 * @since 1/27/2012
 */
public class EventsView {

	public static final String SAVE = "Save";
	public static final String PRINT = "Print";
	public static final String EDIT = "Edit";
	public static final String CANCEL = "Cancel";
	public static final String CLEAR = "clear";
	public static final String DELETE = "Delete";

	private CLabel lblEventName;
	private CLabel lblEventCode;
	private CLabel lblMaxParticipants;
	private CLabel lblPoints;

	private CTextField txtEventName;
	private CTextField txtEventcode;
	private CTextField txtMaxParticipants;
	private CTextField txtPoints;

	private CButton btnSave;
	private CButton btnEdit;
	private CButton btnClear;
	private CButton btnCancel;
	private CButton btnPrint;
	private CButton btnDelete;

	private JTable eventTable;

	private EventsController eventsController;
	private EventTableModel tableModel;
	
	private CssaMDIForm mdiForm;

	/**
	 * @param eventsController
	 */
	public EventsView(EventsController eventsController,
			EventTableModel tableModel) {
		super();
		this.eventsController = eventsController;
		this.tableModel = new EventTableModel();
	}

	public EventsView() {
		this.tableModel = new EventTableModel();
	}

	public EventsView(EventsController eventsController,
			EventTableModel eventTableModel, CssaMDIForm mdiForm) {
			this.eventsController = eventsController;
			this.tableModel = eventTableModel;
			this.mdiForm = mdiForm;
	}

	public void showEventscreen() {
		JPanel tabbedPane = new JPanel();
		tabbedPane.add(getEventDetailsBody(), BorderLayout.CENTER);
		mdiForm.addChild(tabbedPane, "Event Details");
	}

	public JPanel getEventDetailsPanel() {
		JPanel body = new JPanel();
		body.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;

		lblEventName = new CLabel("Event Name:");
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(5, 5, 5, 5);
		body.add(lblEventName, constraints);

		txtEventName = new CTextField();
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.insets = new Insets(3, 5, 3, 5);
		body.add(txtEventName, constraints);

		lblEventCode = new CLabel("Code Name:");
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.insets = new Insets(5, 5, 5, 5);
		body.add(lblEventCode, constraints);

		txtEventcode = new CTextField();
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.insets = new Insets(3, 5, 3, 5);
		body.add(txtEventcode, constraints);

		lblMaxParticipants = new CLabel("No Of Participants:");
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.insets = new Insets(5, 5, 5, 5);
		body.add(lblMaxParticipants, constraints);

		txtMaxParticipants = new CTextField();
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.insets = new Insets(3, 5, 3, 5);
		body.add(txtMaxParticipants, constraints);

		lblPoints = new CLabel("Point:");
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.insets = new Insets(5, 5, 5, 5);
		body.add(lblPoints, constraints);

		txtPoints = new CTextField();
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.insets = new Insets(3, 5, 5, 5);
		body.add(txtPoints, constraints);

		return body;
	}

	public JPanel getEvetMiddleButtonPanel() {

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
		btnSave.addActionListener(eventsController);

		constraints = new GridBagConstraints();
		btnClear = new CButton("Clear");
		btnClear.setMnemonic('L');
		btnClear.setActionCommand(CLEAR);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 3;
		constraints.gridy = 0;
		panel.add(btnClear, constraints);
		btnClear.addActionListener(eventsController);

		constraints = new GridBagConstraints();
		btnCancel = new CButton("Cancel");
		btnCancel.setMnemonic('C');
		btnCancel.setActionCommand(CANCEL);
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 4;
		constraints.gridy = 0;
		panel.add(btnCancel, constraints);
		btnCancel.addActionListener(eventsController);
		
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
		btnEdit.addActionListener(eventsController);

		constraints = new GridBagConstraints();
		btnDelete = new CButton("Delete");
		btnDelete.setMnemonic('D');
		btnDelete.setActionCommand(DELETE);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 1;
		panel.add(btnDelete, constraints);
		btnDelete.addActionListener(eventsController);

		constraints = new GridBagConstraints();
		btnPrint = new CButton("Print");
		btnPrint.setMnemonic('P');
		btnPrint.setActionCommand(PRINT);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 2;
		panel.add(btnPrint, constraints);
		btnPrint.addActionListener(eventsController);
		
		return panel;
	}

	public JPanel getTablePannel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		eventTable = new JTable(tableModel);
		eventTable.setAutoCreateRowSorter(true);
		eventTable.setRowHeight(20);
		JScrollPane scrollPane = new JScrollPane(eventTable);
		scrollPane.setMinimumSize(new Dimension(600, 400));
		scrollPane.setMaximumSize(new Dimension(600, 400));
		scrollPane.setPreferredSize(new Dimension(600, 400));
		panel.add(scrollPane, BorderLayout.CENTER);

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
		panel.add(getEventDetailsPanel(), constraints);

		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 6;
		constraints.insets = new Insets(10, 0, 10, 0);
		constraints.anchor = GridBagConstraints.CENTER;
		panel.add(getEvetMiddleButtonPanel(), constraints);
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

	public JPanel getEventDetailsBody() {
		
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

	public String getEventName() {
		return txtEventName.getText();
	}

	public String getEventCode() {
		return txtEventcode.getText();
	}

	public String getMaxParticipants() {
		return txtMaxParticipants.getText();
	}

	public String getPoints() {
		return txtPoints.getText();
	}

	public void setEventName(String eventName) {
		txtEventName.setText(eventName);
	}

	public void setEventCode(String eventCode) {
		txtEventcode.setText(eventCode);
	}

	public void setMaxParticipants(String maxParticipants) {
		txtMaxParticipants.setText(maxParticipants);
	}

	public void setPoints(String point) {
		txtPoints.setText(point);
	}

	public JTable getEventTable() {
		return eventTable;
	}

	public void setEventTable(JTable eventTable) {
		this.eventTable = eventTable;
	}

	/**
	 * @return the txtMaxParticipants
	 */
	public CTextField getTxtMaxParticipants() {
		return txtMaxParticipants;
	}

	/**
	 * @param txtMaxParticipants the txtMaxParticipants to set
	 */
	public void setTxtMaxParticipants(CTextField txtMaxParticipants) {
		this.txtMaxParticipants = txtMaxParticipants;
	}

	/**
	 * @return the txtPoints
	 */
	public CTextField getTxtPoints() {
		return txtPoints;
	}

	/**
	 * @param txtPoints the txtPoints to set
	 */
	public void setTxtPoints(CTextField txtPoints) {
		this.txtPoints = txtPoints;
	}

	/**
	 * @return the txtEventcode
	 */
	public CTextField getTxtEventcode() {
		return txtEventcode;
	}

	/**
	 * @param txtEventcode the txtEventcode to set
	 */
	public void setTxtEventcode(CTextField txtEventcode) {
		this.txtEventcode = txtEventcode;
	}
	
	
}
