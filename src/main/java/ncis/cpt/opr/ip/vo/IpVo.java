/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename IpVo.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 9. 27.
 * @lastmodified 2016. 9. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 27.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.vo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import ncis.cmn.entity.RnIp;
import ncis.cpt.opr.ip.config.IpBndConstants;

/**
 * @author 신재훈
 *
 */
public class IpVo extends RnIp {
    private String vmCompId; // 가상서버 구성ID
    private String vmNm; // 가상서버명
    private String hstNm; // 호스트명
    private String macAddr; // MAC주소
    private String hypervisor; // 가상화구분
    private String ipStatNm; // 상태명
    private String regionNm; // 센터명
    private String regionId; // 센터ID

    private BigDecimal selectVmSeq; // 선택한 가상서버 Id
    private BigDecimal selectNetwkIntfcSeq; // 선택한 NIC ID

    private String selectNetClCd;
    private String selectRegionId;

    private List<String> checkIps;
    private List<String> ipAddrList;

    private List<Integer> checkBndIds;

    private String netNm; // 망명
    private String institutionNm; // 부처명
    private String ipBndNm; // IP대역명

    private List<IpVo> ipList; // IpVo 목록

    private BigDecimal selectBndSeq;
    
    private String[] checkDatas;
    private List<String> checkDataList;
//    private List<CheckIpVo> checkDataList;
    
	public String getMacAddr() {
        return macAddr;
    }

    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr;
    }

    public String getHypervisor() {
        return hypervisor;
    }

    public void setHypervisor(String hypervisor) {
        this.hypervisor = hypervisor;
    }

    public String getVmNm() {
        return vmNm;
    }
    
	public void setVmNm(String vmNm) {
        this.vmNm = vmNm;
    }

    public String getHstNm() {
        return hstNm;
    }

    public void setHstNm(String hstNm) {
        this.hstNm = hstNm;
    }

    public List<String> getCheckIps() {
        return checkIps;
    }

    public void setCheckIps(List<String> checkIps) {
        this.checkIps = checkIps;
    }

    public String getIpStatNm() {
        return ipStatNm;
    }

    public void setIpStatNm(String ipStatNm) {
        this.ipStatNm = ipStatNm;
    }

    public BigDecimal getSelectVmSeq() {
        return selectVmSeq;
    }

    public void setSelectVmSeq(BigDecimal selectVmSeq) {
        this.selectVmSeq = selectVmSeq;
    }

    public List<String> getIpAddrList() {
        return ipAddrList;
    }

    public void setIpAddrList(List<String> ipAddrList) {
        this.ipAddrList = ipAddrList;
    }

    public String getInstitutionNm() {
        return institutionNm;
    }

    public void setInstitutionNm(String institutionNm) {
        this.institutionNm = institutionNm;
    }

    public String getIpBndNm() {
        return ipBndNm;
    }

    public void setIpBndNm(String ipBndNm) {
        this.ipBndNm = ipBndNm;
    }

    public String getNetNm() {
        return netNm;
    }

    public void setNetNm(String netNm) {
        this.netNm = netNm;
    }

    public List<Integer> getCheckBndIds() {
        return checkBndIds;
    }

    public void setCheckBndIds(List<Integer> checkBndIds) {
        this.checkBndIds = checkBndIds;
    }

    public BigDecimal getSelectNetwkIntfcSeq() {
        return selectNetwkIntfcSeq;
    }

    public void setSelectNetwkIntfcSeq(BigDecimal selectNetwkIntfcSeq) {
        this.selectNetwkIntfcSeq = selectNetwkIntfcSeq;
    }

    public List<IpVo> getIpList() {
        return ipList;
    }

    public void setIpList(List<IpVo> ipList) {
        this.ipList = ipList;
    }

    public String getVmCompId() {
        return vmCompId;
    }

    public void setVmCompId(String vmCompId) {
        this.vmCompId = vmCompId;
    }

    @Override
    public String toString() {
        return "IpVo [vmCompId=" + vmCompId + ", vmNm=" + vmNm + ", hstNm=" + hstNm + ", macAddr=" + macAddr + ", hypervisor=" + hypervisor + ", ipStatNm=" + ipStatNm + ", selectVmSeq=" + selectVmSeq + ", selectNetwkIntfcSeq=" + selectNetwkIntfcSeq + ", checkIps=" + checkIps + ", ipAddrList=" + ipAddrList + ", checkBndIds=" + checkBndIds + ", netNm=" + netNm + ", institutionNm=" + institutionNm + ", ipBndNm=" + ipBndNm + ", ipList=" + ipList + ", getIpAddr()=" + getIpAddr() + ", getIpStatCd()=" + getIpStatCd() + ", getVipYn()=" + getVipYn() + ", getNatIpAddr()=" + getNatIpAddr() + ", getRmk()=" + getRmk() + ", getUpdtUserId()=" + getUpdtUserId() + ", getUpdtDttm()=" + getUpdtDttm() + ", getAsgnDt()=" + getAsgnDt() + ", getChngDt()=" + getChngDt() + ", getWithdrawDt()=" + getWithdrawDt() + ", getBndSeq()=" + getBndSeq() + ", getNetwkIntfcSeq()=" + getNetwkIntfcSeq() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    public BigDecimal getSelectBndSeq() {
        return selectBndSeq;
    }

    public void setSelectBndSeq(BigDecimal selectBndSeq) {
        this.selectBndSeq = selectBndSeq;
    }

    public String getRegionNm() {
        return regionNm;
    }

    public void setRegionNm(String regionNm) {
        this.regionNm = regionNm;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getSelectRegionId() {
        return selectRegionId;
    }

    public void setSelectRegionId(String selectRegionId) {
        this.selectRegionId = selectRegionId;
    }

    public String getAsgnDtToString() {
        return (null == getAsgnDt() ? null : new SimpleDateFormat("yyyy.MM.dd").format(getAsgnDt()));
    }

    public String getWithdrawDtToString() {
        return (null == getWithdrawDt() ? null : new SimpleDateFormat("yyyy.MM.dd").format(getWithdrawDt()));
    }

    public String getChngDtToString() {
        return (null == getChngDt() ? null : new SimpleDateFormat("yyyy.MM.dd").format(getChngDt()));
    }

    public String getIpStatCdNm() {
        String ipStatCdNm = "";
        if (null != getIpStatCd()) {
            switch (getIpStatCd()) {
                case "01":
                    ipStatCdNm = IpBndConstants.IP_BND_STAT_CD_NM_ASGN;
                    break;
                case "02":
                    ipStatCdNm = IpBndConstants.IP_BND_STAT_CD_NM_UNASGN;
                    break;
                case "03":
                    ipStatCdNm = IpBndConstants.IP_BND_STAT_CD_NM_BLK;
                    break;
            }
        }
        return ipStatCdNm;
    }

    public String getSelectNetClCd() {
        return selectNetClCd;
    }

    public void setSelectNetClCd(String selectNetClCd) {
        this.selectNetClCd = selectNetClCd;
    }

	/**
	 * @return the checkDatas
	 */
	public String[] getCheckDatas() {
		return checkDatas;
	}

	/**
	 * @param checkDatas the checkDatas to set
	 */
	public void setCheckDatas(String[] checkDatas) {
		this.checkDatas = checkDatas;
	}

	/**
	 * @return the checkDataList
	 */
	public List<String> getCheckDataList() {
		return checkDataList;
	}

	/**
	 * @param checkDataList the checkDataList to set
	 */
	public void setCheckDataList(List<String> checkDataList) {
		this.checkDataList = checkDataList;
	}

}
