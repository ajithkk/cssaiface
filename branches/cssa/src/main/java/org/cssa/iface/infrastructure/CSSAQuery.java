package org.cssa.iface.infrastructure;

/**
 * 
 * @author Ajith
 * @since 12/16/2011
 *
 */

public class CSSAQuery {
	//events table query started.
	public static final String INSERT_EVENTS_TABLE = "INSERT INTO "+CSSAConstants.EVENTS_TABLE+ " ("
			+ CSSAConstants.EVENT_DETAILS_EVENT_ID + ","
			+ CSSAConstants.EVENTS_EVENT_NAME + ","
			+ CSSAConstants.EVENTS_MAX_NO_OF_PARTICIPANTS + ","
			+ CSSAConstants.EVENTS_EVENT_POINT + ") VALUES (?,?,?,?)";
	
	public static final String SELECT_ALL_EVENTS_TABLE = "SELECT " + CSSAConstants.EVENTS_SNO + ","
			+ CSSAConstants.EVENTS_EVENT_ID + ","
			+ CSSAConstants.EVENTS_EVENT_NAME + ","
			+ CSSAConstants.EVENTS_MAX_NO_OF_PARTICIPANTS + ","
			+ CSSAConstants.EVENTS_EVENT_POINT + " FROM "
			+ CSSAConstants.EVENTS_TABLE;
	
	public static final String UPDATE_EVENTS_TABLE = "UPDATE "+CSSAConstants.EVENTS_TABLE+" SET "+CSSAConstants.EVENTS_EVENT_NAME +" =  ? ,"
			+CSSAConstants.EVENTS_MAX_NO_OF_PARTICIPANTS+ " = ? , "
			+CSSAConstants.EVENTS_EVENT_POINT+"= ? WHERE " 
			+CSSAConstants.EVENTS_EVENT_ID +" = ? "; 
	
	public static final String SELECT_EVENTS_TABLE = "SELECT " + CSSAConstants.EVENTS_SNO + ","
			+ CSSAConstants.EVENTS_EVENT_ID + ","
			+ CSSAConstants.EVENTS_EVENT_NAME + ","
			+ CSSAConstants.EVENTS_MAX_NO_OF_PARTICIPANTS + ","
			+ CSSAConstants.EVENTS_EVENT_POINT + " FROM "
			+ CSSAConstants.EVENTS_TABLE +"WHERE "+CSSAConstants.EVENTS_EVENT_ID +"= ?";
	
	public static final String DELETE_EVENTS_TABLE = "DELETE FROM EVENTS WHERE  "+CSSAConstants.EVENTS_EVENT_ID +"= ?";
	
	//events table events table end.
	
	//query for getting totel number of college
	public static final String GET_COLLEGE_COOUNT = "SELECT COUNT("+CSSAConstants.COLLEGE_DETAILS_SNO +") FROM " 
			+ CSSAConstants.COLLEGE_DETAILS_TABLE ;
	
	//college_details table query started
	
	public static final String SELECT_ALL_COLLEGE_DETAILS = "SELECT "+ CSSAConstants.COLLEGE_DETAILS_SNO +"," 
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_ID +","
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_NAME + ","
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_ADDRESS +","
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_PHONE+","
			+CSSAConstants.COLLEGE_DETAILS_NO_OF_PARTICIPANTS+","
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_POINTS+","
			+CSSAConstants.COLLEGE_DETAILS_STATUS +" FROM "+CSSAConstants.COLLEGE_DETAILS_TABLE +" WHERE "
			+CSSAConstants.COLLEGE_DETAILS_STATUS + "= TRUE ";
	
