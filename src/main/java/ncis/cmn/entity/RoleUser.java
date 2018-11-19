package ncis.cmn.entity;

import org.hibernate.validator.constraints.NotEmpty;

public class RoleUser {

	@NotEmpty(message="롤 코드는 필수 항목입니다.")
	private String roleCode;
	
	@NotEmpty(message="사용자 아이디는 필수 항목입니다.")
	private String userId;

	/**
	 * @return the roleCode
	 */
	public String getRoleCode() {
		return roleCode;
	}
	/**
	 * @param roleCode the roleCode to set
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
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
