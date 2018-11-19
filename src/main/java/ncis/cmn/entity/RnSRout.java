package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 스태틱라우터 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RnSRout {

    /**
     * 스태틱라우터SEQ
     */
    @NotEmpty(message = "스태틱라우터SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal sRoutSeq;

    /**
     * IP대역주소
     */
    private String ipBndAddr;

    /**
     * 서브넷마스크
     */
    private String subnetMask;

    /**
     * 게이트웨이명
     */
    @NotEmpty(message = "게이트웨이명는(은) 필수입력 항목입니다.")
    private String gtwyNm;

    /**
     * 대역SEQ
     */
    @NotEmpty(message = "대역SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal bndSeq;

    public String getIpBndAddr() {
        return ipBndAddr;
    }

    public void setIpBndAddr(String ipBndAddr) {
        this.ipBndAddr = ipBndAddr;
    }

    public String getSubnetMask() {
        return subnetMask;
    }

    public void setSubnetMask(String subnetMask) {
        this.subnetMask = subnetMask;
    }

    public String getGtwyNm() {
        return gtwyNm;
    }

    public void setGtwyNm(String gtwyNm) {
        this.gtwyNm = gtwyNm;
    }

    public BigDecimal getBndSeq() {
        return bndSeq;
    }

    public void setBndSeq(BigDecimal bndSeq) {
        this.bndSeq = bndSeq;
    }

    public BigDecimal getsRoutSeq() {
        return sRoutSeq;
    }

    public void setsRoutSeq(BigDecimal sRoutSeq) {
        this.sRoutSeq = sRoutSeq;
    }

}
