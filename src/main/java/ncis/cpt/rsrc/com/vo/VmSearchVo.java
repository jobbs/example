/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmSearchVo.java
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
public class VmSearchVo extends CommonSearchVo {

    /**
     * -------------------------------
     * PREFIX 내용
     * -------------------------------
     * equals 일치
     * contains 부분일치
     * exists 존재
     * is 여부
     * -------------------------------
     */

    private String orderBy;

    private String equalsRegionId;

    private String equalsZoneId;

    private String equalsNetId;

    private String equalsRsrcPoolId;

    private String equalsStatCd;

    private String equalsStatGrpCd;

    private BigDecimal equalsClstrSeq;

    @Max(value = ComConstant.CLSTR_NM_MAX_LENGTH, groups = { SearchValidation.class })
    private String containsClstrNm;

    private BigDecimal equalsPmSeq;

    @Max(value = ComConstant.PM_NM_MAX_LENGTH, groups = { SearchValidation.class })
    private String containsPmNm;

    @Max(value = ComConstant.PM_COMP_ID_MAX_LENGTH, groups = { SearchValidation.class })
    private String containsPmCompId;

    @Max(value = ComConstant.VM_NM_MAX_LENGTH, groups = { SearchValidation.class })
    private String containsVmNm;

    @Max(value = ComConstant.VM_ID_MAX_LENGTH, groups = { SearchValidation.class })
    private String containsVmId;

    @Max(value = ComConstant.VM_COMP_ID_MAX_LENGTH, groups = { SearchValidation.class })
    private String containsVmCompId;

    @Max(value = ComConstant.HST_NM_MAX_LENGTH, groups = { SearchValidation.class })
    private String containsHstNm;

    @Max(value = ComConstant.IP_ADDR_MAX_LENGTH, groups = { SearchValidation.class })
    private String containsRprsntIpAddr;

    private String equalsOsTyCd;

    private String equalsInstitutionId;

    @Max(value = ComConstant.INSTITUTION_NM_MAX_LENGTH, groups = { SearchValidation.class })
    private String containsInstitutionNm;

    @Max(value = ComConstant.JOB_NM_MAX_LENGTH, groups = { SearchValidation.class })
    private String existsContainsJobNm;

    private String equalsJobId;

    private String[] existsVrlzSwTyCdList;

    private BigDecimal equalsVmSeq;

    private String equalsVmCompId;

    private String equalsDelYn;

    private String equalsVmClCd;

    private String equalsNetClCd;

    private String equalsRsrcPoolClCd;

    // 탭메뉴 이동 위해 추가
    private BigDecimal vmSeq;

    // 부처 ID
    private String InstitutionId;

    // 가상스토리지 상세 - 가상서버 조회를 위해 추가
    private BigDecimal searchStrgDmnSeq;

    // 관리대상 가상서버 상세 - 패키지 대상 여부
    private String searchPackgMngTrgtYn;

    // 컴퓨팅관리 > 가상서버과리 목록에서 network 관리의 가상서버 목록을 보여주기위해 검색 조건 추가
    private boolean netVmSltAt = false;

    private boolean all = false;

    // [팝업] IP수동할당 - 가상서버 선택에서 사용
    private String selectRegionId;
    private String selectNetClCd;

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

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public BigDecimal getVmSeq() {
        return vmSeq;
    }

    public void setVmSeq(BigDecimal vmSeq) {
        this.vmSeq = vmSeq;
    }

    public String getEqualsRegionId() {
        return equalsRegionId;
    }

    public void setEqualsRegionId(String equalsRegionId) {
        this.equalsRegionId = equalsRegionId;
    }

    public String getEqualsZoneId() {
        return equalsZoneId;
    }

    public void setEqualsZoneId(String equalsZoneId) {
        this.equalsZoneId = equalsZoneId;
    }

    public String getEqualsNetId() {
        return equalsNetId;
    }

    public void setEqualsNetId(String equalsNetId) {
        this.equalsNetId = equalsNetId;
    }

    public String getEqualsRsrcPoolId() {
        return equalsRsrcPoolId;
    }

