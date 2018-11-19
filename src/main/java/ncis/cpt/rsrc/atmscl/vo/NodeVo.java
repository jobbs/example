package ncis.cpt.rsrc.atmscl.vo;

import ncis.cmn.entity.RxNode;

public class NodeVo extends RxNode {

	private String regionId; /* 리전ID */
    private String zoneId; /* 존ID */
    private String netClCd; /* 망구분코드 */
    private String netId; /* 망ID */
    private String regionNm; /* 리전명 */
    private String zoneNm; /* 존명 */
    private String netNm; /* 망명 */
    private String rsrcPoolNm; /* 자원풀명 */
    private String creUserId; /* 생성자 */
    private String updtUserId; /* 수정자 */
    private String creUserNm; /* 생성자명 */
    private String updtUserNm; /* 수정자명 */
    private String atmsclNodeTyCdNm;  /* 자동확장노드유형코드명 */
    private String statCdNm; /* 상태코드명 */
    private double sumMemAsgnCapa; /* 메모리할당량 */
    private double avgMemUseRt; /* 메모리사용률 */
    private double sumCpuCorQty; /* CPU코어수 */
    private double avgCpuUseRt; /* CPU사용률 */
    private double netwkIn; /* 네트워크In */
    private double netwkOut; /* 네트워크Out */
    private String atmSclVmNm;  /* 가상버서명 */
    private String atmSclRprsntIpAddr;  /* 가상버서대표IP */
    private String vrlzSwTyCd; /* 가상화소프트웨어유형코드 */
    private String rsrcPoolClCd; /* 자원풀구분코드 */
    private String rprsntIpAddr; /* 가상서버IP */
    private String vmRootId; /* 가상서버 root ID */
    private String vmRootPassWd; /* 가상서버 root PassWd */
    private String nodeRsrcPoolId;  /* 자원풀ID */


