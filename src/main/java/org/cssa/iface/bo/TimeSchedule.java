/**
 * 
 */
package org.cssa.iface.bo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author ajith
 *
 */

@XmlRootElement(name = "timeSchedule")
@XmlType(propOrder = {"scheduleDay","scheduleDate"})
public class TimeSchedule {
	
	private String scheduleDay;
	private String scheduleDate;
	
	/**
	 * @return the scheduleDay
	 */
	@XmlElement(name = "scheduleDay")
	public String getScheduleDay() {
		return scheduleDay;
	}
	/**
	 * @param scheduleDay the scheduleDay to set
	 */
	public void setScheduleDay(String scheduleDay) {
		this.scheduleDay = scheduleDay;
	}
	/**
	 * @return the scheduleDate
	 */
	public String getScheduleDate() {
		return scheduleDate;
	}
	/**
	 * @param scheduleDate the scheduleDate to set
	 */
	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	
	

}
