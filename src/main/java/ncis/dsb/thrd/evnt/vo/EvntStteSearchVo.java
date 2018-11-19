/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * EvntStteSearchVo.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   김동훈         v1.0             최초생성
 *
 */
package ncis.dsb.thrd.evnt.vo;

import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.CommonSearchVo;

public class EvntStteSearchVo extends CommonSearchVo {

	//등급
	private String thresGrdId;
	//대상
	private String trgtCd;
	//대상
	private String trgtNm;

	private String regionId;
	private String zoneId;
	private String netId;
	private String   rsrcPoolId;
	//내용
	private String cn;
	//검색기간
	private String searchTrmCd;
	//검색시작일자
	private String strtDt;
	//검색종료일자
	private String endDt;
	//이벤트이력
	private String evntHist;
	private String userId;

	@SuppressWarnings("unused")
	private boolean allRsrcPoolAuth;

	@SuppressWarnings("unused")
	private boolean allJobAuth;

	public boolean isAllRsrcPoolAuth() {
		return RequestUtils.isAllRsrcPoolAuth();
	}
	public boolean isAllJobAuth() {
		return RequestUtils.isAllJobAuth();
	}

	public String getTrgtCd() {
		return trgtCd;
	}
	public void setTrgtCd(String trgtCd) {
		this.trgtCd = trgtCd;
	}
	public String getTrgtNm() {
		return trgtNm;
	}
	public void setTrgtNm(String trgtNm) {
		this.trgtNm = trgtNm;
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
	public String getRsrcPoolId() {
		return rsrcPoolId;
	}
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}
	public String getCn() {
		return cn;
	}
	public void setCn(String cn) {
		this.cn = cn;
	}
	public String getSearchTrmCd() {
		return searchTrmCd;
	}
	public void setSearchTrmCd(String searchTrmCd) {
		this.searchTrmCd = searchTrmCd;
	}
	public String getStrtDt() {
		return strtDt;
	}
	public void setStrtDt(String strtDt) {
		this.strtDt = strtDt;
	}
	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	public String getEvntHist() {
		return evntHist;
	}
	public void setEvntHist(String evntHist) {
		this.evntHist = evntHist;
	}
	public String getThresGrdId() {
		return thresGrdId;
	}
	public void setThresGrdId(String thresGrdId) {
		this.thresGrdId = thresGrdId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}


}
