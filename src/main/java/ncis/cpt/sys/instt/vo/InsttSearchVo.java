/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename DepartSearchVo.java
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     최경철         v1.0             최초생성
 *
 */
package ncis.cpt.sys.instt.vo;

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 최경철
 *
 */
public class InsttSearchVo extends CommonSearchVo {

	private String searchUseYn;

	private String searchInttId;

	private String searchInttNm;

	private String searchRegionId;

	private String type;
	
	private String searchOnnara;

	/**
	 * @return the searchInttNm
	 */
	public String getSearchInttNm() {
		return searchInttNm;
	}

	/**
	 * @param searchInttNm
	 *            the searchInttNm to set
	 */
	public void setSearchInttNm(String searchInttNm) {
		this.searchInttNm = searchInttNm;
	}

	/**
	 * @return the searchRegionId
	 */
	public String getSearchRegionId() {
		return searchRegionId;
	}

	/**
	 * @param searchRegionId
	 *            the searchRegionId to set
	 */
	public void setSearchRegionId(String searchRegionId) {
		this.searchRegionId = searchRegionId;
	}

	/**
	 * @return the searchUseYn
	 */
	public String getSearchUseYn() {
		return searchUseYn;
	}

	/**
	 * @param searchUseYn
	 *            the searchUseYn to set
	 */
	public void setSearchUseYn(String searchUseYn) {
		this.searchUseYn = searchUseYn;
	}

	/**
	 * @return the searchInttId
	 */
	public String getSearchInttId() {
		return searchInttId;
	}

	/**
	 * @param searchInttId
	 *            the searchInttId to set
	 */
	public void setSearchInttId(String searchInttId) {
		this.searchInttId = searchInttId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the searchOnnara
	 */
	public String getSearchOnnara() {
		return searchOnnara;
	}

	/**
	 * @param searchOnnara
	 *            the searchOnnara to set
	 */
	public void setSearchOnnara(String searchOnnara) {
		this.searchOnnara = searchOnnara;
	}
}
