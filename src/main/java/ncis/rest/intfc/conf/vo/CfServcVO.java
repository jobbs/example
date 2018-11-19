package ncis.rest.intfc.conf.vo;

import java.util.List;


/**
 * @author LeeJiHun
 *
 */
public class CfServcVO {

	private Integer servcSeq; /* 서비스SEQ */
	private Integer servcAreaSeq; /* 서비스영역SEQ */
	private String servcId; /* 서비스ID */
	private String servcNm; /* 서비스명 */
	private String servcUid; /* 서비스UID */
	private String rmk; /* 비고 */
	private Double reqCpuCorQty;  /* 요청CPU코어수 */
	private Double reqMemCapa;  /* 요청메모리용량 */
	private Double lmttCpuCorQty;  /* 제한CPU코어수 */
	private Double lmttMemCapa;  /* 제한메모리용량 */
	private String basImgId; /* 베이스이미지ID */
	private String gitAddr; /* Git주소 */
	private List<CfRuteVO> hstInfos; /* 네트워크인터페이스 정보 */
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
	 * @return the reqCpuCorQty
	 */
	public Double getReqCpuCorQty() {
	    return reqCpuCorQty;
	}
	/**
	 * @param reqCpuCorQty the reqCpuCorQty to set
	 */
	public void setReqCpuCorQty(Double reqCpuCorQty) {
	    this.reqCpuCorQty = reqCpuCorQty;
	}
	/**
	 * @return the reqMemCapa
	 */
	public Double getReqMemCapa() {
	    return reqMemCapa;
	}
	/**
	 * @param reqMemCapa the reqMemCapa to set
	 */
	public void setReqMemCapa(Double reqMemCapa) {
	    this.reqMemCapa = reqMemCapa;
	}
	/**
	 * @return the lmttCpuCorQty
	 */
	public Double getLmttCpuCorQty() {
	    return lmttCpuCorQty;
	}
	/**
	 * @param lmttCpuCorQty the lmttCpuCorQty to set
	 */
	public void setLmttCpuCorQty(Double lmttCpuCorQty) {
	    this.lmttCpuCorQty = lmttCpuCorQty;
	}
	/**
	 * @return the lmttMemCapa
	 */
	public Double getLmttMemCapa() {
	    return lmttMemCapa;
	}
	/**
	 * @param lmttMemCapa the lmttMemCapa to set
	 */
	public void setLmttMemCapa(Double lmttMemCapa) {
	    this.lmttMemCapa = lmttMemCapa;
	}
	/**
	 * @return the basImgId
	 */
	public String getBasImgId() {
	    return basImgId;
	}
	/**
	 * @param basImgId the basImgId to set
	 */
	public void setBasImgId(String basImgId) {
	    this.basImgId = basImgId;
	}
	/**
	 * @return the gitAddr
	 */
	public String getGitAddr() {
	    return gitAddr;
	}
	/**
	 * @param gitAddr the gitAddr to set
	 */
	public void setGitAddr(String gitAddr) {
	    this.gitAddr = gitAddr;
	}

	public List<CfRuteVO> getHstInfos() {
		return hstInfos;
	}
	public void setHstInfos(List<CfRuteVO> hstInfos) {
		this.hstInfos = hstInfos;
	}

}
