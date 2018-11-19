package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 통보형식 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class StDspthForm {

    /**
     * 통보설정ID
     */
    @NotEmpty(message = "통보설정ID는(은) 필수입력 항목입니다.")
    private BigDecimal dspthConfId;

    /**
     * 통보형식코드
     */
    private String dspthTyCd;

    public BigDecimal getDspthConfId() {
        return dspthConfId;
    }

    public void setDspthConfId(BigDecimal dspthConfId) {
        this.dspthConfId = dspthConfId;
    }

    public String getDspthTyCd() {
        return dspthTyCd;
    }

    public void setDspthTyCd(String dspthTyCd) {
        this.dspthTyCd = dspthTyCd;
    }

}
