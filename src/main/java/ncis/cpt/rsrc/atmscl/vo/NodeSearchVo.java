package ncis.cpt.rsrc.atmscl.vo;

import ncis.cmn.vo.CommonSearchVo;

public class NodeSearchVo extends CommonSearchVo {
	
    private String regionId; /* 리전ID */
    private String zoneId; /* 존ID */
    private String netClCd; /* 망구분코드 */
    private String rsrcPoolId; /* 자원풀ID */
    private String statCd; /* 부처명 */
    private String atmsclNodeNm; /* 노드명 */
    private Integer servcAreaSeq; /* 서비스영역Seq */
    private String atmsclNodeIpAddr;  /* 자동확장노드IP주소 */
    private String atmsclNodeTyCd; /* 노드유형코드 */
    
	/**
	 * @return the regionId
	 */
	public String getRegionId() {
		return regionId;
	}
	/**
	 * @param regionId the regionId to set
	 */
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	/**
	 * @return the zoneId
	 */
	public String getZoneId() {
		return zoneId;
	}
	/**
	 * @param zoneId the zoneId to set
	 */
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	/**
	 * @return the netClCd
	 */
	public String getNetClCd() {
		return netClCd;
	}
	/**
	 * @param netClCd the netClCd to set
	 */
	public void setNetClCd(String netClCd) {
		this.netClCd = netClCd;
	}
	/**
	 * @return the atmsclNodeNm
	 */
	public String getAtmsclNodeNm() {
		return atmsclNodeNm;
	}
	/**
	 * @param atmsclNodeNm the atmsclNodeNm to set
	 */
	public void setAtmsclNodeNm(String atmsclNodeNm) {
		this.atmsclNodeNm = atmsclNodeNm;
	}
	/**
	 * @return the rsrcPoolId
	 */
	public String getRsrcPoolId() {
		return rsrcPoolId;
	}
	/**
	 * @param rsrcPoolId the rsrcPoolId to set
	 */
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
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
	 * @return the atmsclNodeIpAddr
	 */
	public String getAtmsclNodeIpAddr() {
		return atmsclNodeIpAddr;
	}
	/**
	 * @param atmsclNodeIpAddr the atmsclNodeIpAddr to set
	 */
	public void setAtmsclNodeIpAddr(String atmsclNodeIpAddr) {
		this.atmsclNodeIpAddr = atmsclNodeIpAddr;
	}
	/**
	 * @return the atmsclNodeTyCd
	 */
	public String getAtmsclNodeTyCd() {
		return atmsclNodeTyCd;
	}
	/**
	 * @param atmsclNodeTyCd the atmsclNodeTyCd to set
	 */
	public void setAtmsclNodeTyCd(String atmsclNodeTyCd) {
		this.atmsclNodeTyCd = atmsclNodeTyCd;
	}
}
