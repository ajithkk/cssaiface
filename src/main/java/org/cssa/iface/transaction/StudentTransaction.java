/**
 * 
 */
package org.cssa.iface.transaction;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cssa.iface.bo.StudentDetails;
import org.cssa.iface.dao.dbengine.DBEngineImpl;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.infrastructure.CSSAConstants;
import org.cssa.iface.infrastructure.CSSAQuery;
import org.cssa.iface.services.QueryServices;
import org.cssa.iface.util.Util;

/**
 * @author KK
 * @since 12/31/3011
 *
 */
public class StudentTransaction implements Transaction<StudentDetails>  {
	
	private ResultSet res; 
	
	public StudentTransaction() {
		res = null;
	}
	@Override
	public int save(StudentDetails object) throws IfaceException {
		int resultId = CSSAConstants.FAIL;
		Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		try {
			parameterMap.put(1, object.getCollegeId());
			parameterMap.put(2, object.getStudentId());
			parameterMap.put(3, object.getStudentName());
			parameterMap.put(4, Util.getGender(object.getStudentGender()));
			parameterMap.put(5, object.getStudentPhone());
			resultId = dbEngineImpl.executeUpdate(parameterMap, CSSAQuery.INSERT_STUDENT_DETAILS);
		}catch (Exception e) {
			throw new IfaceException(e);
		}
		return resultId;
	}

