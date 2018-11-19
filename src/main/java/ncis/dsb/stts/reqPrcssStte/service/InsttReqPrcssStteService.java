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
package ncis.dsb.stts.reqPrcssStte.service;

import java.util.List;

import ncis.dsb.stts.reqPrcssStte.vo.InsttReqPrcssStteSearchVo;
import ncis.dsb.stts.reqPrcssStte.vo.ReqPrcssStteVo;

public interface InsttReqPrcssStteService {


	public List<ReqPrcssStteVo> selectInsttReqPrcssStteList(InsttReqPrcssStteSearchVo searchVo) throws Exception;


}
