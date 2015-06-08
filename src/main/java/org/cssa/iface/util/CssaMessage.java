package org.cssa.iface.util;

import javax.swing.JOptionPane;

import org.cssa.iface.gui.CssaMDIForm;
import org.cssa.iface.gui.util.MessageUtil;

/**
 * 
 * @author ajith
 * @since 8/22/2012
 *
 */

public class CssaMessage extends MessageUtil {
	
	public CssaMessage() {
		this(null);
	}
	
	public CssaMessage(CssaMDIForm mdiForm) {
		super(mdiForm);
	}

	public static void informationMessage(CssaMDIForm mdiForm, String message) {
		JOptionPane.showMessageDialog(mdiForm,message);
	}
	
	public static void informationMessage(CssaMDIForm mdiForm, String message, String title) {
		JOptionPane.showMessageDialog(mdiForm,message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	

}
