/**
 * 
 */
package org.cssa.iface.infrastructure;

/**
 * @author KK
 * @since 12/16/2011
 */
public class CSSAConstants {
	
	public static final String CONFIG_XML_FILE = "cssa_interface.xml";
	public static final String CONFIG_PROPERTIES_FILE = "CSSA_IFACE.properties";
	public static final String DATE_FORMAT = "MM/dd/yyyy";
	public static final String REPORT_HOME = "report";
	
	public static final String APP_NAME = "Interface Registration software";
	public static final String APP_VERSION = "2.0";
	public static final String AUTHOR = "Ajith K K";
	  
	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final String FILE_SEPARATOR = System.getProperty("file.separator");
	public static final String PATH_SEPARATOR = System.getProperty("path.separator");
	
	public static final String MAX_TEAM_MEMBERS = "MAX_TEAM_MEMBERS";
	public static final int MAX_EVENT_PARTICIPATION = 4; 
	
	public static final int FAIL = -1;
	public static final String MALE = "M";
	public static final String FEMALE = "F";
	
	public static final String COLLEGE_ID_PRE_STRING = "IT";
	public static final String COLLEGE_ID_PRE_ZERO = "0";
	
	public static final String EVENTS_TABLE = "EVENTS";
	public static final String EVENT_DETAILS_TABLE = "EVENT_DETAILS";
	public static final String COLLEGE_DETAILS_TABLE = "COLLEGE_DETAILS";
	public static final String STUDENTS_DETAILS_TABLE = "STUDENTS_DETAILS";
	public static final String RESULTS_TABLE = "RESULTS";
	public static final String SEMINAR_DETAILS_TABLE = "SEMINAR_DETAILS";
	public static final String WINNERS_TABLE = "WINNERS";
	public static final String TIMESHEET_TABLE = "TIMESHEET";
	
	public static final String EVENTS_SNO = "SNO";
	public static final String EVENTS_EVENT_ID = "EVENT_ID";
	public static final String EVENTS_EVENT_NAME = "EVENT_NAME";
	public static final String EVENTS_MAX_NO_OF_PARTICIPANTS = "MAX_NO_OF_PARTICIPANTS";
	public static final String EVENTS_EVENT_POINT = "EVENT_POINT";

	public static final String COLLEGE_DETAILS_SNO = "SNO";
	public static final String COLLEGE_DETAILS_COLLEGE_ID = "COLLEGE_ID";
	public static final String COLLEGE_DETAILS_COLLEGE_NAME = "COLLEGE_NAME";
	public static final String COLLEGE_DETAILS_COLLEGE_ADDRESS = "COLLEGE_ADDRESS";
	public static final String COLLEGE_DETAILS_COLLEGE_PHONE = "COLLEGE_PHONE";
	public static final String COLLEGE_DETAILS_NO_OF_PARTICIPANTS = "NO_OF_PARTICIPANTS";
	public static final String COLLEGE_DETAILS_COLLEGE_POINTS = "COLLEGE_POINTS";
	public static final String COLLEGE_DETAILS_STATUS = "STATUS";
	
	public static final String EVENT_DETAILS_SNO = "SNO";
	public static final String EVENT_DETAILS_STUDENT_ID = "STUDENT_ID";
	public static final String EVENT_DETAILS_GROUP_ID = "GROUP_ID";
	public static final String EVENT_DETAILS_EVENT_ID = "EVENT_ID";
	public static final String EVENT_DETAILS_COLLEGE_ID = "COLLEGE_ID";
	public static final String EVENT_DETAILS_EVENT_STAGE = "EVENT_STAGE";
	public static final String EVENT_DETAILS_MARK = "MARK";
	
	
	public static final String STUDENTS_DETAILS_SNO = "SNO";
	public static final String STUDENTS_DETAILS_COLLEGE_ID = "COLLEGE_ID";
	public static final String STUDENTS_DETAILS_STUDENT_ID = "STUDENT_ID";
	public static final String STUDENTS_DETAILS_STUDENT_NAME = "STUDENT_NAME";
	public static final String STUDENTS_DETAILS_STUDENT_GENDER = "STUDENT_GENDER";
	public static final String STUDENTS_DETAILS_STUDENT_PHONE = "STUDENT_PHONE";
	public static final String STUDENTS_DETAILS_STUDENT_POINT = "STUDENT_POINT";
	public static final String STUDENTS_DETAILS_STATUS = "STATUS";
	public static final String STUDENT_DETAILS_ACCOMMODATION = "ACCOMMODATION";
	
	public static final String RESULTS_SNO = "SNO";
	public static final String RESULTS_COLLEGE_ID = "COLLEGE_ID";
	public static final String RESULTS_STUDENT_ID = "STUDENT_ID";
	public static final String RESULTS_EVENT_ID = "EVENT_ID";
	public static final String RESULTS_EVENT_GROUP_ID = "GROUP_ID";
	public static final String RESULTS_RESULT_STATUS = "RESULT_STATUS";
	public static final String RESULTS_MARK = "MARK";
	
