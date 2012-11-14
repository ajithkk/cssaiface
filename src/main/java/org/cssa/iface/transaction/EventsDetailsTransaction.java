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
		List<EventDetails> eventDetails = new ArrayList<EventDetails>();
		dbEngineImpl = new DBEngineImpl();
		
		try{
			res = dbEngineImpl.executeQuery(CSSAQuery.SELECT_ALL_PARTICIPANTS_DETAILS);
			while(res.next()) {
				EventDetails eDetails = new EventDetails();
				eDetails.setSno(res.getInt(CSSAConstants.EVENT_DETAILS_SNO));
				eDetails.setCollegeId(res.getString(CSSAConstants.EVENT_DETAILS_COLLEGE_ID));
				eDetails.setEventId(res.getString(CSSAConstants.EVENT_DETAILS_EVENT_ID));
				eDetails.setGroupId(res.getString(CSSAConstants.EVENT_DETAILS_GROUP_ID));
				eDetails.setStudentId(res.getString(CSSAConstants.EVENT_DETAILS_STUDENT_ID));
				eventDetails.add(eDetails);
			}
		}catch (Exception e) {
			throw new IfaceException(e);
		}
		return eventDetails;
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
	
	public int[] deleteAll(List<EventDetails> eventDetails) throws IfaceException {
		dbEngineImpl = new DBEngineImpl();
		int[] result;
		List<Map<Integer, Object>> batchParameterList = new ArrayList<Map<Integer,Object>>();
		for(EventDetails event : eventDetails) {
			Map<Integer, Object> parameter = new HashMap<Integer, Object>();
			parameter.put(1, event.getCollegeId());
			parameter.put(2, event.getEventId());
			parameter.put(3, event.getGroupId());
			parameter.put(4, event.getStudentId());
			batchParameterList.add(parameter);
		}
		result = dbEngineImpl.executeBatch(batchParameterList, CSSAQuery.DELETE_GROUP_EVENT_DETAILS);
		return result;
	}
	
	public List<EventDetails> loadAll(EventDetails details) throws IfaceException {
		List<EventDetails> eventDetails = new ArrayList<EventDetails>();
		dbEngineImpl = new DBEngineImpl();
		
		Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
		parameterMap.put(1, details.getCollegeId());
		parameterMap.put(2, details.getEventId());
		parameterMap.put(3, details.getGroupId());
		try{
			res = dbEngineImpl.executeQuery(parameterMap, CSSAQuery.SELECT_EVENT_PARTICIPANTS );
			while(res.next()) {
				EventDetails eDetails = new EventDetails();
				eDetails.setCollegeId(res.getString(CSSAConstants.EVENT_DETAILS_COLLEGE_ID));
				eDetails.setEventId(res.getString(CSSAConstants.EVENT_DETAILS_EVENT_ID));
				eDetails.setGroupId(res.getString(CSSAConstants.EVENT_DETAILS_GROUP_ID));
				eDetails.setStudentId(res.getString(CSSAConstants.EVENT_DETAILS_STUDENT_ID));
				eventDetails.add(eDetails);
			}
		}catch (Exception e) {
			throw new IfaceException(e);
		} finally {
			dbEngineImpl.closeResultSet(res);
		}
		return eventDetails;
		
	}
	
	public List<EventDetails> selectEventParticipants(EventDetails details) throws IfaceException {
		List<EventDetails> eventDetails = new ArrayList<EventDetails>();
		dbEngineImpl = new DBEngineImpl();
		
		Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
		parameterMap.put(1, details.getCollegeId());
		parameterMap.put(2, details.getEventId());
		try{
			res = dbEngineImpl.executeQuery(parameterMap, CSSAQuery.SELECT_PARTICIPANTS_IN_EVENT );
			while(res.next()) {
				EventDetails eDetails = new EventDetails();
				eDetails.setCollegeId(res.getString(CSSAConstants.EVENT_DETAILS_COLLEGE_ID));
				eDetails.setEventId(res.getString(CSSAConstants.EVENT_DETAILS_EVENT_ID));
				eDetails.setGroupId(res.getString(CSSAConstants.EVENT_DETAILS_GROUP_ID));
				eDetails.setStudentId(res.getString(CSSAConstants.EVENT_DETAILS_STUDENT_ID));
				eventDetails.add(eDetails);
			}
		}catch (Exception e) {
			throw new IfaceException(e);
		} finally {
			dbEngineImpl.closeResultSet(res);
		}
		return eventDetails;
	}

}
