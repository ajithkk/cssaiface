/**
 * 
 */
package org.cssa.iface.bo;

/**
 * @author Ajith
 * @since 12/12/2011
 */
public class StudentDetails extends CollegeDetails {
	
	
	private int sno;
	private String studentId;
	private String studentName;
	private String studentGender;
	private String studentPhone;
	private float studentPoint;
	private boolean status;
	private boolean accommodation;
	
	
	/**
	 * @return the accommodation
	 */
	public boolean isAccommodation() {
		return accommodation;
	}
	/**
	 * @param accommodation the accommodation to set
	 */
	public void setAccommodation(boolean accommodation) {
		this.accommodation = accommodation;
	}
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
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	/**
	 * @return the studentGender
	 */
	public String getStudentGender() {
		return studentGender;
	}
	/**
	 * @param gender the studentGender to set
	 */
	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}
	/**
	 * @return the studentPhone
	 */
	public String getStudentPhone() {
		return studentPhone;
	}
	/**
	 * @param studentPhone the studentPhone to set
	 */
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	/**
	 * @return the studentPoint
	 */
	public float getStudentPoint() {
		return studentPoint;
	}
	/**
	 * @param studentPoint the studentPoint to set
	 */
	public void setStudentPoint(float studentPoint) {
		this.studentPoint = studentPoint;
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
