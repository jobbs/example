/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * RsrcUseStteImpl.java
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

package ncis.dsb.stts.rsrcuse.service.impl;

import java.util.List;
import javax.annotation.Resource;
import ncis.dsb.stts.rsrcuse.dao.RsrcUseStteDao;
import ncis.dsb.stts.rsrcuse.service.RsrcUseStteService;
import ncis.dsb.stts.rsrcuse.vo.RsrcUseStteSearchVo;
import ncis.dsb.stts.rsrcuse.vo.RsrcUseStteVo;
import org.springframework.stereotype.Service;

@Service("rsrcUseStteService")
public class RsrcUseStteImpl implements RsrcUseStteService {


	@Resource(name="rsrcUseStteDao")
	private RsrcUseStteDao rsrcUseStteDao;

	/**
	 * 자원 사용 현황-기간별 조회
	 * */
	@Override
	public List<RsrcUseStteVo> selectRsrcUseStteList(RsrcUseStteSearchVo searchVo) throws Exception {

		List<RsrcUseStteVo> list = null;
		list = rsrcUseStteDao.selecRsrcUseStteList(searchVo);

		//if( totalCount > 0 ) {
		searchVo.getPaginationInfo().setTotalRecordCount(list.size());	// 페이지 처리위한 count

		//}
		return list;


	}

}
