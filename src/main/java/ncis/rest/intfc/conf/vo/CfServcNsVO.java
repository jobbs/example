package ncis.rest.intfc.conf.vo;


/**
 * @author LeeJiHun
 *
 */
public class CfServcNsVO{

	private Integer servcAreaSeq; /* 서비스영역SEQ */
	private String servcAreaId; /* 서비스영역ID */
	private String servcAreaNm; /* 서비스영역명 */
	private String servcAreaUid; /* 서비스영역UID */
	private String institutionId; /* 기관ID */
	private String jobId;  /* 업무ID */
	private String rsrcPoolId;  /* 자원풀ID */
	private String servcAreaCompId; /* 서비스영역구성ID */
	private String rmk; /* 비고 */
	private Double reqCpuCorQty;  /* 요청CPU코어수 */
	private Double reqMemCapa;  /* 요청메모리용량 */
	private Double lmttCpuCorQty;  /* 제한CPU코어수 */
	private Double lmttMemCapa;  /* 제한메모리용량 */
	private Integer maxPodQty; /* 최대POD수 */
	private Double minCpuCorQty;  /* 최소CPU수 */
	private Double minMemCapa;     /* 최소메모리용량 */
	private Double maxCpuCorQty;  /* 최대CPU수 */
	private Double maxMemCapa;     /* 최대메모리용량 */


	public Integer getServcAreaSeq() {
	    return servcAreaSeq;
	}
	public void setServcAreaSeq(Integer servcAreaSeq) {
	    this.servcAreaSeq = servcAreaSeq;
	}
	public String getServcAreaId() {
	    return servcAreaId;
	}
	public void setServcAreaId(String servcAreaId) {
	    this.servcAreaId = servcAreaId;
	}
	public String getServcAreaNm() {
	    return servcAreaNm;
	}
	public void setServcAreaNm(String servcAreaNm) {
	    this.servcAreaNm = servcAreaNm;
	}
	public String getServcAreaUid() {
	    return servcAreaUid;
	}
	public void setServcAreaUid(String servcAreaUid) {
	    this.servcAreaUid = servcAreaUid;
	}
	public String getInstitutionId() {
	    return institutionId;
	}
	public void setInstitutionId(String institutionId) {
	    this.institutionId = institutionId;
	}
	public String getJobId() {
	    return jobId;
	}
	public void setJobId(String jobId) {
	    this.jobId = jobId;
	}
	public String getRsrcPoolId() {
	    return rsrcPoolId;
	}
	public void setRsrcPoolId(String rsrcPoolId) {
	    this.rsrcPoolId = rsrcPoolId;
	}
	public String getServcAreaCompId() {
	    return servcAreaCompId;
	}
	public void setServcAreaCompId(String servcAreaCompId) {
	    this.servcAreaCompId = servcAreaCompId;
	}
	public String getRmk() {
	    return rmk;
	}
	public void setRmk(String rmk) {
	    this.rmk = rmk;
	}
	public Double getReqCpuCorQty() {
	    return reqCpuCorQty;
	}
	public void setReqCpuCorQty(Double reqCpuCorQty) {
	    this.reqCpuCorQty = reqCpuCorQty;
	}
	public Double getReqMemCapa() {
	    return reqMemCapa;
	}
	public void setReqMemCapa(Double reqMemCapa) {
	    this.reqMemCapa = reqMemCapa;
	}
	public Double getLmttCpuCorQty() {
	    return lmttCpuCorQty;
	}
	public void setLmttCpuCorQty(Double lmttCpuCorQty) {
	    this.lmttCpuCorQty = lmttCpuCorQty;
	}
	public Double getLmttMemCapa() {
	    return lmttMemCapa;
	}
	public void setLmttMemCapa(Double lmttMemCapa) {
	    this.lmttMemCapa = lmttMemCapa;
	}
	public Integer getMaxPodQty() {
	    return maxPodQty;
	}
	public void setMaxPodQty(Integer maxPodQty) {
	    this.maxPodQty = maxPodQty;
	}
	public Double getMinCpuCorQty() {
	    return minCpuCorQty;
	}
	public void setMinCpuCorQty(Double minCpuCorQty) {
	    this.minCpuCorQty = minCpuCorQty;
	}
	public Double getMinMemCapa() {
	    return minMemCapa;
	}
	public void setMinMemCapa(Double minMemCapa) {
	    this.minMemCapa = minMemCapa;
	}
	public Double getMaxCpuCorQty() {
	    return maxCpuCorQty;
	}
	public void setMaxCpuCorQty(Double maxCpuCorQty) {
	    this.maxCpuCorQty = maxCpuCorQty;
	}
	public Double getMaxMemCapa() {
	    return maxMemCapa;
	}
	public void setMaxMemCapa(Double maxMemCapa) {
	    this.maxMemCapa = maxMemCapa;
	}

}
