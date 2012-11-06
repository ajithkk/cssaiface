package org.cssa.iface.transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cssa.iface.bo.InsertResult;
import org.cssa.iface.bo.Winners;
import org.cssa.iface.dao.dbengine.DBEngineImpl;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.infrastructure.CSSAConstants;
import org.cssa.iface.infrastructure.CSSAQuery;
import org.cssa.iface.services.QueryServices;

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
		int result = -1;
		DBEngineImpl dbEngineImpl = new DBEngineImpl();
		if(null != object) {
			Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
			parameterMap.put(1, object.getEventName());
			parameterMap.put(2, object.getEventStatus());
			parameterMap.put(3, object.getGroupName());
			result = dbEngineImpl.executeUpdate(parameterMap, CSSAQuery.DELETE_WINNER);
			
		}
		return result;
	}
	
	public int[] saveAll(List<InsertResult> insertResults, String position) throws IfaceException {
		
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
			if(null == position) {
				position = inResult.getEventStatus();
			}
			parameterMap.put(4, position);
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
		
		dbEngineImpl.executeUpdate(collegePointMap, CSSAQuery.INSERT_COLLEGE_POINTS);
		Map<Integer, Object> studentPoint;
		List<Map<Integer, Object>> studentList = new ArrayList<Map<Integer,Object>>();
		
		for(InsertResult result2 : insertResults) {
			studentPoint = new HashMap<Integer, Object>();
			studentPoint.put(1, teamPoint);
			studentPoint.put(2, result2.getStudentId());
			studentList.add(studentPoint);
		}
		
		 result = dbEngineImpl.executeBatch(studentList, CSSAQuery.INSERT_STTUDENT_POINTS);
		
		
		return result;
		
	}
	
	public List<InsertResult> load(Winners winner) throws IfaceException {
		DBEngineImpl dbEngineImpl = new DBEngineImpl();
		String sqlCammand = QueryServices.getSingleWinnersDetails(winner);
		ResultSet res = dbEngineImpl.executeQuery(sqlCammand);
		List<InsertResult> insertResults = new ArrayList<InsertResult>();
		try {
			while(res.next()) {
				InsertResult insertResult = new InsertResult();
				insertResult.setEventName(res.getString(CSSAConstants.EVENT_DETAILS_EVENT_ID));
				insertResult.setStudentId(res.getString(CSSAConstants.WINNERS_STUDENT_ID));
				insertResult.setCollegeId(res.getString(CSSAConstants.WINNERS_COLLEGE_ID));
				insertResult.setGroupName(res.getString(CSSAConstants.WINNERS_EVENT_GROUP_ID));
				insertResult.setMark(res.getFloat(CSSAConstants.WINNERS_MARK));
				insertResult.setEventStatus(res.getString(CSSAConstants.WINNERS_RESULT_STATUS));
				insertResult.setStudentName(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME));
				insertResult.setStudentPhone(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE));
				insertResults.add(insertResult);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IfaceException(e);
		} finally { 
			dbEngineImpl.closeResultSet(res);
			
		}
		
		return insertResults;
	}
	

}
