package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 이벤트통보대상자 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class StEvntDspthCharger {

    /**
     * 통보대상자ID
     */
    @NotEmpty(message = "통보대상자ID는(은) 필수입력 항목입니다.")
    private String dspthTrgtId;

    /**
     * 통보설정ID
     */
    @NotEmpty(message = "통보설정ID는(은) 필수입력 항목입니다.")
    private BigDecimal dspthConfId;

    public String getDspthTrgtId() {
        return dspthTrgtId;
    }

    public void setDspthTrgtId(String dspthTrgtId) {
        this.dspthTrgtId = dspthTrgtId;
    }

    public BigDecimal getDspthConfId() {
        return dspthConfId;
    }

    public void setDspthConfId(BigDecimal dspthConfId) {
        this.dspthConfId = dspthConfId;
    }

}