    public void setEqualsRsrcPoolId(String equalsRsrcPoolId) {
        this.equalsRsrcPoolId = equalsRsrcPoolId;
    }

    public String getEqualsStatCd() {
        return equalsStatCd;
    }

    public void setEqualsStatCd(String equalsStatCd) {
        this.equalsStatCd = equalsStatCd;
    }

    public String getEqualsStatGrpCd() {
        return equalsStatGrpCd;
    }

    public void setEqualsStatGrpCd(String equalsStatGrpCd) {
        this.equalsStatGrpCd = equalsStatGrpCd;
    }

    public BigDecimal getEqualsClstrSeq() {
        return equalsClstrSeq;
    }

    public void setEqualsClstrSeq(BigDecimal equalsClstrSeq) {
        this.equalsClstrSeq = equalsClstrSeq;
    }

    public String getContainsClstrNm() {
        return containsClstrNm;
    }

    public void setContainsClstrNm(String containsClstrNm) {
        this.containsClstrNm = containsClstrNm;
    }

    public BigDecimal getEqualsPmSeq() {
        return equalsPmSeq;
    }

    public void setEqualsPmSeq(BigDecimal equalsPmSeq) {
        this.equalsPmSeq = equalsPmSeq;
    }

    public String getContainsPmNm() {
        return containsPmNm;
    }

    public void setContainsPmNm(String containsPmNm) {
        this.containsPmNm = containsPmNm;
    }

    public String getContainsPmCompId() {
        return containsPmCompId;
    }

    public void setContainsPmCompId(String containsPmCompId) {
        this.containsPmCompId = containsPmCompId;
    }

    public String getContainsVmNm() {
        return containsVmNm;
    }

    public void setContainsVmNm(String containsVmNm) {
        this.containsVmNm = containsVmNm;
    }

    public String getContainsVmId() {
        return containsVmId;
    }

    public void setContainsVmId(String containsVmId) {
        this.containsVmId = containsVmId;
    }

    public String getContainsVmCompId() {
        return containsVmCompId;
    }

    public void setContainsVmCompId(String containsVmCompId) {
        this.containsVmCompId = containsVmCompId;
    }

    public String getContainsHstNm() {
        return containsHstNm;
    }

    public void setContainsHstNm(String containsHstNm) {
        this.containsHstNm = containsHstNm;
    }

    public String getContainsRprsntIpAddr() {
        return containsRprsntIpAddr;
    }

    public void setContainsRprsntIpAddr(String containsRprsntIpAddr) {
        this.containsRprsntIpAddr = containsRprsntIpAddr;
    }

    public String getEqualsOsTyCd() {
        return equalsOsTyCd;
    }

    public void setEqualsOsTyCd(String equalsOsTyCd) {
        this.equalsOsTyCd = equalsOsTyCd;
    }

    public String getContainsInstitutionNm() {
        return containsInstitutionNm;
    }

    public void setContainsInstitutionNm(String containsInstitutionNm) {
        this.containsInstitutionNm = containsInstitutionNm;
    }

    public String getExistsContainsJobNm() {
        return existsContainsJobNm;
    }

    public void setExistsContainsJobNm(String existsContainsJobNm) {
        this.existsContainsJobNm = existsContainsJobNm;
    }

    public String getEqualsJobId() {
        return equalsJobId;
    }

    public void setEqualsJobId(String equalsJobId) {
        this.equalsJobId = equalsJobId;
    }

    public String[] getExistsVrlzSwTyCdList() {
        if (null != this.existsVrlzSwTyCdList) {
            this.existsVrlzSwTyCdList = (existsVrlzSwTyCdList == null ? null : Arrays.copyOf(existsVrlzSwTyCdList, existsVrlzSwTyCdList.length));
            return this.existsVrlzSwTyCdList;
        }
        return null;
    }

    public void setExistsVrlzSwTyCdList(String[] existsVrlzSwTyCdList) {
        this.existsVrlzSwTyCdList = (existsVrlzSwTyCdList == null ? null : Arrays.copyOf(existsVrlzSwTyCdList, existsVrlzSwTyCdList.length));
    }

    public BigDecimal getEqualsVmSeq() {
        return equalsVmSeq;
    }

