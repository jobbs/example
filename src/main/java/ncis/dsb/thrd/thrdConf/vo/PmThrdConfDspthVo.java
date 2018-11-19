/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * PmThrdConfDspthVo.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   김동훈         v1.0             최초생성
 *
 */
package ncis.dsb.thrd.thrdConf.vo;


public class PmThrdConfDspthVo extends PmThrdConfSearchVo {


	private String eqpAuthrDspthYn;
	private String dspthTrgtId;
	private String dspthGrdCd;
	private String dspthTyCd;

	public String getEqpAuthrDspthYn() {
		return eqpAuthrDspthYn;
	}
	public void setEqpAuthrDspthYn(String eqpAuthrDspthYn) {
		this.eqpAuthrDspthYn = eqpAuthrDspthYn;
	}
	public String getDspthTrgtId() {
		return dspthTrgtId;
	}
	public void setDspthTrgtId(String dspthTrgtId) {
		this.dspthTrgtId = dspthTrgtId;
	}
	public String getDspthGrdCd() {
		return dspthGrdCd;
	}
	public void setDspthGrdCd(String dspthGrdCd) {
		this.dspthGrdCd = dspthGrdCd;
	}
	public String getDspthTyCd() {
		return dspthTyCd;
	}
	public void setDspthTyCd(String dspthTyCd) {
		this.dspthTyCd = dspthTyCd;
	}
}
