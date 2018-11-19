/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CCmUsrConnHistDao.java
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

import ncis.cmn.entity.CmUsrConnHist;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 사용자접속이력 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cCmUsrConnHistDao")
public class CCmUsrConnHistDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 사용자접속이력 등록
	 * @param cmUsrConnHist
	 */
	public void insertCmUsrConnHist(CmUsrConnHist cmUsrConnHist) {
		sqlSession.insert("ncis.sql.cmn.cmUsrConnHist.insertCmUsrConnHist", cmUsrConnHist);
	}
}
