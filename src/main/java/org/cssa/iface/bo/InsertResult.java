package org.cssa.iface.bo;

public class InsertResult extends StudentDetails {
	
	private String eventName;
	private String groupName;
	private char eventStatus;
	private float mark;
	
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
	public char getEventStatus() {
		return eventStatus;
	}
	/**
	 * @param eventStatus the eventStatus to set
	 */
	public void setEventStatus(char eventStatus) {
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