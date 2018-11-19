package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 클러스터용도 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RcClstrPrpos {

    /**
     * 클러스터SEQ
     */
    @NotEmpty(message = "클러스터SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal clstrSeq;

    /**
     * 용도구분코드
     */
    @NotEmpty(message = "용도구분코드는(은) 필수입력 항목입니다.")
    private String prposClCd;

    public BigDecimal getClstrSeq() {
        return clstrSeq;
    }

    public void setClstrSeq(BigDecimal clstrSeq) {
        this.clstrSeq = clstrSeq;
    }

    public String getPrposClCd() {
        return prposClCd;
    }

    public void setPrposClCd(String prposClCd) {
        this.prposClCd = prposClCd;
    }

}
