package ncis.cmn.dao;

import ncis.cpt.opr.catalg.vo.TmplatSvo;
import ncis.cpt.opr.catalg.vo.TmplatSwVo;
import ncis.cpt.opr.catalg.vo.TmplatVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 템플릿적용소프트웨어 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRrTmplatApplcSwDao")
public class CRrTmplatApplcSwDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 템플릿소프트웨어추가
	 * @param tmplatVo
	 */
	public void insertRrTmplatSw(TmplatSwVo vo) {

		sqlSession.insert("ncis.sql.cmn.rrTmplatApplcSw.insertRrTmplatApplcSw", vo);
	}

	/**
	 * 템플릿소프트웨어삭제
	 * @param tmplatVo
	 */
	public void deleteRrTmplatSw(TmplatVo tmplatVo) {

		sqlSession.delete("ncis.sql.cmn.rrTmplatApplcSw.deleteRrTmplatApplcSw", tmplatVo.getTmplatSeq());
	}

	/**
	 * 소프트웨어삭제
	 * @param tmplatVo
	 */
	public void deleteRrTmplatSwAll(TmplatSvo svo) {

		sqlSession.delete("ncis.sql.cmn.rrTmplatApplcSw.deleteRrTmplatApplcSwAll", svo);
	}
}
