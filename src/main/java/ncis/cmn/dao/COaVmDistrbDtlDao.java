package ncis.cmn.dao;

import ncis.cmn.entity.OaVmDistrbDtl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 가상서버별배포상세(배포이력 포함) DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cOaVmDistrbDtlDao")
public class COaVmDistrbDtlDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 가상서버별배포상세(배포이력 포함) 등록
	 * @param oaVmDistrbDtl
	 */
	public void insertOaVmDistrbDtl(OaVmDistrbDtl oaVmDistrbDtl) {
		sqlSession.insert("ncis.sql.cmn.oaVmDistrbDtl.insertOaVmDistrbDtl", oaVmDistrbDtl);
	}

	/**
	 * 가상서버별배포상세(배포이력 포함) 수정
	 * @param oaVmDistrbDtl
	 */
	public void updateOaVmDistrbDtl(OaVmDistrbDtl oaVmDistrbDtl) {
		sqlSession.update("ncis.sql.cmn.oaVmDistrbDtl.updateOaVmDistrbDtl", oaVmDistrbDtl);
	}

	/**
	 * 가상서버별배포상세(배포이력 포함) 삭제
	 * @param oaVmDistrbDtl
	 */
	public void deleteOaVmDistrbDtl(OaVmDistrbDtl oaVmDistrbDtl) {
		sqlSession.update("ncis.sql.cmn.oaVmDistrbDtl.deleteOaVmDistrbDtl", oaVmDistrbDtl);
	}

}
