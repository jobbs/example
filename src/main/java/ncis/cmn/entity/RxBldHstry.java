package ncis.cmn.entity;

import java.sql.Timestamp;

/**
 * 빌드이력 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author x
 */

public class RxBldHstry {

    private Integer servcSeq;  /* 서비스SEQ */
    private String bldHstryId;  /* 빌드이력ID */
    private String bldId;  /* 빌드ID */
    private String bldVer;  /* 빌드버전 */
    private String rsrcVer;  /* 자원버전 */
    private String basImgServcAreaId;  /* 베이스이미지서비스영역ID */
    private String basImgId;  /* 베이스이미지ID */
    private String repoTyCd;  /* 저장소유형코드 */
    private String repoAddr;  /* 저장소주소 */
    private String gitBrnchNm;  /* GIT브랜치명 */
    private String gitBestPath;  /* GIT최상위경로 */
    private String creImgNm;  /* 생성이미지명 */
    private String creImgId;  /* 생성이미지ID */
    private String bldStatCd;  /* 빌드상태코드 */
    private String creDttm;  /* 생성일시 */
    private String creUserId;  /* 생성자ID */
    private String updtUserId;  /* 수정자ID */
    private String imgTag;  /* 이미지태그 */
    private String scrtkyId; /*보안키*/
    private Timestamp bldDttmSync;


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
	 * @return the rsrcVer
	 */
	public String getRsrcVer() {
		return rsrcVer;
	}
	/**
	 * @param rsrcVer the rsrcVer to set
	 */
	public void setRsrcVer(String rsrcVer) {
		this.rsrcVer = rsrcVer;
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
	 * @return the bldDttmSync
	 */
	public Timestamp getBldDttmSync() {
		return bldDttmSync;
	}
	/**
	 * @param bldDttmSync the bldDttmSync to set
	 */
	public void setBldDttmSync(Timestamp bldDttmSync) {
		this.bldDttmSync = bldDttmSync;
	}


}
