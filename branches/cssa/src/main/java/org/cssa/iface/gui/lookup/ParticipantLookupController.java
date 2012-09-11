/**
 * 
 */
package org.cssa.iface.gui.lookup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import org.cssa.iface.bo.InsertResultsTableBo;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.services.LookupController;
import org.cssa.iface.services.LookupService;
import org.cssa.iface.transaction.EventsTransaction;

/**
 * @author Ajith
 *
 */
public class ParticipantLookupController implements ActionListener, MouseListener, LookupController {
	
	private CssaMDIForm mdiForm;
	private EventsTransaction eventsTransaction;
	private ParticipantLookupTableModel tableModel;
	private ParticipantLookupView lookupView;
	private List<InsertResultsTableBo> resultsTableBos;
	private LookupService<InsertResultsTableBo> insertResult;
	private InsertResultsTableBo tableBo;
	
	/**
	 * constructor
	 * @param mdiForm
	 */
	public ParticipantLookupController(CssaMDIForm mdiForm) {
		this.mdiForm = mdiForm;
		tableModel = new ParticipantLookupTableModel();
		insertResult = null;
	}
	
	

	/**
	 * @param mdiForm
	 * @param insertResult
	 */
	public ParticipantLookupController(CssaMDIForm mdiForm,
			LookupService<InsertResultsTableBo> insertResult) {
		super();
		this.mdiForm = mdiForm;
		this.insertResult = insertResult;
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(ParticipantLookupView.SEARCH.equals(actionCommand)) {
			searchAction();
			
		} else if(ParticipantLookupView.CANCEL.equals(actionCommand)) {
			cancelAction();
			
		} else if (ParticipantLookupView.CLEAR.equals(actionCommand)) {
			clearAction();
		}
	}


	@Override
	public void searchAction() {
		
	}



	@Override
	public void clearAction() {
		
	}



	@Override
	public void cancelAction() {
		mdiForm.closeFrame();
		
	}
	
	public void askParticipantsLookupView() {
		lookupView = new ParticipantLookupView(mdiForm, this, tableModel);
		lookupView.showLookupView();
	}

}
