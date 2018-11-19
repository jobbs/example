/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * PmThrdConfPSearchVo.java
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


public class PmThrdConfPSearchVo extends PmThrdConfSearchVo {
	private String trgtSrvrClCd;
	private Long thresTrgtSrvrSeq;
	public String getTrgtSrvrClCd() {
		return trgtSrvrClCd;
	}
	public void setTrgtSrvrClCd(String trgtSrvrClCd) {
		this.trgtSrvrClCd = trgtSrvrClCd;
	}
	public Long getThresTrgtSrvrSeq() {
		return thresTrgtSrvrSeq;
	}
	public void setThresTrgtSrvrSeq(Long thresTrgtSrvrSeq) {
		this.thresTrgtSrvrSeq = thresTrgtSrvrSeq;
	}


}
