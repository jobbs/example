package ncis.cpt.rsrc.atmscl.vo;

import ncis.cmn.entity.RxServcArea;

public class BldVo extends RxServcArea {

	private Integer servcSeq;  /* 서비스SEQ */
	private String bldId;  /* 빌드ID */
	private String bldNm;  /* 빌드명 */
	private String basImgId;  /* 베이스이미지ID */
	private String basImgNm;  /* 베이스이미지명 */
	private String basImgVer;  /* 베이스이미지 버전 */
	private String repoTyCd;  /* 저장소유형코드 */
	private String repoAddr;  /* 저장소주소 */
	private String gitBrnchNm;  /* GIT브랜치명 */
	private String gitBestPath;  /* GIT최상위경로 */
	private String scrtkyId;  /* 보안키ID */
	private String creImgNm;  /* 생성이미지명 */
	private String creImgId;  /* 생성이미지ID */
	private String imgTag;  /* 이미지태그 */
	private Integer servcAreaSeq;  /* 서비스영역SEQ */
	private String lastBldVer;  /* 최종빌드버전 */
	private String lastBldDttm;  /* 최종빌드일시 */
	private String creDttm;  /* 생성일시 */
	private String updtDttm;  /* 수정일시 */
	private String creUserId;  /* 생성자ID */
	private String updtUserId;  /* 수정자ID */
	private String creUserNm;  /* 생성자명 */
	private String updtUserNm;  /* 수정자명 */
	private String bldStatCd; // 빌드 상태 코드
	//
	private String statCd;
	private String institutionNm;
	private String regionId; /* 리전ID */
    private String zoneId; /* 존ID */
    private String netClCd; /* 망구분코드 */
    private String regionNm; /* 리전명 */
    private String zoneNm; /* 존명 */
    private String netNm; /* 망명 */
    private String netClCdNm; /* 망코드 */
    private String rsrcPoolId; /* 자원풀ID */
    private String rsrcPoolNm; /* 자원풀명 */
    private String bldVer; /* 빋드 버전 */
    private String jobNm; /*업무명 */
    private String servcNm; /*서비스명*/
    private String servcId; /*서비스ID*/
	private String originBasImgId;  //기존 베이스 이미지 ID
	private String originRepoAddr; //기존 git저장소주소
	private String originScrtkyId; //기존 보안키ID
	private String originGitBrnchNm; //기존 Git브랜치
	private String originGitBestPath; //기존Git최상위 경로
	private String basImgServcAreaId; //베이스이미지서비스영역ID
	private String bldStatNm; //빌드상태코드명
	private String bldHstryId; //빌드이력ID
	private String ctlTrgtYn; //제어대상여부

