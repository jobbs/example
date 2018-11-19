/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * EvntStteSearchVo.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 10. 10
 * @lastmodified2017. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 10. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.thrd.evnt.vo;

import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.CommonSearchVo;

public class AxEvntStteSearchVo extends CommonSearchVo {

	private String regionId;
	private String zoneId;
	private String netId;
	private String rsrcPoolId;
	//내용
	private String cn;
	//검색기간
	private String searchTrmCd;
	//검색시작일자
	private String strtDt;
	//검색종료일자
	private String endDt;
	//발생유형
	private String evntOccrReasn;
	//발생대상
	private String occrObjectId;
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
	public String getEvntOccrReasn() {
		return evntOccrReasn;
	}
	public void setEvntOccrReasn(String evntOccrReasn) {
		this.evntOccrReasn = evntOccrReasn;
	}
	public String getOccrObjectId() {
		return occrObjectId;
	}
	public void setOccrObjectId(String occrObjectId) {
		this.occrObjectId = occrObjectId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}


}
