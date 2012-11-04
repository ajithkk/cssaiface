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
			+ CSSAConstants.EVENTS_TABLE +" WHERE "+CSSAConstants.EVENTS_EVENT_ID +"= ?";
	
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
	
	
	public static final String INSERT_COLLEGE_POINTS = "UPDATE "+CSSAConstants.COLLEGE_DETAILS_TABLE +" SET "
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_POINTS +"= ?"
			 +" WHERE "
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_ID +"= ?";
	
	public static final String UPDATE_COLLEGE_NO_OF_STUDENTS = "UPDATE "+CSSAConstants.COLLEGE_DETAILS_TABLE +" SET "
			+CSSAConstants.COLLEGE_DETAILS_NO_OF_PARTICIPANTS +"= ? "
			 +" WHERE "
			+CSSAConstants.COLLEGE_DETAILS_COLLEGE_ID +"= ?";
	
	
	
	
	
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
			+CSSAConstants.STUDENTS_DETAILS_STATUS +" , "
			+CSSAConstants.STUDENT_DETAILS_ACCOMMODATION +", "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_POINT +" FROM "+CSSAConstants.STUDENTS_DETAILS_TABLE;
	
	public static final String SELECT_STUDENT_DETAILS = "SELECT "+CSSAConstants.STUDENTS_DETAILS_SNO +" , "
			+CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE +" , "
			+CSSAConstants.STUDENTS_DETAILS_STATUS +" , "
			+CSSAConstants.STUDENT_DETAILS_ACCOMMODATION+ ", "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_POINT +" FROM "
			+CSSAConstants.STUDENTS_DETAILS_TABLE +" WHERE "
			+CSSAConstants.STUDENTS_DETAILS_STATUS +" = TRUE AND " 
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" = ? " ;
	
	public static final String SELECT_STUDENT_DETAILS_BY_COLLEGE = "SELECT "+CSSAConstants.STUDENTS_DETAILS_SNO +" , "
			+CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE +" , "
			+CSSAConstants.STUDENTS_DETAILS_STATUS +" , "
			+CSSAConstants.STUDENT_DETAILS_ACCOMMODATION+ ", "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_POINT +" FROM "
			+CSSAConstants.STUDENTS_DETAILS_TABLE +" WHERE "
			+CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID  +" = ? " ;
			
	public static final String SELECT_ALL_STUDENT_DETAILS_INCLUDE_DELETED = "SELECT "+CSSAConstants.STUDENTS_DETAILS_SNO +" , "
			+CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER +" , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE +" , "
			+CSSAConstants.STUDENTS_DETAILS_STATUS +" , "
			+CSSAConstants.STUDENT_DETAILS_ACCOMMODATION+ ", "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_POINT +" FROM "+CSSAConstants.STUDENTS_DETAILS_TABLE ;
	
	public static final String UPDATE_STUDENT_DETAILS = "UPDATE "+CSSAConstants.STUDENTS_DETAILS_TABLE +" SET "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +" = ? , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER +" = ? , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE +" = ? , "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_POINT +" = ? , "
			+CSSAConstants.STUDENT_DETAILS_ACCOMMODATION +"= ? ,"
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
	
	
	public static final String INSERT_STTUDENT_POINTS = "UPDATE "+CSSAConstants.STUDENTS_DETAILS_TABLE +" SET "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_POINT +" = ?  "
			+" WHERE "
			+CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" = ? ";
	
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
			+CSSAConstants.EVENT_DETAILS_GROUP_ID +"= ? AND " 
			+CSSAConstants.EVENT_DETAILS_STUDENT_ID + "= ? ";
	
	public static final String DELETE_STUDENT_EVENT_DETAILS = "DELETE FROM "+ CSSAConstants.EVENT_DETAILS_TABLE 
			+" WHERE "+CSSAConstants.EVENT_DETAILS_STUDENT_ID +"= ? AND " 
			+ CSSAConstants.EVENT_DETAILS_EVENT_ID +" = ? ";
	
	public static final String SELECT_EVENT_PARTICIPANTS = "SELECT "+CSSAConstants.EVENT_DETAILS_COLLEGE_ID +"," 
			+CSSAConstants.EVENT_DETAILS_STUDENT_ID +","
			+CSSAConstants.EVENT_DETAILS_EVENT_ID +","
			+CSSAConstants.EVENT_DETAILS_GROUP_ID +" FROM "+ CSSAConstants.EVENT_DETAILS_TABLE 
			+" WHERE " +CSSAConstants.EVENT_DETAILS_COLLEGE_ID +" = ? AND "
			+CSSAConstants.EVENT_DETAILS_EVENT_ID +" = ? AND "
			+CSSAConstants.EVENT_DETAILS_GROUP_ID+ " = ?";
	
	public static final String SELECT_PARTICIPANTS_IN_EVENT = "SELECT "+CSSAConstants.EVENT_DETAILS_COLLEGE_ID +"," 
			+CSSAConstants.EVENT_DETAILS_STUDENT_ID +","
			+CSSAConstants.EVENT_DETAILS_EVENT_ID +","
			+CSSAConstants.EVENT_DETAILS_GROUP_ID +" FROM "+ CSSAConstants.EVENT_DETAILS_TABLE 
			+" WHERE " +CSSAConstants.EVENT_DETAILS_COLLEGE_ID +" = ? AND "
			+CSSAConstants.EVENT_DETAILS_EVENT_ID +" = ?";
	
	public static final String DELETE_STUDENT_DETAIL_FROM_EVENT = "DELETE FROM "+ CSSAConstants.EVENT_DETAILS_TABLE 
			+" WHERE "+CSSAConstants.EVENT_DETAILS_STUDENT_ID +"= ? ";
	
	
	public static final String SELECT_ALL_PARTICIPANTS_DETAILS = "";
	
	
