package ncis.cmn.dao;

import ncis.cmn.entity.RxBldConf;
import ncis.cmn.entity.RxBldHstry;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 빌드설정 DAO - 공통(등록/수정/삭제)
 *
 * @author x
 */

@Repository("cRxBldConfDao")
public class CRxBldConfDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 빌드설정 생성
	 * @param rxBldConf
	 */

	public void insertRxBldConf(RxBldConf rxBldConf) {
		sqlSession.insert("ncis.sql.cmn.rxBldConf.insertRxBldConf", rxBldConf);
	}

	/**
	 * 빌드설정 수정
	 * @param rxBldConf
	 */
	public void updateRxBldConf(RxBldConf rxBldConf) {
		sqlSession.insert("ncis.sql.cmn.rxBldConf.updateRxBldConf", rxBldConf);
	}

	/**
	 * 빌드설정 삭제
	 * @param rxBldConf
	 */
	public void deleteRxBldConf(RxBldConf rxBldConf) {
		sqlSession.insert("ncis.sql.cmn.rxBldConf.deleteRxBldConf", rxBldConf);
	}

	/**
	 * 빌드 설정(빌드상세) 수정
	 * @param bldConf
	 */
	public void updateRxBldConfBldVer(RxBldConf bldConf) {
		sqlSession.update("ncis.sql.cmn.rxBldConf.updateRxBldConfBldVer", bldConf);

	}

	/**
	 * 빌드 설정(빌드상세) 버전정보 수정
	 * @param bldConf
	 */
	public void updateBldConf(RxBldConf bldConf) {
		sqlSession.update("ncis.sql.cmn.rxBldConf.updateBldConf", bldConf);

	}

	/**
	 * 빌드 이력 (빌드상세) 생성
	 * @param bldHstry
	 */
	public void insertBldHstry(RxBldHstry bldHstry) {
		sqlSession.insert("ncis.sql.cmn.rxBldConf.insertBldHstry", bldHstry);
	}

	/**
	 * 빌드 설정(동기화) 수정
	 * @param rxBldConf
	 */
	public void updateBldConfSync(RxBldConf rxBldConf) {
		sqlSession.update("ncis.sql.cmn.rxBldConf.updateBldConfSync", rxBldConf);
	}
}
