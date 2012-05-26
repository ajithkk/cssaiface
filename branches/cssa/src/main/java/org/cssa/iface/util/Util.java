package org.cssa.iface.util;

import java.util.logging.Logger;
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
}
