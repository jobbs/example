package ncis.cpt.rsrc.atmscl.vo;

import ncis.cmn.entity.RxServcSclng;

public class ServcSclngVo extends RxServcSclng {

    private String scalrId;  /* 스케일러ID */
    private String sclGrpCd;  /* 스케일그룹코드 */
    private String sclGrpNm;  /* 스케일그룹명 */
    private String thresClCd;  /* 임계치구분코드 */
    private String strtThresVl;  /* 시작임계치값 */
    private String endThresVl;  /* 종료임계치값 */
    private String sclngClNm; /* 스케일구분코드명 */
    private Integer nowPodQty; /* 현제Pod수 */
    private Integer minPodQty; /* 최소Pod수 */
    private Integer maxPodQty; /* 최대Pod수 */
    private String thresClNm;  /* 임계치구분명 */


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
	 * @return the sclGrpCd
	 */
	public String getSclGrpCd() {
		return sclGrpCd;
	}
	/**
	 * @param sclGrpCd the sclGrpCd to set
	 */
	public void setSclGrpCd(String sclGrpCd) {
		this.sclGrpCd = sclGrpCd;
	}
	/**
	 * @return the thresClCd
	 */
	public String getThresClCd() {
		return thresClCd;
	}
	/**
	 * @param thresClCd the thresClCd to set
	 */
	public void setThresClCd(String thresClCd) {
		this.thresClCd = thresClCd;
	}
	/**
	 * @return the strtThresVl
	 */
	public String getStrtThresVl() {
		return strtThresVl;
	}
	/**
	 * @param strtThresVl the strtThresVl to set
	 */
	public void setStrtThresVl(String strtThresVl) {
		this.strtThresVl = strtThresVl;
	}
	/**
	 * @return the endThresVl
	 */
	public String getEndThresVl() {
		return endThresVl;
	}
	/**
	 * @param endThresVl the endThresVl to set
	 */
	public void setEndThresVl(String endThresVl) {
		this.endThresVl = endThresVl;
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
	 * @return the thresClNm
	 */
	public String getThresClNm() {
		return thresClNm;
	}
	/**
	 * @param thresClNm the thresClNm to set
	 */
	public void setThresClNm(String thresClNm) {
		this.thresClNm = thresClNm;
	}
	/**
	 * @return the sclGrpNm
	 */
	public String getSclGrpNm() {
		return sclGrpNm;
	}
	/**
	 * @param sclGrpNm the sclGrpNm to set
	 */
	public void setSclGrpNm(String sclGrpNm) {
		this.sclGrpNm = sclGrpNm;
	}

}

