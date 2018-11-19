package ncis.cmn.entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 기관업무변경이력 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class SiInstitutionChngHist {

    /**
     * 변경일시
     */
    @NotEmpty(message = "변경일시는(은) 필수입력 항목입니다.")
    private String chngDttm;

    /**
     * 기관ID
     */
    @NotEmpty(message = "기관ID는(은) 필수입력 항목입니다.")
    private String institutionId;

    /**
     * 기관명
     */
    private String institutionNm;

    /**
     * 부서ID
     */
    private String deptId;

    /**
     * 부서명
     */
    private String deptNm;

    /**
     * 업무ID
     */
    private String jobId;

    /**
     * 업무명
     */
    private String jobNm;

    /**
     * 리전구분코드
     */
    private String regionClCd;

    /**
     * 클라우드업무여부
     */
    private String cludJob;

    public String getChngDttm() {
        return chngDttm;
    }

    public void setChngDttm(String chngDttm) {
        this.chngDttm = chngDttm;
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

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptNm() {
        return deptNm;
    }

    public void setDeptNm(String deptNm) {
        this.deptNm = deptNm;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobNm() {
        return jobNm;
    }

    public void setJobNm(String jobNm) {
        this.jobNm = jobNm;
    }

    public String getRegionClCd() {
        return regionClCd;
    }

    public void setRegionClCd(String regionClCd) {
        this.regionClCd = regionClCd;
    }

    public String getCludJob() {
        return cludJob;
    }

    public void setCludJob(String cludJob) {
        this.cludJob = cludJob;
    }

}
