package ncis.cmn.entity;

import java.math.BigDecimal;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 네트워크인터페이스 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RcNetwkIntfc {

    /**
     * 네트워크인터페이스SEQ
     */
    @NotEmpty(message = "네트워크인터페이스SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal netwkIntfcSeq;

    /**
     * 가상스위치SEQ
     */
    @NotEmpty(message = "가상스위치SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal vrSwtchSeq;

    /**
     * 네트워크인터페이스명
     */
    @NotEmpty(message = "네트워크인터페이스명는(은) 필수입력 항목입니다.")
    private String netwkIntfcNm;

    /**
     * IP주소
     */
    private String ipAddr;

    /**
     * MAC주소
     */
    private String macAddr;

    /**
     * UUID
     */
    private String uuid;

    /**
     * 서브넷마스크
     */
    private String subnetMask;

    /**
     * 게이트웨이IP주소
     */
    @NotEmpty(message = "게이트웨이IP주소는(은) 필수입력 항목입니다.")
    private String gtwyIpAddr;

    /**
     * 가상서버SEQ
     */
    @NotEmpty(message = "가상서버SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal vmSeq;

    /**
     * NIC용도코드
     */
    @NotEmpty(message = "NIC용도코드는(은) 필수입력 항목입니다.")
    private String nicPrposCd;

    /**
     * 삭제자ID
     */
    private String delUserId;

    /**
     * 삭제일시
     */
    private String delDttm;

    /**
     * 삭제여부
     */
    private String delYn;

    public BigDecimal getVrSwtchSeq() {
        return vrSwtchSeq;
    }

    public void setVrSwtchSeq(BigDecimal vrSwtchSeq) {
        this.vrSwtchSeq = vrSwtchSeq;
    }

    public String getNetwkIntfcNm() {
        return netwkIntfcNm;
    }

    public void setNetwkIntfcNm(String netwkIntfcNm) {
        this.netwkIntfcNm = netwkIntfcNm;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getMacAddr() {
        return macAddr;
    }

    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public BigDecimal getVmSeq() {
        return vmSeq;
    }

    public void setVmSeq(BigDecimal vmSeq) {
        this.vmSeq = vmSeq;
    }

    public String getNicPrposCd() {
        return nicPrposCd;
    }

    public void setNicPrposCd(String nicPrposCd) {
        this.nicPrposCd = nicPrposCd;
    }

    public BigDecimal getNetwkIntfcSeq() {
        return netwkIntfcSeq;
    }

    public void setNetwkIntfcSeq(BigDecimal netwkIntfcSeq) {
        this.netwkIntfcSeq = netwkIntfcSeq;
    }

    public String getDelUserId() {
        return delUserId;
    }

    public void setDelUserId(String delUserId) {
        this.delUserId = delUserId;
    }

    public String getDelDttm() {
        return delDttm;
    }

    public void setDelDttm(String delDttm) {
        this.delDttm = delDttm;
    }

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

}
