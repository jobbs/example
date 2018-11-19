/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * InsttUseStteImpl.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   양정순         v1.0             최초생성
 *
 */


package ncis.dsb.stts.use.serv.service.impl;

import java.util.List;
import javax.annotation.Resource;
import ncis.dsb.stts.use.serv.dao.InsttUseStteDao;
import ncis.dsb.stts.use.serv.service.InsttUseStteService;
import ncis.dsb.stts.use.serv.vo.InsttUseStteSearchVo;
import ncis.dsb.stts.use.serv.vo.InsttUseStteVo;
import org.springframework.stereotype.Service;

@Service("insttUseStteService")
public class InsttUseStteImpl implements InsttUseStteService {

	@Resource(name="insttUseStteDao")
	private InsttUseStteDao insttUseStteDao;

	/**
	 * 기관별 이용 현황
	 * */
	@Override
	public List<InsttUseStteVo> selectInsttUseStteList(InsttUseStteSearchVo searchVo) throws Exception {
		List<InsttUseStteVo> list = null;

		list = insttUseStteDao.selectInsttUseStteList(searchVo);
		searchVo.getPaginationInfo().setTotalRecordCount(list.size());	// 페이지 처리위한 count


		return list;

	}


	/**
	 * 기관별 이용 현황
	 * */
	@Override
	public List<InsttUseStteVo> selectInsttUseStteAtmSclList(InsttUseStteSearchVo searchVo) throws Exception {
		List<InsttUseStteVo> list = null;
		list = insttUseStteDao.selectInsttUseStteAtmSclList(searchVo);
		return list;
	}


}
