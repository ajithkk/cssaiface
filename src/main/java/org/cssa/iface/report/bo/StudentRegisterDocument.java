package org.cssa.iface.report.bo;

import java.util.List;

import org.cssa.iface.bo.StudentDetails;

/**
 * 
 * @author ajith
 *
 */

public class StudentRegisterDocument {
	
	private String collegeName;
	private int numberOfParticipants;
	private String phoneNumber;
	private String collegeId;
	private List<StudentDetails> studentDetails;
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
	 * @return the numberOfParticipants
	 */
	public int getNumberOfParticipants() {
		return numberOfParticipants;
	}
	/**
	 * @param numberOfParticipants the numberOfParticipants to set
	 */
	public void setNumberOfParticipants(int numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the studentDetails
	 */
	public List<StudentDetails> getStudentDetails() {
		return studentDetails;
	}
	/**
	 * @param studentDetails the studentDetails to set
	 */
	public void setStudentDetails(List<StudentDetails> studentDetails) {
		this.studentDetails = studentDetails;
	}
	
	

}
