/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * DbmsSpaceUseRtService.java
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
package ncis.dsb.stts.cludSwtchGoalRslt.service;

import java.util.List;

import ncis.cmn.vo.CommonSearchVo;
import ncis.dsb.stts.cludSwtchGoalRslt.vo.InsttSwtchStteVo;

public interface InsttSwtchStteService {

	public List<InsttSwtchStteVo> selectInsttSwtchStteList(CommonSearchVo vo)throws Exception;
	public void insertCludReqPrcssStte(List<InsttSwtchStteVo> list)throws Exception;
}
