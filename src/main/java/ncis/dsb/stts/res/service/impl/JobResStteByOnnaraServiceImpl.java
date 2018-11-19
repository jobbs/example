/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * JobResStteByOnnaraServiceImpl.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 10. 17
 * @lastmodified2017. 10. 17
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 10. 17   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.res.service.impl;

import java.util.ArrayList;
import java.util.List;


import java.util.Map;

import javax.annotation.Resource;

import ncis.dsb.stts.res.dao.JobResStteByOnnaraDao;
import ncis.dsb.stts.res.service.JobResStteByOnnaraService;
import ncis.dsb.stts.res.vo.JobResSearchVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("jobResStteByOnnaraService")
public class JobResStteByOnnaraServiceImpl implements JobResStteByOnnaraService {

	private final Logger logger = LoggerFactory.getLogger(JobResStteByOnnaraServiceImpl.class);
	@Resource(name="jobResStteByOnnaraDao")
	private JobResStteByOnnaraDao jobResStteByOnnaraDao;
	/**
	 * VmList
	 */
	public List<Map<String,String>> selectJobResStteByOnnaraVmList(JobResSearchVo searchVo)
			throws Exception {
		return jobResStteByOnnaraDao.selectJobResStteByOnnaraVmList(searchVo);
	}
	/**
	 * 자원 사용률
	 */
	@Override
	public List<Map<String,String>> selectJobTimeResByOnnaraUseRtPivot(JobResSearchVo searchVo)
			throws Exception {
		List<Map<String,String>> vmList = selectJobResStteByOnnaraVmList(searchVo);
		if(vmList.size() <= 0){
			vmList = new ArrayList<Map<String,String>>();
		}
		searchVo.setVmList(vmList);
		List<Map<String,String>> list=null;
		list = jobResStteByOnnaraDao.selectJobTimeResByOnnaraUseRtPivot(searchVo);
		logger.debug("===================searchVo.getColctCd()"+searchVo.getColctCd());
		return list;
	}

	@Override
	public List<Map<String,String>> selectJobTimeResByOnnaraUseRtTop(JobResSearchVo searchVo)
			throws Exception {
		List<Map<String,String>> vmList = selectJobResStteByOnnaraVmList(searchVo);
		if(vmList.size() <= 0){
			vmList = new ArrayList<Map<String,String>>();
		}
		searchVo.setVmList(vmList);
		List<Map<String,String>> list=null;
		list = jobResStteByOnnaraDao.selectJobTimeResByOnnaraUseRtTop(searchVo);
		logger.debug("===================searchVo.getColctCd()"+searchVo.getColctCd());
		return list;
	}

	/**
	 * PodList
	 */
	public List<Map<String,String>> selectJobResStteByOnnaraPodList(JobResSearchVo searchVo)
			throws Exception {
		return jobResStteByOnnaraDao.selectJobResStteByOnnaraPodList(searchVo);
	}
	/**
	 * 자동확장 자원 사용률
	 */
	@Override
	public List<Map<String,String>> selectAxTimeResByOnnaraUseRtPivot(JobResSearchVo searchVo)
			throws Exception {
		List<Map<String,String>> podList = selectJobResStteByOnnaraPodList(searchVo);
		if(podList.size() <= 0){
			podList = new ArrayList<Map<String,String>>();
		}
		searchVo.setPodList(podList);
		List<Map<String,String>> list=null;
		list = jobResStteByOnnaraDao.selectAxTimeResByOnnaraUseRtPivot(searchVo);
		logger.debug("===================searchVo.getColctCd()"+searchVo.getColctCd());
		return list;
	}

	@Override
	public List<Map<String,String>> selectAxTimeResByOnnaraUseRtTop(JobResSearchVo searchVo)
			throws Exception {
		List<Map<String,String>> podList = selectJobResStteByOnnaraPodList(searchVo);
		if(podList.size() <= 0){
			podList = new ArrayList<Map<String,String>>();
		}
		searchVo.setPodList(podList);
		List<Map<String,String>> list=null;
		list = jobResStteByOnnaraDao.selectAxTimeResByOnnaraUseRtTop(searchVo);
		logger.debug("===================searchVo.getColctCd()"+searchVo.getColctCd());
		return list;
	}

}
