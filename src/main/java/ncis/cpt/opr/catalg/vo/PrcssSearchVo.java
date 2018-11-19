/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PrcssSearchVo.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 9. 30.
 * @lastmodified 2016. 9. 30.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 30.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.vo;

import ncis.cmn.vo.CommonSearchVo;

/**
 * @author 이화영
 *
 */
public class PrcssSearchVo extends CommonSearchVo {

	private String searchPrpcssNm;  /* 프로세스명 */

	public String getSearchPrpcssNm() {
		return searchPrpcssNm;
	}

	public void setSearchPrpcssNm(String searchPrpcssNm) {
		this.searchPrpcssNm = searchPrpcssNm;
	}




}
