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
package ncis.cmn.dao;

import ncis.cpt.opr.catalg.vo.SpecSvo;
import ncis.cpt.opr.catalg.vo.SpecVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 스펙 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRrSpecDao")
public class CRrSpecDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 스펙 등록
	 * @param rrSpec
	 */
	public void insertRrSpec(SpecVo vo) {
		sqlSession.insert("ncis.sql.cmn.rrSpec.insertRrSpec", vo);
	}

	/**
	 * 스펙 수정
	 * @param rrSpec
	 */
	public void updateRrSpec(SpecVo vo) {
		sqlSession.update("ncis.sql.cmn.rrSpec.updateRrSpec", vo);
	}

	/**
	 * 스펙 삭제
	 * @param rrSpec
	 */
	public void deleteRrSpec(SpecSvo svo) {
		sqlSession.delete("ncis.sql.cmn.rrSpec.deleteRrSpec", svo);
	}

}
