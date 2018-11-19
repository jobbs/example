package ncis.cmn.entity;

/**
 * 서비스라우트 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author x
 */

public class RxServcRoute {

    private Integer servcSeq;  /* 서비스SEQ */
    private String routeId;  /* 라우트ID */
    private String routeNm;  /* 라우트명 */
    private String routeUid;  /* 라우트UID */
    private String targtPort;  /* 타겟포트 */
    private String hstNm;  /* 호스트명 */
    private String path;  /* 경로 */
    private String tlsTrmntnClCd;  /* TLS터미네이션구분코드 */
    private String crtfctKey;  /* 인증서키 */
    private String prvtKey;  /* 개인키 */
    private String caCrtfctKey;  /* CA인증서키 */
    private String dstnCaCrtfctKey;  /* 목적지CA인증서키 */
    private String creDttm;  /* 생성일시 */
    private String creUserId;  /* 생성자ID */


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
	 * @return the routeId
	 */
	public String getRouteId() {
		return routeId;
	}
	/**
	 * @param routeId the routeId to set
	 */
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	/**
	 * @return the routeNm
	 */
	public String getRouteNm() {
		return routeNm;
	}
	/**
	 * @param routeNm the routeNm to set
	 */
	public void setRouteNm(String routeNm) {
		this.routeNm = routeNm;
	}
	/**
	 * @return the routeUid
	 */
	public String getRouteUid() {
		return routeUid;
	}
	/**
	 * @param routeUid the routeUid to set
	 */
	public void setRouteUid(String routeUid) {
		this.routeUid = routeUid;
	}
	/**
	 * @return the targtPort
	 */
	public String getTargtPort() {
		return targtPort;
	}
	/**
	 * @param targtPort the targtPort to set
	 */
	public void setTargtPort(String targtPort) {
		this.targtPort = targtPort;
	}
	/**
	 * @return the hstNm
	 */
	public String getHstNm() {
		return hstNm;
	}
	/**
	 * @param hstNm the hstNm to set
	 */
	public void setHstNm(String hstNm) {
		this.hstNm = hstNm;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return the tlsTrmntnClCd
	 */
	public String getTlsTrmntnClCd() {
		return tlsTrmntnClCd;
	}
	/**
	 * @param tlsTrmntnClCd the tlsTrmntnClCd to set
	 */
	public void setTlsTrmntnClCd(String tlsTrmntnClCd) {
		this.tlsTrmntnClCd = tlsTrmntnClCd;
	}
	/**
	 * @return the crtfctKey
	 */
	public String getCrtfctKey() {
		return crtfctKey;
	}
	/**
	 * @param crtfctKey the crtfctKey to set
	 */
	public void setCrtfctKey(String crtfctKey) {
		this.crtfctKey = crtfctKey;
	}
	/**
	 * @return the prvtKey
	 */
	public String getPrvtKey() {
		return prvtKey;
	}
	/**
	 * @param prvtKey the prvtKey to set
	 */
	public void setPrvtKey(String prvtKey) {
		this.prvtKey = prvtKey;
	}
	/**
	 * @return the caCrtfctKey
	 */
	public String getCaCrtfctKey() {
		return caCrtfctKey;
	}
	/**
	 * @param caCrtfctKey the caCrtfctKey to set
	 */
	public void setCaCrtfctKey(String caCrtfctKey) {
		this.caCrtfctKey = caCrtfctKey;
	}
	/**
	 * @return the dstnCaCrtfctKey
	 */
	public String getDstnCaCrtfctKey() {
		return dstnCaCrtfctKey;
	}
	/**
	 * @param dstnCaCrtfctKey the dstnCaCrtfctKey to set
	 */
	public void setDstnCaCrtfctKey(String dstnCaCrtfctKey) {
		this.dstnCaCrtfctKey = dstnCaCrtfctKey;
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




}
