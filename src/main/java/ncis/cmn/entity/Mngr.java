/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename Mngr.java
 *
 * @author 정승용
 * @lastmodifier 정승용
 * @created 2016. 10. 20.
 * @lastmodified 2016. 10. 20.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 20.     정승용         v1.0             최초생성
 *
 */
package ncis.cmn.entity;

import ncis.cmn.entity.couch.CmnCouchVo;

/**
 * @author 정승용
 *
 */
public class Mngr extends CmnCouchVo {

	private String stackMngrId;			// couchDB의 Key(PK)
	private String rev;					// couchDB 문서 reversion
	private String regionId;			// 지역(Area)ID
	private String zoneId;				// 존(Zone)ID
	private String netId;				// 망(Network)ID
	private String netCd;				// 망(Network) Code
	private String stackClCd;			// 스택(Stack)분류코드
	private String mngrClCd;			// 매니저분류코드
	private String mngrVerCd;			// 매니저버전코드
	private String mngrNm;				// 매니저명
	private String apiVerCd;			// API버전코드
	private String nowVerCd;			// 현재버전코드
	private String regUserNm;			// 등록자명
	private String regDt;				// 등록일자
	private String hostAddr;			// 호스트(Host)주소
	private String hostAddr2;			// 호스트(Host)주소
	private String atchFileName;		// 첨부파일명
	private String atchPath;			// 첨부파일경로
	private String mngrId;				// 매니저ID
	private String mngrPw;				// 매니저PW
	private String virtlCnsleAccesIp;	// 가상콘솔접근IP
	private String virtlCnsleAccesPort;	// 가상콘솔접근PORT
	private String dc;					// 설명
	private String authenticate;		// 인증키 (token 등)
	private String monitoringYN;		// 모니터링 수집 여부

