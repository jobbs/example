/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * PmThrdConfCvo.java
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

import java.util.List;

import ncis.cmn.entity.CmUsr;

public class PmThrdConfCvo extends PmThrdConfPSearchVo{

	private String eqpAuthrDspthYn;
	private List<String> dspthTyCdList;
	private List<String> dspthGrdCdList;
	private List<CmUsr> dspthTrgtList;
	private String trgtSrvrClCd;
	private Long thresTrgtSrvrSeq;
	private String gubun;//리전/존/망/풀/클러스터/물리서버/가상서버를 구분


	public List<String> getDspthTyCdList() {
		return dspthTyCdList;
	}
	public void setDspthTyCdList(List<String> dspthTyCdList) {
		this.dspthTyCdList = dspthTyCdList;
	}
	public List<String> getDspthGrdCdList() {
		return dspthGrdCdList;
	}
	public void setDspthGrdCdList(List<String> dspthGrdCdList) {
		this.dspthGrdCdList = dspthGrdCdList;
	}
	public List<CmUsr> getDspthTrgtList() {
		return dspthTrgtList;
	}
	public void setDspthTrgtList(List<CmUsr> dspthTrgtList) {
		this.dspthTrgtList = dspthTrgtList;
	}
	public String getTrgtSrvrClCd() {
		return trgtSrvrClCd;
	}
	public void setTrgtSrvrClCd(String trgtSrvrClCd) {
		this.trgtSrvrClCd = trgtSrvrClCd;
	}
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public Long getThresTrgtSrvrSeq() {
		return thresTrgtSrvrSeq;
	}
	public void setThresTrgtSrvrSeq(Long thresTrgtSrvrSeq) {
		this.thresTrgtSrvrSeq = thresTrgtSrvrSeq;
	}
	public String getEqpAuthrDspthYn() {
		return eqpAuthrDspthYn;
	}
	public void setEqpAuthrDspthYn(String eqpAuthrDspthYn) {
		this.eqpAuthrDspthYn = eqpAuthrDspthYn;
	}

}
