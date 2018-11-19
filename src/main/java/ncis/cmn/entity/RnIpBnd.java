package ncis.cmn.entity;

import java.math.BigDecimal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * IP대역 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RnIpBnd {

    /**
     * 대역SEQ
     */
    // @NotEmpty(message = "대역SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal bndSeq;

    /**
     * IP대역명
     */
    @NotEmpty(message = "IP대역명는(은) 필수입력 항목입니다.")
    private String ipBndNm;

    /**
     * 사용여부
     */
    private String useYn;

    /**
     * 대역시작IP주소
     */
    @NotEmpty(message = "대역시작IP주소는(은) 필수입력 항목입니다.")
    private String bndStrtIp;

    /**
     * 대역종료IP주소
     */
    @NotEmpty(message = "대역종료IP주소는(은) 필수입력 항목입니다.")
    private String bndEndIp;

    /**
     * 서브넷마스크
     */
    @NotEmpty(message = "서브넷마스크는(은) 필수입력 항목입니다.")
    private String subnetMask;

    /**
     * 게이트웨이IP주소
     */
    private String gtwyIpAddr;

    /**
     * VLAN
     */
    private String vlan;

    /**
     * 할당IP수
     */
    private BigDecimal asgnIpQty;

    /**
     * 미할당IP수
     */
    private BigDecimal unasgnIpQty;

    /**
     * 블럭IP수
     */
    private BigDecimal blkIpQty;

    /**
     * 등록자ID
     */
    private String regUserId;

    /**
     * 등록일시
     */
    private String regDttm;

    /**
     * 수정자ID
     */
    private String updtUserId;

    /**
     * 수정일시
     */
    private String updtDttm;

    /**
     * 망ID
     */
    private String netClCd;

    /**
     * 리전ID
     */
    private String regionId;

    public String getIpBndNm() {
        return ipBndNm;
    }

    public void setIpBndNm(String ipBndNm) {
        this.ipBndNm = ipBndNm;
    }

    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    public String getBndStrtIp() {
        return bndStrtIp;
    }

    public void setBndStrtIp(String bndStrtIp) {
        this.bndStrtIp = bndStrtIp;
    }

    public String getBndEndIp() {
        return bndEndIp;
    }

    public void setBndEndIp(String bndEndIp) {
        this.bndEndIp = bndEndIp;
    }

    public String getSubnetMask() {
        return subnetMask;
    }

    public void setSubnetMask(String subnetMask) {
        this.subnetMask = subnetMask;
    }

    public String getGtwyIpAddr() {
        return gtwyIpAddr;
    }

    public void setGtwyIpAddr(String gtwyIpAddr) {
        this.gtwyIpAddr = gtwyIpAddr;
    }

    public String getVlan() {
        return vlan;
    }

    public void setVlan(String vlan) {
        this.vlan = vlan;
    }

    public BigDecimal getAsgnIpQty() {
        return asgnIpQty;
    }

    public void setAsgnIpQty(BigDecimal asgnIpQty) {
        this.asgnIpQty = asgnIpQty;
    }

    public BigDecimal getUnasgnIpQty() {
        return unasgnIpQty;
    }

    public void setUnasgnIpQty(BigDecimal unasgnIpQty) {
        this.unasgnIpQty = unasgnIpQty;
    }

    public BigDecimal getBlkIpQty() {
        return blkIpQty;
    }

    public void setBlkIpQty(BigDecimal blkIpQty) {
        this.blkIpQty = blkIpQty;
    }

    public String getRegUserId() {
        return regUserId;
    }

    public void setRegUserId(String regUserId) {
        this.regUserId = regUserId;
    }

    public String getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(String regDttm) {
        this.regDttm = regDttm;
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

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public BigDecimal getBndSeq() {
        return bndSeq;
    }

    public void setBndSeq(BigDecimal bndSeq) {
        this.bndSeq = bndSeq;
    }

    public String getNetClCd() {
        return netClCd;
    }

    public void setNetClCd(String netClCd) {
        this.netClCd = netClCd;
    }
}
