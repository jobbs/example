package ncis.cpt.rsrc.atmscl.vo;

import ncis.cmn.entity.RxServcPod;

public class ServcPodVo extends RxServcPod {

	private String institutionNm;   /* 부처명 */
    private String statCdNm; /* 상태코드명 */
    private String jobNm;   /* 업무명 */
    private String servcNm; /* 서비스명 */
    
	/**
	 * @return the institutionNm
	 */
	public String getInstitutionNm() {
		return institutionNm;
	}
	/**
	 * @param institutionNm the institutionNm to set
	 */
	public void setInstitutionNm(String institutionNm) {
		this.institutionNm = institutionNm;
	}
	/**
	 * @return the statCdNm
	 */
	public String getStatCdNm() {
		return statCdNm;
	}
	/**
	 * @param statCdNm the statCdNm to set
	 */
	public void setStatCdNm(String statCdNm) {
		this.statCdNm = statCdNm;
	}
	/**
	 * @return the jobNm
	 */
	public String getJobNm() {
		return jobNm;
	}
	/**
	 * @param jobNm the jobNm to set
	 */
	public void setJobNm(String jobNm) {
		this.jobNm = jobNm;
	}
	/**
	 * @return the servcNm
	 */
	public String getServcNm() {
		return servcNm;
	}
	/**
	 * @param servcNm the servcNm to set
	 */
	public void setServcNm(String servcNm) {
		this.servcNm = servcNm;
	}

    
}
