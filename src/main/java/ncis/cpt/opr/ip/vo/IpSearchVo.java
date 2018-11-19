/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename IpSearchVo.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.vo;

import java.math.BigDecimal;
import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 김봉민
 *
 */
public class IpSearchVo extends CommonSearchVo {
    private String ipAddr; // IP주소
    private String ipStatCd; // IP상태코드
    private BigDecimal bndSeq; // 대역
    private String natYn; /* NAT 여부 */

    // IP현황목록 Component
    private String searchRegion; // 센터
    private String searchNet; // 망
    private String searchStartAsgnDt; // 할당 시작일자
    private String searchEndAsgnDt; // 할당 종료일자
    private String searchStartWithdrawDt; // 회수 시작일자
    private String searchEndWithdrawDt; // 회수 종료일자
    private String searchIpAddr; // IP주소
    private String searchVmCompId; // 가상서버구성ID
    private String searchInstitutionNm; // 사용부처
    private String searchIpBndNm; // IP대역명
    private String searchMacAddr; // MAC주소
    private String searchVmNm; // 가상서버명

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getIpStatCd() {
        return ipStatCd;
    }

    public void setIpStatCd(String ipStatCd) {
        this.ipStatCd = ipStatCd;
    }

    public BigDecimal getBndSeq() {
        return bndSeq;
    }

    public void setBndSeq(BigDecimal bndSeq) {
        this.bndSeq = bndSeq;
    }

    public String getSearchNet() {
        return searchNet;
    }

    public void setSearchNet(String searchNet) {
        this.searchNet = searchNet;
    }

    public String getSearchIpAddr() {
        return searchIpAddr;
    }

    public void setSearchIpAddr(String searchIpAddr) {
        this.searchIpAddr = searchIpAddr;
    }

    public String getSearchVmCompId() {
        return searchVmCompId;
    }

    public void setSearchVmCompId(String searchVmCompId) {
        this.searchVmCompId = searchVmCompId;
    }

    public String getSearchInstitutionNm() {
        return searchInstitutionNm;
    }

    public void setSearchInstitutionNm(String searchInstitutionNm) {
        this.searchInstitutionNm = searchInstitutionNm;
    }

    public String getSearchIpBndNm() {
        return searchIpBndNm;
    }

    public void setSearchIpBndNm(String searchIpBndNm) {
        this.searchIpBndNm = searchIpBndNm;
    }

    public String getSearchMacAddr() {
        return searchMacAddr;
    }

    public void setSearchMacAddr(String searchMacAddr) {
        this.searchMacAddr = searchMacAddr;
    }

    public String getSearchVmNm() {
        return searchVmNm;
    }

    public void setSearchVmNm(String searchVmNm) {
        this.searchVmNm = searchVmNm;
    }

    public String getSearchStartAsgnDt() {
        return searchStartAsgnDt;
    }

    public void setSearchStartAsgnDt(String searchStartAsgnDt) {
        this.searchStartAsgnDt = searchStartAsgnDt;
    }

    public String getSearchEndAsgnDt() {
        return searchEndAsgnDt;
    }

    public void setSearchEndAsgnDt(String searchEndAsgnDt) {
        this.searchEndAsgnDt = searchEndAsgnDt;
    }

    public String getSearchStartWithdrawDt() {
        return searchStartWithdrawDt;
    }

    public void setSearchStartWithdrawDt(String searchStartWithdrawDt) {
        this.searchStartWithdrawDt = searchStartWithdrawDt;
    }

    public String getSearchEndWithdrawDt() {
        return searchEndWithdrawDt;
    }

    public void setSearchEndWithdrawDt(String searchEndWithdrawDt) {
        this.searchEndWithdrawDt = searchEndWithdrawDt;
    }

    public String getNatYn() {
        return natYn;
    }

    public void setNatYn(String natYn) {
        this.natYn = natYn;
    }

    public String getSearchRegion() {
        return searchRegion;
    }

    public void setSearchRegion(String searchRegion) {
        this.searchRegion = searchRegion;
    }

}
