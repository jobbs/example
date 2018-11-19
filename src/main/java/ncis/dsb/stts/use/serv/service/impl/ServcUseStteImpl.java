/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ServcUseStteImpl.java
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
import ncis.dsb.stts.use.serv.dao.ServcUseStteDao;
import ncis.dsb.stts.use.serv.service.ServcUseStteService;
import ncis.dsb.stts.use.serv.vo.ServcUseStteSearchVo;
import ncis.dsb.stts.use.serv.vo.ServcUseStteVo;
import org.springframework.stereotype.Service;

@Service("servcUseStteService")
public class ServcUseStteImpl implements ServcUseStteService {

	@Resource(name="servcUseStteDao")
	private ServcUseStteDao servcUseStteDao;

	/**
	 * 클라우드 서비스 이용 현황(가상서버)
	 * */
	@Override
	public List<ServcUseStteVo> selectServcUseStteList(ServcUseStteSearchVo searchVo) throws Exception {
		List<ServcUseStteVo> list = null;


		list = servcUseStteDao.selectServcUseStteList(searchVo);
		searchVo.getPaginationInfo().setTotalRecordCount(list.size());	// 페이지 처리위한 count


		return list;


	}

	/**
	 * 클라우드 서비스 이용 현황(자동확장)
	 * */
	@Override
	public List<ServcUseStteVo> selectServcUseStteAtmSclList(ServcUseStteSearchVo searchVo) throws Exception {
		List<ServcUseStteVo> list = null;

		list = servcUseStteDao.selectServcUseStteAtmSclList(searchVo);

		return list;
	}

}
