/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * JobRsrcStteService.java
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
package ncis.dsb.stts.rsrcuse.service;

import java.util.List;


import ncis.dsb.stts.rsrcuse.vo.JobRsrcStteSearchVo;
import ncis.dsb.stts.rsrcuse.vo.JobRsrcStteVo;

public interface JobRsrcStteService {


	public List<JobRsrcStteVo> selectJobRsrcStteList(JobRsrcStteSearchVo searchVo)throws Exception;


	//public int selectServcTotCnt(JobRsrcStteSearchVo searchVo)throws Exception;



}
