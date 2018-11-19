/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmSpecPerPoolService.java
 *
 * @author 이권기
 * @lastmodifier 이권기
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   이권기         v1.0             최초생성
 *
 */
package ncis.dsb.stts.specusert.service;

import java.util.List;

import ncis.dsb.stts.specusert.vo.VmSpecPerPoolSearchVo;
import ncis.dsb.stts.specusert.vo.VmSpecPerPoolVo;

public interface VmSpecPerPoolService {

	public List<VmSpecPerPoolVo> selectVmSpecPerPoolList(VmSpecPerPoolSearchVo searchVo) throws Exception;
}
