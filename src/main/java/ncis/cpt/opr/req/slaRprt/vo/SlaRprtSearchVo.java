/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SlaRprtSearchVo.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.req.slaRprt.vo;

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 이화영
 *
 */
public class SlaRprtSearchVo extends CommonSearchVo {
	private String searchRegion;
	private String institutionNm;
	private String institutionId;
	private String searchrSrcReqTyCd;
	private String searchStartRegDt;
	private String searchEndRegDt;
	private String searchTime;
	private String rsrcReqTyCd;
	private String searchrSrcReqClCd;

	public String getSearchRegion() {
		return searchRegion;
	}
	public void setSearchRegion(String searchRegion) {
		this.searchRegion = searchRegion;
	}
	public String getSearchrSrcReqTyCd() {
		return searchrSrcReqTyCd;
	}
	public void setSearchrSrcReqTyCd(String searchrSrcReqTyCd) {
		this.searchrSrcReqTyCd = searchrSrcReqTyCd;
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
	public String getSearchTime() {
		return searchTime;
	}
	public void setSearchTime(String searchTime) {
		this.searchTime = searchTime;
	}
	public String getRsrcReqTyCd() {
		return rsrcReqTyCd;
	}
	public void setRsrcReqTyCd(String rsrcReqTyCd) {
		this.rsrcReqTyCd = rsrcReqTyCd;
	}
	public String getInstitutionNm() {
		return institutionNm;
	}
	public void setInstitutionNm(String institutionNm) {
		this.institutionNm = institutionNm;
	}
	public String getInstitutionId() {
		return institutionId;
	}
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
	public String getSearchrSrcReqClCd() {
		return searchrSrcReqClCd;
	}
	public void setSearchrSrcReqClCd(String searchrSrcReqClCd) {
		this.searchrSrcReqClCd = searchrSrcReqClCd;
	}
}
