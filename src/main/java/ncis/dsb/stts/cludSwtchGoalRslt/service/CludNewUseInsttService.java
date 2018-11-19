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

import ncis.cmn.entity.StYrCludNwUseInstitution;
import ncis.dsb.stts.cludSwtchGoalRslt.vo.CludNewUseInsttVo;
public interface CludNewUseInsttService {

	public List<CludNewUseInsttVo> selectCludNewUseInsttList(StYrCludNwUseInstitution searchVo)throws Exception;
	public List<CludNewUseInsttVo> selectCludNewUseInsttDtl(StYrCludNwUseInstitution vo)throws Exception;
	public List<String> selectRegPosblYear()throws Exception;
	public void insertCludNewUseInstt( List<StYrCludNwUseInstitution> list)throws Exception;
	public void updateCludNewUseInstt( List<StYrCludNwUseInstitution> list)throws Exception;
	public void deleteCludNewUseInstt( StYrCludNwUseInstitution vo)throws Exception;
}
