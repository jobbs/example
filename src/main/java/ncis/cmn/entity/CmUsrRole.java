package ncis.cmn.entity;

import org.hibernate.validator.constraints.NotEmpty;

public class CmUsrRole {

    @NotEmpty(message="롤 코드는 필수 항목입니다.")
    private String roleCd;

    @NotEmpty(message="사용자 아이디는 필수 항목입니다.")
    private String userId;

    /**
     * @return the roleCode
     */
    public String getRoleCd() {
        return roleCd;
    }
    /**
     * @param roleCode the roleCode to set
     */
    public void setRoleCd(String roleCd) {
        this.roleCd = roleCd;
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
