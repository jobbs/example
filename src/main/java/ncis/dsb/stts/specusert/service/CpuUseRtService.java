/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * CpuUseRtService.java
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
package ncis.dsb.stts.specusert.service;

import java.util.List;

import ncis.dsb.stts.specusert.vo.CpuUseRtSearchVo;
import ncis.dsb.stts.specusert.vo.MemUseRtVo;

public interface CpuUseRtService {

	public List<MemUseRtVo> selectCpuUseRtList(CpuUseRtSearchVo searchVo) throws Exception;

	public List<MemUseRtVo> selectTopCpuUseRtList(CpuUseRtSearchVo searchVo) throws Exception;
}
