/**
 * 
 */
package org.cssa.iface.gui.search;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import org.cssa.iface.bo.Events;
import org.cssa.iface.bo.InsertResult;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.transaction.EventsTransaction;
import org.cssa.iface.transaction.TransactioUtils;
import org.cssa.iface.util.EventStorageXML;


/**
 * @author ajith
 *
 */
public class SearchTableController implements ActionListener {

	private CssaMDIForm mdiForm;
	private SearchTableModel tableModel;
	private SearchTable searchTable;
	private EventsTransaction eventsTransaction;
	private List<Events> events;
	private List<String> columnList;
	
	
	private List<Object> selectedEvents;
	
	private JTable table;
	private JComboBox combo;
	
	private TransactioUtils transactioUtils;
	
	
	/**
	 * @param mdiForm
	 */
	public SearchTableController(CssaMDIForm mdiForm) {
		super();
		this.mdiForm = mdiForm;
		tableModel = new SearchTableModel();
		columnList = new ArrayList<String>();
		selectedEvents = new ArrayList<Object>();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		
		if(combo == e.getSource()) {  
			Object item = combo.getSelectedItem();
			if(selectedEvents.contains(item)) {
			} else {
				selectedEvents.add(item);
			}
		 }
		
		if(actionCommand.equals(SearchTable.SEARCH)) {
			searchActionPerformed();
		} else if (actionCommand.equals(SearchTable.CANCEL)) {
			mdiForm.closeFrame();
		} else if (actionCommand.equals(SearchTable.CLEAR)) {
			clearActionPerfformed();
		}
	}
	
	private void clearActionPerfformed() {
		
		
	}

	private void searchActionPerformed() {
		transactioUtils = new TransactioUtils();
		try {
		List<InsertResult> searchResult = 	transactioUtils.getParticipantsDetailsByEvents(tableModel.getSelectedEvent(), tableModel.getSearchKey());
		if(null != searchResult) {
			new SearchResultController(mdiForm, searchResult).askSearchResultView();

		}
		
		
		} catch (IfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public boolean isSelected(Object item) {
		return selectedEvents.contains(item);
	}
	
	public void askSearachTable() {
		
		searchTable = new SearchTable(mdiForm, this, tableModel);
		searchTable.showSearchTable();
		setTableData();
		table = searchTable.getTable();
		setSearchEventsStage(table, table.getColumnModel().getColumn(0));
		setSearchEvents(table, table.getColumnModel().getColumn(1));
	}
	
	public  void setSearchEvents(JTable table, TableColumn tableColumn) {
		Vector<String> eventVector = new Vector<String>();
	    eventsTransaction = new EventsTransaction();
		try {
		    events = eventsTransaction.loadAll();
		    eventVector.addElement(" ");
			for(Events event : events) {
				eventVector.addElement(event.getEventId());
			}
			
			MultiRenderer render = new MultiRenderer(this);
			DefaultComboBoxModel model = new DefaultComboBoxModel(eventVector);
			combo = new JComboBox(model);
			combo.addActionListener(this);
			combo.setRenderer(render);

			tableColumn.setCellEditor(new DefaultCellEditor(combo));
			DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
			renderer.setToolTipText("Click for combo box");
			tableColumn.setCellRenderer(renderer);
		} catch (IfaceException e) {
			e.printStackTrace();
		}
	}
	
	public  void setSearchEventsStage(JTable table, TableColumn tableColumn) {
		JComboBox comboBox = new JComboBox();
	    eventsTransaction = new EventsTransaction();
		try {
			EventStorageXML eventStorageXML = new EventStorageXML();
			Map<String, String> eventStateMap = eventStorageXML.getEventStageMap();
			
			comboBox.addItem("");
			Set<Map.Entry<String, String>> eventStateSet = eventStateMap.entrySet();
			for(Map.Entry<String, String> set : eventStateSet) {
				comboBox.addItem(set.getValue());
			}
			tableColumn.setCellEditor(new DefaultCellEditor(comboBox));
			DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
			renderer.setToolTipText("Click for combo box");
			tableColumn.setCellRenderer(renderer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setTableData() {
		eventsTransaction = new EventsTransaction();
		try {
		    events = eventsTransaction.loadAll();
		    int size = events.size();
			for(int i = 0; i < 7; i++) {
				columnList.add(" ");
			}
//			columnList.add("");
		}catch (Exception e) {
		}
		tableModel.setEventList(columnList);
		
	}
	
}
