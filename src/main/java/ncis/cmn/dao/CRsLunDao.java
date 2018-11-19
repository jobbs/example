package ncis.cmn.dao;

import ncis.cmn.entity.RsLun;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * LUN DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRsLunDao")
public class CRsLunDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * LUN 등록
	 * @param rsLun
	 */
	public void insertRsLun(RsLun rsLun) {
		sqlSession.insert("ncis.sql.cmn.rsLun.insertRsLun", rsLun);
	}

	/**
	 * LUN 수정
	 * @param rsLun
	 */
	public void updateRsLun(RsLun rsLun) {
		sqlSession.update("ncis.sql.cmn.rsLun.updateRsLun", rsLun);
	}

	/**
	 * LUN 삭제
	 * @param rsLun
	 */
	public void deleteRsLun(RsLun rsLun) {
		sqlSession.update("ncis.sql.cmn.rsLun.deleteRsLun", rsLun);
	}

}
