/**
 * 
 */
package org.cssa.iface.gui.menu;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * @author ajith
 *
 */
public class CssaMenuItem extends JMenuItem {
	
	private String name;
	private Icon icon;
	private boolean mnuVisible;
	private boolean mnuEnabled;

	/**
	 * @param name
	 * @param icon
	 * @param mnuVisible
	 * @param mnuEnabled
	 */
	public CssaMenuItem(String name, Icon icon, boolean mnuVisible,
			boolean mnuEnabled) {
		super();
		this.name = name;
		this.icon = icon;
		this.mnuVisible = mnuVisible;
		this.mnuEnabled = mnuEnabled;
	}

	/**
	 * @param icon
	 */
	public CssaMenuItem(Icon icon) {
		super(icon);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param text
	 * @param icon
	 */
	public CssaMenuItem(String text, Icon icon) {
		super(text, icon);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param text
	 * @param mnemonic
	 */
	public CssaMenuItem(String text, int mnemonic) {
		super(text, mnemonic);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public CssaMenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param a
	 */
	public CssaMenuItem(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param s
	 */
	public CssaMenuItem(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the icon
	 */
	public Icon getIcon() {
		return icon;
	}

	/**
	 * @param icon the icon to set
	 */
	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	/**
	 * @return the mnuVisible
	 */
	public boolean isMnuVisible() {
		return mnuVisible;
	}

	/**
	 * @param mnuVisible the mnuVisible to set
	 */
	public void setMnuVisible(boolean mnuVisible) {
		this.mnuVisible = mnuVisible;
	}

	/**
	 * @return the mnuEnabled
	 */
	public boolean isMnuEnabled() {
		return mnuEnabled;
	}

	/**
	 * @param mnuEnabled the mnuEnabled to set
	 */
	public void setMnuEnabled(boolean mnuEnabled) {
		this.mnuEnabled = mnuEnabled;
	}

}
