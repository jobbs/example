/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RnSRoutingScript.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2017. 1. 2.
 * @lastmodified 2017. 1. 2.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 1. 2.     selim         v1.0             최초생성
 *
 */
package ncis.cmn.entity;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author 최진호
 *
 */
public class RnSRoutingScript {

	private Long sRoutingScriptSeq;

	@NotEmpty(message="운영체제유형은 필수항목입니다.")
	private String osTyCd;

	@NotEmpty(message="운영체제버전은 필수항목입니다.")
	@Size(max=16, message="운영체제의 최대 길이는 최대 16자까지 허용합니다.")
	private String osVer;

	@NotEmpty(message="실행스크립트는 필수항목입니다.")
	@Size(max=4000, message="운영체제의 최대 길이는 최대 4000자까지 허용합니다.")
	private String script;

	@Size(max=4000, message="설명의 최대 길이는 최대 4000자까지 허용합니다.")
	private String dc;

	private String useYn;

	private Date regDttm;

	private String regUserId;

	private Date updtDttm;

	private String updtUserId;

	/**
	 * @return the sRoutingScriptSeq
	 */
	public Long getsRoutingScriptSeq() {
		return sRoutingScriptSeq;
	}

	/**
	 * @param sRoutingScriptSeq the sRoutingScriptSeq to set
	 */
	public void setsRoutingScriptSeq(Long sRoutingScriptSeq) {
		this.sRoutingScriptSeq = sRoutingScriptSeq;
	}

	/**
	 * @return the osTyCd
	 */
	public String getOsTyCd() {
		return osTyCd;
	}

	/**
	 * @param osTyCd the osTyCd to set
	 */
	public void setOsTyCd(String osTyCd) {
		this.osTyCd = osTyCd;
	}

	/**
	 * @return the osVer
	 */
	public String getOsVer() {
		if(null == osVer){
			return null;
		}
		return osVer.trim();
	}

	/**
	 * @param osVer the osVer to set
	 */
	public void setOsVer(String osVer) {
		this.osVer = osVer;
	}

	/**
	 * @return the script
	 */
	public String getScript() {
		return script;
	}

	/**
	 * @param script the script to set
	 */
	public void setScript(String script) {
		this.script = script;
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
	 * @return the useYn
	 */
	public String getUseYn() {
		return useYn;
	}

	/**
	 * @param useYn the useYn to set
	 */
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	/**
	 * @return the regDttm
	 */
	public Date getRegDttm() {
		return regDttm;
	}

	/**
	 * @param regDttm the regDttm to set
	 */
	public void setRegDttm(Date regDttm) {
		this.regDttm = regDttm;
	}

	/**
	 * @return the regUserId
	 */
	public String getRegUserId() {
		return regUserId;
	}

	/**
	 * @param regUserId the regUserId to set
	 */
	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}

	/**
	 * @return the updtDttm
	 */
	public Date getUpdtDttm() {
		return updtDttm;
	}

	/**
	 * @param updtDttm the updtDttm to set
	 */
	public void setUpdtDttm(Date updtDttm) {
		this.updtDttm = updtDttm;
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



}
