/**
 * 
 */
package org.cssa.iface.gui;




import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * @author ajith
 *
 */
public class CssaInternalFrame extends JInternalFrame{
	
	JTabbedPane  tabbedPane;
	
	public CssaInternalFrame() {
		tabbedPane = new JTabbedPane();
	}
	
	public void setPane(JPanel panel) {
		tabbedPane.add(panel);
	}
	
	public void addFrame() {
		
	}

}
