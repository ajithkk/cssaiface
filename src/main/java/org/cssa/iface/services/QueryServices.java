/**
 * 
 */
package org.cssa.iface.services;

import org.cssa.iface.bo.CollegeDetails;
import org.cssa.iface.bo.InsertResult;
import org.cssa.iface.bo.Results;
import org.cssa.iface.bo.StudentDetails;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.infrastructure.CSSAConstants;

/**
 * @author ajith
 * @since 1/9/2012
 *
 */
public class QueryServices {
	/**
	 * 
	 * @param collegeDetails
	 * @return college search query
	 * @throws IfaceException
	 */
	public String getCollegeSearchQuery(CollegeDetails collegeDetails) throws IfaceException {
		StringBuilder collegeSearchQuery = new StringBuilder();
		boolean addStringFlag = false;
		collegeSearchQuery.append("SELECT "+ CSSAConstants.COLLEGE_DETAILS_SNO +"," 
				+CSSAConstants.COLLEGE_DETAILS_COLLEGE_ID +","
				+CSSAConstants.COLLEGE_DETAILS_COLLEGE_NAME + ","
				+CSSAConstants.COLLEGE_DETAILS_COLLEGE_ADDRESS +","
				+CSSAConstants.COLLEGE_DETAILS_COLLEGE_PHONE+","
				+CSSAConstants.COLLEGE_DETAILS_NO_OF_PARTICIPANTS+","
				+CSSAConstants.COLLEGE_DETAILS_COLLEGE_POINTS+","
				+CSSAConstants.COLLEGE_DETAILS_STATUS +" FROM "+CSSAConstants.COLLEGE_DETAILS_TABLE );
		collegeSearchQuery.append(" WHERE ");
		if(null != collegeDetails.getCollegeName() ) {
			if(!collegeDetails.getCollegeName().isEmpty()) {
				String condition =collegeDetails.getCollegeName().replace('*', '%');
				collegeSearchQuery.append(CSSAConstants.COLLEGE_DETAILS_COLLEGE_NAME +" LIKE '");
				collegeSearchQuery.append(condition  +"'");
				addStringFlag = true;
			}
		}
		if( null != collegeDetails.getCollegeId()) {
			if(!collegeDetails.getCollegeId().isEmpty()) {
				if(addStringFlag) {
					collegeSearchQuery.append("AND ");
				}
				String condition = collegeDetails.getCollegeId().replace('*', '%');
				collegeSearchQuery.append(CSSAConstants.COLLEGE_DETAILS_COLLEGE_ID +" LIKE '");
				collegeSearchQuery.append(condition.toUpperCase() +"'" );
			}
		}
		return collegeSearchQuery.toString();
		
	}
	
	public static String getStudentDetailsSearchQuery(StudentDetails studentDetails) throws IfaceException {
		StringBuilder studentSearchQuery = new StringBuilder();
		
		return studentSearchQuery.toString();
	}
	
