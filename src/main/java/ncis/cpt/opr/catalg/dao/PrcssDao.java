/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PrcssDao.java
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
package ncis.cpt.opr.catalg.dao;

import java.math.BigDecimal;
import java.util.List;

import ncis.cpt.opr.catalg.vo.PrcssSearchVo;
import ncis.cpt.opr.catalg.vo.PrcssVo;
import ncis.cpt.opr.catalg.vo.ProcssVarVo;
import ncis.cpt.opr.catalg.vo.UnitJobRelateVo;
import ncis.cpt.opr.catalg.vo.UnitJobVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 이화영
 *
 */
@Repository("prcssDao")
public class PrcssDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 검색 조건에 해당하는 프로세스 목록 카운트
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	public int selectPrcssListTotCnt(PrcssSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.catalg.selectPrcssListTotCnt", searchVo);
	}

	/**
	 * 검색 조건에 해당하는 프로세스 목록 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	public List<PrcssVo> selectPrcssList(PrcssSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.opr.catalg.selectPrcssList", searchVo);
	}

	/** 프로세스 상세조회
	 * @param procssSeq	프로세스Id
	 * @return
	 */
	public PrcssVo selectPrcss(BigDecimal procssSeq) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.catalg.selectPrcss", procssSeq);
	}

	/** 프로세스 상세조회(단위업무 정보)
	 * @param procssSeq	프로세스Id
	 * @return
	 */
	public List<UnitJobVo> unitJobList(BigDecimal procssSeq) {
		return sqlSession.selectList("ncis.sql.cpt.opr.catalg.unitJobList", procssSeq);
	}

	/** 프로세스 상세조회(단위업무 관계)
	 * @param procssSeq	프로세스Id
	 * @return
	 */
	public List<UnitJobRelateVo> unitJobRelateList(BigDecimal procssSeq) {
		return sqlSession.selectList("ncis.sql.cpt.opr.catalg.unitJobRelateList", procssSeq);
	}

	/** 프로세스 상세조회(프로세스 변수)
	 * @param procssSeq	프로세스Id
	 * @return
	 */
	public List<ProcssVarVo> procssVarList(BigDecimal procssSeq) {
		return sqlSession.selectList("ncis.sql.cpt.opr.catalg.procssVarList", procssSeq);
	}

	/**
	 * 프로세스 Excel 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<PrcssVo> selectPrcssExcelList(PrcssSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.opr.catalg.selectPrcssExcelList", searchVo);
	}
}
