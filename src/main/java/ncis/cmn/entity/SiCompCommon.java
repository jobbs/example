package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 구성정보_공통 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class SiCompCommon {

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
    private String modlNm;

    /**
     * 제조사
     */
    private String mnfctCo;

    /**
     * 사용부서명
     */
    @NotEmpty(message = "사용부서명는(은) 필수입력 항목입니다.")
    private String useDept;

    /**
     * 기관ID
     */
    @NotEmpty(message = "기관ID는(은) 필수입력 항목입니다.")
    private String institutionId;

    /**
     * 운영상태
     */
    private String oprStat;

    /**
     * SLA등록업무
     */
    private String slaRegJob;

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
     * 비고
     */
    private String rmk;

    /**
     * 호스트명
     */
    private String hstNm;

    /**
     * 모델코드
     */
    @NotEmpty(message = "모델코드는(은) 필수입력 항목입니다.")
    private String modlCd;

    /**
     * 관리리전구분코드
     */
    private String mngRegionClCd;

    /**
     * 구성서버구분코드
     */
    private String compSrvrClCd;

    /**
     * 설치위치ID
     */
    @NotEmpty(message = "설치위치ID는(은) 필수입력 항목입니다.")
    private BigDecimal instlLocaId;

    /**
     * 설치리전ID
     */
    @NotEmpty(message = "설치리전ID는(은) 필수입력 항목입니다.")
    private BigDecimal instlRegionId;

    /**
     * 관리리전ID
     */
    @NotEmpty(message = "관리리전ID는(은) 필수입력 항목입니다.")
    private BigDecimal mngRegionId;

    /**
     * 업무ID
     */
    @NotEmpty(message = "업무ID는(은) 필수입력 항목입니다.")
    private String jobId;

    /**
     * 리전명
     */
    @NotEmpty(message = "리전명는(은) 필수입력 항목입니다.")
    private String regionNm;

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
     * 서버분류코드
     */
    private String srvrClCd;

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

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getOprStat() {
        return oprStat;
    }

    public void setOprStat(String oprStat) {
        this.oprStat = oprStat;
    }

    public String getSlaRegJob() {
        return slaRegJob;
    }

    public void setSlaRegJob(String slaRegJob) {
        this.slaRegJob = slaRegJob;
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

    public String getModlCd() {
        return modlCd;
    }

    public void setModlCd(String modlCd) {
        this.modlCd = modlCd;
    }

    public String getMngRegionClCd() {
        return mngRegionClCd;
    }

    public void setMngRegionClCd(String mngRegionClCd) {
        this.mngRegionClCd = mngRegionClCd;
    }

    public String getCompSrvrClCd() {
        return compSrvrClCd;
    }

    public void setCompSrvrClCd(String compSrvrClCd) {
        this.compSrvrClCd = compSrvrClCd;
    }

    public BigDecimal getInstlLocaId() {
        return instlLocaId;
    }

    public void setInstlLocaId(BigDecimal instlLocaId) {
        this.instlLocaId = instlLocaId;
    }

    public BigDecimal getInstlRegionId() {
        return instlRegionId;
    }

    public void setInstlRegionId(BigDecimal instlRegionId) {
        this.instlRegionId = instlRegionId;
    }

    public BigDecimal getMngRegionId() {
        return mngRegionId;
    }

    public void setMngRegionId(BigDecimal mngRegionId) {
        this.mngRegionId = mngRegionId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getRegionNm() {
        return regionNm;
    }

    public void setRegionNm(String regionNm) {
        this.regionNm = regionNm;
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

    public String getSrvrClCd() {
        return srvrClCd;
    }

    public void setSrvrClCd(String srvrClCd) {
        this.srvrClCd = srvrClCd;
    }

}
