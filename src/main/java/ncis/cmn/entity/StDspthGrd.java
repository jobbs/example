package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 통보등급 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class StDspthGrd {

    /**
     * 통보설정ID
     */
    @NotEmpty(message = "통보설정ID는(은) 필수입력 항목입니다.")
    private BigDecimal dspthConfId;

    /**
     * 통보등급코드
     */
    private String dspthGrdCd;

    public BigDecimal getDspthConfId() {
        return dspthConfId;
    }

    public void setDspthConfId(BigDecimal dspthConfId) {
        this.dspthConfId = dspthConfId;
    }

    public String getDspthGrdCd() {
        return dspthGrdCd;
    }

    public void setDspthGrdCd(String dspthGrdCd) {
        this.dspthGrdCd = dspthGrdCd;
    }

}