	/**
	 * @return the regionId
	 */
	public String getRegionId() {
		return regionId;
	}
	/**
	 * @param regionId the regionId to set
	 */
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	/**
	 * @return the zoneId
	 */
	public String getZoneId() {
		return zoneId;
	}
	/**
	 * @param zoneId the zoneId to set
	 */
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	/**
	 * @return the netClCd
	 */
	public String getNetClCd() {
		return netClCd;
	}
	/**
	 * @param netClCd the netClCd to set
	 */
	public void setNetClCd(String netClCd) {
		this.netClCd = netClCd;
	}
	/**
	 * @return the regionNm
	 */
	public String getRegionNm() {
		return regionNm;
	}
	/**
	 * @param regionNm the regionNm to set
	 */
	public void setRegionNm(String regionNm) {
		this.regionNm = regionNm;
	}
	/**
	 * @return the zoneNm
	 */
	public String getZoneNm() {
		return zoneNm;
	}
	/**
	 * @param zoneNm the zoneNm to set
	 */
	public void setZoneNm(String zoneNm) {
		this.zoneNm = zoneNm;
	}
	/**
	 * @return the netNm
	 */
	public String getNetNm() {
		return netNm;
	}
	/**
	 * @param netNm the netNm to set
	 */
	public void setNetNm(String netNm) {
		this.netNm = netNm;
	}
	/**
	 * @return the rsrcPoolNm
	 */
	public String getRsrcPoolNm() {
		return rsrcPoolNm;
	}
	/**
	 * @param rsrcPoolNm the rsrcPoolNm to set
	 */
	public void setRsrcPoolNm(String rsrcPoolNm) {
		this.rsrcPoolNm = rsrcPoolNm;
	}
	/**
	 * @return the creUserId
	 */
	public String getCreUserId() {
		return creUserId;
	}
	/**
	 * @param creUserId the creUserId to set
	 */
	public void setCreUserId(String creUserId) {
		this.creUserId = creUserId;
	}
	/**
	 * @return the updtUserId
	 */
	public String getUpdtUserId() {
		return updtUserId;
	}
	/**
	 * @param updtUserId the updtUserId to set
	 */
	public void setUpdtUserId(String updtUserId) {
		this.updtUserId = updtUserId;
	}
	/**
	 * @return the creUserNm
	 */
	public String getCreUserNm() {
		return creUserNm;
	}
	/**
	 * @param creUserNm the creUserNm to set
	 */
	public void setCreUserNm(String creUserNm) {
		this.creUserNm = creUserNm;
	}
	/**
	 * @return the updtUserNm
	 */
	public String getUpdtUserNm() {
		return updtUserNm;
	}
	/**
	 * @param updtUserNm the updtUserNm to set
	 */
	public void setUpdtUserNm(String updtUserNm) {
		this.updtUserNm = updtUserNm;
	}
	/**
	 * @return the atmsclNodeTyCdNm
	 */
	public String getAtmsclNodeTyCdNm() {
		return atmsclNodeTyCdNm;
	}
	/**
	 * @param atmsclNodeTyCdNm the atmsclNodeTyCdNm to set
	 */
	public void setAtmsclNodeTyCdNm(String atmsclNodeTyCdNm) {
		this.atmsclNodeTyCdNm = atmsclNodeTyCdNm;
	}
	/**
	 * @return the sumMemAsgnCapa
	 */
	public double getSumMemAsgnCapa() {
		return sumMemAsgnCapa;
	}
	/**
	 * @param sumMemAsgnCapa the sumMemAsgnCapa to set
	 */
	public void setSumMemAsgnCapa(double sumMemAsgnCapa) {
		this.sumMemAsgnCapa = sumMemAsgnCapa;
	}
	/**
	 * @return the avgMemUseRt
	 */
	public double getAvgMemUseRt() {
		return avgMemUseRt;
	}
	/**
	 * @param avgMemUseRt the avgMemUseRt to set
	 */
	public void setAvgMemUseRt(double avgMemUseRt) {
		this.avgMemUseRt = avgMemUseRt;
	}
	/**
	 * @return the sumCpuCorQty
	 */
	public double getSumCpuCorQty() {
		return sumCpuCorQty;
	}
	/**
	 * @param sumCpuCorQty the sumCpuCorQty to set
	 */
	public void setSumCpuCorQty(double sumCpuCorQty) {
		this.sumCpuCorQty = sumCpuCorQty;
	}
	/**
	 * @return the avgCpuUseRt
	 */
	public double getAvgCpuUseRt() {
		return avgCpuUseRt;
	}
	/**
	 * @param avgCpuUseRt the avgCpuUseRt to set
	 */
	public void setAvgCpuUseRt(double avgCpuUseRt) {
		this.avgCpuUseRt = avgCpuUseRt;
	}
	/**
	 * @return the netwkIn
	 */
	public double getNetwkIn() {
		return netwkIn;
	}
	/**
	 * @param netwkIn the netwkIn to set
	 */
	public void setNetwkIn(double netwkIn) {
		this.netwkIn = netwkIn;
	}
	/**
	 * @return the netwkOut
	 */
	public double getNetwkOut() {
		return netwkOut;
	}
	/**
	 * @param netwkOut the netwkOut to set
	 */
	public void setNetwkOut(double netwkOut) {
		this.netwkOut = netwkOut;
	}
	/**
	 * @return the statCdNm
	 */
	public String getStatCdNm() {
		return statCdNm;
	}
	/**
	 * @param statCdNm the statCdNm to set
	 */
	public void setStatCdNm(String statCdNm) {
		this.statCdNm = statCdNm;
	}
	/**
	 * @return the atmSclVmNm
	 */
	public String getAtmSclVmNm() {
		return atmSclVmNm;
	}
	/**
	 * @param atmSclVmNm the atmSclVmNm to set
	 */
	public void setAtmSclVmNm(String atmSclVmNm) {
		this.atmSclVmNm = atmSclVmNm;
	}
	/**
	 * @return the atmSclRprsntIpAddr
	 */
	public String getAtmSclRprsntIpAddr() {
		return atmSclRprsntIpAddr;
	}
	/**
	 * @param atmSclRprsntIpAddr the atmSclRprsntIpAddr to set
	 */
	public void setAtmSclRprsntIpAddr(String atmSclRprsntIpAddr) {
		this.atmSclRprsntIpAddr = atmSclRprsntIpAddr;
	}
	/**
	 * @return the vrlzSwTyCd
	 */
	public String getVrlzSwTyCd() {
		return vrlzSwTyCd;
	}
	/**
	 * @param vrlzSwTyCd the vrlzSwTyCd to set
	 */
	public void setVrlzSwTyCd(String vrlzSwTyCd) {
		this.vrlzSwTyCd = vrlzSwTyCd;
	}
	/**
	 * @return the rsrcPoolClCd
	 */
	public String getRsrcPoolClCd() {
		return rsrcPoolClCd;
	}
	/**
	 * @param rsrcPoolClCd the rsrcPoolClCd to set
	 */
	public void setRsrcPoolClCd(String rsrcPoolClCd) {
		this.rsrcPoolClCd = rsrcPoolClCd;
	}
	/**
	 * @return the rprsntIpAddr
	 */
	public String getRprsntIpAddr() {
		return rprsntIpAddr;
	}
	/**
	 * @param rprsntIpAddr the rprsntIpAddr to set
	 */
	public void setRprsntIpAddr(String rprsntIpAddr) {
		this.rprsntIpAddr = rprsntIpAddr;
	}
	/**
	 * @return the vmRootId
	 */
	public String getVmRootId() {
		return vmRootId;
	}
	/**
	 * @param vmRootId the vmRootId to set
	 */
	public void setVmRootId(String vmRootId) {
		this.vmRootId = vmRootId;
	}
	/**
	 * @return the vmRootPassWd
	 */
	public String getVmRootPassWd() {
		return vmRootPassWd;
	}
	/**
	 * @param vmRootPassWd the vmRootPassWd to set
	 */
	public void setVmRootPassWd(String vmRootPassWd) {
		this.vmRootPassWd = vmRootPassWd;
	}
	/**
	 * @return the netId
	 */
	public String getNetId() {
		return netId;
	}
	/**
	 * @param netId the netId to set
	 */
	public void setNetId(String netId) {
		this.netId = netId;
	}
	/**
	 * @return the nodeRsrcPoolId
	 */
	public String getNodeRsrcPoolId() {
		return nodeRsrcPoolId;
	}
	/**
	 * @param nodeRsrcPoolId the nodeRsrcPoolId to set
	 */
	public void setNodeRsrcPoolId(String nodeRsrcPoolId) {
		this.nodeRsrcPoolId = nodeRsrcPoolId;
	}

}
