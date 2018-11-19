/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxCpuUseRtServiceImpl.java
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
import ncis.dsb.stts.axusert.dao.AxCpuUseRtDao;
import ncis.dsb.stts.axusert.service.AxCpuUseRtService;
import ncis.dsb.stts.axusert.vo.AxUseRtSearchVo;
import ncis.dsb.stts.axusert.vo.AxUseRtVo;

import org.springframework.stereotype.Service;

@Service("axCpuUseRtService")
public class AxCpuUseRtServiceImpl implements AxCpuUseRtService {

	@Resource(name="axCpuUseRtDao")
	private AxCpuUseRtDao axCpuUseRtDao;

	@Override
	public List<AxUseRtVo> selectAxCpuUseRtList(AxUseRtSearchVo searchVo) throws Exception {
		return axCpuUseRtDao.selectAxCpuUseRtList(searchVo);
	}

	@Override
	public List<AxUseRtVo> selectAxTopCpuUseRtList(AxUseRtSearchVo searchVo) throws Exception {
		return axCpuUseRtDao.selectAxTopCpuUseRtList(searchVo);
	}
}
