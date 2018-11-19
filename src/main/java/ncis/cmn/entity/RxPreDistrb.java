package ncis.cmn.entity;

public class RxPreDistrb  {

	private Integer preDistrbReqSeq; /*사전배포요청SEQ*/
	private String rsrcPoolId; /*자원풀 ID*/
	private String imgId; /*배포 이미지ID*/
	private String imgRepoDtlAddr; /*이미지저장소상세주소*/
	private String distrbReqDttm; /*배포요청 일시*/
	private String distrbReqUserId; /*.배포 요청자ID*/
	private String rmk; /*비고*/
    private Integer servcAreaSeq;  /* 서비스영역SEQ */
    private String demonSetId; // 데몬setID
    private String distrbStatCd; //배포상태코드
    private String institutionId;
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
	 * @return the institutionId
	 */
	public String getInstitutionId() {
		return institutionId;
	}
	/**
	 * @param institutionId the institutionId to set
	 */
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RxPreDistrb [preDistrbReqSeq=" + preDistrbReqSeq
				+ ", rsrcPoolId=" + rsrcPoolId + ", imgId=" + imgId
				+ ", imgRepoDtlAddr=" + imgRepoDtlAddr + ", distrbReqDttm="
				+ distrbReqDttm + ", distrbReqUserId=" + distrbReqUserId
				+ ", rmk=" + rmk + ", servcAreaSeq=" + servcAreaSeq
				+ ", demonSetId=" + demonSetId + ", distrbStatCd="
				+ distrbStatCd + ", institutionId=" + institutionId + "]";
	}




}