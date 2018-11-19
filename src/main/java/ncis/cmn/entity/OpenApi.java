/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename OpenApi.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     박희택         v1.0             최초생성
 *
 */
package ncis.cmn.entity;

import javax.validation.constraints.Pattern;

import ncis.cmn.entity.couch.CmnCouchVo;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author 박희택
 *
 */
public class OpenApi extends CmnCouchVo {

	private String opApiId;						// couchDB의 Key(Pk)
	private String rev;							// couchDB 문서 reversion
	private String regionId;					// 센터정보
	private String opApiNm;						//openAPI명
	private String svcDscvryYn;					//서비스Discovery사용여부명
	@NotEmpty(message="URI를 입력하여 주시기 바랍니다." )
    @Pattern(regexp="^[/](\\w|/)*[/]|/$", message="URI 패턴은 반드시 '/'로 시작을 하여 '/'로 끝나도록 하여 주시기 바랍니다.")
	private String uri;							//gateway 호출 URI
	private String statCd;						// 상태코드
	private String regUserNm; 					// 등록자명
	private String regDt;						// 등록일자
	private String targetHstAddr;				// 타겟호스트주소
	private String dc;							// 설명

	/**
	 * @return the opApiId
	 */
	public String getOpApiId() {
		return opApiId;
	}
	/**
	 * @param opApiId the opApiId to set
	 */
	public void setOpApiId(String opApiId) {
		this.opApiId = opApiId;
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
	 * @return the opApiNm
	 */
	public String getOpApiNm() {
		return opApiNm;
	}
	/**
	 * @param opApiNm the opApiNm to set
	 */
	public void setOpApiNm(String opApiNm) {
		this.opApiNm = opApiNm;
	}
	/**
	 * @return the svcDscvryYn
	 */
	public String getSvcDscvryYn() {
		return svcDscvryYn;
	}
	/**
	 * @param svcDscvryYn the svcDscvryYn to set
	 */
	public void setSvcDscvryYn(String svcDscvryYn) {
		this.svcDscvryYn = svcDscvryYn;
	}
	/**
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}
	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
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
	 * @return the targetHstAddr
	 */
	public String getTargetHstAddr() {
		return targetHstAddr;
	}
	/**
	 * @param targetHstAddr the targetHstAddr to set
	 */
	public void setTargetHstAddr(String targetHstAddr) {
		this.targetHstAddr = targetHstAddr;
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

}
