package ncis.cmn.dao;

import ncis.cmn.entity.RcSrvrOprServc;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 서버관련운영서비스 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRcSrvrOprServcDao")
public class CRcSrvrOprServcDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 서버관련운영서비스 등록
	 * @param rcSrvrOprServc
	 */
	public void insertRcSrvrOprServc(RcSrvrOprServc rcSrvrOprServc) {
		sqlSession.insert("ncis.sql.cmn.rcSrvrOprServc.insertRcSrvrOprServc", rcSrvrOprServc);
	}

	/**
	 * 서버관련운영서비스 수정
	 * @param rcSrvrOprServc
	 */
	public void updateRcSrvrOprServc(RcSrvrOprServc rcSrvrOprServc) {
		sqlSession.update("ncis.sql.cmn.rcSrvrOprServc.updateRcSrvrOprServc", rcSrvrOprServc);
	}

	/**
	 * 서버관련운영서비스 삭제
	 * @param rcSrvrOprServc
	 */
	public void deleteRcSrvrOprServc(RcSrvrOprServc rcSrvrOprServc) {
		sqlSession.update("ncis.sql.cmn.rcSrvrOprServc.deleteRcSrvrOprServc", rcSrvrOprServc);
	}

}
