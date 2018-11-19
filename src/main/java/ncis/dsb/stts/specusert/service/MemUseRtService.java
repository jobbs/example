/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * MemUseRtService.java
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
 */package ncis.dsb.stts.specusert.service;

import java.util.List;

import ncis.dsb.stts.specusert.vo.CpuUseRtSearchVo;
import ncis.dsb.stts.specusert.vo.MemUseRtVo;

public interface MemUseRtService {

	public List<MemUseRtVo> selectMemUseRtList(CpuUseRtSearchVo searchVo) throws Exception;

	public List<MemUseRtVo> selectTopMemUseRtList(CpuUseRtSearchVo searchVo) throws Exception;
}
