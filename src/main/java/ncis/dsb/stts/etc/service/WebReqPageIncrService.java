/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WebVstrService.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   김동훈         v1.0             최초생성
 *
 */
package ncis.dsb.stts.etc.service;

import java.util.List;

import ncis.dsb.stts.etc.vo.GcamsSearchVo;
import ncis.dsb.stts.etc.vo.WebReqPageQtyVo;

public interface WebReqPageIncrService {

	public List<WebReqPageQtyVo> selectWebReqPageIncrList(GcamsSearchVo searchVo) throws Exception;
	public List<String> selectWebReqPageIncrDateList(GcamsSearchVo searchVo)throws Exception ;
	public List<String> selectWebReqPageIncrObjList(GcamsSearchVo searchVo)throws Exception ;
}
