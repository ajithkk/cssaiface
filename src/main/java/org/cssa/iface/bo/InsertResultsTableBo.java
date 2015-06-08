package org.cssa.iface.bo;

/**
 * 
 * @author ajith
 *
 */

public class InsertResultsTableBo extends StudentDetails {
	
	private String groupName;
	private String eventId;
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
	 * @return the eventName
	 */
	public String getEventId() {
		return eventId;
	}
	/**
	 * @param eventName the eventName to set
	 */
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	
}
