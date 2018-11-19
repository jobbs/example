package ncis.cmn.dao;

import ncis.cmn.entity.RcNetwkIntfc;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 네트워크인터페이스 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRcNetwkIntfcDao")
public class CRcNetwkIntfcDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 네트워크인터페이스 등록
	 * @param rcNetwkIntfc
	 */
	public void insertRcNetwkIntfc(RcNetwkIntfc rcNetwkIntfc) {
		sqlSession.insert("ncis.sql.cmn.rcNetwkIntfc.insertRcNetwkIntfc", rcNetwkIntfc);
	}

	/**
	 * 네트워크인터페이스 수정
	 * @param rcNetwkIntfc
	 */
	public void updateRcNetwkIntfc(RcNetwkIntfc rcNetwkIntfc) {
		sqlSession.update("ncis.sql.cmn.rcNetwkIntfc.updateRcNetwkIntfc", rcNetwkIntfc);
	}

	/**
	 * 네트워크인터페이스 삭제
	 * @param rcNetwkIntfc
	 */
	public void deleteRcNetwkIntfc(RcNetwkIntfc rcNetwkIntfc) {
		sqlSession.update("ncis.sql.cmn.rcNetwkIntfc.deleteRcNetwkIntfc", rcNetwkIntfc);
	}

}
