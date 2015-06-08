/**
 * 
 */
package org.cssa.iface.gui.timesheet;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.controls.CButton;
import org.cssa.iface.gui.controls.CLabel;

/**
 * @author ajith
 *
 */
public class SelectDateDialog {
	
	public static final String GO = "Go";
	private CLabel lbldate;
	private JComboBox cmbSelectDate;
	private JButton btnGo;
	private CssaMDIForm mdiForm;
	private SelectDateDialogController controller;
	
	
	
	/**
	 * @param mdiForm
	 * @param controller
	 */
	public SelectDateDialog(CssaMDIForm mdiForm,
			SelectDateDialogController controller) {
		super();
		this.mdiForm = mdiForm;
		this.controller = controller;
	}
	
	public void showDateDialog() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(getDialogBody(), BorderLayout.CENTER);
		mdiForm.addChild(panel, "Date dialog",new Dimension(770, 300));
	}
	
	public JPanel getDialogBody() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints;
		
		lbldate = new CLabel("Select Date");
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 5, 5, 5);
		panel.add(lbldate,constraints);
		
		cmbSelectDate = new JComboBox();
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 0, 5, 2);
		cmbSelectDate.setPreferredSize(new Dimension(250, 23));
		panel.add(cmbSelectDate, constraints);
		
		constraints = new GridBagConstraints();
		btnGo = new CButton("GO");
		btnGo.setMnemonic('G');
		btnGo.setActionCommand(GO);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 2;
		constraints.gridy = 0;
		panel.add(btnGo, constraints);
		btnGo.addActionListener(controller);
		
		return panel;
		
		
	}
	/**
	 * @return the cmbSelectDate
	 */
	public JComboBox getCmbSelectDate() {
		return cmbSelectDate;
	}
	/**
	 * @param cmbSelectDate the cmbSelectDate to set
	 */
	public void setCmbSelectDate(JComboBox cmbSelectDate) {
		this.cmbSelectDate = cmbSelectDate;
	}
	

}
