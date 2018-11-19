package ncis.cmn.entity;

import java.util.Date;

import javax.validation.constraints.Size;

import ncis.cmn.validation.groups.InsertProc;

import org.hibernate.validator.constraints.NotEmpty;

public class RoleInfo {

	/**
	 * 롤코드
	 */
	@NotEmpty(message="롤 코드를 입력하세요", groups={ InsertProc.class })
	@Size(max=7, message="롤코드는 6자리 이하로 입력하세요", groups={ InsertProc.class })
	private String roleCode; 
	
	/**
	 * 롤명
	 */
	@NotEmpty(message="메뉴명을 입력하세요")
	@Size(max=200, message="롤명은 200자리 이하로 입력하세요")
	private String roleName; 
	
	/**
	 * 사용여부
	 */
	@NotEmpty(message="사용여부를 선택하세요", groups={ InsertProc.class })
	private String useYn;
	
	/**
	 * 등록일자
	 */
	private Date regDate;
	/**
	 * 등록자 아이디
	 */
	private String regId;
	
	/**
	 * 수정일자
	 */
	private Date modDate;
	
	/**
	 * 수정자 아이디
	 */
	private String modId;

	/**
	 * @return the roleCode
	 */
	public String getRoleCode() {
		
		if( null != roleCode && !"".equals(roleCode)) 
			return roleCode.toUpperCase().trim();
		else 
			return roleCode;
	}
	/**
	 * @param roleCode the roleCode to set
	 */
	public void setRoleCode(String roleCode) {
		
		if( null != roleCode && !"".equals(roleCode))
			roleCode = roleCode.toUpperCase().trim();
		
		this.roleCode = roleCode;
	}
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the regDate
	 */
	public Date getRegDate() {
		return regDate;
	}
	/**
	 * @param regDate the regDate to set
	 */
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	/**
	 * @return the regId
	 */
	public String getRegId() {
		return regId;
	}
	/**
	 * @param regId the regId to set
	 */
	public void setRegId(String regId) {
		this.regId = regId;
	}
	/**
	 * @return the modDate
	 */
	public Date getModDate() {
		return modDate;
	}
	/**
	 * @param modDate the modDate to set
	 */
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	/**
	 * @return the modId
	 */
	public String getModId() {
		return modId;
	}
	/**
	 * @param modId the modId to set
	 */
	public void setModId(String modId) {
		this.modId = modId;
	}
	/**
	 * @return the useYn
	 */
	public String getUseYn() {
		return useYn;
	}
	/**
	 * @param useYn the useYn to set
	 */
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}


}
