/**
 * 
 */
package org.cssa.iface.transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cssa.iface.bo.TimeSheet;
import org.cssa.iface.dao.dbengine.DBEngineImpl;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.infrastructure.CSSAConstants;
import org.cssa.iface.infrastructure.CSSAQuery;

/**
 * @author ajith
 *
 */
public class TimeSheetTransaction implements Transaction<TimeSheet> {

	private DBEngineImpl dbEngineImpl;
	private ResultSet res = null;
	
	public TimeSheetTransaction() {
		dbEngineImpl = new DBEngineImpl();
	}
	
	@Override
	public int save(TimeSheet object) throws IfaceException {
		int resultId = CSSAConstants.FAIL;
		Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
		if(null != object) {
			parameterMap.put(1, object.getDate());
			
			resultId = dbEngineImpl.executeUpdate(parameterMap, CSSAQuery.INSERT_TIME_SHEET_ADD);
		}
		return resultId;
	}

	@Override
	public TimeSheet load(TimeSheet object) throws IfaceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimeSheet> loadAll() throws IfaceException {
		
		List<TimeSheet> timeSheetsList = new ArrayList<TimeSheet>();
		
		res = dbEngineImpl.executeQuery(CSSAQuery.SELECT_TIMESHEET);
		
		try {
			while (res.next()) {
				TimeSheet time = new TimeSheet();
				time.setSno(res.getInt(CSSAConstants.TIMESHEET_SNO));
				time.setDate(res.getDate(CSSAConstants.TIMESHEET_DAY));
				time.setEndTime(res.getString(CSSAConstants.TIMESHEET_END_TIME));
				time.setStartTime(res.getString(CSSAConstants.TIMESHEET_START_TIME));
				time.setEventId(res.getString(CSSAConstants.TIMESHEET_EVENT_ID));
				time.setEventStage(res.getString(CSSAConstants.TIMESHEET_EVENT_STAGE));
				time.setVenue(res.getString(CSSAConstants.TIMESHEET_VENUE));
				timeSheetsList.add(time);
				
			}
		} catch (SQLException e) {
			throw new IfaceException(e);
		} finally {
			dbEngineImpl.closeResultSet(res);
		}
		return timeSheetsList;
	}

	@Override
	public int update(TimeSheet object) throws IfaceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(TimeSheet object) throws IfaceException {
		Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
		int resultId = -1;
		
		parameterMap.put(1, object.getSno());
		resultId = dbEngineImpl.executeUpdate(parameterMap, CSSAQuery.DELETE_TIMESHEET);
		
		return resultId;
	}
	
	public TimeSheet load(int id) {
		return null;
		
	}
	
	public List<TimeSheet> loadAll(TimeSheet timeSheet) throws IfaceException {
		
		List<TimeSheet> timeSheetsList = new ArrayList<TimeSheet>();
		Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
		parameterMap.put(1, timeSheet.getDate());
		
		res = dbEngineImpl.executeQuery(parameterMap, CSSAQuery.SELECT_TIMESHEET_BY_DATE);
		
		try {
			while (res.next()) {
				TimeSheet time = new TimeSheet();
				time.setSno(res.getInt(CSSAConstants.TIMESHEET_SNO));
				time.setDate(res.getDate(CSSAConstants.TIMESHEET_DAY));
				time.setEndTime(res.getString(CSSAConstants.TIMESHEET_END_TIME));
				time.setStartTime(res.getString(CSSAConstants.TIMESHEET_START_TIME));
				time.setEventId(res.getString(CSSAConstants.TIMESHEET_EVENT_ID));
				time.setEventStage(res.getString(CSSAConstants.TIMESHEET_EVENT_STAGE));
				time.setVenue(res.getString(CSSAConstants.TIMESHEET_VENUE));
				timeSheetsList.add(time);
				
			}
		} catch (SQLException e) {
			throw new IfaceException(e);
		} finally {
			dbEngineImpl.closeResultSet(res);
		}
		return timeSheetsList;
	}

	public int[] update(List<TimeSheet> timeSheetList) throws IfaceException {
		int[] results;
		List<Map<Integer, Object>> parameterMapList = new ArrayList<Map<Integer,Object>>();
		for(TimeSheet timeSheet : timeSheetList) {
			Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
			String endTime = timeSheet.getEndTime() == null ? " " : timeSheet.getEndTime(); 
			String startTime = timeSheet.getStartTime() == null ? " " : timeSheet.getStartTime();
			String eventId = timeSheet.getEventId() == null ? " " : timeSheet.getEventId();
			String eventStage = timeSheet.getEventStage() == null ? " " : timeSheet.getEventStage();
			String venue = timeSheet.getVenue() == null ? " " : timeSheet.getVenue();
			parameterMap.put(1, startTime);
			parameterMap.put(2, endTime);
			parameterMap.put(3, eventId);
			parameterMap.put(4, eventStage);
			parameterMap.put(5, venue);
			parameterMap.put(6, timeSheet.getSno());
			parameterMapList.add(parameterMap);
			
		}
		results = dbEngineImpl.executeBatch(parameterMapList, CSSAQuery.UPDATE_TIMESHEET_BY_DATE);
		return results;
	}


}
