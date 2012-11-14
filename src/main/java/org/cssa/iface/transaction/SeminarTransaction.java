package org.cssa.iface.transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cssa.iface.bo.Seminar;
import org.cssa.iface.dao.dbengine.DBEngineImpl;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.infrastructure.CSSAConstants;
import org.cssa.iface.infrastructure.CSSAQuery;

public class SeminarTransaction implements Transaction<Seminar> {
	
	private ResultSet res;
	
	public SeminarTransaction() {
		super();
		res = null;
	}

	@Override
	public int save(Seminar object) throws IfaceException {
		int resultId = CSSAConstants.FAIL;
		Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
		if(null != object) {
			DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
			parameterMap.put(1, object.getName());
			parameterMap.put(2, object.getCourse());
			parameterMap.put(3, object.getCollege());
			parameterMap.put(4, object.getAddress());
			parameterMap.put(5, object.getPhone());
			parameterMap.put(6, object.getEmail());
			parameterMap.put(7, object.isDutyCertificate());
			resultId = dbEngineImpl.executeUpdate(parameterMap, CSSAQuery.INSERT_ALL_FIELDS_SEMINAR_DETAILS);
		}
		return resultId;
	}

	@Override
	public Seminar load(Seminar object) throws IfaceException {
		Seminar seminar = new Seminar();
		Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		if(null != object) {
			parameterMap.put(1, object.getSno());
			res = dbEngineImpl.executeQuery(parameterMap, CSSAQuery.SELECT_SEMINAR_DETAILS);
			try {
				while(res.next()) {
					seminar.setSno(res.getInt(CSSAConstants.SEMINAR_DETAILS_SNO));
					seminar.setName(res.getString(CSSAConstants.SEMINAR_DETAILS_NAME));
					seminar.setCollege(res.getString(CSSAConstants.SEMINAR_DETAILS_COLLEGE_NAME));
					seminar.setAddress(res.getString(CSSAConstants.SEMINAR_DETAILS_ADDRESS));
					seminar.setCourse(res.getString(CSSAConstants.SEMINAR_DETAILS_COURSE));
					seminar.setEmail(res.getString(CSSAConstants.SEMINAR_DETAILS_EMAIL));
					seminar.setPhone(res.getString(CSSAConstants.SEMINAR_DETAILS_PHONE));
					seminar.setDutyCertificate(res.getBoolean(CSSAConstants.SEMINAR_DETAILS_DUTY_CERTIFICATE));
				}
			} catch (SQLException e) {
				throw new IfaceException(e);
			}finally {
				dbEngineImpl.closeResultSet(res);
			}
		}
		return seminar;
	}

	@Override
	public List<Seminar> loadAll() throws IfaceException {
		
		Seminar seminar;
		List<Seminar> seminarList = new ArrayList<Seminar>();
		Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		res = dbEngineImpl.executeQuery(parameterMap, CSSAQuery.SELECT_ALL_SEMINAR_DETAILS);
		try {
			while(res.next()) {
				seminar = new Seminar();
				seminar.setSno(res.getInt(CSSAConstants.SEMINAR_DETAILS_SNO));
				seminar.setName(res.getString(CSSAConstants.SEMINAR_DETAILS_NAME));
				seminar.setCollege(res.getString(CSSAConstants.SEMINAR_DETAILS_COLLEGE_NAME));
				seminar.setAddress(res.getString(CSSAConstants.SEMINAR_DETAILS_ADDRESS));
				seminar.setCourse(res.getString(CSSAConstants.SEMINAR_DETAILS_COURSE));
				seminar.setEmail(res.getString(CSSAConstants.SEMINAR_DETAILS_EMAIL));
				seminar.setPhone(res.getString(CSSAConstants.SEMINAR_DETAILS_PHONE));
				seminar.setDutyCertificate(res.getBoolean(CSSAConstants.SEMINAR_DETAILS_DUTY_CERTIFICATE));
				seminarList.add(seminar);
			}
		} catch (SQLException e) {
			throw new IfaceException(e);
		}finally {
			dbEngineImpl.closeResultSet(res);
		}
		return seminarList;
	}

	@Override
	public int update(Seminar object) throws IfaceException {
		int resultId = CSSAConstants.FAIL;
		Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
		if(null != object) {
			DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
			parameterMap.put(1, object.getName());
			parameterMap.put(2, object.getCourse());
			parameterMap.put(3, object.getCollege());
			parameterMap.put(4, object.getAddress());
			parameterMap.put(5, object.getPhone());
			parameterMap.put(6, object.getEmail());
			parameterMap.put(7, object.isDutyCertificate());
			parameterMap.put(8, object.getSno());
			resultId = dbEngineImpl.executeUpdate(parameterMap, CSSAQuery.UPDATE_SEMINAR_DETAILS);
		}
		return resultId;
	}

	@Override
	public int delete(Seminar object) throws IfaceException { 
		int resultId = CSSAConstants.FAIL;
		Map<Integer, Object> parameterMap = new HashMap<Integer, Object>();
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		if(null != object) {
			parameterMap.put(1, object.getSno());
			resultId = dbEngineImpl.executeUpdate(parameterMap, CSSAQuery.DELETE_SEMINAR_DETAILS);
		}
		return resultId;
	}

}
