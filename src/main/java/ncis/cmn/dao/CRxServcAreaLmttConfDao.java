package ncis.cmn.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ncis.cmn.entity.RxServcAreaLmttConf;

/**
 * 서비스영역제한설정 DAO - 공통(등록/수정/삭제)
 *
 * @author x
 */

@Repository("cRxServcAreaLmttConfDao")
public class CRxServcAreaLmttConfDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 서비스영역제한설정 등록
	 * @param rxServcArea
	 */
	public void insertRxServcAreaLmttConf(RxServcAreaLmttConf RxServcAreaLmttConf) {
		sqlSession.insert("ncis.sql.cmn.rxServcAreaLmttConf.insertRxServcAreaLmttConf", RxServcAreaLmttConf);
	}

	/**
	 * 서비스영역제한설정 수정
	 * @param rxServcArea
	 */
	public void updateRxServcAreaLmttConf(RxServcAreaLmttConf RxServcAreaLmttConf) {
		sqlSession.update("ncis.sql.cmn.rxServcAreaLmttConf.updateRxServcAreaLmttConf", RxServcAreaLmttConf);
	}


	/**
	 * 서비스영역제한설정 삭제
	 * @param rxServcArea
	 */
	public void deleteRxServcAreaLmttConf(RxServcAreaLmttConf RxServcAreaLmttConf) {
		sqlSession.delete("ncis.sql.cmn.rxServcAreaLmttConf.deleteRxServcAreaLmttConf", RxServcAreaLmttConf);
	}

}
