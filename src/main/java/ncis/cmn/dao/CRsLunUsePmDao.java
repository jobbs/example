package ncis.cmn.dao;

import ncis.cmn.entity.RsLunUsePm;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * LUN사용물리서버 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRsLunUsePmDao")
public class CRsLunUsePmDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * LUN사용물리서버 등록
	 * @param rsLunUsePm
	 */
	public void insertRsLunUsePm(RsLunUsePm rsLunUsePm) {
		sqlSession.insert("ncis.sql.cmn.rsLunUsePm.insertRsLunUsePm", rsLunUsePm);
	}

	/**
	 * LUN사용물리서버 수정
	 * @param rsLunUsePm
	 */
	public void updateRsLunUsePm(RsLunUsePm rsLunUsePm) {
		sqlSession.update("ncis.sql.cmn.rsLunUsePm.updateRsLunUsePm", rsLunUsePm);
	}

	/**
	 * LUN사용물리서버 삭제
	 * @param rsLunUsePm
	 */
	public void deleteRsLunUsePm(RsLunUsePm rsLunUsePm) {
		sqlSession.update("ncis.sql.cmn.rsLunUsePm.deleteRsLunUsePm", rsLunUsePm);
	}

}
