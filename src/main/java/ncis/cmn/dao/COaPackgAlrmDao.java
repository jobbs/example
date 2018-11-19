package ncis.cmn.dao;

import ncis.cmn.entity.OaPackgAlrm;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 패치알림 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cOaPackgAlrmDao")
public class COaPackgAlrmDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 패치알림 등록
	 * @param oaPackgAlrm
	 */
	public void insertOaPackgAlrm(OaPackgAlrm oaPackgAlrm) {
		sqlSession.insert("ncis.sql.cmn.oaPackgAlrm.insertOaPackgAlrm", oaPackgAlrm);
	}

	/**
	 * 패치알림 수정
	 * @param oaPackgAlrm
	 */
	public void updateOaPackgAlrm(OaPackgAlrm oaPackgAlrm) {
		sqlSession.update("ncis.sql.cmn.oaPackgAlrm.updateOaPackgAlrm", oaPackgAlrm);
	}

	/**
	 * 패치알림 삭제
	 * @param oaPackgAlrm
	 */
	public void deleteOaPackgAlrm(OaPackgAlrm oaPackgAlrm) {
		sqlSession.update("ncis.sql.cmn.oaPackgAlrm.deleteOaPackgAlrm", oaPackgAlrm);
	}

}
