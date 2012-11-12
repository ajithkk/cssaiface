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

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.controls.CButton;
import org.cssa.iface.gui.controls.CLabel;
import org.cssa.iface.gui.controls.CTextField;
import org.cssa.iface.util.ImageUtil;
/**
 * @author Ajith
 *
 */
public class ParticipantLookupView {

	public static final String CANCEL = "Cancel";
	public static final String CLEAR = "Clear";
	public static final String SEARCH = "Search";
	public static final String SAVE = "Save";
	public static final String STUDENT_SEARCH = "student_search";
	public static final String PRINT = "Print";
	
	private CLabel lblEventCode;
	private CLabel lblEventStage;
	private CLabel lblCollegeId;
	private CLabel lblStudentId;
	
	private CButton btnSearch;
	private CButton btnClear;
	private CButton btnCancel;
	private CButton btnPrint;
	
	private JComboBox cmbEventCode;
	private JComboBox cmbEventStage;
	private CTextField txtCollegeId;
	private CTextField txtStudentId;
	private JTable tblParticipants;
	
	private CssaMDIForm mdiForm;
	private ParticipantLookupController controller;
	private ParticipantLookupTableModel tableModel;
	private CButton btnStudentSearch;
	
	/**
	 * @param mdiForm
	 * @param controller
	 * @param tableModel
	 */
	public ParticipantLookupView(CssaMDIForm mdiForm,
			ParticipantLookupController controller, ParticipantLookupTableModel tableModel) {
		this.mdiForm = mdiForm;
		this.controller = controller;
		this.tableModel = tableModel;
	}
	public void showLookupView() {
		JPanel tabbedPane = new JPanel();
		tabbedPane.add(getResultDetailsBody(), BorderLayout.CENTER);
		mdiForm.addChild(tabbedPane, " Result Lookup");
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
		
		lblCollegeId = new CLabel("College Id: ");
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 5, 0, 2);
		panel.add(lblCollegeId, constraints);
		
		txtCollegeId = new CTextField();
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 5;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 0, 5, 2);
		panel.add(txtCollegeId, constraints);
		
		lblStudentId = new CLabel("Student Id: ");
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 5, 0, 2);
		panel.add(lblStudentId, constraints);
		
		txtStudentId = new CTextField();
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 6;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 0, 5, 2);
		panel.add(txtStudentId, constraints);
		
		ImageIcon icon = new ImageIcon(new ImageUtil().getImage("search.gif"));
		btnStudentSearch = new CButton(icon);
		btnStudentSearch.setPreferredSize(new Dimension(40, 23));
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 2;
		constraints.gridy = 6;
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
		
		constraints = new GridBagConstraints();
		btnPrint = new CButton("Print");
		btnPrint.setMnemonic('P');
		btnPrint.setActionCommand(PRINT);
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 5;
		constraints.gridy = 0;
		panel.add(btnPrint, constraints);
		btnPrint.addActionListener(controller);
		
		
		return panel;
	}
	
	
	public JPanel getTablePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		tblParticipants = new JTable(tableModel);
		tblParticipants.addMouseListener(controller);
		tblParticipants.setRowHeight(20);
		tblParticipants.setFillsViewportHeight(true);
		tblParticipants.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(tblParticipants);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int w = d.width - 50;
		Dimension hh = mdiForm.getContentPane().getSize();
		int he = hh.height - 260;
		scrollPane.setMinimumSize(new Dimension(w, he));
		scrollPane.setMaximumSize(new Dimension(w, he));
		scrollPane.setPreferredSize(new Dimension(w, he));
		panel.add(scrollPane, BorderLayout.CENTER);
		//tblParticipants.addMouseListener(controller);
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

	public JPanel getResultDetailsBody() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints;
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.insets = new Insets(10, 5, 0, 10);
		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(getTopPannel(), constraints);

		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(0, 5, 5, 5);
		panel.add(getTablePanel(), constraints);

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
	
	
		
	
}
