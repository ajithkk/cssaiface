/**
 * 
 */
package org.cssa.iface.gui.search;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import org.cssa.iface.bo.InsertResult;
import org.cssa.iface.gui.CssaMDIForm;

/**
 * @author ajith
 *
 */
public class SearchResultController implements ActionListener {

	private SearchResultView resultView;
	private SearchResultTableModel tableModel;
	private CssaMDIForm mdiForm;
	private List<InsertResult> resultsList;
	
	public SearchResultController(CssaMDIForm mdiForm, List<InsertResult> resultsList) {
		this.mdiForm = mdiForm;
		this.resultsList = resultsList;
		tableModel = new SearchResultTableModel(resultsList);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		if(SearchResultView.PRINT.equals(actionCommand)) {
			
		} else if (SearchResultView.CANCEL.equals(actionCommand)) {
			mdiForm.closeFrame();
		} else if (SearchResultView.CLEAR.equals(actionCommand)) {
			mdiForm.closeFrame();
		}
		
		
	}
	
	public void askSearchResultView() {
		resultView = new SearchResultView(this, tableModel, mdiForm);
		resultView.showSearchResultScreen();
	}

}
