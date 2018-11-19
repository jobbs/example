/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxLogService.java
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
 * 2017. 08. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.log.axLog.service;

import java.util.List;

import ncis.dsb.stts.log.axLog.vo.AxLogSearchVo;
import ncis.dsb.stts.log.axLog.vo.AxLogVo;

public interface AxLogService {

	public List<AxLogVo> selectAxLogList(AxLogSearchVo searchVo) throws Exception;

}
