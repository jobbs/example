/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ThrdStndIdxSearchVo.java
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

import ncis.cmn.vo.CommonSearchVo;

public class ThrdStndIdxSearchVo extends CommonSearchVo {

	//프로파일명
	private String profNm;
	//내용
	private String dc;

	private Long profId;

	public Long getProfId() {
		return profId;
	}
	public void setProfId(Long profId) {
		this.profId = profId;
	}
	public String getDc() {
		return dc;
	}
	public void setDc(String dc) {
		this.dc = dc;
	}
	public String getProfNm() {
		return profNm;
	}
	public void setProfNm(String profNm) {
		this.profNm = profNm;
	}

}
