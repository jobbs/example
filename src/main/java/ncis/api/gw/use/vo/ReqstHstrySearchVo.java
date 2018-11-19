/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ReqstHstrySearchVo.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 27.
 * @lastmodified 2016. 10. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 27.     박희택         v1.0             최초생성
 *
 */
package ncis.api.gw.use.vo;

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 박희택
 *
 */
public class ReqstHstrySearchVo extends CommonSearchVo{

	private String useReqId;		// api_gw_user테이블의 _id
	private String reqHstrySysCd; 	// 이력목록의 페이징 처리 값

	/**
	 * @return the useReqId
	 */
	public String getUseReqId() {
		return useReqId;
	}
	/**
	 * @param useReqId the useReqId to set
	 */
	public void setUseReqId(String useReqId) {
		this.useReqId = useReqId;
	}
	/**
	 * @return the reqHstrySysCd
	 */
	public String getReqHstrySysCd() {
		return reqHstrySysCd;
	}
	/**
	 * @param reqHstrySysCd the reqHstrySysCd to set
	 */
	public void setReqHstrySysCd(String reqHstrySysCd) {
		this.reqHstrySysCd = reqHstrySysCd;
	}

}
