package ncis.cmn.dao;

import ncis.cmn.entity.RcZone;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 존 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRcZoneDao")
public class CRcZoneDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 존 등록
	 * @param rcZone
	 */
	public void insertRcZone(RcZone rcZone) {
		sqlSession.insert("ncis.sql.cmn.rcZone.insertRcZone", rcZone);
	}

	/**
	 * 존 수정
	 * @param rcZone
	 */
	public void updateRcZone(RcZone rcZone) {
		sqlSession.update("ncis.sql.cmn.rcZone.updateRcZone", rcZone);
	}

	public void deleteRcZone(String zoneId) {
	    sqlSession.delete("ncis.sql.cmn.rcZone.deleteRcZone", zoneId);
	}
}
