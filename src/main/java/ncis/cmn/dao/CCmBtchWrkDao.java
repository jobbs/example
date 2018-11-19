/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CCmBtchWrkDao.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cmn.dao;

import ncis.cmn.entity.CmBtchWrk;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 배치작업 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cCmBtchWrkDao")
public class CCmBtchWrkDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 배치작업 등록
	 * @param cmBtchWrk
	 */
	public void insertCmBtchWrk(CmBtchWrk cmBtchWrk) {
		sqlSession.insert("ncis.sql.cmn.cmBtchWrk.insertCmBtchWrk", cmBtchWrk);
	}

	/**
	 * 배치작업 수정
	 * @param cmBtchWrk
	 */
	public void updateCmBtchWrk(CmBtchWrk cmBtchWrk) {
		sqlSession.update("ncis.sql.cmn.cmBtchWrk.updateCmBtchWrk", cmBtchWrk);
	}

	/**
	 * 배치작업 삭제
	 * @param cmBtchWrk
	 */
	public void deleteCmBtchWrk(Long btchWrkSeq) {
		sqlSession.delete("ncis.sql.cmn.cmBtchWrk.deleteCmBtchWrk", btchWrkSeq);
	}

}
