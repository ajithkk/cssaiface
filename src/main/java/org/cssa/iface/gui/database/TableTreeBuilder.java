/**
 * 
 */
package org.cssa.iface.gui.database;

import java.util.Map;
import java.util.Set;

import org.cssa.iface.util.TableStoreXML;

/**
 * @author ajith
 *
 */
public class TableTreeBuilder implements  TableTreeNodeTypes {
	
	public static TableItemNode build() {
		TableItemNode rootNode = new TableItemNode("Database");
		TableItemNode tableNode = new TableItemNode("Tables");
		TableStoreXML tableStoreXML = new TableStoreXML();
		Map<String, String> tableMap = tableStoreXML.getTableStoreMap();
		Set<Map.Entry<String, String>> tableMapSet = tableMap.entrySet();
		
		for(Map.Entry<String, String> table: tableMapSet) {
			TableItemNode tableNames = new TableItemNode(table.getKey());
			tableNode.addChild(tableNames);
		}
		rootNode.addChild(tableNode);
		return rootNode;
		
	}

}
