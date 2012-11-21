package org.cssa.iface.util;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.cssa.iface.exception.IfaceException;
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
	
	public static Date convertDate(String date) throws IfaceException {
		Date soure = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(CSSAConstants.DATE_FORMAT);
		try {
			 soure = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			new IfaceException(e);
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
	
	public  String getScriptFile(String name) {
		URL url = null;
		String fileName = null;
		try {
			ClassLoader loader = this.getClass().getClassLoader();
		    url = loader.getResource("sql" +"/"+ name.trim()); 
			if(null != url) {
				fileName = url.getPath().substring(1);
				
			}
		} catch (Exception e) {
			
		}
		return fileName;
	}
	
}
