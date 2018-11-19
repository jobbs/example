package ncis.cmn.entity;

/**
 * 서비스 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author x
 */

public class RxServc {

	private String updtUserId;  /* 수정자ID */
	private String updtDttm;  /* 수정일시 */
	private String statCd;  /* 상태코드 */
	private String servcUid;  /* 서비스UID */
	private String servcNm;  /* 서비스명 */
	private String servcId;  /* 서비스ID */
	private String servcCompId;  /* 서비스구성ID */
	private String rmk;  /* 비고 */
	private String jobId;  /* 업무ID */
	private String delYn;  /* 삭제여부 */
	private String delUserId;  /* 삭제자ID */
	private String delDttm;  /* 삭제일시 */
	private String creUserId;  /* 생성자ID */
	private String creDttm;  /* 생성일시 */
	private Integer servcSeq;  /* 서비스SEQ */
	private Integer servcAreaSeq;  /* 서비스영역SEQ */
	private String servcTyCd; /* 서비스유형코드 */


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
	 * @return the servcUid
	 */
	public String getServcUid() {
		return servcUid;
	}
	/**
	 * @param servcUid the servcUid to set
	 */
	public void setServcUid(String servcUid) {
		this.servcUid = servcUid;
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
	 * @return the servcCompId
	 */
	public String getServcCompId() {
		return servcCompId;
	}
	/**
	 * @param servcCompId the servcCompId to set
	 */
	public void setServcCompId(String servcCompId) {
		this.servcCompId = servcCompId;
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
	 * @return the delYn
	 */
	public String getDelYn() {
		return delYn;
	}
	/**
	 * @param delYn the delYn to set
	 */
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	/**
	 * @return the delUserId
	 */
	public String getDelUserId() {
		return delUserId;
	}
	/**
	 * @param delUserId the delUserId to set
	 */
	public void setDelUserId(String delUserId) {
		this.delUserId = delUserId;
	}
	/**
	 * @return the delDttm
	 */
	public String getDelDttm() {
		return delDttm;
	}
	/**
	 * @param delDttm the delDttm to set
	 */
	public void setDelDttm(String delDttm) {
		this.delDttm = delDttm;
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
	 * @return the servcTyCd
	 */
	public String getServcTyCd() {
		return servcTyCd;
	}
	/**
	 * @param servcTyCd the servcTyCd to set
	 */
	public void setServcTyCd(String servcTyCd) {
		this.servcTyCd = servcTyCd;
	}

}
