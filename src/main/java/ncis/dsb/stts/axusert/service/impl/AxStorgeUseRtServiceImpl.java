/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxStorgeUseRtServiceImpl.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 08. 10
 * @lastmodified2017. 08. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 08. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.axusert.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.dsb.stts.axusert.dao.AxStorgeUseRtDao;
import ncis.dsb.stts.axusert.service.AxStorgeUseRtService;
import ncis.dsb.stts.axusert.vo.AxUseRtSearchVo;
import ncis.dsb.stts.axusert.vo.AxUseRtVo;

import org.springframework.stereotype.Service;

@Service("axStorgeUseRtService")
public class AxStorgeUseRtServiceImpl implements AxStorgeUseRtService {

	@Resource(name="axStorgeUseRtDao")
	private AxStorgeUseRtDao axStorgeUseRtDao;

	@Override
	public List<AxUseRtVo> selectSanUseRtList(AxUseRtSearchVo searchVo) throws Exception {
		return axStorgeUseRtDao.selectSanUseRtList(searchVo);
	}

	@Override
	public List<AxUseRtVo> selectTopSanUseRtList(AxUseRtSearchVo searchVo) throws Exception {
		return axStorgeUseRtDao.selectTopSanUseRtList(searchVo);
	}
}
