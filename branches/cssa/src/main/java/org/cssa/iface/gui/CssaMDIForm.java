package org.cssa.iface.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

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

}
