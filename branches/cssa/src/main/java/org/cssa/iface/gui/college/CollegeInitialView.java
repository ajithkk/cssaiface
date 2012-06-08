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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.controls.CButton;
import org.cssa.iface.gui.controls.CLabel;
import org.cssa.iface.gui.controls.CTextField;
import org.cssa.iface.gui.events.EventsView;

/**
 * 
 * @author ajith
 * @since 2/6/2012
 */

public class CollegeInitialView {
	
	public static final String INSERT = "Insert";
	public static final String CANCEL = "Cancel";
	public static final String CLEAR = "Clear";
	public static final String PRINT = "Print";
	
	private CLabel lblCollegeId;
	private CLabel lblCollegeName;
	private CLabel lblNoOfParticipants;
	private CLabel lblCollegePhone;
	
	private CTextField txtCollegeId;
	private CTextField txtNoOfParticipants;
	private JTextArea txtCollegeName;
	private CTextField txtCollegePhone;
	
	private CButton btnInsert;
	private CButton btnCancel;
	private CButton btnClear;
	private CButton btnPrint;
	
	private JTable tblStudentDetails;
	
	private CollegeInitialViewController controller;
	private CollegeInitialTableModel tableModel;
	private CssaMDIForm mdiForm;

	/**
	 * @param controller
	 */
	public CollegeInitialView(CollegeInitialViewController controller, CollegeInitialTableModel tableModel) {
		super();
		this.controller = controller;
		this.tableModel = tableModel;
	}
	public CollegeInitialView() {
		// TODO Auto-generated constructor stub
	}
	
	public CollegeInitialView(CollegeInitialViewController collegeInitialViewController, CollegeInitialTableModel tableModel, CssaMDIForm mdiForm) {
		
		this.controller =collegeInitialViewController;
		this.tableModel = tableModel;
		this.mdiForm = mdiForm;
	}
	
	/**
	 * 
	 * @return main details panel 
	 */
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
		constraints.insets = new Insets(3, 5, 3, 5);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 0;
		panel.add(txtCollegeId, constraints);
		
		constraints = new GridBagConstraints();
		lblNoOfParticipants = new CLabel("No Of Participants:");
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 2;
		constraints.gridy = 0;
		panel.add(lblNoOfParticipants,constraints);
		
		constraints = new GridBagConstraints();
		txtNoOfParticipants = new CTextField();
		txtNoOfParticipants.setPreferredSize(new Dimension(75,21));
		constraints.insets = new Insets(5, 5, 4, 5);
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
		txtCollegeName.setRows(1);
		txtCollegeName.setColumns(54);
		txtCollegeName.setLineWrap(true);
		//txtCollegeName.setPreferredSize(new Dimension(430,20));
		constraints.insets = new Insets(5, 5, 5, 5);
		JScrollPane scrollPane = new JScrollPane(txtCollegeName);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.gridwidth = 3;
		panel.add(scrollPane,constraints);
		
		constraints = new GridBagConstraints();
		lblCollegePhone = new CLabel("Condact Number:");
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 4;
		panel.add(lblCollegePhone, constraints);
		
		constraints = new GridBagConstraints();
		txtCollegePhone = new CTextField();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.insets = new Insets(3, 5, 3, 5);
		panel.add(txtCollegePhone, constraints);
		
