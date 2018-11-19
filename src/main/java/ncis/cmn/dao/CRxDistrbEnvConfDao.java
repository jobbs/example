package ncis.cmn.dao;

import ncis.cmn.entity.RxDistrbEnvConf;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 배포환경변수 DAO - 공통(등록/수정/삭제)
 *
 * @author x
 */

@Repository("cRxDistrbEnvConfDao")
public class CRxDistrbEnvConfDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 배포환경변수 등록
	 * @param rxDistrbEnvConf
	 */
	public void insertRxDistrbEnvConf(RxDistrbEnvConf rxDistrbEnvConf) {
		sqlSession.insert("ncis.sql.cmn.rxDistrbEnvConf.insertRxDistrbEnvConf", rxDistrbEnvConf);
	}

	/**
	 * 배포환경변수 수정
	 * @param rxDistrbEnvConf
	 */
	public void updateRxDistrbEnvConf(RxDistrbEnvConf rxDistrbEnvConf) {
		sqlSession.update("ncis.sql.cmn.rxDistrbEnvConf.updateRxDistrbEnvConf", rxDistrbEnvConf);
	}


	/**
	 * 배포환경변수 삭제
	 * @param rxDistrbEnvConf
	 */
	public void deleteRxDistrbEnvConf(RxDistrbEnvConf rxDistrbEnvConf) {
		sqlSession.delete("ncis.sql.cmn.rxDistrbEnvConf.deleteRxDistrbEnvConf", rxDistrbEnvConf);
	}

}
