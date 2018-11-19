/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ClstrPrposSearchVo.java
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
import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 심원보
 *
 */
public class ClstrPrposSearchVo extends CommonSearchVo {

    private BigDecimal searchClstrSeq;

    private String searchPrposClCd;

    public BigDecimal getSearchClstrSeq() {
        return searchClstrSeq;
    }

    public void setSearchClstrSeq(BigDecimal searchClstrSeq) {
        this.searchClstrSeq = searchClstrSeq;
    }

    public String getSearchPrposClCd() {
        return searchPrposClCd;
    }

    public void setSearchPrposClCd(String searchPrposClCd) {
        this.searchPrposClCd = searchPrposClCd;
    }

}
