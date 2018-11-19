/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UnitJobSearchVo.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 25.
 * @lastmodified 2016. 10. 25.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 25.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.vo;

import java.math.BigDecimal;

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 김봉민
 *
 */
public class UnitJobSearchVo extends CommonSearchVo {

	private int procssSeq;			/* 프로세스 SEQ*/
	private String uJobId;			/* 단위 업무 ID */
	private int uJobSeq;			/* 단위 업무 일련번호 */
	private String uJobNm;			/* 단위 업무 명 */
	private String uJobDc;			/* 단위 업무 설명 */
	private String uJobTyCd;		/* 단위 업무 유형 코드 */
	private String intfcUrl;		/* 인터페이스  URL  */
	private String intfcParamtr;	/* 인터페이스 파리미터 */
	private String intfcFnctTyCd;	/* 인터페이스 함수 유형 코드 */
	private BigDecimal lowProcssSeq;/* 하위 프로세스 SEQ */

	private BigDecimal uJobRelateSeq;/* 단위업무 관계 SEQ */

	public int getProcssSeq() {
		return procssSeq;
	}
	public void setProcssSeq(int procssSeq) {
		this.procssSeq = procssSeq;
	}
	public String getuJobId() {
		return uJobId;
	}
	public void setuJobId(String uJobId) {
		this.uJobId = uJobId;
	}
	public int getuJobSeq() {
		return uJobSeq;
	}
	public void setuJobSeq(int uJobSeq) {
		this.uJobSeq = uJobSeq;
	}
	public String getuJobNm() {
		return uJobNm;
	}
	public void setuJobNm(String uJobNm) {
		this.uJobNm = uJobNm;
	}
	public String getuJobDc() {
		return uJobDc;
	}
	public void setuJobDc(String uJobDc) {
		this.uJobDc = uJobDc;
	}
	public String getuJobTyCd() {
		return uJobTyCd;
	}
	public void setuJobTyCd(String uJobTyCd) {
		this.uJobTyCd = uJobTyCd;
	}
	public String getIntfcUrl() {
		return intfcUrl;
	}
	public void setIntfcUrl(String intfcUrl) {
		this.intfcUrl = intfcUrl;
	}
	public String getIntfcParamtr() {
		return intfcParamtr;
	}
	public void setIntfcParamtr(String intfcParamtr) {
		this.intfcParamtr = intfcParamtr;
	}
	public String getIntfcFnctTyCd() {
		return intfcFnctTyCd;
	}
	public void setIntfcFnctTyCd(String intfcFnctTyCd) {
		this.intfcFnctTyCd = intfcFnctTyCd;
	}
	public BigDecimal getLowProcssSeq() {
		return lowProcssSeq;
	}
	public void setLowProcssSeq(BigDecimal lowProcssSeq) {
		this.lowProcssSeq = lowProcssSeq;
	}
	public BigDecimal getuJobRelateSeq() {
		return uJobRelateSeq;
	}
	public void setuJobRelateSeq(BigDecimal uJobRelateSeq) {
		this.uJobRelateSeq = uJobRelateSeq;
	}

}
