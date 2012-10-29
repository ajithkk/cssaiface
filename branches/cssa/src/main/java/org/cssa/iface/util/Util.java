package org.cssa.iface.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.cssa.iface.infrastructure.CSSAConstants;


/**
 * @author ajith
* Static convenience methods for common tasks, which eliminate code duplication.
*/
public class Util {
	
	/**
	  * Return a {@link Logger} whose name follows a specific naming convention.
	  *
	  * <P>The conventional logger names are taken as   
	  * <tt>aClass.getPackage().getName()</tt>.
	  * 
	  * <P>Logger names appearing in the <tt>logging.properties</tt> config file
	  * must match the names returned by this method.
	  */
	
	public static Logger getLogger(Class<?> aClass) {
		return Logger.getLogger(aClass.getPackage().getName());
	}
	
	public static void exitApplicataion() {
		System.exit(0);
	}
	
	public static char getGender(String gender) {
		char gen ='0';
		if("Male".equalsIgnoreCase(gender)) {
			gen = CSSAConstants.MALE;
		} else if ("Female".equalsIgnoreCase(gender)) {
			gen =  CSSAConstants.FEMALE;
		}
		return gen;
	}
	
	public static Date convertDate(String date) {
		Date soure = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(CSSAConstants.DATE_FORMAT);
		try {
			 soure = dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return soure;
	}
	public static String getReportHome() {
		return System.getProperty("user.home")+"\\"+CSSAConstants.REPORT_HOME;
	}
	
	public static String getCurrentTimeStamp() {
	    SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    return strDate;
	}
}
