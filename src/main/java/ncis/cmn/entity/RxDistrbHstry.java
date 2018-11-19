package ncis.cmn.entity;

import java.sql.Timestamp;

/**
 * RxDistrbHstry Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author x
 */

public class RxDistrbHstry {


    private Integer servcSeq;  /* 서비스SEQ */
    private String distrbId;  /* 배포ID */
    private String distrbConfId;  /* 배포설정ID */
    private String distrbVer;  /* 배포버전 */
    private String distrbDttm;  /* 배포일시 */
    private String distrbStatCd;  /* 배포상태코드 */
    private String creDttm;  /* 생성일시 */
    private String tmplatNm;  /* 템플릿명 */
    private String reStrtPolicyClCd;  /* 재기동정책구분코드 */
    private String dnsPolicyClCd;  /* DNS정책구분코드 */
    private double reqCpuCorQty;  /* 요청CPU코어수 */
    private double reqMemCapa;  /* 요청메모리용량 */
    private double lmttCpuCorQty;  /* 제한CPU코어수 */
    private double lmttMemCapa;  /* 제한메모리용량 */
    private Integer rplcaQty;  /* 복제수 */
    private String updtDttm;  /* 수정일시 */
    private Timestamp distrbDttmSync;



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
	 * @return the distrbId
	 */
	public String getDistrbId() {
		return distrbId;
	}
	/**
	 * @param distrbId the distrbId to set
	 */
	public void setDistrbId(String distrbId) {
		this.distrbId = distrbId;
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
	 * @return the distrbVer
	 */
	public String getDistrbVer() {
		return distrbVer;
	}
	/**
	 * @param distrbVer the distrbVer to set
	 */
	public void setDistrbVer(String distrbVer) {
		this.distrbVer = distrbVer;
	}
	/**
	 * @return the distrbDttm
	 */
	public String getDistrbDttm() {
		return distrbDttm;
	}
	/**
	 * @param distrbDttm the distrbDttm to set
	 */
	public void setDistrbDttm(String distrbDttm) {
		this.distrbDttm = distrbDttm;
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
	 * @return the tmplatNm
	 */
	public String getTmplatNm() {
		return tmplatNm;
	}
	/**
	 * @param tmplatNm the tmplatNm to set
	 */
	public void setTmplatNm(String tmplatNm) {
		this.tmplatNm = tmplatNm;
	}
	/**
	 * @return the reStrtPolicyClCd
	 */
	public String getReStrtPolicyClCd() {
		return reStrtPolicyClCd;
	}
	/**
	 * @param reStrtPolicyClCd the reStrtPolicyClCd to set
	 */
	public void setReStrtPolicyClCd(String reStrtPolicyClCd) {
		this.reStrtPolicyClCd = reStrtPolicyClCd;
	}
	/**
	 * @return the dnsPolicyClCd
	 */
	public String getDnsPolicyClCd() {
		return dnsPolicyClCd;
	}
	/**
	 * @param dnsPolicyClCd the dnsPolicyClCd to set
	 */
	public void setDnsPolicyClCd(String dnsPolicyClCd) {
		this.dnsPolicyClCd = dnsPolicyClCd;
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
	 * @return the rplcaQty
	 */
	public Integer getRplcaQty() {
		return rplcaQty;
	}
	/**
	 * @param rplcaQty the rplcaQty to set
	 */
	public void setRplcaQty(Integer rplcaQty) {
		this.rplcaQty = rplcaQty;
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
	 * @return the distrbDttmSync
	 */
	public Timestamp getDistrbDttmSync() {
		return distrbDttmSync;
	}
	/**
	 * @param distrbDttmSync the distrbDttmSync to set
	 */
	public void setDistrbDttmSync(Timestamp distrbDttmSync) {
		this.distrbDttmSync = distrbDttmSync;
	}


}
