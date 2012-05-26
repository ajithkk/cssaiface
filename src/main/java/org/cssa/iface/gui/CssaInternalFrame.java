/**
 * 
 */
package org.cssa.iface.gui;




import java.awt.Dimension;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import org.cssa.iface.util.ImageUtil;

/**
 * @author ajith
 *
 */
public class CssaInternalFrame extends JInternalFrame{
	
	private JTabbedPane  tabbedPane;
	private CssaMDIForm mdiForm;
	ImageUtil imageUtil;
	
	public CssaInternalFrame() {
		tabbedPane = new JTabbedPane();
	}
	
	CssaInternalFrame(String title, CssaMDIForm mdiForm){
		super(title, true, true, true, true);
		this.mdiForm = mdiForm;
		imageUtil = new ImageUtil();
		Dimension size = mdiForm.getContentPane().getSize();
		this.setSize(size);
		this.setFrameIcon(imageUtil.getIcon("cssa.jpg"));
	}
	
	public void setPane(JPanel panel) {
		tabbedPane.add(panel);
	}
	
	
	

}
