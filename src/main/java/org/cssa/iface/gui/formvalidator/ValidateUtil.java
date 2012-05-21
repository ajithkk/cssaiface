package org.cssa.iface.gui.formvalidator;
/**
 * 
 * @author ajith
 * @since 2/1/2012
 */
public abstract class ValidateUtil {
    /**
     * 
     * @param item
     * @return true if the item is empty or null otherwise false 
     */
	public  boolean isEmpty(String item) {
		if(null == item) {
			return true;
		}
		if(item.isEmpty()) {
			return true;
		}
		return false;
	}
	
	 /**
	  * 
	  * @param string
	  * @return true if the string is number otherwise  false
	  */
	 public static boolean isNumber(String string) {
		    return string.matches("^\\d+$");
		  }
	 
	 public abstract boolean validateForm();

}
