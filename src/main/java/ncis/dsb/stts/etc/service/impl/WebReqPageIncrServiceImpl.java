/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WebVstrServiceImpl.java
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

import ncis.dsb.stts.etc.dao.WebReqPageIncrDao;
import ncis.dsb.stts.etc.service.WebReqPageIncrService;
import ncis.dsb.stts.etc.vo.GcamsSearchVo;
import ncis.dsb.stts.etc.vo.WebReqPageQtyVo;

import org.springframework.stereotype.Service;

@Service("webReqPageIncrService")
public class WebReqPageIncrServiceImpl implements WebReqPageIncrService {

	@Resource(name="webReqPageIncrDao")
	private WebReqPageIncrDao webReqPageIncrDao;

	@Override
	public List<WebReqPageQtyVo> selectWebReqPageIncrList(GcamsSearchVo searchVo) throws Exception {
		return webReqPageIncrDao.selectWebReqPageIncrList(searchVo);
	}
	public List<String> selectWebReqPageIncrDateList(GcamsSearchVo searchVo)throws Exception {
		return webReqPageIncrDao.selectWebReqPageIncrDateList(searchVo);
	}
	public List<String> selectWebReqPageIncrObjList(GcamsSearchVo searchVo)throws Exception {
		return webReqPageIncrDao.selectWebReqPageIncrObjList(searchVo);
	}

}
