/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ServStteService.java
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
package ncis.dsb.stts.servstte.service;

import ncis.dsb.stts.servstte.vo.ServStteCvo;
import ncis.dsb.stts.servstte.vo.ServStteSearchVo;

public interface ServStteService {

	public ServStteCvo selectServStteList(ServStteSearchVo searchVo) throws Exception;

}
