package ncis.cmn.dao;

import ncis.cmn.entity.RxPv;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * PV DAO - 공통(등록/수정/삭제)
 *
 * @author x
 */

@Repository("cRxPvDao")
public class CRxPvDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * PV 등록
	 * @param rxPv
	 */
	public void insertRxPv(RxPv rxPv) {
		sqlSession.insert("ncis.sql.cmn.rxPv.insertRxPv", rxPv);
	}

	/**
	 * PV 수정
	 * @param rxPv
	 */
	public void updateRxPv(RxPv rxPv) {
		sqlSession.insert("ncis.sql.cmn.rxPv.updateRxPv", rxPv);
	}


	/**
	 * PV 삭제
	 * @param rxPv
	 */
	public void deleteRxPv(RxPv rxPv) {
		sqlSession.delete("ncis.sql.cmn.rxPv.deleteRxPv", rxPv);
	}

}
