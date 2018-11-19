package ncis.cpt.rsrc.atmscl.vo;

import java.util.List;

import ncis.cmn.entity.RxServcArea;

public class ServcAreaVo extends RxServcArea {

	private String regionId; /* 리전ID */
    private String zoneId; /* 존ID */
    private String netClCd; /* 망구분코드 */
    private String regionNm; /* 리전명 */
    private String zoneNm; /* 존명 */
    private String netNm; /* 망명 */
    private String rsrcPoolId; /* 자원풀ID */
    private String rsrcPoolNm; /* 자원풀명 */
    private String institutionNm; /* 부처명 */
    private String creUserId; /* 생성자 */
    private String updtUserId; /* 수정자 */
    private String creUserNm; /* 생성자명 */
    private String updtUserNm; /* 수정자명 */
    private double maxCpuCorQty; /* 최대CPU코어수 */
    private double maxMemCapa; /* 최대메모리용량 */
    private double minCpuCorQty; /* 최소CPU코어수 */
    private double minMemCapa; /* 최소메모리용량 */
    private Integer maxPodQty; /* 최대POD수 */
    private Integer reqCpuCorQty;  /* 요청CPU코어수 */
    private Integer reqMemCapa;  /* 요청메모리용량 */
    private Integer lmttCpuCorQty;  /* 제한CPU코어수 */
    private Integer lmttMemCapa;  /* 제한메모리용량 */
    private String limitId;  /* 제한ID */
    private String quotaId;  /* 쿼터ID */
    private String limitEditYn;  /* 제한수정여부 */
    private String quotaEditYn;  /* 쿼터수정여부 */
    private double sumMemAsgnCapa; /* 메모리할당량 */
    private double avgMemUseRt; /* 메모리사용률 */
    private double sumCpuCorQty; /* CPU코어수 */
    private double avgCpuUseRt; /* CPU사용률 */
    private double netwkIn; /* 네트워크In */
    private double netwkOut; /* 네트워크Out */
    private Integer podQty; /* Pod수 */
    private String lmttConfId; /* 제한설정ID */
    private String servcAreaCompId;  /* 서비스영역구성ID */
    private String jobNm;  /* 업무명 */
    private Integer intMaxCpuCorQty; /* 최대CPU코어수(int) */
    private Integer intMaxMemCapa;  /* 최소메모리용량 (int) */
    private String ctlTrgtYn; /* 제어여부 */
    private boolean all = false;
    private List<PvVo> pvList;

	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getZoneId() {
		return zoneId;
	}
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	public String getNetClCd() {
		return netClCd;
	}
	public void setNetClCd(String netClCd) {
		this.netClCd = netClCd;
	}
	public String getRegionNm() {
		return regionNm;
	}
	public void setRegionNm(String regionNm) {
		this.regionNm = regionNm;
	}
	public String getZoneNm() {
		return zoneNm;
	}
	public void setZoneNm(String zoneNm) {
		this.zoneNm = zoneNm;
	}
	public String getNetNm() {
		return netNm;
	}
	public void setNetNm(String netNm) {
		this.netNm = netNm;
	}
	public String getRsrcPoolId() {
		return rsrcPoolId;
	}
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}
	public String getInstitutionNm() {
		return institutionNm;
	}
	public void setInstitutionNm(String institutionNm) {
		this.institutionNm = institutionNm;
	}
	public String getCreUserId() {
		return creUserId;
	}
	public void setCreUserId(String creUserId) {
		this.creUserId = creUserId;
	}
	public String getUpdtUserId() {
		return updtUserId;
	}
	public void setUpdtUserId(String updtUserId) {
		this.updtUserId = updtUserId;
	}
	public String getRsrcPoolNm() {
		return rsrcPoolNm;
	}
	public void setRsrcPoolNm(String rsrcPoolNm) {
		this.rsrcPoolNm = rsrcPoolNm;
	}
	public String getCreUserNm() {
		return creUserNm;
	}
	public void setCreUserNm(String creUserNm) {
		this.creUserNm = creUserNm;
	}
	public String getUpdtUserNm() {
		return updtUserNm;
	}
	public void setUpdtUserNm(String updtUserNm) {
		this.updtUserNm = updtUserNm;
	}
	public double getMaxCpuCorQty() {
		return maxCpuCorQty;
	}

	public void setMaxCpuCorQty(double maxCpuCorQty) {
		this.maxCpuCorQty = maxCpuCorQty;
	}

	public double getMaxMemCapa() {
		return maxMemCapa;
	}

	public void setMaxMemCapa(double maxMemCapa) {
		this.maxMemCapa = maxMemCapa;
	}
	public double getMinCpuCorQty() {
		return minCpuCorQty;
	}
	public void setMinCpuCorQty(double minCpuCorQty) {
		this.minCpuCorQty = minCpuCorQty;
	}
	public double getMinMemCapa() {
		return minMemCapa;
	}
	public void setMinMemCapa(double minMemCapa) {
		this.minMemCapa = minMemCapa;
	}
	public void setMaxCpuCorQty(Integer maxCpuCorQty) {
		this.maxCpuCorQty = maxCpuCorQty;
	}
	public Integer getMaxPodQty() {
		return maxPodQty;
	}
	public void setMaxPodQty(Integer maxPodQty) {
		this.maxPodQty = maxPodQty;
	}
	public Integer getReqCpuCorQty() {
		return reqCpuCorQty;
	}
	public void setReqCpuCorQty(Integer reqCpuCorQty) {
		this.reqCpuCorQty = reqCpuCorQty;
	}
	public Integer getReqMemCapa() {
		return reqMemCapa;
	}
	public void setReqMemCapa(Integer reqMemCapa) {
		this.reqMemCapa = reqMemCapa;
	}
	public Integer getLmttCpuCorQty() {
		return lmttCpuCorQty;
	}
	public void setLmttCpuCorQty(Integer lmttCpuCorQty) {
		this.lmttCpuCorQty = lmttCpuCorQty;
	}
	public Integer getLmttMemCapa() {
		return lmttMemCapa;
	}
	public void setLmttMemCapa(Integer lmttMemCapa) {
		this.lmttMemCapa = lmttMemCapa;
	}
	public boolean isAll() {
		return all;
	}
	public void setAll(boolean all) {
		this.all = all;
	}
	public double getSumMemAsgnCapa() {
		return sumMemAsgnCapa;
	}
	public void setSumMemAsgnCapa(double sumMemAsgnCapa) {
		this.sumMemAsgnCapa = sumMemAsgnCapa;
	}
	public double getAvgMemUseRt() {
		return avgMemUseRt;
	}
	public void setAvgMemUseRt(double avgMemUseRt) {
		this.avgMemUseRt = avgMemUseRt;
	}
	public double getSumCpuCorQty() {
		return sumCpuCorQty;
	}
	public void setSumCpuCorQty(double sumCpuCorQty) {
		this.sumCpuCorQty = sumCpuCorQty;
	}
	public double getAvgCpuUseRt() {
		return avgCpuUseRt;
	}
	public void setAvgCpuUseRt(double avgCpuUseRt) {
		this.avgCpuUseRt = avgCpuUseRt;
	}
	public double getNetwkIn() {
		return netwkIn;
	}
	public void setNetwkIn(double netwkIn) {
		this.netwkIn = netwkIn;
	}
	public double getNetwkOut() {
		return netwkOut;
	}
	public void setNetwkOut(double netwkOut) {
		this.netwkOut = netwkOut;
	}
	public Integer getPodQty() {
		return podQty;
	}
	public void setPodQty(Integer podQty) {
		this.podQty = podQty;
	}
	public String getLmttConfId() {
		return lmttConfId;
	}
	public void setLmttConfId(String lmttConfId) {
		this.lmttConfId = lmttConfId;
	}
	public List<PvVo> getPvList() {
		return pvList;
	}
	public void setPvList(List<PvVo> pvList) {
		this.pvList = pvList;
	}
	public String getLimitId() {
		return limitId;
	}
	public void setLimitId(String limitId) {
		this.limitId = limitId;
	}
	public String getQuotaId() {
		return quotaId;
	}
	public void setQuotaId(String quotaId) {
		this.quotaId = quotaId;
	}
	public String getLimitEditYn() {
		return limitEditYn;
	}
	public void setLimitEditYn(String limitEditYn) {
		this.limitEditYn = limitEditYn;
	}
	public String getQuotaEditYn() {
		return quotaEditYn;
	}
	public void setQuotaEditYn(String quotaEditYn) {
		this.quotaEditYn = quotaEditYn;
	}
	public String getServcAreaCompId() {
		return servcAreaCompId;
	}
	public void setServcAreaCompId(String servcAreaCompId) {
		this.servcAreaCompId = servcAreaCompId;
	}
	public String getJobNm() {
		return jobNm;
	}
	public void setJobNm(String jobNm) {
		this.jobNm = jobNm;
	}
	public Integer getIntMaxCpuCorQty() {
		return intMaxCpuCorQty;
	}
	public void setIntMaxCpuCorQty(Integer intMaxCpuCorQty) {
		this.intMaxCpuCorQty = intMaxCpuCorQty;
	}
	public Integer getIntMaxMemCapa() {
		return intMaxMemCapa;
	}
	public void setIntMaxMemCapa(Integer intMaxMemCapa) {
		this.intMaxMemCapa = intMaxMemCapa;
	}
	public String getCtlTrgtYn() {
		return ctlTrgtYn;
	}
	public void setCtlTrgtYn(String ctlTrgtYn) {
		this.ctlTrgtYn = ctlTrgtYn;
	}

}

