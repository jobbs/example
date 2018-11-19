/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * JobResStteService.java
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
 * 2017. 06. 10   양정순         v2.0             자동확장
 *
 */
package ncis.dsb.stts.res.service;

import java.util.List;
import java.util.Map;

import ncis.dsb.stts.res.vo.JobResSearchVo;
import ncis.dsb.stts.res.vo.JobResStteVo;
import ncis.dsb.stts.res.vo.JobVmStteVo;
import ncis.dsb.stts.res.vo.JobAxStteVo;
import ncis.dsb.stts.res.vo.JobTimeResUseRtVo;


public interface JobResStteService {

	public List<JobResStteVo> selectJobResStteList(JobResSearchVo searchVo)throws Exception;
	public List<JobVmStteVo> selectJobVmStteList(JobResSearchVo searchVo)throws Exception;
	public List<JobAxStteVo> selectJobAxStteList(JobResSearchVo searchVo)throws Exception;

	public List<JobTimeResUseRtVo> selectJobTimeResUseRtCpu(JobResSearchVo searchVo)throws Exception;
	public List<JobTimeResUseRtVo> selectJobTimeResUseRtMem(JobResSearchVo searchVo)throws Exception;
	public List<JobTimeResUseRtVo> selectJobTimeResUseRtSan(JobResSearchVo searchVo)throws Exception;

	public List<Map<String,String>> selectJobResStteVmList(JobResSearchVo searchVo)throws Exception;
	public List<Map<String,String>> selectJobTimeResUseRtPivot(JobResSearchVo searchVo)throws Exception;

	public List<Map<String,String>> selectAxResSttePodList(JobResSearchVo searchVo)throws Exception;
	public List<Map<String,String>> selectAxTimeResUseRtPivot(JobResSearchVo searchVo)throws Exception;
}
