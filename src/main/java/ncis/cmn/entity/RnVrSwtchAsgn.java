package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 가상스위치(VLAN)할당 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RnVrSwtchAsgn {

    /**
     * 가상스위치SEQ
     */
    @NotEmpty(message = "가상스위치SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal vrSwtchSeq;

    /**
     * 대역SEQ
     */
    @NotEmpty(message = "대역SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal bndSeq;

    public BigDecimal getVrSwtchSeq() {
        return vrSwtchSeq;
    }

    public void setVrSwtchSeq(BigDecimal vrSwtchSeq) {
        this.vrSwtchSeq = vrSwtchSeq;
    }

    public BigDecimal getBndSeq() {
        return bndSeq;
    }

    public void setBndSeq(BigDecimal bndSeq) {
        this.bndSeq = bndSeq;
    }

}
