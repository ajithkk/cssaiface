/**
 * 
 */
package org.cssa.iface.bo;

/**
 * @author Ajith
 * @since 12/12/2011
 */
public class CollegeDetails {

	
	private int sno;
	private String collegeId;
	private String collegeName;
	private String collegeAddress;
	private String collegePhone;
	private int noOfParticipants;
	private float collegePoints;
	private boolean status;
	
	
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
	 * 
	 * @return the collegeName
	 */
	public String getCollegeName() {
		return collegeName;
	}
	/**
	 * 
	 * @param collegeName the collegeName to set 
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	/**
	 * @return the collegeAddress
	 */
	public String getCollegeAddress() {
		return collegeAddress;
	}
	/**
	 * @param collegeAddress the collegeAddress to set
	 */
	public void setCollegeAddress(String collegeAddress) {
		this.collegeAddress = collegeAddress;
	}
	/**
	 * @return the collegePhone
	 */
	public String getCollegePhone() {
		return collegePhone;
	}
	/**
	 * @param collegePhone the collegePhone to set
	 */
	public void setCollegePhone(String collegePhone) {
		this.collegePhone = collegePhone;
	}
	/**
	 * @return the noOfParticipants
	 */
	public int getNoOfParticipants() {
		return noOfParticipants;
	}
	/**
	 * @param noOfParticipants the noOfParticipants to set
	 */
	public void setNoOfParticipants(int noOfParticipants) {
		this.noOfParticipants = noOfParticipants;
	}
	/**
	 * @return the collegePoints
	 */
	public float getCollegePoints() {
		return collegePoints;
	}
	/**
	 * @param collegePoints the collegePoints to set
	 */
	public void setCollegePoints(float collegePoints) {
		this.collegePoints = collegePoints;
	}
	
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
