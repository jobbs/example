package ncis.cmn.dao;

import ncis.cpt.opr.catalg.vo.TmplatPrposVo;
import ncis.cpt.opr.catalg.vo.TmplatVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 템플릿용도 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRrTmplatPrposDao")
public class CRrTmplatPrposDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 템플릿용도추가
	 * @param tmplatVo
	 */
	public void insertRrTmplatPrpos(TmplatPrposVo vo) {

		sqlSession.insert("ncis.sql.cmn.rrTmplatPrpos.insertRrTmplatPrpos", vo);
	}

	/**
	 * 템플릿용도삭제
	 * @param tmplatVo
	 */
	public void deleteRrTmplatPrpos(TmplatVo tmplatVo) {

		sqlSession.delete("ncis.sql.cmn.rrTmplatPrpos.deleteRrTmplatPrpos", tmplatVo.getTmplatSeq());
	}
}
