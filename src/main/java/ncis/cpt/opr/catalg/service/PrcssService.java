/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PrcssService.java
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
package ncis.cpt.opr.catalg.service;

import java.math.BigDecimal;
import java.util.List;

import ncis.cpt.opr.catalg.vo.PrcssSearchVo;
import ncis.cpt.opr.catalg.vo.PrcssVo;
import ncis.cpt.opr.catalg.vo.ProcssVarVo;
import ncis.cpt.opr.catalg.vo.UnitJobRelateVo;
import ncis.cpt.opr.catalg.vo.UnitJobVo;

/**
 * @author 이화영
 *
 */
public interface PrcssService {

	/**
	 * 검색 조건에 해당하는 프로세스 목록 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	List<PrcssVo> selectPrcssList(PrcssSearchVo searchVo);

	/**
	 * 프로세스 상세 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	PrcssVo selectPrcss(BigDecimal procssSeq);

	/**
	 * 프로세스 상세 조회(단위업무 정보)
	 * @param procssSeq	프로세스Id
	 * @return
	 */
	List<UnitJobVo> unitJobList(BigDecimal procssSeq);

	/**
	 * 프로세스 상세 조회(단위업무 관계)
	 * @param procssSeq	프로세스Id
	 * @return
	 */
	List<UnitJobRelateVo> unitJobRelateList(BigDecimal procssSeq);

	/**
	 * 프로세스 상세 조회(프로세스 변수)
	 * @param procssSeq	프로세스Id
	 * @return
	 */
	List<ProcssVarVo> procssVarList(BigDecimal procssSeq);

	/**
	 * 프로세스 Excel 목록 조회
	 * @param searchVo
	 * @return
	 */
	List<PrcssVo> selectPrcssExcelList(PrcssSearchVo searchVo);


}
