/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TemplateVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 9. 21.
 * @lastmodified 2016. 9. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 21.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.rest.intfc.conf.vo;

import java.util.List;

/**
 * 가상서버템플릿 구성정보
 * @author ShinKeeBong
 *
 */
//@JsonInclude(Include.NON_NULL)
public class TemplateVO {

	private String centerId;              /* 센터 구분 코드     */
	private String templateId;            /* 템플릿 일련번호    */
	private String templateName;          /* 템플릿 명          */
	private String osName;                /* 운영체제 명        */
	private String osVersion;             /* 운영체제 버전      */
	private String osPlatform;            /* 운영체제 플랫폼 명 */
	private String osKernel;              /* 운영체제 커널 명   */
	private String osBits;                /* 운영체제 비트      */
	private String osLanguage;            /* 운영체제 언어 명   */
	private String osTypeCode;                /* 운영체제 코드      */
	private String osType;                /* 운영체제 코드      */
	private String networkCode;           /* 네트워크 유형 코드 */
	private String networkName;           /* 네트워크 유형 코드 */
	private List<TemplatePrposVO> purposeCodes;    /* 용도 유형 코드     */



	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getOsName() {
		return osName;
	}
	public void setOsName(String osName) {
		this.osName = osName;
	}
	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	public String getOsPlatform() {
		return osPlatform;
	}
	public void setOsPlatform(String osPlatform) {
		this.osPlatform = osPlatform;
	}
	public String getOsKernel() {
		return osKernel;
	}
	public void setOsKernel(String osKernel) {
		this.osKernel = osKernel;
	}
	public String getOsBits() {
		return osBits;
	}
	public void setOsBits(String osBits) {
		this.osBits = osBits;
	}
	public String getOsLanguage() {
		return osLanguage;
	}
	public void setOsLanguage(String osLanguage) {
		this.osLanguage = osLanguage;
	}
	public String getOsTypeCode()
	{
		return osTypeCode;
	}
	public void setOsTypeCode(String osTypeCode)
	{
		this.osTypeCode = osTypeCode;
	}
	public String getOsType()
	{
		return osType;
	}
	public void setOsType(String osType)
	{
		this.osType = osType;
	}
	public String getNetworkName()
	{
		return networkName;
	}
	public void setNetworkName(String networkName)
	{
		this.networkName = networkName;
	}
	public String getNetworkCode() {
		return networkCode;
	}
	public void setNetworkCode(String networkCode) {
		this.networkCode = networkCode;
	}
	public List<TemplatePrposVO> getPurposeCodes() {
		return purposeCodes;
	}
	public void setPurposeCodes(List<TemplatePrposVO> purposeCodes) {
		this.purposeCodes = purposeCodes;
	}




}
