/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PackgAlrmSearchVo.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 26.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.vo;

import java.util.List;

import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 이화영
 *
 */
public class PackgAlrmSearchVo extends CommonSearchVo {

	private String searchConfrmYn;
	private String searchInstitutionNm;
	private String searchJobNm;
	private String searchVmNm;
	private String searchRegionId;
	private String searchZoneId;
	private String searchNetClCd;
	private String searchRsrcPoolId;
	private String searchVmCompId;
	private String searchHstNm;
	private String searchRprsntIpAddr;
	private String[] searchVrlzSwTyCdList;

	private List<Integer> checkAlrm;
	private List<Integer> packgAlrmList;
	private List<Integer> packgAlrmList1;
	private List<String> packgAlrmList2;

	public String getSearchConfrmYn() {
		return searchConfrmYn;
	}
	public void setSearchConfrmYn(String searchConfrmYn) {
		this.searchConfrmYn = searchConfrmYn;
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
	public String getSearchRsrcPoolId() {
		return searchRsrcPoolId;
	}
	public void setSearchRsrcPoolId(String searchRsrcPoolId) {
		this.searchRsrcPoolId = searchRsrcPoolId;
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
	public String[] getSearchVrlzSwTyCdList() {
		return searchVrlzSwTyCdList;
	}
	public void setSearchVrlzSwTyCdList(String[] searchVrlzSwTyCdList) {
		this.searchVrlzSwTyCdList = searchVrlzSwTyCdList;
	}
	public List<Integer> getCheckAlrm() {
		return checkAlrm;
	}
	public void setCheckAlrm(List<Integer> checkAlrm) {
		this.checkAlrm = checkAlrm;
	}
	public List<Integer> getPackgAlrmList() {
		return packgAlrmList;
	}
	public void setPackgAlrmList(List<Integer> packgAlrmList) {
		this.packgAlrmList = packgAlrmList;
	}
	public List<Integer> getPackgAlrmList1() {
		return packgAlrmList1;
	}
	public void setPackgAlrmList1(List<Integer> packgAlrmList1) {
		this.packgAlrmList1 = packgAlrmList1;
	}
	public List<String> getPackgAlrmList2() {
		return packgAlrmList2;
	}
	public void setPackgAlrmList2(List<String> packgAlrmList2) {
		this.packgAlrmList2 = packgAlrmList2;
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
	public String getSearchNetClCd() {
		return searchNetClCd;
	}
	public void setSearchNetClCd(String searchNetClCd) {
		this.searchNetClCd = searchNetClCd;
	}




}
