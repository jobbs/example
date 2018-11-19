package ncis.cmn.entity;

/**
 * 서비스 포트 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author x
 */

public class RxServcPort {

    private Integer servcSeq;  /* 서비스SEQ */
    private String portId;  /* 포트ID */
    private String portNm;  /* 포트명 */
    private String prtcl;  /* 프로토콜 */
    private String port;  /* 포트 */
    private String targtPort;  /* 타겟포트 */
    private String creDttm;  /* 생성일시 */


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
	 * @return the portId
	 */
	public String getPortId() {
		return portId;
	}
	/**
	 * @param portId the portId to set
	 */
	public void setPortId(String portId) {
		this.portId = portId;
	}
	/**
	 * @return the portNm
	 */
	public String getPortNm() {
		return portNm;
	}
	/**
	 * @param portNm the portNm to set
	 */
	public void setPortNm(String portNm) {
		this.portNm = portNm;
	}
	/**
	 * @return the prtcl
	 */
	public String getPrtcl() {
		return prtcl;
	}
	/**
	 * @param prtcl the prtcl to set
	 */
	public void setPrtcl(String prtcl) {
		this.prtcl = prtcl;
	}
	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}
	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
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



}
