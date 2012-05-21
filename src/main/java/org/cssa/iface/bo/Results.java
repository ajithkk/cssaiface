package org.cssa.iface.bo;
/**
 * 
 * @author Ajith
 * @since 12/12/2011
 */
public class Results {
	
	
	private int sno;
	private String collegeId;
	private String studentId;
	private String eventId;
	private char eventStatus;
	private float mark;
	
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
	 * @return the collegeId
	 */
	public String getCollegeId() {
		return collegeId;
	}
	/**
	 * @param collegeId the collegeId to set
	 */
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	/**
	 * @return the studentId
	 */
	public String getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
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
