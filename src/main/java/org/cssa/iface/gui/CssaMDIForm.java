package org.cssa.iface.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import org.cssa.iface.gui.menu.CssaMenuController;
import org.cssa.iface.gui.toolbar.CssaToolBar;
import org.cssa.iface.util.ImageUtil;

public class CssaMDIForm extends JFrame {

	private JDesktopPane desktopPane;
	private Icon cssaIcon;
	private JPanel toolBarPanel;
	ImageUtil imageUtil;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CssaMDIForm frame = new CssaMDIForm();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		int inset = 0;
		toolBarPanel = new JPanel();
		desktopPane = new JDesktopPane();
		imageUtil = new ImageUtil();
		getContentPane().setLayout(new BorderLayout());
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(inset, inset, screenSize.width - inset*2, screenSize.height-50-inset*2);
		setSize(screenSize);
		setIconImage(imageUtil.getImage("cssa.jpg"));;
		
		toolBarPanel.setLayout(new BoxLayout(toolBarPanel, BoxLayout.Y_AXIS));
		this.getContentPane().add(BorderLayout.NORTH, toolBarPanel);
		
		desktopPane.setBackground(Color.gray);
		desktopPane.putClientProperty("JDesktopPane.dragMode", "outline");
		this.getContentPane().add(BorderLayout.CENTER,desktopPane);
		desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
	
		CssaMenuController controller = new CssaMenuController(this);
		controller.getMenuBar();
		
		CssaToolBar toolBar = new CssaToolBar();
		toolBar.setAlignmentX(JComponent.LEFT_ALIGNMENT);
		toolBarPanel.add(toolBar,BorderLayout.NORTH);
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
		Dimension screenSize = this.getContentPane().getSize();
		JInternalFrame frame = new JInternalFrame(frameTitle, true, true, true, true);
		frame.add(panel);
		frame.setSize(screenSize);
		desktopPane.add(frame);
		frame.setVisible(true);
		try {
			frame.setSelected(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the cssaIcon
	 */
	public Icon getCssaIcon() {
		return cssaIcon;
	}

	/**
	 * @param cssaIcon the cssaIcon to set
	 */
	public void setCssaIcon(Icon cssaIcon) {
		this.cssaIcon = cssaIcon;
	}
	

}
