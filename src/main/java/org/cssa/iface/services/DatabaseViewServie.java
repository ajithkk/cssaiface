/**
 * 
 */
package org.cssa.iface.services;

import java.util.List;

/**
 * @author ajith
 *
 */
public interface DatabaseViewServie<T> {
	
	public void setData(List<T> data);
	public List<T> getData();

}
