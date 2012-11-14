package org.cssa.iface.transaction;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cssa.iface.bo.CollegeDetails;
import org.cssa.iface.dao.dbengine.DBEngineImpl;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.infrastructure.CSSAConstants;
import org.cssa.iface.infrastructure.CSSAQuery;
import org.cssa.iface.services.QueryServices;

/**
 * 
 * @author Ajith
 * @since 12/28/2011
 * 
 */

public class CollegeTransaction implements Transaction<CollegeDetails> {

	private ResultSet res;

	public CollegeTransaction() {
		res = null;
	}

	@Override
	public int save(CollegeDetails object) throws IfaceException {

		int resultId = CSSAConstants.FAIL;
		String sqlCommand = CSSAQuery.INSERT_ALL_FIELDS_COLLEGE_DETAILS;
		
		//System.out.println(sqlCommand);
		String sqlCommand2 = CSSAQuery.INSERT_STUDENT_DETAILS;
		Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		TransactioUtils utils = new TransactioUtils();
		List<Map<Integer, Object>> batchParameterList = new ArrayList<Map<Integer, Object>>();

		parameterMap.put(1, object.getCollegeId());
		parameterMap.put(2, object.getCollegeName());
		parameterMap.put(3, object.getCollegeAddress());
		parameterMap.put(4, object.getCollegePhone());
		parameterMap.put(5, object.getNoOfParticipants());

		List<String> studentIds = utils.getStudentIds(object.getCollegeId(),
				object.getNoOfParticipants());
		for (String studentId : studentIds) {
			Map<Integer, Object> parameter = new HashMap<Integer, Object>();
			parameter.put(1, object.getCollegeId());
			parameter.put(2, studentId);
			batchParameterList.add(parameter);
		}

		try {
			resultId = dbEngineImpl.executeUpdate(parameterMap, sqlCommand);
			dbEngineImpl.executeBatch(batchParameterList, sqlCommand2);
		} catch (IfaceException e) {
			throw e;
		}

		return resultId;
	}

	@Override
	public CollegeDetails load(CollegeDetails object) throws IfaceException {

		CollegeDetails college = new CollegeDetails();
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		try {
			Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
			parameterMap.put(1, object.getCollegeId());
			res = dbEngineImpl.executeQuery(parameterMap,
					CSSAQuery.SELECT_COLLEGE_DETAILS);
			while (res.next()) {
				college.setSno(res.getInt(CSSAConstants.COLLEGE_DETAILS_SNO));
				college.setCollegeId(res
						.getString(CSSAConstants.COLLEGE_DETAILS_COLLEGE_ID));
				college.setCollegeName(res
						.getString(CSSAConstants.COLLEGE_DETAILS_COLLEGE_NAME));
				college.setCollegeAddress(res
						.getString(CSSAConstants.COLLEGE_DETAILS_COLLEGE_ADDRESS));
				college.setCollegePhone(res
						.getString(CSSAConstants.COLLEGE_DETAILS_COLLEGE_PHONE));
				college.setNoOfParticipants(res
						.getInt(CSSAConstants.COLLEGE_DETAILS_NO_OF_PARTICIPANTS));
				college.setCollegePoints(res
						.getFloat(CSSAConstants.COLLEGE_DETAILS_COLLEGE_POINTS));
				college.setStatus(res
						.getBoolean(CSSAConstants.COLLEGE_DETAILS_STATUS));
			}
			dbEngineImpl.closeResultSet(res);
		} catch (Exception e) {
			throw new IfaceException("Exception in load college", e);
		} finally {
			dbEngineImpl.closeResultSet(res);
		}
		return college;
	}

	@Override
	public List<CollegeDetails> loadAll() throws IfaceException {

		List<CollegeDetails> collegeDetails = new ArrayList<CollegeDetails>();
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		try {
			res = dbEngineImpl
					.executeQuery(CSSAQuery.SELECT_ALL_COLLEGE_DETAILS);
			while (res.next()) {
				CollegeDetails college = new CollegeDetails();
				college.setSno(res.getInt(CSSAConstants.COLLEGE_DETAILS_SNO));
				college.setCollegeId(res
						.getString(CSSAConstants.COLLEGE_DETAILS_COLLEGE_ID));
				college.setCollegeName(res
						.getString(CSSAConstants.COLLEGE_DETAILS_COLLEGE_NAME));
				college.setCollegeAddress(res
						.getString(CSSAConstants.COLLEGE_DETAILS_COLLEGE_ADDRESS));
				college.setCollegePhone(res
						.getString(CSSAConstants.COLLEGE_DETAILS_COLLEGE_PHONE));
				college.setNoOfParticipants(res
						.getInt(CSSAConstants.COLLEGE_DETAILS_NO_OF_PARTICIPANTS));
				college.setCollegePoints(res
						.getFloat(CSSAConstants.COLLEGE_DETAILS_COLLEGE_POINTS));
				college.setStatus(res
						.getBoolean(CSSAConstants.COLLEGE_DETAILS_STATUS));
				collegeDetails.add(college);
			}
			dbEngineImpl.closeResultSet(res);
		} catch (Exception e) {
			throw new IfaceException(e);
		} finally {
			dbEngineImpl.closeResultSet(res);
		}
		return collegeDetails;
	}

