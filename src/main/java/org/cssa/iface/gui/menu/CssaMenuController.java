/**
 * 
 */
package org.cssa.iface.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.cssa.iface.gui.CssaMDIForm;

/**
 * @author Ajith
 *
 */
public class CssaMenuController implements ActionListener {

	private CssaMenuBar menuBar = null;
	private CssaMDIForm cssaMDIForm = null;
	
	public CssaMenuController(CssaMDIForm cssaMDIForm) {
		this.cssaMDIForm = cssaMDIForm;
	}
	public CssaMenuController() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(CssaMenuBar.MNU_FILE_NEWCOLLEGE.equals(actionCommand)) {
			exitApp();
		}
		
	}
	
	private void exitApp() {
		System.exit(0);
		
	}
	public void getMenuBar() {
		CssaMenuBar menuBar = new CssaMenuBar(this,cssaMDIForm);
		menuBar.addMenuBar();
	}

}
