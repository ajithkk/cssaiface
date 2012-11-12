/**
 * 
 */
package org.cssa.iface.gui.search;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;

import org.cssa.iface.bo.InsertResult;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.util.ErrorDialog;
import org.cssa.iface.report.search.SearchResultReport;
import org.cssa.iface.util.Util;

import com.itextpdf.text.DocumentException;

/**
 * @author ajith
 *
 */
public class SearchResultController implements ActionListener {

	private SearchResultView resultView;
	private SearchResultTableModel tableModel;
	private CssaMDIForm mdiForm;
	
	public SearchResultController(CssaMDIForm mdiForm, List<InsertResult> resultsList) {
		this.mdiForm = mdiForm;
		tableModel = new SearchResultTableModel(resultsList);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		if(SearchResultView.PRINT.equals(actionCommand)) {
			performPrintAction();
		} else if (SearchResultView.CANCEL.equals(actionCommand)) {
			mdiForm.closeFrame();
		} else if (SearchResultView.CLEAR.equals(actionCommand)) {
			mdiForm.closeFrame();
		}
		
		
	}
	
	private void performPrintAction() {
		
		List<InsertResult> list = tableModel.getSearchResult();
		String FILE = Util.getReportHome()+"\\EventPartipantDetails.pdf";
		if(null != list) {
			SearchResultReport report = new SearchResultReport(FILE, list);
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

	public void askSearchResultView() {
		resultView = new SearchResultView(this, tableModel, mdiForm);
		resultView.showSearchResultScreen();
	}

}
