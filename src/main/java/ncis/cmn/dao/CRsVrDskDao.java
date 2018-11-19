package ncis.cmn.dao;

import ncis.cmn.entity.RsVrDsk;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 가상디스크 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRsVrDskDao")
public class CRsVrDskDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 가상디스크 등록
	 * @param rsVrDsk
	 */
	public void insertRsVrDsk(RsVrDsk rsVrDsk) {
		sqlSession.insert("ncis.sql.cmn.rsVrDsk.insertRsVrDsk", rsVrDsk);
	}

	/**
	 * 가상디스크 수정
	 * @param rsVrDsk
	 */
	public void updateRsVrDsk(RsVrDsk rsVrDsk) {
		sqlSession.update("ncis.sql.cmn.rsVrDsk.updateRsVrDsk", rsVrDsk);
	}

	/**
	 * 가상디스크 삭제
	 * @param rsVrDsk
	 */
	public void deleteRsVrDsk(RsVrDsk rsVrDsk) {
		sqlSession.update("ncis.sql.cmn.rsVrDsk.deleteRsVrDsk", rsVrDsk);
	}

}