	/**
	 * 
	 * @param insertResult
	 * @return prelims non group event participation details query  
	 * @throws IfaceException
	 */
	public static String getParticipationSingleSearch(InsertResult insertResult) throws IfaceException { 
		
		StringBuilder participationSearch = new StringBuilder();
		participationSearch.append( "SELECT "
				+CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID +" , "
				+CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STATUS +" , "
				+CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.EVENT_DETAILS_EVENT_ID +","
				+CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.EVENT_DETAILS_GROUP_ID +"  FROM  "+ CSSAConstants.STUDENTS_DETAILS_TABLE +" , " +CSSAConstants.EVENT_DETAILS_TABLE 
				+" WHERE STUDENTS_DETAILS.STUDENT_ID = EVENT_DETAILS.STUDENT_ID ");
		if(null != insertResult.getEventName()) {
			if(!insertResult.getEventName().isEmpty()) {
				participationSearch.append(" AND ");
				participationSearch.append(CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.EVENT_DETAILS_EVENT_ID +"  = '"+insertResult.getEventName() +"'");
			}
		}
		if(null!= insertResult.getCollegeId()) {
			if(!insertResult.getCollegeId().isEmpty()) {
				participationSearch.append(" AND ");
				participationSearch.append(CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.EVENT_DETAILS_COLLEGE_ID+"  = '"+ insertResult.getCollegeId() +"'");
			}
		}
		
		if(null != insertResult.getStudentId()) {
			if(!insertResult.getStudentId().isEmpty()) {
				participationSearch.append(" AND ");
				participationSearch.append(CSSAConstants.EVENT_DETAILS_TABLE +"."+ CSSAConstants.EVENT_DETAILS_STUDENT_ID + "= '" +insertResult.getStudentId() +"'");
			}
		}
		
		return participationSearch.toString();
		
	}
	
	
public static String getParticipationGroupSearch(InsertResult insertResult) throws IfaceException { 
		
	    boolean andFlag = false;
		StringBuilder participationSearch = new StringBuilder();
		participationSearch.append( "SELECT "
				+CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID +" , "
				+CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STATUS +" , "
				+CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.EVENT_DETAILS_EVENT_ID +","
				+CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.EVENT_DETAILS_GROUP_ID +"  FROM  "+ CSSAConstants.STUDENTS_DETAILS_TABLE +" , " +CSSAConstants.EVENT_DETAILS_TABLE 
				+" WHERE STUDENTS_DETAILS.STUDENT_ID = EVENT_DETAILS.STUDENT_ID ");
		participationSearch.append(" AND ");
		participationSearch.append(CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.EVENT_DETAILS_GROUP_ID + " = ");
		participationSearch.append("( SELECT ");
		participationSearch.append(CSSAConstants.EVENT_DETAILS_GROUP_ID +" FROM "+ CSSAConstants.EVENT_DETAILS_TABLE);
		participationSearch.append(" WHERE ");
		
		if(null != insertResult.getStudentId()) {
			if(!insertResult.getStudentId().isEmpty()) {
				participationSearch.append(CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.EVENT_DETAILS_STUDENT_ID +" = '"+ insertResult.getStudentId() +"' ");
				andFlag = true;
			}
		} else {
			participationSearch.append(" STUDENTS_DETAILS.STUDENT_ID = EVENT_DETAILS.STUDENT_ID ");
		}
		
		if(null != insertResult.getEventName()) {
			if(!insertResult.getEventName().isEmpty()) {
				if(andFlag) {
					participationSearch.append(" AND ");
					participationSearch.append(CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.EVENT_DETAILS_EVENT_ID+ " = '"+ insertResult.getEventName() +" ')");
				} else {
					participationSearch.append(CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.EVENT_DETAILS_EVENT_ID+ " = '"+ insertResult.getEventName() +" '");
					participationSearch.append(" AND  STUDENTS_DETAILS.STUDENT_ID = EVENT_DETAILS.STUDENT_ID )");
				}
			}
		}
		
		//participationSearch.append(" AND  STUDENTS_DETAILS.STUDENT_ID = EVENT_DETAILS.STUDENT_ID ");
		if(null != insertResult.getEventName()) {
			if(!insertResult.getEventName().isEmpty()) {
				participationSearch.append(" AND ");
				participationSearch.append(CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.EVENT_DETAILS_EVENT_ID +"  = '"+insertResult.getEventName() +"'");
			}
		}
		
		if(null!= insertResult.getCollegeId()) {
			if(!insertResult.getCollegeId().isEmpty()) {
				participationSearch.append(" AND ");
				participationSearch.append(CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.EVENT_DETAILS_COLLEGE_ID+"  = '"+ insertResult.getCollegeId() +"'");
			}
		}
		
		return participationSearch.toString();
		
	}
	
	
	/**
	 * 
	 * @param results
	 * @return winners participants group event search query
	 */
	public static String getWinnersParticipantGroupSearch(InsertResult results) {
		boolean andFlag = false;
		StringBuilder winnersGroupSearch = new StringBuilder();
		winnersGroupSearch.append( "SELECT "
				+CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_COLLEGE_ID +" , "
				+CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_STUDENT_ID +" , "
				+CSSAConstants.RESULTS_TABLE +"."+CSSAConstants.RESULTS_RESULT_STATUS +", "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STATUS +" , "
				+CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_EVENT_ID +","
				+CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_EVENT_GROUP_ID+"  FROM  "+ CSSAConstants.STUDENTS_DETAILS_TABLE +" , " +CSSAConstants.RESULTS_TABLE 
				+" WHERE STUDENTS_DETAILS.STUDENT_ID = RESULTS.STUDENT_ID ");
		winnersGroupSearch.append(" AND ");
		winnersGroupSearch.append(CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_EVENT_GROUP_ID + " = ");
		winnersGroupSearch.append("( SELECT ");
		winnersGroupSearch.append(CSSAConstants.RESULTS_EVENT_GROUP_ID +" FROM "+ CSSAConstants.RESULTS_TABLE);
		winnersGroupSearch.append(" WHERE ");
		
		if(null != results.getStudentId()) {
			if(!results.getStudentId().isEmpty()) {
				winnersGroupSearch.append(CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_STUDENT_ID +" = '"+ results.getStudentId() +"' ");
				andFlag = true;
			}
		} else {
			winnersGroupSearch.append(" STUDENTS_DETAILS.STUDENT_ID = RESULTS.STUDENT_ID ");
		}
		
		if(null != results.getEventName()) {
			if(!results.getEventName().isEmpty()) {
				if(andFlag) {
					winnersGroupSearch.append(" AND ");
					winnersGroupSearch.append(CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_EVENT_ID+ " = '"+ results.getEventName() +" ')");
				} else {
					winnersGroupSearch.append(CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_EVENT_ID+ " = '"+ results.getEventName() +" '");
					winnersGroupSearch.append(" AND  STUDENTS_DETAILS.STUDENT_ID = RESULTS.STUDENT_ID )");
				}
			}
		}
		//winnersGroupSearch.append(" AND  STUDENTS_DETAILS.STUDENT_ID = RESULTS.STUDENT_ID");
		if(null != results.getEventName()) {
			if(!results.getEventName().isEmpty()) {
				winnersGroupSearch.append(" AND ");
				winnersGroupSearch.append(CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_EVENT_ID +"  = '"+results.getEventName() +"'");
			}
		}
		
		if(null != results.getEventStatus()) {
			if(!results.getEventStatus().isEmpty()) {
				winnersGroupSearch.append(" AND ");
				winnersGroupSearch.append(CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_RESULT_STATUS +"  = '"+results.getEventStatus() +"'");
			}
		}
		if(null!= results.getCollegeId()) {
			if(!results.getCollegeId().isEmpty()) {
				winnersGroupSearch.append(" AND ");
				winnersGroupSearch.append(CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_COLLEGE_ID+"  = '"+ results.getCollegeId() +"'");
			}
		}
		if(null != results.getGroupName()) {
			if(!results.getGroupName().isEmpty()) {
				
			}
		}
		
		if(null != results.getStudentId()) {
			if(!results.getStudentId().isEmpty()) {
				winnersGroupSearch.append(" AND ");
				winnersGroupSearch.append(CSSAConstants.EVENT_DETAILS_TABLE +"."+ CSSAConstants.EVENT_DETAILS_STUDENT_ID + "= '" +results.getStudentId() +"'");
			}
		}
		return winnersGroupSearch.toString();
		
	}
	
	
	/**
	 * 
	 * @param results
	 * @return
	 * @throws IfaceException
	 */
	public static String getWinnersParticipationSingleSearch(InsertResult results) throws IfaceException { 
		StringBuilder winnersSingleSearch = new StringBuilder();	
		winnersSingleSearch.append( "SELECT "
			+CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_COLLEGE_ID +" , "
			+CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_STUDENT_ID +" , "
			+CSSAConstants.RESULTS_TABLE +"."+CSSAConstants.RESULTS_RESULT_STATUS +", "
			+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +" , "
			+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER +" , "
			+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE +" , "
			+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STATUS +" , "
			+CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_EVENT_ID +","
			+CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_EVENT_GROUP_ID+"  FROM  "+ CSSAConstants.STUDENTS_DETAILS_TABLE +" , " +CSSAConstants.RESULTS_TABLE 
			+" WHERE STUDENTS_DETAILS.STUDENT_ID = RESULTS.STUDENT_ID ");
		if(null != results.getEventName()) {
			if(!results.getEventName().isEmpty()) {
				winnersSingleSearch.append(" AND ");
				winnersSingleSearch.append(CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_EVENT_ID +"  = '"+results.getEventName() +"'");
			}
		}
	
		if(null != results.getEventStatus()) {
			if(!results.getEventStatus().isEmpty()) {
				winnersSingleSearch.append(" AND ");
				winnersSingleSearch.append(CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_RESULT_STATUS +"  = '"+results.getEventStatus() +"'");
			}
		}
		if(null!= results.getCollegeId()) {
			if(!results.getCollegeId().isEmpty()) {
				winnersSingleSearch.append(" AND ");
				winnersSingleSearch.append(CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_COLLEGE_ID+"  = '"+ results.getCollegeId() +"'");
			}
		}
		if(null != results.getStudentId()) {
			if(!results.getStudentId().isEmpty()) {
				winnersSingleSearch.append(" AND ");
				winnersSingleSearch.append(CSSAConstants.RESULTS_TABLE +"."+ CSSAConstants.RESULTS_STUDENT_ID + "= '" +results.getStudentId() +"'");
			}
		}
		return winnersSingleSearch.toString();
		
	}
	
}
