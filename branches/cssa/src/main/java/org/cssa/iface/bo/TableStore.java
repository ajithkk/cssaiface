/**
 * 
 */
package org.cssa.iface.bo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ajith
 *
 */
@XmlRootElement( name ="cssa", namespace = " org.cssa.iface.bo" )
public class TableStore {
	
	@XmlElement(name = "table")
	private ArrayList<Table> tableList;

	/**
	 * @return the tableList
	 */
	public ArrayList<Table> getTableDetailsList() {
		return tableList;
	}

	/**
	 * @param tableList the tableList to set
	 */
	public void setTableDetailsList(ArrayList<Table> tableList) {
		this.tableList = tableList;
	}
	
	

}
