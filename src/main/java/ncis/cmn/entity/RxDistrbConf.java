package ncis.cmn.entity;


import java.sql.Timestamp;

/**
 * RxDistrbConf Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author x
 */

public class RxDistrbConf {

    private Integer servcSeq;  /* 서비스SEQ */
    private String distrbConfId;  /* 배포설정ID */
    private String distrbConfNm;  /* 배포설정명 */
    private String tmplatNm;  /* 템플릿명 */
    private String cntanrId;  /* 컨테이너ID */
    private String imgId;  /* 이미지ID */
    private String imgTag;  /* 이미지태그 */
    private String reStrtPolicyClCd;  /* 재기동정책구분코드 */
    private String dnsPolicyClCd;  /* DNS정책구분코드 */
    private Integer rplcaQty;  /* 복제수 */
    private String testYn;  /* 테스트여부 */
    private String lastDistrbDttm;  /* 최종배포일시 */
    private String lastDistrbVer;  /* 최종배포버전 */
    private String statCd;  /* 상태코드 */
    private String rmk;  /* 비고 */
    private String creDttm;  /* 생성일시 */
    private String updtDttm;  /* 수정일시 */
    private String creUserId;  /* 생성자ID */
    private String updtUserId;  /* 수정자ID */
    private double reqCpuCorQty;  /* 요청CPU코어수 */
    private double reqMemCapa;  /* 요청메모리용량 */
    private double lmttCpuCorQty;  /* 제한CPU코어수 */
    private double lmttMemCapa;  /* 제한메모리용량 */
    private String servcAreaId; /*서비스영역ID*/
    private String distrbId;
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
	 * @return the distrbConfNm
	 */
	public String getDistrbConfNm() {
		return distrbConfNm;
	}
	/**
	 * @param distrbConfNm the distrbConfNm to set
	 */
	public void setDistrbConfNm(String distrbConfNm) {
		this.distrbConfNm = distrbConfNm;
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
	 * @return the cntanrId
	 */
	public String getCntanrId() {
		return cntanrId;
	}
	/**
	 * @param cntanrId the cntanrId to set
	 */
	public void setCntanrId(String cntanrId) {
		this.cntanrId = cntanrId;
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
	 * @return the testYn
	 */
	public String getTestYn() {
		return testYn;
	}
	/**
	 * @param testYn the testYn to set
	 */
	public void setTestYn(String testYn) {
		this.testYn = testYn;
	}
	/**
	 * @return the lastDistrbDttm
	 */
	public String getLastDistrbDttm() {
		return lastDistrbDttm;
	}
	/**
	 * @param lastDistrbDttm the lastDistrbDttm to set
	 */
	public void setLastDistrbDttm(String lastDistrbDttm) {
		this.lastDistrbDttm = lastDistrbDttm;
	}
	/**
	 * @return the lastDistrbVer
	 */
	public String getLastDistrbVer() {
		return lastDistrbVer;
	}
	/**
	 * @param lastDistrbVer the lastDistrbVer to set
	 */
	public void setLastDistrbVer(String lastDistrbVer) {
		this.lastDistrbVer = lastDistrbVer;
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
