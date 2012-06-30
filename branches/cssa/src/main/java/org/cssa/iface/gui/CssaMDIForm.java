package org.cssa.iface.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.util.Stack;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import org.cssa.iface.gui.menu.CssaMenuController;
import org.cssa.iface.gui.toolbar.CssaToolBar;
import org.cssa.iface.gui.util.CssaLookAndFeel;
import org.cssa.iface.infrastructure.CSSAConstants;
import org.cssa.iface.util.ImageUtil;

public class CssaMDIForm extends JFrame {

	private JDesktopPane desktopPane;
	private Icon cssaIcon;
	private JPanel toolBarPanel;
	ImageUtil imageUtil;
	private String lookAndFeel = null;
	JInternalFrame frame;
	Stack<JInternalFrame> internalFrames;
	
	
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
		internalFrames = new Stack<JInternalFrame>();
		
		getContentPane().setLayout(new BorderLayout());
		setLookAndFeel(lookAndFeel);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(inset, inset, screenSize.width - inset*2, screenSize.height-50-inset*2);
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
	    frame = new JInternalFrame(frameTitle, true, true, true, true);
		frame.add(panel);
		frame.setSize(screenSize);
		desktopPane.add(frame);
		frame.setVisible(true);
		internalFrames.push(frame);
		frame.addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameClosing(InternalFrameEvent e){
				closeFrame();
			}
		});
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
	/**
	 * @return the lookAndFeel
	 */
	public String getLookAndFeel() {
		return lookAndFeel;
	}

	/**
	 * @param lookAndFeel the lookAndFeel to set
	 */
	public void setLookAndFeel(String lookAndFeel) {
		this.lookAndFeel = lookAndFeel;
		if(null == lookAndFeel){
			lookAndFeel = CSSAConstants.SYSYEM;
		}
		try {
			UIManager.setLookAndFeel(new CssaLookAndFeel(lookAndFeel).getLookAndFeel());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the frame
	 */
	public JInternalFrame getFrame() {
		return frame;
	}

	/**
	 * @param frame the frame to set
	 */
	public void setFrame(JInternalFrame frame) {
		this.frame = frame;
	}
	
	public void closeFrame() {
		if(!internalFrames.empty()) {
			JInternalFrame frame = internalFrames.pop();
			frame.dispose();
		}
	}
	
	

}
