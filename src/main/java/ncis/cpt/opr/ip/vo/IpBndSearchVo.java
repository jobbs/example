package ncis.cpt.opr.ip.vo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import ncis.cmn.vo.CommonSearchVo;

public class IpBndSearchVo extends CommonSearchVo {

    private String searchUseYn; // 사용여부
    private String searchRegion; // 리전
    private String searchNet; // 망
    private String searchIpBndName; // IP대역명
    private String searchGateway; // 게이트웨이
    private String searchStrtIp; // 시작IP
    private String searchEndIp; // 종료IP
    private String searchInstitution; // 사용부처
    private String searchVlan; // VLAN
    private String[] searchPrposList; // 용도
    private List<Integer> checkBndIps;
    private BigDecimal searchBndSeq;

    private BigDecimal bndSeq; /* 선택된 IP 대역 망 ID */
    private String ipAddr; /* 선택된 Ip */
    private String prposClCd; /* IP대역용도 코드 */
    private String nicPrposCd; /* NIC 용도 코드 */
    private String zoneId; /* 존 ID */
    private String netClCd; /* 망구분코드 */
    private String institutionId; /* 기관 ID */
    private String idIndex; /* index */
    private String natYn; /* NAT IP 여부 */
    private String ipBndUseYn;

    public String getSearchUseYn() {
        return searchUseYn;
    }

    public void setSearchUseYn(String searchUseYn) {
        this.searchUseYn = searchUseYn;
    }

    public String getSearchRegion() {
        return searchRegion;
    }

    public void setSearchRegion(String searchRegion) {
        this.searchRegion = searchRegion;
    }

    public String getSearchNet() {
        return searchNet;
    }

    public void setSearchNet(String searchNet) {
        this.searchNet = searchNet;
    }

    public String getSearchIpBndName() {
        return searchIpBndName;
    }

    public void setSearchIpBndName(String searchIpBndName) {
        this.searchIpBndName = searchIpBndName;
    }

    public String getSearchGateway() {
        return searchGateway;
    }

    public void setSearchGateway(String searchGateway) {
        this.searchGateway = searchGateway;
    }

    public String getSearchEndIp() {
        return searchEndIp;
    }

    public void setSearchEndIp(String searchEndIp) {
        this.searchEndIp = searchEndIp;
    }

    public String getSearchVlan() {
        return searchVlan;
    }

    public void setSearchVlan(String searchVlan) {
        this.searchVlan = searchVlan;
    }

    public String getSearchStrtIp() {
        return searchStrtIp;
    }

    public void setSearchStrtIp(String searchStrtIp) {
        this.searchStrtIp = searchStrtIp;
    }

    public String getSearchInstitution() {
        return searchInstitution;
    }

    public void setSearchInstitution(String searchInstitution) {
        this.searchInstitution = searchInstitution;
    }

    public List<Integer> getCheckBndIps() {
        return checkBndIps;
    }

    public void setCheckBndIps(List<Integer> checkBndIps) {
        this.checkBndIps = checkBndIps;
    }

    public String getPrposClCd() {
        return prposClCd;
    }

    public void setPrposClCd(String prposClCd) {
        this.prposClCd = prposClCd;
    }

    public String getNicPrposCd() {
        return nicPrposCd;
    }

    public void setNicPrposCd(String nicPrposCd) {
        this.nicPrposCd = nicPrposCd;
    }

    public String getNetClCd() {
		return netClCd;
	}

	public void setNetClCd(String netClCd) {
		this.netClCd = netClCd;
	}

	public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getIdIndex() {
        return idIndex;
    }

    public void setIdIndex(String idIndex) {
        this.idIndex = idIndex;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public BigDecimal getSearchBndSeq() {
        return searchBndSeq;
    }

    public void setSearchBndSeq(BigDecimal searchBndSeq) {
        this.searchBndSeq = searchBndSeq;
    }

    public BigDecimal getBndSeq() {
        return bndSeq;
    }

    public void setBndSeq(BigDecimal bndSeq) {
        this.bndSeq = bndSeq;
    }

    public String[] getSearchPrposList() {
        if (null != this.searchPrposList) {
            this.searchPrposList = (searchPrposList == null ? null : Arrays.copyOf(searchPrposList, searchPrposList.length));
            return this.searchPrposList;
        }
        return null;
    }

    public void setSearchPrposList(String[] searchPrposList) {
        this.searchPrposList = (searchPrposList == null ? null : Arrays.copyOf(searchPrposList, searchPrposList.length));
    }

    public String getNatYn() {
        return natYn;
    }

    public void setNatYn(String natYn) {
        this.natYn = natYn;
    }

    public String getIpBndUseYn() {
        return ipBndUseYn;
    }

    public void setIpBndUseYn(String ipBndUseYn) {
        this.ipBndUseYn = ipBndUseYn;
    }
}
