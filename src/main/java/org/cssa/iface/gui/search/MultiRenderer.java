package org.cssa.iface.gui.search;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class MultiRenderer extends BasicComboBoxRenderer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SearchTableController controller;
	/**
	 * @param controller
	 */
	public MultiRenderer(SearchTableController controller) {
		super();
		this.controller = controller;
	}
	
	@Override
	public Component getListCellRendererComponent(JList list,  
            Object value,  
            int index,  
            boolean isSelected,  
            boolean cellHasFocus)  {
		
		if(controller.isSelected(value)) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		
		setFont(list.getFont());
				
		if (value instanceof Icon) {  
            setIcon((Icon)value);  
        } else {  
            setText((value == null) ? "" : value.toString());  
        } 
		
		return this;
		
	}
	

}
