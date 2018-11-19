package ncis.cmn.entity;

import java.util.Date;

import javax.validation.constraints.Size;

import ncis.cmn.validation.groups.InsertProc;

import org.hibernate.validator.constraints.NotEmpty;

public class CmRole {

    /**
     * 롤코드
     */
    @NotEmpty(message="롤 코드를 입력하세요", groups={ InsertProc.class })
    @Size(max=7, message="롤코드는 6자리 이하로 입력하세요", groups={ InsertProc.class })
    private String roleCd;

    /**
     * 롤명
     */
    @NotEmpty(message="메뉴명을 입력하세요")
    @Size(max=200, message="롤명은 200자리 이하로 입력하세요")
    private String roleNm;

    /**
     * 롤타입
     */
    @NotEmpty(message="롤 타입은 필수 항목입니다.")
    private String roleTyCd;

    /**
     * 사용여부
     */
    @NotEmpty(message="사용여부를 선택하세요", groups={ InsertProc.class })
    private String useYn;

    /**
     * 등록일자
     */
    private Date regDttm;
    /**
     * 등록자 아이디
     */
    private String regUserId;

    /**
     * 수정일자
     */
    private Date updtDttm;

    /**
     * 수정자 아이디
     */
    private String updtUserId;

    /**
     * @return the roleCode
     */
    public String getRoleCd() {

        if( null != roleCd && !"".equals(roleCd))
            return roleCd.toUpperCase().trim();
        else
            return roleCd;
    }
    /**
     * @param roleCode the roleCode to set
     */
    public void setRoleCd(String roleCd) {

        if( null != roleCd && !"".equals(roleCd))
            roleCd = roleCd.toUpperCase().trim();

        this.roleCd = roleCd;
    }
    /**
     * @return the roleName
     */
    public String getRoleNm() {
        return roleNm;
    }
    /**
     * @param roleName the roleName to set
     */
    public void setRoleNm(String roleNm) {
        this.roleNm = roleNm;
    }
    /**
     * @return the regDate
     */
    public Date getRegDttm() {
        return regDttm;
    }
    /**
     * @param regDate the regDate to set
     */
    public void setRegDttm(Date regDttm) {
        this.regDttm = regDttm;
    }
    /**
     * @return the regId
     */
    public String getRegUserId() {
        return regUserId;
    }
    /**
     * @param regId the regId to set
     */
    public void setRegUserId(String regUserId) {
        this.regUserId = regUserId;
    }
    /**
     * @return the modDate
     */
    public Date getUpdtDttm() {
        return updtDttm;
    }
    /**
     * @param modDate the modDate to set
     */
    public void setUpdtDttm(Date updtDttm) {
        this.updtDttm = updtDttm;
    }
    /**
     * @return the modId
     */
    public String getUpdtUserId() {
        return updtUserId;
    }
    /**
     * @param modId the modId to set
     */
    public void setUpdtUserId(String updtUserId) {
        this.updtUserId = updtUserId;
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
	/**
	 * @return the roleTyCd
	 */
	public String getRoleTyCd() {
		return roleTyCd;
	}
	/**
	 * @param roleTyCd the roleTyCd to set
	 */
	public void setRoleTyCd(String roleTyCd) {
		this.roleTyCd = roleTyCd;
	}


}
