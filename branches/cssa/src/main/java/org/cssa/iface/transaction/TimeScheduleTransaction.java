/**
 * 
 */
package org.cssa.iface.transaction;

import java.util.List;

import org.cssa.iface.bo.TimeSechedule;
import org.cssa.iface.exception.IfaceException;

/**
 * @author ajith
 *
 */
public class TimeScheduleTransaction implements Transaction<TimeSechedule> {

	@Override
	public int save(TimeSechedule object) throws IfaceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TimeSechedule load(TimeSechedule object) throws IfaceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimeSechedule> loadAll() throws IfaceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(TimeSechedule object) throws IfaceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(TimeSechedule object) throws IfaceException {
		// TODO Auto-generated method stub
		return 0;
	}

}
