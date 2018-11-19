/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * InsttChngStteService.java
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

import ncis.dsb.stts.use.serv.vo.InsttChngStteSearchVo;
import ncis.dsb.stts.use.serv.vo.InsttChngStteVo;


public interface InsttChngStteService {

	public List<InsttChngStteVo> selectInsttChngStteList(InsttChngStteSearchVo searchVo)throws Exception;



}
