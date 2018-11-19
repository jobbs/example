/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TmplatServiceImpl.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 5.
 * @lastmodified 2016. 10. 5.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 5.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.config.OprConstant;
import ncis.cmn.dao.CRrSwDao;
import ncis.cmn.dao.CRrTmplatApplcSwDao;
import ncis.cmn.dao.CRrTmplatDao;
import ncis.cmn.dao.CRrTmplatPrposDao;
import ncis.cpt.opr.catalg.dao.TmplatDao;
import ncis.cpt.opr.catalg.service.TmplatService;
import ncis.cpt.opr.catalg.vo.TmplatPrposVo;
import ncis.cpt.opr.catalg.vo.TmplatSvo;
import ncis.cpt.opr.catalg.vo.TmplatSwVo;
import ncis.cpt.opr.catalg.vo.TmplatVo;

import org.springframework.stereotype.Service;

/**
 * @author 송승규
 *
 */
@Service("tmplatService")
public class TmplatServiceImpl implements TmplatService{

	@Resource(name="tmplatDao") private TmplatDao tmplatDao;

	@Resource(name="cRrTmplatDao") private CRrTmplatDao cTmplatDao;

	@Resource(name="cRrTmplatApplcSwDao") private CRrTmplatApplcSwDao cTmplatSwDao;

	@Resource(name="cRrTmplatPrposDao") private CRrTmplatPrposDao cTmplatPrposDao;

	@Resource(name="cRrSwDao") private CRrSwDao cSwDao;

	/**
	 * 템플릿목록조회
	 * @param svo
	 * @return
	 */
	@Override
	public List<TmplatVo> selectTmplatList(TmplatSvo svo){

		List<TmplatVo> resultList = null;

		int totCnt = tmplatDao.selectTmplatTotCnt(svo);

		if(totCnt > 0){
			svo.getPaginationInfo().setTotalRecordCount(totCnt);	// 페이지 처리위한 count
			resultList = tmplatDao.selectTmplatList(svo);
		}
		return resultList;
	}

	/**
	 * 템플릿상세조회
	 * @param TmplatVo
	 * @return
	 */
	@Override
	public TmplatVo selectTmplatDetail(TmplatVo vo){

		TmplatVo resultVo = tmplatDao.selectTmplatDetail(vo.getTmplatSeq());

		return resultVo;
	}

	/**
	 * 템플릿 사용 수정
	 * @param svo
	 */
	@Override
	public void updateTmplatUseY(TmplatSvo svo){

		List<Integer> list = svo.getUpdtCheck();
		for(int i=0; i<list.size(); i++){
			cTmplatDao.updateTmplatUseY(list.get(i));
		}
	}

	/**
	 * 템플릿 미사용 수정
	 * @param svo
	 */
	@Override
	public void updateTmplatUseN(TmplatSvo svo){

		List<Integer> list = svo.getUpdtCheck();
		for(int i=0; i<list.size(); i++){
			cTmplatDao.updateTmplatUseN(list.get(i));
		}
	}

	/**
	 * 템플릿수정
	 * @param vo
	 * @return
	 */
	@Override
	public void updateTmplatDetail(TmplatVo vo){

		cTmplatDao.updateRrTmplat(vo);

		TmplatVo resultVo = selectTmplatDetail(vo);

		List<String> prpos = vo.getPrposInsert();
		List<Integer> sw = vo.getSwInsert();

		// 기존 용도 삭제
		if(resultVo.getPrposList().size() > 0){
			cTmplatPrposDao.deleteRrTmplatPrpos(vo);
		}

		// 기존 SW 삭제
		if(resultVo.getTmplatSwList().size() > 0){
			cTmplatSwDao.deleteRrTmplatSw(vo);
		}

		// 신규 용도 추가
		if(prpos.size() > 0){
			for(int i=0; i<prpos.size(); i++){
				TmplatPrposVo prposVo = new TmplatPrposVo();
				prposVo.setPrposCn(prpos.get(i));
				prposVo.setTmplatSeq(vo.getTmplatSeq());

				cTmplatPrposDao.insertRrTmplatPrpos(prposVo);
			}
		}

		// 신규 소프트웨어 추가
		if(sw.size() > 0){
			for(int i=0; i<sw.size(); i++){
				TmplatSwVo swVo = new TmplatSwVo();
				swVo.setSwSeq(sw.get(i));
				swVo.setTmplatSeq(vo.getTmplatSeq());

				cTmplatSwDao.insertRrTmplatSw(swVo);
			}
		}
	}

	/**
	 * 소프트웨어 목록조회
	 * @param vo
	 * @return
	 */
	@Override
	public List<TmplatSwVo> selectSwList(TmplatSvo svo){

		List<TmplatSwVo> resultList = null;

		int totCnt = tmplatDao.selectSwTotCnt(svo);

		if(totCnt > 0){
			svo.getPaginationInfo().setTotalRecordCount(totCnt);	// 페이지 처리위한 count
			resultList = tmplatDao.selectSwList(svo);
		}
		return resultList;
	}

	/**
	 * 자원요청상세-가상서버-템플릿 조회
	 * @param vo
	 * @return
	 */
	@Override
	public List<TmplatVo> selectRrVmTmplatList(TmplatSvo svo){
		svo.setUseYn(OprConstant.USE_YN_Y);
		svo.setPaginationInfo(null);
		return tmplatDao.selectRrVmTmplatList(svo);
	}


	/**
	 * 템플릿 자원요청 사용여부를 업데이트 한다.
	 * @param processMngVo
	 * @return
	 */
	@Override
	public void updateRrTmplatRsrcReqInit(String rsrcReqNo) {
		cTmplatDao.updateRrTmplatRsrcReqInit(rsrcReqNo);
	}

}
