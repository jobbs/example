package ncis.cmn.dao;

import ncis.cmn.entity.OaAlrmTrgt;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 알림대상자 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cOaAlrmTrgtDao")
public class COaAlrmTrgtDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 알림대상자 등록
	 * @param oaAlrmTrgt
	 */
	public void insertOaAlrmTrgt(OaAlrmTrgt oaAlrmTrgt) {
		sqlSession.insert("ncis.sql.cmn.oaAlrmTrgt.insertOaAlrmTrgt", oaAlrmTrgt);
	}

	/**
	 * 알림대상자 수정
	 * @param oaAlrmTrgt
	 */
	public void updateOaAlrmTrgt(OaAlrmTrgt oaAlrmTrgt) {
		sqlSession.update("ncis.sql.cmn.oaAlrmTrgt.updateOaAlrmTrgt", oaAlrmTrgt);
	}

	/**
	 * 알림대상자 삭제
	 * @param oaAlrmTrgt
	 */
	public void deleteOaAlrmTrgt(OaAlrmTrgt oaAlrmTrgt) {
		sqlSession.update("ncis.sql.cmn.oaAlrmTrgt.deleteOaAlrmTrgt", oaAlrmTrgt);
	}

}
