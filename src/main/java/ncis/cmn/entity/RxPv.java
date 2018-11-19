package ncis.cmn.entity;

/**
 * PV Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author x
 */

public class RxPv {

	private String rsrcPoolId;  /* 자원풀ID */
	private String pvId;  /* PV_ID */
	private Integer servcAreaSeq;  /* 서비스영역SEQ */
	private String pvNm;  /* PV명 */
	private String pvUid;  /* PV_UID */
	private Integer strgAsgnCapa;  /* 스토리지할당량 */
	private String accssModeClCd;  /* 접근모드구분코드 */
	private String strgClCd;  /* 스토리지구분코드 */
	private String glstrEndpntId;  /* 글러스터엔드포인트ID */
	private String strgPath;  /* 스토리지경로 */
	private String strgHstAddr;  /* 스토리지호스트주소 */
	private String iscsiIqn;  /* ISCSI_IQN */
	private String iscsiLun;  /* ISCSI_LUN */
	private String reUsePolicyClCd;  /* 재사용정책구분코드 */
	private String creDttm;  /* 생성일시 */
	private String updtDttm;  /* 수정일시 */
	private String statCd;  /* 상태코드 */
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
	 * @return the pvId
	 */
	public String getPvId() {
		return pvId;
	}
	/**
	 * @param pvId the pvId to set
	 */
	public void setPvId(String pvId) {
		this.pvId = pvId;
	}

	/**
	 * @return the servcAreaSeq
	 */
	public Integer getServcAreaSeq() {
		return servcAreaSeq;
	}
	/**
	 * @param servcAreaSeq the servcAreaSeq to set
	 */
	public void setServcAreaSeq(Integer servcAreaSeq) {
		this.servcAreaSeq = servcAreaSeq;
	}
	/**
	 * @return the pvNm
	 */
	public String getPvNm() {
		return pvNm;
	}
	/**
	 * @param pvNm the pvNm to set
	 */
	public void setPvNm(String pvNm) {
		this.pvNm = pvNm;
	}
	/**
	 * @return the pvUid
	 */
	public String getPvUid() {
		return pvUid;
	}
	/**
	 * @param pvUid the pvUid to set
	 */
	public void setPvUid(String pvUid) {
		this.pvUid = pvUid;
	}
	/**
	 * @return the strgAsgnCapa
	 */
	public Integer getStrgAsgnCapa() {
		return strgAsgnCapa;
	}
	/**
	 * @param strgAsgnCapa the strgAsgnCapa to set
	 */
	public void setStrgAsgnCapa(Integer strgAsgnCapa) {
		this.strgAsgnCapa = strgAsgnCapa;
	}
	/**
	 * @return the accssModeClCd
	 */
	public String getAccssModeClCd() {
		return accssModeClCd;
	}
	/**
	 * @param accssModeClCd the accssModeClCd to set
	 */
	public void setAccssModeClCd(String accssModeClCd) {
		this.accssModeClCd = accssModeClCd;
	}
	/**
	 * @return the strgClCd
	 */
	public String getStrgClCd() {
		return strgClCd;
	}
	/**
	 * @param strgClCd the strgClCd to set
	 */
	public void setStrgClCd(String strgClCd) {
		this.strgClCd = strgClCd;
	}
	/**
	 * @return the glstrEndpntId
	 */
	public String getGlstrEndpntId() {
		return glstrEndpntId;
	}
	/**
	 * @param glstrEndpntId the glstrEndpntId to set
	 */
	public void setGlstrEndpntId(String glstrEndpntId) {
		this.glstrEndpntId = glstrEndpntId;
	}
	/**
	 * @return the strgPath
	 */
	public String getStrgPath() {
		return strgPath;
	}
	/**
	 * @param strgPath the strgPath to set
	 */
	public void setStrgPath(String strgPath) {
		this.strgPath = strgPath;
	}
	/**
	 * @return the strgHstAddr
	 */
	public String getStrgHstAddr() {
		return strgHstAddr;
	}
	/**
	 * @param strgHstAddr the strgHstAddr to set
	 */
	public void setStrgHstAddr(String strgHstAddr) {
		this.strgHstAddr = strgHstAddr;
	}
	/**
	 * @return the iscsiIqn
	 */
	public String getIscsiIqn() {
		return iscsiIqn;
	}
	/**
	 * @param iscsiIqn the iscsiIqn to set
	 */
	public void setIscsiIqn(String iscsiIqn) {
		this.iscsiIqn = iscsiIqn;
	}
	/**
	 * @return the iscsiLun
	 */
	public String getIscsiLun() {
		return iscsiLun;
	}
	/**
	 * @param iscsiLun the iscsiLun to set
	 */
	public void setIscsiLun(String iscsiLun) {
		this.iscsiLun = iscsiLun;
	}
	/**
	 * @return the reUsePolicyClCd
	 */
	public String getReUsePolicyClCd() {
		return reUsePolicyClCd;
	}
	/**
	 * @param reUsePolicyClCd the reUsePolicyClCd to set
	 */
	public void setReUsePolicyClCd(String reUsePolicyClCd) {
		this.reUsePolicyClCd = reUsePolicyClCd;
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

}
