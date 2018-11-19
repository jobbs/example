package ncis.cpt.rsrc.atmscl.vo;

import ncis.cmn.entity.RxPreDistrb;

public class PreDistrbVo extends RxPreDistrb {

	private Integer servcAreaSeq;  /* 서비스영역SEQ */
	private String servcAreaId;  /* 서비스영역ID */
    private Integer preDistrbReqSeq;  /* 사전배포요청SEQ */
    private String institutionNm; /*기관명*/
    private String jobNm; /*업무명*/
    private String jobId; /*업무ID*/
    private String regionId; /* 리전ID */
    private String zoneId; /* 존ID */
    private String netId; /* 망ID */
    private String netClCd; /* 망구분코드 */
    private String regionNm; /* 리전명 */
    private String zoneNm; /* 존명 */
    private String netNm; /* 망명 */
    private String rsrcPoolId;  /* 자원풀ID */
    private String rsrcPoolNm; /* 자원풀명 */
    private String imgId;  /* 이미지ID */
    private String imgNm;  /* 이미지NM */
    private String imgRepoDtlAddr;  /* 이미지저장소상세주소 */
    private String distrbReqDttm;  /* 배포요청일시 */
    private String distrbReqUserId;  /* 배포요청자ID */
    private String rmk;  /* 비고 */
    private String creUserNm; /*유저명*/
    private String servcNm;// 서비스명
    private String servcId;// 서비스ID
    private String imgVer; //이미지 버전
    private String demonSetId; // 데몬setID
    private String distrbStatCd; //배포상태코드
    private String distrbComptDttm; //배포완료일시
    private String distrbStatNm; //배포상태코드명
    private String distrbReqUserNm; //배포자명
    private String creUserId; //생성자
    private String creDttm;
    private String ctlTrgtYn;
    private String servcAreaNm;
	/**
	 * @return the servcAreaSeq
	 */
	public Integer getServcAreaSeq() {
		return servcAreaSeq;
	}
	/**
	 * @param servcAreaSeq the servcAreaSeq to set
	 */
	public void setServcAreaSeq(Integer servcAreaSeq) {
		this.servcAreaSeq = servcAreaSeq;
	}
	/**
	 * @return the servcAreaId
	 */
	public String getServcAreaId() {
		return servcAreaId;
	}
	/**
	 * @param servcAreaId the servcAreaId to set
	 */
	public void setServcAreaId(String servcAreaId) {
		this.servcAreaId = servcAreaId;
	}
	/**
	 * @return the preDistrbReqSeq
	 */
	public Integer getPreDistrbReqSeq() {
		return preDistrbReqSeq;
	}
	/**
	 * @param preDistrbReqSeq the preDistrbReqSeq to set
	 */
	public void setPreDistrbReqSeq(Integer preDistrbReqSeq) {
		this.preDistrbReqSeq = preDistrbReqSeq;
	}
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
	 * @return the jobId
	 */
	public String getJobId() {
		return jobId;
	}
	/**
	 * @param jobId the jobId to set
	 */
	public void setJobId(String jobId) {
		this.jobId = jobId;
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
	/**
	 * @return the zoneId
	 */
	public String getZoneId() {
		return zoneId;
	}
	/**
	 * @param zoneId the zoneId to set
	 */
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	/**
	 * @return the netId
	 */
	public String getNetId() {
		return netId;
	}
	/**
	 * @param netId the netId to set
	 */
	public void setNetId(String netId) {
		this.netId = netId;
	}
	/**
	 * @return the netClCd
	 */
	public String getNetClCd() {
		return netClCd;
	}
	/**
	 * @param netClCd the netClCd to set
	 */
	public void setNetClCd(String netClCd) {
		this.netClCd = netClCd;
	}
	/**
	 * @return the regionNm
	 */
	public String getRegionNm() {
		return regionNm;
	}
	/**
	 * @param regionNm the regionNm to set
	 */
	public void setRegionNm(String regionNm) {
		this.regionNm = regionNm;
	}
	/**
	 * @return the zoneNm
	 */
	public String getZoneNm() {
		return zoneNm;
	}
	/**
	 * @param zoneNm the zoneNm to set
	 */
	public void setZoneNm(String zoneNm) {
		this.zoneNm = zoneNm;
	}
	/**
	 * @return the netNm
	 */
	public String getNetNm() {
		return netNm;
	}
	/**
	 * @param netNm the netNm to set
	 */
	public void setNetNm(String netNm) {
		this.netNm = netNm;
	}
	/**
	 * @return the rsrcPoolId
	 */
	public String getRsrcPoolId() {
		return rsrcPoolId;
	}
	/**
	 * @param rsrcPoolId the rsrcPoolId to set
	 */
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}
	/**
	 * @return the rsrcPoolNm
	 */
	public String getRsrcPoolNm() {
		return rsrcPoolNm;
	}
	/**
	 * @param rsrcPoolNm the rsrcPoolNm to set
	 */
	public void setRsrcPoolNm(String rsrcPoolNm) {
		this.rsrcPoolNm = rsrcPoolNm;
	}
	/**
	 * @return the imgId
	 */
	public String getImgId() {
		return imgId;
	}
	/**
	 * @param imgId the imgId to set
	 */
	public void setImgId(String imgId) {
		this.imgId = imgId;
	}
	/**
	 * @return the imgNm
	 */
	public String getImgNm() {
		return imgNm;
	}
	/**
	 * @param imgNm the imgNm to set
	 */
	public void setImgNm(String imgNm) {
		this.imgNm = imgNm;
	}
	/**
	 * @return the imgRepoDtlAddr
	 */
	public String getImgRepoDtlAddr() {
		return imgRepoDtlAddr;
	}
	/**
	 * @param imgRepoDtlAddr the imgRepoDtlAddr to set
	 */
	public void setImgRepoDtlAddr(String imgRepoDtlAddr) {
		this.imgRepoDtlAddr = imgRepoDtlAddr;
	}
	/**
	 * @return the distrbReqDttm
	 */
	public String getDistrbReqDttm() {
		return distrbReqDttm;
	}
	/**
	 * @param distrbReqDttm the distrbReqDttm to set
	 */
	public void setDistrbReqDttm(String distrbReqDttm) {
		this.distrbReqDttm = distrbReqDttm;
	}
	/**
	 * @return the distrbReqUserId
	 */
	public String getDistrbReqUserId() {
		return distrbReqUserId;
	}
	/**
	 * @param distrbReqUserId the distrbReqUserId to set
	 */
	public void setDistrbReqUserId(String distrbReqUserId) {
		this.distrbReqUserId = distrbReqUserId;
	}
	/**
	 * @return the rmk
	 */
	public String getRmk() {
		return rmk;
	}
	/**
	 * @param rmk the rmk to set
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	/**
	 * @return the creUserNm
	 */
	public String getCreUserNm() {
		return creUserNm;
	}
	/**
	 * @param creUserNm the creUserNm to set
	 */
	public void setCreUserNm(String creUserNm) {
		this.creUserNm = creUserNm;
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
	/**
	 * @return the servcId
	 */
	public String getServcId() {
		return servcId;
	}
	/**
	 * @param servcId the servcId to set
	 */
	public void setServcId(String servcId) {
		this.servcId = servcId;
	}
	/**
	 * @return the imgVer
	 */
	public String getImgVer() {
		return imgVer;
	}
	/**
	 * @param imgVer the imgVer to set
	 */
	public void setImgVer(String imgVer) {
		this.imgVer = imgVer;
	}
	/**
	 * @return the demonSetId
	 */
	public String getDemonSetId() {
		return demonSetId;
	}
	/**
	 * @param demonSetId the demonSetId to set
	 */
	public void setDemonSetId(String demonSetId) {
		this.demonSetId = demonSetId;
	}
	/**
	 * @return the distrbStatCd
	 */
	public String getDistrbStatCd() {
		return distrbStatCd;
	}
	/**
	 * @param distrbStatCd the distrbStatCd to set
	 */
	public void setDistrbStatCd(String distrbStatCd) {
		this.distrbStatCd = distrbStatCd;
	}
	/**
	 * @return the distrbComptDttm
	 */
	public String getDistrbComptDttm() {
		return distrbComptDttm;
	}
	/**
	 * @param distrbComptDttm the distrbComptDttm to set
	 */
	public void setDistrbComptDttm(String distrbComptDttm) {
		this.distrbComptDttm = distrbComptDttm;
	}
	/**
	 * @return the distrbStatNm
	 */
	public String getDistrbStatNm() {
		return distrbStatNm;
	}
	/**
	 * @param distrbStatNm the distrbStatNm to set
	 */
	public void setDistrbStatNm(String distrbStatNm) {
		this.distrbStatNm = distrbStatNm;
	}
	/**
	 * @return the distrbReqUserNm
	 */
	public String getDistrbReqUserNm() {
		return distrbReqUserNm;
	}
	/**
	 * @param distrbReqUserNm the distrbReqUserNm to set
	 */
	public void setDistrbReqUserNm(String distrbReqUserNm) {
		this.distrbReqUserNm = distrbReqUserNm;
	}
	/**
	 * @return the creUserId
	 */
	public String getCreUserId() {
		return creUserId;
	}
	/**
	 * @param creUserId the creUserId to set
	 */
	public void setCreUserId(String creUserId) {
		this.creUserId = creUserId;
	}
	/**
	 * @return the creDttm
	 */
	public String getCreDttm() {
		return creDttm;
	}
	/**
	 * @param creDttm the creDttm to set
	 */
	public void setCreDttm(String creDttm) {
		this.creDttm = creDttm;
	}
	/**
	 * @return the ctlTrgtYn
	 */
	public String getCtlTrgtYn() {
		return ctlTrgtYn;
	}
	/**
	 * @param ctlTrgtYn the ctlTrgtYn to set
	 */
	public void setCtlTrgtYn(String ctlTrgtYn) {
		this.ctlTrgtYn = ctlTrgtYn;
	}
	/**
	 * @return the servcAreaNm
	 */
	public String getServcAreaNm() {
		return servcAreaNm;
	}
	/**
	 * @param servcAreaNm the servcAreaNm to set
	 */
	public void setServcAreaNm(String servcAreaNm) {
		this.servcAreaNm = servcAreaNm;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PreDistrbVo [servcAreaSeq=" + servcAreaSeq + ", servcAreaId="
				+ servcAreaId + ", preDistrbReqSeq=" + preDistrbReqSeq
				+ ", institutionNm=" + institutionNm + ", jobNm=" + jobNm
				+ ", jobId=" + jobId + ", regionId=" + regionId + ", zoneId="
				+ zoneId + ", netId=" + netId + ", netClCd=" + netClCd
				+ ", regionNm=" + regionNm + ", zoneNm=" + zoneNm + ", netNm="
				+ netNm + ", rsrcPoolId=" + rsrcPoolId + ", rsrcPoolNm="
				+ rsrcPoolNm + ", imgId=" + imgId + ", imgNm=" + imgNm
				+ ", imgRepoDtlAddr=" + imgRepoDtlAddr + ", distrbReqDttm="
				+ distrbReqDttm + ", distrbReqUserId=" + distrbReqUserId
				+ ", rmk=" + rmk + ", creUserNm=" + creUserNm + ", servcNm="
				+ servcNm + ", servcId=" + servcId + ", imgVer=" + imgVer
				+ ", demonSetId=" + demonSetId + ", distrbStatCd="
				+ distrbStatCd + ", distrbComptDttm=" + distrbComptDttm
				+ ", distrbStatNm=" + distrbStatNm + ", distrbReqUserNm="
				+ distrbReqUserNm + ", creUserId=" + creUserId + ", creDttm="
				+ creDttm + ", ctlTrgtYn=" + ctlTrgtYn + ", servcAreaNm="
				+ servcAreaNm + "]";
	}






}