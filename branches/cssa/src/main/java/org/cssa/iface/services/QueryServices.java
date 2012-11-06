/**
 * 
 */
package org.cssa.iface.services;

import java.util.List;
import java.util.Map;

import org.cssa.iface.bo.CollegeDetails;
import org.cssa.iface.bo.InsertResult;
import org.cssa.iface.bo.StudentDetails;
import org.cssa.iface.bo.Winners;
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
					collegeSearchQuery.append(" AND ");
				}
				String condition = collegeDetails.getCollegeId().replace('*', '%');
				collegeSearchQuery.append(CSSAConstants.COLLEGE_DETAILS_COLLEGE_ID +" LIKE '");
				collegeSearchQuery.append(condition.toUpperCase() +"'" );
			}
		}
		return collegeSearchQuery.toString();
		
	}
	
	/**
	 * 
	 * @param studentDetails
	 * @return
	 * @throws IfaceException
	 */
	public static String getStudentDetailsSearchQuery(StudentDetails studentDetails) throws IfaceException {
		StringBuilder studentSearchQuery = new StringBuilder();
		studentSearchQuery.append( "SELECT "+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_SNO +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STATUS +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENT_DETAILS_ACCOMMODATION +", "
				+CSSAConstants.COLLEGE_DETAILS_TABLE+"."+CSSAConstants.COLLEGE_DETAILS_COLLEGE_NAME+", "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_POINT +" FROM "+CSSAConstants.STUDENTS_DETAILS_TABLE+", " +CSSAConstants.COLLEGE_DETAILS_TABLE
				+" WHERE "+CSSAConstants.COLLEGE_DETAILS_TABLE+"."+CSSAConstants.COLLEGE_DETAILS_COLLEGE_ID +"= "+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID);
			if(null != studentDetails.getStudentId()) {
				if(!studentDetails.getStudentId().isEmpty()) {
					studentSearchQuery.append(" AND ");
					String condition = studentDetails.getStudentId().replace('*', '%');
					studentSearchQuery.append(CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" LIKE");
					studentSearchQuery.append("'"+ condition +"'");
				}
			}
			
			if(null != studentDetails.getStudentName()) {
				if(!studentDetails.getStudentName().isEmpty()) {
					studentSearchQuery.append(" AND ");
					String condition = studentDetails.getStudentName().replace('*', '%');
					studentSearchQuery.append(CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +" LIKE ");
					studentSearchQuery.append("'"+ condition +"'");
				}
			}
			if(null != studentDetails.getCollegeId()) {
				if(!studentDetails.getCollegeId().isEmpty()) {
					studentSearchQuery.append(" AND ");
					String condition = studentDetails.getCollegeId().replace('*', '%');
					studentSearchQuery.append(CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID + " LIKE ");
					studentSearchQuery.append("'"+ condition +"'");
				}
			}
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
	
public static String getEditParticipationSingleSearch(InsertResult insertResult) throws IfaceException { 
		
		StringBuilder participationSearch = new StringBuilder();
		participationSearch.append( "SELECT "
				+CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID +" , "
				+CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STATUS +" , "
				+CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.EVENT_DETAILS_EVENT_ID +","
				+CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_MARK +","
				+CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_RESULT_STATUS +","
				+CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.EVENT_DETAILS_GROUP_ID +"  FROM  "+ CSSAConstants.STUDENTS_DETAILS_TABLE +" , " +CSSAConstants.RESULTS_TABLE 
				+" WHERE STUDENTS_DETAILS.STUDENT_ID = RESULTS.STUDENT_ID ");
		if(null != insertResult.getEventName()) {
			if(!insertResult.getEventName().isEmpty()) {
				participationSearch.append(" AND ");
				participationSearch.append(CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.EVENT_DETAILS_EVENT_ID +"  = '"+insertResult.getEventName() +"'");
			}
		}
		if(null!= insertResult.getCollegeId()) {
			if(!insertResult.getCollegeId().isEmpty()) {
				participationSearch.append(" AND ");
				participationSearch.append(CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.EVENT_DETAILS_COLLEGE_ID+"  = '"+ insertResult.getCollegeId() +"'");
			}
		}
		
		if(null != insertResult.getStudentId()) {
			if(!insertResult.getStudentId().isEmpty()) {
				participationSearch.append(" AND ");
				participationSearch.append(CSSAConstants.RESULTS_TABLE +"."+ CSSAConstants.EVENT_DETAILS_STUDENT_ID + "= '" +insertResult.getStudentId() +"'");
			}
		}
		if(null != insertResult.getEventStatus()) {
			if(!insertResult.getEventStatus().isEmpty()) {
				participationSearch.append(" AND ");
				participationSearch.append(CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_RESULT_STATUS+"  = '"+ insertResult.getEventStatus() +"'");
			}
		}
		
		
		return participationSearch.toString();
		
	}
	
	/**
	 * 
	 * @param insertResult
	 * @return
	 * @throws IfaceException
	 */
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
	 * @param insertResult
	 * @return
	 * @throws IfaceException
	 */
	public static String getEditParticipationGroupSearch(InsertResult insertResult) throws IfaceException { 
		
	    boolean andFlag = false;
		StringBuilder participationSearch = new StringBuilder();
		participationSearch.append( "SELECT "
				+CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID +" , "
				+CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE +" , "
				+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STATUS +" , "
				+CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.EVENT_DETAILS_EVENT_ID +","
				+CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_MARK +","
				+CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_RESULT_STATUS +","
				+CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.EVENT_DETAILS_GROUP_ID +"  FROM  "+ CSSAConstants.STUDENTS_DETAILS_TABLE +" , " +CSSAConstants.RESULTS_TABLE 
				+" WHERE STUDENTS_DETAILS.STUDENT_ID = RESULTS.STUDENT_ID ");
		participationSearch.append(" AND ");
		participationSearch.append(CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.EVENT_DETAILS_GROUP_ID + " = ");
		participationSearch.append("( SELECT ");
		participationSearch.append(CSSAConstants.EVENT_DETAILS_GROUP_ID +" FROM "+ CSSAConstants.RESULTS_TABLE);
		participationSearch.append(" WHERE ");
		
		if(null != insertResult.getStudentId()) {
			if(!insertResult.getStudentId().isEmpty()) {
				participationSearch.append(CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.EVENT_DETAILS_STUDENT_ID +" = '"+ insertResult.getStudentId() +"' ");
				andFlag = true;
			}
		} else {
			participationSearch.append(" STUDENTS_DETAILS.STUDENT_ID = RESULTS.STUDENT_ID ");
		}
		
		if(null != insertResult.getEventName()) {
			if(!insertResult.getEventName().isEmpty()) {
				if(andFlag) {
					participationSearch.append(" AND ");
					participationSearch.append(CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.EVENT_DETAILS_EVENT_ID+ " = '"+ insertResult.getEventName() +" ')");
				} else {
					participationSearch.append(CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.EVENT_DETAILS_EVENT_ID+ " = '"+ insertResult.getEventName() +" '");
					participationSearch.append(" AND  STUDENTS_DETAILS.STUDENT_ID = RESULTS.STUDENT_ID )");
				}
			}
		}
		
		//participationSearch.append(" AND  STUDENTS_DETAILS.STUDENT_ID = EVENT_DETAILS.STUDENT_ID ");
		if(null != insertResult.getEventName()) {
			if(!insertResult.getEventName().isEmpty()) {
				participationSearch.append(" AND ");
				participationSearch.append(CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.EVENT_DETAILS_EVENT_ID +"  = '"+insertResult.getEventName() +"'");
			}
		}
		
		if(null!= insertResult.getCollegeId()) {
			if(!insertResult.getCollegeId().isEmpty()) {
				participationSearch.append(" AND ");
				participationSearch.append(CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.EVENT_DETAILS_COLLEGE_ID+"  = '"+ insertResult.getCollegeId() +"'");
			}
		}
		
		if(null != insertResult.getEventStatus()) {
			if(!insertResult.getEventStatus().isEmpty()) {
				participationSearch.append(" AND ");
				participationSearch.append(CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_RESULT_STATUS+"  = '"+ insertResult.getEventStatus() +"'");
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
		
		/*if(null != results.getStudentId()) {
			if(!results.getStudentId().isEmpty()) {
				winnersGroupSearch.append(" AND ");
				winnersGroupSearch.append(CSSAConstants.RESULTS_TABLE +"."+ CSSAConstants.EVENT_DETAILS_STUDENT_ID + "= '" +results.getStudentId() +"'");
			}
		}*/
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
	
	public static  String getParticipantsDetailsByEventsQuery(List<String> eventList, Map<Integer, String> searcKeys) {
		
		String table;
		String round = searcKeys.get(0);
		String roundQuery = null;
		StringBuilder eventSearch = new StringBuilder();
		if(null != round) {
			if(!round.isEmpty()) {
				table = CSSAConstants.RESULTS_TABLE;
				eventSearch.append( "SELECT "
				+table+"."+CSSAConstants.RESULTS_RESULT_STATUS +", ");
				roundQuery = " AND "+table+".RESULT_STATUS = '"+round +"' ";
			} else {
				table = CSSAConstants.EVENT_DETAILS_TABLE;
				eventSearch.append( "SELECT ");

			}
		} else {
			table = CSSAConstants.EVENT_DETAILS_TABLE;
			eventSearch.append( "SELECT ");

		}
		
			eventSearch.append(table+"."+CSSAConstants.RESULTS_COLLEGE_ID +" , "
			+table+"."+CSSAConstants.RESULTS_STUDENT_ID +" , "
			+CSSAConstants.COLLEGE_DETAILS_TABLE+"."+CSSAConstants.COLLEGE_DETAILS_COLLEGE_NAME +","
			+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +" , "
			+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER +" , "
			+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE +" , "
			+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STATUS +" , "
			+table+"."+CSSAConstants.RESULTS_EVENT_ID +","
			+table+"."+CSSAConstants.RESULTS_EVENT_GROUP_ID+"  FROM  "+ CSSAConstants.STUDENTS_DETAILS_TABLE +" , " +table +", "+CSSAConstants.COLLEGE_DETAILS_TABLE
			+" WHERE STUDENTS_DETAILS.STUDENT_ID ="+table+".STUDENT_ID  AND STUDENTS_DETAILS.COLLEGE_ID = COLLEGE_DETAILS.COLLEGE_ID ");
		if(null != roundQuery) {
			eventSearch.append(roundQuery);
		}
		if( null != eventList) {
			boolean inflag = true;
			boolean comaFlag = true;
			for(String event : eventList) {
				if(!event.isEmpty() && !event.equals(" ")) {
					if(inflag) {
						eventSearch.append(" AND " +table+". EVENT_ID in (");
						inflag = false;
					}
					if(comaFlag){
						eventSearch.append("'"+ event+"'");
						comaFlag = false;
					} else  {
						eventSearch.append(",'"+ event+"'");
					}
				}
			}
			if(!inflag) {
				eventSearch.append(")");
			}
		}
		
		String collegeId = searcKeys.get(2);
		if(null != collegeId) {
			if(!collegeId.isEmpty()) { 
				eventSearch.append(" AND "+table+".COLLEGE_ID  LIKE ");
				String collegeIdReplace = collegeId.replace('*','%');
				eventSearch.append("'"+collegeIdReplace +"'");
			}
		}
		
		String studentId = searcKeys.get(3);
		if(null != studentId) {
			if(!studentId.isEmpty()) {
				eventSearch.append(" AND "+table+".STUDENT_ID  LIKE ");
				String studentIdReplace = studentId.replace('*','%');
				eventSearch.append("'"+studentIdReplace +"'");
			}
		}
		
		
		return eventSearch.toString();
		
	}
	
	public static String getSingleWinnersDetails(Winners winners) {
		
		StringBuilder winnersSingleSearch = new StringBuilder();	
		winnersSingleSearch.append( "SELECT "
			+CSSAConstants.WINNERS_TABLE+"."+CSSAConstants.WINNERS_STUDENT_ID +" , "
			+CSSAConstants.WINNERS_TABLE+"."+CSSAConstants.WINNERS_COLLEGE_ID +" , "
			+CSSAConstants.WINNERS_TABLE +"."+CSSAConstants.WINNERS_EVENT_ID +", "
			+CSSAConstants.WINNERS_TABLE +"."+CSSAConstants.WINNERS_EVENT_GROUP_ID+","
			+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +" , "
			+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER +" , "
			+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE +" , "
			+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STATUS +" , "
			+CSSAConstants.WINNERS_TABLE+"."+CSSAConstants.WINNERS_MARK +","
			+CSSAConstants.WINNERS_TABLE+"."+CSSAConstants.WINNERS_RESULT_STATUS+"  FROM  "+ CSSAConstants.STUDENTS_DETAILS_TABLE +" , " +CSSAConstants.WINNERS_TABLE 
			+" WHERE STUDENTS_DETAILS.STUDENT_ID = WINNERS.STUDENT_ID ");
		if(null != winners.getEventId()) {
			if(!winners.getEventId().isEmpty()) {
				winnersSingleSearch.append(" AND ");
				winnersSingleSearch.append(CSSAConstants.WINNERS_TABLE+"."+CSSAConstants.WINNERS_EVENT_ID +"  = '"+ winners.getEventId() +"'");
			}
		}
		if(null != winners.getWinnerStatus()) {
			if(!winners.getWinnerStatus().isEmpty()) {
				winnersSingleSearch.append(" AND ");
				winnersSingleSearch.append(CSSAConstants.WINNERS_TABLE+"."+CSSAConstants.WINNERS_RESULT_STATUS +"  = '"+ winners.getWinnerStatus() +"'");
			}
		}
	
		return winnersSingleSearch.toString();
	}
	
	
}