	@Override
	public int update(CollegeDetails object) throws IfaceException {

		int resultId = CSSAConstants.FAIL;
		String sqlCommand = CSSAQuery.UPDATE_COLLEGE_DETAILS;
		Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();

		parameterMap.put(1, object.getCollegeName());
		parameterMap.put(2, object.getCollegeAddress());
		parameterMap.put(3, object.getCollegePhone());
		parameterMap.put(4, object.getNoOfParticipants());
		parameterMap.put(5, object.getCollegePoints());
		parameterMap.put(6, object.isStatus());
		parameterMap.put(7, object.getCollegeId());
		try {
			resultId = dbEngineImpl.executeUpdate(parameterMap, sqlCommand);
		} catch (IfaceException e) {
			throw e;
		}

		return resultId;
	}

	@Override
	public int delete(CollegeDetails object) throws IfaceException {
		int resultId = CSSAConstants.FAIL;
		String sqlCommand = CSSAQuery.DELETE_COLLEGE_DETAILS;
		Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();

		parameterMap.put(1, object.getCollegeId());

		try {
			resultId = dbEngineImpl.executeUpdate(parameterMap, sqlCommand);
		} catch (IfaceException e) {
			throw e;
		}

		return resultId;
	}

	public List<CollegeDetails> loadAll(CollegeDetails object)
			throws IfaceException {
		List<CollegeDetails> collegeDetails = new ArrayList<CollegeDetails>();
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		QueryServices queryServices = new QueryServices();
		try {
			res = dbEngineImpl.executeQuery(queryServices
					.getCollegeSearchQuery(object));
			while (res.next()) {
				CollegeDetails college = new CollegeDetails();
				college.setSno(res.getInt(CSSAConstants.COLLEGE_DETAILS_SNO));
				college.setCollegeId(res
						.getString(CSSAConstants.COLLEGE_DETAILS_COLLEGE_ID));
				college.setCollegeName(res
						.getString(CSSAConstants.COLLEGE_DETAILS_COLLEGE_NAME));
				college.setCollegeAddress(res
						.getString(CSSAConstants.COLLEGE_DETAILS_COLLEGE_ADDRESS));
				college.setCollegePhone(res
						.getString(CSSAConstants.COLLEGE_DETAILS_COLLEGE_PHONE));
				college.setNoOfParticipants(res
						.getInt(CSSAConstants.COLLEGE_DETAILS_NO_OF_PARTICIPANTS));
				college.setCollegePoints(res
						.getFloat(CSSAConstants.COLLEGE_DETAILS_COLLEGE_POINTS));
				college.setStatus(res
						.getBoolean(CSSAConstants.COLLEGE_DETAILS_STATUS));
				collegeDetails.add(college);
			}
			dbEngineImpl.closeResultSet(res);
		} catch (Exception e) {
			throw new IfaceException(e);
		} finally {
			dbEngineImpl.closeResultSet(res);
		}
		return collegeDetails;
	}
	
	
	public List<CollegeDetails> selectAll() throws IfaceException {

		List<CollegeDetails> collegeDetails = new ArrayList<CollegeDetails>();
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		try {
			res = dbEngineImpl
					.executeQuery(CSSAQuery.SELECT_ALL_COLLEGE_DETAILS_INCLUDE_DELETED);
			while (res.next()) {
				CollegeDetails college = new CollegeDetails();
				college.setSno(res.getInt(CSSAConstants.COLLEGE_DETAILS_SNO));
				college.setCollegeId(res
						.getString(CSSAConstants.COLLEGE_DETAILS_COLLEGE_ID));
				college.setCollegeName(res
						.getString(CSSAConstants.COLLEGE_DETAILS_COLLEGE_NAME));
				college.setCollegeAddress(res
						.getString(CSSAConstants.COLLEGE_DETAILS_COLLEGE_ADDRESS));
				college.setCollegePhone(res
						.getString(CSSAConstants.COLLEGE_DETAILS_COLLEGE_PHONE));
				college.setNoOfParticipants(res
						.getInt(CSSAConstants.COLLEGE_DETAILS_NO_OF_PARTICIPANTS));
				college.setCollegePoints(res
						.getFloat(CSSAConstants.COLLEGE_DETAILS_COLLEGE_POINTS));
				college.setStatus(res
						.getBoolean(CSSAConstants.COLLEGE_DETAILS_STATUS));
				collegeDetails.add(college);
			}
			dbEngineImpl.closeResultSet(res);
		} catch (Exception e) {
			throw new IfaceException(e);
		} finally {
			dbEngineImpl.closeResultSet(res);
		}
		return collegeDetails;
	}

}