	public static final String SELECT_COLLEGE_DETAILS = "SELECT "+ CSSAConstants.COLLEGE_DETAILS_SNO +"," 
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_ID +","+CSSAConstants.COLLEGE_DETAILS_COLLEGE_NAME + ","
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_ADDRESS +","
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_PHONE+","
			+CSSAConstants.COLLEGE_DETAILS_NO_OF_PARTICIPANTS+","
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_POINTS+","
			+CSSAConstants.COLLEGE_DETAILS_STATUS +" FROM "+CSSAConstants.COLLEGE_DETAILS_TABLE +" WHERE "
			+CSSAConstants.COLLEGE_DETAILS_STATUS + "=TRUE  AND "
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_ID +" =  ? ";
	
	public static final String UPDATE_COLLEGE_DETAILS = "UPDATE "+CSSAConstants.COLLEGE_DETAILS_TABLE +" SET "
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_NAME +"= ? ,"
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_ADDRESS +"= ? ,"
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_PHONE+"= ? ,"
			+CSSAConstants.COLLEGE_DETAILS_NO_OF_PARTICIPANTS +"= ? ,"
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_POINTS +"= ?,"
			+CSSAConstants.COLLEGE_DETAILS_STATUS +"=? WHERE "
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_ID +"= ?";
	
	public static final String SELECT_ALL_COLLEGE_DETAILS_INCLUDE_DELETED = "SELECT "+ CSSAConstants.COLLEGE_DETAILS_SNO +"," 
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_ID +","
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_NAME + ","
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_ADDRESS +","
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_PHONE+","
			+CSSAConstants.COLLEGE_DETAILS_NO_OF_PARTICIPANTS+","
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_POINTS+","
			+CSSAConstants.COLLEGE_DETAILS_STATUS +"FROM"+CSSAConstants.COLLEGE_DETAILS_TABLE ;
	
	public static final String DELETE_COLLEGE_DETAILS = "UPDATE"+CSSAConstants.COLLEGE_DETAILS_TABLE+" SET"
			+CSSAConstants.COLLEGE_DETAILS_STATUS +" = FALSE WHERE "
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_ID +"= ?";
	
	public static final String UNDO_COLLEGE_DETAILS = "UPDATE"+CSSAConstants.COLLEGE_DETAILS_TABLE+" SET"
			+CSSAConstants.COLLEGE_DETAILS_STATUS +" = TRUE WHERE "
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_ID +"= ?";
	
	public static final String INSERT_ALL_FIELDS_COLLEGE_DETAILS = "INSERT INTO "+CSSAConstants.COLLEGE_DETAILS_TABLE +" ("
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_ID +" , "
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_NAME +" , "
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_ADDRESS +" , "
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_PHONE +" , "
			+CSSAConstants.COLLEGE_DETAILS_NO_OF_PARTICIPANTS +" ) VALUES ( ?,?,?,?,? ) ";
	
	public static final String INSERT_COLLEGE_DETAILS = "INSERT INTO "+CSSAConstants.COLLEGE_DETAILS_TABLE +" ("
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_ID +" ,"
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_NAME +" ,"
			+CSSAConstants.COLLEGE_DETAILS_NO_OF_PARTICIPANTS +" ) VALUES ( ?,?,? ) ";
	
	//college_details table query end
	
	//student_details table query started
	
	public static final String INSERT_STUDENT_DETAILS = "INSERT INTO "+CSSAConstants.STUDENTS_DETAILS_TABLE +" ( "
			+CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID +" ,"
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" ) VALUES (? , ? )";
	
	public static final String INSERT_ALL_FIELDS_STUDENT_DETAILS = "INSERT INTO " +CSSAConstants.STUDENTS_DETAILS_TABLE +" ("
			+CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE +","
			+CSSAConstants.STUDENT_DETAILS_ACCOMMODATION +" ) VALUES ( ?,?,?,?,?,?) ";
	
	public static final String SELECT_ALL_STUDENT_DETAILS = "SELECT "+CSSAConstants.STUDENTS_DETAILS_SNO +" , "
			+CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_POINT +" FROM "+CSSAConstants.STUDENTS_DETAILS_TABLE +"WHERE "
			+CSSAConstants.STUDENTS_DETAILS_STATUS +" = TRUE ";
	
