/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ClstResStteServiceImpl.java
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

import ncis.dsb.stts.res.dao.ClstResStteDao;
import ncis.dsb.stts.res.service.ClstResStteService;
import ncis.dsb.stts.res.vo.ClstResInfoVo;
import ncis.dsb.stts.res.vo.ClstResStteCvo;
import ncis.dsb.stts.res.vo.ClstResStteSearchVo;

import org.springframework.stereotype.Service;

@Service("clstResStteService")
public class ClstResStteServiceImpl implements ClstResStteService {

	@Resource(name="clstResStteDao")
	private ClstResStteDao clstResStteDao;

	/**
	 * 자원풀 자원현황
	 * */
	@Override
	public ClstResStteCvo selectClstResStteList(ClstResStteSearchVo SearchVo) throws Exception {
		ClstResStteCvo clstResStteCvo = new ClstResStteCvo();

		clstResStteCvo.setPmResInfoVo(clstResStteDao.selectPmResInfo(SearchVo));
		clstResStteCvo.setVmResInfoVo(clstResStteDao.selectVmResInfo(SearchVo));
		clstResStteCvo.setAxCntVo(clstResStteDao.selectAxCnt(SearchVo));

		List<ClstResInfoVo> list = null;
		list = clstResStteDao.selectClstResList(SearchVo);
		clstResStteCvo.setClstResInfoList(list);

		SearchVo.getPaginationInfo().setTotalRecordCount(list.size());	// 페이지 처리위한 count

        return  clstResStteCvo;
	}

}
