package ncis.cmn.dao;

import ncis.cmn.entity.RxServc;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 서비스 DAO - 공통(등록/수정/삭제)
 *
 * @author x
 */

@Repository("cRxServcDao")
public class CRxServcDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 서비스 생성
	 * @param rxServc
	 */

	public void insertRxServc(RxServc rxServc) {
		sqlSession.insert("ncis.sql.cmn.rxServc.insertRxServc", rxServc);
	}

	/**
	 * 서비스 수정
	 * @param rxServc
	 */
	public void updateRxServc(RxServc rxServc) {
		sqlSession.insert("ncis.sql.cmn.rxServc.updateRxServc", rxServc);
	}

	/**
	 * 서비스 상태 수정
	 * @param rxServc
	 */
	public void updateRxServcStat(RxServc rxServc) {
		sqlSession.insert("ncis.sql.cmn.rxServc.updateRxServcStat", rxServc);
	}


	/**
	 * 서비스 삭제
	 * @param rxServc
	 */
	public void deleteRxServc(RxServc rxServc) {
		sqlSession.insert("ncis.sql.cmn.rxServc.deleteRxServc", rxServc);
	}
}
