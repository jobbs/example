/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RoleServiceImpl.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.job.service.impl;

import java.util.List;
import javax.annotation.Resource;
import ncis.cmn.dao.CCmJobDao;
import ncis.cpt.sys.job.dao.JobDao;
import ncis.cpt.sys.job.service.JobService;
import ncis.cpt.sys.job.vo.JobSearchVo;
import ncis.cpt.sys.job.vo.JobVo;
import org.springframework.stereotype.Service;

@Service("jobService")
public class JobServiceImpl implements JobService {

	@Resource(name="cCmJobDao") private CCmJobDao cCmJobDao;
	@Resource(name="jobDao") private JobDao jobDao;

	@Override
	public List<JobVo> selectJobList(JobSearchVo searchVo) {
		List<JobVo> list = null;

		int totalCount = jobDao.selectJobTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount); // 페이지 처리위한 count
			list = jobDao.selectJobList(searchVo);
		}

		return list;
	}

	@Override
	public List<JobVo> selectJobListXlsDwnl(JobSearchVo searchVo) {
	    return jobDao.selectJobListXlsDwnl(searchVo);
	}

	@Override
	public JobVo selectJob(String jobId) {
		JobVo jobVo = jobDao.selectJobTotCnt(jobId);
		return jobVo;
	}


	@Override
	public void updateJob(JobVo jobVo) {
		cCmJobDao.updateCmJobUseYn(jobVo);

	}


}
