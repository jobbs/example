/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmLogServiceImpl.java
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
package ncis.dsb.stts.log.vmLog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.dsb.stts.log.vmLog.dao.VmLogDao;
import ncis.dsb.stts.log.vmLog.service.VmLogService;
import ncis.dsb.stts.log.vmLog.vo.VmLogSearchVo;
import ncis.dsb.stts.log.vmLog.vo.VmLogVo;

import org.springframework.stereotype.Service;

@Service("vmLogService")
public class VmLogServiceImpl implements VmLogService {

	@Resource(name="vmLogDao")
	private VmLogDao vmLogDao;

	/**
	 * 가상서버 로그 조회
	 * */
	@Override
	public List<VmLogVo> selectVmLogList(VmLogSearchVo searchVo) throws Exception {
		List<VmLogVo> list = null;
		int totalCount = vmLogDao.selectVmLogTotCnt(searchVo);
		if(totalCount > 0){
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);
			list =  vmLogDao.selectVmLogList(searchVo);
		}

		return list;
	}

}
