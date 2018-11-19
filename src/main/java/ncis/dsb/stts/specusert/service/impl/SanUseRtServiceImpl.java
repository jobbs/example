/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * SanUseRtServiceImpl.java
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
package ncis.dsb.stts.specusert.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.dsb.stts.specusert.dao.SanUseRtDao;
import ncis.dsb.stts.specusert.service.SanUseRtService;
import ncis.dsb.stts.specusert.vo.CpuUseRtSearchVo;
import ncis.dsb.stts.specusert.vo.MemUseRtVo;

import org.springframework.stereotype.Service;

@Service("sanUseRtService")
public class SanUseRtServiceImpl implements SanUseRtService {

	@Resource(name="sanUseRtDao")
	private SanUseRtDao sanUseRtDao;

	@Override
	public List<MemUseRtVo> selectSanUseRtList(CpuUseRtSearchVo searchVo) throws Exception {
		return sanUseRtDao.selectSanUseRtList(searchVo);
	}

	@Override
	public List<MemUseRtVo> selectTopSanUseRtList(CpuUseRtSearchVo searchVo) throws Exception {
		return sanUseRtDao.selectTopSanUseRtList(searchVo);
	}
}
