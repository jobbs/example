/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmLogService.java
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
package ncis.dsb.stts.log.vmLog.service;

import java.util.List;

import ncis.dsb.stts.log.vmLog.vo.VmLogSearchVo;
import ncis.dsb.stts.log.vmLog.vo.VmLogVo;

public interface VmLogService {

	public List<VmLogVo> selectVmLogList(VmLogSearchVo searchVo) throws Exception;

}
