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
	private TransactioUtils transactioUtils;

	@Override
	public int save(InsertResult object) throws IfaceException {
		
		return 0;
	}

	@Override
	public InsertResult load(InsertResult object) throws IfaceException {
		
		return null;
	}

	@Override
	public List<InsertResult> loadAll() throws IfaceException {
		return load(new Winners());
	}

	@Override
	public int update(InsertResult object) throws IfaceException {
		int result = -1;
		DBEngineImpl dbEngineImpl = new DBEngineImpl();
		transactioUtils = new TransactioUtils();
		if(null != object) {
			Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
			parameterMap.put(1, object.getEventStatus());
			parameterMap.put(2, object.getMark());
			parameterMap.put(3, object.getEventName());
			parameterMap.put(4, object.getEventStatus());
			parameterMap.put(5, object.getGroupName());
			result = dbEngineImpl.executeUpdate(parameterMap, CSSAQuery.UPDATE_WINNERS);
		}
		return result;
	}

	@Override
	public int delete(InsertResult object) throws IfaceException {
		int result = -1;
		DBEngineImpl dbEngineImpl = new DBEngineImpl();
		transactioUtils = new TransactioUtils();
		List<InsertResult> resultWinners = null;
		float clgPoint = 0;
		float stdPoint = 0;
		if(null != object) {
			Winners winner = new Winners();
			winner.setEventId(object.getEventName());
			winner.setWinnerStatus(object.getEventStatus());
		    resultWinners = load(winner);
			
			Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
			parameterMap.put(1, object.getEventName());
			parameterMap.put(2, object.getEventStatus());
			parameterMap.put(3, object.getGroupName());
			result = dbEngineImpl.executeUpdate(parameterMap, CSSAQuery.DELETE_WINNER);
			
			if(object.getEventStatus().toUpperCase().equals("FIRST")){
				clgPoint = 5;
			} else {
				clgPoint = 2.5f;
			}
			transactioUtils.insertCollegePoint(clgPoint, resultWinners.get(0), true);
			stdPoint = clgPoint/resultWinners.size();
			transactioUtils.insertStudentPoint(stdPoint, resultWinners, true);
			
		}
		return result;
	}
	
	public int[] saveAll(List<InsertResult> insertResults, String position) throws IfaceException {
		
		int[]  result = null;
		float teamPoint = 0;
		float collegePoint = 0;
		Map<Integer, Object> parameterMap;
		DBEngineImpl dbEngineImpl = new DBEngineImpl();
		eventsTransaction = new EventsTransaction();
		transactioUtils = new TransactioUtils();
		InsertResult insertResult = insertResults.get(0);
		parameterMap = new HashMap<Integer, Object>();
		if(null == position) {
			position = insertResult.getEventStatus();
		}
		parameterMap.put(1, position);
		parameterMap.put(2, insertResult.getEventName());
		
		ResultSet res = dbEngineImpl.executeQuery(parameterMap, CSSAQuery.SELECT_WINNERS);
		try {
			if(!res.next()) {
			
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
			
			result = dbEngineImpl.executeBatch(parameterList, CSSAQuery.INSERT_WINNERS);
			collegePoint = eventsTransaction.load(insertResults.get(0).getEventName()).getPoints();
			teamPoint = collegePoint / insertResults.size();
			
			transactioUtils.insertCollegePoint(collegePoint, insertResults.get(0), false);
			transactioUtils.insertStudentPoint(teamPoint, insertResults, false);
			} else {
				throw new IfaceException("Result of "+position+ "is already inserted");
			}
		} catch (SQLException e) {
			throw new IfaceException(e);
		} finally {
			dbEngineImpl.closeResultSet(res);
		}
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
