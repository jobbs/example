package ncis.cmn.dao;

import ncis.cmn.entity.RxBldHstry;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 빌드이력 DAO - 공통(등록/수정/삭제)
 *
 * @author x
 */

@Repository("cRxBldHstryDao")
public class CRxBldHstryDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 빌드이력 생성
	 * @param rxBldHstry
	 */

	public void insertRxBldHstry(RxBldHstry rxBldHstry) {
		sqlSession.insert("ncis.sql.cmn.rxBldHstry.insertRxBldHstry", rxBldHstry);
	}

	/**
	 * 빌드이력 수정
	 * @param rxBldHstry
	 */
	public void updateRxBldHstry(RxBldHstry rxBldHstry) {
		sqlSession.insert("ncis.sql.cmn.rxBldHstry.updateRxBldHstry", rxBldHstry);
	}

	/**
	 * 빌드이력 삭제
	 * @param rxBldHstry
	 */
	public void deleteRxBldHstry(RxBldHstry rxBldHstry) {
		sqlSession.insert("ncis.sql.cmn.rxBldHstry.deleteRxBldHstry", rxBldHstry);
	}

	/**
	 * 빌드이력 상태 수정
	 * @param rxBldHstry
	 */
	public void updateRxBldHstryStat(RxBldHstry rxBldHstry) {
		sqlSession.insert("ncis.sql.cmn.rxBldHstry.updateRxBldHstryStat", rxBldHstry);
	}

	/**
	 * 빌드 동기화 입력
	 * @param rxBldHstry
	 */
	public void insertRxBldSync(RxBldHstry rxBldHstry) {
		sqlSession.insert("ncis.sql.cmn.rxBldHstry.insertRxBldSync", rxBldHstry);

	}

}
