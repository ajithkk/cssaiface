package org.cssa.iface.transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.cssa.iface.bo.Events;
import org.cssa.iface.bo.InsertResult;
import org.cssa.iface.bo.InsertResultsTableBo;
import org.cssa.iface.bo.Results;
import org.cssa.iface.dao.dbengine.DBEngineImpl;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.infrastructure.CSSAConstants;
import org.cssa.iface.infrastructure.CSSAQuery;
import org.cssa.iface.services.QueryServices;

/**
 * 
 * @author KK
 * @since 12/27/2011
 *
 */

public class TransactioUtils {
	
	private ResultSet res;
	
	public TransactioUtils() {
		res = null;
	}
	/**
	 * this method return college id 
	 * @return
	 * @throws IfaceException
	 */
	public String  getCollegeId() throws IfaceException {
		String collegeId = CSSAConstants.COLLEGE_ID_PRE_STRING;
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		try{
			res = dbEngineImpl.executeQuery(CSSAQuery.GET_COLLEGE_COOUNT);
			if(res.next()) {
				collegeId+= ((res.getInt(1)+1) < 10 ? CSSAConstants.COLLEGE_ID_PRE_ZERO +String.valueOf(res.getInt(1)+1) : String.valueOf(res.getInt(1)+1));
			}
		}catch (Exception e) {
			throw  new IfaceException(e);
		}finally {
			dbEngineImpl.closeResultSet(res);
		}
		return collegeId;
	}
	
	public List<String> getStudentIds(String collegeId, int noOfParticipants) throws IfaceException {
		 
		List<String> studentIds = new ArrayList<String>();
		for(int i = 1; i <= noOfParticipants; i++) {
			 studentIds.add(collegeId + i);
		 }
		
		return studentIds;
		
	}
	
	public List<InsertResultsTableBo> getGroupResult(Results results) throws IfaceException {
		
		List<InsertResultsTableBo> insertResultsTableBo = new ArrayList<InsertResultsTableBo>();
		DBEngineImpl dbEngineImpl = new DBEngineImpl();
		Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
		if(null != results) {
			parameterMap.put(1, results.getCollegeId());
			parameterMap.put(2, results.getEventId());
			parameterMap.put(3, results.getStudentId());
			parameterMap.put(4, results.getEventId());
			res = dbEngineImpl.executeQuery(parameterMap, CSSAQuery.SELECT_GROUP_STUDENT);
			
			try {
				while(res.next()) {
					InsertResultsTableBo tableBo = new InsertResultsTableBo();
					tableBo.setCollegeId(res.getString(CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID));
					tableBo.setStudentId(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_ID));
					tableBo.setStudentName(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME));
					tableBo.setStudentGender(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER));
					tableBo.setStudentPhone(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE));
					tableBo.setStatus(res.getBoolean(CSSAConstants.STUDENTS_DETAILS_STATUS));
					tableBo.setEventId(res.getString(CSSAConstants.EVENT_DETAILS_EVENT_ID));
					tableBo.setGroupName(res.getString(CSSAConstants.EVENT_DETAILS_GROUP_ID));
					insertResultsTableBo.add(tableBo);
				}
			} catch (SQLException e) {
				throw new IfaceException(e);
			}finally {
				dbEngineImpl.closeResultSet(res);
			}
		}
		return insertResultsTableBo;
		
	}
	
	public List<InsertResult> getParticipantsList(InsertResult insertResult , boolean editMode) throws IfaceException {
		
		String query = "";
		DBEngineImpl dbEngineImpl = new DBEngineImpl();
		List<InsertResult> participantList = new ArrayList<InsertResult>();
		
		if(null != insertResult) {
			if(null != insertResult.getEventName()) {
				EventsTransaction eventsTransaction = new EventsTransaction();
				Events events = eventsTransaction.load(insertResult.getEventName());
				if(events.getMaxNoOfParticipants() > 1) {
					if(editMode){
						query = QueryServices.getEditParticipationGroupSearch(insertResult);
					}else {
						query = QueryServices.getParticipationGroupSearch(insertResult);
					}
				} else {
					if(editMode) {
					 query = QueryServices.getEditParticipationSingleSearch(insertResult);
					} else {
						query = QueryServices.getParticipationSingleSearch(insertResult);
					}
				}
			} else {
				if(editMode) {
					query = QueryServices.getEditParticipationSingleSearch(insertResult);
				}else {
					query = QueryServices.getParticipationSingleSearch(insertResult);
				}
			}
			
			try { 
				res = dbEngineImpl.executeQuery(query);
				while(res.next()) {
					InsertResult participant = new InsertResult();
					participant.setCollegeId(res.getString(CSSAConstants.EVENT_DETAILS_COLLEGE_ID));
					participant.setStudentId(res.getString(CSSAConstants.EVENT_DETAILS_STUDENT_ID));
					participant.setStudentName(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME));
					participant.setStudentGender(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER));
					participant.setStudentPhone(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE));
					participant.setStatus(res.getBoolean(CSSAConstants.STUDENTS_DETAILS_STATUS));
					participant.setEventName(res.getString(CSSAConstants.EVENT_DETAILS_EVENT_ID));
					participant.setGroupName(res.getString(CSSAConstants.EVENT_DETAILS_GROUP_ID));
					if(editMode) {
						participant.setEventStatus(res.getString(CSSAConstants.RESULTS_RESULT_STATUS));
						participant.setMark(res.getFloat(CSSAConstants.RESULTS_MARK));
					}
					participantList.add(participant);
					
				}
			} catch (Exception e) {
				throw new IfaceException(e);
			} finally {
				dbEngineImpl.closeResultSet(res);
			}
			
			
		}
		
		return participantList;
		
	}
	
