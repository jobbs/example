package ncis.cmn.dao;

import ncis.cmn.entity.OaVmInstlPackg;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 가상서버설치패키지 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cOaVmInstlPackgDao")
public class COaVmInstlPackgDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 가상서버설치패키지 등록
	 * @param oaVmInstlPackg
	 */
	public void insertOaVmInstlPackg(OaVmInstlPackg oaVmInstlPackg) {
		sqlSession.insert("ncis.sql.cmn.oaVmInstlPackg.insertOaVmInstlPackg", oaVmInstlPackg);
	}

	/**
	 * 가상서버설치패키지 수정
	 * @param oaVmInstlPackg
	 */
	public void updateOaVmInstlPackg(OaVmInstlPackg oaVmInstlPackg) {
		sqlSession.update("ncis.sql.cmn.oaVmInstlPackg.updateOaVmInstlPackg", oaVmInstlPackg);
	}

	/**
	 * 가상서버설치패키지 삭제
	 * @param oaVmInstlPackg
	 */
	public void deleteOaVmInstlPackg(OaVmInstlPackg oaVmInstlPackg) {
		sqlSession.update("ncis.sql.cmn.oaVmInstlPackg.deleteOaVmInstlPackg", oaVmInstlPackg);
	}

}
