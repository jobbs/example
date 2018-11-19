/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename OpenApiVo.java
 *
 * @author 정승용
 * @lastmodifier 정승용
 * @created 2016. 10. 18.
 * @lastmodified 2016. 10. 18.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 18.     정승용         v1.0             최초생성
 */
package ncis.api.stack.mngr.vo;

import java.util.List;

import ncis.cmn.entity.Mngr;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 정승용
 *
 */
public class MngrVo extends Mngr {

	private String regionNm;			// 지역(Center)
	private String zoneNm;				// 존(Zone)
	private String netNm;				// 망(Network)
	private String stackClNm;			// 스택 분류
	private String mngrClNm;			// 매니저 분류
	private String mngrVerNm;			// 매니저 버전
	private String apiVerNm;			// API 버전
	private String nowVerNm;			// 현재 버전
	private MultipartFile uploadFile;	// 업로드 파일
	private String passwdChk;			// 비밀번호 확인
	private String status;				// 스택 매니저 호출 후 상태

	private List<String> delKey;		// 목록의 체크박스 Key : OpenAPI ID
	private List<String> delRev;    	// 목록의 체크박스 Rev : couchDB 문서 Reversion

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
	 * @return the stackClNm
	 */
	public String getStackClNm() {
		return stackClNm;
	}
	/**
	 * @param stackClNm the stackClNm to set
	 */
	public void setStackClNm(String stackClNm) {
		this.stackClNm = stackClNm;
	}
	/**
	 * @return the mngrClNm
	 */
	public String getMngrClNm() {
		return mngrClNm;
	}
	/**
	 * @param mngrClNm the mngrClNm to set
	 */
	public void setMngrClNm(String mngrClNm) {
		this.mngrClNm = mngrClNm;
	}
	/**
	 * @return the mngrVerNm
	 */
	public String getMngrVerNm() {
		return mngrVerNm;
	}
	/**
	 * @param mngrVerNm the mngrVerNm to set
	 */
	public void setMngrVerNm(String mngrVerNm) {
		this.mngrVerNm = mngrVerNm;
	}
	/**
	 * @return the apiVerNm
	 */
	public String getApiVerNm() {
		return apiVerNm;
	}
	/**
	 * @param apiVerNm the apiVerNm to set
	 */
	public void setApiVerNm(String apiVerNm) {
		this.apiVerNm = apiVerNm;
	}
	/**
	 * @return the nowVerNm
	 */
	public String getNowVerNm() {
		return nowVerNm;
	}
	/**
	 * @param nowVerNm the nowVerNm to set
	 */
	public void setNowVerNm(String nowVerNm) {
		this.nowVerNm = nowVerNm;
	}
	/**
	 * @return the uploadFile
	 */
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	/**
	 * @param uploadFile the uploadFile to set
	 */
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	/**
	 * @return the passwdChk
	 */
	public String getPasswdChk() {
		return passwdChk;
	}
	/**
	 * @param passwdChk the passwdChk to set
	 */
	public void setPasswdChk(String passwdChk) {
		this.passwdChk = passwdChk;
	}
	/**
	 * @return the delKey
	 */
	public List<String> getDelKey() {
		return delKey;
	}
	/**
	 * @param delKey the delKey to set
	 */
	public void setDelKey(List<String> delKey) {
		this.delKey = delKey;
	}
	/**
	 * @return the delRev
	 */
	public List<String> getDelRev() {
		return delRev;
	}
	/**
	 * @param delRev the delRev to set
	 */
	public void setDelRev(List<String> delRev) {
		this.delRev = delRev;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}