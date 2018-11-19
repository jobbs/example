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
import java.util.Map;

import javax.annotation.Resource;

import ncis.cmn.entity.StCludSwtchGoalRslt;
import ncis.dsb.stts.cludSwtchGoalRslt.dao.CludSwtchGoalRsltDao;
import ncis.dsb.stts.cludSwtchGoalRslt.service.CludSwtchGoalRsltService;
import ncis.dsb.stts.cludSwtchGoalRslt.vo.CludSwtchGoalRsltVo;

import org.springframework.stereotype.Service;

@Service("cludSwtchGoalRsltService")
public class CludSwtchGoalRsltServiceImpl implements CludSwtchGoalRsltService {

	@Resource(name="cludSwtchGoalRsltDao")
	private CludSwtchGoalRsltDao cludSwtchGoalRsltDao;

	/**
	 * 클라우드 전환 목표 및  실적 조회
	 * */
	@Override
	public List<CludSwtchGoalRsltVo> selectCludSwtchGoalRsltList() throws Exception {
		return cludSwtchGoalRsltDao.selectCludSwtchGoalRsltList();
	}
	/**
	 * 클라우드 전환 목표 및 상세 실적 조회
	 * */
	@Override
	public List<Map<String, Object>> selectCludSwtchRsltDtl(List<String> list) throws Exception {
		return cludSwtchGoalRsltDao.selectCludSwtchRsltDtl(list);
	}
	/**
	 * 2011년도부터 현재 년도까지 목록 조회
	 * */
	public List<String> select2011toCurrentYear() throws Exception{
		return cludSwtchGoalRsltDao.select2011toCurrentYear();
	}
	/**
	 * 클라우드 전환 목표 및 실적 등록
	 * */
	public List<Map<String, Object>> selectCludSwtchGoalRsltDtl(List<String> yearList) throws Exception{
		return cludSwtchGoalRsltDao.selectCludSwtchGoalRsltDtl(yearList);
	}
	/**
	 * 클라우드 전환 목표 및 실적 등록
	 * */
	public void insertCludSwtchGoalRslt(List<StCludSwtchGoalRslt> list) throws Exception{
		cludSwtchGoalRsltDao.deleteCludSwtchGoalRslt();
		for(int i=0; i<list.size(); i++){
			cludSwtchGoalRsltDao.insertCludSwtchGoalRslt(list.get(i));
		}

	}

}
