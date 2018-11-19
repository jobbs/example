/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * GovDeptResStteServiceImpl.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 17
 * @lastmodified2016. 10. 17
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 17   양정순         v1.0             최초생성
 *
 */

package ncis.dsb.stts.res.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.dsb.stts.res.dao.GovDeptResStteDao;
import ncis.dsb.stts.res.service.GovDeptResStteService;
import ncis.dsb.stts.res.vo.GovDeptResStteCvo;
import ncis.dsb.stts.res.vo.GovDeptResStteSearchVo;
import ncis.dsb.stts.res.vo.GovDeptResStteVo;

import org.springframework.stereotype.Service;

@Service("govDeptResStteService")
public class GovDeptResStteServiceImpl implements GovDeptResStteService {

	@Resource(name="govDeptResStteDao")
	private GovDeptResStteDao govDeptResStteDao;

	/**
	 * 부처 자원현황
	 * */
	@Override
	public GovDeptResStteCvo selectGovDeptResList(GovDeptResStteSearchVo searchVo) throws Exception {
		GovDeptResStteCvo govDeptResStteCvo = new GovDeptResStteCvo();
		govDeptResStteCvo.setGovDeptResInfoVo(govDeptResStteDao.selectGovDeptResInfo(searchVo));
		govDeptResStteCvo.setGovAxCntVo(govDeptResStteDao.selectAxCnt(searchVo));

		List<GovDeptResStteVo> list = null;
		list = govDeptResStteDao.selectGovDeptResList(searchVo);
		govDeptResStteCvo.setGvDeptResStteList(list);
		searchVo.getPaginationInfo().setTotalRecordCount(list.size());

		return govDeptResStteCvo;
	}

}
