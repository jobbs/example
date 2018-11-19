/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WasSmTimeConectService.java
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

import ncis.dsb.stts.etc.vo.GcamObjSearchVo;
import ncis.dsb.stts.etc.vo.GcamObjVo;
import ncis.dsb.stts.etc.vo.GcamsSearchVo;
import ncis.dsb.stts.etc.vo.WasVstrQtyVo;

public interface WasSmTimeConectService {

	public List<WasVstrQtyVo> selectWasSmTimeConectList(GcamsSearchVo searchVo)throws Exception;
	public List<GcamObjVo> selectJobWebWasDbmsList(GcamObjSearchVo searchVo)throws Exception;
	public List<String> selectWasDailyVstrQtyDateList(GcamsSearchVo searchVo) throws Exception ;
	public List<String> selectWasDailyVstrQtyObjList(GcamsSearchVo searchVo) throws Exception ;
}
