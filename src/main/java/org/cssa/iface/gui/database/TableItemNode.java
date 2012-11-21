/**
 * 
 */
package org.cssa.iface.gui.database;

import java.util.Enumeration;
import java.util.Vector;

import javax.swing.tree.TreeNode;

/**
 * @author ajith
 *
 */
public class TableItemNode implements TreeNode {
	
	private String title;
	
	private int type;
	private Vector<TreeNode> children = new Vector<TreeNode>();
	private TreeNode parent;
	
	

	/**
	 * @param title
	 */
	public TableItemNode(String title) {
		this.title = title;
	}

	/**
	 * @param title
	 * @param type
	 */
	public TableItemNode(String title, int type) {
		this.title = title;
		this.type = type;
	}

	public void addChild(TreeNode child) {
		children.add(child);
	}
	
	@Override
	public TreeNode getChildAt(int childIndex) {
		return children.elementAt(childIndex);
	}

	@Override
	public int getChildCount() {
		return children.size();
	}

	@Override
	public TreeNode getParent() {
		return this.parent;
	}

	@Override
	public int getIndex(TreeNode node) {
		return children.indexOf(node);
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public boolean isLeaf() {
		return (children.size() == 0);
	}

	@Override
	public Enumeration<TreeNode> children() {
		return children.elements();
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
	
	public String toString() {
		return title;
	}

}
