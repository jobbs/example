/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmUsefulRngService.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.specusert.service;

import java.util.List;

import ncis.dsb.stts.specusert.vo.VmUsefulMemVo;
import ncis.dsb.stts.specusert.vo.VmUsefulRngSearchVo;
import ncis.dsb.stts.specusert.vo.VmUsefulSanVo;

public interface VmUsefulRngService {

	public List<VmUsefulMemVo> selectMemCntList(VmUsefulRngSearchVo searchVo) throws Exception;

	public List<VmUsefulSanVo> selectSanCntList(VmUsefulRngSearchVo searchVo) throws Exception;

	public List<VmUsefulMemVo> selectMemCntRtList(VmUsefulRngSearchVo searchVo) throws Exception;

	public List<VmUsefulSanVo> selectSanCntRtList(VmUsefulRngSearchVo searchVo) throws Exception;



}
