/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxLogServiceImpl.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 08. 10
 * @lastmodified2017. 08. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 08. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.log.axLog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.dsb.stts.log.axLog.dao.AxLogDao;
import ncis.dsb.stts.log.axLog.service.AxLogService;
import ncis.dsb.stts.log.axLog.vo.AxLogSearchVo;
import ncis.dsb.stts.log.axLog.vo.AxLogVo;

import org.springframework.stereotype.Service;

@Service("axLogService")
public class AxLogServiceImpl implements AxLogService {

	@Resource(name="axLogDao")
	private AxLogDao axLogDao;

	/**
	 * 자동확장 로그 조회
	 * */
	@Override
	public List<AxLogVo> selectAxLogList(AxLogSearchVo searchVo) throws Exception {
		List<AxLogVo> list = null;
		int totalCount = axLogDao.selectAxLogTotCnt(searchVo);
		if(totalCount > 0){
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);
			list =  axLogDao.selectAxLogList(searchVo);
		}

		return list;
	}

}
