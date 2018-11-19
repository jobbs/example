package ncis.cmn.entity;

/**
 * 노드 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author x
 */

public class RxNode {

    private String rsrcPoolId;  /* 자원풀ID */
    private String atmsclNodeId;  /* 자동확장노드ID */
    private String atmsclNodeNm;  /* 자동확장노드명 */
    private String atmsclNodeIpAddr;  /* 자동확장노드IP주소 */
    private String atmsclNodeUid;  /* 자동확장노드UID */
    private double cpuCorQty;  /* CPU코어수 */
    private double memAsgnCapa;  /* 메모리할당량 */
    private Integer podQty;  /* POD수 */
    private String statCd;  /* 상태코드 */
    private String creDttm;  /* 생성일시 */
    private String updtDttm;  /* 수정일시 */
    private String syncDttm;  /* 동기화일시 */
    private String creUserId;  /* 생성자ID */
    private String updtUserId;  /* 수정자ID */
    private String rmk;  /* 비고 */
    private String atmsclNodeTyCd;  /* 자동확장노드유형코드 */
	/**
	 * @return the rsrcPoolId
	 */
	public String getRsrcPoolId() {
		return rsrcPoolId;
	}
	/**
	 * @param rsrcPoolId the rsrcPoolId to set
	 */
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}
	/**
	 * @return the atmsclNodeId
	 */
	public String getAtmsclNodeId() {
		return atmsclNodeId;
	}
	/**
	 * @param atmsclNodeId the atmsclNodeId to set
	 */
	public void setAtmsclNodeId(String atmsclNodeId) {
		this.atmsclNodeId = atmsclNodeId;
	}
	/**
	 * @return the atmsclNodeNm
	 */
	public String getAtmsclNodeNm() {
		return atmsclNodeNm;
	}
	/**
	 * @param atmsclNodeNm the atmsclNodeNm to set
	 */
	public void setAtmsclNodeNm(String atmsclNodeNm) {
		this.atmsclNodeNm = atmsclNodeNm;
	}
	/**
	 * @return the atmsclNodeIpAddr
	 */
	public String getAtmsclNodeIpAddr() {
		return atmsclNodeIpAddr;
	}
	/**
	 * @param atmsclNodeIpAddr the atmsclNodeIpAddr to set
	 */
	public void setAtmsclNodeIpAddr(String atmsclNodeIpAddr) {
		this.atmsclNodeIpAddr = atmsclNodeIpAddr;
	}
	/**
	 * @return the atmsclNodeUid
	 */
	public String getAtmsclNodeUid() {
		return atmsclNodeUid;
	}
	/**
	 * @param atmsclNodeUid the atmsclNodeUid to set
	 */
	public void setAtmsclNodeUid(String atmsclNodeUid) {
		this.atmsclNodeUid = atmsclNodeUid;
	}
	/**
	 * @return the cpuCorQty
	 */
	public double getCpuCorQty() {
		return cpuCorQty;
	}
	/**
	 * @param cpuCorQty the cpuCorQty to set
	 */
	public void setCpuCorQty(double cpuCorQty) {
		this.cpuCorQty = cpuCorQty;
	}
	/**
	 * @return the memAsgnCapa
	 */
	public double getMemAsgnCapa() {
		return memAsgnCapa;
	}
	/**
	 * @param memAsgnCapa the memAsgnCapa to set
	 */
	public void setMemAsgnCapa(double memAsgnCapa) {
		this.memAsgnCapa = memAsgnCapa;
	}
	/**
	 * @return the podQty
	 */
	public Integer getPodQty() {
		return podQty;
	}
	/**
	 * @param podQty the podQty to set
	 */
	public void setPodQty(Integer podQty) {
		this.podQty = podQty;
	}
	/**
	 * @return the statCd
	 */
	public String getStatCd() {
		return statCd;
	}
	/**
	 * @param statCd the statCd to set
	 */
	public void setStatCd(String statCd) {
		this.statCd = statCd;
	}
	/**
	 * @return the creDttm
	 */
	public String getCreDttm() {
		return creDttm;
	}
	/**
	 * @param creDttm the creDttm to set
	 */
	public void setCreDttm(String creDttm) {
		this.creDttm = creDttm;
	}
	/**
	 * @return the updtDttm
	 */
	public String getUpdtDttm() {
		return updtDttm;
	}
	/**
	 * @param updtDttm the updtDttm to set
	 */
	public void setUpdtDttm(String updtDttm) {
		this.updtDttm = updtDttm;
	}
	/**
	 * @return the syncDttm
	 */
	public String getSyncDttm() {
		return syncDttm;
	}
	/**
	 * @param syncDttm the syncDttm to set
	 */
	public void setSyncDttm(String syncDttm) {
		this.syncDttm = syncDttm;
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
	 * @return the rmk
	 */
	public String getRmk() {
		return rmk;
	}
	/**
	 * @param rmk the rmk to set
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	/**
	 * @return the atmsclNodeTyCd
	 */
	public String getAtmsclNodeTyCd() {
		return atmsclNodeTyCd;
	}
	/**
	 * @param atmsclNodeTyCd the atmsclNodeTyCd to set
	 */
	public void setAtmsclNodeTyCd(String atmsclNodeTyCd) {
		this.atmsclNodeTyCd = atmsclNodeTyCd;
	}
}
