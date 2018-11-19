package ncis.cmn.entity;

/**
 * Pod Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author x
 */

public class RxServcPod {

    private Integer servcSeq;  /* 서비스SEQ */
    private String podId;  /* POD_ID */
    private String podNm;  /* POD명 */
    private String podUid;  /* POD_UID */
    private String podIpAddr;  /* PODIP주소 */
    private String hstIpAddr;  /* 호스트IP주소 */
    private double cpuCorQty;  /* CPU코어수 */
    private double memAsgnCapa;  /* 메모리할당량 */
    private double strgAsgnCapa;  /* 스토리지할당량 */
    private String imgId;  /* 이미지ID */
    private double cpuUseRt;  /* CPU사용률 */
    private double memUseRt;  /* 메모리사용률 */
    private double netwkIn;  /* 네트워크IN(KB/sec) */
    private double netwkOut;  /* 네트워크OUT(KB/sec) */
    private String strtDttm;  /* 시작일시 */
    private String atmsclNodeId;  /* 자동확장노드ID */
    private String creDttm;  /* 생성일시 */
    private String updtDttm;  /* 수정일시 */
    private String rsrcPoolId;  /* 자원풀ID */
    private String statCd;  /* 상태코드 */
    private String delYn;  /* 삭제여부 */
    private String imgRepoDtlAddr;  /* 이미지상세주소 */
    private String podTyCd;  /* pod유형코드 */

	/**
	 * @return the servcSeq
	 */
	public Integer getServcSeq() {
		return servcSeq;
	}
	/**
	 * @param servcSeq the servcSeq to set
	 */
	public void setServcSeq(Integer servcSeq) {
		this.servcSeq = servcSeq;
	}
	/**
	 * @return the podId
	 */
	public String getPodId() {
		return podId;
	}
	/**
	 * @param podId the podId to set
	 */
	public void setPodId(String podId) {
		this.podId = podId;
	}
	/**
	 * @return the podNm
	 */
	public String getPodNm() {
		return podNm;
	}
	/**
	 * @param podNm the podNm to set
	 */
	public void setPodNm(String podNm) {
		this.podNm = podNm;
	}
	/**
	 * @return the podUid
	 */
	public String getPodUid() {
		return podUid;
	}
	/**
	 * @param podUid the podUid to set
	 */
	public void setPodUid(String podUid) {
		this.podUid = podUid;
	}
	/**
	 * @return the podIpAddr
	 */
	public String getPodIpAddr() {
		return podIpAddr;
	}
	/**
	 * @param podIpAddr the podIpAddr to set
	 */
	public void setPodIpAddr(String podIpAddr) {
		this.podIpAddr = podIpAddr;
	}
	/**
	 * @return the hstIpAddr
	 */
	public String getHstIpAddr() {
		return hstIpAddr;
	}
	/**
	 * @param hstIpAddr the hstIpAddr to set
	 */
	public void setHstIpAddr(String hstIpAddr) {
		this.hstIpAddr = hstIpAddr;
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
	 * @return the strgAsgnCapa
	 */
	public double getStrgAsgnCapa() {
		return strgAsgnCapa;
	}
	/**
	 * @param strgAsgnCapa the strgAsgnCapa to set
	 */
	public void setStrgAsgnCapa(double strgAsgnCapa) {
		this.strgAsgnCapa = strgAsgnCapa;
	}
	/**
	 * @return the imgId
	 */
	public String getImgId() {
		return imgId;
	}
	/**
	 * @param imgId the imgId to set
	 */
	public void setImgId(String imgId) {
		this.imgId = imgId;
	}
	/**
	 * @return the cpuUseRt
	 */
	public double getCpuUseRt() {
		return cpuUseRt;
	}
	/**
	 * @param cpuUseRt the cpuUseRt to set
	 */
	public void setCpuUseRt(double cpuUseRt) {
		this.cpuUseRt = cpuUseRt;
	}
	/**
	 * @return the memUseRt
	 */
	public double getMemUseRt() {
		return memUseRt;
	}
	/**
	 * @param memUseRt the memUseRt to set
	 */
	public void setMemUseRt(double memUseRt) {
		this.memUseRt = memUseRt;
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
	 * @return the strtDttm
	 */
	public String getStrtDttm() {
		return strtDttm;
	}
	/**
	 * @param strtDttm the strtDttm to set
	 */
	public void setStrtDttm(String strtDttm) {
		this.strtDttm = strtDttm;
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
	 * @return the delYn
	 */
	public String getDelYn() {
		return delYn;
	}
	/**
	 * @param delYn the delYn to set
	 */
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	/**
	 * @return the imgRepoDtlAddr
	 */
	public String getImgRepoDtlAddr() {
		return imgRepoDtlAddr;
	}
	/**
	 * @param imgRepoDtlAddr the imgRepoDtlAddr to set
	 */
	public void setImgRepoDtlAddr(String imgRepoDtlAddr) {
		this.imgRepoDtlAddr = imgRepoDtlAddr;
	}
	/**
	 * @return the podTyCd
	 */
	public String getPodTyCd() {
		return podTyCd;
	}
	/**
	 * @param podTyCd the podTyCd to set
	 */
	public void setPodTyCd(String podTyCd) {
		this.podTyCd = podTyCd;
	}

}
