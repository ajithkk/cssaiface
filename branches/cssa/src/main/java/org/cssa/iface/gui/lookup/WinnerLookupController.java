/**
 * 
 */
package org.cssa.iface.gui.lookup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.cssa.iface.bo.Events;
import org.cssa.iface.bo.InsertResult;
import org.cssa.iface.bo.Winners;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.util.ErrorDialog;
import org.cssa.iface.services.QueryServices;
import org.cssa.iface.transaction.EventsTransaction;
import org.cssa.iface.transaction.WinnerTransaction;
import org.cssa.iface.util.EventStorageXML;

/**
 * @author admin
 *
 */
public class WinnerLookupController implements ActionListener, MouseListener { 
	
	private CssaMDIForm mdiForm;
	private WinnerLookupView lookupView;
	private WinnerTransaction transaction;
	private WinnerLookupTableModel tableModel;
	private EventsTransaction eventsTransaction;
	private boolean printEnable;
	
	/**
	 * @param mdiForm
	 */
	public WinnerLookupController(CssaMDIForm mdiForm) {
		this(mdiForm, false);
	}
	

	/**
	 * @param mdiForm
	 * @param printEnable
	 */
	public WinnerLookupController(CssaMDIForm mdiForm, boolean printEnable) {
		this.mdiForm = mdiForm;
		this.printEnable = printEnable;
		this.mdiForm = mdiForm;
		tableModel = new WinnerLookupTableModel();
		transaction = new WinnerTransaction();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(WinnerLookupView.CANCEL.equals(actionCommand)) {
			mdiForm.closeFrame();
		} else if (WinnerLookupView.SEARCH.equals(actionCommand)) {
			performSearchAction();
		} else if (WinnerLookupView.SAVE.equals(actionCommand)) {
			performSaveAction();
		} else if (WinnerLookupView.PRINT.equals(actionCommand)) {
			performPrintAction();
		} else if (WinnerLookupView.DELETE.equals(actionCommand)) {
			performDeleteAction();
		}
		
	}

	private void performDeleteAction() {
		int selectedIndex = lookupView.getTblStudentDetails().getSelectedRow();
		InsertResult result = tableModel.getWinnerList().get(selectedIndex);
		try {
			transaction.delete(result);
		} catch (IfaceException e) {
			new ErrorDialog(e);
			e.printStackTrace();
		}
	}

	private void performPrintAction() {
		
	}

	private void performSaveAction() {
		List<InsertResult> insertResults = tableModel.getWinnerList();
		try {
			transaction.saveAll(insertResults,null);
		} catch (IfaceException e) {
			new ErrorDialog(e);
			e.printStackTrace();
		}
		
	}

	private void performSearchAction() {
		Winners winners = new Winners();
		String eventId = lookupView.getEventId().getSelectedIndex() > 0 ? lookupView.getEventId().getSelectedItem().toString() : null ;
		String position = lookupView.getWinnerPosition().getSelectedIndex()> 0 ? lookupView.getWinnerPosition().getSelectedItem().toString() : null;
		winners.setEventId(eventId);
		winners.setWinnerStatus(position);
		
		try {
			List<InsertResult> winnerList = transaction.load(winners);
			tableModel.setWinnerList(winnerList);
		} catch (IfaceException e) {
			new ErrorDialog(e);
			e.printStackTrace();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	
	public void askWinnerLookUp() {
		lookupView  = new WinnerLookupView(this, tableModel, mdiForm);
		lookupView.showWinnerLookup();
		setEventId();
		setWinnerPosition();
		if(printEnable) {
			lookupView.getBtnDelete().setVisible(false);
			lookupView.getBtnSave().setVisible(false);
			lookupView.getBtnPrint().setVisible(true);
		} else {
			lookupView.getBtnDelete().setVisible(true);
			lookupView.getBtnSave().setVisible(true);
			lookupView.getBtnPrint().setVisible(false);
		}
	}
	
	private void setWinnerPosition() {
		lookupView.getWinnerPosition().addItem("Please Select");
		lookupView.getWinnerPosition().addItem("First");
		lookupView.getWinnerPosition().addItem("Second");
	}

	private void setEventId() {
		eventsTransaction = new EventsTransaction();
		try {
			List<Events> events = eventsTransaction.loadAll();
			lookupView.getEventId().addItem("please select");

			for(Events event : events) {
				lookupView.getEventId().addItem(event.getEventId());
			}
		} catch (IfaceException e) {
			new ErrorDialog(e).setVisible(true);
		}
	}

}
