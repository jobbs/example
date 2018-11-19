package ncis.cmn.dao;

import ncis.cmn.entity.RnSlb;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * SLB DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRnSlbDao")
public class CRnSlbDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * SLB 등록
	 * @param rnSlb
	 */
	public void insertRnSlb(RnSlb rnSlb) {
		sqlSession.insert("ncis.sql.cmn.rnSlb.insertRnSlb", rnSlb);
	}

	/**
	 * SLB 수정
	 * @param rnSlb
	 */
	public void updateRnSlb(RnSlb rnSlb) {
		sqlSession.update("ncis.sql.cmn.rnSlb.updateRnSlb", rnSlb);
	}

	/**
	 * SLB 삭제
	 * @param rnSlb
	 */
	public void deleteRnSlb(RnSlb rnSlb) {
		sqlSession.update("ncis.sql.cmn.rnSlb.deleteRnSlb", rnSlb);
	}

	/**
	 * SLB merge
	 * @param rnSlb
	 */
	public void mergeRnSlb(RnSlb rnSlb){
		sqlSession.update("ncis.sql.cmn.rnSlb.mergeRnSlb", rnSlb);
	}

}
