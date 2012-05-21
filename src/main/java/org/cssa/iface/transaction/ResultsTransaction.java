/**
 * 
 */
package org.cssa.iface.transaction;

import java.util.List;

import org.cssa.iface.bo.Results;
import org.cssa.iface.exception.IfaceException;

/**
 * @author KK
 * @since 12/31/2011
 */
public class ResultsTransaction implements Transaction<Results> {

	@Override
	public int save(Results object) throws IfaceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Results load(Results object) throws IfaceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Results> loadAll() throws IfaceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Results object) throws IfaceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Results object) throws IfaceException {
		// TODO Auto-generated method stub
		return 0;
	}

}
