/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * JobRsrcStteImpl.java
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
package ncis.dsb.stts.rsrcuse.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.dsb.stts.rsrcuse.dao.JobRsrcStteDao;
import ncis.dsb.stts.rsrcuse.service.JobRsrcStteService;
import ncis.dsb.stts.rsrcuse.vo.JobRsrcStteSearchVo;
import ncis.dsb.stts.rsrcuse.vo.JobRsrcStteVo;

import org.springframework.stereotype.Service;

@Service("jobRsrcStteService")
public class JobRsrcStteImpl implements JobRsrcStteService {


	@Resource(name="jobRsrcStteDao")
	private JobRsrcStteDao jobRsrcStteDao;

	/**
	 * 업무별 자원 사용 현황 조회
	 * */

	@Override
	public List<JobRsrcStteVo> selectJobRsrcStteList(JobRsrcStteSearchVo searchVo) throws Exception {

		List<JobRsrcStteVo> list = null;
		list = jobRsrcStteDao.selecJobRsrcStteList(searchVo);
		//int totalCount = rsrcAsgnStteTrmDao.selectRsrcAsgnStteTrmTotCnt(searchVo);

		//if( totalCount > 0 ) {
		searchVo.getPaginationInfo().setTotalRecordCount(list.size());	// 페이지 처리위한 count

		//}
		return list;


	}


}
