package ncis.cmn.entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 가상서버업무변경이력 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class SiVmJobChngHist {

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
     * 기관ID
     */
    @NotEmpty(message = "기관ID는(은) 필수입력 항목입니다.")
    private String institutionId;

    /**
     * 리전구분코드
     */
    private String regionClCd;

    /**
     * 업무ID
     */
    private String jobId;

    /**
     * 업무명
     */
    private String jobNm;

    /**
     * 업무등급코드
     */
    private String jobGrdCd;

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

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getRegionClCd() {
        return regionClCd;
    }

    public void setRegionClCd(String regionClCd) {
        this.regionClCd = regionClCd;
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

    public String getJobGrdCd() {
        return jobGrdCd;
    }

    public void setJobGrdCd(String jobGrdCd) {
        this.jobGrdCd = jobGrdCd;
    }

}
