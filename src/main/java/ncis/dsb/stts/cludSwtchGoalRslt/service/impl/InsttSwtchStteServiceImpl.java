/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * DbmsSpaceUseRtServiceImpl.java
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
package ncis.dsb.stts.cludSwtchGoalRslt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.vo.CommonSearchVo;
import ncis.dsb.stts.cludSwtchGoalRslt.dao.InsttSwtchStteDao;
import ncis.dsb.stts.cludSwtchGoalRslt.service.InsttSwtchStteService;
import ncis.dsb.stts.cludSwtchGoalRslt.vo.InsttSwtchStteVo;

import org.springframework.stereotype.Service;

@Service("insttSwtchStteService")
public class InsttSwtchStteServiceImpl implements InsttSwtchStteService {

	@Resource(name="insttSwtchStteDao")
	private InsttSwtchStteDao insttSwtchStteDao;

	/**
	 * 기관별 전환 현황 목록조회
	 * */
	@Override
	public List<InsttSwtchStteVo> selectInsttSwtchStteList(CommonSearchVo vo) throws Exception {
		List<InsttSwtchStteVo> list = insttSwtchStteDao.selectInsttSwtchStteList(vo);
		if(list!=null && list.size()>0){
			int cnt = list.get(0).getTotCnt();
			vo.getPaginationInfo().setTotalRecordCount(cnt);
		}
		return list;
	}
	/**
	 * 기관별 전환 현황 등륵
	 * */
	public void insertCludReqPrcssStte(List<InsttSwtchStteVo> list)throws Exception{
		insttSwtchStteDao.deleteCludReqPrcssStte();//전체삭제
		for(int i=0; i<list.size(); i++){
			insttSwtchStteDao.insertCludReqPrcssStte(list.get(i));
		}

	}

}
