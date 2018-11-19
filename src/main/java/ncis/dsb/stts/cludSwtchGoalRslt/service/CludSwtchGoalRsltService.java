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
import java.util.Map;

import ncis.cmn.entity.StCludSwtchGoalRslt;
import ncis.dsb.stts.cludSwtchGoalRslt.vo.CludSwtchGoalRsltVo;

public interface CludSwtchGoalRsltService {

	public List<CludSwtchGoalRsltVo> selectCludSwtchGoalRsltList()throws Exception;
	public List<Map<String, Object>> selectCludSwtchRsltDtl(List<String> list)throws Exception;
	public List<String> select2011toCurrentYear() throws Exception ;
	public List<Map<String, Object>> selectCludSwtchGoalRsltDtl(List<String> list) throws Exception;
	public void insertCludSwtchGoalRslt(List<StCludSwtchGoalRslt> list) throws Exception;
}
