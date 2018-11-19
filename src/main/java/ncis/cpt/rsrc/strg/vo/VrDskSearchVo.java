/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VrDskSearchVo.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 27.
 * @lastmodified 2016. 10. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 27.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.strg.vo;

import java.math.BigDecimal;
import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 신재훈
 *
 */
public class VrDskSearchVo extends CommonSearchVo {
    private BigDecimal searchVrStrgSeq; // 가상스토리지SEQ
    private BigDecimal searchVrDskSeq; // 가상디스크SEQ
    private BigDecimal searchVmSeq; // 가상서버SEQ

    public BigDecimal getSearchVrStrgSeq() {
        return searchVrStrgSeq;
    }

    public void setSearchVrStrgSeq(BigDecimal searchVrStrgSeq) {
        this.searchVrStrgSeq = searchVrStrgSeq;
    }

    public BigDecimal getSearchVrDskSeq() {
        return searchVrDskSeq;
    }

    public void setSearchVrDskSeq(BigDecimal searchVrDskSeq) {
        this.searchVrDskSeq = searchVrDskSeq;
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

    @Override
    public String toString() {
        return "VrDskSearchVo [searchVrStrgSeq=" + searchVrStrgSeq + ", searchVrDskSeq=" + searchVrDskSeq + ", getSearchVrStrgSeq()=" + getSearchVrStrgSeq() + ", getSearchVrDskSeq()=" + getSearchVrDskSeq() + ", getPaginationInfo()=" + getPaginationInfo() + ", getSearchColumn()=" + getSearchColumn() + ", getSearchText()=" + getSearchText() + ", getSearchUserId()=" + getSearchUserId() + ", getSearchType()=" + getSearchType() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

	public BigDecimal getSearchVmSeq() {
		return searchVmSeq;
	}

	public void setSearchVmSeq(BigDecimal searchVmSeq) {
		this.searchVmSeq = searchVmSeq;
	}

}
