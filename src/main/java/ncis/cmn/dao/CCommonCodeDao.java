/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CCommonCodeDao.java
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

import ncis.cmn.entity.CommonCode;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 공통코드 관리 테이블 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cCommonCodeDao")
public class CCommonCodeDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 공통코드 관리 테이블 등록
	 * @param commonCode
	 */
	public void insertCommonCode(CommonCode commonCode) {
		sqlSession.insert("ncis.sql.cmn.commonCode.insertCommonCode", commonCode);
	}

	/**
	 * 공통코드 관리 테이블 수정
	 * @param commonCode
	 */
	public void updateCommonCode(CommonCode commonCode) {
		sqlSession.update("ncis.sql.cmn.commonCode.updateCommonCode", commonCode);
	}

	/**
	 * 공통코드 관리 테이블 삭제
	 * @param commonCode
	 */
	public void deleteCommonCode(CommonCode commonCode) {
		sqlSession.update("ncis.sql.cmn.commonCode.deleteCommonCode", commonCode);
	}

}
