/**
 * 
 */
package org.cssa.iface.gui.college;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

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
		txtCollegeName.setColumns(40);
		txtCollegeName.setLineWrap(true);
		//txtCollegeName.setPreferredSize(new Dimension(430,20));
		JScrollPane scrollPane = new JScrollPane(txtCollegeName);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.gridwidth = 3;
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
		txtCollegeAddress.setColumns(40);
		txtCollegeAddress.setLineWrap(true);
		//txtCollegeName.setPreferredSize(new Dimension(430,20));
	    scrollPane = new JScrollPane(txtCollegeAddress);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.gridwidth = 3;
		panel.add(scrollPane,constraints);
		
		constraints = new GridBagConstraints();
		lblCollegePhone = new CLabel("Condact Number:");
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
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				
				try {
				      //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				      for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels())
				        if ("Nimbus".equals(laf.getName())) UIManager.setLookAndFeel(laf.getClassName());
				    } catch(Exception e) {
				      e.printStackTrace();
				    }
				JFrame frame = new JFrame();
				/*try {
		            // Set System L&F
		        UIManager.setLookAndFeel(
		            UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (UnsupportedLookAndFeelException e) {
		       // handle exception
		    }
		    catch (ClassNotFoundException e) {
		       // handle exception
		    }
		    catch (InstantiationException e) {
		       // handle exception
		    }
		    catch (IllegalAccessException e) {
		       // handle exception
		    }*/

				frame.setLayout(new GridBagLayout());
				GridBagConstraints constraints = new GridBagConstraints();
				constraints.gridx = 0;
				constraints.gridy = 0;
				//constraints.anchor = GridBagConstraints.NORTHWEST;
				// frame.add(new Event().init(),BorderLayout.NORTH);
				frame.add(new CollegeDetilsView().getCollegeDetailsPanel(),
						constraints);
				// frame.add(new Event().getBottamPanel(), BorderLayout.CENTER);
				// frame.add(new Event().getSideButtonPanel(), BorderLayout.)
				//frame.pack();
				 constraints = new GridBagConstraints();
				constraints.gridx = 0;
				constraints.gridy = 2;
				//constraints.anchor = GridBagConstraints.NORTHWEST;
				//frame.add(new CollegeDetilsView().getMainDetailsPanel(),
						//constraints);
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.setSize(800, 400);
				frame.setVisible(true);
			}
		});
	}

}
