package ncis.cmn.dao;

import ncis.cmn.entity.RcPm;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 물리서버 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRcPmDao")
public class CRcPmDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 물리서버 등록
	 * @param rcPm
	 */
	public void insertRcPm(RcPm rcPm) {
		sqlSession.insert("ncis.sql.cmn.rcPm.insertRcPm", rcPm);
	}

	/**
	 * 물리서버 수정
	 * @param rcPm
	 */
	public void updateRcPm(RcPm rcPm) {
		sqlSession.update("ncis.sql.cmn.rcPm.updateRcPm", rcPm);
	}

	/**
	 * 물리서버 삭제
	 * @param rcPm
	 */
	public void deleteRcPm(RcPm rcPm) {
		sqlSession.update("ncis.sql.cmn.rcPm.deleteRcPm", rcPm);
	}

	/**
	 * 물리서버구성ID 수정
	 * @param rcPm
	 */
	public void updateRcPmCompId(RcPm rcPm) {
		sqlSession.update("ncis.sql.cmn.rcPm.updateRcPmCompId", rcPm);
	}

	/**
	 * 물리서버 상태 수정
	 * @param rcPm
	 */
	public void updateRcPmStat(RcPm rcPm) {
		sqlSession.update("ncis.sql.cmn.rcPm.updateRcPmStat", rcPm);
	}

}
