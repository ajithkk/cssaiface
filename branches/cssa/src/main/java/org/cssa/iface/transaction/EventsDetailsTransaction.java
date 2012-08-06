/**
 * 
 */
package org.cssa.iface.transaction;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cssa.iface.bo.EventDetails;
import org.cssa.iface.dao.dbengine.DBEngineImpl;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.infrastructure.CSSAConstants;
import org.cssa.iface.infrastructure.CSSAQuery;

/**
 * @author KK
 * @since 12/31/2011
 *
 */
public class EventsDetailsTransaction  implements Transaction<EventDetails>{

	
	private ResultSet res;
	private DBEngineImpl dbEngineImpl;
	@Override
	public int save(EventDetails object) throws IfaceException {
		int resultId = CSSAConstants.FAIL;
		dbEngineImpl = new DBEngineImpl();
		Map<Integer, Object> parameter = new HashMap<Integer, Object>();
		parameter.put(1, object.getStudentId());
		parameter.put(2, object.getGroupId());
		parameter.put(3, object.getEventId());
		parameter.put(4, object.getCollegeId());
		resultId = dbEngineImpl.executeUpdate(parameter, CSSAQuery.INSERT_EVENT_DETAILS);
		return resultId;
	}

	@Override
	public EventDetails load(EventDetails object) throws IfaceException {
		
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
	
	public int[] saveAll(List<EventDetails> eventDetails) throws IfaceException {
		dbEngineImpl = new DBEngineImpl();
		int[] result;
		List<Map<Integer, Object>> batchParameterList = new ArrayList<Map<Integer,Object>>();
		for(EventDetails event : eventDetails) {
			Map<Integer, Object> parameter = new HashMap<Integer, Object>();
			parameter.put(1, event.getStudentId());
			parameter.put(2, event.getGroupId());
			parameter.put(3, event.getEventId());
			parameter.put(4, event.getCollegeId());
			batchParameterList.add(parameter);
		}
		result = dbEngineImpl.executeBatch(batchParameterList, CSSAQuery.INSERT_EVENT_DETAILS);
		return result;
	}
	
	public int[] updateAll(List<EventDetails> eventDetails) throws IfaceException {
		dbEngineImpl = new DBEngineImpl();
		int[] result;
		List<Map<Integer, Object>> batchParameterList = new ArrayList<Map<Integer,Object>>();
		for(EventDetails event : eventDetails) {
			Map<Integer, Object> parameter = new HashMap<Integer, Object>();
			parameter.put(1, event.getStudentId());
			parameter.put(2, event.getGroupId());
			parameter.put(3, event.getEventId());
			parameter.put(4, event.getCollegeId());
			batchParameterList.add(parameter);
		}
		result = dbEngineImpl.executeBatch(batchParameterList, CSSAQuery.INSERT_EVENT_DETAILS);
		return result;
		
	}

}
