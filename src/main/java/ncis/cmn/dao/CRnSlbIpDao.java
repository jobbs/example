package ncis.cmn.dao;

import ncis.cmn.entity.RnSlbIp;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * SLB_IP DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRnSlbIpDao")
public class CRnSlbIpDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * SLB_IP 등록
	 * @param rnSlbIp
	 */
	public void insertRnSlbIp(RnSlbIp rnSlbIp) {
		sqlSession.insert("ncis.sql.cmn.rnSlbIp.insertRnSlbIp", rnSlbIp);
	}

	/**
	 * SLB_IP 수정
	 * @param rnSlbIp
	 */
	public void updateRnSlbIp(RnSlbIp rnSlbIp) {
		sqlSession.update("ncis.sql.cmn.rnSlbIp.updateRnSlbIp", rnSlbIp);
	}

	/**
	 * SLB_IP 삭제
	 * @param rnSlbIp
	 */
	public void deleteRnSlbIp(RnSlbIp rnSlbIp) {
		sqlSession.update("ncis.sql.cmn.rnSlbIp.deleteRnSlbIp", rnSlbIp);
	}

	/**
	 * SLB_IP merge
	 * @param rnSlb
	 */
	public void mergeRnSlbIp(RnSlbIp rnSlbIp){
		sqlSession.update("ncis.sql.cmn.rnSlbIp.mergeRnSlbIp", rnSlbIp);
	}

}
