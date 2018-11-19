/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * JobRsrcStteSearchVo.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   양정순         v1.0             최초생성
 */

package ncis.dsb.stts.rsrcuse.vo;

import ncis.cmn.vo.CommonSearchVo;

public class JobRsrcStteSearchVo extends CommonSearchVo {

	   private String institutionId;
	   private String institutionNm;
	   private String search;
	/**
	 * @return the institution_id
	 */
	public String getInstitutionId() {
		return institutionId;
	}
	/**
	 * @param institution_id the institution_id to set
	 */
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}

	/**
	 * @return the institution_id
	 */
	public String getInstitutionNm() {
		return institutionNm;
	}
	/**
	 * @param institution_id the institution_id to set
	 */
	public void setInstitutionNm(String institutionNm) {
		this.institutionNm = institutionNm;
	}
	/**
	 * @return the search
	 */
	public String getSearch() {
		return search;
	}
	/**
	 * @param search the search to set
	 */
	public void setSearch(String search) {
		this.search = search;
	}



}

