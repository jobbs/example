/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CmInsttUser.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 12. 1.
 * @lastmodified 2016. 12. 1.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 1.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cmn.entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author 박봉춘
 *
 */
public class CmInsttUser {

	/**
	 * 부처ID
	 */
	@NotEmpty(message = "부처ID는(은) 필수입력 항목입니다.")
	private String institutionId;

	/**
     * 사용자ID
     */
    @NotEmpty(message = "사용자ID는(은) 필수입력 항목입니다.")
	private String userId;

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
}