	/**
	 * @return the monitoringYN
	 */
	public String getMonitoringYN() {
		return monitoringYN;
	}
	/**
	 * @param monitoringYN the monitoringYN to set
	 */
	public void setMonitoringYN(String monitoringYN) {
		this.monitoringYN = monitoringYN;
	}
	/**
	 * @return the stackMngrId
	 */
	public String getStackMngrId() {
		return stackMngrId;
	}
	/**
	 * @param stackMngrId the stackMngrId to set
	 */
	public void setStackMngrId(String stackMngrId) {
		this.stackMngrId = stackMngrId;
	}
	/**
	 * @return the rev
	 */
	public String getRev() {
		return rev;
	}
	/**
	 * @param rev the rev to set
	 */
	public void setRev(String rev) {
		this.rev = rev;
	}
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
	 * @return the netCd
	 */
	public String getNetCd() {
		return netCd;
	}
	/**
	 * @param netCd the netCd to set
	 */
	public void setNetCd(String netCd) {
		this.netCd = netCd;
	}
	/**
	 * @return the stackClCd
	 */
	public String getStackClCd() {
		return stackClCd;
	}
	/**
	 * @param stackClCd the stackClCd to set
	 */
	public void setStackClCd(String stackClCd) {
		this.stackClCd = stackClCd;
	}
	/**
	 * @return the mngrClCd
	 */
	public String getMngrClCd() {
		return mngrClCd;
	}
	/**
	 * @param mngrClCd the mngrClCd to set
	 */
	public void setMngrClCd(String mngrClCd) {
		this.mngrClCd = mngrClCd;
	}
	/**
	 * @return the mngrVerCd
	 */
	public String getMngrVerCd() {
		return mngrVerCd;
	}
	/**
	 * @param mngrVerCd the mngrVerCd to set
	 */
	public void setMngrVerCd(String mngrVerCd) {
		this.mngrVerCd = mngrVerCd;
	}
	/**
	 * @return the mngrNm
	 */
	public String getMngrNm() {
		return mngrNm;
	}
	/**
	 * @param mngrNm the mngrNm to set
	 */
	public void setMngrNm(String mngrNm) {
		this.mngrNm = mngrNm;
	}
	/**
	 * @return the apiVerCd
	 */
	public String getApiVerCd() {
		return apiVerCd;
	}
	/**
	 * @param apiVerCd the apiVerCd to set
	 */
	public void setApiVerCd(String apiVerCd) {
		this.apiVerCd = apiVerCd;
	}
	/**
	 * @return the nowVerCd
	 */
	public String getNowVerCd() {
		return nowVerCd;
	}
	/**
	 * @param nowVerCd the nowVerCd to set
	 */
	public void setNowVerCd(String nowVerCd) {
		this.nowVerCd = nowVerCd;
	}
	/**
	 * @return the regUserNm
	 */
	public String getRegUserNm() {
		return regUserNm;
	}
	/**
	 * @param regUserNm the regUserNm to set
	 */
	public void setRegUserNm(String regUserNm) {
		this.regUserNm = regUserNm;
	}
	/**
	 * @return the regDt
	 */
	public String getRegDt() {
		return regDt;
	}
	/**
	 * @param regDt the regDt to set
	 */
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	/**
	 * @return the hostAddr
	 */
	public String getHostAddr() {
		return hostAddr;
	}
	/**
	 * @param hostAddr the hostAddr to set
	 */
	public void setHostAddr(String hostAddr) {
		this.hostAddr = hostAddr;
	}
	/**
	 * @return the atchFileName
	 */
	public String getAtchFileName() {
		return atchFileName;
	}
	/**
	 * @param atchFileName the atchFileName to set
	 */
	public void setAtchFileName(String atchFileName) {
		this.atchFileName = atchFileName;
	}
	/**
	 * @return the atchPath
	 */
	public String getAtchPath() {
		return atchPath;
	}
	/**
	 * @param atchPath the atchPath to set
	 */
	public void setAtchPath(String atchPath) {
		this.atchPath = atchPath;
	}
	/**
	 * @return the mngrId
	 */
	public String getMngrId() {
		return mngrId;
	}
	/**
	 * @param mngrId the mngrId to set
	 */
	public void setMngrId(String mngrId) {
		this.mngrId = mngrId;
	}
	/**
	 * @return the mngrPw
	 */
	public String getMngrPw() {
		return mngrPw;
	}
	/**
	 * @param mngrPw the mngrPw to set
	 */
	public void setMngrPw(String mngrPw) {
		this.mngrPw = mngrPw;
	}
	/**
	 * @return the virtlCnsleAccesIp
	 */
	public String getVirtlCnsleAccesIp() {
		return virtlCnsleAccesIp;
	}
	/**
	 * @param virtlCnsleAccesIp the virtlCnsleAccesIp to set
	 */
	public void setVirtlCnsleAccesIp(String virtlCnsleAccesIp) {
		this.virtlCnsleAccesIp = virtlCnsleAccesIp;
	}
	/**
	 * @return the virtlCnsleAccesPort
	 */
	public String getVirtlCnsleAccesPort() {
		return virtlCnsleAccesPort;
	}
	/**
	 * @param virtlCnsleAccesPort the virtlCnsleAccesPort to set
	 */
	public void setVirtlCnsleAccesPort(String virtlCnsleAccesPort) {
		this.virtlCnsleAccesPort = virtlCnsleAccesPort;
	}
	/**
	 * @return the dc
	 */
	public String getDc() {
		return dc;
	}
	/**
	 * @param dc the dc to set
	 */
	public void setDc(String dc) {
		this.dc = dc;
	}
	/**
	 * @return the hostAddr2
	 */
	public String getHostAddr2() {
		return hostAddr2;
	}
	/**
	 * @param hostAddr2 the hostAddr2 to set
	 */
	public void setHostAddr2(String hostAddr2) {
		this.hostAddr2 = hostAddr2;
	}
	/**
	 * @return the authenticate
	 */
	public String getAuthenticate() {
		return authenticate;
	}
	/**
	 * @param authenticate the authenticate to set
	 */
	public void setAuthenticate(String authenticate) {
		this.authenticate = authenticate;
	}

}
