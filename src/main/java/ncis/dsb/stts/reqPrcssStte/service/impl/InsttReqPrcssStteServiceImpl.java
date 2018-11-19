/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ClstResStteServiceImpl.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 11. 30
 * @lastmodified2016. 11. 30
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 30   김동훈         v1.0             최초생성
 *
 */

package ncis.dsb.stts.reqPrcssStte.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.util.ObjectUtils;
import ncis.dsb.stts.reqPrcssStte.dao.InsttReqPrcssStteDao;
import ncis.dsb.stts.reqPrcssStte.service.InsttReqPrcssStteService;
import ncis.dsb.stts.reqPrcssStte.vo.InsttReqPrcssStteSearchVo;
import ncis.dsb.stts.reqPrcssStte.vo.ReqPrcssStteVo;

import org.springframework.stereotype.Service;

@Service("insttReqPrcssStteService")
public class InsttReqPrcssStteServiceImpl implements InsttReqPrcssStteService {

	@Resource(name="insttReqPrcssStteDao")
	private InsttReqPrcssStteDao insttReqPrcssStteDao;

	/**
	 * 클라우드 요청 처리현황 목록 조회
	 */
	public List<ReqPrcssStteVo> selectInsttReqPrcssStteList(InsttReqPrcssStteSearchVo searchVo) throws Exception{

		List<ReqPrcssStteVo> list = insttReqPrcssStteDao.selectInsttReqPrcssStteList(searchVo);
		if(!ObjectUtils.isEmpty(list)&&list.size()>0){
			int totalCount = list.get(0).getTotalCount();
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
		}

		return list;
	}

}
