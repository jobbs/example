/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxMemUseRtServiceImpl.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 10. 10
 * @lastmodified2017. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 10. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.axusert.service.impl;

import java.util.List;
import javax.annotation.Resource;
import ncis.dsb.stts.axusert.dao.AxMemUseRtDao;
import ncis.dsb.stts.axusert.service.AxMemUseRtService;
import ncis.dsb.stts.axusert.vo.AxUseRtSearchVo;
import ncis.dsb.stts.axusert.vo.AxUseRtVo;

import org.springframework.stereotype.Service;

@Service("axMemUseRtService")
public class AxMemUseRtServiceImpl implements AxMemUseRtService {

	@Resource(name="axMemUseRtDao")
	private AxMemUseRtDao axMemUseRtDao;

	/* 메모리사용률 조회
	 */

	@Override
	public List<AxUseRtVo> selectAxMemUseRtList(AxUseRtSearchVo searchVo) throws Exception {
		return axMemUseRtDao.selectAxMemUseRtList(searchVo);
	}

	/* 최빈시 메모리 사용률 조회
	 * @see ncis.dsb.stts.specusert.service.MemUseRtService#selectTopMemUseRtList(ncis.dsb.stts.specusert.vo.CpuUseRtSearchVo)
	 */
	@Override
	public List<AxUseRtVo> selectAxTopMemUseRtList(AxUseRtSearchVo searchVo) throws Exception {
		return axMemUseRtDao.selectAxTopMemUseRtList(searchVo);
	}
}
