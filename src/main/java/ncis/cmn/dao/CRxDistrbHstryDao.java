package ncis.cmn.dao;

import ncis.cmn.entity.RxDistrbHstry;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 배포이력 DAO - 공통(등록/수정/삭제)
 *
 * @author x
 */

@Repository("cRxDistrbHstryDao")
public class CRxDistrbHstryDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 배포이력 등록
	 * @param rxDistrbHstry
	 */
	public void insertRxDistrbHstry(RxDistrbHstry rxDistrbHstry) {
		sqlSession.insert("ncis.sql.cmn.rxDistrbHstry.insertRxDistrbHstry", rxDistrbHstry);
	}


	/**
	 * 배포이력 삭제
	 * @param rxDistrbHstry
	 */
	public void deleteRxDistrbHstry(RxDistrbHstry rxDistrbHstry) {
		sqlSession.update("ncis.sql.cmn.rxDistrbHstry.deleteRxDistrbHstry", rxDistrbHstry);
	}

	/**
	 * 배포이력 상테 수정
	 * @param rxDistrbHstry
	 */
	public void updateRxDistrbHstryStat(RxDistrbHstry rxDistrbHstry) {
		sqlSession.update("ncis.sql.cmn.rxDistrbHstry.updateRxDistrbHstryStat", rxDistrbHstry);
	}


	/**
	 * @param rxDistrbHstry
	 */
	public void insertRxDistrbHstrySync(RxDistrbHstry rxDistrbHstry) {
		sqlSession.update("ncis.sql.cmn.rxDistrbHstry.insertRxDistrbHstrySync", rxDistrbHstry);

	}



}
