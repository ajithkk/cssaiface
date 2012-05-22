package org.cssa.iface.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import org.cssa.iface.gui.menu.CssaMenuController;
import org.cssa.iface.util.ImageUtil;

public class CssaMDIForm extends JFrame {

	private JDesktopPane desktopPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CssaMDIForm frame = new CssaMDIForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CssaMDIForm() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize);
		desktopPane = new JDesktopPane();
		setContentPane(desktopPane);
		desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		setIconImage(new ImageUtil().getImage("cssa.jpg"));
		CssaMenuController controller = new CssaMenuController(this);
		controller.getMenuBar();
	}
	
	public void addChild(JInternalFrame frame) {
		desktopPane.add(frame);
		frame.setVisible(true);
		try {
			frame.setSelected(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	
	public void addChild(JPanel panel, String frameTitle) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		JInternalFrame frame = new JInternalFrame(frameTitle, true, true, true, true);
		frame.add(panel);
		frame.setSize(screenSize);
		desktopPane.add(frame);
		try {
			frame.setSelected(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	

}
