package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * LUN사용물리서버 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RsLunUsePm {

    /**
     * LUN_ID
     */
    @NotEmpty(message = "LUN_ID는(은) 필수입력 항목입니다.")
    private BigDecimal lunId;

    /**
     * 물리서버ID
     */
    @NotEmpty(message = "물리서버ID는(은) 필수입력 항목입니다.")
    private String pmId;

    public BigDecimal getLunId() {
        return lunId;
    }

    public void setLunId(BigDecimal lunId) {
        this.lunId = lunId;
    }

    public String getPmId() {
        return pmId;
    }

    public void setPmId(String pmId) {
        this.pmId = pmId;
    }

}
