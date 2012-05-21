/**
 * 
 */
package org.cssa.iface.transaction;

import java.util.List;

import org.cssa.iface.bo.EventDetails;
import org.cssa.iface.exception.IfaceException;

/**
 * @author KK
 * @since 12/31/2011
 *
 */
public class EventsDetailsTransaction  implements Transaction<EventDetails>{

	@Override
	public int save(EventDetails object) throws IfaceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EventDetails load(EventDetails object) throws IfaceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EventDetails> loadAll() throws IfaceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(EventDetails object) throws IfaceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(EventDetails object) throws IfaceException {
		// TODO Auto-generated method stub
		return 0;
	}

}
