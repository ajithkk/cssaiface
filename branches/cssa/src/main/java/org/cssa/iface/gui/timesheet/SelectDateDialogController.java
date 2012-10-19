/**
 * 
 */
package org.cssa.iface.gui.timesheet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Set;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.util.TimeScheduleStoreXML;

/**
 * @author ajith
 *
 */
public class SelectDateDialogController implements ActionListener {
	
	private CssaMDIForm mdiForm;
	private SelectDateDialog dateDialog;
	
	/**
	 * @param mdiForm
	 */
	public SelectDateDialogController(CssaMDIForm mdiForm) {
		super();
		this.mdiForm = mdiForm;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		if(SelectDateDialog.GO.equals(actionCommand)) {
			if(dateDialog.getCmbSelectDate().getSelectedIndex() > 0) {
				TimeSheetController controller = new TimeSheetController(mdiForm, dateDialog.getCmbSelectDate().getSelectedItem().toString());
				controller.askTimeSheetView();
			}
		}
	}
	
	public void askDateDialog() {
		dateDialog = new SelectDateDialog(mdiForm, this);
		dateDialog.showDateDialog();
		setDate();
	}
	
	private void setDate() {
		
		TimeScheduleStoreXML  timeScheduleStoreXML = new TimeScheduleStoreXML();
		Map<String, String> dayMap = timeScheduleStoreXML.getTimeScheduleMap();
		
		dateDialog.getCmbSelectDate().addItem("Please Select");
		Set<Map.Entry<String, String>> daySet = dayMap.entrySet();
		for(Map.Entry<String, String> set : daySet) {
			dateDialog.getCmbSelectDate().addItem(set.getValue());
		}
		
		
	}

}
