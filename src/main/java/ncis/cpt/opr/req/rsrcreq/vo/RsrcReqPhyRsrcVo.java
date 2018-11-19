/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre> 자원 요청상세_물지자원 </pre>
 *
 * @filename RsrcReqPhyRsrcInfoVo.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.opr.req.rsrcreq.vo;

import java.math.BigDecimal;

import ncis.cmn.entity.RrRsrcReqDtlPRsrc;

public class RsrcReqPhyRsrcVo extends RrRsrcReqDtlPRsrc{

	private String zoneNm;				/* 존명 */
	private String netNm; 				/*망 명*/
	private String rsrcPoolNm;			/*  자원풀 명 */
	private String rsrcReqTyNm;			/*  자원요청유형코드 */
	private RsrcReqClstrPropsListVo rsrcReqClstrPropsListVo; 	/* 자원요청클러스터용도	*/
	private String rsrcReqClstrPropsReqListCd;			/* 자원요청클러스터용도목록 -텍스트*/
	private String rsrcReqClstrPropsReqListNm;			/* 자원요청클러스터용도목록 -텍스트*/

	private String rsrcReqClstrPropsReqListNmTxt;			/* 자원요청클러스터용도목록 -텍스트*/


	private String schRsrcReqNo; /* 검색 전달 */
	private String vrlzSwTyCd;		/* 가상화SW 유형 코드  */
	private String vrlzSwTyNm;		/* 가상화SW 유형 코드명  */
	private String vrlzSwTyVl2;		/* 가상화SW 유형2 코드  */

	private String regionId;	/* 센터 ID */

	private BigDecimal dataCntrSeq;  /* 데이터센터SEQ */
	private String dataCntrNm;    /* 데이터센터명 */

	public String getZoneNm() {
		return zoneNm;
	}

	public void setZoneNm(String zoneNm) {
		this.zoneNm = zoneNm;
	}

	public String getNetNm() {
		return netNm;
	}

	public void setNetNm(String netNm) {
		this.netNm = netNm;
	}

	public String getRsrcPoolNm() {
		return rsrcPoolNm;
	}

	public void setRsrcPoolNm(String rsrcPoolNm) {
		this.rsrcPoolNm = rsrcPoolNm;
	}

	public String getRsrcReqTyNm() {
		return rsrcReqTyNm;
	}

	public void setRsrcReqTyNm(String rsrcReqTyNm) {
		this.rsrcReqTyNm = rsrcReqTyNm;
	}

	public RsrcReqClstrPropsListVo getRsrcReqClstrPropsListVo() {
		return rsrcReqClstrPropsListVo;
	}

	public void setRsrcReqClstrPropsListVo(
			RsrcReqClstrPropsListVo rsrcReqClstrPropsListVo) {
		this.rsrcReqClstrPropsListVo = rsrcReqClstrPropsListVo;
	}

	public String getRsrcReqClstrPropsReqListCd() {
		return rsrcReqClstrPropsReqListCd;
	}

	public void setRsrcReqClstrPropsReqListCd(String rsrcReqClstrPropsReqListCd) {
		this.rsrcReqClstrPropsReqListCd = rsrcReqClstrPropsReqListCd;
	}

	public String getRsrcReqClstrPropsReqListNm() {
		return rsrcReqClstrPropsReqListNm;
	}

	public void setRsrcReqClstrPropsReqListNm(String rsrcReqClstrPropsReqListNm) {
		this.rsrcReqClstrPropsReqListNm = rsrcReqClstrPropsReqListNm;
	}

	public String getSchRsrcReqNo() {
		return schRsrcReqNo;
	}

	public void setSchRsrcReqNo(String schRsrcReqNo) {
		this.schRsrcReqNo = schRsrcReqNo;
	}

	public String getVrlzSwTyCd() {
		return vrlzSwTyCd;
	}

	public void setVrlzSwTyCd(String vrlzSwTyCd) {
		this.vrlzSwTyCd = vrlzSwTyCd;
	}

	public String getVrlzSwTyNm() {
		return vrlzSwTyNm;
	}

	public void setVrlzSwTyNm(String vrlzSwTyNm) {
		this.vrlzSwTyNm = vrlzSwTyNm;
	}

	public String getVrlzSwTyVl2() {
		return vrlzSwTyVl2;
	}

	public void setVrlzSwTyVl2(String vrlzSwTyVl2) {
		this.vrlzSwTyVl2 = vrlzSwTyVl2;
	}

	public String getRsrcReqClstrPropsReqListNmTxt() {
		return rsrcReqClstrPropsReqListNmTxt;
	}

	public void setRsrcReqClstrPropsReqListNmTxt(
			String rsrcReqClstrPropsReqListNmTxt) {
		this.rsrcReqClstrPropsReqListNmTxt = rsrcReqClstrPropsReqListNmTxt;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public BigDecimal getDataCntrSeq() {
		return dataCntrSeq;
	}

	public void setDataCntrSeq(BigDecimal dataCntrSeq) {
		this.dataCntrSeq = dataCntrSeq;
	}

	public String getDataCntrNm() {
		return dataCntrNm;
	}

	public void setDataCntrNm(String dataCntrNm) {
		this.dataCntrNm = dataCntrNm;
	}
}
