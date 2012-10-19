/**
 * 
 */
package org.cssa.iface.transaction;

import java.util.List;

import org.cssa.iface.bo.TimeSchedule;
import org.cssa.iface.exception.IfaceException;

/**
 * @author ajith
 *
 */
public class TimeScheduleTransaction implements Transaction<TimeSchedule> {

	@Override
	public int save(TimeSchedule object) throws IfaceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TimeSchedule load(TimeSchedule object) throws IfaceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimeSchedule> loadAll() throws IfaceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(TimeSchedule object) throws IfaceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(TimeSchedule object) throws IfaceException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public TimeSchedule load(int id) {
		return null;
		
	}

	

}
