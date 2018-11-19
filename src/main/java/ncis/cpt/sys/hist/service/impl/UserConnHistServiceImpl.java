/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserConnRecServiceImpl.java
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
import ncis.cmn.dao.CCmUsrConnHistDao;
import ncis.cmn.entity.CmUsrConnHist;
import ncis.cpt.sys.hist.dao.UserConnHistDao;
import ncis.cpt.sys.hist.service.UserConnHistService;
import ncis.cpt.sys.hist.vo.UserConnHistSearchVo;
import ncis.cpt.sys.hist.vo.UserConnHistVo;
import org.springframework.stereotype.Service;

@Service("userConnHistService")
public class UserConnHistServiceImpl implements UserConnHistService {

	@Resource(name="cCmUsrConnHistDao") private CCmUsrConnHistDao cCmUsrConnHistDao;
	@Resource(name="userConnHistDao") private UserConnHistDao userConnHistDao;

	@Override
	public List<UserConnHistVo> selectUserConnHistList(UserConnHistSearchVo searchVo) {

		List<UserConnHistVo> list = null;

		int totalCount = userConnHistDao.selectUserConnHistTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			list = userConnHistDao.selectUserConnHistList(searchVo);
		}

		return list;
	}

	@Override
	public UserConnHistVo selectUserConnHist(Long connectSeq) {
		return userConnHistDao.selectUserConnHist(connectSeq);
	}

	@Override
	public void insertUSerConnHist(CmUsrConnHist cmUsrConnHist) {
		cCmUsrConnHistDao.insertCmUsrConnHist(cmUsrConnHist);
	}

	@Override
	public List<UserConnHistVo> selectDownloadUserConnHist(UserConnHistSearchVo searchVo) {
		return userConnHistDao.selectDownloadUserConnHist(searchVo);
	}


}
