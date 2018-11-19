/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SwSearchVo.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2017. 1. 16.
 * @lastmodified 2017. 1. 16.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 1. 16.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.vo;

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 이화영
 *
 */
public class SwSearchVo extends CommonSearchVo {

	 /**
     * 소프트웨어명
     */
    private String searchSwNm;

    /**
     * 소프트웨어 버전
     */
    private String searchSwVer;

    /**
     * 소프트웨어 제조사
     */
    private String searchSwMnfctCo;

	/**
	 * @return the searchSwNm
	 */
	public String getSearchSwNm() {
		return searchSwNm;
	}

	/**
	 * @param searchSwNm the searchSwNm to set
	 */
	public void setSearchSwNm(String searchSwNm) {
		this.searchSwNm = searchSwNm;
	}

	/**
	 * @return the searchSwVer
	 */
	public String getSearchSwVer() {
		return searchSwVer;
	}

	/**
	 * @param searchSwVer the searchSwVer to set
	 */
	public void setSearchSwVer(String searchSwVer) {
		this.searchSwVer = searchSwVer;
	}

	/**
	 * @return the searchSwMnfctCo
	 */
	public String getSearchSwMnfctCo() {
		return searchSwMnfctCo;
	}

	/**
	 * @param searchSwMnfctCo the searchSwMnfctCo to set
	 */
	public void setSearchSwMnfctCo(String searchSwMnfctCo) {
		this.searchSwMnfctCo = searchSwMnfctCo;
	}



}
