/**
 * 
 */
package org.cssa.iface.gui.lookup;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import org.cssa.iface.gui.controls.CButton;
import org.cssa.iface.gui.controls.CLabel;
import org.cssa.iface.gui.controls.CTextField;

/**
 * @author ajith
 *
 */
public class CollegeLookupView {
	
	public static final String SEARCH = "Search";
	public static final String CANCEL = "Cancel";
	public static final String CLEAR = "Clear";
	
	private CLabel lblCollegeName;
	private CLabel lblCollegeId;
	
	private CTextField txtCollegeName;
	private CTextField txtCollegeId;
	
	private CButton btnSearch;
	private CButton btnClear;
	private CButton btnCancel;
	
	private JTable tblCollegeDetails;
	
	private CollegeLookupController collegeLookupController;
	private CollegeLookupTableModel tableModel;
	
	
	
	/**
	 * @param collegeLookupController
	 * @param tableModel
	 */
	public CollegeLookupView(CollegeLookupController collegeLookupController,
			CollegeLookupTableModel tableModel) {
		super();
		this.collegeLookupController = collegeLookupController;
		this.tableModel = tableModel;
	}
	/**
	 * default constructor
	 */
	public CollegeLookupView() {
		this.tableModel = new CollegeLookupTableModel();
		
	}
	
	/**
	 * display college lookup screen
	 */
	/*public void showCollegeLookupScreen() {
		JTabbedPane tabbedPane = new JTabbedPane();
		
	}*/
	public Component showCollegeLookupScreen() {
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab(BorderLayout.CENTER, getEventDetailsBody());
		//tabbedPane.addTab("Event Details", new EventsView().getEventDetailsBody());
		tabbedPane.setTitleAt(0, "College Details");
		return tabbedPane;
	}
	
	public JPanel getCollegeDetailsPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = null;
		
		lblCollegeId = new CLabel("College Id:");
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(10, 5, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(lblCollegeId,constraints);
		
		txtCollegeId = new CTextField();
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 0;
		panel.add(txtCollegeId, constraints);
		
		lblCollegeName = new CLabel("College Name:");
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		panel.add(lblCollegeName,constraints);
		
		txtCollegeName =  new CTextField();
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridy = 1;
		panel.add(txtCollegeName, constraints);
		
		return panel;
		
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
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 2;
		constraints.gridy = 0;
		panel.add(btnSearch, constraints);
		btnSearch.addActionListener(collegeLookupController);

		constraints = new GridBagConstraints();
		btnClear = new CButton("Clear");
		btnClear.setMnemonic('L');
		btnClear.setActionCommand(CLEAR);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 3;
		constraints.gridy = 0;
		panel.add(btnClear, constraints);
		btnClear.addActionListener(collegeLookupController);

		constraints = new GridBagConstraints();
		btnCancel = new CButton("Cancel");
		btnCancel.setMnemonic('C');
		btnCancel.setActionCommand(CANCEL);
		constraints.insets = new Insets(0, 5, 0, 5);
		constraints.gridx = 4;
		constraints.gridy = 0;
		panel.add(btnCancel, constraints);
		btnCancel.addActionListener(collegeLookupController);
		
		return panel;
	}
	
	public JPanel getTablePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		tblCollegeDetails = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(tblCollegeDetails);
		panel.add(scrollPane, BorderLayout.CENTER);

		return panel;
	}
	
	public JPanel getTopPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 0, 0, 0);
		constraints.gridx = 1;
		constraints.gridy = 5;
		constraints.anchor = GridBagConstraints.NORTH;
		panel.add(getCollegeDetailsPanel(), constraints);

		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 6;
		constraints.insets = new Insets(10, 0, 10, 0);
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
	
	public JPanel getEventDetailsBody() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints;
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(getTopPanel(), constraints);

		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(0, 5, 5, 5);
		panel.add(getBottomPannel(), constraints);

		return panel;
	}

	
	/**
	 * this method return college name
	 * @return collegeName
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
	 * method to get the college Id
	 * @return collegeId
	 */
	public String getCollegeId() {
		return txtCollegeId.getText();
	}
	
	/**
	 * method to set the college id
	 * @param collegeId
	 */
	public void setCollegeId(String collegeId) {
		txtCollegeId.setText(collegeId);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();
				try {
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
		    }

				frame.setLayout(new BorderLayout());
				// frame.add(new Event().init(),BorderLayout.NORTH);
				frame.add(new CollegeLookupView().showCollegeLookupScreen(),
						BorderLayout.CENTER);
				/*frame.add(new CollegeLookupView().getEventDetailsBody(),
						BorderLayout.CENTER);*/
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
	


