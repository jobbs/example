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

import ncis.dsb.stts.res.dao.AxNodeResStteDao;
import ncis.dsb.stts.res.service.AxNodeResStteService;
import ncis.dsb.stts.res.vo.AxNodeResSearchVo;
import ncis.dsb.stts.res.vo.AxNodeResStteVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("axNodeResStteService")
public class AxNodeResStteServiceImpl implements AxNodeResStteService {

	private final Logger logger = LoggerFactory.getLogger(AxNodeResStteServiceImpl.class);
	@Resource(name="axNodeResStteDao")
	private AxNodeResStteDao axNodeResStteDao;

	/**
	 * 노드 자원현황
	 * */
	@Override
	public List<AxNodeResStteVo> selectAxNodeResStteList(AxNodeResSearchVo searchVo) throws Exception {
		List<AxNodeResStteVo> list = null;
		list = axNodeResStteDao.selectAxNodeResStteList(searchVo);
		searchVo.getPaginationInfo().setTotalRecordCount(list.size());
		return list;
	}


	/**
	 * 자원 사용률
	 */
	@Override
	public List<Map<String,String>> selectAxNodeTimeResUseRtPivot(AxNodeResSearchVo searchVo)
			throws Exception {

		List<Map<String,String>> nodeList = selectAxNodeResStteNodeList(searchVo);
		if(nodeList.size() <= 0){
			nodeList = new ArrayList<Map<String,String>>();
		}
		searchVo.setNodeList(nodeList);
		logger.debug("===================searchVo.getColctCd()"+searchVo.getColctCd()+"===================searchVo.getNodeList()"+searchVo.getNodeList());
		List<Map<String,String>> list =null;
		list = axNodeResStteDao.selectAxNodeTimeResUseRtPivot(searchVo);
		return list;
	}


	/**
	 * VmList
	 */
	public List<Map<String,String>> selectAxNodeResStteNodeList(AxNodeResSearchVo searchVo)
			throws Exception {
		List<Map<String,String>> nodeList = axNodeResStteDao.selectAxNodeResStteNodeList(searchVo);
		return nodeList;

	}
}
