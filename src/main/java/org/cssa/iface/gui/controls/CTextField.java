package org.cssa.iface.gui.controls;

import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.text.Document;
/**
 * 
 * @author ajith
 * @since 1/27/2012
 */

public class CTextField extends JTextField {

	private Dimension d = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = -5189046408536114630L;

	/**
	 * 
	 */
	public CTextField() {
		super();
		setSize();
	}

	/**
	 * @param doc
	 * @param text
	 * @param columns
	 */
	public CTextField(Document doc, String text, int columns) {
		super(doc, text, columns);
		setSize();
	}

	/**
	 * @param columns
	 */
	public CTextField(int columns) {
		super(columns);
		setSize();
	}

	/**
	 * @param text
	 * @param columns
	 */
	public CTextField(String text, int columns) {
		super(text, columns);
		setSize();
	}

	/**
	 * @param text
	 */
	public CTextField(String text) {
		super(text);
		setSize();
	}
	
	/**
	 * Set the default size to CTextField
	 */
	public void setSize() {
		if(null == d) {
			d = new Dimension(250,23);
		}
		setSize(d);
	}
	
	/**
	 * Set the CTextField size to d
	 */
	public void setSize(Dimension d) {
		if(null == d) {
			setSize();
		}
		setPreferredSize(d);
		
	}

}
