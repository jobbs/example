/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxEvntStteServiceImpl.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 10. 10
 * @lastmodified2017. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 10. 10   양정순         v1.0             최초생성
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
import ncis.dsb.thrd.evnt.dao.AxEvntStteDao;
import ncis.dsb.thrd.evnt.service.AxEvntStteService;
import ncis.dsb.thrd.evnt.vo.AxEvntStteSearchVo;
import ncis.dsb.thrd.evnt.vo.AxEvntStteVo;
import org.springframework.stereotype.Service;

@Service("axEvntStteService")
public class AxEvntStteServiceImpl implements AxEvntStteService {

	@Resource(name="axEvntStteDao")
	private AxEvntStteDao axEvntStteDao;

	@Resource(name="cStEvntDao")
	private CStEvntDao cStEvntDao;


	/* 자동확장 이벤트현황 목록조회
	 * (non-Javadoc)
	 * @see ncis.dsb.thrd.evnt.service.EvntStteService#selectEvntStteList(ncis.dsb.thrd.evnt.vo.EvntStteSearchVo)
	 */
	@Override
	public List<AxEvntStteVo> selectAxEvntStteList(AxEvntStteSearchVo searchVo) {
		UserVo user = RequestUtils.getUser();
		searchVo.setUserId(user.getUserId());
		int totalCount = axEvntStteDao.selectAxEvntStteListCnt(searchVo);
		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			return axEvntStteDao.selectAxEvntStteList(searchVo);
		}
		return null;
	}


	/* 자동확장 이벤트 확인
	 * (non-Javadoc)
	 * @see ncis.dsb.thrd.evnt.service.EvntStteService#updateEvntConfrm(java.lang.String)
	 */
	@Override
	public void updateAxEvntConfrm(String evntSeq) {
		UserVo user = RequestUtils.getUser();

		StEvnt stEvnt = new StEvnt ();
		stEvnt.setConfrmUserId(user.getUserId());
		stEvnt.setEvntSeq(new BigDecimal(evntSeq));

		cStEvntDao.updateAxEvntConfrm(stEvnt);
	}


	/* 이벤트 확인 취소
	 * (non-Javadoc)
	 * @see ncis.dsb.thrd.evnt.service.EvntStteService#updateEvntConfrmCncl(java.lang.String)
	 */
	@Override
	public void updateAxEvntConfrmCncl(String evntSeq) {
		StEvnt stEvnt = new StEvnt ();
		stEvnt.setEvntSeq(new BigDecimal(evntSeq));
		cStEvntDao.updateAxEvntConfrmCncl(stEvnt);
	}

}