		return panel;
	}
	
	private  JPanel getMiddleButtonPanel() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		
		constraints = new GridBagConstraints();
		btnInsert = new CButton("Save");
		btnInsert.setMnemonic('S');
		btnInsert.setActionCommand(INSERT);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 2;
		constraints.gridy = 0;
		panel.add(btnInsert, constraints);
		
		constraints = new GridBagConstraints();
		btnClear = new CButton("Clear");
		btnClear.setMnemonic('L');
		btnClear.setActionCommand(CLEAR);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 3;
		constraints.gridy = 0;
		panel.add(btnClear,constraints);
		
		constraints = new GridBagConstraints();
		btnCancel = new CButton("Cancel");
		btnCancel.setMnemonic('C');
		btnCancel.setActionCommand(CANCEL);
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 4;
		constraints.gridy = 0;
		panel.add(btnCancel,constraints);
		
		return panel;
	}
	
	private  JPanel getTablePannel() {
		JPanel panel = new JPanel();
		tblStudentDetails = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(tblStudentDetails);
		scrollPane.setMinimumSize(new Dimension(600, 200));
		scrollPane.setMaximumSize(new Dimension(600, 200));
		scrollPane.setPreferredSize(new Dimension(600, 200));
		panel.add(scrollPane, BorderLayout.WEST);
		return panel;
	}
	
	private JPanel getSideButtonPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		
		constraints = new GridBagConstraints();
		btnPrint = new CButton("Print");
		btnPrint.setMnemonic('P');
		btnPrint.setActionCommand(PRINT);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 2;
		panel.add(btnPrint, constraints);
		btnPrint.addActionListener(controller);
		
		return panel;
	}
	
	/**
	 * 
	 * @return return top view 
	 */
	public JPanel getTopPannel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		//constraints.insets = new Insets(5, 0, 0, 0);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.NORTH;
		panel.add(getMainDetailsPanel(), constraints);

		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(10, 0, 10, 0);
		constraints.anchor = GridBagConstraints.CENTER;
		panel.add(getMiddleButtonPanel(), constraints);
		return panel;
	}
	
	/**
	 * 
	 * @return bottom view 
	 */
	public JPanel getBottomPannel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 0, 0, 5);
		constraints.gridy = 0;
		constraints.gridx = 0;
		constraints.gridwidth = 3;
		panel.add(getTablePannel(), constraints);

		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.NORTHEAST;
		constraints.gridx = 4;
		constraints.gridy = 0;
		constraints.insets = new Insets(10, 0, 0, 0);
		panel.add(getSideButtonPanel(), constraints);

		return panel;
	}

	/**
	 * 
	 * @return full view 
	 */
	public JPanel getDetailsBody() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints;
		
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(getTopPannel(), constraints);

		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		//constraints.insets = new Insets(5, 0, 5, 0);
		panel.add(getBottomPannel(), constraints);

		return panel;
	}
	
	public void showCollegeInitialView() {
		JPanel tabbedPane = new JPanel();
		tabbedPane.add(getDetailsBody(), BorderLayout.CENTER);
		mdiForm.addChild(tabbedPane, "College Initial View");
	}
	/**
	 * 
	 * @return college Id
	 */
	public String getCollegeId() {
		return txtCollegeId.getText();
	}
	
	/**
	 * mehtod to set college Id 
	 * @param collegeId
	 */
	public void setCollegeId(String collegeId) {
		txtCollegeId.setText(collegeId);
	}
	
	/**
	 * 
	 * @return college Name 
	 */
	public String getCollegeName() {
		return txtCollegeName.getText();
	}
	
	/**
	 * method to set the college name 
	 * @param collegeName
	 */
	public void setCollegeName(String collegeName) {
		txtCollegeName.setText(collegeName);
	}
	
	/**
	 * 
	 * @return number of participants 
	 */
	public String getNoOfParticipants() {
		return txtNoOfParticipants.getText();
	}
	
	/**
	 * method to set number of participants
	 * @param noOfPArticipants
	 */
	public void setNoOfParticipants(int noOfPArticipants) {
		txtNoOfParticipants.setText(String.valueOf(noOfPArticipants));
	}
	
	/**
	 * 
	 * @return college phone number 
	 */
	
	public String getCollegePhone() {
		return txtCollegePhone.getText();
	}
	
	/**
	 * memthod to set the college phone number 
	 * @param collegePhone
	 */
	public void setCollegePhone(String collegePhone) {
		txtCollegePhone.setText(collegePhone);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
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

				frame.setLayout(new BorderLayout());
				// frame.add(new Event().init(),BorderLayout.NORTH);
				frame.add(new CollegeInitialView().getDetailsBody(),
						BorderLayout.WEST);
				// frame.add(new Event().getBottamPanel(), BorderLayout.CENTER);
				// frame.add(new Event().getSideButtonPanel(), BorderLayout.)
				frame.pack();
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.setSize(400, 400);
				frame.setVisible(true);
			}
		});
	}
}
