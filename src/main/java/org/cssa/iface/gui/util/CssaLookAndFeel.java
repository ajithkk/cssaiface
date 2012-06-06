package org.cssa.iface.gui.util;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import org.cssa.iface.infrastructure.CSSAConstants;

/**
 * 
 * @author ajith
 *
 */
public class CssaLookAndFeel {
	
	private String lookAndFeel;
	
	public CssaLookAndFeel() {
		lookAndFeel = CSSAConstants.SYSYEM;
		setLookAndFeel();
	}
	
	public CssaLookAndFeel(String lookAndFeel) {
		this.lookAndFeel = lookAndFeel;
		setLookAndFeel();
	}

	/**
	 * @return the lookAndFeel
	 */
	public String getLookAndFeel() {
		return lookAndFeel;
	}

	private void setLookAndFeel() {
		if(CSSAConstants.SYSYEM .equalsIgnoreCase(lookAndFeel)){
			lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		} else if (CSSAConstants.MOTIF.equalsIgnoreCase(lookAndFeel)) {
			lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
		} else if (CSSAConstants.GTK.equalsIgnoreCase(lookAndFeel)) {
			lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
		} else if (CSSAConstants.JAVA.equalsIgnoreCase(lookAndFeel)) {
			lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
		} else if (CSSAConstants.NIMBUS.equalsIgnoreCase(lookAndFeel)) {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            lookAndFeel = info.getClassName();
		            break;
		        }
		    }
		}
		
	}

}