	public static final String WINNERS_SNO = "SNO";
	public static final String WINNERS_COLLEGE_ID = "COLLEGE_ID";
	public static final String WINNERS_STUDENT_ID = "STUDENT_ID";
	public static final String WINNERS_EVENT_ID = "EVENT_ID";
	public static final String WINNERS_EVENT_GROUP_ID = "GROUP_ID";
	public static final String WINNERS_RESULT_STATUS = "WINNER_STATUS";
	public static final String WINNERS_MARK = "MARK";
	
	public static final String SEMINAR_DETAILS_SNO = "SNO";
	public static final String SEMINAR_DETAILS_NAME = "NAME";
	public static final String SEMINAR_DETAILS_COURSE = "COURSE";
	public static final String SEMINAR_DETAILS_COLLEGE_NAME = "COLLEGE_NAME";
	public static final String SEMINAR_DETAILS_ADDRESS = "ADDRESS";
	public static final String SEMINAR_DETAILS_PHONE = "PHONE";
	public static final String SEMINAR_DETAILS_EMAIL = "EMAIL";
	public static final String SEMINAR_DETAILS_DUTY_CERTIFICATE = "DUTY_CERTIFICATE";
	
	public static final String TIMESHEET_SNO = "SNO";
	public static final String TIMESHEET_EVENT_ID = "EVENT_ID";
	public static final String TIMESHEET_START_TIME = "START_TIME";
	public static final String TIMESHEET_END_TIME = "END_TIME";
	public static final String TIMESHEET_EVENT_STAGE = "EVENT_STAGE";
	public static final String TIMESHEET_VENUE = "VENUE";
	public static final String TIMESHEET_DAY = "DAY";
	
	public static final String[] EVENT_DETAILS_COLUMN_NAMES = {"SNO", "EVENT CODE NAME", "EVENT NAME", "NO OF PARTICIPANTS", "POINTS" };
	public static final String[] COLLEGE_DETAILS_COLUMN_NAMES = {"SNO","COLLEGE ID", "COLLEGE NAME", "ADDRESS", "PHONE NUMBER","NUMBER OF PARTICIPANTS","STATUS","POINTS"};
	public static final String[] COLLEGE_INITIAL_DETAILS_COLUMN_NAMES = {"SNO","STUDENT ID", "STUDENT NAME", "EVENTS"};
	public static final String[] STUDENT_LOOKUP_COLUMN_NAMES = {"SNO","COLLEGE ID","COLLEGE NAME","STUDENT ID","STUDENT NAME","PHONE NUMBER","POINT","ACCOMMODATION","ACTIVE"};
	public static final String[] STUDENT_DETAILS_COLUMN_NAMES = {"SNO","COLLEGE ID","STUDENT ID","STUDENT NAME","GENDER","PHONE NUMBER","POINT","ACCOMMODATION","STATUS"};
	public static final String[] INSERT_RESULT_TABLE_COLUMN_NAMES = {"SNO","COLLEGE ID","STUDENT ID","STUDENT NAME","EVENT ID","GROUP NAME", "EVENT STAGE"};
	public static final String[] INSERT_RESULT_COLUMN_NAMES = {"SNO","COLLEGE ID","STUDENT ID","STUDENT NAME","EVENT ID","GROUP NAME","MARK","EVENT STAGE"};
	public static final String[] EVENT_RESULT_TABLE_COLUMN_NAMES = {"SNO","COLLEGE ID","COLLEGE NAME", "STUDENT ID","STUDENT NAME","EVENT ID","GROUP NAME", "EVENT STAGE"};
	public static final String[] TIMESHEET_COLUMN_NAMES = {"TIME ID","DATE","EVENT NAME","START TIME", "END TIME","EVENT ROUND","VENUE"};
	public static final String[] WINNERS_TABLE_COLUMN_NAMES = {"SNO","COLLEGE ID","STUDENT ID","STUDENT NAME","EVENT ID","GROUP NAME", "POSITION"};
	public static final String[] EVENT_DETAILS_TABLE_COLUMN_NAMES = {"SNO","COLLEGE ID","STUDENT ID","EVENT ID","GROUP NAME"};
	public static final String[] RESULT_COLUMN_NAMES = {"SNO","COLLEGE ID","STUDENT ID","EVENT ID","RESULT STATUS","GROUP NAME","MARK"};
	public static final String[] GROUP_COLUMN_NAMES = {"SNO","COLLEGE ID","COLLEGE NAME","STUDENT ID","STUDENT NAME","EVENT ID","GROUP ID","PHONE","ACTIVE"};
	
	public static final String SPLASH_IMAGE = "crazy-turtle-cartoon-comic.png";

	public static final String HELP_FILE = "HelpSet.cs";
	
	public static final String SYSYEM = "system";
	public static final String MOTIF = "motif";
	public static final String GTK = "gtk";
	public static final String NIMBUS = "nimbus";
	public static final String JAVA = "java";
	public static final String WINDOWS = "windows";
	

}
