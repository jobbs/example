/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CommonSearchVo.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.vo;

import ncis.cmn.util.PropertiesUtil;
import ncis.cmn.util.RequestUtils;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

public class CommonSearchVo {

    private PaginationInfo paginationInfo; // 페이지정보

    private String searchType;

    private String searchColumn;
    private String searchText;

    @SuppressWarnings("unused")
    private String searchUserId;

    private boolean byRole;

    public CommonSearchVo () {
        paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPageNo(1);
        paginationInfo.setPageSize(Integer.valueOf(PropertiesUtil.getProperty("PAGE_SIZE")));
        paginationInfo.setRecordCountPerPage(Integer.valueOf(PropertiesUtil.getProperty("RECORD_COUNT_PER_PAGE")));

        byRole = true;
    }

    /**
     * @return the paginationInfo
     */
    public PaginationInfo getPaginationInfo() {
        return paginationInfo;
    }

    /**
     * @param paginationInfo the paginationInfo to set
     */
    public void setPaginationInfo(PaginationInfo paginationInfo) {
        this.paginationInfo = paginationInfo;
    }

    public void setTotalRecordCount(int totalRecordCount){
        if(getPaginationInfo() != null){
            getPaginationInfo().setTotalRecordCount(totalRecordCount);
        }
    }

    /**
     * @return the searchColumn
     */
    public String getSearchColumn() {
        return searchColumn;
    }

    /**
     * @param searchColumn the searchColumn to set
     */
    public void setSearchColumn(String searchColumn) {
        this.searchColumn = searchColumn;
    }

    /**
     * @return the searchText
     */
    public String getSearchText() {
        return searchText;
    }

    /**
     * @param searchText the searchText to set
     */
    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    /**
     * @return the searchUserId
     */
    public String getSearchUserId() {
        String superposedRole = RequestUtils.getSuperposedUserRole();

        if( null != superposedRole && !"SYSADM".equals(superposedRole) ) {
            return RequestUtils.getUserId();
        }

        return null;
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

    public boolean isSysAdm() {
        return "SYSADM".equals(RequestUtils.getSuperposedUserRole());
    }

    public boolean isOprAdm() {
        return "OPRADM".equals(RequestUtils.getSuperposedUserRole());
    }

    public boolean isOprChr() {
        return "OPRCHR".equals(RequestUtils.getSuperposedUserRole());
    }
    public boolean isBldAdm() {
    	return "BLDADM".equals(RequestUtils.getSuperposedUserRole());
    }

	/**
	 * @return the byRole
	 */
	public boolean getByRole() {

		return byRole;
	}

	/**
	 * @param byRole the byRole to set
	 */
	public void setByRole(boolean byRole) {
		this.byRole = byRole;
	}

}
