package ncis.cmn.dao;

import ncis.cmn.entity.OaPackgVer;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 패키지버전 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cOaPackgVerDao")
public class COaPackgVerDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 패키지버전 등록
	 * @param oaPackgVer
	 */
	public void insertOaPackgVer(OaPackgVer oaPackgVer) {
		sqlSession.insert("ncis.sql.cmn.oaPackgVer.insertOaPackgVer", oaPackgVer);
	}

	/**
	 * 패키지버전 수정
	 * @param oaPackgVer
	 */
	public void updateOaPackgVer(OaPackgVer oaPackgVer) {
		sqlSession.update("ncis.sql.cmn.oaPackgVer.updateOaPackgVer", oaPackgVer);
	}

	/**
	 * 패키지버전 삭제
	 * @param oaPackgVer
	 */
	public void deleteOaPackgVer(OaPackgVer oaPackgVer) {
		sqlSession.update("ncis.sql.cmn.oaPackgVer.deleteOaPackgVer", oaPackgVer);
	}

}
