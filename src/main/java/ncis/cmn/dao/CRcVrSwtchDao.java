package ncis.cmn.dao;

import ncis.cmn.entity.RcVrSwtch;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 가상스위치(VLAN) DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRcVrSwtchDao")
public class CRcVrSwtchDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 가상스위치(VLAN) 등록
	 * @param rcVrSwtch
	 */
	public void insertRcVrSwtch(RcVrSwtch rcVrSwtch) {
		sqlSession.insert("ncis.sql.cmn.rcVrSwtch.insertRcVrSwtch", rcVrSwtch);
	}

	/**
	 * 가상스위치(VLAN) 수정
	 * @param rcVrSwtch
	 */
	public void updateRcVrSwtch(RcVrSwtch rcVrSwtch) {
		sqlSession.update("ncis.sql.cmn.rcVrSwtch.updateRcVrSwtch", rcVrSwtch);
	}

	/**
	 * 가상스위치(VLAN) 삭제
	 * @param rcVrSwtch
	 */
	public void deleteRcVrSwtch(RcVrSwtch rcVrSwtch) {
		sqlSession.update("ncis.sql.cmn.rcVrSwtch.deleteRcVrSwtch", rcVrSwtch);
	}

}
