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
import org.cssa.iface.bo.Events;
import org.cssa.iface.bo.InsertResult;
import org.cssa.iface.bo.InsertResultsTableBo;
import org.cssa.iface.bo.Results;
import org.cssa.iface.dao.dbengine.DBEngineImpl;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.infrastructure.CSSAConstants;
import org.cssa.iface.infrastructure.CSSAQuery;

/**
 * @author KK
 * @since 12/31/2011
 */
public class ResultsTransaction implements Transaction<Results> {
	
    private EventsTransaction eventsTransaction;
    private TransactioUtils transactionUtils;
    private DBEngineImpl dbEngineImpl;
    
	@Override
	public int save(Results object) throws IfaceException {
		
		transactionUtils = new TransactioUtils();
		eventsTransaction = new EventsTransaction();
		Events events = new Events();
		dbEngineImpl = new DBEngineImpl();
		
		
		Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
		List<Map<Integer, Object>> parameterList = new ArrayList<Map<Integer,Object>>();
		
		events.setEventId(object.getEventId());
		events = eventsTransaction.load(events);
		
		if(events.getMaxNoOfParticipants() > 1 ) {
			
			List<InsertResultsTableBo> resultsTableBos = new ArrayList<InsertResultsTableBo>();
			resultsTableBos = transactionUtils.getGroupResult(object);
			
			for(InsertResultsTableBo insertResultsTableBo : resultsTableBos) {
				parameterMap = new HashMap<Integer, Object>();;
				parameterMap.put(1, insertResultsTableBo.getCollegeId());
				parameterMap.put(2, insertResultsTableBo.getStudentId());
				parameterMap.put(3, insertResultsTableBo.getEventId());
				parameterMap.put(4, object.getEventStatus());
				parameterMap.put(5, object.getMark());
				parameterList.add(parameterMap);
				
			}
		} else {
			parameterMap.put(1, object.getCollegeId());
			parameterMap.put(2, object.getStudentId());
			parameterMap.put(3, object.getEventId());
			parameterMap.put(4, object.getEventStatus());
			parameterMap.put(5, object.getMark());
			parameterList.add(parameterMap);
		} 

		try{
			int[] result = dbEngineImpl.executeBatch(parameterList, CSSAQuery.INSERT_RESULT);
		}catch (Exception e) {
			throw new IfaceException(e);
		}
		
		return 0;
	}

	@Override
	public Results load(Results object) throws IfaceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Results> loadAll() throws IfaceException {
		ResultSet res;
		List<Results> results = new ArrayList<Results>();
		dbEngineImpl = new DBEngineImpl();
		
		try{
			res = dbEngineImpl.executeQuery(CSSAQuery.SELECT_RESULT_TABLE);
			while(res.next()) {
				Results eDetails = new Results();
				eDetails.setSno(res.getInt(CSSAConstants.EVENT_DETAILS_SNO));
				eDetails.setCollegeId(res.getString(CSSAConstants.EVENT_DETAILS_COLLEGE_ID));
				eDetails.setEventId(res.getString(CSSAConstants.EVENT_DETAILS_EVENT_ID));
				eDetails.setStudentId(res.getString(CSSAConstants.EVENT_DETAILS_STUDENT_ID));
				eDetails.setEventStatus(res.getString(CSSAConstants.RESULTS_RESULT_STATUS));
				eDetails.setMark(res.getFloat(CSSAConstants.RESULTS_MARK));
				eDetails.setGroupId(res.getString(CSSAConstants.RESULTS_EVENT_GROUP_ID));
				
				results.add(eDetails);
			}
		}catch (Exception e) {
			throw new IfaceException(e);
		}
		return results;
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

	public List<Results> loadAll(Results object) throws IfaceException {
		return null;
	}
	
	public int[] save(List<InsertResult> result, String eventStatus) throws IfaceException {
		dbEngineImpl = new DBEngineImpl();
		List<Map<Integer, Object>> batchParameterList = new ArrayList<Map<Integer,Object>>();
		for(InsertResult result2: result) {
			Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
			parameterMap.put(1, result2.getCollegeId());
			parameterMap.put(2, result2.getStudentId());
			parameterMap.put(3, result2.getEventName());
			parameterMap.put(4, eventStatus);
			parameterMap.put(5, result2.getGroupName());
			parameterMap.put(6, result2.getMark());
			batchParameterList.add(parameterMap);
		}
		int[] res = dbEngineImpl.executeBatch(batchParameterList, CSSAQuery.INSERT_RESULT);
		return res;
	}
	public int[] update(List<InsertResult> result, String eventStatus) throws IfaceException {
		dbEngineImpl = new DBEngineImpl();
		List<Map<Integer, Object>> batchParameterList = new ArrayList<Map<Integer,Object>>();
		for(InsertResult result2: result) {
			Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
			parameterMap.put(4, result2.getCollegeId());
			parameterMap.put(3, result2.getStudentId());
			parameterMap.put(5, result2.getEventName());
			parameterMap.put(1, eventStatus);
			parameterMap.put(2, result2.getMark());
			batchParameterList.add(parameterMap);
		}
		int[] res = dbEngineImpl.executeBatch(batchParameterList, CSSAQuery.UPDATE_RESULT);
		return res;
	}
	
}