	public static final String SELECT_STUDENT_DETAILS = "SELECT "+CSSAConstants.STUDENTS_DETAILS_SNO +" , "
			+CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_POINT +" FROM "
			+CSSAConstants.STUDENTS_DETAILS_TABLE +"WHERE "
			+CSSAConstants.STUDENTS_DETAILS_STATUS +" = TRUE AND " 
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" = ? " ;
			
	public static final String SELECT_ALL_STUDENT_DETAILS_INCLUDE_DELETED = "SELECT "+CSSAConstants.STUDENTS_DETAILS_SNO +" , "
			+CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_POINT +" FROM "+CSSAConstants.STUDENTS_DETAILS_TABLE ;
	
	public static final String UPDATE_STUDENT_DETAILS = "UPDATE "+CSSAConstants.STUDENTS_DETAILS_TABLE +" SET "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +" = ? , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER +" = ? , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE +" = ? , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_POINT +" = ? , "
			+CSSAConstants.STUDENTS_DETAILS_STATUS +" = ? WHERE "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" = ? ";
	
	public static final String DELETE_ALL_STUDENT_DETAILS = "UPDATE "+CSSAConstants.STUDENTS_DETAILS_TABLE +" SET "
			+CSSAConstants.STUDENTS_DETAILS_STATUS +" = FALSE  WHERE "+ CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID +" = ?";
	
	public static final String DELETE_STUDENT_DETAILS = "UPDATE "+CSSAConstants.STUDENTS_DETAILS_TABLE +" SET "
			+CSSAConstants.STUDENTS_DETAILS_STATUS +" = FALSE  WHERE "+ CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" = ?";
	
	public static final String RECYCLE_ALL_STUDENT_DETAILS = "UPDATE "+CSSAConstants.STUDENTS_DETAILS_TABLE +" SET "
			+CSSAConstants.STUDENTS_DETAILS_STATUS +" = TRUE WHERE "+ CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID +" = ?";
	
	public static final String RECYCLE_STUDENT_DETAILS = "UPDATE "+CSSAConstants.STUDENTS_DETAILS_TABLE +" SET "
			+CSSAConstants.STUDENTS_DETAILS_STATUS +" = TRUE  WHERE "+ CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" = ?";
	// student Details query ended.
	
	//Event details query started.
	public static final String INSERT_EVENT_DETAILS = "INSERT INTO "+CSSAConstants.EVENT_DETAILS_TABLE +"("
			+CSSAConstants.EVENT_DETAILS_STUDENT_ID +","
			+CSSAConstants.EVENT_DETAILS_GROUP_ID +" ,"
			+CSSAConstants.EVENT_DETAILS_EVENT_ID +" ,"
			+CSSAConstants.EVENT_DETAILS_COLLEGE_ID +" ) VALUES ( ?,?,?,?)";
	
	public static final String DELETE_GROUP_EVENT_DETAILS = "DELETE FROM "+CSSAConstants.EVENT_DETAILS_TABLE 
			+" WHERE "+CSSAConstants.EVENT_DETAILS_COLLEGE_ID +"= ? AND "
			+CSSAConstants.EVENT_DETAILS_EVENT_ID +"= ? AND "
			+CSSAConstants.EVENT_DETAILS_GROUP_ID +"= ? " ;
	
	public static final String DELETE_STUDENT_EVENT_DETAILS = "DELETE FROM "+ CSSAConstants.EVENT_DETAILS_TABLE 
			+" WHERE "+CSSAConstants.EVENT_DETAILS_STUDENT_ID +"= ? AND " 
			+ CSSAConstants.EVENT_DETAILS_EVENT_ID +" = ? ";
	
	public static final String SELECT_ALL_PARTICIPANTS_DETAILS = "";
	
	
/*	
	public static final String SELECT_ALL_STUDENT_RESULT = "SELECT "+ CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_STUDENT_ID +", "
			+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +", "
			+CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_EVENT_ID*/
	
	
			
	
	
	
	
	
			
}
