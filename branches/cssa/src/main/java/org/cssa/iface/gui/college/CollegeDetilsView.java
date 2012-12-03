/**
 * 
 */
package org.cssa.iface.gui.college;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.controls.CButton;
import org.cssa.iface.gui.controls.CLabel;
import org.cssa.iface.gui.controls.CTextField;

/**
 * @author ajith
 *
 */
public class CollegeDetilsView {
	
	public static final String SAVE = "Save";
	public static final String CANCEL = "Cancel";
	public static final String CLEAR = "Clear";
	
	private CLabel lblCollegeId;
	private CLabel lblCollegeName;
	private CLabel lblCollegeAddress;
	private CLabel lblCollegePhone;
	private CLabel lblNoOfParticipatnts;
	

	private CTextField txtCollegeId;
	private CTextField txtNoOfParticipants;
	private JTextArea txtCollegeName;
	private CTextField txtCollegePhone;
	private JTextArea txtCollegeAddress;
	
	private CButton btnSave;
	private CButton btnCancel;
	private CButton btnClear;
	private JCheckBox status;
	
	private CssaMDIForm mdiForm;
	private CollegeDetailsController collegeDetailsController;
	
	public CollegeDetilsView(CollegeDetailsController collegeDetailsController,
			CssaMDIForm mdiForm) {
		this.collegeDetailsController = collegeDetailsController;
		this.mdiForm = mdiForm;

	}
	
	public void showCollegeDetailsView() {
		JPanel panel = new JPanel();
		panel.add(getCollegeDetailsPanel(),BorderLayout.CENTER);
		mdiForm.addChild(panel, "College Details Form");
	}

	public   JPanel getMainDetailsPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		
		constraints = new GridBagConstraints();
		lblCollegeId = new CLabel("College Id:");
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(lblCollegeId, constraints);
		
		constraints = new GridBagConstraints();
		txtCollegeId = new CTextField();
		txtCollegeId.setEditable(false);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 0;
		panel.add(txtCollegeId, constraints);
		
		constraints = new GridBagConstraints();
		lblNoOfParticipatnts = new CLabel("No Of Participants:");
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 2;
		constraints.gridy = 0;
		panel.add(lblNoOfParticipatnts,constraints);
		
		constraints = new GridBagConstraints();
		txtNoOfParticipants = new CTextField();
		txtNoOfParticipants.setPreferredSize(new Dimension(90,23));
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 3;
		constraints.gridy = 0;
		txtNoOfParticipants.setEditable(false);
		panel.add(txtNoOfParticipants, constraints);
		
		constraints = new GridBagConstraints();
		lblCollegeName = new CLabel("College Name:");
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 3;
		panel.add(lblCollegeName, constraints);
		
		constraints = new GridBagConstraints();
		txtCollegeName = new JTextArea();
		txtCollegeName.setRows(2);
		txtCollegeName.setColumns(55);
		txtCollegeName.setLineWrap(true);
		//txtCollegeName.setPreferredSize(new Dimension(830,20));
		JScrollPane scrollPane = new JScrollPane(txtCollegeName);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.gridwidth = 3;
		constraints.insets = new Insets(5, 0, 5, 5);
		panel.add(scrollPane,constraints);
		
		constraints = new GridBagConstraints();
		lblCollegeAddress = new CLabel("College Address:");
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 4;
		panel.add(lblCollegeAddress, constraints);
		
		constraints = new GridBagConstraints();
		txtCollegeAddress = new JTextArea();
		txtCollegeAddress.setRows(5);
		txtCollegeAddress.setColumns(55);
		txtCollegeAddress.setLineWrap(true);
		//txtCollegeName.setPreferredSize(new Dimension(830,20));
	    scrollPane = new JScrollPane(txtCollegeAddress);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.gridwidth = 3;
		constraints.insets = new Insets(5, 0, 5, 5);
		panel.add(scrollPane,constraints);
		
		constraints = new GridBagConstraints();
		lblCollegePhone = new CLabel("contact Number:");
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 5;
		panel.add(lblCollegePhone, constraints);
		
