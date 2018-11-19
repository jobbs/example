/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * EvntStteServiceImpl.java
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

import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import ncis.cmn.dao.CStEvntDao;
import ncis.cmn.entity.StEvnt;
import ncis.cmn.security.vo.UserVo;
import ncis.cmn.util.RequestUtils;
import ncis.dsb.thrd.evnt.dao.EvntStteDao;
import ncis.dsb.thrd.evnt.service.EvntStteService;
import ncis.dsb.thrd.evnt.vo.EvntStteSearchVo;
import ncis.dsb.thrd.evnt.vo.EvntStteVo;
import org.springframework.stereotype.Service;

@Service("evntStteService")
public class EvntStteServiceImpl implements EvntStteService {

	@Resource(name="evntStteDao")
	private EvntStteDao evntStteDao;

	@Resource(name="cStEvntDao")
	private CStEvntDao cStEvntDao;


	/* 이벤트현황 목록조회
	 * (non-Javadoc)
	 * @see ncis.dsb.thrd.evnt.service.EvntStteService#selectEvntStteList(ncis.dsb.thrd.evnt.vo.EvntStteSearchVo)
	 */
	@Override
	public List<EvntStteVo> selectEvntStteList(EvntStteSearchVo searchVo) {
		UserVo user = RequestUtils.getUser();
		searchVo.setUserId(user.getUserId());
		int totalCount = evntStteDao.selectEvntStteListCnt(searchVo);
		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			return evntStteDao.selectEvntStteList(searchVo);
		}
		return null;
	}


	/* 이벤트 확인
	 * (non-Javadoc)
	 * @see ncis.dsb.thrd.evnt.service.EvntStteService#updateEvntConfrm(java.lang.String)
	 */
	@Override
	public void updateEvntConfrm(String evntSeq) {
		UserVo user = RequestUtils.getUser();

		StEvnt stEvnt = new StEvnt ();
		stEvnt.setConfrmUserId(user.getUserId());
		stEvnt.setEvntSeq(new BigDecimal(evntSeq));

		cStEvntDao.updateEvntConfrm(stEvnt);
	}


	/* 이벤트 확인 취소
	 * (non-Javadoc)
	 * @see ncis.dsb.thrd.evnt.service.EvntStteService#updateEvntConfrmCncl(java.lang.String)
	 */
	@Override
	public void updateEvntConfrmCncl(String evntSeq) {
		StEvnt stEvnt = new StEvnt ();
		stEvnt.setEvntSeq(new BigDecimal(evntSeq));
		cStEvntDao.updateEvntConfrmCncl(stEvnt);
	}

}
