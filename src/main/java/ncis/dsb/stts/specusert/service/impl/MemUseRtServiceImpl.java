/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * MemUseRtServiceImpl.java
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
import ncis.dsb.stts.specusert.dao.MemUseRtDao;
import ncis.dsb.stts.specusert.service.MemUseRtService;
import ncis.dsb.stts.specusert.vo.CpuUseRtSearchVo;
import ncis.dsb.stts.specusert.vo.MemUseRtVo;

import org.springframework.stereotype.Service;

@Service("memUseRtService")
public class MemUseRtServiceImpl implements MemUseRtService {

	@Resource(name="memUseRtDao")
	private MemUseRtDao memUseRtDao;

	/* 메모리사용률 조회
	 */
	@Override
	public List<MemUseRtVo> selectMemUseRtList(CpuUseRtSearchVo searchVo) throws Exception {
		return memUseRtDao.selectMemUseRtList(searchVo);
	}

	/* 최빈시 메모리 사용률 조회
	 * @see ncis.dsb.stts.specusert.service.MemUseRtService#selectTopMemUseRtList(ncis.dsb.stts.specusert.vo.CpuUseRtSearchVo)
	 */
	@Override
	public List<MemUseRtVo> selectTopMemUseRtList(CpuUseRtSearchVo searchVo) throws Exception {
		return memUseRtDao.selectTopMemUseRtList(searchVo);
	}
}
