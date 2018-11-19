/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcPoolSearchVo.java
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
package ncis.cpt.rsrc.pool.vo;

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 심원보
 *
 */
public class RsrcPoolSearchVo extends CommonSearchVo {

    private String searchRegionId;

    private String searchZoneId;

    private String searchNetId;

    private String searchNetClCd;

    private String searchPoolNm;

    private String searchPoolTypeCd;

    private String searchSwTypeCd;

    private String searchCtlTrgtYn;

    private boolean netVmSltAt;





	/**
	 * @return the netVmSltAt
	 */
	public boolean isNetVmSltAt() {
		return netVmSltAt;
	}

	/**
	 * @param netVmSltAt the netVmSltAt to set
	 */
	public void setNetVmSltAt(boolean netVmSltAt) {
		this.netVmSltAt = netVmSltAt;
	}

	/**
	 * @return the searchNetClCd
	 */
	public String getSearchNetClCd() {
		return searchNetClCd;
	}

	/**
	 * @param searchNetClCd the searchNetClCd to set
	 */
	public void setSearchNetClCd(String searchNetClCd) {
		this.searchNetClCd = searchNetClCd;
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

    public String getSearchPoolNm() {
        return searchPoolNm;
    }

    public void setSearchPoolNm(String searchPoolNm) {
        this.searchPoolNm = searchPoolNm;
    }

	/**
	 * @return the searchSwTypeCd
	 */
	public String getSearchSwTypeCd() {
		return searchSwTypeCd;
	}

	/**
	 * @param searchSwTypeCd the searchSwTypeCd to set
	 */
	public void setSearchSwTypeCd(String searchSwTypeCd) {
		this.searchSwTypeCd = searchSwTypeCd;
	}

	/**
	 * @return the searchPoolTypeCd
	 */
	public String getSearchPoolTypeCd() {
		return searchPoolTypeCd;
	}

	/**
	 * @param searchPoolTypeCd the searchPoolTypeCd to set
	 */
	public void setSearchPoolTypeCd(String searchPoolTypeCd) {
		this.searchPoolTypeCd = searchPoolTypeCd;
	}

	/**
	 * @return the searchCtlTrgtYn
	 */
	public String getSearchCtlTrgtYn() {
		return searchCtlTrgtYn;
	}

	/**
	 * @param searchCtlTrgtYn the searchCtlTrgtYn to set
	 */
	public void setSearchCtlTrgtYn(String searchCtlTrgtYn) {
		this.searchCtlTrgtYn = searchCtlTrgtYn;
	}



}
