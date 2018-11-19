/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxCpuUseRtService.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 10. 10
 * @lastmodified2017. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 10. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.axusert.service;

import java.util.List;

import ncis.dsb.stts.axusert.vo.AxUseRtSearchVo;
import ncis.dsb.stts.axusert.vo.AxUseRtVo;

public interface AxCpuUseRtService {

	public List<AxUseRtVo> selectAxCpuUseRtList(AxUseRtSearchVo searchVo) throws Exception;

	public List<AxUseRtVo> selectAxTopCpuUseRtList(AxUseRtSearchVo searchVo) throws Exception;
}
