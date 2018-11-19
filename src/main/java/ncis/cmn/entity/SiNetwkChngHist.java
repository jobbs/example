package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 구성정보_네트워크변경이력 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class SiNetwkChngHist {

    /**
     * 변경일시
     */
    @NotEmpty(message = "변경일시는(은) 필수입력 항목입니다.")
    private String chngDttm;

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
     * 관리리전구분명
     */
    @NotEmpty(message = "관리리전구분명는(은) 필수입력 항목입니다.")
    private String mngRegionClNm;

    /**
     * 자산ID
     */
    @NotEmpty(message = "자산ID는(은) 필수입력 항목입니다.")
    private String assetsId;

    /**
     * 구성자원명
     */
    @NotEmpty(message = "구성자원명는(은) 필수입력 항목입니다.")
    private String compRsrcNm;

    /**
     * 모델명
     */
    @NotEmpty(message = "모델명는(은) 필수입력 항목입니다.")
    private String modlNm;

    /**
     * 제조사
     */
    @NotEmpty(message = "제조사는(은) 필수입력 항목입니다.")
    private String mnfctCo;

    /**
     * 사용부서명
     */
    @NotEmpty(message = "사용부서명는(은) 필수입력 항목입니다.")
    private String useDept;

    /**
     * 사용부서ID
     */
    @NotEmpty(message = "사용부서ID는(은) 필수입력 항목입니다.")
    private String useDeptId;

    /**
     * 기관ID
     */
    @NotEmpty(message = "기관ID는(은) 필수입력 항목입니다.")
    private String institutionId;

    /**
     * 기관명
     */
    @NotEmpty(message = "기관명는(은) 필수입력 항목입니다.")
    private String institutionNm;

    /**
     * 운영상태
     */
    @NotEmpty(message = "운영상태는(은) 필수입력 항목입니다.")
    private String oprStat;

    /**
     * 운영담당부서(정)
     */
    private String oprChargDeptNm;

    /**
     * 정운영담당자ID
     */
    private String oprChargerId;

    /**
     * 위탁사용부서(정)
     */
    private String cnsgnUseDept;

    /**
     * 위탁사용자(정)
     */
    private String cnsgnUser;

    /**
     * 설치리전명
     */
    private String instlRegionNm;

    /**
     * 설치층명
     */
    private String instlFloorNm;

    /**
     * 설치영역명
     */
    private String instlAreaNm;

    /**
     * 설치X좌표
     */
    private String instlXCrdnt;

    /**
     * 설치Y좌표
     */
    private String instlYCrdnt;

    /**
     * SLA 등록업무
     */
    private String slaRegJob;

    /**
     * 업무 등록 일자
     */
    private String jobRegDt;

    /**
     * 이중화(HA)여부
     */
    private String haYn;

    /**
     * 단일구성여부
     */
    private String singlCompYn;

    /**
     * DR장비여부
     */
    private String drEqpYn;

    /**
     * 비고
     */
    private String rmk;

    /**
     * 호스트명
     */
    private String hstNm;

    /**
     * 네트워크구분코드
     */
    private String netwkClCd;

    /**
     * 운영체제버전
     */
    private String osVer;

    /**
     * 사용슬롯 수
     */
    private BigDecimal useSlotQty;

    /**
     * 총인터페이스(광)개수
     */
    private BigDecimal totIntfcKQty;

    /**
     * 사용 인터페이스(광) 개수
     */
    private BigDecimal useIntfcKQty;

    /**
     * 총 인터페이스(UTP) 개수
     */
    private BigDecimal totIntfcUtpQty;

    /**
     * 사용 인터페이스(UTP) 개수
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
     * 재기동 주기 일수
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

    /**
     * 운영담당부서(정)ID
     */
    private String oprChargDeptId;

    /**
     * 모델국산외산구분코드
     */
    private String modlOrignlClCd;

    /**
     * 리전외부위치명
     */
    private String regionLocaNm;

    /**
     * 위탁운영자담당자ID
     */
    private String cnsgnOprChargerId;

    /**
     * nSIMS용 대표IP
     */
    private String rprsntIp;

    /**
     * 자산구분코드
     */
    private String assetsClCd;

    /**
     * 제조사코드
     */
    private String mnfctCoCd;

    /**
     * 모델코드
     */
    private String modlCd;

    /**
     * 자산설치일자
     */
    private String assetsInstlDt;

    public String getChngDttm() {
        return chngDttm;
    }

    public void setChngDttm(String chngDttm) {
        this.chngDttm = chngDttm;
    }

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

    public String getMngRegionClNm() {
        return mngRegionClNm;
    }

    public void setMngRegionClNm(String mngRegionClNm) {
        this.mngRegionClNm = mngRegionClNm;
    }

    public String getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(String assetsId) {
        this.assetsId = assetsId;
    }

    public String getCompRsrcNm() {
        return compRsrcNm;
    }

    public void setCompRsrcNm(String compRsrcNm) {
        this.compRsrcNm = compRsrcNm;
    }

    public String getModlNm() {
        return modlNm;
    }

    public void setModlNm(String modlNm) {
        this.modlNm = modlNm;
    }

    public String getMnfctCo() {
        return mnfctCo;
    }

    public void setMnfctCo(String mnfctCo) {
        this.mnfctCo = mnfctCo;
    }

    public String getUseDept() {
        return useDept;
    }

    public void setUseDept(String useDept) {
        this.useDept = useDept;
    }

    public String getUseDeptId() {
        return useDeptId;
    }

    public void setUseDeptId(String useDeptId) {
        this.useDeptId = useDeptId;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getInstitutionNm() {
        return institutionNm;
    }

    public void setInstitutionNm(String institutionNm) {
        this.institutionNm = institutionNm;
    }

    public String getOprStat() {
        return oprStat;
    }

    public void setOprStat(String oprStat) {
        this.oprStat = oprStat;
    }

    public String getOprChargDeptNm() {
        return oprChargDeptNm;
    }

    public void setOprChargDeptNm(String oprChargDeptNm) {
        this.oprChargDeptNm = oprChargDeptNm;
    }

    public String getOprChargerId() {
        return oprChargerId;
    }

    public void setOprChargerId(String oprChargerId) {
        this.oprChargerId = oprChargerId;
    }

    public String getCnsgnUseDept() {
        return cnsgnUseDept;
    }

    public void setCnsgnUseDept(String cnsgnUseDept) {
        this.cnsgnUseDept = cnsgnUseDept;
    }

    public String getCnsgnUser() {
        return cnsgnUser;
    }

    public void setCnsgnUser(String cnsgnUser) {
        this.cnsgnUser = cnsgnUser;
    }

    public String getInstlRegionNm() {
        return instlRegionNm;
    }

    public void setInstlRegionNm(String instlRegionNm) {
        this.instlRegionNm = instlRegionNm;
    }

    public String getInstlFloorNm() {
        return instlFloorNm;
    }

    public void setInstlFloorNm(String instlFloorNm) {
        this.instlFloorNm = instlFloorNm;
    }

    public String getInstlAreaNm() {
        return instlAreaNm;
    }

    public void setInstlAreaNm(String instlAreaNm) {
        this.instlAreaNm = instlAreaNm;
    }

    public String getInstlXCrdnt() {
        return instlXCrdnt;
    }

    public void setInstlXCrdnt(String instlXCrdnt) {
        this.instlXCrdnt = instlXCrdnt;
    }

    public String getInstlYCrdnt() {
        return instlYCrdnt;
    }

    public void setInstlYCrdnt(String instlYCrdnt) {
        this.instlYCrdnt = instlYCrdnt;
    }

    public String getSlaRegJob() {
        return slaRegJob;
    }

    public void setSlaRegJob(String slaRegJob) {
        this.slaRegJob = slaRegJob;
    }

    public String getJobRegDt() {
        return jobRegDt;
    }

    public void setJobRegDt(String jobRegDt) {
        this.jobRegDt = jobRegDt;
    }

    public String getHaYn() {
        return haYn;
    }

    public void setHaYn(String haYn) {
        this.haYn = haYn;
    }

    public String getSinglCompYn() {
        return singlCompYn;
    }

    public void setSinglCompYn(String singlCompYn) {
        this.singlCompYn = singlCompYn;
    }

    public String getDrEqpYn() {
        return drEqpYn;
    }

    public void setDrEqpYn(String drEqpYn) {
        this.drEqpYn = drEqpYn;
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk;
    }

    public String getHstNm() {
        return hstNm;
    }

    public void setHstNm(String hstNm) {
        this.hstNm = hstNm;
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

    public String getOprChargDeptId() {
        return oprChargDeptId;
    }

    public void setOprChargDeptId(String oprChargDeptId) {
        this.oprChargDeptId = oprChargDeptId;
    }

    public String getModlOrignlClCd() {
        return modlOrignlClCd;
    }

    public void setModlOrignlClCd(String modlOrignlClCd) {
        this.modlOrignlClCd = modlOrignlClCd;
    }

    public String getRegionLocaNm() {
        return regionLocaNm;
    }

    public void setRegionLocaNm(String regionLocaNm) {
        this.regionLocaNm = regionLocaNm;
    }

    public String getCnsgnOprChargerId() {
        return cnsgnOprChargerId;
    }

    public void setCnsgnOprChargerId(String cnsgnOprChargerId) {
        this.cnsgnOprChargerId = cnsgnOprChargerId;
    }

    public String getRprsntIp() {
        return rprsntIp;
    }

    public void setRprsntIp(String rprsntIp) {
        this.rprsntIp = rprsntIp;
    }

    public String getAssetsClCd() {
        return assetsClCd;
    }

    public void setAssetsClCd(String assetsClCd) {
        this.assetsClCd = assetsClCd;
    }

    public String getMnfctCoCd() {
        return mnfctCoCd;
    }

    public void setMnfctCoCd(String mnfctCoCd) {
        this.mnfctCoCd = mnfctCoCd;
    }

    public String getModlCd() {
        return modlCd;
    }

    public void setModlCd(String modlCd) {
        this.modlCd = modlCd;
    }

    public String getAssetsInstlDt() {
        return assetsInstlDt;
    }

    public void setAssetsInstlDt(String assetsInstlDt) {
        this.assetsInstlDt = assetsInstlDt;
    }

}
