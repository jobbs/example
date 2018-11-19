/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename LunSearchVo.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 31.
 * @lastmodified 2016. 10. 31.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 31.     신재훈         v1.0             최초생성
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
public class LunSearchVo extends CommonSearchVo {
    private String searchClstrCompId; // 클러스터 구성ID
    private String searchClstrNm; // 클러스터명
    private String searchPmCompId; // 물리서버 구성ID
    private String searchPmNm; // 물리서버명

    private BigDecimal selectStrgDmnSeq; // 선택한 가상스토리지도메인SEQ

    public String getSearchClstrCompId() {
        return searchClstrCompId;
    }

    public void setSearchClstrCompId(String searchClstrCompId) {
        this.searchClstrCompId = searchClstrCompId;
    }

    public String getSearchClstrNm() {
        return searchClstrNm;
    }

    public void setSearchClstrNm(String searchClstrNm) {
        this.searchClstrNm = searchClstrNm;
    }

    public String getSearchPmCompId() {
        return searchPmCompId;
    }

    public void setSearchPmCompId(String searchPmCompId) {
        this.searchPmCompId = searchPmCompId;
    }

    public String getSearchPmNm() {
        return searchPmNm;
    }

    public void setSearchPmNm(String searchPmNm) {
        this.searchPmNm = searchPmNm;
    }

    public BigDecimal getSelectStrgDmnSeq() {
        return selectStrgDmnSeq;
    }

    public void setSelectStrgDmnSeq(BigDecimal selectStrgDmnSeq) {
        this.selectStrgDmnSeq = selectStrgDmnSeq;
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
        return "LunSearchVo [searchClstrCompId=" + searchClstrCompId + ", searchClstrNm=" + searchClstrNm + ", searchPmCompId=" + searchPmCompId + ", searchPmNm=" + searchPmNm + ", selectStrgDmnSeq=" + selectStrgDmnSeq + ", getSearchClstrCompId()=" + getSearchClstrCompId() + ", getSearchClstrNm()=" + getSearchClstrNm() + ", getSearchPmCompId()=" + getSearchPmCompId() + ", getSearchPmNm()=" + getSearchPmNm() + ", getSelectStrgDmnSeq()=" + getSelectStrgDmnSeq() + ", isSysadm()=" + isSysadm() + ", isOpradm()=" + isOpradm() + ", getUserId()=" + getUserId() + ", getPaginationInfo()=" + getPaginationInfo() + ", getSearchColumn()=" + getSearchColumn() + ", getSearchText()=" + getSearchText() + ", getSearchUserId()=" + getSearchUserId() + ", getSearchType()=" + getSearchType() + ", isSysAdm()=" + isSysAdm() + ", isOprAdm()=" + isOprAdm() + ", isOprChr()=" + isOprChr() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

}
