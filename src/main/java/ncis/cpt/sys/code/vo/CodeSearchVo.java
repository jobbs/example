/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CodeSearchVo.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 29.
 * @lastmodified 2016. 9. 29.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 29.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.code.vo;

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 최진호
 *
 */
public class CodeSearchVo extends CommonSearchVo {

    private String searchType;

    private String searchParentGrpCd;

    private String searchParentCd;

    private String searchCd;

    private String searchGrpCd;

    private String searchCdNm;

    private String searchUseYn;

    private boolean searchWhole;

    private String searchExtra1;

    private String searchExtra2;

    private String searchExtra3;

    private String searchExtra4;

    private String searchExtra5;

    /**
     * @return the searchParentGrpCd
     */
    public String getSearchParentGrpCd() {
        return searchParentGrpCd;
    }

    /**
     * @param searchParentGrpCd the searchParentGrpCd to set
     */
    public void setSearchParentGrpCd(String searchParentGrpCd) {
        this.searchParentGrpCd = searchParentGrpCd;
    }

    /**
     * @return the searchParentCd
     */
    public String getSearchParentCd() {
        return searchParentCd;
    }

    /**
     * @param searchParentCd the searchParentCd to set
     */
    public void setSearchParentCd(String searchParentCd) {
        this.searchParentCd = searchParentCd;
    }

    /**
     * @return the searchCd
     */
    public String getSearchCd() {
        return searchCd;
    }

    /**
     * @param searchCd the searchCd to set
     */
    public void setSearchCd(String searchCd) {
        this.searchCd = searchCd;
    }

    /**
     * @return the searchGrpCd
     */
    public String getSearchGrpCd() {
        return searchGrpCd;
    }

    /**
     * @param searchGrpCd the searchGrpCd to set
     */
    public void setSearchGrpCd(String searchGrpCd) {
        this.searchGrpCd = searchGrpCd;
    }

    /**
     * @return the searchCdNm
     */
    public String getSearchCdNm() {
        return searchCdNm;
    }

    /**
     * @param searchCdNm the searchCdNm to set
     */
    public void setSearchCdNm(String searchCdNm) {
        this.searchCdNm = searchCdNm;
    }

    /**
     * @return the searchWhole
     */
    public boolean getSearchWhole() {
        return searchWhole;
    }

    /**
     * @param searchWhole the searchWhole to set
     */
    public void setSearchWhole(boolean searchWhole) {
        this.searchWhole = searchWhole;
    }

    /**
     * @return the searchExtra1
     */
    public String getSearchExtra1() {
        return searchExtra1;
    }

    /**
     * @param searchExtra1 the searchExtra1 to set
     */
    public void setSearchExtra1(String searchExtra1) {
        this.searchExtra1 = searchExtra1;
    }

    /**
     * @return the searchExtra2
     */
    public String getSearchExtra2() {
        return searchExtra2;
    }

    /**
     * @param searchExtra2 the searchExtra2 to set
     */
    public void setSearchExtra2(String searchExtra2) {
        this.searchExtra2 = searchExtra2;
    }

    /**
     * @return the searchExtra3
     */
    public String getSearchExtra3() {
        return searchExtra3;
    }

    /**
     * @param searchExtra3 the searchExtra3 to set
     */
    public void setSearchExtra3(String searchExtra3) {
        this.searchExtra3 = searchExtra3;
    }

    /**
     * @return the searchExtra4
     */
    public String getSearchExtra4() {
        return searchExtra4;
    }

    /**
     * @param searchExtra4 the searchExtra4 to set
     */
    public void setSearchExtra4(String searchExtra4) {
        this.searchExtra4 = searchExtra4;
    }

    /**
     * @return the searchExtra5
     */
    public String getSearchExtra5() {
        return searchExtra5;
    }

    /**
     * @param searchExtra5 the searchExtra5 to set
     */
    public void setSearchExtra5(String searchExtra5) {
        this.searchExtra5 = searchExtra5;
    }

    /**
     * @return the searchUseYn
     */
    public String getSearchUseYn() {
        return searchUseYn;
    }

    /**
     * @param searchUseYn the searchUseYn to set
     */
    public void setSearchUseYn(String searchUseYn) {
        this.searchUseYn = searchUseYn;
    }

    /**
     * @return the searchType
     */
    public String getSearchType() {
        return searchType;
    }

    /**
     * @param searchType the searchType to set
     */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

}
