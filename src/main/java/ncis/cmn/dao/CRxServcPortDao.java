package ncis.cmn.dao;

import ncis.cmn.entity.RxServcPort;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 서비스 포트 DAO - 공통(등록/수정/삭제)
 *
 * @author x
 */

@Repository("cRxServcPortDao")
public class CRxServcPortDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 서비스 포트 생성
	 * @param rxServcPort
	 */

	public void insertRxServcPort(RxServcPort rxServcPort) {
		sqlSession.insert("ncis.sql.cmn.rxServcPort.insertRxServcPort", rxServcPort);
	}

	/**
	 * 서비스 포트 수정
	 * @param rxServcPort
	 */
	public void updateRxServcPort(RxServcPort rxServcPort) {
		sqlSession.insert("ncis.sql.cmn.rxServcPort.updateRxServcPort", rxServcPort);
	}

	/**
	 * 서비스 포트 삭제
	 * @param rxServcPort
	 */
	public void deleteRxServcPort(RxServcPort rxServcPort) {
		sqlSession.insert("ncis.sql.cmn.rxServcPort.deleteRxServcPort", rxServcPort);
	}
}
