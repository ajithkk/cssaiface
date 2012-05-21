/**
 * 
 */
package org.cssa.iface.transaction;

import java.util.List;

import org.cssa.iface.exception.IfaceException;

/**
 * @author Ajith
 *
 */
public interface Transaction<T> {
	int save(T object) throws IfaceException ;
	T load(T object) throws IfaceException;
	List<T> loadAll() throws IfaceException;
	int update(T object)throws IfaceException;
	int delete(T object)throws IfaceException ;
	

}
