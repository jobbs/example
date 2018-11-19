/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SpecDao.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.dao;

import java.util.List;

import ncis.cpt.opr.catalg.vo.SpecSvo;
import ncis.cpt.opr.catalg.vo.SpecVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 송승규
 *
 */
@Repository("specDao")
public class SpecDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * 스펙 목록조회 건수
	 * @param svo
	 * @return
	 */
	public int selectSpecTotCnt(SpecSvo svo){

		return sqlSession.selectOne("ncis.sql.cpt.spec.selectSpecTotCnt", svo);
	}

	/**
	 * 스펙 목록조회
	 * @param svo
	 * @return
	 */
	public List<SpecVo> selectSpecList(SpecSvo svo){

		return sqlSession.selectList("ncis.sql.cpt.spec.selectSpecList", svo);
	}

	/**
	 * 스펙 상세조회
	 * @param specSeq
	 * @return
	 */
	public SpecVo selectSpecDetail(Integer specSeq){

		return sqlSession.selectOne("ncis.sql.cpt.spec.selectSpecDetail",specSeq);
	}
}
