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

import ncis.cmn.entity.StYrCludNwUseInstitution;
import ncis.cmn.exception.CommonException;
import ncis.dsb.stts.cludSwtchGoalRslt.dao.CludNewUseInsttDao;
import ncis.dsb.stts.cludSwtchGoalRslt.service.CludNewUseInsttService;
import ncis.dsb.stts.cludSwtchGoalRslt.vo.CludNewUseInsttVo;

import org.springframework.stereotype.Service;

@Service("cludNewUseInsttService")
public class CludNewUseInsttServiceImpl implements CludNewUseInsttService {

	@Resource(name="cludNewUseInsttDao")
	private CludNewUseInsttDao cludNewUseInsttDao;

	/**
	 * 클라우드 신규 이용기관 조회
	 * */
	public List<CludNewUseInsttVo> selectCludNewUseInsttList(StYrCludNwUseInstitution searchVo)throws Exception{
		return cludNewUseInsttDao.selectCludNewUseInsttList();
	}
	/**
	 * 클라우드 신규 이용기관 상세 조회
	 * */
	public List<CludNewUseInsttVo> selectCludNewUseInsttDtl(StYrCludNwUseInstitution vo)throws Exception{
		return cludNewUseInsttDao.selectCludNewUseInsttDtl(vo);
	}
	/**
	 * 등록가능 년도 조회
	 * */
	public List<String> selectRegPosblYear()throws Exception{
		return cludNewUseInsttDao.selectRegPosblYear();
	}
	/*
	 * 신규이용기관 등록
	 */
	public void insertCludNewUseInstt( List<StYrCludNwUseInstitution> list)throws Exception{

		for(StYrCludNwUseInstitution vo : list){
			int cnt = cludNewUseInsttDao.selectCludNewUseInsttCnt(vo);
			if(cnt>0){
				throw new CommonException(vo.getInstitutionNm()+"은(는) 이미 등록된 기관입니다.");
			}
			cludNewUseInsttDao.insertCludNewUseInstt(vo);
		}
	}
	/*
	 * 신규이용기관 수정
	 */
	public void updateCludNewUseInstt( List<StYrCludNwUseInstitution> list)throws Exception{
		cludNewUseInsttDao.deleteCludNewUseInstt(list.get(0));
		for(StYrCludNwUseInstitution vo : list){
			int cnt = cludNewUseInsttDao.selectCludNewUseInsttCnt(vo);
			if(cnt>0){
				throw new CommonException(vo.getInstitutionNm()+"은(는) 이미 등록된 기관입니다.");
			}
			cludNewUseInsttDao.insertCludNewUseInstt(vo);
		}
	}
	/*
	 * 신규이용기관 수정
	 */
	public void deleteCludNewUseInstt( StYrCludNwUseInstitution vo)throws Exception{
		cludNewUseInsttDao.deleteCludNewUseInstt(vo);
	}

}