	@Override
	public StudentDetails load(StudentDetails object) throws IfaceException {
		StudentDetails student = new StudentDetails();
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		res = null;
		try {
			Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
			parameterMap.put(1, object.getStudentId());
			res = dbEngineImpl.executeQuery(parameterMap, CSSAQuery.SELECT_STUDENT_DETAILS);
			while(res.next()) {
				student.setSno(res.getInt(CSSAConstants.STUDENTS_DETAILS_SNO));
				student.setCollegeId(res.getString(CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID));
				student.setStudentId(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_ID));
				student.setStudentName(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME));
				student.setStudentPhone(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE));
				student.setStudentGender(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER));
				student.setStudentPoint(res.getFloat(CSSAConstants.STUDENTS_DETAILS_STUDENT_POINT));
				student.setStatus(res.getBoolean(CSSAConstants.STUDENTS_DETAILS_STATUS));
				
			} 
			dbEngineImpl.closeResultSet(res);
		} catch (Exception e) {
			throw new IfaceException(e);
		} finally {
			dbEngineImpl.closeResultSet(res);
		}

		return student;
	}

	@Override
	public List<StudentDetails> loadAll() throws IfaceException {
		List<StudentDetails> studentDetails = new ArrayList<StudentDetails>();
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		res = null;
		try {
			res =  dbEngineImpl.executeQuery(CSSAQuery.SELECT_ALL_STUDENT_DETAILS);
			while ( res.next()) {
				StudentDetails student = new StudentDetails();
				student.setSno(res.getInt(CSSAConstants.STUDENTS_DETAILS_SNO));
				student .setCollegeId(res.getString(CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID));
				student.setStudentId(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_ID));
				student.setStudentName(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME));
				student.setStudentPhone(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE));
				student.setStudentGender(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER));
				student.setStudentPoint(res.getFloat(CSSAConstants.STUDENTS_DETAILS_STUDENT_POINT));
				student.setAccommodation(res.getBoolean(CSSAConstants.STUDENT_DETAILS_ACCOMMODATION));
				student.setStatus(res.getBoolean(CSSAConstants.STUDENTS_DETAILS_STATUS));
				studentDetails.add(student);
			}
			dbEngineImpl.closeResultSet(res);
		}catch (Exception e) {
			throw new IfaceException(e);
		} finally {
			dbEngineImpl.closeResultSet(res);
		}
		return studentDetails;
	}

	public List<StudentDetails> loadAll(StudentDetails studentDetail) throws IfaceException {
		List<StudentDetails> studentDetails = new ArrayList<StudentDetails>();
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		res = null;
		try {
			String query = QueryServices.getStudentDetailsSearchQuery(studentDetail);
			res =  dbEngineImpl.executeQuery(query);
			while ( res.next()) {
				StudentDetails student = new StudentDetails();
				student.setSno(res.getInt(CSSAConstants.STUDENTS_DETAILS_SNO));
				student .setCollegeId(res.getString(CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID));
				student.setCollegeName(res.getString(CSSAConstants.COLLEGE_DETAILS_COLLEGE_NAME));
				student.setStudentId(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_ID));
				student.setStudentName(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME));
				student.setStudentPhone(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE));
				student.setStudentGender(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER));
				student.setStudentPoint(res.getFloat(CSSAConstants.STUDENTS_DETAILS_STUDENT_POINT));
				student.setAccommodation(res.getBoolean(CSSAConstants.STUDENT_DETAILS_ACCOMMODATION));
				student.setStatus(res.getBoolean(CSSAConstants.STUDENTS_DETAILS_STATUS));
				studentDetails.add(student);
			}
			dbEngineImpl.closeResultSet(res);
		}catch (Exception e) {
			throw new IfaceException(e);
		} finally {
			dbEngineImpl.closeResultSet(res);
		}
		return studentDetails;
	}

	@Override
	public int update(StudentDetails object) throws IfaceException {
		int resultId = CSSAConstants.FAIL;
		Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		try {
			parameterMap.put(1, object.getStudentName());
			parameterMap.put(2, Util.getGender(object.getStudentGender()));
			parameterMap.put(3, object.getStudentPhone());
			parameterMap.put(4, object.getStudentPoint());
			parameterMap.put(5, object.isAccommodation());
			parameterMap.put(6, object.isStatus());
			parameterMap.put(7, object.getStudentId());
			resultId = dbEngineImpl.executeUpdate(parameterMap, CSSAQuery.UPDATE_STUDENT_DETAILS);
		}catch (Exception e) {
			throw new IfaceException(e);
		}
		return resultId;
	}

	@Override
	public int delete(StudentDetails object) throws IfaceException {
		int[] resultId = new int[3];
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		try {
			Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
			parameterMap.put(1, object.getStudentId());
			resultId[0] = dbEngineImpl.executeUpdate(parameterMap, CSSAQuery.DELETE_STUDENT_DETAILS);
			resultId[1] = dbEngineImpl.executeUpdate(parameterMap, CSSAQuery.DELETE_STUDENT_DETAIL_FROM_EVENT);
			resultId[2] = dbEngineImpl.executeUpdate(parameterMap, CSSAQuery.DELETE_STUDENT_EVENT_DETAILS_FROM_RESULT);
		}catch (Exception e) {
			throw new IfaceException(e);
		}
		return resultId[0];
	}
	
	public int deleteAll(StudentDetails object) throws IfaceException {
		int resultId = CSSAConstants.FAIL;
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		try {
			Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
			parameterMap.put(1, object.getCollegeId());
			resultId = dbEngineImpl.executeUpdate(parameterMap, CSSAQuery.DELETE_ALL_STUDENT_DETAILS);
		}catch (Exception e) {
			throw new IfaceException(e);
		}
		return resultId;
	}
	
	public List<StudentDetails> selectAll() throws IfaceException {
		List<StudentDetails> studentDetails = new ArrayList<StudentDetails>();
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		res = null;
		try {
			res =  dbEngineImpl.executeQuery(CSSAQuery.SELECT_ALL_STUDENT_DETAILS_INCLUDE_DELETED);
			while ( res.next()) {
				StudentDetails student = new StudentDetails();
				student.setSno(res.getInt(CSSAConstants.STUDENTS_DETAILS_SNO));
				student .setCollegeId(res.getString(CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID));
				student.setStudentId(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_ID));
				student.setStudentName(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME));
				student.setStudentPhone(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE));
				student.setStudentGender(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER));
				student.setStudentPoint(res.getFloat(CSSAConstants.STUDENTS_DETAILS_STUDENT_POINT));
				student.setStatus(res.getBoolean(CSSAConstants.STUDENTS_DETAILS_STATUS));
				studentDetails.add(student);
			}
			dbEngineImpl.closeResultSet(res);
		}catch (Exception e) {
			throw new IfaceException(e);
		} finally {
			dbEngineImpl.closeResultSet(res);
		}
		return studentDetails;
		
	}
	
	public List<StudentDetails> loadAll(String collegeID)throws IfaceException {
		List<StudentDetails> studentDetails = new ArrayList<StudentDetails>();
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		res = null;
		try {
			Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
			parameterMap.put(1, collegeID);
			res = dbEngineImpl.executeQuery(parameterMap, CSSAQuery.SELECT_STUDENT_DETAILS_BY_COLLEGE);
			while ( res.next()) {
				StudentDetails student = new StudentDetails();
				student.setSno(res.getInt(CSSAConstants.STUDENTS_DETAILS_SNO));
				student .setCollegeId(res.getString(CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID));
				student.setStudentId(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_ID));
				student.setStudentName(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME));
				student.setStudentPhone(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE));
				student.setStudentGender(res.getString(CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER));
				student.setStudentPoint(res.getFloat(CSSAConstants.STUDENTS_DETAILS_STUDENT_POINT));
				student.setAccommodation(res.getBoolean(CSSAConstants.STUDENT_DETAILS_ACCOMMODATION));
				student.setStatus(res.getBoolean(CSSAConstants.STUDENTS_DETAILS_STATUS));
				studentDetails.add(student);
			}
			dbEngineImpl.closeResultSet(res);
		}catch (Exception e) {
			throw new IfaceException(e);
		} finally {
			dbEngineImpl.closeResultSet(res);
		}
		return studentDetails;	
	}
	
	public StudentDetails addNewStudent(List<StudentDetails> list) throws IfaceException {
		int count = list.size();
		String collegeId = list.get(0).getCollegeId();
		String studentId = collegeId+(count+1);
		Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
		Map<Integer, Object> parameterMap2 = new HashMap<Integer, Object>();
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		
		parameterMap.put(1, count+1);
		parameterMap.put(2, collegeId);
		dbEngineImpl.executeUpdate(parameterMap, CSSAQuery.UPDATE_COLLEGE_NO_OF_STUDENTS);
		
		parameterMap2.put(1, collegeId);
		parameterMap2.put(2, studentId);
		dbEngineImpl.executeUpdate(parameterMap2, CSSAQuery.INSERT_STUDENT_DETAILS);
		
		
		StudentDetails studentDetails = new StudentDetails();
		studentDetails.setCollegeId(collegeId);
		studentDetails.setStudentId(studentId);
		
		return load(studentDetails);
		
	}

}
