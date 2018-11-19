package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 구성정보_서버모듈변경이력 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class SiPmChngHist {

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
     * 관리리전ID
     */
    @NotEmpty(message = "관리리전ID는(은) 필수입력 항목입니다.")
    private BigDecimal mngRegionId;

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
    private String cnsgnUesr;

    /**
     * 설치리전명
     */
    private String instlRegionNm;

    /**
     * 설치리전ID
     */
    private BigDecimal instlRegionId;

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
     * SLA등록업무
     */
    private String slaRegJob;

    /**
     * 업무등록일자
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
     * 상위구성ID
     */
    private String upperCompId;

    /**
     * 상위구성자원명
     */
    private String upperCompRsrcNm;

    /**
     * 비고
     */
    private String rmk;

    /**
     * 호스트명
     */
    private String hstNm;

    /**
     * 네트워크영역구분코드
     */
    private String netwkAreaClCd;

    /**
     * 대표IP주소
     */
    private String rprsntId;

    /**
     * MAC주소
     */
    private String macAddr;

    /**
     * 서버용도
     */
    private String srvrPrpos;

    /**
     * 운영체제명
     */
    private String osNm;

    /**
     * 운영체제버전
     */
    private String osVer;

    /**
     * 패치버전
     */
    private String patchVer;

    /**
     * 커널버전
     */
    private String krnlVer;

    /**
     * CPU타입
     */
    private String cpuTy;

    /**
     * CPU제조사
     */
    private String cpuMnfctCo;

    /**
     * CPU코어구분
     */
    private String cpuCorCl;

    /**
     * 물리적CPU개수
     */
    private BigDecimal phyCpuQty;

    /**
     * 물리적CPU총개수
     */
    private BigDecimal phyCpuTotQty;

    /**
     * 사용논리CPU코어개수
     */
    private BigDecimal useLogicCoreQty;

    /**
     * 사용논리코어총개수
     */
    private BigDecimal useLogicCoreTotQty;

    /**
     * 설치메모리개수
     */
    private BigDecimal instlMemQty;

    /**
     * 설치메모리총개수
     */
    private BigDecimal instlMemTotQty;

    /**
     * 사용메모리용량(MB)
     */
    private BigDecimal useMemCapa;

    /**
     * 사용메모리총용량(MB)
     */
    private BigDecimal useMemTotCapa;

    /**
     * 내장디스크개수
     */
    private BigDecimal indcoDskQty;

    /**
     * 내장디스크총개수
     */
    private BigDecimal indcoDskTotQty;

    /**
     * 사용내장디스크용량(GB)
     */
    private BigDecimal useIndcoDskCapa;

    /**
     * 사용내장디스크총용량(GB)
     */
    private BigDecimal useIndcoDskTotCapa;

    /**
     * 스토리지연결여부
     */
    private String strgConnYn;

    /**
     * 할당스토리지용량(GB)
     */
    private BigDecimal asgnStrgCapa;

    /**
     * 사용네트워크포트개수
     */
    private BigDecimal useNetwkPortQty;

    /**
     * KVM연결내용
     */
    private String kvmConnCn;

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

    /**
     * 관리리전구분코드
     */
    private String mngRegionClCd;

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

    public BigDecimal getMngRegionId() {
        return mngRegionId;
    }

    public void setMngRegionId(BigDecimal mngRegionId) {
        this.mngRegionId = mngRegionId;
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

    public String getCnsgnUesr() {
        return cnsgnUesr;
    }

    public void setCnsgnUesr(String cnsgnUesr) {
        this.cnsgnUesr = cnsgnUesr;
    }

    public String getInstlRegionNm() {
        return instlRegionNm;
    }

    public void setInstlRegionNm(String instlRegionNm) {
        this.instlRegionNm = instlRegionNm;
    }

    public BigDecimal getInstlRegionId() {
        return instlRegionId;
    }

    public void setInstlRegionId(BigDecimal instlRegionId) {
        this.instlRegionId = instlRegionId;
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

    public String getUpperCompId() {
        return upperCompId;
    }

    public void setUpperCompId(String upperCompId) {
        this.upperCompId = upperCompId;
    }

    public String getUpperCompRsrcNm() {
        return upperCompRsrcNm;
    }

    public void setUpperCompRsrcNm(String upperCompRsrcNm) {
        this.upperCompRsrcNm = upperCompRsrcNm;
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

    public String getNetwkAreaClCd() {
        return netwkAreaClCd;
    }

    public void setNetwkAreaClCd(String netwkAreaClCd) {
        this.netwkAreaClCd = netwkAreaClCd;
    }

    public String getRprsntId() {
        return rprsntId;
    }

    public void setRprsntId(String rprsntId) {
        this.rprsntId = rprsntId;
    }

    public String getMacAddr() {
        return macAddr;
    }

    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr;
    }

    public String getSrvrPrpos() {
        return srvrPrpos;
    }

    public void setSrvrPrpos(String srvrPrpos) {
        this.srvrPrpos = srvrPrpos;
    }

    public String getOsNm() {
        return osNm;
    }

    public void setOsNm(String osNm) {
        this.osNm = osNm;
    }

    public String getOsVer() {
        return osVer;
    }

    public void setOsVer(String osVer) {
        this.osVer = osVer;
    }

    public String getPatchVer() {
        return patchVer;
    }

    public void setPatchVer(String patchVer) {
        this.patchVer = patchVer;
    }

    public String getKrnlVer() {
        return krnlVer;
    }

    public void setKrnlVer(String krnlVer) {
        this.krnlVer = krnlVer;
    }

    public String getCpuTy() {
        return cpuTy;
    }

    public void setCpuTy(String cpuTy) {
        this.cpuTy = cpuTy;
    }

    public String getCpuMnfctCo() {
        return cpuMnfctCo;
    }

    public void setCpuMnfctCo(String cpuMnfctCo) {
        this.cpuMnfctCo = cpuMnfctCo;
    }

    public String getCpuCorCl() {
        return cpuCorCl;
    }

    public void setCpuCorCl(String cpuCorCl) {
        this.cpuCorCl = cpuCorCl;
    }

    public BigDecimal getPhyCpuQty() {
        return phyCpuQty;
    }

    public void setPhyCpuQty(BigDecimal phyCpuQty) {
        this.phyCpuQty = phyCpuQty;
    }

    public BigDecimal getPhyCpuTotQty() {
        return phyCpuTotQty;
    }

    public void setPhyCpuTotQty(BigDecimal phyCpuTotQty) {
        this.phyCpuTotQty = phyCpuTotQty;
    }

    public BigDecimal getUseLogicCoreQty() {
        return useLogicCoreQty;
    }

    public void setUseLogicCoreQty(BigDecimal useLogicCoreQty) {
        this.useLogicCoreQty = useLogicCoreQty;
    }

    public BigDecimal getUseLogicCoreTotQty() {
        return useLogicCoreTotQty;
    }

    public void setUseLogicCoreTotQty(BigDecimal useLogicCoreTotQty) {
        this.useLogicCoreTotQty = useLogicCoreTotQty;
    }

    public BigDecimal getInstlMemQty() {
        return instlMemQty;
    }

    public void setInstlMemQty(BigDecimal instlMemQty) {
        this.instlMemQty = instlMemQty;
    }

    public BigDecimal getInstlMemTotQty() {
        return instlMemTotQty;
    }

    public void setInstlMemTotQty(BigDecimal instlMemTotQty) {
        this.instlMemTotQty = instlMemTotQty;
    }

    public BigDecimal getUseMemCapa() {
        return useMemCapa;
    }

    public void setUseMemCapa(BigDecimal useMemCapa) {
        this.useMemCapa = useMemCapa;
    }

    public BigDecimal getUseMemTotCapa() {
        return useMemTotCapa;
    }

    public void setUseMemTotCapa(BigDecimal useMemTotCapa) {
        this.useMemTotCapa = useMemTotCapa;
    }

    public BigDecimal getIndcoDskQty() {
        return indcoDskQty;
    }

    public void setIndcoDskQty(BigDecimal indcoDskQty) {
        this.indcoDskQty = indcoDskQty;
    }

    public BigDecimal getIndcoDskTotQty() {
        return indcoDskTotQty;
    }

    public void setIndcoDskTotQty(BigDecimal indcoDskTotQty) {
        this.indcoDskTotQty = indcoDskTotQty;
    }

    public BigDecimal getUseIndcoDskCapa() {
        return useIndcoDskCapa;
    }

    public void setUseIndcoDskCapa(BigDecimal useIndcoDskCapa) {
        this.useIndcoDskCapa = useIndcoDskCapa;
    }

    public BigDecimal getUseIndcoDskTotCapa() {
        return useIndcoDskTotCapa;
    }

    public void setUseIndcoDskTotCapa(BigDecimal useIndcoDskTotCapa) {
        this.useIndcoDskTotCapa = useIndcoDskTotCapa;
    }

    public String getStrgConnYn() {
        return strgConnYn;
    }

    public void setStrgConnYn(String strgConnYn) {
        this.strgConnYn = strgConnYn;
    }

    public BigDecimal getAsgnStrgCapa() {
        return asgnStrgCapa;
    }

    public void setAsgnStrgCapa(BigDecimal asgnStrgCapa) {
        this.asgnStrgCapa = asgnStrgCapa;
    }

    public BigDecimal getUseNetwkPortQty() {
        return useNetwkPortQty;
    }

    public void setUseNetwkPortQty(BigDecimal useNetwkPortQty) {
        this.useNetwkPortQty = useNetwkPortQty;
    }

    public String getKvmConnCn() {
        return kvmConnCn;
    }

    public void setKvmConnCn(String kvmConnCn) {
        this.kvmConnCn = kvmConnCn;
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

    public String getMngRegionClCd() {
        return mngRegionClCd;
    }

    public void setMngRegionClCd(String mngRegionClCd) {
        this.mngRegionClCd = mngRegionClCd;
    }

}
