/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NamespaceVO.java
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 05. 31.
 * @lastmodified 2017. 05. 31.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 05. 31.     x         v1.0             최초생성
 *
 */
package ncis.intfc.atmscl.vo;

import java.sql.Timestamp;

/**
 * @author x
 *
 */
public class AtmSclResultIfVo {

	private String uid; //uid
	private String message;  //메시지
	private String statCd; //상태코드
	private String succYn; //성공여부
	private String imgRepoAddr; //이미지저장소 주소
	private String buildNumber; //빌드버전
	private String creationTime; //생성일자
	private Integer podsCnt; //pod 개수
	private Integer latestVersion; //배포버전
	private String buildPhase; //빌드상태
	private String deploymentPhase; //배포상태
	private String code; //배포상태
	private Timestamp lastDistrbDttm;
	private Integer replicas;
	private Timestamp lastBldDttm;
	private String repoTyCd;
	private String repoAddr;
	private String gitBrnchNm;
	private String creImgNm;
	private String creImgId;
	private String imgTag;

	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
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
	 * @return the succYn
	 */
	public String getSuccYn() {
		return succYn;
	}
	/**
	 * @param succYn the succYn to set
	 */
	public void setSuccYn(String succYn) {
		this.succYn = succYn;
	}
	/**
	 * @return the imgRepoAddr
	 */
	public String getImgRepoAddr() {
		return imgRepoAddr;
	}
	/**
	 * @param imgRepoAddr the imgRepoAddr to set
	 */
	public void setImgRepoAddr(String imgRepoAddr) {
		this.imgRepoAddr = imgRepoAddr;
	}
	/**
	 * @return the buildNumber
	 */
	public String getBuildNumber() {
		return buildNumber;
	}
	/**
	 * @param buildNumber the buildNumber to set
	 */
	public void setBuildNumber(String buildNumber) {
		this.buildNumber = buildNumber;
	}
	/**
	 * @return the creationTime
	 */
	public String getCreationTime() {
		return creationTime;
	}
	/**
	 * @param creationTime the creationTime to set
	 */
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	/**
	 * @return the podsCnt
	 */
	public Integer getPodsCnt() {
		return podsCnt;
	}
	/**
	 * @param podsCnt the podsCnt to set
	 */
	public void setPodsCnt(Integer podsCnt) {
		this.podsCnt = podsCnt;
	}
	/**
	 * @return the latestVersion
	 */
	public Integer getLatestVersion() {
		return latestVersion;
	}
	/**
	 * @param latestVersion the latestVersion to set
	 */
	public void setLatestVersion(Integer latestVersion) {
		this.latestVersion = latestVersion;
	}
	/**
	 * @return the buildPhase
	 */
	public String getBuildPhase() {
		return buildPhase;
	}
	/**
	 * @param buildPhase the buildPhase to set
	 */
	public void setBuildPhase(String buildPhase) {
		this.buildPhase = buildPhase;
	}
	/**
	 * @return the deploymentPhase
	 */
	public String getDeploymentPhase() {
		return deploymentPhase;
	}
	/**
	 * @param deploymentPhase the deploymentPhase to set
	 */
	public void setDeploymentPhase(String deploymentPhase) {
		this.deploymentPhase = deploymentPhase;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the lastDistrbDttm
	 */
	public Timestamp getLastDistrbDttm() {
		return lastDistrbDttm;
	}
	/**
	 * @param lastDistrbDttm the lastDistrbDttm to set
	 */
	public void setLastDistrbDttm(Timestamp lastDistrbDttm) {
		this.lastDistrbDttm = lastDistrbDttm;
	}
	/**
	 * @return the replicas
	 */
	public Integer getReplicas() {
		return replicas;
	}
	/**
	 * @param replicas the replicas to set
	 */
	public void setReplicas(Integer replicas) {
		this.replicas = replicas;
	}
	/**
	 * @return the lastBldDttm
	 */
	public Timestamp getLastBldDttm() {
		return lastBldDttm;
	}
	/**
	 * @param lastBldDttm the lastBldDttm to set
	 */
	public void setLastBldDttm(Timestamp lastBldDttm) {
		this.lastBldDttm = lastBldDttm;
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

}
