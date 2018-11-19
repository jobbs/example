/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmPatchSearchVo.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 11.
 * @lastmodified 2016. 10. 11.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 11.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.vo;

import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 이화영
 *
 */
public class VmPatchSearchVo extends CommonSearchVo {

	private String searchRegionId;
    private String searchZoneId;
    private String searchNetId;
    private String searchRsrcPoolId;
    private String searchStatCd;
    private String searchInstitutionNm;
    private String searchJobNm;
    private String searchVmNm;
    private String searchVmCompId;
    private String searchHstNm;
    private String searchRprsntIpAddr;
    private String searchOsTyCd;
    private String searchPackgNm;
    private String[] existsVrlzSwTyCdList;
    private boolean all = false;
    private String statGrpCdNm;
    private String statGrpCd;

	public String getSearchRegionId() {
		return searchRegionId;
	}
	public void setSearchRegionId(String searchRegionId) {
		this.searchRegionId = searchRegionId;
	}
	public String getSearchZoneId() {
		return searchZoneId;
	}
	public void setSearchZoneId(String searchZoneId) {
		this.searchZoneId = searchZoneId;
	}
	public String getSearchNetId() {
		return searchNetId;
	}
	public void setSearchNetId(String searchNetId) {
		this.searchNetId = searchNetId;
	}
	public String getSearchRsrcPoolId() {
		return searchRsrcPoolId;
	}
	public void setSearchRsrcPoolId(String searchRsrcPoolId) {
		this.searchRsrcPoolId = searchRsrcPoolId;
	}
	public String getSearchStatCd() {
		return searchStatCd;
	}
	public void setSearchStatCd(String searchStatCd) {
		this.searchStatCd = searchStatCd;
	}
	public String getSearchInstitutionNm() {
		return searchInstitutionNm;
	}
	public void setSearchInstitutionNm(String searchInstitutionNm) {
		this.searchInstitutionNm = searchInstitutionNm;
	}
	public String getSearchJobNm() {
		return searchJobNm;
	}
	public void setSearchJobNm(String searchJobNm) {
		this.searchJobNm = searchJobNm;
	}
	public String getSearchVmNm() {
		return searchVmNm;
	}
	public void setSearchVmNm(String searchVmNm) {
		this.searchVmNm = searchVmNm;
	}
	public String getSearchVmCompId() {
		return searchVmCompId;
	}
	public void setSearchVmCompId(String searchVmCompId) {
		this.searchVmCompId = searchVmCompId;
	}
	public String getSearchHstNm() {
		return searchHstNm;
	}
	public void setSearchHstNm(String searchHstNm) {
		this.searchHstNm = searchHstNm;
	}
	public String getSearchRprsntIpAddr() {
		return searchRprsntIpAddr;
	}
	public void setSearchRprsntIpAddr(String searchRprsntIpAddr) {
		this.searchRprsntIpAddr = searchRprsntIpAddr;
	}
	public String getSearchOsTyCd() {
		return searchOsTyCd;
	}
	public void setSearchOsTyCd(String searchOsTyCd) {
		this.searchOsTyCd = searchOsTyCd;
	}
	public String getSearchPackgNm() {
		return searchPackgNm;
	}
	public void setSearchPackgNm(String searchPackgNm) {
		this.searchPackgNm = searchPackgNm;
	}
	public String[] getExistsVrlzSwTyCdList() {
		return existsVrlzSwTyCdList;
	}
	public void setExistsVrlzSwTyCdList(String[] existsVrlzSwTyCdList) {
		this.existsVrlzSwTyCdList = existsVrlzSwTyCdList;
	}
	public boolean isAll() {
		return all;
	}
	public void setAll(boolean all) {
		this.all = all;
	}
	public String getStatGrpCdNm() {
		return statGrpCdNm;
	}
	public void setStatGrpCdNm(String statGrpCdNm) {
		this.statGrpCdNm = statGrpCdNm;
	}
	public String getStatGrpCd() {
		return statGrpCd;
	}
	public void setStatGrpCd(String statGrpCd) {
		this.statGrpCd = statGrpCd;
	}
	public boolean isSysadm() {
        return "SYSADM".equals(RequestUtils.getUser().getSuperposedUserRole());
    }
	public boolean isOpradm() {
        return "OPRADM".equals(RequestUtils.getUser().getSuperposedUserRole());
    }

	public String getUserId() {
        return RequestUtils.getUserId();
    }



}
