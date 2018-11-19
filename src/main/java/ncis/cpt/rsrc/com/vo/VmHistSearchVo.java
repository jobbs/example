/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmHistSearchVo.java
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 27.
 * @lastmodified 2016. 10. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 27.     최경철         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.vo;

import java.math.BigDecimal;
import ncis.cmn.vo.CommonSearchVo;
import ncis.cpt.rsrc.com.config.ComConstant;

/**
 * @author 최경철
 *
 */
public class VmHistSearchVo extends CommonSearchVo {

    private BigDecimal searchVmSeq;

    private String searchGrpCd = ComConstant.VM_REQ_GRP_CD;

    private String[] vmReqTyCdList;

    /**
     * @return the searchVmSeq
     */
    public BigDecimal getSearchVmSeq() {
        return searchVmSeq;
    }

    /**
     * @param searchVmSeq the searchVmSeq to set
     */
    public void setSearchVmSeq(BigDecimal searchVmSeq) {
        this.searchVmSeq = searchVmSeq;
    }

    /**
     * @return the vmReqTyCdList
     */
    public String[] getVmReqTyCdList() {
        return vmReqTyCdList;
    }

    /**
     * @param vmReqTyCdList the vmReqTyCdList to set
     */
    public void setVmReqTyCdList(String[] vmReqTyCdList) {
        this.vmReqTyCdList = vmReqTyCdList;
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

}
