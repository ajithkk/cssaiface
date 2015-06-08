/**
 * 
 */
package org.cssa.iface.bo;

/**
 * @author Ajith K K
 * @since 12/12/2011
 */
public class Events {
	
	private int sno;
	private String eventName;
	private int maxNoOfParticipants;
	private int points;
	private String eventId;
	
	/**
	 * @return the sno
	 */
	public int getSno() {
		return sno;
	}
	/**
	 * @param sno the sno to set
	 */
	public void setSno(int sno) {
		this.sno = sno;
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
	 * @return the maxNoOfParticipants
	 */
	public int getMaxNoOfParticipants() {
		return maxNoOfParticipants;
	}
	/**
	 * @param maxNoOfParticipants the maxNoOfParticipants to set
	 */
	public void setMaxNoOfParticipants(int maxNoOfParticipants) {
		this.maxNoOfParticipants = maxNoOfParticipants;
	}
	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}
	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	/**
	 * @return the eventId
	 */
	public String getEventId() {
		return eventId;
	}
	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	

}
