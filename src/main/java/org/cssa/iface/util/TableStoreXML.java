/**
 * 
 */
package org.cssa.iface.util;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.cssa.iface.bo.TableStore;

/**
 * @author ajith
 *
 */
public class TableStoreXML {
	private static final Logger log = Util.getLogger(TableStoreXML.class);
	private static final String TABLE_DETAILS_XML = "interface_table.xml";
	private TableStore tableStore;
	private Map<String, String> tableStoreMap;
	
	public TableStoreXML() {
		init();
	}

	private void init() {
		try{
			tableStoreMap = new HashMap<String, String>();
			JAXBContext context = JAXBContext
					.newInstance(TableStore.class);
			Unmarshaller um = context.createUnmarshaller();
			URL url = this.getClass().getClassLoader().getResource(TABLE_DETAILS_XML);
			tableStore = (TableStore) um.unmarshal(url);
			int size = tableStore.getTableDetailsList().size();
			for(int i = 0; i < size; i++) {
				tableStoreMap.put(tableStore.getTableDetailsList().get(i).getTableName(), tableStore.getTableDetailsList().get(i).getScriptFile());
			}
		} catch (JAXBException e) {
			log.error(e);
		}
	}

	
	/**
	 * @return the tableStore
	 */
	public TableStore getTableStore() {
		return tableStore;
	}

	/**
	 * @param tableStore the tableStore to set
	 */
	public void setTableStore(TableStore tableStore) {
		this.tableStore = tableStore;
	}

	/**
	 * @return the tableStoreMap
	 */
	public Map<String, String> getTableStoreMap() {
		return tableStoreMap;
	}

	/**
	 * @param tableStoreMap the tableStoreMap to set
	 */
	public void setTableStoreMap(Map<String, String> tableStoreMap) {
		this.tableStoreMap = tableStoreMap;
	}
	
	

}
