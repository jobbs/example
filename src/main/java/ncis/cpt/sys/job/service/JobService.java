/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename JobService.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 6.
 * @lastmodified 2016. 10. 6.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 6.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.job.service;

import java.util.List;
import ncis.cpt.sys.job.vo.JobSearchVo;
import ncis.cpt.sys.job.vo.JobVo;

/**
 * @author 최진호
 *
 */
public interface JobService {

    /**
     * @param searchVo
     * @return
     */
    List<JobVo> selectJobList(JobSearchVo searchVo);

	/**
	 * @param jobId
	 * @return
	 */
	JobVo selectJob(String jobId);

	/**
	 * @param jobVo
	 */
	void updateJob(JobVo jobVo);

    /**
     * 부처 업무 목록(Excel Dwonload)
     * @param searchVo
     * @return
     */
    List<JobVo> selectJobListXlsDwnl(JobSearchVo searchVo);

}
