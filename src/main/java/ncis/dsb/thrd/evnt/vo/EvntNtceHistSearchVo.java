/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * EvntNtceHistSearchVo.java
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

public class EvntNtceHistSearchVo extends CommonSearchVo {

	//대상서버구분코드
	private String trgtSrvrClCd;
	//임계등급
	private String thresGrdId;
	//내용
	private String cn;
	//통보상태코드
	private String dspthStatCd;
	//검색기간
	private String searchTrmCd;
	//시작일자
	private String strtDt;
	//종료일자
	private String endDt;

	private String regionId;
	private String zoneId;
	private String netId;
	private String   rsrcPoolId;
	private String UserId;

	@SuppressWarnings("unused")
	private boolean allRsrcPoolAuth;

	@SuppressWarnings("unused")
	private boolean allJobAuth;

	public String getTrgtSrvrClCd() {
		return trgtSrvrClCd;
	}
	public void setTrgtSrvrClCd(String trgtSrvrClCd) {
		this.trgtSrvrClCd = trgtSrvrClCd;
	}
	public String getThresGrdId() {
		return thresGrdId;
	}
	public void setThresGrdId(String thresGrdId) {
		this.thresGrdId = thresGrdId;
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
	public String getCn() {
		return cn;
	}
	public void setCn(String cn) {
		this.cn = cn;
	}
	public String getDspthStatCd() {
		return dspthStatCd;
	}
	public void setDspthStatCd(String dspthStatCd) {
		this.dspthStatCd = dspthStatCd;
	}
	public String getSearchTrmCd() {
		return searchTrmCd;
	}
	public void setSearchTrmCd(String searchTrmCd) {
		this.searchTrmCd = searchTrmCd;
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
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public boolean isAllRsrcPoolAuth() {
		return RequestUtils.isAllRsrcPoolAuth();
	}
	public boolean isAllJobAuth() {
		return RequestUtils.isAllJobAuth();
	}
}
