/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VrSwtchSearchVo.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 9.
 * @lastmodified 2016. 10. 9.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 9.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.vo;

import java.util.Arrays;
import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 신재훈
 *
 */
public class VrSwtchSearchVo extends CommonSearchVo {
    private String searchRegionId;
    private String searchNetClCd;

    private String regionId;
    private String netClCd;
    /** 2017-08-23 adding */
    private String rsrcPoolId;
    private String netwkNm;

    private String[] searchVrlzSwTyCdList;

    public String getSearchRegionId() {
        return searchRegionId;
    }

    public void setSearchRegionId(String searchRegionId) {
        this.searchRegionId = searchRegionId;
    }

    public String[] getSearchVrlzSwTyCdList() {
        if (null != this.searchVrlzSwTyCdList) {
            this.searchVrlzSwTyCdList = (searchVrlzSwTyCdList == null ? null : Arrays.copyOf(searchVrlzSwTyCdList, searchVrlzSwTyCdList.length));
            return this.searchVrlzSwTyCdList;
        }
        return null;
    }

    public void setSearchVrlzSwTyCdList(String[] searchVrlzSwTyCdList) {
        this.searchVrlzSwTyCdList = searchVrlzSwTyCdList == null ? null : Arrays.copyOf(searchVrlzSwTyCdList, searchVrlzSwTyCdList.length);
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getSearchNetClCd() {
        return searchNetClCd;
    }

    public void setSearchNetClCd(String searchNetClCd) {
        this.searchNetClCd = searchNetClCd;
    }

    public String getNetClCd() {
        return netClCd;
    }

    public void setNetClCd(String netClCd) {
        this.netClCd = netClCd;
    }

    @Override
    public String toString() {
        return "VrSwtchSearchVo [searchRegionId=" + searchRegionId + ", searchNetClCd=" + searchNetClCd + ", regionId=" + regionId + ", netClCd=" + netClCd + ", searchVrlzSwTyCdList=" + Arrays.toString(searchVrlzSwTyCdList) + "]";
    }

	/**
	 * @return the rsrcPoolId
	 */
	public String getRsrcPoolId() {
		return rsrcPoolId;
	}

	/**
	 * @param rsrcPoolId the rsrcPoolId to set
	 */
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}

	/**
	 * @return the netwkNm
	 */
	public String getNetwkNm() {
		return netwkNm;
	}

	/**
	 * @param netwkNm to set
	 */
	public void setNetwkNm(String netwkNm) {
		this.netwkNm = netwkNm;
	}

}
