/**
 * 
 */
package org.cssa.iface.transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cssa.iface.bo.Events;
import org.cssa.iface.bo.InsertResult;
import org.cssa.iface.bo.InsertResultsTableBo;
import org.cssa.iface.bo.Results;
import org.cssa.iface.dao.dbengine.DBEngineImpl;
import org.cssa.iface.exception.IfaceException;
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
}
