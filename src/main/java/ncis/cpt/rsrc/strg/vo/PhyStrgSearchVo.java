/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PStrgSearchVo.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 25.
 * @lastmodified 2016. 10. 25.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 25.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.strg.vo;

import ncis.cmn.vo.CommonSearchVo;

/**
 * 물리스토리지 공통 조회  Vo
 * @author 김봉민
 *
 */
public class PhyStrgSearchVo extends CommonSearchVo {

	private String rsrcPoolId; /*클러스트 ID */
	private String regionId; /* 리전ID */
	private String zoneId; /* 존ID */
	private String netId; /* 망ID */
	private String netClCd; /* 망구분코드 */
	private String[] vrlzSwTyCdList; /* 가상화SW유형코드 목록 */
	private String compId;		/* 구성ID */
	private String phyStrgId;	/* 물리스토리지 ID */
	private String phyStrgNm;	/* 물리스토리지명 */
	private String compClCd;	/* 구상 구분 코드  */
	private String srchPhyStrgId; 	/* 물리스토리지 ID */

	public String getRsrcPoolId() {
		return rsrcPoolId;
	}
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}
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
	public String getNetId() {
		return netId;
	}
	public void setNetId(String netId) {
		this.netId = netId;
	}
	public String[] getVrlzSwTyCdList() {
		return vrlzSwTyCdList;
	}
	public void setVrlzSwTyCdList(String[] vrlzSwTyCdList) {
		this.vrlzSwTyCdList = vrlzSwTyCdList;
	}
	public String getCompId() {
		return compId;
	}
	public void setCompId(String compId) {
		this.compId = compId;
	}
	public String getPhyStrgNm() {
		return phyStrgNm;
	}
	public void setPhyStrgNm(String phyStrgNm) {
		this.phyStrgNm = phyStrgNm;
	}
	public String getPhyStrgId() {
		return phyStrgId;
	}
	public void setPhyStrgId(String phyStrgId) {
		this.phyStrgId = phyStrgId;
	}
	public String getCompClCd() {
		return compClCd;
	}
	public void setCompClCd(String compClCd) {
		this.compClCd = compClCd;
	}
	public String getSrchPhyStrgId() {
		return srchPhyStrgId;
	}
	public void setSrchPhyStrgId(String srchPhyStrgId) {
		this.srchPhyStrgId = srchPhyStrgId;
	}
	public String getNetClCd() {
		return netClCd;
	}
	public void setNetClCd(String netClCd) {
		this.netClCd = netClCd;
	}
}
