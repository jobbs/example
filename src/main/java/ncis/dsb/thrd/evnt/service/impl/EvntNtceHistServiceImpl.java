/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * EvntNtceHistServiceImpl.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   김동훈         v1.0             최초생성
 *
 */
package ncis.dsb.thrd.evnt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.util.RequestUtils;
import ncis.dsb.thrd.evnt.dao.EvntNtceHistDao;
import ncis.dsb.thrd.evnt.service.EvntNtceHistService;
import ncis.dsb.thrd.evnt.vo.EvntNtceHistVo;
import ncis.dsb.thrd.evnt.vo.EvntNtceHistSearchVo;

import org.springframework.stereotype.Service;

@Service("evntNtceHistService")
public class EvntNtceHistServiceImpl implements EvntNtceHistService {

	@Resource(name="evntNtceHistDao")
	private EvntNtceHistDao evntNtceHistDao;

	/* 이벤트 통보이력 목록 조회
	 * @see ncis.dsb.thrd.evnt.service.EvntNtceHistService#selectEvntNtceHistList(ncis.dsb.thrd.evnt.vo.EvntNtceHistSearchVo)
	 */
	@Override
	public List<EvntNtceHistVo> selectEvntNtceHistList(EvntNtceHistSearchVo searchVo) throws Exception {
		ncis.cmn.security.vo.UserVo user = RequestUtils.getUser();
		searchVo.setUserId(user.getUserId());

		int totalCount = evntNtceHistDao.selectEvntNtceHistListCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			return evntNtceHistDao.selectEvntNtceHistList(searchVo);
		}
		return null;
	}

}
