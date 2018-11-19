package ncis.cmn.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * IP Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RnIp {

    /**
     * IP주소
     */
    @NotEmpty(message = "IP주소는(은) 필수입력 항목입니다.")
    private String ipAddr;

    /**
     * 대역SEQ
     */
    @NotEmpty(message = "대역SEQ는(은) 필수입력 항목입니다.")
    private Integer bndSeq;

    /**
     * IP상태코드
     */
    private String ipStatCd;

    /**
     * 할당일자
     */
    private Date asgnDt;

    /**
     * 변경일자
     */
    private Date chngDt;

    /**
     * VIP여부
     */
    private String vipYn;

    /**
     * 회수일자
     */
    private Date withdrawDt;

    /**
     * NAT_IP주소
     */
    private String natIpAddr;

    /**
     * 비고
     */
    private String rmk;

    /**
     * 네트워크인터페이스SEQ
     */
    private BigDecimal netwkIntfcSeq;

    /**
     * 수정자ID
     */
    private String updtUserId;

    /**
     * 수정일시
     */
    private String updtDttm;

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getIpStatCd() {
        return ipStatCd;
    }

    public void setIpStatCd(String ipStatCd) {
        this.ipStatCd = ipStatCd;
    }

    public String getVipYn() {
        return vipYn;
    }

    public void setVipYn(String vipYn) {
        this.vipYn = vipYn;
    }

    public String getNatIpAddr() {
        return natIpAddr;
    }

    public void setNatIpAddr(String natIpAddr) {
        this.natIpAddr = natIpAddr;
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk;
    }

    public String getUpdtUserId() {
        return updtUserId;
    }

    public void setUpdtUserId(String updtUserId) {
        this.updtUserId = updtUserId;
    }

    public String getUpdtDttm() {
        return updtDttm;
    }

    public void setUpdtDttm(String updtDttm) {
        this.updtDttm = updtDttm;
    }

    public Date getAsgnDt() {
        return asgnDt;
    }

    public void setAsgnDt(Date asgnDt) {
        this.asgnDt = asgnDt;
    }

    public Date getChngDt() {
        return chngDt;
    }

    public void setChngDt(Date chngDt) {
        this.chngDt = chngDt;
    }

    public Date getWithdrawDt() {
        return withdrawDt;
    }

    public void setWithdrawDt(Date withdrawDt) {
        this.withdrawDt = withdrawDt;
    }

    public Integer getBndSeq() {
        return bndSeq;
    }

    public void setBndSeq(Integer bndSeq) {
        this.bndSeq = bndSeq;
    }

    public BigDecimal getNetwkIntfcSeq() {
        return netwkIntfcSeq;
    }

    public void setNetwkIntfcSeq(BigDecimal netwkIntfcSeq) {
        this.netwkIntfcSeq = netwkIntfcSeq;
    }

}
