/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PmSearchVo.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     심원보         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.vo;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.validation.constraints.Max;

import ncis.cmn.vo.CommonSearchVo;
import ncis.cpt.rsrc.com.config.ComConstant;
import ncis.cpt.rsrc.com.validation.SearchValidation;

/**
 * @author 심원보
 *
 */
public class PmSearchVo extends CommonSearchVo {

    private String orderBy;

    private String searchRegionId;

    private String searchZoneId;

    private String searchNetId;

    private String searchNetClCd;

    private String searchRsrcPoolId;

    private String searchStatCd;

    private String searchDelYn;

    private BigDecimal searchClstrSeq;

    @Max(value = ComConstant.CLSTR_NM_MAX_LENGTH, groups = { SearchValidation.class })
    private String containsClstrNm;

    private String searchPmNm;

    private String searchPmId;

    private String searchRprsntIpAddr;

    private String searchPmCompId;

    private BigDecimal searchNotPmSeq;

    private String[] searchVrlzSwTyCdList;

    private String searchVrCnvrSwTyCd;

    private String searchClstrNm;

    // 컴퓨팅관리 > 물리서버관리 목록에서 network 관리의 물리서버 목록을 보여주기위해 검색 조건 추가
    private boolean netPmSltAt = false;

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
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

    /**
	 * @return the containsClstrNm
	 */
	public String getContainsClstrNm()
	{
		return containsClstrNm;
	}

	/**
	 * @param containsClstrNm the containsClstrNm to set
	 */
	public void setContainsClstrNm(String containsClstrNm)
	{
		this.containsClstrNm = containsClstrNm;
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

    /**
	 * @return the searchPmId
	 */
	public String getSearchPmId()
	{
		return searchPmId;
	}

	/**
	 * @param searchPmId the searchPmId to set
	 */
	public void setSearchPmId(String searchPmId)
	{
		this.searchPmId = searchPmId;
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

    public String getSearchVrCnvrSwTyCd() {
        return searchVrCnvrSwTyCd;
    }

    public void setSearchVrCnvrSwTyCd(String searchVrCnvrSwTyCd) {
        this.searchVrCnvrSwTyCd = searchVrCnvrSwTyCd;
    }

	public String getSearchNetClCd() {
		return searchNetClCd;
	}

	public void setSearchNetClCd(String searchNetClCd) {
		this.searchNetClCd = searchNetClCd;
	}

	public boolean isNetPmSltAt() {
		return netPmSltAt;
	}

	public void setNetPmSltAt(boolean netPmSltAt) {
		this.netPmSltAt = netPmSltAt;
	}

	public String getSearchClstrNm() {
		return searchClstrNm;
	}

	public void setSearchClstrNm(String searchClstrNm) {
		this.searchClstrNm = searchClstrNm;
	}

}
