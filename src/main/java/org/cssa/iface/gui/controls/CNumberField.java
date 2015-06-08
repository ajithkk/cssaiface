package org.cssa.iface.gui.controls;

import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.text.Document;
/**
 * 
 * @author ajith
 * @since 1/27/2012
 */

public class CNumberField extends JTextField {

	private Dimension d = null;

	/**
	 * 
	 */
	public CNumberField() {
		super();
		setSize();
	}

	/**
	 * @param doc
	 * @param text
	 * @param columns
	 */
	public CNumberField(Document doc, String text, int columns) {
		super(doc, text, columns);
		setSize();
	}

	/**
	 * @param columns
	 */
	public CNumberField(int columns) {
		super(columns);
		setSize();
	}

	/**
	 * @param text
	 * @param columns
	 */
	public CNumberField(String text, int columns) {
		super(text, columns);
		setSize();
	}

	/**
	 * @param text
	 */
	public CNumberField(String text) {
		super(text);
		setSize();
	}
	
	/**
	 * Set the default size to the CNumberFiels
	 */
	public void setSize() {
		if(null == d) {
			d  = new Dimension(150,23);
		}
		
	}
	/**
	 * Set the CNumberField size to d
	 */
	public void setSize(Dimension d) {
		if(null == d) {
			setSize();
		}
		setPreferredSize(d);
		
	}


}
