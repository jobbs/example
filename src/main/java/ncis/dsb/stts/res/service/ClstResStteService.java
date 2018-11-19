/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ClstResStteService.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 17
 * @lastmodified2016. 10. 17
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 17   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.res.service;

import ncis.dsb.stts.res.vo.ClstResStteCvo;
import ncis.dsb.stts.res.vo.ClstResStteSearchVo;

public interface ClstResStteService {


	public ClstResStteCvo selectClstResStteList(ClstResStteSearchVo SearchVo) throws Exception;


}
