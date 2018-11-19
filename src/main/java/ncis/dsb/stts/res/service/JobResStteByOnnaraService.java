/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * JobResStteByOnnaraService.java
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
 * 2017. 10. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.res.service;

import java.util.List;
import java.util.Map;
import ncis.dsb.stts.res.vo.JobResSearchVo;


public interface JobResStteByOnnaraService {
	public List<Map<String,String>> selectJobResStteByOnnaraVmList(JobResSearchVo searchVo)throws Exception;
	public List<Map<String,String>> selectJobTimeResByOnnaraUseRtPivot(JobResSearchVo searchVo)throws Exception;
	public List<Map<String,String>> selectJobTimeResByOnnaraUseRtTop(JobResSearchVo searchVo)throws Exception;

	public List<Map<String,String>> selectJobResStteByOnnaraPodList(JobResSearchVo searchVo)throws Exception;
	public List<Map<String,String>> selectAxTimeResByOnnaraUseRtPivot(JobResSearchVo searchVo)throws Exception;
	public List<Map<String,String>> selectAxTimeResByOnnaraUseRtTop(JobResSearchVo searchVo)throws Exception;
}
