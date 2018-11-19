/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename IpBndVo.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     신재훈         v1.0             최초생성
 *
 */

package ncis.cpt.opr.ip.vo;

import java.util.List;
import ncis.cmn.entity.RnIpBnd;
import ncis.cpt.sys.instt.vo.InsttVo;

public class IpBndVo extends RnIpBnd {

    private List<IpVo> ipList; // IP목록
    private List<SRoutVo> sRoutLists; // StaticRouter 목록
    private List<VrSwtchVo> vrSwtchList; // 가상스위치 목록
    private List<InsttVo> insttList; // 부서목록
    private List<IpBndPrposVo> ipBndPrposVoList; // 용도 조회
    private List<IpBndInstVo> ipBndInstVoList; // 부처 조회

    private String regionNm;
    private String netNm;
    private String regUserNm;
    private String updtUserNm;
    private String prposNm;
    private String useYnNm;
    private String prposClCd; /* 용도 코드 */
    private String prposClNm; /* 용도코드 명 */
    private String ipBndUseYn;

    private String institutionId; // 부처ID
    private String institutionNm; // 부처명

    private List<String> prposClCdList; // 용도 코드 리스트

    public String getRegionNm() {
        return regionNm;
    }

    public void setRegionNm(String regionNm) {
        this.regionNm = regionNm;
    }

    public String getNetNm() {
        return netNm;
    }

    public void setNetNm(String netNm) {
        this.netNm = netNm;
    }

    public String getRegUserNm() {
        return regUserNm;
    }

    public void setRegUserNm(String regUserNm) {
        this.regUserNm = regUserNm;
    }

    public String getUpdtUserNm() {
        return updtUserNm;
    }

    public void setUpdtUserNm(String updtUserNm) {
        this.updtUserNm = updtUserNm;
    }

    public String getInstitutionNm() {
        return institutionNm;
    }

    public void setInstitutionNm(String institutionNm) {
        this.institutionNm = institutionNm;
    }

    public String getPrposNm() {
        return prposNm;
    }

    public void setPrposNm(String prposNm) {
        this.prposNm = prposNm;
    }

    public String getUseYnNm() {
        return useYnNm;
    }

    public void setUseYnNm(String useYnNm) {
        this.useYnNm = useYnNm;
    }

    public List<IpVo> getIpList() {
        return ipList;
    }

    public void setIpList(List<IpVo> ipList) {
        this.ipList = ipList;
    }

    public List<InsttVo> getInsttList() {
        return insttList;
    }

    public void setInsttList(List<InsttVo> insttList) {
        this.insttList = insttList;
    }

    public List<IpBndPrposVo> getIpBndPrposVoList() {
        return ipBndPrposVoList;
    }

    public void setIpBndPrposVoList(List<IpBndPrposVo> ipBndPrposVoList) {
        this.ipBndPrposVoList = ipBndPrposVoList;
    }

    public List<String> getPrposClCdList() {
        return prposClCdList;
    }

    public void setPrposClCdList(List<String> prposClCdList) {
        this.prposClCdList = prposClCdList;
    }

    public List<VrSwtchVo> getVrSwtchList() {
        return vrSwtchList;
    }

    public void setVrSwtchList(List<VrSwtchVo> vrSwtchList) {
        this.vrSwtchList = vrSwtchList;
    }

    public String getPrposClCd() {
        return prposClCd;
    }

    public void setPrposClCd(String prposClCd) {
        this.prposClCd = prposClCd;
    }

    public String getPrposClNm() {
        return prposClNm;
    }

    public void setPrposClNm(String prposClNm) {
        this.prposClNm = prposClNm;
    }

    public List<SRoutVo> getsRoutLists() {
        return sRoutLists;
    }

    public void setsRoutLists(List<SRoutVo> sRoutLists) {
        this.sRoutLists = sRoutLists;
    }

    public String getIpBndUseYn() {
        return ipBndUseYn;
    }

    public void setIpBndUseYn(String ipBndUseYn) {
        this.ipBndUseYn = ipBndUseYn;
    }

    public List<IpBndInstVo> getIpBndInstVoList() {
        return ipBndInstVoList;
    }

    public void setIpBndInstVoList(List<IpBndInstVo> ipBndInstVoList) {
        this.ipBndInstVoList = ipBndInstVoList;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

}
