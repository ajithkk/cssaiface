/**
 * 
 */
package org.cssa.iface.gui.student;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import org.cssa.iface.gui.controls.CLabel;
import org.cssa.iface.gui.controls.CTextField;

/**
 * @author ajith
 *
 */
public class StudentDetailsView {
	
	public static final String[] GENDER = {"Male", "Female"};
	
	private CLabel lblStudentId;
	private CLabel lblCollegeId;
	private CLabel lblStudentName;
	private CLabel lblGender;
	private CLabel lblPhone;
	private CLabel lblAccommodation;
	
	private CTextField txtStudentId;
	private CTextField txtCollegeId;
	private CTextField txtStudentName;
	private CTextField txtPhone;
	
	private JComboBox cbGender;
	private JCheckBox ckAccommodation;
	private JTable eventTable;
	
	
	public  JPanel getStudentDetailsPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		
		lblStudentId = new CLabel("Studen Id:");
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(3, 0, 2, 2);
		panel.add(lblStudentId,constraints);
		
		txtStudentId = new CTextField();
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.insets = new Insets(3, 2, 2, 0);
		panel.add(txtStudentId, constraints);
		
		lblCollegeId = new CLabel("College Id:");
		constraints = new GridBagConstraints();
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(3, 6, 2, 2);
		panel.add(lblCollegeId, constraints);
		
		txtCollegeId = new CTextField();
		constraints = new GridBagConstraints();
		constraints.gridx = 3;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(3, 2, 3, 0);
		panel.add(txtCollegeId, constraints);
		
		lblStudentName = new CLabel("Student Name:");
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(2, 0, 2, 2);
		panel.add(lblStudentName, constraints);
		
		txtStudentName = new CTextField();
		constraints = new GridBagConstraints();
		txtStudentName.setPreferredSize(new Dimension(390,20));
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 3;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(2, 3, 3, 0);
		panel.add(txtStudentName, constraints);
		
		lblPhone = new CLabel("Phone:");
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(2, 3, 3, 2);
		panel.add(lblPhone, constraints);
		
		txtPhone = new CTextField();
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(2, 2, 2, 2);
		panel.add(txtPhone, constraints);
		
		lblGender = new CLabel("Gender:");
		constraints = new GridBagConstraints();
		constraints.gridx = 2;
		constraints.gridy = 2;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(2, 3, 3, 2);
		panel.add(lblGender, constraints);
		
		cbGender = new JComboBox(GENDER);
		constraints = new GridBagConstraints();
		constraints.gridx = 3;
		constraints.gridy = 2;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(2, 3, 3, 0);
		panel.add(cbGender, constraints);
		
		ckAccommodation = new JCheckBox("Accommodation");
		constraints = new GridBagConstraints();
		constraints.gridx = 3;
		constraints.gridy = 2;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(2, 3, 3, 0);
		panel.add(ckAccommodation, constraints);
		
		return panel;
		
	}
	
	
	public JPanel getTablePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		
		
		return panel;
	}
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.add(new StudentDetailsView().getStudentDetailsPanel(), BorderLayout.NORTH );
		frame.setSize(new Dimension(400, 200));
		frame.setVisible(true);
	}
	
	
}
