package ncis.cmn.dao;

import ncis.cmn.entity.RcVmSnapsht;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 가상서버스냅샷 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRcVmSnapshtDao")
public class CRcVmSnapshtDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 가상서버스냅샷 등록
	 * @param rcVmSnapsht
	 */
	public void insertRcVmSnapsht(RcVmSnapsht rcVmSnapsht) {
		sqlSession.insert("ncis.sql.cmn.rcVmSnapsht.insertRcVmSnapsht", rcVmSnapsht);
	}

	/**
	 * 가상서버스냅샷 수정
	 * @param rcVmSnapsht
	 */
	public void updateRcVmSnapsht(RcVmSnapsht rcVmSnapsht) {
		sqlSession.update("ncis.sql.cmn.rcVmSnapsht.updateRcVmSnapsht", rcVmSnapsht);
	}

	/**
	 * 가상서버스냅샷 삭제
	 * @param rcVmSnapsht
	 */
	public void deleteRcVmSnapsht(RcVmSnapsht rcVmSnapsht) {
		sqlSession.update("ncis.sql.cmn.rcVmSnapsht.deleteRcVmSnapsht", rcVmSnapsht);
	}

}
