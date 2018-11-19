package ncis.rest.intfc.conf.vo;

import java.util.List;


/**
 * @author YangJY
 *
 */
public class CfServcSclngVO {

	private Integer servcSeq; 		/* 서비스SEQ */
	private String scalrId; 		/* 스케일러ID */
	private String sclngClNm; 		/* 스케일링구분코드명 */
	private String scalrNm; 		/* 스케일러명 */
	private Integer nowPodQty; 	/* 현재POD수 */
	private Integer minPodQty; 	/* 최소POD수 */
	private Integer maxPodQty; 	/* 최대POD수 */
	private String alarmYn; 		/* 알림여부 */
	private String creDttm; 		/* 생성일시 */
	private String updtDttm; 		/* 수정일시 */
	private String lastSclDttm; 	/* 최종스케일일시 */
	private String creUserId; 		/* 생성자ID */
	private String updtUserId; 	/* 수정자ID */

	private List<CfSclngThresConfVO> sclngThresConfInfos; /* 스케일링임계치설정 */

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
	 * @return the scalrId
	 */
	public String getScalrId() {
		return scalrId;
	}

	/**
	 * @param scalrId the scalrId to set
	 */
	public void setScalrId(String scalrId) {
		this.scalrId = scalrId;
	}

	/**
	 * @return the sclngClNm
	 */
	public String getSclngClNm() {
		return sclngClNm;
	}

	/**
	 * @param sclngClNm the sclngClNm to set
	 */
	public void setSclngClNm(String sclngClNm) {
		this.sclngClNm = sclngClNm;
	}

	/**
	 * @return the scalrNm
	 */
	public String getScalrNm() {
		return scalrNm;
	}

	/**
	 * @param scalrNm the scalrNm to set
	 */
	public void setScalrNm(String scalrNm) {
		this.scalrNm = scalrNm;
	}

	/**
	 * @return the nowPodQty
	 */
	public Integer getNowPodQty() {
		return nowPodQty;
	}

	/**
	 * @param nowPodQty the nowPodQty to set
	 */
	public void setNowPodQty(Integer nowPodQty) {
		this.nowPodQty = nowPodQty;
	}

	/**
	 * @return the minPodQty
	 */
	public Integer getMinPodQty() {
		return minPodQty;
	}

	/**
	 * @param minPodQty the minPodQty to set
	 */
	public void setMinPodQty(Integer minPodQty) {
		this.minPodQty = minPodQty;
	}

	/**
	 * @return the maxPodQty
	 */
	public Integer getMaxPodQty() {
		return maxPodQty;
	}

	/**
	 * @param maxPodQty the maxPodQty to set
	 */
	public void setMaxPodQty(Integer maxPodQty) {
		this.maxPodQty = maxPodQty;
	}

	/**
	 * @return the alarmYn
	 */
	public String getAlarmYn() {
		return alarmYn;
	}

	/**
	 * @param alarmYn the alarmYn to set
	 */
	public void setAlarmYn(String alarmYn) {
		this.alarmYn = alarmYn;
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
	 * @return the lastSclDttm
	 */
	public String getLastSclDttm() {
		return lastSclDttm;
	}

	/**
	 * @param lastSclDttm the lastSclDttm to set
	 */
	public void setLastSclDttm(String lastSclDttm) {
		this.lastSclDttm = lastSclDttm;
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
	 * @return the sclngThresConfInfos
	 */
	public List<CfSclngThresConfVO> getSclngThresConfInfos() {
		return sclngThresConfInfos;
	}

	/**
	 * @param sclngThresConfInfos the sclngThresConfInfos to set
	 */
	public void setSclngThresConfInfos(List<CfSclngThresConfVO> sclngThresConfInfos) {
		this.sclngThresConfInfos = sclngThresConfInfos;
	}


}
