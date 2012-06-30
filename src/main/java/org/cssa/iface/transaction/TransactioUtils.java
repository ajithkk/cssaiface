package org.cssa.iface.transaction;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import org.cssa.iface.dao.dbengine.DBEngineImpl;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.infrastructure.CSSAConstants;
import org.cssa.iface.infrastructure.CSSAQuery;

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
			
			System.out.println(CSSAQuery.GET_COLLEGE_COOUNT);
			res = dbEngineImpl.executeQuery(CSSAQuery.GET_COLLEGE_COOUNT);
			if(res.next()) {
				collegeId+= ((res.getInt(1)+1) < 10 ? CSSAConstants.COLLEGE_ID_PRE_ZERO +String.valueOf(res.getInt(1)) : String.valueOf(res.getInt(1)));
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

}