/*	
	public static final String SELECT_ALL_STUDENT_RESULT = "SELECT "+ CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_STUDENT_ID +", "
			+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +", "
			+CSSAConstants.RESULTS_TABLE+"."+CSSAConstants.RESULTS_EVENT_ID*/
	
	
	public static final String SELECT_ALL_SEMINAR_DETAILS = "SELECT "+ CSSAConstants.SEMINAR_DETAILS_SNO +"," 
			+CSSAConstants.SEMINAR_DETAILS_NAME +","+CSSAConstants.SEMINAR_DETAILS_COURSE  + ","
			+CSSAConstants.SEMINAR_DETAILS_COLLEGE_NAME +","
			+CSSAConstants.SEMINAR_DETAILS_ADDRESS+","
			+CSSAConstants.SEMINAR_DETAILS_PHONE+","
			+CSSAConstants.SEMINAR_DETAILS_EMAIL+","
			+CSSAConstants.SEMINAR_DETAILS_DUTY_CERTIFICATE +" FROM "+CSSAConstants.SEMINAR_DETAILS_TABLE ;	
	
	public static final String SELECT_SEMINAR_DETAILS = "SELECT "+ CSSAConstants.SEMINAR_DETAILS_SNO +"," 
			+CSSAConstants.SEMINAR_DETAILS_NAME +","+CSSAConstants.SEMINAR_DETAILS_COURSE  + ","
			+CSSAConstants.SEMINAR_DETAILS_COLLEGE_NAME +","
			+CSSAConstants.SEMINAR_DETAILS_ADDRESS+","
			+CSSAConstants.SEMINAR_DETAILS_PHONE+","
			+CSSAConstants.SEMINAR_DETAILS_EMAIL+","
			+CSSAConstants.SEMINAR_DETAILS_DUTY_CERTIFICATE +" FROM "+CSSAConstants.SEMINAR_DETAILS_TABLE +" WHERE "
			+CSSAConstants.SEMINAR_DETAILS_SNO +" = ? ";	
	
	public static final String INSERT_ALL_FIELDS_SEMINAR_DETAILS = "INSERT INTO " +CSSAConstants.SEMINAR_DETAILS_TABLE +" ("
			+CSSAConstants.SEMINAR_DETAILS_NAME +","+CSSAConstants.SEMINAR_DETAILS_COURSE  + ","
			+CSSAConstants.SEMINAR_DETAILS_COLLEGE_NAME +","
			+CSSAConstants.SEMINAR_DETAILS_ADDRESS+","
			+CSSAConstants.SEMINAR_DETAILS_PHONE+","
			+CSSAConstants.SEMINAR_DETAILS_EMAIL+","
			+CSSAConstants.SEMINAR_DETAILS_DUTY_CERTIFICATE +" ) VALUES ( ?,?,?,?,?,?,?) ";
	
	
	public static final String UPDATE_SEMINAR_DETAILS = "UPDATE "+CSSAConstants.SEMINAR_DETAILS_TABLE +" SET "
			+CSSAConstants.SEMINAR_DETAILS_NAME +"= ?  ,"+CSSAConstants.SEMINAR_DETAILS_COURSE  +"= ? ,"
			+CSSAConstants.SEMINAR_DETAILS_COLLEGE_NAME +"= ? ,"
			+CSSAConstants.SEMINAR_DETAILS_ADDRESS+"= ? ,"
			+CSSAConstants.SEMINAR_DETAILS_PHONE+"= ? ,"
			+CSSAConstants.SEMINAR_DETAILS_DUTY_CERTIFICATE +" WHERE "
			+CSSAConstants.SEMINAR_DETAILS_SNO +" = ? ";
	
	public static final String DELETE_SEMINAR_DETAILS = "DELETE FROM "+CSSAConstants.SEMINAR_DETAILS_TABLE 
			+" WHERE "+CSSAConstants.SEMINAR_DETAILS_SNO  +"= ?" ;
	
	//RESULT table query 
	
	
	public static final String INSERT_RESULT = "INSERT INTO "+CSSAConstants.RESULTS_TABLE +"(" 
			+CSSAConstants.RESULTS_COLLEGE_ID +", "
			+CSSAConstants.RESULTS_STUDENT_ID +", "
			+CSSAConstants.RESULTS_EVENT_ID +", "
			+CSSAConstants.RESULTS_RESULT_STATUS +", "
			+CSSAConstants.RESULTS_EVENT_GROUP_ID + ", "
			+CSSAConstants.RESULTS_MARK +") VALUES(?,?,?,?,?,?)";
	
	public static final String SELECT_RESULT = "SELECT "+CSSAConstants.RESULTS_SNO+ " ,"
			+CSSAConstants.RESULTS_COLLEGE_ID +", "
			+CSSAConstants.RESULTS_STUDENT_ID +", "
			+CSSAConstants.RESULTS_EVENT_ID +", "
			+CSSAConstants.RESULTS_RESULT_STATUS+", "
			+CSSAConstants.RESULTS_MARK +" FROM "+CSSAConstants.RESULTS_TABLE +" WHERE "+
			CSSAConstants.RESULTS_STUDENT_ID +" = ? AND "+ CSSAConstants.RESULTS_STUDENT_ID +" = ?"; 
	
	public static final String UPDATE_RESULT = "UPDATE "+CSSAConstants.RESULTS_TABLE +" SET " +
			CSSAConstants.RESULTS_RESULT_STATUS +" = ? , "+
			CSSAConstants.RESULTS_MARK + " = ? WHERE "+ CSSAConstants.RESULTS_STUDENT_ID +" = ? AND "
			+CSSAConstants.RESULTS_COLLEGE_ID +" = ?  AND "+ CSSAConstants.RESULTS_EVENT_ID +" = ? "; 
	
	
	public static final String DELETE_STUDENT_EVENT_DETAILS_FROM_RESULT = "DELETE FROM "+ CSSAConstants.RESULTS_TABLE 
			+" WHERE "+CSSAConstants.RESULTS_STUDENT_ID +"= ? ";
	
	public static final String SELECT_GROUP_STUDENT = " SELECT "
			+CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID +" , "
			+CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" , "
			+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +" , "
			+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER +" , "
			+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE +" , "
			+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STATUS +" , "
			+CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.EVENT_DETAILS_EVENT_ID +","
			+CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.EVENT_DETAILS_GROUP_ID +"  FROM  "+ CSSAConstants.STUDENTS_DETAILS_TABLE +" , " +CSSAConstants.EVENT_DETAILS_TABLE 
			+" WHERE "
			+CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.EVENT_DETAILS_COLLEGE_ID +" = ? AND "
			+CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.EVENT_DETAILS_EVENT_ID +" = ? AND "
			+CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.EVENT_DETAILS_GROUP_ID +" = ( SELECT "
				+CSSAConstants.EVENT_DETAILS_GROUP_ID +" FROM "+ CSSAConstants.EVENT_DETAILS_TABLE 
				+" WHERE "+CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.EVENT_DETAILS_STUDENT_ID +" = ? AND "+CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.EVENT_DETAILS_EVENT_ID +" = ?)  AND  STUDENTS_DETAILS.STUDENT_ID = EVENT_DETAILS.STUDENT_ID";
			//+CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" = "+ CSSAConstants.EVENT_DETAILS_STUDENT_ID ;
	
	public static final String SELECT_PARTICIPANTS = " SELECT "
			+CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_COLLEGE_ID +" , "
			+CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_ID +" , "
			+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_NAME +" , "
			+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_GENDER +" , "
			+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STUDENT_PHONE +" , "
			+CSSAConstants.STUDENTS_DETAILS_TABLE+"."+CSSAConstants.STUDENTS_DETAILS_STATUS +" , "
			+CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.EVENT_DETAILS_EVENT_ID +","
			+CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.EVENT_DETAILS_GROUP_ID +"  FROM  "+ CSSAConstants.STUDENTS_DETAILS_TABLE +" , " +CSSAConstants.EVENT_DETAILS_TABLE 
			+" WHERE "
			+CSSAConstants.EVENT_DETAILS_TABLE+"."+CSSAConstants.EVENT_DETAILS_EVENT_ID +" = ? AND  STUDENTS_DETAILS.STUDENT_ID = EVENT_DETAILS.STUDENT_ID";
	
	
			
	public static final String INSERT_WINNERS = "INSERT INTO "+CSSAConstants.WINNERS_TABLE +"(" 
			+CSSAConstants.WINNERS_COLLEGE_ID +", "
			+CSSAConstants.WINNERS_STUDENT_ID +", "
			+CSSAConstants.WINNERS_EVENT_ID +", "
			+CSSAConstants.WINNERS_RESULT_STATUS +", "
			+CSSAConstants.WINNERS_EVENT_GROUP_ID + ", "
			+CSSAConstants.WINNERS_MARK +") VALUES(?,?,?,?,?,?)";
	
	
	public static final String SELECT_WINNERS = "SELECT "+CSSAConstants.WINNERS_SNO+ " ,"
			+CSSAConstants.WINNERS_COLLEGE_ID +", "
			+CSSAConstants.WINNERS_STUDENT_ID +", "
			+CSSAConstants.WINNERS_EVENT_ID +", "
			+CSSAConstants.WINNERS_RESULT_STATUS+", "
			+CSSAConstants.WINNERS_MARK +" FROM "+CSSAConstants.WINNERS_TABLE +" WHERE "+
			CSSAConstants.WINNERS_STUDENT_ID +" = ? AND "+ CSSAConstants.WINNERS_EVENT_ID +" = ?"; 
	
	public static final String UPDATE_WINNERS = "UPDATE "+CSSAConstants.WINNERS_TABLE +" SET" +
			CSSAConstants.WINNERS_RESULT_STATUS +" = ?"+
			CSSAConstants.WINNERS_MARK + "= ? WHERE "+ CSSAConstants.WINNERS_STUDENT_ID +" = ? AND "
			+CSSAConstants.WINNERS_STUDENT_ID +" = ?  AND "+ CSSAConstants.WINNERS_EVENT_ID +" = ? "; 
	
	//Time Schedule table query started
	
	public static final String INSERT_TIME_SHEET = "INSERT INTO "+ CSSAConstants.TIMESHEET_TABLE +" ("
			+ CSSAConstants.TIMESHEET_DAY +", "
			+ CSSAConstants.TIMESHEET_START_TIME +", "
			+ CSSAConstants.TIMESHEET_END_TIME +", "
			+ CSSAConstants.TIMESHEET_EVENT_ID +", "
			+ CSSAConstants.TIMESHEET_EVENT_STAGE +", "
			+ CSSAConstants.TIMESHEET_VENUE +") VALUES(?,?,?,?,?,?)";
	public static final String INSERT_TIME_SHEET_ADD = "INSERT INTO "+ CSSAConstants.TIMESHEET_TABLE +" ("
			+ CSSAConstants.TIMESHEET_DAY +") VALUES(?)";
	
	public static final String SELECT_TIMESHEET_BY_DATE = " SELECT "+CSSAConstants.TIMESHEET_SNO +" , "
			+ CSSAConstants.TIMESHEET_DAY +", "
			+ CSSAConstants.TIMESHEET_START_TIME +", "
			+ CSSAConstants.TIMESHEET_END_TIME +", "
			+ CSSAConstants.TIMESHEET_EVENT_ID +", "
			+ CSSAConstants.TIMESHEET_EVENT_STAGE +", "
			+ CSSAConstants.TIMESHEET_VENUE +" FROM "+ CSSAConstants.TIMESHEET_TABLE +" WHERE "
			+ CSSAConstants.TIMESHEET_DAY +" =  ? ";
	
	public static final String UPDATE_TIMESHEET_BY_DATE  = " UPDATE "+CSSAConstants.TIMESHEET_TABLE +" SET "
			+CSSAConstants.TIMESHEET_START_TIME +" = ?, "
			+ CSSAConstants.TIMESHEET_END_TIME +" = ?,  "
			+ CSSAConstants.TIMESHEET_EVENT_ID +" = ?,  "
			+ CSSAConstants.TIMESHEET_EVENT_STAGE +"= ?,  "
			+ CSSAConstants.TIMESHEET_VENUE +"=  ?  WHERE "+ CSSAConstants.TIMESHEET_SNO+" = ?";
			
	public static final String DELETE_TIMESHEET = "DELETE FROM  "+CSSAConstants.TIMESHEET_TABLE +"  WHERE "+ CSSAConstants.TIMESHEET_SNO+" = ?";
}
