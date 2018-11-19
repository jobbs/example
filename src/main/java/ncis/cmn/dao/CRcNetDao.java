package ncis.cmn.dao;

import ncis.cmn.entity.RcNet;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 망 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRcNetDao")
public class CRcNetDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 망 등록
	 * @param rcNet
	 */
	public void insertRcNet(RcNet rcNet) {
		sqlSession.insert("ncis.sql.cmn.rcNet.insertRcNet", rcNet);
	}

	/**
	 * 망 수정
	 * @param rcNet
	 */
	public void updateRcNet(RcNet rcNet) {
		sqlSession.update("ncis.sql.cmn.rcNet.updateRcNet", rcNet);
	}

	/**
	 * 망 삭제
	 * @param rcNet
	 */
	public void deleteRcNet(String netId) {
		sqlSession.update("ncis.sql.cmn.rcNet.deleteRcNet", netId);
	}

}
