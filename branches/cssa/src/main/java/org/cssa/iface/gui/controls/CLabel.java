package org.cssa.iface.gui.controls;

import javax.swing.Icon;
import javax.swing.JLabel;
/**
 * 
 * @author ajith
 * @since 1/27/2012
 */
public class CLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public CLabel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param image
	 * @param horizontalAlignment
	 */
	public CLabel(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param image
	 */
	public CLabel(Icon image) {
		super(image);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param text
	 * @param icon
	 * @param horizontalAlignment
	 */
	public CLabel(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param text
	 * @param horizontalAlignment
	 */
	public CLabel(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param text
	 */
	public CLabel(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

}
