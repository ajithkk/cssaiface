/**
 * 
 */
package org.cssa.iface.bo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ajith
 *
 */

@XmlRootElement( name ="cssa", namespace = " org.cssa.iface.bo" )
public class TimeScheduleStore {
	@XmlElement(name = "timeSchedule")
	private ArrayList<TimeSchedule>scheduleList;

	public ArrayList<TimeSchedule> getTimeScheduleList() {
		return scheduleList;
	}

	public void setTimeScheduleList(ArrayList<TimeSchedule> scheduleList) {
		this.scheduleList = scheduleList;
	}
	
	
}
