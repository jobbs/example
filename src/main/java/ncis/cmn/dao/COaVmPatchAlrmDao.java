package ncis.cmn.dao;

import ncis.cmn.entity.OaVmPatchAlrm;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 가상서버별패치알림 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cOaVmPatchAlrmDao")
public class COaVmPatchAlrmDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 가상서버별패치알림 등록
	 * @param oaVmPatchAlrm
	 */
	public void insertOaVmPatchAlrm(OaVmPatchAlrm oaVmPatchAlrm) {
		sqlSession.insert("ncis.sql.cmn.oaVmPatchAlrm.insertOaVmPatchAlrm", oaVmPatchAlrm);
	}

	/**
	 * 가상서버별패치알림 수정
	 * @param oaVmPatchAlrm
	 */
	public void updateOaVmPatchAlrm(OaVmPatchAlrm oaVmPatchAlrm) {
		sqlSession.update("ncis.sql.cmn.oaVmPatchAlrm.updateOaVmPatchAlrm", oaVmPatchAlrm);
	}

	/**
	 * 가상서버별패치알림 삭제
	 * @param oaVmPatchAlrm
	 */
	public void deleteOaVmPatchAlrm(OaVmPatchAlrm oaVmPatchAlrm) {
		sqlSession.update("ncis.sql.cmn.oaVmPatchAlrm.deleteOaVmPatchAlrm", oaVmPatchAlrm);
	}

}
