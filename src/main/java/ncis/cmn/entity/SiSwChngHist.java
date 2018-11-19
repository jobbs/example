package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 구성정보_소프트웨어변경이력 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class SiSwChngHist {

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
    private String institutionId;

    /**
     * 기관명
     */
    private String institutionNm;

    /**
     * 운영상태
     */
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
     * 설치구성ID
     */
    private String instlCompId;

    /**
     * 설치구성자원명
     */
    private String instlCompRsrcNm;

    /**
     * 최초설치버전
     */
    private String frstInstlVer;

    /**
     * 현재패치버전
     */
    private String nowPatchVer;

    /**
     * 최초설치커널버전
     */
    private String frstInstlKrnlVer;

    /**
     * 현재커널버전
     */
    private String nowKrnlVer;

    /**
     * 소프트웨어구분
     */
    private String swCl;

    /**
     * 라이선스개수
     */
    private BigDecimal licnseQty;

    /**
     * 소프트웨어설치일자
     */
    private String swInstlDt;

    /**
     * 소스설치폴더
     */
    private String srcInstlFoldr;

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

    public String getInstlCompId() {
        return instlCompId;
    }

    public void setInstlCompId(String instlCompId) {
        this.instlCompId = instlCompId;
    }

    public String getInstlCompRsrcNm() {
        return instlCompRsrcNm;
    }

    public void setInstlCompRsrcNm(String instlCompRsrcNm) {
        this.instlCompRsrcNm = instlCompRsrcNm;
    }

    public String getFrstInstlVer() {
        return frstInstlVer;
    }

    public void setFrstInstlVer(String frstInstlVer) {
        this.frstInstlVer = frstInstlVer;
    }

    public String getNowPatchVer() {
        return nowPatchVer;
    }

    public void setNowPatchVer(String nowPatchVer) {
        this.nowPatchVer = nowPatchVer;
    }

    public String getFrstInstlKrnlVer() {
        return frstInstlKrnlVer;
    }

    public void setFrstInstlKrnlVer(String frstInstlKrnlVer) {
        this.frstInstlKrnlVer = frstInstlKrnlVer;
    }

    public String getNowKrnlVer() {
        return nowKrnlVer;
    }

    public void setNowKrnlVer(String nowKrnlVer) {
        this.nowKrnlVer = nowKrnlVer;
    }

    public String getSwCl() {
        return swCl;
    }

    public void setSwCl(String swCl) {
        this.swCl = swCl;
    }

    public BigDecimal getLicnseQty() {
        return licnseQty;
    }

    public void setLicnseQty(BigDecimal licnseQty) {
        this.licnseQty = licnseQty;
    }

    public String getSwInstlDt() {
        return swInstlDt;
    }

    public void setSwInstlDt(String swInstlDt) {
        this.swInstlDt = swInstlDt;
    }

    public String getSrcInstlFoldr() {
        return srcInstlFoldr;
    }

    public void setSrcInstlFoldr(String srcInstlFoldr) {
        this.srcInstlFoldr = srcInstlFoldr;
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
