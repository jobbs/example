package ncis.cmn.dao;

import ncis.cmn.entity.RcClstr;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 클러스터 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRcClstrDao")
public class CRcClstrDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 클러스터 등록
	 * @param rcClstr
	 */
	public void insertRcClstr(RcClstr rcClstr) {
		sqlSession.insert("ncis.sql.cmn.rcClstr.insertRcClstr", rcClstr);
	}

	/**
	 * 클러스터 수정
	 * @param rcClstr
	 */
	public void updateRcClstr(RcClstr rcClstr) {
		sqlSession.update("ncis.sql.cmn.rcClstr.updateRcClstr", rcClstr);
	}

	/**
	 * 클러스터 삭제
	 * @param rcClstr
	 */
	public void deleteRcClstr(RcClstr rcClstr) {
		sqlSession.update("ncis.sql.cmn.rcClstr.deleteRcClstr", rcClstr);
	}

}
