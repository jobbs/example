/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WasSmTimeConectServiceImpl.java
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
package ncis.dsb.stts.etc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.dsb.stts.etc.dao.WasSmTimeConectDao;
import ncis.dsb.stts.etc.service.WasSmTimeConectService;
import ncis.dsb.stts.etc.vo.GcamObjSearchVo;
import ncis.dsb.stts.etc.vo.GcamObjVo;
import ncis.dsb.stts.etc.vo.GcamsSearchVo;
import ncis.dsb.stts.etc.vo.WasVstrQtyVo;

import org.springframework.stereotype.Service;

@Service("wasSmTimeConectService")
public class WasSmTimeConectServiceImpl implements WasSmTimeConectService {

	@Resource(name="wasSmTimeConectDao")
	private WasSmTimeConectDao wasSmTimeConectDao;

	@Override
	public List<WasVstrQtyVo> selectWasSmTimeConectList(GcamsSearchVo searchVo) throws Exception {
		return wasSmTimeConectDao.selectWasSmTimeConectList(searchVo);
	}
	public List<String> selectWasDailyVstrQtyDateList(GcamsSearchVo searchVo) throws Exception {
		return wasSmTimeConectDao.selectWasDailyVstrQtyDateList(searchVo);
	}
	public List<String> selectWasDailyVstrQtyObjList(GcamsSearchVo searchVo) throws Exception {
		return wasSmTimeConectDao.selectWasDailyVstrQtyObjList(searchVo);
	}
	public List<GcamObjVo> selectJobWebWasDbmsList(GcamObjSearchVo searchVo)throws Exception{
		return wasSmTimeConectDao.selectJobWebWasDbmsList(searchVo);
	}


}
