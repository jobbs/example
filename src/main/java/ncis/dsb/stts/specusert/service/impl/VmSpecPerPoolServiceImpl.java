/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmSpecPerPoolServiceImpl.java
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
import ncis.dsb.stts.specusert.dao.VmSpecPerPoolDao;
import ncis.dsb.stts.specusert.service.VmSpecPerPoolService;
import ncis.dsb.stts.specusert.vo.VmSpecPerPoolSearchVo;
import ncis.dsb.stts.specusert.vo.VmSpecPerPoolVo;
import org.springframework.stereotype.Service;

@Service("vmSpecPerPoolService")
public class VmSpecPerPoolServiceImpl implements VmSpecPerPoolService {

	@Resource(name="vmSpecPerPoolDao")
	private VmSpecPerPoolDao vmSpecPerPoolDao;

	@Override
	public List<VmSpecPerPoolVo> selectVmSpecPerPoolList(VmSpecPerPoolSearchVo searchVo) throws Exception {

		List<VmSpecPerPoolVo> list = null;

		int totalCount = vmSpecPerPoolDao.selectVmSpecPerPoolTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			list = vmSpecPerPoolDao.selectVmSpecPerPoolList(searchVo);
		}

		return list;
	}
}
