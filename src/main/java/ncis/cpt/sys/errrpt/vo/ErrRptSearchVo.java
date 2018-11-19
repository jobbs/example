/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ErrRptSearchVo.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 31.
 * @lastmodified 2016. 10. 31.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 31.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.errrpt.vo;

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 최진호
 *
 */
public class ErrRptSearchVo extends CommonSearchVo {

    private String searchSbjct;

    private String searchContent;

    private String searchErrTyCd;

    private String searchErrCateCd;

    private String searchProcssStatCd;

    private String searchChargeNm;

    /**
     * @return the searchSbjct
     */
    public String getSearchSbjct() {
        return searchSbjct;
    }

    /**
     * @param searchSbjct the searchSbjct to set
     */
    public void setSearchSbjct(String searchSbjct) {
        this.searchSbjct = searchSbjct;
    }

    /**
     * @return the searchContent
     */
    public String getSearchContent() {
        return searchContent;
    }

    /**
     * @param searchContent the searchContent to set
     */
    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }

    /**
     * @return the searchErrTyCd
     */
    public String getSearchErrTyCd() {
        return searchErrTyCd;
    }

    /**
     * @param searchErrTyCd the searchErrTyCd to set
     */
    public void setSearchErrTyCd(String searchErrTyCd) {
        this.searchErrTyCd = searchErrTyCd;
    }

    /**
     * @return the searchErrCateCd
     */
    public String getSearchErrCateCd() {
        return searchErrCateCd;
    }

    /**
     * @param searchErrCateCd the searchErrCateCd to set
     */
    public void setSearchErrCateCd(String searchErrCateCd) {
        this.searchErrCateCd = searchErrCateCd;
    }

    /**
     * @return the searchProcssStatCd
     */
    public String getSearchProcssStatCd() {
        return searchProcssStatCd;
    }

    /**
     * @param searchProcssStatCd the searchProcssStatCd to set
     */
    public void setSearchProcssStatCd(String searchProcssStatCd) {
        this.searchProcssStatCd = searchProcssStatCd;
    }

    /**
     * @return the searchChargeId
     */
    public String getSearchChargeNm() {
        return searchChargeNm;
    }

    /**
     * @param searchChargeId the searchChargeId to set
     */
    public void setSearchChargeNm(String searchChargeNm) {
        this.searchChargeNm = searchChargeNm;
    }
}
