/**
 * 
 */
package org.cssa.iface.gui.controls;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 * @author ajith
 *  @since 1/27/2012
 *
 */
public class CButton  extends JButton{
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font font = null;
	private String title;
	private Dimension d = null;
	
	/**
	 * @return the font
	 */
	public Font getFont() {
		return font;
	}

	/**
	 * @param font the font to set
	 */
	public void setFont(Font font) {
		this.font = font;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 */
	public CButton() {
		super();
		setStyle();
		setSize();
	}

	/**
	 * @param a
	 */
	public CButton(Action a) {
		super(a);
		setStyle();
		setSize();
	}

	/**
	 * @param icon
	 */
	public CButton(Icon icon) {
		super(icon);
		setStyle();
		setSize();
	}

	/**
	 * @param text
	 * @param icon
	 */
	public CButton(String text, Icon icon) {
		super(text, icon);
		setStyle();
		setSize();
	}

	/**
	 * @param text
	 */
	public CButton(String text) {
		super(text);
		setStyle();
		setSize();
	}
	
	/**
	 * 
	 * @param font set the font style of the button
	 */
	public  void setStyle(Font font) {
		if(null == font) {
			setStyle();
		}
		setFont(font);
	}
	/**
	 *  set the font style of the button
	 */
	public void setStyle() {
		if(null ==font ) {
			font = new Font("Cambria", Font.BOLD, 12);
		}
		setStyle(font);
	}
	
	/**
	 * @param d set the size of the button 
	 */
	public void setSize(Dimension d) {
		if(null == d) {
			setSize();
		}
		setPreferredSize(d);
	}
	
	/**
	 * set the size of the button 
	 */
	public void setSize() {
		if(null == d) {
			d = new Dimension(125, 30);
		}
		setSize(d);
	}
	/**
	 * @param width
	 * @param height 
	 *  set the size of the button 
	 */
	public void setSize(int width, int height) {
		if(0 == width| 0 == height) {
			setSize();
		}else {
			setSize(new Dimension(width, height));
		}
	}

	

}
