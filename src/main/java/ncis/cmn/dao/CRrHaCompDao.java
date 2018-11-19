package ncis.cmn.dao;

import ncis.cmn.entity.RrHaComp;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * HA구성 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRrHaCompDao")
public class CRrHaCompDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * HA구성 등록
	 * @param rrHaComp
	 */
	public void insertRrHaComp(RrHaComp rrHaComp) {
		sqlSession.insert("ncis.sql.cmn.rrHaComp.insertRrHaComp", rrHaComp);
	}

	/**
	 * HA구성 수정
	 * @param rrHaComp
	 */
	public void updateRrHaComp(RrHaComp rrHaComp) {
		sqlSession.update("ncis.sql.cmn.rrHaComp.updateRrHaComp", rrHaComp);
	}

	/**
	 * HA구성 삭제
	 * @param rrHaComp
	 */
	public void deleteRrHaComp(RrHaComp rrHaComp) {
		sqlSession.update("ncis.sql.cmn.rrHaComp.deleteRrHaComp", rrHaComp);
	}

}
