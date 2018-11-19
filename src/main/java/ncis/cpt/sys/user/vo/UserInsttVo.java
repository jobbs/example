/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserInstitutionVo.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 11. 30.
 * @lastmodified 2016. 11. 30.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 30.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.sys.user.vo;

import ncis.cmn.entity.CmInstitution;

/**
 * @author 박봉춘
 *
 */
public class UserInsttVo extends CmInstitution{

	private String institutionId;

	private String userId;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the institutionId
	 */
	public String getInstitutionId() {
		return institutionId;
	}

	/**
	 * @param institutionId the institutionId to set
	 */
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}

}
