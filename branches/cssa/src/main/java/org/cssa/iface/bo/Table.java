package org.cssa.iface.bo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author ajith
 *
 */
@XmlRootElement(name = "table")
@XmlType(propOrder = {"tableName", "scriptFile"})
public class Table {
	
	private String tableName;
	private String scriptFile;
	
	/**
	 * @return the tableName
	 */
	@XmlElement(name = "tableName")
	public String getTableName() {
		return tableName;
	}
	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	/**
	 * @return the scriptFile
	 */
	public String getScriptFile() {
		return scriptFile;
	}
	/**
	 * @param scriptFile the scriptFile to set
	 */
	public void setScriptFile(String scriptFile) {
		this.scriptFile = scriptFile;
	}
	
	
	

}
