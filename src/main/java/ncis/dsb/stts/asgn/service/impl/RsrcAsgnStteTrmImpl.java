/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * RsrcAsgnStteTrmImpl.java
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

package ncis.dsb.stts.asgn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.security.vo.UserMenuMap;
import ncis.dsb.stts.asgn.dao.RsrcAsgnStteTrmDao;
import ncis.dsb.stts.asgn.service.RsrcAsgnStteTrmService;
import ncis.dsb.stts.asgn.vo.RsrcAsgnStteTrmSearchVo;
import ncis.dsb.stts.asgn.vo.RsrcAsgnStteTrmVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("rsrcAsgnStteTrmService")
public class RsrcAsgnStteTrmImpl implements RsrcAsgnStteTrmService {

	private static final Logger logger = LoggerFactory.getLogger(UserMenuMap.class);

	@Resource(name="rsrcAsgnStteTrmDao")
	private RsrcAsgnStteTrmDao rsrcAsgnStteTrmDao;

	/**
	 * 자원 보유 및 할당 현황-클러스터별 조회
	 * */
	@Override
	public List<RsrcAsgnStteTrmVo> selectRsrcAsgnStteTrmList(RsrcAsgnStteTrmSearchVo searchVo) throws Exception {

		List<RsrcAsgnStteTrmVo> list = null;
		list = rsrcAsgnStteTrmDao.selectRsrcAsgnStteTrmList(searchVo);
		logger.debug("size=========="+list.size());
		//int totalCount = rsrcAsgnStteTrmDao.selectRsrcAsgnStteTrmTotCnt(searchVo);

		//if( totalCount > 0 ) {
		searchVo.getPaginationInfo().setTotalRecordCount(list.size());	// 페이지 처리위한 count

		//}
		return list;


	}

}
