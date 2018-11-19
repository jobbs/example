/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SlaRprtService.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 6.
 * @lastmodified 2016. 10. 6.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 6.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.req.slaRprt.service;

import ncis.cpt.opr.req.slaRprt.vo.SlaRprtSearchVo;
import ncis.cpt.opr.req.slaRprt.vo.SlaRprtVo;

/**
 * @author 이화영
 *
 */
public interface SlaRprtService {

	/**
	 * 검색 조건에 해당하는 SLA리포트  조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	SlaRprtVo selectSlaRprt(SlaRprtSearchVo searchVo);



}
