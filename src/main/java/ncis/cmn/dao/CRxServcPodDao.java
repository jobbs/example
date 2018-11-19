package ncis.cmn.dao;

import ncis.cmn.entity.RxServcPod;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Pod DAO - 공통(등록/수정/삭제)
 *
 * @author x
 */

@Repository("cRxServcPodDao")
public class CRxServcPodDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * Pod 등록
	 * @param rxServcPod
	 */
	public void insertRxServcPod(RxServcPod rxServcPod) {
		sqlSession.insert("ncis.sql.cmn.rxServcPod.insertRxServcPod", rxServcPod);
	}


	/**
	 * Pod 삭제
	 * @param rxServcPod
	 */
	public void deleteRxServcPod(RxServcPod rxServcPod) {
		sqlSession.update("ncis.sql.cmn.rxServcPod.deleteRxServcPod", rxServcPod);
	}


	/**
	 * Pod 수정
	 * @param rxServcPod
	 */
	public void updateRxServcPod(RxServcPod rxServcPod) {
		sqlSession.update("ncis.sql.cmn.rxServcPod.updateRxServcPod", rxServcPod);
	}

}
