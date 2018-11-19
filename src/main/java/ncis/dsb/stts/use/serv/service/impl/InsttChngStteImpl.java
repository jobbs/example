/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * InsttChngStteImpl.java
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
import ncis.dsb.stts.use.serv.dao.InsttChngStteDao;
import ncis.dsb.stts.use.serv.service.InsttChngStteService;
import ncis.dsb.stts.use.serv.vo.InsttChngStteSearchVo;
import ncis.dsb.stts.use.serv.vo.InsttChngStteVo;
import org.springframework.stereotype.Service;

@Service("insttChngStteService")
public class InsttChngStteImpl implements InsttChngStteService {

	@Resource(name="insttChngStteDao")
	private InsttChngStteDao insttChngStteDao;

	/**
	 * 기관별 변동 현황
	 * */
	@Override
	public List<InsttChngStteVo> selectInsttChngStteList(InsttChngStteSearchVo searchVo) throws Exception {

		List<InsttChngStteVo> list = null;
		list = insttChngStteDao.selectInsttChngStteList(searchVo);
		searchVo.getPaginationInfo().setTotalRecordCount(list.size());	// 페이지 처리위한 count


		return list;


	}

}