    public void setEqualsVmSeq(BigDecimal equalsVmSeq) {
        this.equalsVmSeq = equalsVmSeq;
    }

    public String getEqualsVmCompId() {
        return equalsVmCompId;
    }

    public void setEqualsVmCompId(String equalsVmCompId) {
        this.equalsVmCompId = equalsVmCompId;
    }

    public String getEqualsDelYn() {
        return equalsDelYn;
    }

    public void setEqualsDelYn(String equalsDelYn) {
        this.equalsDelYn = equalsDelYn;
    }

    public String getEqualsVmClCd() {
        return equalsVmClCd;
    }

    public void setEqualsVmClCd(String equalsVmClCd) {
        this.equalsVmClCd = equalsVmClCd;
    }

    public String getInstitutionId() {
        return InstitutionId;
    }

    public void setInstitutionId(String institutionId) {
        InstitutionId = institutionId;
    }

    public String getEqualsInstitutionId() {
        return equalsInstitutionId;
    }

    public void setEqualsInstitutionId(String equalsInstitutionId) {
        this.equalsInstitutionId = equalsInstitutionId;
    }

    public String getSearchPackgMngTrgtYn() {
        return searchPackgMngTrgtYn;
    }

    public void setSearchPackgMngTrgtYn(String searchPackgMngTrgtYn) {
        this.searchPackgMngTrgtYn = searchPackgMngTrgtYn;
    }

    @Override
    public String toString() {
        return "VmSearchVo [equalsRegionId=" + equalsRegionId + ", equalsZoneId=" + equalsZoneId + ", equalsNetId=" + equalsNetId + ", equalsRsrcPoolId=" + equalsRsrcPoolId + ", equalsStatCd=" + equalsStatCd + ", equalsClstrSeq=" + equalsClstrSeq + ", containsClstrNm=" + containsClstrNm + ", equalsPmSeq=" + equalsPmSeq + ", containsPmNm=" + containsPmNm + ", containsPmCompId=" + containsPmCompId + ", containsVmNm=" + containsVmNm + ", containsVmId=" + containsVmId + ", containsVmCompId=" + containsVmCompId + ", containsHstNm=" + containsHstNm + ", containsRprsntIpAddr=" + containsRprsntIpAddr + ", equalsOsTyCd=" + equalsOsTyCd + ", containsInstitutionNm=" + containsInstitutionNm + ", existsContainsJobNm=" + existsContainsJobNm + ", equalsJobId=" + equalsJobId + ", existsVrlzSwTyCdList=" + Arrays.toString(existsVrlzSwTyCdList) + ", equalsVmSeq=" + equalsVmSeq + ", equalsVmCompId=" + equalsVmCompId + ", equalsDelYn=" + equalsDelYn + ", equalsVmClCd=" + equalsVmClCd + ", vmSeq=" + vmSeq + "]";
    }

    public BigDecimal getSearchStrgDmnSeq() {
        return searchStrgDmnSeq;
    }

    public void setSearchStrgDmnSeq(BigDecimal searchStrgDmnSeq) {
        this.searchStrgDmnSeq = searchStrgDmnSeq;
    }

    public boolean isAll() {
        return all;
    }

    public void setAll(boolean all) {
        this.all = all;
    }

    public String getEqualsNetClCd() {
        return equalsNetClCd;
    }

    public void setEqualsNetClCd(String equalsNetClCd) {
        this.equalsNetClCd = equalsNetClCd;
    }

    public String getSelectRegionId() {
        return selectRegionId;
    }

    public void setSelectRegionId(String selectRegionId) {
        this.selectRegionId = selectRegionId;
    }

    public String getEqualsRsrcPoolClCd() {
        return equalsRsrcPoolClCd;
    }

    public void setEqualsRsrcPoolClCd(String equalsRsrcPoolClCd) {
        this.equalsRsrcPoolClCd = equalsRsrcPoolClCd;
    }

    public String getSelectNetClCd() {
        return selectNetClCd;
    }

    public void setSelectNetClCd(String selectNetClCd) {
        this.selectNetClCd = selectNetClCd;
    }
}
