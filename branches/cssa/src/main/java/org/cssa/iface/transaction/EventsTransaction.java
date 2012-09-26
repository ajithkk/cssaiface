package org.cssa.iface.transaction;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cssa.iface.bo.Events;
import org.cssa.iface.dao.dbengine.DBEngineImpl;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.infrastructure.CSSAConstants;
import org.cssa.iface.infrastructure.CSSAQuery;

/**
 * 
 * @author KK
 * @since 12/12/2011
 */

public class EventsTransaction implements Transaction<org.cssa.iface.bo.Events> {

	private org.cssa.iface.bo.Events event;
	private ResultSet res;

	/**
	 * @param event
	 */
	public EventsTransaction(Events event) {
		super();
		this.event = event;
		this.res = null;

	}

	public EventsTransaction() {
		this.res = null;
	}


	@Override
	public int save(Events object) throws IfaceException {
		int resultId = CSSAConstants.FAIL;
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
		parameterMap.put(1, object.getEventId());
		parameterMap.put(2, object.getEventName());
		parameterMap.put(3, object.getMaxNoOfParticipants());
		parameterMap.put(4, object.getPoints());
		try {
			resultId = dbEngineImpl.executeUpdate(parameterMap, CSSAQuery.INSERT_EVENTS_TABLE);
		} catch (IfaceException e) {
			e.printStackTrace();
		} 
		return resultId;
	}

	@Override
	public Events load(Events object) throws IfaceException {
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		Map<Integer, Object> parameterMap = new  HashMap<Integer,Object>();
		parameterMap.put(1, object.getEventId());
		try {
			res = dbEngineImpl.executeQuery(parameterMap, CSSAQuery.SELECT_EVENTS_TABLE);
			if (res.next()) {
				event = new Events();
				event.setSno(res.getInt(CSSAConstants.EVENTS_SNO));
				event.setEventId(res.getString(CSSAConstants.EVENTS_EVENT_ID));
				event.setEventName(res.getString(CSSAConstants.EVENTS_EVENT_NAME));
				event.setMaxNoOfParticipants(res.getInt(CSSAConstants.EVENTS_MAX_NO_OF_PARTICIPANTS));
				event.setPoints(res.getInt(CSSAConstants.EVENTS_EVENT_POINT));
			}
			dbEngineImpl.closeResultSet(res);
		}catch (SQLException e) {
			// TODO: handle exception
		}finally {
			dbEngineImpl.closeResultSet(res);
		}
		return event;
	}

	@Override
	public List<Events> loadAll() throws IfaceException {
		List<Events> events = new ArrayList<Events>();
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		try {
			res = dbEngineImpl.executeQuery(CSSAQuery.SELECT_ALL_EVENTS_TABLE);
			while(res.next()) {
				Events event = new Events();
				event.setSno(res.getInt(CSSAConstants.EVENTS_SNO));
				event.setEventId(res.getString(CSSAConstants.EVENTS_EVENT_ID));
				event.setEventName(res.getString(CSSAConstants.EVENTS_EVENT_NAME));
				event.setMaxNoOfParticipants(res.getInt(CSSAConstants.EVENTS_MAX_NO_OF_PARTICIPANTS));
				event.setPoints(res.getInt(CSSAConstants.EVENTS_EVENT_POINT));
				events.add(event);
			}
			dbEngineImpl.closeResultSet(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbEngineImpl.closeResultSet(res);
		}

		return events;
	}

	@Override
	public int update(Events object) throws IfaceException {
		int resultId = CSSAConstants.FAIL;
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		Map<Integer, Object> parameterMap = new HashMap<Integer,Object>();
		
		parameterMap.put(1, object.getEventName());
		parameterMap.put(2, object.getMaxNoOfParticipants());
		parameterMap.put(3, object.getPoints());
		parameterMap.put(4, object.getEventId());
		try {
			resultId = dbEngineImpl.executeUpdate(parameterMap,CSSAQuery.UPDATE_EVENTS_TABLE);
			} catch (IfaceException e) {
				e.printStackTrace();
			}
		return resultId;
	}

	@Override
	public int delete(Events object) throws IfaceException {
		int resultId = CSSAConstants.FAIL;
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		Map<Integer, Object> parameterMap = new HashMap<Integer,Object>();
		parameterMap.put(1, object.getEventId());
		try {
			dbEngineImpl.executeUpdate(parameterMap, CSSAQuery.DELETE_EVENTS_TABLE);
		}catch (IfaceException e) {
			
		}
		return resultId;
	}
	
	public Events load(String eventId) throws IfaceException {
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		Map<Integer, Object> parameterMap = new  HashMap<Integer,Object>();
		parameterMap.put(1, eventId);
		try {
			res = dbEngineImpl.executeQuery(parameterMap, CSSAQuery.SELECT_EVENTS_TABLE);
			if (res.next()) {
				event = new Events();
				event.setSno(res.getInt(CSSAConstants.EVENTS_SNO));
				event.setEventId(res.getString(CSSAConstants.EVENTS_EVENT_ID));
				event.setEventName(res.getString(CSSAConstants.EVENTS_EVENT_NAME));
				event.setMaxNoOfParticipants(res.getInt(CSSAConstants.EVENTS_MAX_NO_OF_PARTICIPANTS));
				event.setPoints(res.getInt(CSSAConstants.EVENTS_EVENT_POINT));
			}
			dbEngineImpl.closeResultSet(res);
		}catch (SQLException e) {
			// TODO: handle exception
		}finally {
			dbEngineImpl.closeResultSet(res);
		}
		return event;
	}

}
