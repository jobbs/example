package ncis.cmn.dao;

import ncis.cmn.entity.RsVrStrg;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 가상스토리지 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRsVrStrgDao")
public class CRsVrStrgDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 가상스토리지 등록
	 * @param rsVrStrg
	 */
	public void insertRsVrStrg(RsVrStrg rsVrStrg) {
		sqlSession.insert("ncis.sql.cmn.rsVrStrg.insertRsVrStrg", rsVrStrg);
	}

	/**
	 * 가상스토리지 수정
	 * @param rsVrStrg
	 */
	public void updateRsVrStrg(RsVrStrg rsVrStrg) {
		sqlSession.update("ncis.sql.cmn.rsVrStrg.updateRsVrStrg", rsVrStrg);
	}

	/**
	 * 가상스토리지 삭제
	 * @param rsVrStrg
	 */
	public void deleteRsVrStrg(RsVrStrg rsVrStrg) {
		sqlSession.update("ncis.sql.cmn.rsVrStrg.deleteRsVrStrg", rsVrStrg);
	}

}