	/**
	 * @return the servcSeq
	 */
	public Integer getServcSeq() {
		return servcSeq;
	}
	/**
	 * @param servcSeq the servcSeq to set
	 */
	public void setServcSeq(Integer servcSeq) {
		this.servcSeq = servcSeq;
	}
	/**
	 * @return the bldId
	 */
	public String getBldId() {
		return bldId;
	}
	/**
	 * @param bldId the bldId to set
	 */
	public void setBldId(String bldId) {
		this.bldId = bldId;
	}
	/**
	 * @return the bldNm
	 */
	public String getBldNm() {
		return bldNm;
	}
	/**
	 * @param bldNm the bldNm to set
	 */
	public void setBldNm(String bldNm) {
		this.bldNm = bldNm;
	}
	/**
	 * @return the basImgId
	 */
	public String getBasImgId() {
		return basImgId;
	}
	/**
	 * @param basImgId the basImgId to set
	 */
	public void setBasImgId(String basImgId) {
		this.basImgId = basImgId;
	}
	/**
	 * @return the basImgNm
	 */
	public String getBasImgNm() {
		return basImgNm;
	}
	/**
	 * @param basImgNm the basImgNm to set
	 */
	public void setBasImgNm(String basImgNm) {
		this.basImgNm = basImgNm;
	}
	/**
	 * @return the basImgVer
	 */
	public String getBasImgVer() {
		return basImgVer;
	}
	/**
	 * @param basImgVer the basImgVer to set
	 */
	public void setBasImgVer(String basImgVer) {
		this.basImgVer = basImgVer;
	}
	/**
	 * @return the repoTyCd
	 */
	public String getRepoTyCd() {
		return repoTyCd;
	}
	/**
	 * @param repoTyCd the repoTyCd to set
	 */
	public void setRepoTyCd(String repoTyCd) {
		this.repoTyCd = repoTyCd;
	}
	/**
	 * @return the repoAddr
	 */
	public String getRepoAddr() {
		return repoAddr;
	}
	/**
	 * @param repoAddr the repoAddr to set
	 */
	public void setRepoAddr(String repoAddr) {
		this.repoAddr = repoAddr;
	}
	/**
	 * @return the gitBrnchNm
	 */
	public String getGitBrnchNm() {
		return gitBrnchNm;
	}
	/**
	 * @param gitBrnchNm the gitBrnchNm to set
	 */
	public void setGitBrnchNm(String gitBrnchNm) {
		this.gitBrnchNm = gitBrnchNm;
	}
	/**
	 * @return the gitBestPath
	 */
	public String getGitBestPath() {
		return gitBestPath;
	}
	/**
	 * @param gitBestPath the gitBestPath to set
	 */
	public void setGitBestPath(String gitBestPath) {
		this.gitBestPath = gitBestPath;
	}
	/**
	 * @return the scrtkyId
	 */
	public String getScrtkyId() {
		return scrtkyId;
	}
	/**
	 * @param scrtkyId the scrtkyId to set
	 */
	public void setScrtkyId(String scrtkyId) {
		this.scrtkyId = scrtkyId;
	}
	/**
	 * @return the creImgNm
	 */
	public String getCreImgNm() {
		return creImgNm;
	}
	/**
	 * @param creImgNm the creImgNm to set
	 */
	public void setCreImgNm(String creImgNm) {
		this.creImgNm = creImgNm;
	}
	/**
	 * @return the creImgId
	 */
	public String getCreImgId() {
		return creImgId;
	}
	/**
	 * @param creImgId the creImgId to set
	 */
	public void setCreImgId(String creImgId) {
		this.creImgId = creImgId;
	}
	/**
	 * @return the imgTag
	 */
	public String getImgTag() {
		return imgTag;
	}
	/**
	 * @param imgTag the imgTag to set
	 */
	public void setImgTag(String imgTag) {
		this.imgTag = imgTag;
	}
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
	 * @return the lastBldVer
	 */
	public String getLastBldVer() {
		return lastBldVer;
	}
	/**
	 * @param lastBldVer the lastBldVer to set
	 */
	public void setLastBldVer(String lastBldVer) {
		this.lastBldVer = lastBldVer;
	}
	/**
	 * @return the lastBldDttm
	 */
	public String getLastBldDttm() {
		return lastBldDttm;
	}
	/**
	 * @param lastBldDttm the lastBldDttm to set
	 */
	public void setLastBldDttm(String lastBldDttm) {
		this.lastBldDttm = lastBldDttm;
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
	 * @return the updtDttm
	 */
	public String getUpdtDttm() {
		return updtDttm;
	}
	/**
	 * @param updtDttm the updtDttm to set
	 */
	public void setUpdtDttm(String updtDttm) {
		this.updtDttm = updtDttm;
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
	 * @return the updtUserId
	 */
	public String getUpdtUserId() {
		return updtUserId;
	}
	/**
	 * @param updtUserId the updtUserId to set
	 */
	public void setUpdtUserId(String updtUserId) {
		this.updtUserId = updtUserId;
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
	 * @return the updtUserNm
	 */
	public String getUpdtUserNm() {
		return updtUserNm;
	}
	/**
	 * @param updtUserNm the updtUserNm to set
	 */
	public void setUpdtUserNm(String updtUserNm) {
		this.updtUserNm = updtUserNm;
	}
	/**
	 * @return the bldStatCd
	 */
	public String getBldStatCd() {
		return bldStatCd;
	}
	/**
	 * @param bldStatCd the bldStatCd to set
	 */
	public void setBldStatCd(String bldStatCd) {
		this.bldStatCd = bldStatCd;
	}
	/**
	 * @return the statCd
	 */
	public String getStatCd() {
		return statCd;
	}
	/**
	 * @param statCd the statCd to set
	 */
	public void setStatCd(String statCd) {
		this.statCd = statCd;
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
	 * @return the netClCdNm
	 */
	public String getNetClCdNm() {
		return netClCdNm;
	}
	/**
	 * @param netClCdNm the netClCdNm to set
	 */
	public void setNetClCdNm(String netClCdNm) {
		this.netClCdNm = netClCdNm;
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
	 * @return the bldVer
	 */
	public String getBldVer() {
		return bldVer;
	}
	/**
	 * @param bldVer the bldVer to set
	 */
	public void setBldVer(String bldVer) {
		this.bldVer = bldVer;
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
	 * @return the originBasImgId
	 */
	public String getOriginBasImgId() {
		return originBasImgId;
	}
	/**
	 * @param originBasImgId the originBasImgId to set
	 */
	public void setOriginBasImgId(String originBasImgId) {
		this.originBasImgId = originBasImgId;
	}
	/**
	 * @return the originRepoAddr
	 */
	public String getOriginRepoAddr() {
		return originRepoAddr;
	}
	/**
	 * @param originRepoAddr the originRepoAddr to set
	 */
	public void setOriginRepoAddr(String originRepoAddr) {
		this.originRepoAddr = originRepoAddr;
	}
	/**
	 * @return the originScrtkyId
	 */
	public String getOriginScrtkyId() {
		return originScrtkyId;
	}
	/**
	 * @param originScrtkyId the originScrtkyId to set
	 */
	public void setOriginScrtkyId(String originScrtkyId) {
		this.originScrtkyId = originScrtkyId;
	}
	/**
	 * @return the originGitBrnchNm
	 */
	public String getOriginGitBrnchNm() {
		return originGitBrnchNm;
	}
	/**
	 * @param originGitBrnchNm the originGitBrnchNm to set
	 */
	public void setOriginGitBrnchNm(String originGitBrnchNm) {
		this.originGitBrnchNm = originGitBrnchNm;
	}
	/**
	 * @return the originGitBestPath
	 */
	public String getOriginGitBestPath() {
		return originGitBestPath;
	}
	/**
	 * @param originGitBestPath the originGitBestPath to set
	 */
	public void setOriginGitBestPath(String originGitBestPath) {
		this.originGitBestPath = originGitBestPath;
	}
	/**
	 * @return the basImgServcAreaId
	 */
	public String getBasImgServcAreaId() {
		return basImgServcAreaId;
	}
	/**
	 * @param basImgServcAreaId the basImgServcAreaId to set
	 */
	public void setBasImgServcAreaId(String basImgServcAreaId) {
		this.basImgServcAreaId = basImgServcAreaId;
	}
	/**
	 * @return the bldStatNm
	 */
	public String getBldStatNm() {
		return bldStatNm;
	}
	/**
	 * @param bldStatNm the bldStatNm to set
	 */
	public void setBldStatNm(String bldStatNm) {
		this.bldStatNm = bldStatNm;
	}

	/**
	 * @return the bldHstryId
	 */
	public String getBldHstryId() {
		return bldHstryId;
	}
	/**
	 * @param bldHstryId the bldHstryId to set
	 */
	public void setBldHstryId(String bldHstryId) {
		this.bldHstryId = bldHstryId;
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



}