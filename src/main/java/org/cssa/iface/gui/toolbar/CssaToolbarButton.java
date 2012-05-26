package org.cssa.iface.gui.toolbar;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
/**
 * 
 * @author ajith
 *
 */

public class CssaToolbarButton extends JButton {
	
	private static final Insets MARGIN = new Insets(0, 0, 0, 0);
	private static final int BOTTOM = 3;
	private static final int CENTER = 0;
 
	public CssaToolbarButton(Icon icon, String txt,String toolTip) {
		super(icon);
		setMargin(MARGIN);
		setVerticalTextPosition(BOTTOM);
		setHorizontalTextPosition(CENTER);
		setToolTipText(toolTip);
		Dimension iconSize = new Dimension(25, 25);
		setSize(iconSize);
		setMaximumSize(iconSize);
		setMinimumSize(iconSize);
		setPreferredSize(iconSize);
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	}
	public CssaToolbarButton(Icon icon) {
		this(icon,null,null);
	}
	
	public CssaToolbarButton(String imageFile) {
		this(new ImageIcon(imageFile));
	}
	
	public CssaToolbarButton(String imageFile, String txt) {
		this(new ImageIcon(imageFile));
	}
}
