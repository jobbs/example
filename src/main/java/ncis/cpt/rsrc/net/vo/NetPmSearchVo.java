/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetPmSearchVo.java
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 24.
 * @lastmodified 2016. 10. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 24.     최경철         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.net.vo;

import java.math.BigDecimal;
import java.util.Arrays;

import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 최경철
 *
 */
public class NetPmSearchVo extends CommonSearchVo {

	private String searchRegionId;

    private String searchZoneId;

    private String searchNetId;

    private String searchNetClCd;

    private String searchRsrcPoolId;

    private String searchStatCd;

    private String searchDelYn;

    private BigDecimal searchClstrSeq;

    private String searchPmNm;

    private String searchRprsntIpAddr;

    private String searchPmCompId;

    private BigDecimal searchNotPmSeq;

    private String[] searchVrlzSwTyCdList;

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

    public String getSearchDelYn() {
        return searchDelYn;
    }

    public void setSearchDelYn(String searchDelYn) {
        this.searchDelYn = searchDelYn;
    }

    public BigDecimal getSearchClstrSeq() {
        return searchClstrSeq;
    }

    public void setSearchClstrSeq(BigDecimal searchClstrSeq) {
        this.searchClstrSeq = searchClstrSeq;
    }

    public String getSearchPmNm() {
        return searchPmNm;
    }

    public void setSearchPmNm(String searchPmNm) {
        this.searchPmNm = searchPmNm;
    }

    public String getSearchRprsntIpAddr() {
        return searchRprsntIpAddr;
    }

    public void setSearchRprsntIpAddr(String searchRprsntIpAddr) {
        this.searchRprsntIpAddr = searchRprsntIpAddr;
    }

    public String getSearchPmCompId() {
        return searchPmCompId;
    }

    public void setSearchPmCompId(String searchPmCompId) {
        this.searchPmCompId = searchPmCompId;
    }

    public BigDecimal getSearchNotPmSeq() {
        return searchNotPmSeq;
    }

    public void setSearchNotPmSeq(BigDecimal searchNotPmSeq) {
        this.searchNotPmSeq = searchNotPmSeq;
    }

    public String[] getSearchVrlzSwTyCdList() {
        if (null != this.searchVrlzSwTyCdList) {
            this.searchVrlzSwTyCdList = (searchVrlzSwTyCdList == null ? null : Arrays.copyOf(searchVrlzSwTyCdList, searchVrlzSwTyCdList.length));
            return this.searchVrlzSwTyCdList;
        }
        return null;
    }

    public void setSearchVrlzSwTyCdList(String[] searchVrlzSwTyCdList) {
        this.searchVrlzSwTyCdList = (searchVrlzSwTyCdList == null ? null : Arrays.copyOf(searchVrlzSwTyCdList, searchVrlzSwTyCdList.length));
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
