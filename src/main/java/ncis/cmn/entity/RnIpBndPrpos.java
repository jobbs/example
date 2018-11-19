package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * IP대역용도 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RnIpBndPrpos {

    /**
     * 대역SEQ
     */
    @NotEmpty(message = "대역SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal bndSeq;

    /**
     * 용도구분코드
     */
    @NotEmpty(message = "용도구분코드는(은) 필수입력 항목입니다.")
    private String prposClCd;

    public String getPrposClCd() {
        return prposClCd;
    }

    public void setPrposClCd(String prposClCd) {
        this.prposClCd = prposClCd;
    }

    public BigDecimal getBndSeq() {
        return bndSeq;
    }

    public void setBndSeq(BigDecimal bndSeq) {
        this.bndSeq = bndSeq;
    }

}
