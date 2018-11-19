/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PrcssServiceImpl.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 9. 30.
 * @lastmodified 2016. 9. 30.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 30.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import ncis.cpt.opr.catalg.dao.PrcssDao;
import ncis.cpt.opr.catalg.service.PrcssService;
import ncis.cpt.opr.catalg.vo.PrcssSearchVo;
import ncis.cpt.opr.catalg.vo.PrcssVo;
import ncis.cpt.opr.catalg.vo.ProcssVarVo;
import ncis.cpt.opr.catalg.vo.UnitJobRelateVo;
import ncis.cpt.opr.catalg.vo.UnitJobVo;

import org.springframework.stereotype.Service;

/**
 * @author 이화영
 *
 */
@Service("prcssService")
public class PrcssServiceImpl implements PrcssService {

	@Resource(name="prcssDao") private PrcssDao prcssDao;

	/**
	 * 검색 조건에 해당하는 프로세스 목록 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	@Override
	public List<PrcssVo> selectPrcssList(PrcssSearchVo searchVo) {

		List<PrcssVo> list = null;

		int totalCount = prcssDao.selectPrcssListTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			list = prcssDao.selectPrcssList(searchVo);
		}
		return list;
	}

	/**
	 * 프로세스 상세 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	@Override
	public PrcssVo selectPrcss(BigDecimal procssSeq) {
		return prcssDao.selectPrcss(procssSeq);
	}

	/**
	 * 프로세스 상세 조회(단위업무 정보)
	 * @param procssSeq	프로세스Id
	 * @return
	 */
	@Override
	public List<UnitJobVo> unitJobList(BigDecimal procssSeq) {
		return prcssDao.unitJobList(procssSeq);
	}

	/**
	 * 프로세스 상세 조회(단위업무 관계)
	 * @param procssSeq	프로세스Id
	 * @return
	 */
	@Override
	public List<UnitJobRelateVo> unitJobRelateList(BigDecimal procssSeq) {
		return prcssDao.unitJobRelateList(procssSeq);
	}

	/**
	 * 프로세스 상세 조회(프로세스 변수)
	 * @param procssSeq	프로세스Id
	 * @return
	 */
	@Override
	public List<ProcssVarVo> procssVarList(BigDecimal procssSeq){
		return prcssDao.procssVarList(procssSeq);
	}

	/**
	 * 프로세스 Excel 목록 조회
	 * @param searchVo
	 * @return
	 */
	@Override
	public List<PrcssVo> selectPrcssExcelList(PrcssSearchVo searchVo) {

		List<PrcssVo> list = null;

		list = prcssDao.selectPrcssExcelList(searchVo);

		return list;
	}


}
