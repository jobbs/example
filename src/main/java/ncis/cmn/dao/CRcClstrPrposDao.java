package ncis.cmn.dao;

import ncis.cmn.entity.RcClstrPrpos;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 클러스터용도 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRcClstrPrposDao")
public class CRcClstrPrposDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 클러스터용도 등록
	 * @param rcClstrPrpos
	 */
	public void insertRcClstrPrpos(RcClstrPrpos rcClstrPrpos) {
		sqlSession.insert("ncis.sql.cmn.rcClstrPrpos.insertRcClstrPrpos", rcClstrPrpos);
	}

	/**
	 * 클러스터용도 삭제
	 * @param rcClstrPrpos
	 */
	public void deleteRcClstrPrpos(RcClstrPrpos rcClstrPrpos) {
		sqlSession.update("ncis.sql.cmn.rcClstrPrpos.deleteRcClstrPrpos", rcClstrPrpos);
	}

}
