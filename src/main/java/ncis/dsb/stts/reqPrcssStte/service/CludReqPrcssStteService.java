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

import ncis.dsb.stts.reqPrcssStte.vo.ReqPrcssStteSearchVo;
import ncis.dsb.stts.reqPrcssStte.vo.ReqPrcssStteVo;

public interface CludReqPrcssStteService {


	public List<ReqPrcssStteVo> selectCludReqPrcssStteList(ReqPrcssStteSearchVo searchVo) throws Exception;
	public List<ReqPrcssStteVo> selectCludReqPrcssStteDtl(ReqPrcssStteSearchVo searchVo) throws Exception;
	public void insertCludReqPrcssStte(List<ReqPrcssStteVo> list) throws Exception;
	public void updateCludReqPrcssStte(List<ReqPrcssStteVo> list) throws Exception;
	public void deleteCludReqPrcssStte(ReqPrcssStteVo list) throws Exception;

	public List<ReqPrcssStteVo> selectSanWithdrawStte(ReqPrcssStteSearchVo searchVo) throws Exception;




}
