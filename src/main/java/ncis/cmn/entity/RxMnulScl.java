package ncis.cmn.entity;

/**
 * PVC Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author x
 */

public class RxMnulScl {

	private Integer nowPodQty; //현재POD 수
	private Integer chngPodQty; //변경POD 수
	private String reqDttm;  /* 등록일시 */
	private String sclReasn; // 스케일 사유
	private Integer cpuUseRt;
	private Integer memUseRt;
	private String regUserId;
	private Integer servcSeq;
	private String distrbConfId;
	private String servcAreaId;
    private double avgCpuUseRt; /* CPU사용률 */
    private double avgMemUseRt; /* 메모리사용률 */
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
	 * @return the chngPodQty
	 */
	public Integer getChngPodQty() {
		return chngPodQty;
	}
	/**
	 * @param chngPodQty the chngPodQty to set
	 */
	public void setChngPodQty(Integer chngPodQty) {
		this.chngPodQty = chngPodQty;
	}
	/**
	 * @return the reqDttm
	 */
	public String getReqDttm() {
		return reqDttm;
	}
	/**
	 * @param reqDttm the reqDttm to set
	 */
	public void setReqDttm(String reqDttm) {
		this.reqDttm = reqDttm;
	}
	/**
	 * @return the sclReasn
	 */
	public String getSclReasn() {
		return sclReasn;
	}
	/**
	 * @param sclReasn the sclReasn to set
	 */
	public void setSclReasn(String sclReasn) {
		this.sclReasn = sclReasn;
	}
	/**
	 * @return the cpuUseRt
	 */
	public Integer getCpuUseRt() {
		return cpuUseRt;
	}
	/**
	 * @param cpuUseRt the cpuUseRt to set
	 */
	public void setCpuUseRt(Integer cpuUseRt) {
		this.cpuUseRt = cpuUseRt;
	}
	/**
	 * @return the memUseRt
	 */
	public Integer getMemUseRt() {
		return memUseRt;
	}
	/**
	 * @param memUseRt the memUseRt to set
	 */
	public void setMemUseRt(Integer memUseRt) {
		this.memUseRt = memUseRt;
	}
	/**
	 * @return the regUserId
	 */
	public String getRegUserId() {
		return regUserId;
	}
	/**
	 * @param regUserId the regUserId to set
	 */
	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
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
	 * @return the distrbConfId
	 */
	public String getDistrbConfId() {
		return distrbConfId;
	}
	/**
	 * @param distrbConfId the distrbConfId to set
	 */
	public void setDistrbConfId(String distrbConfId) {
		this.distrbConfId = distrbConfId;
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
	 * @return the avgCpuUseRt
	 */
	public double getAvgCpuUseRt() {
		return avgCpuUseRt;
	}
	/**
	 * @param avgCpuUseRt the avgCpuUseRt to set
	 */
	public void setAvgCpuUseRt(double avgCpuUseRt) {
		this.avgCpuUseRt = avgCpuUseRt;
	}
	/**
	 * @return the avgMemUseRt
	 */
	public double getAvgMemUseRt() {
		return avgMemUseRt;
	}
	/**
	 * @param avgMemUseRt the avgMemUseRt to set
	 */
	public void setAvgMemUseRt(double avgMemUseRt) {
		this.avgMemUseRt = avgMemUseRt;
	}

}
