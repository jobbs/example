/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ServcUseStteService.java
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
package ncis.dsb.stts.use.serv.service;

import java.util.List;

import ncis.dsb.stts.use.serv.vo.ServcUseStteSearchVo;
import ncis.dsb.stts.use.serv.vo.ServcUseStteVo;

public interface ServcUseStteService {

	public List<ServcUseStteVo> selectServcUseStteList(ServcUseStteSearchVo searchVo)throws Exception;

	public List<ServcUseStteVo> selectServcUseStteAtmSclList(ServcUseStteSearchVo searchVo)throws Exception;



}
