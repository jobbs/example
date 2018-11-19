package ncis.cmn.dao;

import ncis.cmn.entity.OaPackg;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 패키지 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cOaPackgDao")
public class COaPackgDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 패키지 등록
	 * @param oaPackg
	 */
	public void insertOaPackg(OaPackg oaPackg) {
		sqlSession.insert("ncis.sql.cmn.oaPackg.insertOaPackg", oaPackg);
	}

	/**
	 * 패키지 수정
	 * @param oaPackg
	 */
	public void updateOaPackg(OaPackg oaPackg) {
		sqlSession.update("ncis.sql.cmn.oaPackg.updateOaPackg", oaPackg);
	}

	/**
	 * 패키지 삭제
	 * @param oaPackg
	 */
	public void deleteOaPackg(OaPackg oaPackg) {
		sqlSession.update("ncis.sql.cmn.oaPackg.deleteOaPackg", oaPackg);
	}

}
