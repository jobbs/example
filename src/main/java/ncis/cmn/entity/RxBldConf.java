package ncis.cmn.entity;

import java.sql.Timestamp;


/**
 * 빌드설정 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author x
 */

public class RxBldConf {

    private Integer servcSeq;  /* 서비스SEQ */
    private String bldId;  /* 빌드ID */
    private String bldNm;  /* 빌드명 */
    private String basImgId;  /* 베이스이미지ID */
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
    private String servcAreaId; //서비스 영역 ID
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
