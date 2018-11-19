package ncis.cmn.entity;

/**
 * 서비스영역제한설정 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author x
 */

public class RxServcAreaLmttConf {

	private Integer servcAreaSeq;  /* 서비스영역SEQ */
	private String lmttConfId;  /* 제한설정ID */
	private String lmttTyCd;  /* 제한유형코드 */
	private double maxCpuCorQty;  /* 최대CPU코어수 */
	private double maxMemCapa;  /* 최대메모리용량 */
	private double minCpuCorQty;  /* 최소CPU코어수 */
	private double minMemCapa;  /* 최소메모리용량 */
	private Integer maxPodQty;  /* 최대POD수 */
	private double reqCpuCorQty;  /* 요청CPU코어수 */
	private double reqMemCapa;  /* 요청메모리용량 */
	private Integer reqStrgCapa;  /* 요청스토리지용량 */
	private double lmttCpuCorQty;  /* 제한CPU코어수 */
	private double lmttMemCapa;  /* 제한메모리용량 */
	private String creUserId; /* 생성자 */
	private String updtUserId; /* 수정자 */

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
	 * @return the lmttConfId
	 */
	public String getLmttConfId() {
		return lmttConfId;
	}
	/**
	 * @param lmttConfId the lmttConfId to set
	 */
	public void setLmttConfId(String lmttConfId) {
		this.lmttConfId = lmttConfId;
	}
	/**
	 * @return the lmttTyCd
	 */
	public String getLmttTyCd() {
		return lmttTyCd;
	}
	/**
	 * @param lmttTyCd the lmttTyCd to set
	 */
	public void setLmttTyCd(String lmttTyCd) {
		this.lmttTyCd = lmttTyCd;
	}
	/**
	 * @return the maxCpuCorQty
	 */
	public double getMaxCpuCorQty() {
		return maxCpuCorQty;
	}
	/**
	 * @param maxCpuCorQty the maxCpuCorQty to set
	 */
	public void setMaxCpuCorQty(double maxCpuCorQty) {
		this.maxCpuCorQty = maxCpuCorQty;
	}
	/**
	 * @return the maxMemCapa
	 */
	public double getMaxMemCapa() {
		return maxMemCapa;
	}
	/**
	 * @param maxMemCapa the maxMemCapa to set
	 */
	public void setMaxMemCapa(double maxMemCapa) {
		this.maxMemCapa = maxMemCapa;
	}
	/**
	 * @return the minCpuCorQty
	 */
	public double getMinCpuCorQty() {
		return minCpuCorQty;
	}
	/**
	 * @param minCpuCorQty the minCpuCorQty to set
	 */
	public void setMinCpuCorQty(double minCpuCorQty) {
		this.minCpuCorQty = minCpuCorQty;
	}
	/**
	 * @return the minMemCapa
	 */
	public double getMinMemCapa() {
		return minMemCapa;
	}
	/**
	 * @param minMemCapa the minMemCapa to set
	 */
	public void setMinMemCapa(double minMemCapa) {
		this.minMemCapa = minMemCapa;
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
	 * @return the reqStrgCapa
	 */
	public Integer getReqStrgCapa() {
		return reqStrgCapa;
	}
	/**
	 * @return the reqCpuCorQty
	 */
	public double getReqCpuCorQty() {
		return reqCpuCorQty;
	}
	/**
	 * @param reqCpuCorQty the reqCpuCorQty to set
	 */
	public void setReqCpuCorQty(double reqCpuCorQty) {
		this.reqCpuCorQty = reqCpuCorQty;
	}
	/**
	 * @return the reqMemCapa
	 */
	public double getReqMemCapa() {
		return reqMemCapa;
	}
	/**
	 * @param reqMemCapa the reqMemCapa to set
	 */
	public void setReqMemCapa(double reqMemCapa) {
		this.reqMemCapa = reqMemCapa;
	}
	/**
	 * @param reqStrgCapa the reqStrgCapa to set
	 */
	public void setReqStrgCapa(Integer reqStrgCapa) {
		this.reqStrgCapa = reqStrgCapa;
	}
	/**
	 * @return the lmttCpuCorQty
	 */
	public double getLmttCpuCorQty() {
		return lmttCpuCorQty;
	}
	/**
	 * @param lmttCpuCorQty the lmttCpuCorQty to set
	 */
	public void setLmttCpuCorQty(double lmttCpuCorQty) {
		this.lmttCpuCorQty = lmttCpuCorQty;
	}
	/**
	 * @return the lmttMemCapa
	 */
	public double getLmttMemCapa() {
		return lmttMemCapa;
	}
	/**
	 * @param lmttMemCapa the lmttMemCapa to set
	 */
	public void setLmttMemCapa(double lmttMemCapa) {
		this.lmttMemCapa = lmttMemCapa;
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



}
