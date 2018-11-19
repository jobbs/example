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
package ncis.dsb.stts.etc.service;

import java.util.List;

import ncis.dsb.stts.etc.vo.DbmsSpaceUseRtVo;
import ncis.dsb.stts.etc.vo.GcamsSearchVo;

public interface DbmsSpaceUseRtService {

	public List<DbmsSpaceUseRtVo> selectDbmsSpaceUseRtList(GcamsSearchVo searchVo) throws Exception;
	public List<String> selectDbmsSpaceUseRtDateList(GcamsSearchVo searchVo) throws Exception;
	public List<String> selectDbmsSpaceUseRtObjList(GcamsSearchVo searchVo) throws Exception;
}