		constraints = new GridBagConstraints();
		txtCollegePhone = new CTextField();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 5;
		constraints.insets = new Insets(5, 0, 5, 5);
		panel.add(txtCollegePhone, constraints);
		
		constraints = new GridBagConstraints();
		status = new JCheckBox("Status");
		status.setSelected(true);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 2;
		constraints.gridy = 5;
		panel.add(status,constraints);
		
		return panel;
	}
	
	private JPanel getMiddleButtonPanel() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		
		constraints = new GridBagConstraints();
		btnSave = new CButton("Save");
		btnSave.setMnemonic('S');
		btnSave.setActionCommand(SAVE);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx =3;
		constraints.gridy = 0;
		panel.add(btnSave, constraints);
		
		constraints = new GridBagConstraints();
		btnClear = new CButton("Clear");
		btnClear.setMnemonic('L');
		btnClear.setActionCommand(CLEAR);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 4;
		constraints.gridy = 0;
		panel.add(btnClear,constraints);
		
		constraints = new GridBagConstraints();
		btnCancel = new CButton("Cancel");
		btnCancel.setMnemonic('C');
		btnCancel.setActionCommand(CANCEL);
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 5;
		constraints.gridy = 0;
		panel.add(btnCancel,constraints);
		
		btnCancel.addActionListener(collegeDetailsController);
		btnClear.addActionListener(collegeDetailsController);
		btnSave.addActionListener(collegeDetailsController);
		
		
		return panel;
	}
	
	public JPanel getCollegeDetailsPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 0, 0, 0);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.NORTH;
		panel.add(getMainDetailsPanel(), constraints);

		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.insets = new Insets(10, 60, 10, 0);
		constraints.anchor = GridBagConstraints.CENTER;
		panel.add(getMiddleButtonPanel(), constraints);
		return panel;
	}

	/**
	 * @return the txtCollegeId
	 */
	public String  getTxtCollegeId() {
		return txtCollegeId.getText();
	}

	/**
	 * @param txtCollegeId the txtCollegeId to set
	 */
	public void setTxtCollegeId(String txtCollegeId) {
		this.txtCollegeId.setText(txtCollegeId);
	}

	/**
	 * @return the txtNoOfParticipants
	 */
	public String getTxtNoOfParticipants() {
		return txtNoOfParticipants.getText();
	}

	/**
	 * @param txtNoOfParticipants the txtNoOfParticipants to set
	 */
	public void setTxtNoOfParticipants(String  txtNoOfParticipants) {
		this.txtNoOfParticipants.setText(txtNoOfParticipants);
	}

	/**
	 * @return the txtCollegeName
	 */
	public String getTxtCollegeName() {
		return txtCollegeName.getText();
	}

	/**
	 * @param txtCollegeName the txtCollegeName to set
	 */
	public void setTxtCollegeName(String txtCollegeName) {
		this.txtCollegeName.setText(txtCollegeName);
	}

	/**
	 * @return the txtCollegePhone
	 */
	public String  getTxtCollegePhone() {
		return txtCollegePhone.getText();
	}

	/**
	 * @param txtCollegePhone the txtCollegePhone to set
	 */
	public void setTxtCollegePhone(String txtCollegePhone) {
		this.txtCollegePhone.setText(txtCollegePhone);
	}

	/**
	 * @return the txtCollegeAddress
	 */
	public String getTxtCollegeAddress() {
		return txtCollegeAddress.getText();
	}

	/**
	 * @param txtCollegeAddress the txtCollegeAddress to set
	 */
	public void setTxtCollegeAddress(String txtCollegeAddress) {
		this.txtCollegeAddress.setText(txtCollegeAddress);
	}
	
	/**
	 * 
	 * @return status
	 */
	public boolean getStatus() {
		return status.isSelected();
	}
	
	/**
	 * 
	 * @param status
	 */
	public void setStatus(boolean status) {
		this.status.setSelected(status);
	}
}
