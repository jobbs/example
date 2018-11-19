package ncis.cmn.dao;

import ncis.cmn.entity.RcMacBnd;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * MAC 대역 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRcMacBndDao")
public class CRcMacBndDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * MAC 대역 등록
	 * @param rcMacBnd
	 */
	public void insertRcMacBnd(RcMacBnd rcMacBnd) {
		sqlSession.insert("ncis.sql.cmn.rcMacBnd.insertRcMacBnd", rcMacBnd);
	}

	/**
	 * MAC 대역 수정
	 * @param rcMacBnd
	 */
	public void updateRcMacBnd(RcMacBnd rcMacBnd) {
		sqlSession.update("ncis.sql.cmn.rcMacBnd.updateRcMacBnd", rcMacBnd);
	}

	/**
	 * MAC 대역 삭제
	 * @param rcMacBnd
	 */
	public void deleteRcMacBnd(RcMacBnd rcMacBnd) {
		sqlSession.update("ncis.sql.cmn.rcMacBnd.deleteRcMacBnd", rcMacBnd);
	}

}
