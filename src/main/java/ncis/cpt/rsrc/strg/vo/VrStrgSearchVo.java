/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename vrStrgSearchVo.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 26.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.strg.vo;

import java.math.BigDecimal;
import java.util.Arrays;
import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 신재훈
 *
 */
public class VrStrgSearchVo extends CommonSearchVo {
    private String strgDmnTyNm;
    private String searchRegionId; // 센터
    private String searchZoneId; // 존
    private String searchNetId;
    private String searchNetClCd; // 망구분
    private String searchRsrcPoolId;
    private String searchVrStrgDmnNm;

    private String[] searchVrlzSwTyCdList;

    private BigDecimal searchStrgDmnSeq;

    private String searchPhyStrgId; /* 물리스토리지 ID */

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

    public String getSearchVrStrgDmnNm() {
        return searchVrStrgDmnNm;
    }

    public void setSearchVrStrgDmnNm(String searchVrStrgDmnNm) {
        this.searchVrStrgDmnNm = searchVrStrgDmnNm;
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

    @Override
    public String toString() {
        return "VrStrgSearchVo [searchRegionId=" + searchRegionId + ", searchZoneId=" + searchZoneId + ", searchNetId=" + searchNetId + ", searchRsrcPoolId=" + searchRsrcPoolId + ", searchVrStrgDmnNm=" + searchVrStrgDmnNm + ", searchVrlzSwTyCdList=" + Arrays.toString(searchVrlzSwTyCdList) + "]";
    }

    public String getStrgDmnTyNm() {
        return strgDmnTyNm;
    }

    public void setStrgDmnTyNm(String strgDmnTyNm) {
        this.strgDmnTyNm = strgDmnTyNm;
    }

    public BigDecimal getSearchStrgDmnSeq() {
        return searchStrgDmnSeq;
    }

    public void setSearchStrgDmnSeq(BigDecimal searchStrgDmnSeq) {
        this.searchStrgDmnSeq = searchStrgDmnSeq;
    }

    public String getSearchPhyStrgId() {
        return searchPhyStrgId;
    }

    public void setSearchPhyStrgId(String searchPhyStrgId) {
        this.searchPhyStrgId = searchPhyStrgId;
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
