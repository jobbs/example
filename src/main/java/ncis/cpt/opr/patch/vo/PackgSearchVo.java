/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PackgSearchVo.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.vo;

import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 이화영
 *
 */
public class PackgSearchVo extends CommonSearchVo {

	private String searchRegionId;
	private String searchNetClCd;
	private String searchRepositId;
	private String searchStartRegDt;
	private String searchEndRegDt;
	private String searchPackgNm;
	private String searchVer;
	private String searchPackgCn;
	private String packgSeq;
	private String searchType;
	private String verPackgNm;

	public String getSearchRegionId() {
		return searchRegionId;
	}
	public void setSearchRegionId(String searchRegionId) {
		this.searchRegionId = searchRegionId;
	}
	public String getSearchRepositId() {
		return searchRepositId;
	}
	public void setSearchRepositId(String searchRepositId) {
		this.searchRepositId = searchRepositId;
	}
	public String getSearchStartRegDt() {
		return searchStartRegDt;
	}
	public void setSearchStartRegDt(String searchStartRegDt) {
		this.searchStartRegDt = searchStartRegDt;
	}
	public String getSearchEndRegDt() {
		return searchEndRegDt;
	}
	public void setSearchEndRegDt(String searchEndRegDt) {
		this.searchEndRegDt = searchEndRegDt;
	}
	public String getSearchPackgNm() {
		return searchPackgNm;
	}
	public void setSearchPackgNm(String searchPackgNm) {
		this.searchPackgNm = searchPackgNm;
	}
	public String getSearchVer() {
		return searchVer;
	}
	public void setSearchVer(String searchVer) {
		this.searchVer = searchVer;
	}
	public String getSearchPackgCn() {
		return searchPackgCn;
	}
	public void setSearchPackgCn(String searchPackgCn) {
		this.searchPackgCn = searchPackgCn;
	}
	public String getPackgSeq() {
		return packgSeq;
	}
	public void setPackgSeq(String packgSeq) {
		this.packgSeq = packgSeq;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getVerPackgNm() {
		return verPackgNm;
	}
	public void setVerPackgNm(String verPackgNm) {
		this.verPackgNm = verPackgNm;
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
