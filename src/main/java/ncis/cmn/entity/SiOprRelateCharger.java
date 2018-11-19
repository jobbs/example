package ncis.cmn.entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 운영연관담당자 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class SiOprRelateCharger {

    /**
     * 사용자ID
     */
    @NotEmpty(message = "사용자ID는(은) 필수입력 항목입니다.")
    private String userId;

    /**
     * 구성ID
     */
    @NotEmpty(message = "구성ID는(은) 필수입력 항목입니다.")
    private String compId;

    /**
     * 연관자구분코드
     */
    private String relaterClCd;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public String getRelaterClCd() {
        return relaterClCd;
    }

    public void setRelaterClCd(String relaterClCd) {
        this.relaterClCd = relaterClCd;
    }

}
