package ncis.cmn.dao;

import ncis.cmn.entity.OaPatchAlrmRelateVer;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 패치알림관련패키지버전 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cOaPatchAlrmRelateVerDao")
public class COaPatchAlrmRelateVerDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 패치알림관련패키지버전 등록
	 * @param oaPatchAlrmRelateVer
	 */
	public void insertOaPatchAlrmRelateVer(OaPatchAlrmRelateVer oaPatchAlrmRelateVer) {
		sqlSession.insert("ncis.sql.cmn.oaPatchAlrmRelateVer.insertOaPatchAlrmRelateVer", oaPatchAlrmRelateVer);
	}

	/**
	 * 패치알림관련패키지버전 수정
	 * @param oaPatchAlrmRelateVer
	 */
	public void updateOaPatchAlrmRelateVer(OaPatchAlrmRelateVer oaPatchAlrmRelateVer) {
		sqlSession.update("ncis.sql.cmn.oaPatchAlrmRelateVer.updateOaPatchAlrmRelateVer", oaPatchAlrmRelateVer);
	}

	/**
	 * 패치알림관련패키지버전 삭제
	 * @param oaPatchAlrmRelateVer
	 */
	public void deleteOaPatchAlrmRelateVer(OaPatchAlrmRelateVer oaPatchAlrmRelateVer) {
		sqlSession.update("ncis.sql.cmn.oaPatchAlrmRelateVer.deleteOaPatchAlrmRelateVer", oaPatchAlrmRelateVer);
	}

}
