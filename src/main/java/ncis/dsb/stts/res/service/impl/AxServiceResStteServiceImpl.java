/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxNodeResStteServiceImpl.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 05. 17
 * @lastmodified2017. 05. 17
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 05. 17   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.res.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import ncis.dsb.stts.res.dao.AxServiceResStteDao;
import ncis.dsb.stts.res.service.AxServiceResStteService;
import ncis.dsb.stts.res.vo.AxServiceResSearchVo;
import ncis.dsb.stts.res.vo.AxServiceResStteVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("axServiceResStteService")
public class AxServiceResStteServiceImpl implements AxServiceResStteService {

	private final Logger logger = LoggerFactory.getLogger(AxServiceResStteServiceImpl.class);
	@Resource(name="axServiceResStteDao")
	private AxServiceResStteDao axServiceResStteDao;

	/**
	 * 서비스 자원현황
	 * */
	@Override
	public List<AxServiceResStteVo> selectAxServiceResStteList(AxServiceResSearchVo searchVo) throws Exception {
		List<AxServiceResStteVo> list = null;
		list = axServiceResStteDao.selectAxServiceResStteList(searchVo);
		searchVo.getPaginationInfo().setTotalRecordCount(list.size());
		return list;
	}


	/**
	 * 자원 사용률
	 */
	@Override
	public List<Map<String,String>> selectAxServiceTimeResUseRtPivot(AxServiceResSearchVo searchVo)
			throws Exception {
		List<Map<String,String>> podList = selectAxServiceResSttePodList(searchVo);
		if(podList.size() <= 0){
			podList = new ArrayList<Map<String,String>>();
		}
		searchVo.setPodList(podList);
		List<Map<String,String>> list=null;
		list = new ArrayList<Map<String,String>>();
		list = axServiceResStteDao.selectAxServiceTimeResUseRtPivot(searchVo);

		logger.debug("===================searchVo.getColctCd()"+searchVo.getColctCd());

		return list;
	}


	/**
	 * PodList
	 */
	public List<Map<String,String>> selectAxServiceResSttePodList(AxServiceResSearchVo searchVo)
			throws Exception {
		return axServiceResStteDao.selectAxServiceResSttePodList(searchVo);
	}
}
