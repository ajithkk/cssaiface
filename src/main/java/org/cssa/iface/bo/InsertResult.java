package org.cssa.iface.bo;

/**
 * 
 * @author ajith
 *
 */

public class InsertResult extends StudentDetails {
	
	private String eventName;
	private String groupName;
	private String eventStatus;
	private String collegeName;
	private float mark;
	
	/**
	 * @return the collegeName
	 */
	public String getCollegeName() {
		return collegeName;
	}
	/**
	 * @param collegeName the collegeName to set
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
	
	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}
	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	
	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}
	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/**
	 * @return the eventStatus
	 */
	public String getEventStatus() {
		return eventStatus;
	}
	/**
	 * @param eventStatus the eventStatus to set
	 */
	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}
	/**
	 * @return the mark
	 */
	public float getMark() {
		return mark;
	}
	/**
	 * @param mark the mark to set
	 */
	public void setMark(float mark) {
		this.mark = mark;
	}
	
	

}