public List<InsertResult> getWinnersParticipantsList(InsertResult insertResult) throws IfaceException {
		
		String query = "";
		DBEngineImpl dbEngineImpl = new DBEngineImpl();
		List<InsertResult> participantList = new ArrayList<InsertResult>();
		
		if(null != insertResult) {
			if(null != insertResult.getEventName()) {
				EventsTransaction eventsTransaction = new EventsTransaction();
				Events events = eventsTransaction.load(insertResult.getEventName());
				if(events.getMaxNoOfParticipants() > 1) {
					query = QueryServices.getWinnersParticipantGroupSearch(insertResult);
				} else {
					 query = QueryServices.getWinnersParticipationSingleSearch(insertResult);
				}
			} else {
				query = QueryServices.getWinnersParticipationSingleSearch(insertResult);
			}
			
			try { 
				res = dbEngineImpl.executeQuery(query);
				while(res.next()) {
					InsertResult participant = new InsertResult();
					participant.setCollegeId(res.getString(CSSAConstants.EVENT_DETAILS_COLLEGE_ID));
					participant.setStudentId(res.getString(CSSAConstants.EVENT_DETAILS_STUDENT_ID));
					participant.setEventStatus(res.getString(CSSAConstants.RESULTS_RESULT_STATUS));
					//participant.setCollegeName(res.getString(CSSAConstants.COLLEGE_DETAILS_COLLEGE_NAME));
					participant.setStudentName(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME));
					participant.setStudentGender(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER));
					participant.setStudentPhone(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE));
					participant.setStatus(res.getBoolean(CSSAConstants.STUDENTS_DETAILS_STATUS));
					participant.setEventName(res.getString(CSSAConstants.EVENT_DETAILS_EVENT_ID));
					participant.setGroupName(res.getString(CSSAConstants.EVENT_DETAILS_GROUP_ID));
					participantList.add(participant);
					
				}
			} catch (Exception e) {
				throw new IfaceException(e);
			} finally {
				dbEngineImpl.closeResultSet(res);
			}
			
			
		}
		
		return participantList;
		
	}

	public List<InsertResult> getParticipantsDetailsByEvents(List<String> eventList, Map<Integer, String> searcKeys) throws IfaceException {
		
		String query = QueryServices.getParticipantsDetailsByEventsQuery(eventList, searcKeys);
		List<InsertResult> participantList = new ArrayList<InsertResult>();
		DBEngineImpl dbEngineImpl = new DBEngineImpl();
		try { 
			res = dbEngineImpl.executeQuery(query);
			while(res.next()) {
				InsertResult participant = new InsertResult();
				participant.setCollegeId(res.getString(CSSAConstants.EVENT_DETAILS_COLLEGE_ID));
				participant.setCollegeName(res.getString(CSSAConstants.COLLEGE_DETAILS_COLLEGE_NAME));
				participant.setStudentId(res.getString(CSSAConstants.EVENT_DETAILS_STUDENT_ID));
				participant.setStudentName(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME));
				participant.setStudentGender(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER));
				participant.setStudentPhone(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE));
				participant.setStatus(res.getBoolean(CSSAConstants.STUDENTS_DETAILS_STATUS));
				participant.setEventName(res.getString(CSSAConstants.EVENT_DETAILS_EVENT_ID));
				participant.setGroupName(res.getString(CSSAConstants.EVENT_DETAILS_GROUP_ID));
				participantList.add(participant);
				
			}
		} catch (Exception e) {
			throw new IfaceException(e);
		} finally {
			dbEngineImpl.closeResultSet(res);
		}
		
		return participantList;
		
	}


}
