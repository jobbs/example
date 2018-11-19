/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CCmBtchWrkRegHistDao.java
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

import ncis.cmn.entity.CmBtchWrkRegHist;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 배치작업등록이력 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cCmBtchWrkRegHistDao")
public class CCmBtchWrkRegHistDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 배치작업등록이력 등록
	 * @param cmBtchWrkRegHist
	 */
	public void insertCmBtchWrkRegHist(CmBtchWrkRegHist cmBtchWrkRegHist) {
		sqlSession.insert("ncis.sql.cmn.cmBtchWrkRegHist.insertCmBtchWrkRegHist", cmBtchWrkRegHist);
	}

	/**
	 * 배치작업등록이력 수정
	 * @param cmBtchWrkRegHist
	 */
	public void updateCmBtchWrkRegHist(CmBtchWrkRegHist cmBtchWrkRegHist) {
		sqlSession.update("ncis.sql.cmn.cmBtchWrkRegHist.updateCmBtchWrkRegHist", cmBtchWrkRegHist);
	}

	/**
	 * 배치작업등록이력 삭제
	 * @param cmBtchWrkRegHist
	 */
	public void deleteCmBtchWrkRegHist(CmBtchWrkRegHist cmBtchWrkRegHist) {
		sqlSession.update("ncis.sql.cmn.cmBtchWrkRegHist.deleteCmBtchWrkRegHist", cmBtchWrkRegHist);
	}

}
