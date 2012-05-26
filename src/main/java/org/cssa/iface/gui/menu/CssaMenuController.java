/**
 * 
 */
package org.cssa.iface.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.infrastructure.CSSAConstants;
import org.cssa.iface.util.Util;

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
			exitApplication();
		}
		
	}
	
	public void exitApplication() {
		Util.exitApplicataion();
		
	}
	public void getMenuBar() {
		CssaMenuBar menuBar = new CssaMenuBar(this,cssaMDIForm);
		menuBar.addMenuBar();
	}
	
	public void displayHelp() {
		ClassLoader loader = this.getClass().getClassLoader();
		URL url = loader.getResource("help" + File.separator + CSSAConstants.HELP_FILE); 
		
	}

}
