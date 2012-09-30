package org.cssa.iface.transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cssa.iface.bo.InsertResult;
import org.cssa.iface.dao.dbengine.DBEngineImpl;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.infrastructure.CSSAQuery;

public class WinnerTransaction implements Transaction<InsertResult>{
	
	private EventsTransaction eventsTransaction;

	@Override
	public int save(InsertResult object) throws IfaceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public InsertResult load(InsertResult object) throws IfaceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InsertResult> loadAll() throws IfaceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(InsertResult object) throws IfaceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(InsertResult object) throws IfaceException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int[] saveAll(List<InsertResult> insertResults) throws IfaceException {
		
		int[]  result;
		double teamPoint = 0;
		double collegePoint = 0;
	
		DBEngineImpl dbEngineImpl = new DBEngineImpl();
		eventsTransaction = new EventsTransaction();
		
		Map<Integer, Object> parameterMap;
		List<Map<Integer, Object>> parameterList = new ArrayList<Map<Integer,Object>>();
		for(InsertResult inResult : insertResults) {
			parameterMap = new HashMap<Integer, Object>();
			parameterMap.put(1, inResult.getCollegeId());
			parameterMap.put(2, inResult.getStudentId());
			parameterMap.put(3, inResult.getEventName());
			parameterMap.put(4, inResult.getEventStatus());
			parameterMap.put(5, inResult.getGroupName());
			parameterMap.put(6, inResult.getMark());
			parameterList.add(parameterMap);
			
		}
		
		dbEngineImpl.executeBatch(parameterList, CSSAQuery.INSERT_WINNERS);
		collegePoint = eventsTransaction.load(insertResults.get(0).getEventName()).getPoints();
		teamPoint = collegePoint / insertResults.size();
		
		Map<Integer, Object> collegePointMap = new HashMap<Integer, Object>();
		collegePointMap.put(1, collegePoint);
		collegePointMap.put(2, insertResults.get(0).getCollegeId());
		
		dbEngineImpl.executeQuery(collegePointMap, CSSAQuery.INSERT_COLLEGE_POINTS);
		Map<Integer, Object> studentPoint;
		List<Map<Integer, Object>> studentList = new ArrayList<Map<Integer,Object>>();
		
		for(InsertResult result2 : insertResults) {
			studentPoint = new HashMap<Integer, Object>();
			studentPoint.put(1, teamPoint);
			studentPoint.put(2, result2.getStudentId());
			studentList.add(studentPoint);
		}
		
		dbEngineImpl.executeBatch(studentList, CSSAQuery.INSERT_STTUDENT_POINTS);
		
		
		return null;
		
	}

}
