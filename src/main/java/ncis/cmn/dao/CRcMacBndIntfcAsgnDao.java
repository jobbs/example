package ncis.cmn.dao;

import ncis.cmn.entity.RcMacBndIntfcAsgn;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * MAC대역인터페이스할당 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRcMacBndIntfcAsgnDao")
public class CRcMacBndIntfcAsgnDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * MAC대역인터페이스할당 등록
	 * @param rcMacBndIntfcAsgn
	 */
	public void insertRcMacBndIntfcAsgn(RcMacBndIntfcAsgn rcMacBndIntfcAsgn) {
		sqlSession.insert("ncis.sql.cmn.rcMacBndIntfcAsgn.insertRcMacBndIntfcAsgn", rcMacBndIntfcAsgn);
	}

	/**
	 * MAC대역인터페이스할당 수정
	 * @param rcMacBndIntfcAsgn
	 */
	public void updateRcMacBndIntfcAsgn(RcMacBndIntfcAsgn rcMacBndIntfcAsgn) {
		sqlSession.update("ncis.sql.cmn.rcMacBndIntfcAsgn.updateRcMacBndIntfcAsgn", rcMacBndIntfcAsgn);
	}

	/**
	 * MAC대역인터페이스할당 삭제
	 * @param rcMacBndIntfcAsgn
	 */
	public void deleteRcMacBndIntfcAsgn(RcMacBndIntfcAsgn rcMacBndIntfcAsgn) {
		sqlSession.update("ncis.sql.cmn.rcMacBndIntfcAsgn.deleteRcMacBndIntfcAsgn", rcMacBndIntfcAsgn);
	}

}
