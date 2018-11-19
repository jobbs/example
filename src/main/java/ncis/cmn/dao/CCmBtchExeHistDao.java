/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CCmBtchExeHistDao.java
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

import ncis.cmn.entity.CmBtchExeHist;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 배치작업실행이력 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cCmBtchExeHistDao")
public class CCmBtchExeHistDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 배치작업실행이력 등록
	 * @param cmBtchExeHist
	 */
	public void insertCmBtchExeHist(CmBtchExeHist cmBtchExeHist) {
		sqlSession.insert("ncis.sql.cmn.cmBtchExeHist.insertCmBtchExeHist", cmBtchExeHist);
	}

	/**
	 * 배치작업실행이력 수정
	 * @param cmBtchExeHist
	 */
	public void updateCmBtchExeHist(CmBtchExeHist cmBtchExeHist) {
		sqlSession.update("ncis.sql.cmn.cmBtchExeHist.updateCmBtchExeHist", cmBtchExeHist);
	}

	/**
	 * 배치작업실행이력 삭제
	 * @param cmBtchExeHist
	 */
	public void deleteCmBtchExeHist(CmBtchExeHist cmBtchExeHist) {
		sqlSession.update("ncis.sql.cmn.cmBtchExeHist.deleteCmBtchExeHist", cmBtchExeHist);
	}

}
