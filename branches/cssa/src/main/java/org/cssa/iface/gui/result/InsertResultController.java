package org.cssa.iface.gui.result;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.cssa.iface.gui.CssaMDIForm;

public class InsertResultController implements ActionListener {

	
	private CssaMDIForm mdiForm;
	private InsertResultView resultView;
	
	public InsertResultController(CssaMDIForm mdiForm) {
		super();
		this.mdiForm = mdiForm;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void askInsertResultView() {
		resultView = new InsertResultView(this, mdiForm);				
		resultView.showInsertResultScreen();
	}

}
