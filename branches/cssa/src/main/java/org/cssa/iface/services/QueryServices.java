/**
 * 
 */
package org.cssa.iface.services;

import org.cssa.iface.bo.CollegeDetails;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.infrastructure.CSSAConstants;

/**
 * @author ajith
 * @since 1/9/2012
 *
 */
public class QueryServices {
	/**
	 * 
	 * @param collegeDetails
	 * @return
	 * @throws IfaceException
	 */
	public String getCollegeSearchQuery(CollegeDetails collegeDetails) throws IfaceException {
		StringBuilder collegeSearchQuery = new StringBuilder();
		boolean addStringFlag = false;
		collegeSearchQuery.append("SELECT "+ CSSAConstants.COLLEGE_DETAILS_SNO +"," 
				+CSSAConstants.COLLEGE_DETAILS_COLLEGE_ID +","
				+CSSAConstants.COLLEGE_DETAILS_COLLEGE_NAME + ","
				+CSSAConstants.COLLEGE_DETAILS_COLLEGE_ADDRESS +","
				+CSSAConstants.COLLEGE_DETAILS_COLLEGE_PHONE+","
				+CSSAConstants.COLLEGE_DETAILS_NO_OF_PARTICIPANTS+","
				+CSSAConstants.COLLEGE_DETAILS_COLLEGE_POINTS+","
				+CSSAConstants.COLLEGE_DETAILS_STATUS +"FROM"+CSSAConstants.COLLEGE_DETAILS_TABLE );
		collegeSearchQuery.append("WHERE");
		if(null != collegeDetails.getCollegeName()) {
			collegeSearchQuery.append(CSSAConstants.COLLEGE_DETAILS_COLLEGE_NAME +" LIKE '" + collegeDetails.getCollegeName() +"'");
			addStringFlag = true;
		}
		if( null != collegeDetails.getCollegeId()) {
			if(addStringFlag) {
				collegeSearchQuery.append("AND");
			}
			collegeSearchQuery.append(CSSAConstants.COLLEGE_DETAILS_COLLEGE_ID +"LIKE '"+ collegeDetails.getCollegeId() +"'" );
		}
		return collegeSearchQuery.toString();
		
	}

}
