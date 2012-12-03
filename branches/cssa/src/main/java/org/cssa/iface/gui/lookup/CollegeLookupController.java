/**
 * 
 */
package org.cssa.iface.gui.lookup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.List;

import org.cssa.iface.bo.CollegeDetails;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.college.CollegeDetailsController;
import org.cssa.iface.gui.formvalidator.CollegeLookupFormValidator;
import org.cssa.iface.gui.util.ErrorDialog;
import org.cssa.iface.report.college.CollegeLookupReport;
import org.cssa.iface.services.CollegeDetailsQueryEngine;
import org.cssa.iface.services.CollegeLookupService;
import org.cssa.iface.transaction.CollegeTransaction;
import org.cssa.iface.util.Util;

import com.itextpdf.text.DocumentException;

/**
 * @author ajith
 *
 */
public class CollegeLookupController implements ActionListener, MouseListener {
	
	private CollegeLookupView lookupView;
	private CollegeLookupFormValidator validator;
	private CollegeLookupTableModel tableModel;
	private CssaMDIForm mdiForm;
	private CollegeTransaction transaction;
	private boolean reportView;
	
	List<CollegeDetails> collegeDetails;
	CollegeDetailsQueryEngine engine;
	
	private CollegeLookupService<CollegeDetails> collegeLookupService;
	
	/**
	 * default constructor
	 */
	public CollegeLookupController(CssaMDIForm mdiForm) {
		validator = new CollegeLookupFormValidator();
		tableModel = new CollegeLookupTableModel();
		this.mdiForm = mdiForm;
		transaction = new CollegeTransaction();
		collegeLookupService = null;
	}
	
	
	public CollegeLookupController(CssaMDIForm mdiForm, boolean reportView) {
		this(mdiForm);
		this.reportView = reportView;
	}
	
	
	
	/**
	 * @param mdiForm
	 * @param collegeLookupService
	 */
	public CollegeLookupController(CssaMDIForm mdiForm,
			CollegeLookupService<CollegeDetails> collegeLookupService) {
		super();
		this.mdiForm = mdiForm;
		this.collegeLookupService = collegeLookupService;
		validator = new CollegeLookupFormValidator();
		tableModel = new CollegeLookupTableModel();
		transaction = new CollegeTransaction();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		String action = e.getActionCommand();
		if(CollegeLookupView.SEARCH.equals(action)) {
			performSearchAction();
			
		}
		if(CollegeLookupView.CANCEL.equals(action)) {
			mdiForm.closeFrame();
		}
		if(CollegeLookupView.CLEAR.equals(action)) {
			clearCollegeLookupView();
		}
		if(CollegeLookupView.PRINT.equals(action)) {
			performPrintAction();
		}
		
		
	}
	
	

	private void performSearchAction() {
		validator.setLookupView(lookupView);
		if(validator.allFieldsEmpty()) {
			try {
				collegeDetails = transaction.loadAll();
				tableModel.setCollegeList(collegeDetails);
			} catch (IfaceException e1) {
				new ErrorDialog(e1).setVisible(true);
			}
		}
		else {
			CollegeDetails collegeDetail = new CollegeDetails();
			collegeDetail.setCollegeId(lookupView.getCollegeId());
			collegeDetail.setCollegeName(lookupView.getCollegeName());
			try {
				collegeDetails = transaction.loadAll(collegeDetail);
				tableModel.setCollegeList(collegeDetails);
			} catch (IfaceException e1) {
				new ErrorDialog(e1).setVisible(true);
			}
		}
		
	}


	private void performPrintAction() {
		String FILE = Util.getReportHome()+"\\CollegeDetailsReport.pdf";
		List<CollegeDetails> college = tableModel.getCollegeList();
		if(null != college) {
			CollegeLookupReport report = new CollegeLookupReport(FILE, college);
			try {
				report.createReport();
			} catch (FileNotFoundException e) {
				new ErrorDialog(e).setVisible(true);
				e.printStackTrace();
			} catch (DocumentException e) {
				new ErrorDialog(e).setVisible(true);
				e.printStackTrace();
			}
		}
		
		
	}


	/**
	 * clear the college look view
	 */
	public void clearCollegeLookupView() {
		lookupView.setCollegeId("");
		lookupView.setCollegeName("");
	}
	
	
	/**
	 * method to ask college lookup view 
	 */
	public void askCollegeLookupView() {
		lookupView = new CollegeLookupView(this,tableModel,mdiForm);
		lookupView.showCollegeLookupScreen();
		if(reportView) {
			lookupView.getBtnPrint().setVisible(true);
		} else {
			lookupView.getBtnPrint().setVisible(false);
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(!reportView) {
			int selectedRow =  lookupView.getTblCollegeDetails().getSelectedRow();
		    CollegeDetails college = tableModel.getCollegeList().get(selectedRow);
		    if(null == collegeLookupService) {
		    	new CollegeDetailsController(mdiForm, college).askCollegeDetailsView();
		    } else {
				collegeLookupService.setSelectedCollege(college);
				mdiForm.closeFrame();
			}
		}
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
