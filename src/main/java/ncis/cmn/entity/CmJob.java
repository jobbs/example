package ncis.cmn.entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 업무 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class CmJob {

	/**
	* 업무ID
	*/
	@NotEmpty(message="업무ID는(은) 필수입력 항목입니다.")
    private String jobId;

	/**
	* 업무명
	*/
    private String jobNm;

	/**
	* 클라우드업무여부
	*/
    private String cludJob;

	/**
	* 업무등급
	*/
    private String jobGrd;

	/**
	* 업무등록일자
	*/
    private String jobRegDt;

    private String regionId;

	/**
	* 기관ID
	*/
	@NotEmpty(message="기관ID는(은) 필수입력 항목입니다.")
    private String institutionId;

    /**
     * 사용여부
     */
    private String useYn;

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

    public String getCludJob() {
        return cludJob;
    }

    public void setCludJob(String cludJob) {
        this.cludJob = cludJob;
    }

    public String getJobGrd() {
        return jobGrd;
    }

    public void setJobGrd(String jobGrd) {
        this.jobGrd = jobGrd;
    }

    public String getJobRegDt() {
        return jobRegDt;
    }

    public void setJobRegDt(String jobRegDt) {
        this.jobRegDt = jobRegDt;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

	/**
	 * @return the useYn
	 */
	public String getUseYn() {
		return useYn;
	}

	/**
	 * @param useYn the useYn to set
	 */
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

    /**
     * @return the regionId
     */
    public String getRegionId() {
        return regionId;
    }

    /**
     * @param regionId the regionId to set
     */
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }




}


