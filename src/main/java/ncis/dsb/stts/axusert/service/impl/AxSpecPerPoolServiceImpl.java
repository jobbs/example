/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxSpecPerPoolServiceImpl.java
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
import ncis.dsb.stts.axusert.dao.AxSpecPerPoolDao;
import ncis.dsb.stts.axusert.service.AxSpecPerPoolService;
import ncis.dsb.stts.axusert.vo.AxSpecPerPoolSearchVo;
import ncis.dsb.stts.axusert.vo.AxSpecPerPoolVo;
import org.springframework.stereotype.Service;

@Service("axSpecPerPoolService")
public class AxSpecPerPoolServiceImpl implements AxSpecPerPoolService {

	@Resource(name="axSpecPerPoolDao")
	private AxSpecPerPoolDao axSpecPerPoolDao;

	@Override
	public List<AxSpecPerPoolVo> selectAxSpecPerPoolList(AxSpecPerPoolSearchVo searchVo) throws Exception {

		List<AxSpecPerPoolVo> list = null;

		int totalCount = axSpecPerPoolDao.selectAxSpecPerPoolTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			list = axSpecPerPoolDao.selectAxSpecPerPoolList(searchVo);
		}

		return list;
	}
}
