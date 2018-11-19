/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxServcUsefulRngService.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 08. 10
 * @lastmodified2017. 08. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 08. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.axusert.service;

import java.util.List;

import ncis.dsb.stts.axusert.vo.AxServcUsefulMemVo;
import ncis.dsb.stts.axusert.vo.AxServcUsefulRngSearchVo;
import ncis.dsb.stts.axusert.vo.AxServcUsefulSanVo;

public interface AxServcUsefulRngService {

	public List<AxServcUsefulMemVo> selectMemCntList(AxServcUsefulRngSearchVo searchVo) throws Exception;

	public List<AxServcUsefulSanVo> selectSanCntList(AxServcUsefulRngSearchVo searchVo) throws Exception;

	public List<AxServcUsefulMemVo> selectMemCntRtList(AxServcUsefulRngSearchVo searchVo) throws Exception;

	public List<AxServcUsefulSanVo> selectSanCntRtList(AxServcUsefulRngSearchVo searchVo) throws Exception;



}
