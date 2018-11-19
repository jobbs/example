/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * CpuUseRtServiceImpl.java
 *
 * @author 이권기
 * @lastmodifier 이권기
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   이권기         v1.0             최초생성
 *
 */
package ncis.dsb.stts.specusert.service.impl;

import java.util.List;
import javax.annotation.Resource;
import ncis.dsb.stts.specusert.dao.CpuUseRtDao;
import ncis.dsb.stts.specusert.service.CpuUseRtService;
import ncis.dsb.stts.specusert.vo.CpuUseRtSearchVo;
import ncis.dsb.stts.specusert.vo.MemUseRtVo;

import org.springframework.stereotype.Service;

@Service("cpuUseRtService")
public class CpuUseRtServiceImpl implements CpuUseRtService {

	@Resource(name="cpuUseRtDao")
	private CpuUseRtDao cpuUseRtDao;

	@Override
	public List<MemUseRtVo> selectCpuUseRtList(CpuUseRtSearchVo searchVo) throws Exception {
		return cpuUseRtDao.selectCpuUseRtList(searchVo);
	}

	@Override
	public List<MemUseRtVo> selectTopCpuUseRtList(CpuUseRtSearchVo searchVo) throws Exception {
		return cpuUseRtDao.selectTopCpuUseRtList(searchVo);
	}
}
