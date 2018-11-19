package ncis.cmn.dao;

import ncis.cmn.entity.RxServcRoute;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 서비스 라우트 DAO - 공통(등록/수정/삭제)
 *
 * @author x
 */

@Repository("cRxServcRouteDao")
public class CRxServcRouteDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 서비스 라우트 생성
	 * @param rxServcRoute
	 */

	public void insertRxServcRoute(RxServcRoute rxServcRoute) {
		sqlSession.insert("ncis.sql.cmn.rxServcRoute.insertRxServcRoute", rxServcRoute);
	}

	/**
	 * 서비스 라우트 수정
	 * @param rxServcRoute
	 */
	public void updateRxServcRoute(RxServcRoute rxServcRoute) {
		sqlSession.insert("ncis.sql.cmn.rxServcRoute.updateRxServcRoute", rxServcRoute);
	}

	/**
	 * 서비스 라우트 삭제
	 * @param rxServcRoute
	 */
	public void deleteRxServcRoute(RxServcRoute rxServcRoute) {
		sqlSession.insert("ncis.sql.cmn.rxServcRoute.deleteRxServcRoute", rxServcRoute);
	}
}
