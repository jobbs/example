package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 네트워크구성정보 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class SiNetwkComp {

    /**
     * 구성ID
     */
    @NotEmpty(message = "구성ID는(은) 필수입력 항목입니다.")
    private String compId;

    /**
     * 구성구분코드
     */
    @NotEmpty(message = "구성구분코드는(은) 필수입력 항목입니다.")
    private String compClCd;

    /**
     * 네트워크구분코드
     */
    @NotEmpty(message = "네트워크구분코드는(은) 필수입력 항목입니다.")
    private String netwkClCd;

    /**
     * 운영체제버전
     */
    private String osVer;

    /**
     * 사용 슬롯 수
     */
    private BigDecimal useSlotQty;

    /**
     * 총인터페이스(광)개수
     */
    private BigDecimal totIntfcKQty;

    /**
     * 사용인터페이스(광)개수
     */
    private BigDecimal useIntfcKQty;

    /**
     * 총인터페이스(UTP)개수
     */
    private BigDecimal totIntfcUtpQty;

    /**
     * 사용인터페이스(UTP)개수
     */
    private BigDecimal useIntfcUtpQty;

    /**
     * 총인터페이스(COMBO)개수
     */
    private BigDecimal totIntfcComboQty;

    /**
     * 사용인터페이스(COMBO)개수
     */
    private BigDecimal useIntfcComboQty;

    /**
     * 총전원개수
     */
    private BigDecimal totPowerQty;

    /**
     * 사용전원개수
     */
    private BigDecimal usePowerQty;

    /**
     * 콘솔유형
     */
    private String consTy;

    /**
     * IP주소
     */
    private String ipAddr;

    /**
     * 사용네트워크포트개수
     */
    private BigDecimal useNetwkPortQty;

    /**
     * 인터페이스 종류
     */
    private String intfcKndCd;

    /**
     * 재기동주기일수
     */
    private BigDecimal reStrtCycleDtNo;

    /**
     * 최근재기동일자
     */
    private String rcntReStrtDt;

    /**
     * 재기동문자메시지수신여부
     */
    private String reStrtLttrRcivYn;

    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public String getCompClCd() {
        return compClCd;
    }

    public void setCompClCd(String compClCd) {
        this.compClCd = compClCd;
    }

    public String getNetwkClCd() {
        return netwkClCd;
    }

    public void setNetwkClCd(String netwkClCd) {
        this.netwkClCd = netwkClCd;
    }

    public String getOsVer() {
        return osVer;
    }

    public void setOsVer(String osVer) {
        this.osVer = osVer;
    }

    public BigDecimal getUseSlotQty() {
        return useSlotQty;
    }

    public void setUseSlotQty(BigDecimal useSlotQty) {
        this.useSlotQty = useSlotQty;
    }

    public BigDecimal getTotIntfcKQty() {
        return totIntfcKQty;
    }

    public void setTotIntfcKQty(BigDecimal totIntfcKQty) {
        this.totIntfcKQty = totIntfcKQty;
    }

    public BigDecimal getUseIntfcKQty() {
        return useIntfcKQty;
    }

    public void setUseIntfcKQty(BigDecimal useIntfcKQty) {
        this.useIntfcKQty = useIntfcKQty;
    }

    public BigDecimal getTotIntfcUtpQty() {
        return totIntfcUtpQty;
    }

    public void setTotIntfcUtpQty(BigDecimal totIntfcUtpQty) {
        this.totIntfcUtpQty = totIntfcUtpQty;
    }

    public BigDecimal getUseIntfcUtpQty() {
        return useIntfcUtpQty;
    }

    public void setUseIntfcUtpQty(BigDecimal useIntfcUtpQty) {
        this.useIntfcUtpQty = useIntfcUtpQty;
    }

    public BigDecimal getTotIntfcComboQty() {
        return totIntfcComboQty;
    }

    public void setTotIntfcComboQty(BigDecimal totIntfcComboQty) {
        this.totIntfcComboQty = totIntfcComboQty;
    }

    public BigDecimal getUseIntfcComboQty() {
        return useIntfcComboQty;
    }

    public void setUseIntfcComboQty(BigDecimal useIntfcComboQty) {
        this.useIntfcComboQty = useIntfcComboQty;
    }

    public BigDecimal getTotPowerQty() {
        return totPowerQty;
    }

    public void setTotPowerQty(BigDecimal totPowerQty) {
        this.totPowerQty = totPowerQty;
    }

    public BigDecimal getUsePowerQty() {
        return usePowerQty;
    }

    public void setUsePowerQty(BigDecimal usePowerQty) {
        this.usePowerQty = usePowerQty;
    }

    public String getConsTy() {
        return consTy;
    }

    public void setConsTy(String consTy) {
        this.consTy = consTy;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public BigDecimal getUseNetwkPortQty() {
        return useNetwkPortQty;
    }

    public void setUseNetwkPortQty(BigDecimal useNetwkPortQty) {
        this.useNetwkPortQty = useNetwkPortQty;
    }

    public String getIntfcKndCd() {
        return intfcKndCd;
    }

    public void setIntfcKndCd(String intfcKndCd) {
        this.intfcKndCd = intfcKndCd;
    }

    public BigDecimal getReStrtCycleDtNo() {
        return reStrtCycleDtNo;
    }

    public void setReStrtCycleDtNo(BigDecimal reStrtCycleDtNo) {
        this.reStrtCycleDtNo = reStrtCycleDtNo;
    }

    public String getRcntReStrtDt() {
        return rcntReStrtDt;
    }

    public void setRcntReStrtDt(String rcntReStrtDt) {
        this.rcntReStrtDt = rcntReStrtDt;
    }

    public String getReStrtLttrRcivYn() {
        return reStrtLttrRcivYn;
    }

    public void setReStrtLttrRcivYn(String reStrtLttrRcivYn) {
        this.reStrtLttrRcivYn = reStrtLttrRcivYn;
    }

}
