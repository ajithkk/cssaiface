package org.cssa.iface.util;

import javax.swing.JOptionPane;

import org.cssa.iface.gui.CssaMDIForm;

/**
 * 
 * @author ajith
 * @since 8/22/2012
 *
 */

public class CssaMessage {
	
	public static void informationMessage(CssaMDIForm mdiForm, String message) {
		JOptionPane.showMessageDialog(mdiForm,message);
	}
	
	public static void informationMessage(CssaMDIForm mdiForm, String message, String title) {
		JOptionPane.showMessageDialog(mdiForm,message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	

}
