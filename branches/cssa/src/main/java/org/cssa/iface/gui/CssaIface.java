package org.cssa.iface.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import org.cssa.iface.util.ImageUtil;

public class CssaIface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDesktopPane desktopPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CssaIface frame = new CssaIface();
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
	public CssaIface() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize);
		desktopPane = new JDesktopPane();
		setContentPane(desktopPane);
		desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		setIconImage(new ImageUtil().getImage("cssa.jpg"));
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
