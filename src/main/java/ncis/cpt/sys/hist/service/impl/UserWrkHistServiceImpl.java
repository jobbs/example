/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserWrkHistServiceImpl.java
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
package ncis.cpt.sys.hist.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.dao.CCmUserWrkHistDao;
import ncis.cpt.sys.hist.dao.UserWrkHistDao;
import ncis.cpt.sys.hist.service.UserWrkHistService;
import ncis.cpt.sys.hist.vo.UserWrkHistSearchVo;
import ncis.cpt.sys.hist.vo.UserWrkHistVo;

import org.springframework.stereotype.Service;

@Service("userWrkHistService")
public class UserWrkHistServiceImpl implements UserWrkHistService {

	@Resource(name="cUserWrkHistDao") private CCmUserWrkHistDao cUserWrkHistDao;
	@Resource(name="userWrkHistDao") private UserWrkHistDao userWrkHistDao;

	@Override
	public List<UserWrkHistVo> selectUserWrkHistList(UserWrkHistSearchVo searchVo) {

		List<UserWrkHistVo> list = null;

		int totalCount = userWrkHistDao.selectUserWrkHistTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			list = userWrkHistDao.selectUserWrkHistList(searchVo);
		}

		return list;
	}

	@Override
	public UserWrkHistVo selectUserWrkHist(Long wrkHistSeq) {
		return userWrkHistDao.selectUserWrkHist(wrkHistSeq);
	}

	@Override
	public void insertUserWrkHist(UserWrkHistVo workHist) {
	    cUserWrkHistDao.insertUserWrkHist(workHist);
	}

	@Override
	public List<UserWrkHistVo> selectDownloadUserWrkHist(UserWrkHistSearchVo searchVo) {
		return userWrkHistDao.selectDownloadUserWrkHist(searchVo);
	}

}
