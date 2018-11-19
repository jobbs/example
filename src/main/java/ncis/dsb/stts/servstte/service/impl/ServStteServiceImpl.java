/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ServStteServiceImpl.java
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
package ncis.dsb.stts.servstte.service.impl;

import javax.annotation.Resource;

import ncis.dsb.stts.servstte.dao.ServStteDao;
import ncis.dsb.stts.servstte.service.ServStteService;
import ncis.dsb.stts.servstte.vo.ServStteCvo;
import ncis.dsb.stts.servstte.vo.ServStteSearchVo;

import org.springframework.stereotype.Service;

@Service("servStteService")
public class ServStteServiceImpl implements ServStteService {

	@Resource(name="servStteDao")
	private ServStteDao servStteDao;

	/**
	 * 서버현황 조회
	 * */
	@Override
	public ServStteCvo selectServStteList(ServStteSearchVo searchVo) throws Exception {
		ServStteCvo servStteCvo = new ServStteCvo();

		servStteCvo.setCntServStteList(servStteDao.selectCntServStteList(searchVo));
		servStteCvo.setPmStteList(servStteDao.selectPmStteList(searchVo));
		servStteCvo.setVmStteList(servStteDao.selectVmStteList(searchVo));
		servStteCvo.setVrlzStteList(servStteDao.selectVrlzStteList(searchVo));
		servStteCvo.setCloudJobList(servStteDao.selectCloudJobList(searchVo));

		return servStteCvo;
	}

}
